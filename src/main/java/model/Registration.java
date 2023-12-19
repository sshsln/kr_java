package model;

import lombok.Data;

@Data
public class Registration {
    private Integer id_r;
    private Event event;
    private Visitor visitor;
    private String reg_time;

    public Registration(Integer id_r, Event event, Visitor visitor, String reg_time) {
        this.id_r = id_r;
        this.event = event;
        this.visitor = visitor;
        this.reg_time = reg_time;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
