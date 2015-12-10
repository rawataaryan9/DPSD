/**
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.snapdeal.dis.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.dyuproject.protostuff.Tag;
import com.google.gson.Gson;
import com.snapdeal.base.model.common.ServiceResponse;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewResponse extends ServiceResponse {

    /**
     *
     */
    private static final long serialVersionUID = -8536046676649800864L;

    @Tag(5)
    private ResponseCode      responseCode;

    @Tag(6)
    private Long outputValue;

    public ViewResponse() {
        super();
        setResponseCode(ResponseCode.OK);
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
        setMessage(responseCode.message());
    }

    public Long getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(Long outputValue) {
        this.outputValue = outputValue;
    }

    @Override
    public String toString() {
        return "ViewResponse{" +
                "responseCode=" + responseCode +
                ", outputValue=" + outputValue +
                '}';
    }
}
