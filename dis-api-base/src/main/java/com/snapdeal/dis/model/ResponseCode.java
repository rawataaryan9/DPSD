/**
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.snapdeal.dis.model;


public enum ResponseCode {

    OK("Sucessfully published the event!", "OK"),
    ERROR("Error while processing event request", "ERROR");

    private  String message;
    private String code;

    private ResponseCode(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String message() {
        return message;
    }

    public String code() {
        return  code;
    }

}
