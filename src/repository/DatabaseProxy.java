package repository;

import security.Authority;
import security.Credentials;

public class DatabaseProxy {
    private Database database;
    private Credentials credentials;
    
    public DatabaseProxy(Credentials credentials) {
        this.database = Database.getInstance();
        this.credentials = credentials;
    }
    
    public void query(String sql) {
        if (isAuthorized(sql)) {
            database.query(sql);
        } else {
            System.out.println("Unauthorized query: " + sql);
        }
    }
    
    /**
     * Checks if current user's {@link Credentials} allows him to perform all DML queries.
     * 
     * If user has {@link Authority#ADMIN} he will recieve full access,7
     * otherwise he is permitted to execute only SELECT query.
     * 
     * @param sql - query going to be executed
     * @return boolean flag which shows if user is permitted to execute query
     */
    private boolean isAuthorized(String sql) {
        if (credentials.getAuthority().equals(Authority.ADMIN)) {
            return true;
        }
        return sql.trim().toLowerCase().startsWith("select");
    }
}