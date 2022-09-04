package sample.ear.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
@Startup
public class ExampleEjb {

    @Resource(lookup = "java:/jdbc/PostgresDS")
    private DataSource dataSource;

    public void method(int id, String name) throws Exception {

        final String sql = "INSERT INTO public.example_ejb ( id, name) VALUES (?,?)";

        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();

        } catch (final Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
