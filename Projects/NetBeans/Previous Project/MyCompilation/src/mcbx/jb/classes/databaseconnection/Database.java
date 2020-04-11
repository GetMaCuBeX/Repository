package mcbx.jb.classes.databaseconnection;

import java.sql.Connection;

public class Database {

     private static JD_MySQLConnect _ins_MySQLConnect = new JD_MySQLConnect(null, true);
     public static MySQL _booksreservation = new MySQL("localhost", "3306", "booksreservation", "root", "");
     public static MySQL _waterlevelmonitoring = new MySQL("localhost", "3306", "waterlevelmonitoring", "root", "");
     public static MySQL _lanes_data = new MySQL("localhost", "3306", "lanes_data", "root", "");
     public static MySQL _attendancemonitoring = new MySQL("localhost", "3306", "attendancemonitoring", "root", "");
     public static MySQL _gradebookmanagement = new MySQL("localhost", "3306", "gradebookmanagement", "root", "");

     public static Connection _function_getConnection(MySQL _ref_database) {
          try {
               _ref_database.connectToServer();
               Connection conn = _ref_database.getConnection();
               return conn;
          } catch (Exception e) {
               System.err.println(e);
          }
          return null;
     }

     public static void _open_JD_MySQLConnect(MySQL ref_database) {
          try {
               _ins_MySQLConnect.setLocationRelativeTo(null);
               _ins_MySQLConnect.initiliazeConnection(ref_database);
               _ins_MySQLConnect.setVisible(true);
          } catch (Exception e) {
               System.err.println(e);
          }
     }
}
