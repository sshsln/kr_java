package model;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

@Data
public class Organizer {
    private String login;
    private String org_name;
    private String password;

    public Organizer() {
    }

    public Organizer(HttpServletRequest request) {
        this.login = request.getParameter("login");
        this.org_name = request.getParameter("org_name");
        this.password = request.getParameter("password");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getOrg_name() {
        return org_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
