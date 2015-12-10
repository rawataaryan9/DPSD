package com.snapdeal.dp.web;

import com.snapdeal.dis.services.service.ExpressionService;
import com.snapdeal.dis.model.ExpressionSRO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by aman on 9/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration(locations = { "/spring/beanshib.xml","/spring/spring-servlet.xml" })
public class ExpressionServiceTest {

    @Autowired
    private ExpressionService expressionService;

    @Test
    public void validateExpressionService(){
        List<ExpressionSRO> expressionSROList = expressionService.getAllExpressions();
        if(expressionSROList.size()>0){
            System.out.println("working fine: "+expressionSROList.get(0).getReferenceName()+", "+expressionSROList.get(0).getCreatedTime());
        }
        else{
            System.out.println("error");
        }
        assertNotNull(expressionSROList);
    }
}
