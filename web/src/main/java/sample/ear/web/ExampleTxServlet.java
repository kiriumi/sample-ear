package sample.ear.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import sample.ear.ejb.StatelessEjb;

@WebServlet("/example-tx")
@Transactional
public class ExampleTxServlet extends HttpServlet {

    @EJB
    private StatelessEjb slEjb;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        try {
            slEjb.method();

        } catch (final Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("example");
    }
}
