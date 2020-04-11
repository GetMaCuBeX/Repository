package mcbx.jb.classes.databaseconnection;


import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConnection extends MySQLConnection {

     private static MySQLConnection ref_MySQLConnection = new MySQLConnection();
     private static MySQL ref_MySQL;
     private static MySQL ref_MySQL2;

     public static void main(String[] args) {
          ref_MySQL = new MySQL("localhost", "3306", "booksreservation", "root", "");
          ref_MySQL2 = new MySQL("localhost", "3306", "gradebook", "root", "");

          testConnection_MySQL();
//          testConnection_MySQLConnection();
     }

     private static void testConnection_MySQLConnection() {
          try {
               System.out.println();
               ref_MySQLConnection.getConnectToDatabaseHost();
               System.out.println("Database: '" + ref_MySQLConnection.getConfig() + "'");
               System.out.println("Username: '" + ref_MySQLConnection.getMySqlUsername() + "'");
               System.out.println("Password: '" + ref_MySQLConnection.getMySqlPassword() + "'");
               System.out.println();

          } catch (Exception sqle) {
               System.err.println(sqle);
          }
     }

     private static void testConnection_MySQL() {
          try {
               ref_MySQL.connectToServer();
//               ref_MySQL2.connectToServer();
          } catch (Exception ex) {
               Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
}
