package com.snapdeal.dis.services.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.snapdeal.dis.convertor.ExpressionDOToSRO;
import com.snapdeal.dis.services.dao.ExpressionDao;
import com.snapdeal.dis.services.entity.ExpressionDO;
import com.snapdeal.dis.services.service.ExpressionService;
import com.snapdeal.dis.services.sro.ExpressionSRO;
import com.snapdeal.dis.services.util.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snapdeal.dis.convertor.ExpressionDOToSRO;
import com.snapdeal.dis.services.dao.ExpressionDao;
import com.snapdeal.dis.services.dao.aao.ExpressionDaoImpl;
import com.snapdeal.dis.services.entity.ExpressionDO;
import com.snapdeal.dis.services.util.Actions;
import com.snapdeal.dis.services.util.ExecutionMode;
import com.snapdeal.dis.services.service.ExpressionService;
import com.snapdeal.dis.services.sro.ExpressionSRO;

//Service Implementation 
@Service
public class ExpressionServiceImpl implements ExpressionService{
	
	//Injecting dependency expressionDao
	@Autowired
	@Qualifier(value="expressionDao")
	private ExpressionDao expressionDao;
	
	public ExpressionDao getExpressionDao() {
		return expressionDao;
	}
	
	public void setExpressionDao(ExpressionDao expressionDao) {
		this.expressionDao = expressionDao;
	}
	
	//Getting list of all expression.
	public List<ExpressionSRO> getAllExpressions(){
		
		List<ExpressionDO> expDO = expressionDao.getAllExpressions();
		
		List<ExpressionSRO> expSRO = null;
		if (expDO.size()>0){
			System.out.println(expDO.get(0).getExecutionMode()+" execution mode");
			expSRO = ExpressionDOToSRO.convertDOToSROList(expDO);
		}
		
		return expSRO;
	}
	
	//Getting expression by id
	public ExpressionSRO getExpressionByID(int id){
		
		ExpressionDO expDO = expressionDao.getExpressionById(id);
		if(expDO==null){
			return null;
		}
		else {
			ExpressionSRO expSRO = ExpressionDOToSRO.convertDOToSRO(expDO);
			return expSRO;
		}
	}
	
	// SOft deletion of an expression by updating its field isDeleted to true.
	//@Transactional
	public boolean deleteExpressionById(int id){
		ExpressionDO exprDO = expressionDao.getExpressionById(id);
		if(exprDO==null){
			return false;
		}
		return expressionDao.deleteExpressionById(id);
	}

	public ExpressionSRO getExpressionByName(String name) {
		String namespace = name.substring(0,name.lastIndexOf('.'));
		String refName = name.substring(name.lastIndexOf('.')+1,name.length());
		ExpressionDO exprDO  = expressionDao.getExpressionByName(namespace,refName);
		if(exprDO!=null){
			return ExpressionDOToSRO.convertDOToSRO(exprDO);
		}
		return null;
	}

	@Override
	public void executeActions(ExpressionSRO expSRO, String action) {

	}


	public List<String> getAllActions() {
		List<Actions> listactions = Arrays.asList(Actions.values());
		List<String> allActions = new ArrayList<String>();
		for(Actions ac:listactions){
			System.out.println(ac.getDescription()+" :st");
			allActions.add(ac.getDescription());
		}
		return allActions;
	}
}
