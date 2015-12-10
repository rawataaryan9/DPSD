package com.snapdeal.dis.web.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

public class SACSGrantedAuthority implements GrantedAuthority{
	public SACSGrantedAuthority(String name) {
		
		
	}

	/*@Override*/
	public String getAuthority() {
		return null;
	}
	
}
