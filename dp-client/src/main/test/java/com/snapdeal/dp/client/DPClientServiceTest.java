package com.snapdeal.dp.client;

import com.snapdeal.dis.model.GetAllExpressionsRequest;
import com.snapdeal.dis.model.GetAllExpressionsResponse;
import com.snapdeal.dis.service.IDPAdminClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by aman on 10/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DPClientServiceTest {

    @Autowired
    private IDPAdminClientService service;

    @Test
    public void validateExpressionService(){
        GetAllExpressionsRequest request = new GetAllExpressionsRequest();
        GetAllExpressionsResponse response = service.getAllExpressions(request);
        System.out.println(response.getListExpressionSRO().size());
        assertNotNull(response);
    }
}
