package com.snapdeal.dis.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.stereotype.Component;

import com.snapdeal.sacs.base.sro.v2.ResourcePermissionSRO;
import com.snapdeal.sacs.base.sro.v2.UserSRO;
import com.snapdeal.sacs.client.sso.authentication.SSOSamlAuthenticationProvider;

@Component
public class CustomAuthenticationProvider extends SSOSamlAuthenticationProvider{
	
	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		SAMLCredential credential =null;
		UserSRO user = null;
		
		try {
			 credential = generateCredential(auth);
			 user = getSSOUserSRO(credential);
			 
			 if (user.getResourcePermissions() != null) {
			 for (ResourcePermissionSRO resourceRole : user.getResourcePermissions()) {
			 if (resourceRole != null) {
				 authorities.add(new SACSGrantedAuthority(resourceRole.getName()));
			 }
			 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new UsernamePasswordAuthenticationToken(user, credential,authorities);
	}

}
