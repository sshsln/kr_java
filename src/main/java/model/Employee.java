package model;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class Employee {

    private String fio;
    private String login;
    private String password;
    private List<Project> projects;
    private List<Task> tasks;
    private List<WorkLog> workLogList;

    public Employee() {
    }

    public Employee(String fio, String login, String password, List<Project> projects, List<Task> tasks, List<WorkLog> workLogList) {
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.projects = projects;
        this.tasks = tasks;
        this.workLogList = workLogList;
    }

    public Employee(HttpServletRequest req) {
        this.login = req.getParameter("login");
        this.password = req.getParameter("password");
        this.fio = req.getParameter("fio");
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<WorkLog> getWorkLogList() {
        return workLogList;
    }

    public void setWorkLogList(List<WorkLog> workLogList) {
        this.workLogList = workLogList;
    }
}
