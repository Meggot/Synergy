package sessions;

import models.Account;
import sessions.models.SessionContext;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class SessionsService {

    private Map<Integer, SessionContext> activeSessions;

    public SessionsService() {
        setActiveSessions(new HashMap<Integer, SessionContext>());
    }

    public Map<Integer, SessionContext> getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(Map<Integer, SessionContext> activeSessions) {
        this.activeSessions = activeSessions;
    }

    public boolean isUserCurrentlyLoggedIn(Integer userId) {
        return activeSessions.containsKey(userId);
    }

    public void loginUser(Account account) {
        activeSessions.put(account.getId(), new SessionContext(account, new Date()));
    }
}
