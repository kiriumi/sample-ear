package sample.ear.web2;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import sample.ear.ejb.StatefulEjb;
import sample.ear.ejb.StatelessEjb;

@WebServlet("/example2")
public class Example2Servlet extends HttpServlet {

    @EJB
    private StatelessEjb slEjb;

    @EJB
    private StatefulEjb sfEjb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        System.out.println(slEjb.getName());
        System.out.println(sfEjb.getName());

        if (StringUtils.isBlank(sfEjb.getName())) {
            sfEjb.setName("ステートフル２");
        }

        System.out.println(slEjb.getName());
        System.out.println(sfEjb.getName());

        req.getRequestDispatcher("example2.jsp").forward(req, res);
    }
}
