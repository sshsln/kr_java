package model;
import lombok.Data;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Data
public class Visitor {
    private Integer id_v;
    private String visitor_name;
    private String email;
    private List<Registration> registrationList;

    public Visitor() { }

    public Visitor(Integer id_v, String visitor_name, String email, List<Registration> registrationList) {
        this.id_v = id_v;
        this.visitor_name = visitor_name;
        this.email = email;
        this.registrationList = registrationList;
    }

    public Integer getId_v() {
        return id_v;
    }

    public void setId_v(Integer id_v) {
        this.id_v = id_v;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }
}
