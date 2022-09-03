package sample.ear.web2;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.ear.ejb.ExampleEjb;

@WebServlet("/example2")
public class Example2Servlet extends HttpServlet {

    @EJB
    private ExampleEjb ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.getRequestDispatcher("example2.jsp").forward(req, res);
    }
}
