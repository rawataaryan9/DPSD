/**
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.snapdeal.dis.service;


import com.snapdeal.dis.model.ViewRequest;
import com.snapdeal.dis.model.ViewResponse;

public interface IDISAPIClientService {

    void setDISAPIWebServiceURL(String url);

    ViewResponse getSummarizedView(ViewRequest request);
}
