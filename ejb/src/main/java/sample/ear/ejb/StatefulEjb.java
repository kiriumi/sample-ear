package sample.ear.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

import org.apache.commons.lang3.StringUtils;

@Stateful
public class StatefulEjb {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.stripToEmpty(name);
    }

    @PostConstruct
    public void construct() {
        System.out.println("PreConstruct@Stateful");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PostDestroy@Stateful");
    }

}
