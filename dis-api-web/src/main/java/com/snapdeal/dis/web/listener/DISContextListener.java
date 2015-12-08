/**
 *  Copyright 2014 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.snapdeal.dis.web.listener;

import com.snapdeal.dis.services.service.IStartupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class DISContextListener implements ServletContextListener {

    private static final Logger LOG = LoggerFactory.getLogger(DISContextListener.class);

    //ContextLoader contextLoader = new ConxtextLoader();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("Context initialized event called...");
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        // WebApplicationContext context = contextLoader.initWebApplicationContext(sce);
        IStartupService startupService = context.getBean(IStartupService.class);
        try {
            startupService.loadAllAtStartup();
        } catch (Exception e) {
            LOG.error("error while initializing application:", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // nothing needed here
    }

}
