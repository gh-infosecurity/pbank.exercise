package ua.com.pb.biplane.testexercise.servlet;

import ua.com.pb.biplane.testexercise.bl.BuisnLog;
import ua.com.pb.biplane.testexercise.dto.ConfigDto;
import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.DataController;
import ua.com.pb.biplane.testexercise.util.Utils;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
@WebServlet(name = "filter", urlPatterns = "/filter")
public class InpunServletFilter extends HttpServlet {
    Logger logger = Logger.getLogger(InpunServletFilter.class.getName());
    DataController dataController;
    BuisnLog buisnLog;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "doGet");

        ServletOutputStream out = response.getOutputStream();
        out.write(Integer.parseInt(InpunServletFilter.class.getResource("*").toString()));

        request.getRequestDispatcher("/WEB-INF/html/index.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "doPost");
        InputDto dto = null;
        String xml;

        InputStream in = req.getInputStream();
        String chEncoding = req.getCharacterEncoding();
        int dataLength = new byte[req.getContentLength()].length;
        xml = Utils.getInputXML(in, chEncoding, dataLength);

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

        dto = Utils.doLoopFilter(dto);
        req.setAttribute("dto", dto);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
        dispatcher.forward(req, resp);
    }
}