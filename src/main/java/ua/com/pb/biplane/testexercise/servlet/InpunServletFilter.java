package ua.com.pb.biplane.testexercise.servlet;

import ua.com.pb.biplane.testexercise.dto.InputDto;
import ua.com.pb.biplane.testexercise.input.fs.InputStore.ReadWeb;
import ua.com.pb.biplane.testexercise.util.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "doGet");
        request.getRequestDispatcher("/WEB-INF/html/index.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "doPost");
        ReadWeb readWeb = new ReadWeb();
        InputDto dto = null;
        String xml;

        try {
            byte[] xmlData = new byte[req.getContentLength()];

            InputStream sis = req.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(sis);

            bis.read(xmlData, 0, xmlData.length);

            if (req.getCharacterEncoding() != null) {
                xml = new String(xmlData, req.getCharacterEncoding());
            } else {
                xml = new String(xmlData);
            }

            dto = readWeb.readInputData(xml);
            dto = Utils.doLoopFilter(dto);

        } catch (IOException e) {
            logger.log(Level.ALL, e.getMessage());
        } catch (Exception e) {
            logger.log(Level.ALL, e.getMessage());
        }


        req.setAttribute("dto", dto);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
        dispatcher.forward(req, resp);
    }
}