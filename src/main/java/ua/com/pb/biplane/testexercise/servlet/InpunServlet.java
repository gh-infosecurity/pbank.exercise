package ua.com.pb.biplane.testexercise.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.bl.BuisnLog;
import ua.com.pb.biplane.testexercise.dto.UnitedDto;
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

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
@WebServlet(name = "input", urlPatterns = "/input")
public class InpunServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(InpunServlet.class);
    DataController dataController;
    BuisnLog buisnLog;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("doGet");
        request.getRequestDispatcher("/WEB-INF/html/index.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");
        UnitedDto unDto = null;


        InputStream in = req.getInputStream();
        String chEncoding = req.getCharacterEncoding();
        int dataLength = new byte[req.getContentLength()].length;

        String xml = Utils.getInputXML(in, chEncoding, dataLength);
        String[] obj = {xml};
        dataController = new DataController(obj);

        try {
            buisnLog = new BuisnLog(dataController);
            unDto = buisnLog.doOperation();
            buisnLog.logOperation(unDto);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }

        req.setAttribute("dto", unDto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
        dispatcher.forward(req, resp);
    }
}