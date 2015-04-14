package ua.com.pb.biplane.testexercise.servlet;

import ua.com.pb.biplane.testexercise.dao.InitDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
@WebServlet(name = "change", urlPatterns = "/change")
public class ChangeBdServlet extends HttpServlet {
    Logger logger = Logger.getLogger(ChangeBdServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "doGet");
        request.getRequestDispatcher("/WEB-INF/jsp/changedbconfig.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "doPost");
        Properties prop = new Properties();
        String elements = req.getParameter("elements");
        String operations = req.getParameter("operations");

        if(elements!=null&&operations!=null){
            prop.setProperty("elements", elements);
            prop.setProperty("operations", operations);
        }

        InitDatabase.upadteDB(prop);
        resp.sendRedirect("/dbconflist");
    }
}