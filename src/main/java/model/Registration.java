package model;
import lombok.Data;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    public Integer getId_r() {
        return id_r;
    }

    public void setId_r(Integer id_r) {
        this.id_r = id_r;
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

    public String getReg_time() {
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }
}
