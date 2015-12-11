/**
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.snapdeal.dis.service;


import com.snapdeal.dis.model.GetAllExpressionsRequest;
import com.snapdeal.dis.model.GetAllExpressionsResponse;

public interface IDPAdminClientService {

    void setDISAPIWebServiceURL(String url);

    GetAllExpressionsResponse getAllExpressions(GetAllExpressionsRequest request);
}
