package mcbx.jb.classes.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

     /* establish connection */
     public void connectToServer() {
          try {
               try {
                    /* Class.forName (com.mysql.jdbc.Driver) */
                    Class.forName(this.getDRIVER());
               } catch (ClassNotFoundException e) {
                    this.setConnection(null);
                    ClassNotFoundException_println();
                    ClassNotFoundException_JOptionPane();
                    return;
               }
               /* this.setConnection(jdbc:mysql://localhost:3306/databasename,root,empty) */
               this.setDbURL(this.getURL() + "" + this.getServerHostName() + ":" + this.getPortNumber() + "/" + this.getSchema());
               this.setConnection(DriverManager.getConnection(this.getDbURL(), this.getUserName(), this.getPassword()));
//               System.out.println("Connection Ok...");
//               System.out.println("\t@Database URL:\t[" + this.getDbURL() + "]");
          } catch (SQLException sqle) {
               this.setConnection(null);
               SQLException_println();
               SQLException_JOptionPane(sqle);
          }
     }

     /* display exception message*/
     private void SQLException_println() {
          System.err.println("Connection Failed...");
          System.err.println("\t@Server:\t[" + this.getServerHostName() + "]");
          System.err.println("\t@Port #:\t[" + this.getPortNumber() + "]");
          System.err.println("\t@Schema:\t[" + this.getSchema() + "]");
          System.err.println("\t@Username:\t[" + this.getUserName() + "]");
          System.err.println("\t@Password:\t[" + this.getPassword() + "]");
          System.err.println("\t@Database URL:\t[" + this.getDbURL() + "]");
     }

     private void SQLException_JOptionPane(SQLException sqle) {
          JOptionPane.showMessageDialog(null, sqle, "Connection Failed", JOptionPane.ERROR_MESSAGE);
     }

     private void ClassNotFoundException_println() {
          System.err.println("Missing MySQL Driver...");
     }

     private void ClassNotFoundException_JOptionPane() {
          JOptionPane.showMessageDialog(null, ""
                  + "<html>"
                  + "<head>"
                  + "<style type=\"text/css\">"
                  + "<!--"
                  + ".style1 {"
                  + "color: #FF0000;"
                  + "font-weight: bold;"
                  + "}"
                  + "-->"
                  + "</style>"
                  + "</head>"
                  + "<body>"
                  + "<p class=\"style1\">Error:</p>"
                  + "<p>Missing MySQL Driver</p>"
                  + "</body>"
                  + "</html>"
                  + "", "Connection Failed", JOptionPane.ERROR_MESSAGE);
     }
}
