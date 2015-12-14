package com.snapdeal.dis.services.dao.aao;

import java.util.List;

import com.snapdeal.dis.services.dao.ExpressionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.snapdeal.dis.services.entity.ExpressionDO;

//Dao Interface implementation

@Repository("expressionDao")
public class ExpressionDaoImpl implements ExpressionDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExpressionDaoImpl.class);
	
	// Injecting hibernateTemplate dependency
	@Autowired
	private HibernateTemplate htemp;
	
	public HibernateTemplate getHtemp() {
		return htemp;
	}

	public void setHtemp(HibernateTemplate htemp) {
		this.htemp = htemp;
	}

	//Getting all the expression list from database.
	public List<ExpressionDO> getAllExpressions() {
		return htemp.find("select exp from ExpressionDO exp where exp.isDeleted = ?",false);
	}
	 
	//Getting the current number of expressions in the expression table.
	public int getExpressionsCount(){
		return DataAccessUtils.intResult(htemp.find("select count(*) from ExpressionDO"));
	}
	
	//Getting a particular expression by its reference id.
	public ExpressionDO getExpressionById(int id) {
		Object[] params = {false,id};
		List<ExpressionDO> exprDO = htemp.find("select exp from ExpressionDO exp where exp.isDeleted = ? and exp.id = ?",params);	
		if(exprDO.size()>0){
			return exprDO.get(0);
		}
		LOG.info("No expression present against this expression reference id");
		return null;
	}

	// Soft deletion of an expression by updating its field isDeleted as true.
	@Transactional
	public boolean deleteExpressionById(int id) {
		
		ExpressionDO exprDO = getExpressionById(id);
		if(exprDO==null){
			LOG.info("No such expression found against this Id to be updated!!");
			return false;
		}else if(exprDO.isDeleted()){
			LOG.info("No such expression found against this Id to be updated!!");
			return false;
		}
		exprDO.setDeleted(true);
		
		try{
			htemp.saveOrUpdate(exprDO);
			return true;
		}catch(RuntimeException e){
			LOG.error("updation of event failed",e);
			return false;
		}
	}

	public ExpressionDO getExpressionByName(String refName) {
		Object[] params = {false,refName};
		List<ExpressionDO> exprDO = htemp.find("select exp from ExpressionDO exp where exp.isDeleted = ? and exp.referenceName = ?",params);
		if(exprDO.size()>0){
			return exprDO.get(0);
		}
		LOG.info("No expression present against this expression reference id");
		return null;
	}

	@Override
	@Transactional
	public boolean insertExpression(String referenceName, String expression, String createdBy) {
		ExpressionDO exprDO = getExpressionByName(referenceName);
		if(exprDO!=null){
			LOG.info("expression already exists");
			return false;
		}
		ExpressionDO newExprDO = new ExpressionDO(referenceName,expression,false,createdBy);
		try{
			htemp.save(newExprDO);
			return true;
		} catch(RuntimeException e){
			LOG.error("insertion of expression failed",e);
			return false;
		}
	}

}
