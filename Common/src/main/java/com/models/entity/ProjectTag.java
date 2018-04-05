package com.models.entity;

import javax.persistence.*;

@Entity
@Table(name="Project_Tags")
public class ProjectTag extends EntityObject{
    @Id
    @Column(name="pk_tag_id")
    @SequenceGenerator(name="project_tags_seq", sequenceName = "project_tags_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_tags_seq")
    private int id;
    @JoinColumn(name="fk_project_id")
    private Project project;
    @Column(name="value")
    private String value;

    public ProjectTag() {

    }

    public ProjectTag(final Project project, final String value) {
        super();
        this.project = project;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(final Project project) {
        this.project = project;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
