package ua.com.pb.biplane.testexercise.servlet;

import ua.com.pb.biplane.testexercise.bl.BuisnLog;
import ua.com.pb.biplane.testexercise.dto.LogDto;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
@WebServlet(name = "history", urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<LogDto> logs;

        BuisnLog buisnLog = new BuisnLog();
        logs = buisnLog.getLogOperation();

        req.setAttribute("logs", logs);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/page.jsp");
        rd.forward(req, resp);
    }


}