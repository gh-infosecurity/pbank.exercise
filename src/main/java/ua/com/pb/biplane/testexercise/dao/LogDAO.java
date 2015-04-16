package ua.com.pb.biplane.testexercise.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.pb.biplane.testexercise.dto.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by artur on 15.04.15.
 */
public class LogDAO extends DAO {
    private Logger logger = LoggerFactory.getLogger(LogDAO.class);
    Statement stmt;


    public ArrayList<LogDto> readLogs() {
        Connection conn = getDBConnection();
        ArrayList<LogDto> logDtos = new ArrayList<>();

        try {
            stmt = getDBConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from LOGS;");

            while (rs.next()) {
                LogDto logDto = new LogDto();
                logDto.setId(Integer.valueOf(rs.getString("id")));
                logDto.setInputData(rs.getString("inputData"));
                logDto.setOperations(rs.getNString("operations"));
                logDto.setElements(Integer.valueOf(rs.getString("elements")));
                logDto.setStatus(rs.getString("status"));
                logDto.setResult(rs.getString("result"));

                logDtos.add(logDto);
            }
            rs.close();

            stmt.close();
            conn.commit();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        } finally {
            closeConnection(conn);
        }

        return logDtos;
    }

    public void createLog(UnitedDto unDto) {

        Connection conn = getDBConnection();
        InputDto inputDto = unDto.getInputDto();
        StateDto stateDto = unDto.getStDato();
        ConfigDto configDto = unDto.getConfDto();

        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String query = "INSERT INTO LOGS(INPUTDATA, operations, elements, status, result) VALUES("+"\'"+
                    + inputDto.getValues().length + "\',\'"
                    + configDto.getTypeOfOperations() + "\',"
                    + configDto.getNumberOfInputElements() + ",\'"
                    + stateDto.getStatus() + "\',\'"
                    + stateDto.getResult()+"\')";

            stmt.executeUpdate(query);

            stmt.close();
            conn.commit();

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

}
