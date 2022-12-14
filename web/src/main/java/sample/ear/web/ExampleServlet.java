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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sample.ear.ejb.StatefulEjb;
import sample.ear.ejb.StatelessEjb;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet {

    @EJB
    private StatelessEjb slEjb;

    @EJB
    private StatefulEjb sfEjb;

    private final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        logger.info("{}の開始", "画面１");

        // ステートレスBeanとステートフルBeanの動作確認
        System.out.println(slEjb.getName());
        System.out.println(sfEjb.getName());

        if (StringUtils.isBlank(slEjb.getName())) {
            slEjb.setName("ステートレス１");
            sfEjb.setName("ステートフル１");
        }

        System.out.println(slEjb.getName());
        System.out.println(sfEjb.getName());

        // JSPの表示
        req.setAttribute("name", slEjb.getName());
        req.getRequestDispatcher("example.jsp").forward(req, res);

        // Web2にセッションで情報を渡す
        final HttpSession session = req.getSession(true);
        session.setAttribute("web2.name", slEjb.getName());

        logger.info("{}の終了", "画面１");
    }
}
