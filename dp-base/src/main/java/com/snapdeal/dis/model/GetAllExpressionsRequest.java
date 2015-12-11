package com.snapdeal.dis.model;

import com.snapdeal.base.model.common.ServiceRequest;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by aman on 10/12/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllExpressionsRequest extends ServiceRequest {

    private static final long serialVersionUID = -5902760717328771823L;

    public GetAllExpressionsRequest(){
        super();
    }

    @Override
    public String toString() {
        return "GetAllExpressionsRequest{}";
    }
}
