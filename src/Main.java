import repository.DatabaseProxy;
import security.AdminCreds;
import security.UserCreds;

public class Main {

    private DatabaseProxy proxy;

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        userTest();
        adminTest();
    }

    public void userTest() {
        proxy = new DatabaseProxy(new UserCreds());

        proxy.query("SELECT * FROM users");
        proxy.query("UPDATE users SET active = 1");
    }

    public void adminTest() {
        proxy = new DatabaseProxy(new AdminCreds());

        proxy.query("SELECT * FROM users");
        proxy.query("UPDATE users SET active = 1");
    }
}
