package com.snapdeal.dis.services.dao;

import java.util.List;

import com.snapdeal.dis.services.entity.ExpressionDO;

//Dao Interface for Expression Entity

public interface ExpressionDao {
	
	public List<ExpressionDO> getAllExpressions();
	public int getExpressionsCount();
	public ExpressionDO getExpressionById(int id);
	public boolean deleteExpressionById(int id);
	public ExpressionDO getExpressionByName(String refName);
	
}
