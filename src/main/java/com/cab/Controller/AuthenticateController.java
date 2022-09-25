package com.cab.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Config.JwtUtils;
import com.cab.Model.Admin;
import com.cab.Model.JwtRequest;
import com.cab.Model.JwtResponse;
import com.cab.Model.User;
import com.cab.ServiceImp.UserDetailsServiceImpl;


@RestController
@CrossOrigin(origins = "*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticateManager;

	@Autowired
	private UserDetailsServiceImpl userdetailsServiceImpl;

	@Autowired
	private JwtUtils jwtUtils;
	


   // for user
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {

			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}

		UserDetails userdetails = this.userdetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userdetails);
		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void authenticate(String username, String password) throws Exception {
		try {

			authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {
			throw new Exception("User Disabled " + e.getMessage());
		} catch (BadCredentialsException e) {
			throw new Exception("User Disabled " + e.getMessage());
		}
	}
	
	
	// Return the current User
	@GetMapping("/current")
	public User getCurrentUser(Principal principal) {
		
		return (User)this.userdetailsServiceImpl.loadUserByUsername(principal.getName());
	}
	
	
	
	
	
	
	// For Admin
	
	@PostMapping("/generate")
	public ResponseEntity<?> generateToken1(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {

			authenticate1(jwtRequest.getUsername(), jwtRequest.getPassword());

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}

		UserDetails userdetails = this.userdetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtUtils.generateToken1(userdetails);
		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void authenticate1(String username, String password) throws Exception {
		try {

			authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {
			throw new Exception("User Disabled " + e.getMessage());
		} catch (BadCredentialsException e) {
			throw new Exception("User Disabled " + e.getMessage());
		}
	}
	
	
	// Return the current User
	@GetMapping("/current-user")
	public Admin getCurrentAdmin(Principal principal) {
		
		return (Admin)this.userdetailsServiceImpl.loadUserByUsername(principal.getName());
	}


}
