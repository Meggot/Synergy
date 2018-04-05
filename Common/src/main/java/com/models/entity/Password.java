package com.models.entity;

import javax.persistence.*;

/**
 * Created by bradleyw on 25/03/2018.
 */
@Entity
@Table(name="Passwords")
public class Password extends EntityObject{
    @Id
    @Column(name = "pk_pwd_id")
    @SequenceGenerator(name = "passwords_seq", sequenceName = "passwords_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="passwords_seq")
    private int id;
    @Column(name="salt")
    private String salt;
    @Column(name="hash_value")
    private String hashValue;

    public Password() {

    }

    public Password(final String salt, final String hashValue) {
        super();
        this.salt = salt;
        this.hashValue = hashValue;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(final String salt) {
        this.salt = salt;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(final String hashValue) {
        this.hashValue = hashValue;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Password password = (Password) o;

        if (id != password.id) return false;
        if (salt != null ? !salt.equals(password.salt) : password.salt != null) return false;
        return hashValue != null ? hashValue.equals(password.hashValue) : password.hashValue == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (hashValue != null ? hashValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Password{" +
                "id=" + id +
                ", salt='" + salt + '\'' +
                ", hashValue='" + hashValue + '\'' +
                '}';
    }
}
