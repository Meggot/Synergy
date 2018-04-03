package models;

import javax.persistence.*;

@Entity
@Table(name="User_Audits")
public class UserAudit extends EntityObject{

    @Id
    @Column(name="pk_audit_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @JoinColumn(name="fk_account_id")
    private Account account;
    @Column(name="value")
    private String value;

    public UserAudit(final String value, final Account account) {
        this.value = value;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }
}
