package com.example.springbootapimysql.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ModelAudit implements Serializable {
    
    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    @Column(nullable = false)
    private Date updated_at;
    
    // CONTROLLER

    public ModelAudit() { }
    
    // GETTERS AND SETTERS

    public Date getCreatedAt() {return createdAt;}
    public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}

    public Date getUpdated_at() {return updated_at;}
    public void setUpdated_at(Date updated_at) {this.updated_at = updated_at;}
    
}
