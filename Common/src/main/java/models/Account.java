package models;

import java.util.Date;

public class Account {

    private String username;
    private Long id;
    private int pwdId;
    private String email;
    private Date creationDate;
    private boolean deleted;
    private int oca;

    public Account(final Long accountId, final String accountUsername, final String accountEmail) {
        this.id = accountId;
        this.username = accountUsername;
        this.email = accountEmail;
        this.creationDate = new Date();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getPwdId() {
        return this.pwdId;
    }

    public void setPwdId(final int pwdId) {
        this.pwdId = pwdId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
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
