package sample.ear.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

import org.apache.commons.lang3.StringUtils;

@Singleton
public class SingletonEjb {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.stripToEmpty(name);
    }

    @PostConstruct
    public void construct() {
        System.out.println("PreConstruct@Singleton");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PostDestroy@Singleton");
    }
}
