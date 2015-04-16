package ua.com.pb.biplane.testexercise.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Properties;


/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class ConfigDAO extends DAO {
    private Logger logger = LoggerFactory.getLogger(ConfigDAO.class);

    public void upadteConfig(Properties prop) {
        Connection conn = getDBConnection();
        Statement stmt;

        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String query = "UPDATE CONFIG SET operations=\'"
                    + prop.getProperty("operations") + "\'"
                    + ", elements=" + prop.getProperty("elements")
                    + " where id=1";
            logger.info(query);
            stmt.execute(query);

            stmt.close();
            conn.commit();

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public Properties readConfig() {
        Properties prop = new Properties();
        Connection conn = getDBConnection();
        Statement stmt;

        try {
            stmt = getDBConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from CONFIG;");
            while (rs.next()) {
                prop.setProperty("elements", rs.getString("elements"));
                prop.setProperty("operations", rs.getString("operations"));
            }

            rs.close();
            stmt.close();
            conn.commit();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        } finally {
            closeConnection(conn);
        }

        return prop;
    }
}