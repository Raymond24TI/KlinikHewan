package model;

public class User extends AbstractUser {

    public User(int id, String username, String password, String role) {
        super(id, username, password, role);
    }

    @Override
    public String getInfo() {
        return "User: " + username + " (" + role + ")";
    }
}
