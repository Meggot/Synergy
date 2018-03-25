package sessions.models;

import models.Account;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class SessionContext {
    private Account account;
    private Date lastMessageRecieved;
    private List<String> trackingProjects;
    private InetAddress inetAddress;
    public SessionContext(Account account, Date lastMessageRecieved) {
        //this.inetAddress = inetAddress;
        this.setLastMessageRecieved(lastMessageRecieved);
        this.account = account;
    }

    public Date getLastMessageRecieved() {
        return lastMessageRecieved;
    }

    public void setLastMessageRecieved(Date lastMessageRecieved) {
        this.lastMessageRecieved = lastMessageRecieved;
    }

    public List<String> getTrackingProjects() {
        return trackingProjects;
    }

    public void setTrackingProjects(List<String> trackingProjects) {
        this.trackingProjects = trackingProjects;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
