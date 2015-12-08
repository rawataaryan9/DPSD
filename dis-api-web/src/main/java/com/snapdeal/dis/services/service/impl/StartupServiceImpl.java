/**
 *  Copyright 2014 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.snapdeal.dis.services.service.impl;

import com.snapdeal.base.cache.CacheManager;

import com.snapdeal.dis.services.cache.ExpressionCache;
import com.snapdeal.dis.services.service.IStartupService;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class StartupServiceImpl implements IStartupService {

    private static final Logger LOG = LoggerFactory.getLogger(StartupServiceImpl.class);

    private String EXPRESSIONS_FILE = "expressions/expressions.txt";

    @Override
    public void loadAllAtStartup() {
        loadCache();
    }

    private void loadCache() {
        loadExpressionCache();
    }

    private void loadExpressionCache() {
        ExpressionCache expressionCache = new ExpressionCache();

        try {
            List<String> strExpressions = IOUtils.readLines(FileUtils.class.getClassLoader()
                    .getResourceAsStream(EXPRESSIONS_FILE), Charsets.UTF_8);
            for(String strExpression : strExpressions){
                String[] tempArr = strExpression.split(":", 3);
                Integer id = Integer.valueOf(tempArr[0]);
                String expressionName = tempArr[1];
                expressionCache.loadExpression(expressionName, id);
            }
        } catch (Exception e) {
            LOG.error("Error Occurred while parsing expressions file");
            e.printStackTrace();
        }
        CacheManager.getInstance().setCache(expressionCache);
    }



}
