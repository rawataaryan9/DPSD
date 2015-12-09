package com.snapdeal.dis.services.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.snapdeal.dis.services.sro.ExpressionSRO;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

//Entity Expression

@Entity
@Table( name = "expression") 
public class ExpressionDO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	@Column(name = "reference_name",nullable = false)
	private String referenceName;

	@Column(name = "expression",nullable = false)
	private String expression;
	
	@Column(name = "is_deleted",nullable = false)
	private boolean isDeleted;
	
	@Column(name = "created_by",nullable = false)
	private String createdBy;
	
	@Column(name = "created_time",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Generated(GenerationTime.INSERT)
	private Date createdTime;
	
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
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public ExpressionDO(){
		super();
	}
	public ExpressionDO(String referenceName,
			String expression, boolean isDeleted, String createdBy) {
		super();
		this.referenceName = referenceName;
		this.expression = expression;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
	}

	public ExpressionSRO getExpressionSRO(){
		Date createdDate = this.getCreatedTime();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String createdDateStr = format.format(createdDate);
		ExpressionSRO expSRO = new ExpressionSRO(this.getId(), this.getReferenceName(), this.getExpression(),  this.isDeleted(), this.getCreatedBy(), createdDateStr);
		return expSRO;
	}
	
}
