package model;

import lombok.Data;

@Data
public class Registration {
    private Event event;
    private Visitor visitor;

    public Registration(Event event, Visitor visitor) {
        this.event = event;
        this.visitor = visitor;
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
