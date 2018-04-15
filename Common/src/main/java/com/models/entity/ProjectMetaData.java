package com.models.entity;


import javax.persistence.*;

@Entity
@Table(name="Project_Meta_Data")
public class ProjectMetaData extends EntityObject {

    @Id
    @SequenceGenerator(name="project_meta_data_seq", sequenceName = "project_meta_data_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "project_meta_data_seq")
    @Column(name="pk_project_meta_data_id")
    private int id;

    @Column(name="fk_project_id")
    private int projectId;

    @Column(name="upvotes")
    private int numUpvotes;

    @Column(name="downvotes")
    private int numDownvotes;

    @Column(name="favourites")
    private int numFavourites;

    @Column(name="shares")
    private int numShares;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getNumUpvotes() {
        return numUpvotes;
    }

    public void setNumUpvotes(int numUpvotes) {
        this.numUpvotes = numUpvotes;
    }

    public int getNumDownvotes() {
        return numDownvotes;
    }

    public void setNumDownvotes(int numDownvotes) {
        this.numDownvotes = numDownvotes;
    }

    public int getNumFavourites() {
        return numFavourites;
    }

    public void setNumFavourites(int numFavourites) {
        this.numFavourites = numFavourites;
    }

    public int getNumShares() {
        return numShares;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }
}
