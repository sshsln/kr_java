package services.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDBService {

    public String getOrgPassByLogin(String login) {
        String password = null;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "select o.\"password\" from organizer o where o.login = '" + login + "' ";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            resultSet.next();
            password = resultSet.getString("password");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return password;
    }

    public void createSession(String login, String session) {
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "INSERT INTO sessions (login, session)\n" +
                "VALUES ('" + login + "', '" + session + "')";
        if (dataBaseService.insert(sql)) {
            // логика на успех
        } else {
            // ошибка
        }

    }

    public void cleanSession(String login) {
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "delete from sessions s where s.login = '" + login + "'";
        dataBaseService.delete(sql);
    }

    public String getUserLoginBySession(String session) {
        String login = null;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "select s.login from sessions s where s.\"session\" = '" + session + "'";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            resultSet.next();
            login = resultSet.getString("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return login;
    }

    public String getOrgNameBySession(String session) {
        String org_name = null;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT o.org_name FROM sessions s JOIN organizer o ON s.login = o.login WHERE s.\"session\" = '" + session + "'";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            resultSet.next();
            org_name = resultSet.getString("org_name");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return org_name;
    }

}
