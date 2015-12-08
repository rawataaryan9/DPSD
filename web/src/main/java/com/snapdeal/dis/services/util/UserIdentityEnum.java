package com.snapdeal.dis.services.util;

public enum UserIdentityEnum {

	USER_ID_EMAIL("E");

	private String prefix;

	UserIdentityEnum(String prefix) {
		this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}

}
