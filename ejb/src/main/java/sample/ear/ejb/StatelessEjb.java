package sample.ear.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;

@Stateless
public class StatelessEjb {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.stripToEmpty(name);
    }

    @PostConstruct
    public void construct() {
        System.out.println("PreConstruct@Stateless");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PostDestroy@Stateless");
    }

}
