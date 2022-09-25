package com.cab.Config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cab.ServiceImp.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtUtils jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.print(requestTokenHeader);
		String username = null;
		String jwtToken = null;

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
			} catch (ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("Token is Expired");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error");
			}

		}else {
			System.out.println("Invalid token number");
		}
		
		if(username!=null  && SecurityContextHolder.getContext().getAuthentication()==null) {
			final UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(username);
			
			System.out.println(userDetails);
			
			if(this.jwtUtil.validateToken(jwtToken, userDetails)) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
			    
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}else {
			System.out.println("Token is not valid");
		}
		filterChain.doFilter(request, response);

	}

}
