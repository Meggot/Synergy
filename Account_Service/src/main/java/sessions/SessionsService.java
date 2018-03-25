package sessions;

import models.Account;
import sessions.models.SessionContext;

import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class SessionsService {

    private Map<Long, SessionContext> activeSessions;

    public SessionsService() {
        setActiveSessions(new HashMap<Long, SessionContext>());
    }

    public Map<Long, SessionContext> getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(Map<Long, SessionContext> activeSessions) {
        this.activeSessions = activeSessions;
    }

    public boolean isUserCurrentlyLoggedIn(Long userId) {
        return activeSessions.containsKey(userId);
    }

    public void loginUser(Account account) {
        activeSessions.put(account.getId(), new SessionContext(account, new Date()));
    }
}
