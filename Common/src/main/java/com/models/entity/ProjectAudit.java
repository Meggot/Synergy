package com.models.entity;

import javax.persistence.*;

@Entity
@Table(name="Project_Audits")
public class ProjectAudit extends EntityObject{

    @Id
    @Column(name="pk_project_audit_id")
    @SequenceGenerator(name="project_audits_seq", sequenceName = "project_audits_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_audits_seq")
    private int id;
    @OneToOne
    @JoinColumn(name="fk_project_id")
    private Project project;
    @Column(name="value")
    private String value;

    public ProjectAudit() {

    }

    public ProjectAudit(final Project project, final String value) {
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
