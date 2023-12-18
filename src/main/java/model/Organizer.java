package model;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Data
public class Organizer {
    private String login;
    private String org_name;
    private String password;
    private List<Event> eventList;

    public Organizer() {
    }

    public Organizer(String login, String org_name, String password, List<Event> eventList) {
        this.login = login;
        this.org_name = org_name;
        this.password = password;
        this.eventList = eventList;
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

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
