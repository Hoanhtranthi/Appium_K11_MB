package src.test_data.models;

public class LoginCreds {

    private String username;
    private String password;

    public LoginCreds(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginCreds{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
