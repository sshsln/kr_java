package services.db;

import model.Event;
import model.Visitor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VisDBService {
    public List<Event> showVisEvents() {
        List<Event> events = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        String sql = "SELECT event.event_name, event.date, organizer.org_name, event.location FROM event INNER JOIN organizer ON event.organizer_n = organizer.login WHERE date > '" + formattedDateTime + "' ORDER BY date ASC";
        try (Statement statement = dataBaseService.getConnect().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Event event = new Event();
                event.setEvent_name(resultSet.getString("event_name"));
                event.setOrganizerName(resultSet.getString("org_name"));
                event.setDate(resultSet.getString("date"));
                event.setLocation(resultSet.getString("location"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public List<Event> showUpcomingVisEvents() {
        List<Event> events = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        String sql = "SELECT * FROM event WHERE date > '" + formattedDateTime + "' ORDER BY date ASC";
        try (Statement statement = dataBaseService.getConnect().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Event event = new Event();
                event.setId_e(resultSet.getInt("id_e"));
                event.setEvent_name(resultSet.getString("event_name"));
                event.setDate(resultSet.getString("date"));
                event.setLocation(resultSet.getString("location"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public boolean isUserExist(String email) {
        boolean userExist = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT * FROM visitor WHERE email = '" + email + "'";
        try (Statement statement = dataBaseService.getConnect().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                userExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userExist;
    }

    public Boolean editVisName(Visitor visitor) {
        Boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "UPDATE visitor SET visitor_name = '" + visitor.getVisitor_name() + "' WHERE email = '" + visitor.getEmail() + "'";
        if (dataBaseService.update(sql)) {
            isSuccess = true;
        } else {
        }
        return isSuccess;
    }

    public Boolean createVisitor(Visitor visitor) {
        Boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "INSERT INTO visitor (visitor_name, email)" +
                "VALUES ('" + visitor.getVisitor_name() + "','" + visitor.getEmail() + "')";
        if (dataBaseService.insert(sql)) {
            isSuccess = true;
        } else {
        }
        return isSuccess;
    }

    public Visitor getVisitorByEmail(String email) {
        Visitor visitor = null;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT * FROM visitor WHERE email = '" + email + "'";
        try (Statement statement = dataBaseService.getConnect().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                visitor = new Visitor();
                visitor.setId_v(resultSet.getInt("id_v"));
                visitor.setVisitor_name(resultSet.getString("visitor_name"));
                visitor.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitor;
    }

    public Boolean createRegistration(int eventId, int visitorId) {
        Boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        String sql = "INSERT INTO registration (event_n, visitor_n, reg_time) " +
                "VALUES (" + eventId + ", " + visitorId + ", '" + formattedDateTime + "')";
        if (dataBaseService.insert(sql)) {
            isSuccess = true;
        }
        return isSuccess;
    }

    public boolean isRegistrationExist(String email, int eventId) {
        boolean regExist = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT * FROM registration WHERE visitor_n IN (SELECT id_v FROM visitor WHERE email = '" + email + "') AND event_n = '" + eventId + "'";
        try (Statement statement = dataBaseService.getConnect().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                regExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regExist;
    }

    public Boolean cancelRegistration(String email, int eventId) {
        Boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "DELETE FROM registration WHERE visitor_n IN (SELECT id_v FROM visitor WHERE email = '" + email + "') AND event_n = '" + eventId + "'";
        if (dataBaseService.delete(sql)) {
            isSuccess = true;
        } else {
        }
        return isSuccess;
    }

}
