package com.snapdeal.dis.services.entity;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.snapdeal.dis.model.ExpressionSRO;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.slf4j.Logger;

//Entity Expression

@Entity
@Table( name = "expression")
public class ExpressionDO {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(ExpressionDO.class);

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
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> exp = null;
        try {
            exp = mapper.readValue(expression,Map.class);
        } catch (IOException e) {
            LOG.info("Invalid expression returned from the database");
        }
        return new ExpressionSRO(id, referenceName, exp,  isDeleted, createdBy, createdDateStr);

    }

}
