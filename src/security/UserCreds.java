package security;

public class UserCreds implements Credentials {

    public Authority getAuthority() {
        return Authority.USER;
    }
}
