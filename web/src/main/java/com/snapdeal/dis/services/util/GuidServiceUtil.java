package com.snapdeal.dis.services.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GuidServiceUtil {

	private static final Logger LOG = LoggerFactory.getLogger(GuidServiceUtil.class);

	public static String getEmailAssociatedKey(String email) {
		String prefix = UserIdentityEnum.USER_ID_EMAIL.getPrefix();
		return prefix + "_" + email;
	}

}
