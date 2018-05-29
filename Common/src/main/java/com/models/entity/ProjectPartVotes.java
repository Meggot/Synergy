package com.models.entity;


import javax.persistence.*;

@Entity
@Table(name="Project_Part_Votes")
public class ProjectPartVotes {

    @Id
    @SequenceGenerator(name="project_part_votes_seq", sequenceName = "project_part_votes_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "project_part_votes_seq")
    @Column(name="pk_project_part_votes_id")
    private int id;

    @OneToOne
    @JoinColumn(name="fk_project_part_id")
    private ProjectPart projectPart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProjectPart getProjectPart() {
        return this.projectPart;
    }

    public void setProjectPart(ProjectPart projectPart) {
        this.projectPart = projectPart;
    }
}
