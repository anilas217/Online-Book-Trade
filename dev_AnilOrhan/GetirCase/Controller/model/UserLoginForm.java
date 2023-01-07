package dev_AnilOrhan.GetirCase.Controller.model;

public class UserLoginForm {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
