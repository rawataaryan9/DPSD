package com.snapdeal.dis.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.snapdeal.dis.model.ExpressionSRO;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snapdeal.dis.services.service.ExpressionService;

/*
 * Controller for Handling Servlet Request*/
@Controller
public class ExpressionController {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(ExpressionController.class);


    private ExpressionService expressionService;

	public ExpressionService getExpressionService() {
		return expressionService;
	}

	/* Setting expressionService Dependency */
	@Autowired
	public void setExpressionService(ExpressionService expressionService) {
		this.expressionService = expressionService;
	}

	/* Method for getting all expressions */
	@RequestMapping(value = "/allexpressions",method = RequestMethod.GET)
	@ResponseBody
	public List<ExpressionSRO> getAllExpressions(){
		return expressionService.getAllExpressions();
	}

	/* Method for getting expressionById */
	@RequestMapping(value = "/getExpressionById",method = RequestMethod.GET)
	@ResponseBody
	public ExpressionSRO getExpressionById(@RequestParam(value= "expressionId") int id){
		return expressionService.getExpressionByID(id);
	}
	
	/*Method for getting expression By Name */
	@RequestMapping(value = "/getExpressionByName",method=RequestMethod.GET)
	@ResponseBody
	public ExpressionSRO getExpressionByName(@RequestParam(value = "expressionName") String name){
		return expressionService.getExpressionByName(name);
	}

    @RequestMapping(value = "/handleActions",method=RequestMethod.POST)
    @ResponseBody
    public boolean handleAction(@RequestParam(value="expressionId") int id,
                                @RequestParam(value="name") String name,
                                @RequestParam(value="expression") String expression,
                                @RequestParam(value="action") String action){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> exp = null;
        try {
            exp = mapper.readValue(expression,Map.class);
        } catch (IOException e) {
            LOG.info("Invalid expression returned from the database");
        }

        expressionService.executeActions(new ExpressionSRO(id,name,exp),action);

        return true;
    }
	
	@RequestMapping(value = "/getAllActions",method=RequestMethod.GET)
	@ResponseBody
	public List<String> getActions(){
		return expressionService.getAllActions();
	}
	
	@RequestMapping(value = "/deleteExpressionById",method=RequestMethod.GET)
	@ResponseBody
	public boolean deleteExpressionById(@RequestParam("id") int id){
		return expressionService.deleteExpressionById(id);
	}
	
}

