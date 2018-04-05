package com.models.entity;

import javax.persistence.*;

@Entity
@Table(name="Authors")
public class Author extends EntityObject {

    @Id
    @Column(name="pk_author_id")
    @SequenceGenerator(name="authors_seq", sequenceName="authors_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_seq")
    private int id;
    @OneToOne
    @JoinColumn(name="fk_project_part_id")
    private ProjectPart projectPart;
    @OneToOne
    @JoinColumn(name="fk_account_id")
    private Account account;
    @Column(name="ownership_level")
    private int ownershiplevel;

    public Author(){

    }

    public Author(final ProjectPart projectPart, final Account account, final int ownershiplevel) {
        super();
        this.projectPart = projectPart;
        this.account = account;
        this.ownershiplevel = ownershiplevel;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public ProjectPart getProjectPart() {
        return projectPart;
    }

    public void setProjectPart(final ProjectPart projectPart) {
        this.projectPart = projectPart;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    public int getOwnershiplevel() {
        return ownershiplevel;
    }

    public void setOwnershiplevel(final int ownershiplevel) {
        this.ownershiplevel = ownershiplevel;
    }
}
