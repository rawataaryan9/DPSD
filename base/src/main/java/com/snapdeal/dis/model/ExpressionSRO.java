package com.snapdeal.dis.model;

import java.util.Map;

public class ExpressionSRO {
	private int id;
	private String referenceName;
	private Map<String, Object> expression;
	private boolean isDeleted;
	private String createdBy;
	private String createdTime;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public Map<String, Object> getExpression() {
		return expression;
	}

	public void setExpression(Map<String, Object> expression) {
		this.expression = expression;
	}

	public ExpressionSRO(int id, String referenceName,
						 Map<String, Object> expression) {
		super();
		this.id = id;
		this.referenceName = referenceName;
		this.expression = expression;
		
	}

	public ExpressionSRO(int id, String referenceName, Map<String, Object> expression,
						 boolean isDeleted, String createdBy, String createdTime) {
		super();
		this.id = id;
		this.referenceName = referenceName;
		this.expression = expression;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	

}
