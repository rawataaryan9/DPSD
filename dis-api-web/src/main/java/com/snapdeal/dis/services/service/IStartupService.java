/**
 *  Copyright 2014 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.snapdeal.dis.services.service;

/**
 * Startup service for the logger application to load the configuration and json schemas
 *
 */
public interface IStartupService {

    /**
     * Master method to be called
     */
    void loadAllAtStartup();

}
