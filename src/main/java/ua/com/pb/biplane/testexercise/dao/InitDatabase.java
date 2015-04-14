package ua.com.pb.biplane.testexercise.dao;

import ua.com.pb.biplane.testexercise.EmbedMe;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class InitDatabase {
    static Logger logger = Logger.getLogger(InitDatabase.class.getName());
    static String DB_DRIVER = "org.hsqldb.jdbcDriver";

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:hsqldb:file:/tmp/dbname:SA");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }


    static public void init() throws SQLException {
        Connection dbConnection = getDBConnection();
        Statement stmt;

        try {
            dbConnection.setAutoCommit(false);
            stmt = dbConnection.createStatement();

            stmt.execute("DROP TABLE IF EXISTS CONFIG");
            stmt.execute("CREATE TABLE CONFIG(id int primary key, operations varchar(50), elements int)");
            stmt.execute("INSERT INTO CONFIG(id, operations, elements) VALUES(1, 'SUM_STR', 1)");

            stmt.close();
            dbConnection.commit();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception Message " + e.getLocalizedMessage());
        } finally {
            dbConnection.close();
        }

    }


    static public void upadteDB(Properties prop) {
        Connection dbConnection = getDBConnection();
        Statement stmt;

        try {
            dbConnection.setAutoCommit(false);
            stmt = dbConnection.createStatement();
            String query = "UPDATE CONFIG SET operations=\'"
                    +prop.getProperty("operations")+"\'"
                    +", elements="+prop.getProperty("elements")
                    +" where id=1";
            System.out.println(query);
            stmt.execute(query);

            stmt.close();
            dbConnection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(EmbedMe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}