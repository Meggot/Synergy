package com.models.entity;

import javax.persistence.*;

@Entity
@Table(name="Projects")
public class Project extends EntityObject{

    @Id
    @SequenceGenerator(name="projects_seq", sequenceName = "projects_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_seq")
    @Column(name="pk_project_id")
    private int id;
    @OneToOne
    @JoinColumn(name="fk_owner_id")
    private Account owner;

    @Column(name="title")
    private String title;

    @Column(name="synopsis")
    private String synopsis;

    @OneToOne()
    @JoinColumn(name = "fk_project_id")
    private ProjectMetaData metaData;

    public Project() {
        this.metaData = new ProjectMetaData();
    }

    public Project(final String projectTitle, final String projectSynopsis, final Account owner) {
        super();
        this.title = projectTitle;
        this.synopsis = projectSynopsis;
        this.owner = owner;
        this.metaData = new ProjectMetaData();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
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

    public Account getOwner() {
        return owner;
    }

    public void setOwner(final Account owner) {
        this.owner = owner;
    }

    public ProjectMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(ProjectMetaData metaData) {
        this.metaData = metaData;
    }
}
