package model;

import lombok.Data;

@Data
public class Visitor {
    private Integer id_v;
    private String visitor_name;
    private String email;

    public Visitor() {
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
}
