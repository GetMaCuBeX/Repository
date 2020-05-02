/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mcbx.database.AlertHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;
import javax.swing.JOptionPane;

public class MySQL {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://";
    private String serverHostName = "";
    private String portNumber = "";
    private String schema = "";
    private String userName = "";
    private String password = "";
    private String dbURL = "";
    private Connection connection = null;

    public MySQL(String serverHostname, String portNumber, String schema, String username, String password) {
        this.serverHostName = serverHostname;
        this.portNumber = portNumber;
        this.schema = schema;
        this.userName = username;
        this.password = password;
    }

    public String getDRIVER() {
        return DRIVER;
    }

    public String getURL() {
        return URL;
    }

    public String getServerHostName() {
        return serverHostName;
    }

    public void setServerHostName(String serverHostName) {
        this.serverHostName = serverHostName;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // Establish connection
    public void connectToServer(Window window) {
        try {
            try {
                Class.forName(this.getDRIVER());
            } catch (ClassNotFoundException e) {
                this.setConnection(null);
                AlertHelper.showAlert(AlertType.ERROR, window, "Error", null, "Missing MySQL Driver...");
                return;
            }
            /* this.setConnection(jdbc:mysql://localhost:3306/databasename,root,empty) */
            this.setDbURL(this.getURL() + "" + this.getServerHostName() + ":" + this.getPortNumber() + "/" + this.getSchema());
            this.setConnection(DriverManager.getConnection(this.getDbURL(), this.getUserName(), this.getPassword()));
            AlertHelper.showAlert(AlertType.INFORMATION, window, "Information", null, "Success Connection...");
//               System.out.println("\t@Database URL:\t[" + this.getDbURL() + "]");
        } catch (SQLException e) {
            AlertHelper.showAlertException(AlertType.ERROR, window, "Class "+getClass().getSimpleName(), "Exception", e.getMessage(), e);
            this.setConnection(null);
//            AlertHelper.showAlert(AlertType.ERROR, window, "Error", null, "Connection Failed...");
            printConnection();
        }
    }
    
    // Establish connection
    public void connectToServer() {
        try {
            try {
                Class.forName(this.getDRIVER());
            } catch (ClassNotFoundException e) {
                this.setConnection(null);
               System.err.println(e.getMessage());
                return;
            }
            /* this.setConnection(jdbc:mysql://localhost:3306/databasename,root,empty) */
            this.setDbURL(this.getURL() + "" + this.getServerHostName() + ":" + this.getPortNumber() + "/" + this.getSchema());
            this.setConnection(DriverManager.getConnection(this.getDbURL(), this.getUserName(), this.getPassword())); 
               System.out.println("\t@Database URL:\t[" + this.getDbURL() + "]");
        } catch (SQLException e) { 
            this.setConnection(null);
               System.err.println(e.getMessage());
               printConnection();
            printConnection();
        }
    }

    /* display exception message*/
    private void printConnection() {
        System.err.println("Connection Failed...");
        System.err.println("\t@Server:\t[" + this.getServerHostName() + "]");
        System.err.println("\t@Port #:\t[" + this.getPortNumber() + "]");
        System.err.println("\t@Schema:\t[" + this.getSchema() + "]");
        System.err.println("\t@Username:\t[" + this.getUserName() + "]");
        System.err.println("\t@Password:\t[" + this.getPassword() + "]");
        System.err.println("\t@Database URL:\t[" + this.getDbURL() + "]");
    }

}
