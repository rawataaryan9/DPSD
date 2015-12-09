package com.snapdeal.dis.services.dao;

import java.util.List;

import com.snapdeal.dis.services.entity.Expression;
import com.snapdeal.dis.services.entity.ExpressionDO;
import com.snapdeal.dis.services.dao.ExpressionDao;
import com.snapdeal.dis.services.util.ExecutionMode;

//Dao Interface for Expression Entity

public interface ExpressionDao {
	
	public List<ExpressionDO> getAllExpressions();
	public int getExpressionsCount();
	public ExpressionDO getExpressionById(int id);
	public boolean insertExpression(String referenceName, String namespace, String expression, String createdBy, ExecutionMode executionMode);
	public boolean deleteExpressionById(int id);
	public ExpressionDO getExpressionByName(String namespace, String refName);
	
}
