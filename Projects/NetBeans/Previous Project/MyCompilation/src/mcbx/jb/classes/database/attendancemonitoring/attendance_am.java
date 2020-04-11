package mcbx.jb.classes.database.attendancemonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class attendance_am {

     private static Vector data;
     private String attendancedate;
     private String timein;
     private String statusin;
     private String timeout;
     private String statusout;
     private int registeredstudents_idregisteredstudents;

     public attendance_am() {
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert(String attendancedate, int registeredstudents_idregisteredstudents, Connection conn) {
          try {
               String query = "INSERT INTO attendance_am (attendancedate, registeredstudents_idregisteredstudents) values (?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, attendancedate);
               statement.setInt(2, registeredstudents_idregisteredstudents);
               statement.execute();

               System.out.println("Successfully Inserted.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_timein_and_statusin(int idattendance_am, String timein, String statusin, int registeredstudents_idregisteredstudents, Connection conn) {
          try {
               String query = "UPDATE attendance_am SET timein=?, statusin=? WHERE idattendance_am = '" + idattendance_am + "' AND registeredstudents_idregisteredstudents = '" + registeredstudents_idregisteredstudents + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, timein);
               statement.setString(2, statusin);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_timeout_and_statusout(int idattendance_am, String timeout, String statusout, int registeredstudents_idregisteredstudents, Connection conn) {
          try {
               String query = "UPDATE attendance_am SET timein=?, statusin=? WHERE idattendance_am = '" + idattendance_am + "' AND registeredstudents_idregisteredstudents = '" + registeredstudents_idregisteredstudents + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, timeout);
               statement.setString(2, statusout);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
// ----------------------------------------------------------------------------- [DISPLAY]
// ----------------------------------------------------------------------------- [RETURN VALUES]
     public java.util.Date function_get_attendancedate(int idattendance_am, Connection conn) {
          try {
               String query = "SELECT aam.attendancedate FROM attendance_am AS aam WHERE aam.idattendance_am = '" + idattendance_am + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    java.util.Date aam_attendancedate_rs = rs.getDate("aam.attendancedate");
                    return aam_attendancedate_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_statusin(int idattendane_am, Connection conn) {
          try {
               String query = "SELECT aam.statusin FROM attendance_am AS aam WHERE aam.idattendance_am = '" + idattendane_am + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String aam_statusi_rs = rs.getString("aam.statusin");
                    return aam_statusi_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_statusout(int idattendane_am, Connection conn) {
          try {
               String query = "SELECT aam.statusout FROM attendance_am AS aam WHERE aam.idattendance_am = '" + idattendane_am + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String aam_statusout_rs = rs.getString("aam.statusout");
                    return aam_statusout_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public int function_get_idattendance_am(String attendancedate, int registeredstudents_idregisteredstudents, Connection conn) {
          try {
               String query = "SELECT amm.idattendance_am FROM attendance_am AS amm WHERE amm.attendancedate = '" + attendancedate + "' AND amm.registeredstudents_idregisteredstudents = '" + registeredstudents_idregisteredstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int amm_idattendance_am_rs = rs.getInt("amm.idattendance_am");
                    return amm_idattendance_am_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
}
