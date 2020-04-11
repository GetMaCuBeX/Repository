package mcbx.jb.classes.databaseconnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MaCuBeX
 */
public class MySQLConnection {

    private static String dbDriver = "com.mysql.jdbc.Driver";
    private static String readFile = System.getProperty("user.dir") + "/iReport/doscstinventorysystem/Config.ini";
    private static String jdbcUrl = "jdbc:mysql://";
    private static String dbUrl;
    public String mySqlUsername = "root";
    public String mySqlPassword = "";
    public Connection conn;

    public static String getDbDriver() {
        return dbDriver;
    }

    public static void setDbDriver(String dbDriver) {
        MySQLConnection.dbDriver = dbDriver;
    }

    public static String getReadFile() {
        return readFile;
    }

    public static void setReadFile(String readFile) {
        MySQLConnection.readFile = readFile;
    }

    public static String getJdbcUrl() {
        return jdbcUrl;
    }

    public static void setJdbcUrl(String jdbcUrl) {
        MySQLConnection.jdbcUrl = jdbcUrl;
    }

    public static String getDbUrl() {
        return dbUrl;
    }

    public static void setDbUrl(String dbUrl) {
        MySQLConnection.dbUrl = dbUrl;
    }

    public String getMySqlUsername() {
        return mySqlUsername;
    }

    public void setMySqlUsername(String mySqlUsername) {
        this.mySqlUsername = mySqlUsername;
    }

    public String getMySqlPassword() {
        return mySqlPassword;
    }

    public void setMySqlPassword(String mySqlPassword) {
        this.mySqlPassword = mySqlPassword;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public MySQLConnection() {
    }

    public String getConfig() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(getReadFile()));
            String line;

            while ((line = in.readLine()) != null) {
                return dbUrl = line;
            }
            in.close();

        } catch (IOException e) {
            System.out.println("Exception: Failed to read the file 'Config.ini'");
        }
        return getJdbcUrl();
    }

    public void getConnectToDatabaseHost() {
        synchronized (MySQLConnection.getReadFile()) {
            try {
                if (this.getConn() == null || this.getConn().isClosed()) {
                    try {
                        // Class.forName (com.mysql.jdbc.Driver)
                        Class.forName(MySQLConnection.getDbDriver());
                        // setConn(jdbc:mysql://localhost:3306/'databasename',root,'empty')
                        setConn(DriverManager.getConnection(MySQLConnection.getJdbcUrl() + this.getConfig(), this.getMySqlUsername(), this.getMySqlPassword()));
                        // System.out.println("Connected to database : " + this.getConfig());
//                        System.out.println("Connection: 'Connected'");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e + "\nCommunications link failure.", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Exception: " + e);
                    }
                } else {
//                    System.out.println("Connection: 'Still connected'");
                }
            } catch (SQLException ex) {
                // JOptionPane.showMessageDialog(null, ex + "", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("SQLException: " + ex);
            }
        } // end synchronized
    } // end getConnectToDatabaseHost()
} // end class
