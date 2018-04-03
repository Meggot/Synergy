package models;

import javax.persistence.*;

/**
 * Created by bradleyw on 25/03/2018.
 */
@Entity
@Table(name="Passwords")
public class Password extends EntityObject{
    @Id
    @Column(name = "pk_pwd_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="salt")
    private String salt;
    @Column(name="hash_value")
    private String hashValue;

    public Password(final String salt, final String hashValue) {
        this.salt = salt;
        this.hashValue = hashValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
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

        if (id != null ? !id.equals(password.id) : password.id != null) return false;
        if (salt != null ? !salt.equals(password.salt) : password.salt != null) return false;
        return hashValue != null ? hashValue.equals(password.hashValue) : password.hashValue == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (hashValue != null ? hashValue.hashCode() : 0);
        return result;
    }
}
