package sample.ear.ejb;

import java.time.ZonedDateTime;

import javax.ejb.Stateless;

@Stateless
public class ExampleEjb {

    private int id;

    private String name;

    private ZonedDateTime birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

}
