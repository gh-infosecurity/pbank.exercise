package ua.com.pb.biplane.testexercise.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by artur on 15.04.15.
 */
public class DAO {
    private Logger logger = LoggerFactory.getLogger(DAO.class);
    private String DB_DRIVER = "org.hsqldb.jdbcDriver";

    protected Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        }
        try {
            conn = DriverManager.getConnection("jdbc:hsqldb:file:/tmp/dbname:SA");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    protected void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    public void init() {
        Connection dbConnection = getDBConnection();
        Statement stmt;

        try {
            dbConnection.setAutoCommit(false);
            stmt = dbConnection.createStatement();

            stmt.execute("DROP TABLE IF EXISTS CONFIG");
            stmt.execute("DROP TABLE IF EXISTS LOGS");
            stmt.execute("CREATE TABLE CONFIG(id int primary key, operations VARCHAR(50), elements int)");
            stmt.execute("CREATE TABLE LOGS(ID INTEGER IDENTITY, INPUTDATA VARCHAR(255), operations VARCHAR(50), elements INT, status VARCHAR (50), result VARCHAR(255))");
            stmt.execute("INSERT INTO CONFIG(id, operations, elements) VALUES(1, 'SUM_STR', 1)");

            stmt.close();
            dbConnection.commit();

        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        } finally {
            closeConnection(dbConnection);
        }
    }

}
