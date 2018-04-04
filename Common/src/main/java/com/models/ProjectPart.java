package com.models;

import javax.persistence.*;

@Entity
@Table(name="Project_Parts")
public class ProjectPart extends EntityObject{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="pk_project_part_id")
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_project_id")
    private Project project;
    @Column(name="part_position")
    private Long position;
    @Column(name="body")
    private String body;

    public ProjectPart() {

    }

    public ProjectPart(final Project project, final Account author, final Long position, final String body) {
        super();
        this.project = project;
        this.position = position;
        this.body = body;
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


    public Long getPosition() {
        return position;
    }

    public void setPosition(final Long position) {
        this.position = position;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

}
