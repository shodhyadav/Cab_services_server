package com.cab.Model;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class Authority implements GrantedAuthority {

	private String authority;

	public Authority(String authority) {

		this.authority = authority;
	}

	public String getAuthority() {

		return this.authority;

	}

}
