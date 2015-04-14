package ua.com.pb.biplane.testexercise.servlet;

import ua.com.pb.biplane.testexercise.bl.BuisnLog;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.DataController;
import ua.com.pb.biplane.testexercise.util.Utils;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.ref.SoftReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
@WebServlet(name = "input", urlPatterns = "/input")
public class InpunServlet extends HttpServlet {
    Logger logger = Logger.getLogger(InpunServlet.class.getName());
    DataController dataController;
    BuisnLog buisnLog;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "doGet");
        request.getRequestDispatcher("/WEB-INF/html/index.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "doPost");
        InputDto dto = null;


        InputStream in = req.getInputStream();
        String chEncoding = req.getCharacterEncoding();
        int dataLength = new byte[req.getContentLength()].length;

        String xml = Utils.getInputXML(in, chEncoding, dataLength);
        String [] obj = {xml};
        dataController = new DataController(obj);

       try {
            ConfigDto confDto = dataController.getProperties();
            buisnLog = new BuisnLog(dataController);
            dto = dataController.getInputData(confDto);
            buisnLog.doOperation();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }


        req.setAttribute("dto", dto);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
        dispatcher.forward(req, resp);
    }
}