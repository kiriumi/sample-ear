package sample.ear.ejb;

import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

@Stateless
public class ExampleEjb {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void method() {
        StringUtils.isBlank("");
    }

}
