package sample.ear.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.ear.ejb.ExampleEjb;

@WebServlet("/example-tx")
public class ExampleTxServlet extends HttpServlet {

    @EJB
    private ExampleEjb ejb;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        try {
            final String id = req.getParameter("id");
            final String name = req.getParameter("name");

            ejb.method(Integer.parseInt(id), name);

        } catch (final Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("example");
    }
}
