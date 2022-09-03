package sample.ear.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import sample.ear.ejb.ExampleEjb;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet {

    @EJB
    private ExampleEjb ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        ejb.setName("名前");

        final String name = StringUtils.stripToEmpty(ejb.getName());
        req.setAttribute("name", name);

        req.getRequestDispatcher("example.jsp").forward(req, res);

        // Web2にセッションで情報を渡す
        final HttpSession session = req.getSession(true);
        session.setAttribute("web2.name", name);
    }
}
