package services.db;
import model.Event;
import model.Organizer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrgDBService {

    public Boolean registrationOrg(Organizer organizer){
        Boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "INSERT INTO organizer (login, org_name, password)" +
                "VALUES ('"+organizer.getLogin()+"', '"+organizer.getOrg_name()+"','"+organizer.getPassword()+"')";
        if(dataBaseService.insert(sql)){
            isSuccess =true;
        } else {
        }
        return isSuccess;
    }

    public boolean isLoginUnique(String login) {
        boolean isUnique = true;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT login FROM organizer WHERE login = '" + login + "'";
        try (Statement statement = dataBaseService.getConnect().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                isUnique = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUnique;
    }

    public Boolean createEvent(Organizer organizer, Event event){
        Boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "INSERT INTO event (event_name, date, organizer_n, location)" +
                "VALUES ('"+event.getEvent_name()+"','"+event.getDate()+"','"+organizer.getLogin()+"','"+event.getLocation()+"')";
        if(dataBaseService.insert(sql)){
            isSuccess =true;
        } else {
        }
        return isSuccess;
    }

    public List<Event> showOrgEvents(Organizer organizer) {
        List<Event> events = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT event_name, date, location, vis_count FROM event WHERE organizer_n = '" + organizer.getLogin() + "' ORDER BY date ASC";
        try (Statement statement = dataBaseService.getConnect().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Event event = new Event();
                event.setEvent_name(resultSet.getString("event_name"));
                event.setDate(resultSet.getString("date"));
                event.setLocation(resultSet.getString("location"));
                event.setVis_count(resultSet.getInt("vis_count"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public List<Event> showUpcomingOrgEvents(Organizer organizer) {
        List<Event> events = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        String sql = "SELECT * FROM event WHERE organizer_n = '" + organizer.getLogin() + "' AND date > '"+formattedDateTime+"' ORDER BY date ASC";
        try (Statement statement = dataBaseService.getConnect().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Event event = new Event();
                event.setId_e(resultSet.getInt("id_e"));
                event.setEvent_name(resultSet.getString("event_name"));
                event.setDate(resultSet.getString("date"));
                event.setLocation(resultSet.getString("location"));
                event.setVis_count(resultSet.getInt("vis_count"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public Boolean editEvent(Organizer organizer, Event event){
        Boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "UPDATE event SET date = '"+event.getDate()+"', location = '"+event.getLocation()+"' WHERE id_e = '"+event.getId_e()+"' AND organizer_n = '"+organizer.getLogin()+"'";
        if(dataBaseService.update(sql)){
            isSuccess =true;
        } else {
        }
        return isSuccess;
    }

    public Boolean deleteEvent(Organizer organizer, Event event){
        Boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "DELETE FROM event WHERE id_e = '"+event.getId_e()+"' AND organizer_n = '"+organizer.getLogin()+"'";
        if(dataBaseService.delete(sql)){
            isSuccess =true;
        } else {
        }
        return isSuccess;
    }

}
