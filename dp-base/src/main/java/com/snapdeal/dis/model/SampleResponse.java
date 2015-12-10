package com.snapdeal.dis.model;

import com.dyuproject.protostuff.Tag;
import com.snapdeal.base.model.common.ServiceResponse;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by aman on 10/12/15.
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class SampleResponse extends ServiceResponse {

    private static final long serialVersionUID = -4270688164401220314L;

    @Tag(5)
    private ResponseCode      responseCode;

    @Tag(6)
    private List<ExpressionSRO> listExpressionSRO;

    public SampleResponse() {
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

    public List<ExpressionSRO> getListExpressionSRO() {
        return listExpressionSRO;
    }

    public void setListExpressionSRO(List<ExpressionSRO> listExpressionSRO) {
        this.listExpressionSRO = listExpressionSRO;
    }

    @Override
    public String toString() {
        return "SampleResponse{" +
                "responseCode=" + responseCode +
                ", listExpressionSRO=" + listExpressionSRO.size() +
                '}';
    }
}
