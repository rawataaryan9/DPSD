/**
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.snapdeal.dis.web.controller;

import com.snapdeal.base.cache.CacheManager;
import com.snapdeal.dis.model.ResponseCode;
import com.snapdeal.dis.model.ViewRequest;
import com.snapdeal.dis.model.ViewResponse;
import com.snapdeal.dis.services.cache.ExpressionCache;
import com.snapdeal.dis.services.dao.GuidDao;
import com.snapdeal.dis.services.dao.SummaryDao;
import com.snapdeal.dis.services.util.GuidServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/service/dis-api/")
public class SummarizedViewController {

    private static final Logger LOG = LoggerFactory.getLogger(SummarizedViewController.class);

    @Autowired
    @Qualifier("guidAao")
    private GuidDao guidDaoService;

    @Autowired
    @Qualifier("summaryAao")
    private SummaryDao summaryDaoService;


    @RequestMapping(value = "getSummarizedView", produces = "application/sd-service")
    @ResponseBody
    public ViewResponse getSummarizedView(@RequestBody ViewRequest request){
        ViewResponse response = new ViewResponse();
        LOG.info("Received request {}", request.toString());

        try {
            Integer expressionId = CacheManager.getInstance().getCache(ExpressionCache.class).getExpressionIdByName(request.getExpressionName());
            String GUID = guidDaoService.getGuid(GuidServiceUtil.getEmailAssociatedKey(request.getUserEmail()));
            Long output = summaryDaoService.get(GUID, expressionId.toString());
            if(output!=null)
                response.setOutputValue(output);
            else
                response.setResponseCode(ResponseCode.ERROR);
        } catch (Exception ex) {
            response.setResponseCode(ResponseCode.ERROR);
            ex.printStackTrace();
        }

        response.setProtocol(request.getResponseProtocol());
        return response;
    }

}
