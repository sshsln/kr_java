package model;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Data
public class Event {
    private Integer id_e;
    private String event_name;
    private String date;
    private Organizer organizer;
    private String organizerName;
    private String location;
    private Integer vis_count;
    private List<Registration> registrationList;

    public Event() {
    }

    public Event(Integer id_e, String event_name, String date, Organizer organizer, String location, Integer vis_count, List<Registration> registrationList) {
        this.id_e = id_e;
        this.event_name = event_name;
        this.date = date;
        this.organizer = organizer;
        this.location = location;
        this.vis_count = vis_count;
        this.registrationList = registrationList;
    }

    public Event(HttpServletRequest request) {
        this.event_name = request.getParameter("event_name");
        this.date = request.getParameter("date");
        this.location = request.getParameter("location");
    }


    public Integer getId_e() {
        return id_e;
    }

    public void setId_e(Integer id_e) {
        this.id_e = id_e;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getVis_count() {
        return vis_count;
    }

    public void setVis_count(Integer vis_count) {
        this.vis_count = vis_count;
    }
}
