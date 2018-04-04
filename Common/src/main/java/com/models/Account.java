package com.models;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Accounts")
public class Account extends EntityObject{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="pk_user_id")
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_pwd_id")
    private Password password;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="dob")
    private Date dateOfBirth;

    public Account() {

    }

    @PersistenceConstructor
    public Account(final String accountUsername, final String accountEmail, final Password accountPassword) {
        super();
        this.username = accountUsername;
        this.email = accountEmail;
        this.password = accountPassword;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }


    public Password getPassword() {
        return password;
    }

    public void setPassword(final Password password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Account account = (Account) o;

        if (!(id == account.id)) return false;
        if (!password.equals(account.password)) return false;
        if (!username.equals(account.username)) return false;
        if (!email.equals(account.email)) return false;
        return dateOfBirth != null ? dateOfBirth.equals(account.dateOfBirth) : account.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + password.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }
}
