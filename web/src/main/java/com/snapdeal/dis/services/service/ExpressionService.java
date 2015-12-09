package com.snapdeal.dis.services.service;

import java.util.List;

import com.snapdeal.dis.services.sro.ExpressionSRO;
import com.snapdeal.dis.services.util.ExecutionMode;
import com.snapdeal.dis.services.sro.ExpressionSRO;

//Service Interface for Expression
public interface ExpressionService {
	
	public List<ExpressionSRO> getAllExpressions();
	public ExpressionSRO getExpressionByID(int id);
	public boolean deleteExpressionById(int id);
	public ExpressionSRO getExpressionByName(String name);
	public void executeActions(ExpressionSRO expSRO, String action);
	public List<String> getAllActions();
}
