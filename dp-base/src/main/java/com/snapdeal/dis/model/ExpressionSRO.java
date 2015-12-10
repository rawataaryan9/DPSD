package com.snapdeal.dis.model;

public class ExpressionSRO {
	private int id;
	private String referenceName;
	private String expression;
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
	
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
		public ExpressionSRO() {
		super();
	}

	public ExpressionSRO(int id, String referenceName,
						 String expression) {
		super();
		this.id = id;
		this.referenceName = referenceName;
		this.expression = expression;
		
	}

	public ExpressionSRO(int id, String referenceName, String expression,
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
