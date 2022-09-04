package sample.ear.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

@Stateless
public class StatelessEjb {

    private DataSource dataSource;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.stripToEmpty(name);
    }

    public void method() throws Exception {

        final String sql = "INSERT INTO public.user_info ( id, password, email) VALUES (?,?,?)";

        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "hoge");
            ps.setString(2, "pass");
            ps.setString(3, "hoge@com");
            ps.executeUpdate();

        } catch (final Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @PostConstruct
    public void construct() throws NamingException {

        System.out.println("PreConstruct@Stateless");

        final Context ctx = new InitialContext();
        this.dataSource = (DataSource) ctx.lookup("java:/jdbc/PostgresDS");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PostDestroy@Stateless");
    }

}
