package com.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EntityObject implements Serializable {

    @Column(name="creation_date")
    @CreationTimestamp
    private Date creationDate;
    @Column(name="modified_date")
    @UpdateTimestamp
    private Date modifiedDate;
    @Column(name= "deleted")
    private boolean deleted;
    @Column(name="oca")
    private int oca;

    public EntityObject() {
        this.oca = 0;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }

    public int getOca() {
        return oca;
    }

    public void setOca(final int oca) {
        this.oca = oca;
    }

    @PostUpdate
    public void incrementOca() {
        this.oca = oca++;
    }
}
