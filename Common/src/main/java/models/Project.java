package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Projects")
public class Project extends EntityObject{

    private String name;
    private int id;
    private String synopsis;
    private Date creationDate;
    private Date modifiedDate;
    private boolean deleted;
    private int oca;

    public Project(final String projectName, final String projectSynopsis) {
        this.name = projectName;
        this.synopsis = projectSynopsis;
        this.creationDate = new Date();
        this.deleted = false;
        this.oca = 0;
    }


    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public void setSynopsis(final String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }

    public int getOca() {
        return this.oca;
    }

    public void setOca(final int oca) {
        this.oca = oca;
    }
}
