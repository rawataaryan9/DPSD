/**
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.snapdeal.dis.model;

import com.dyuproject.protostuff.Tag;
import com.snapdeal.base.model.common.ServiceRequest;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewRequest extends ServiceRequest {

    /**
     *
     */
    private static final long serialVersionUID = -1104652854994486487L;

    @Tag(5)
    String userEmail;

    @Tag(6)
    String expressionName;


    public ViewRequest() {
        super();
    }

    public ViewRequest(String userEmail, String expressionName) {
        this.userEmail = userEmail;
        this.expressionName = expressionName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getExpressionName() {
        return expressionName;
    }

    public void setExpressionName(String expressionName) {
        this.expressionName = expressionName;
    }


    @Override
    public String toString() {
        return "ViewRequest{" +
                "userEmail='" + userEmail + '\'' +
                ", expressionName='" + expressionName + '\'' +
                '}';
    }
}
