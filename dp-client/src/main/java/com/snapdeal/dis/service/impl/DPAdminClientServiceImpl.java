/**
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */  
package com.snapdeal.dis.service.impl;

import com.snapdeal.base.exception.TransportException;
import com.snapdeal.base.model.common.ServiceRequest;
import com.snapdeal.base.model.common.ServiceResponse;
import com.snapdeal.base.transport.service.ITransportService;
import com.snapdeal.dis.model.*;
import com.snapdeal.dis.service.IDPAdminClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("dpAdminClientService")
public class DPAdminClientServiceImpl implements IDPAdminClientService {

    @Autowired
    private ITransportService transportService;

    private String            webServiceUrl;
    
    private String            serviceUrl = new String("service/");

    public void setTransportService(ITransportService service) {
        this.transportService = service;
    }

    @PostConstruct
    public void init() {
        transportService.registerService("/"+ serviceUrl+"/", "dp-web");
    }
    
    private <T extends ServiceRequest> String getServiceURL(T request) {
        return new StringBuilder("http://localhost:8080/dp-web-1.0-SNAPSHOT/").append(serviceUrl).toString();
    }

    private <T extends ServiceResponse> T getErrorResponse(T response) {
        response.setSuccessful(false);
        response.setCode(ResponseCode.ERROR.code());
        response.setMessage(ResponseCode.ERROR.message());
        return response;
    }
    
    @Override
    public void setDISAPIWebServiceURL(String url) {
        this.webServiceUrl = url;
    }
    
    @Override
    public GetAllExpressionsResponse getAllExpressions(GetAllExpressionsRequest request) {
        GetAllExpressionsResponse response = new GetAllExpressionsResponse();
        String url = new StringBuilder(getServiceURL(request)).append("allexpressions").toString();
        try {
            response = (GetAllExpressionsResponse) transportService.executeRequest(url, request, null, GetAllExpressionsResponse.class);
        } catch (TransportException e) {
            response = getErrorResponse(response);
            response.setResponseCode(ResponseCode.ERROR);
        }   
        return response;
        
    }
}
