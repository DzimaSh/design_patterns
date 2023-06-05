package security;

public class AdminCreds implements Credentials {

    public Authority getAuthority() {
        return Authority.ADMIN;
    }
}
