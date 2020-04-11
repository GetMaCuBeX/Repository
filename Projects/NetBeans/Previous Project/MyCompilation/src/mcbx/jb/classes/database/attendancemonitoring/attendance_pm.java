package mcbx.jb.classes.database.attendancemonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class attendance_pm {

     private static Vector data;
     private String attendancedate;
     private String timein;
     private String statusin;
     private String timeout;
     private String statusout;
     private int registeredstudents_idregisteredstudents;

     public attendance_pm() {
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert(String attendancedate, int registeredstudents_idregisteredstudents, Connection conn) {
          try {
               String query = "INSERT INTO attendance_pm (attendancedate, registeredstudents_idregisteredstudents) values (?,?);";
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
               String query = "UPDATE attendance_pm SET timein=?, statusin=? WHERE idattendance_pm = '" + idattendance_am + "' AND registeredstudents_idregisteredstudents = '" + registeredstudents_idregisteredstudents + "'";
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
               String query = "UPDATE attendance_pm SET timein=?, statusin=? WHERE idattendance_pm = '" + idattendance_am + "' AND registeredstudents_idregisteredstudents = '" + registeredstudents_idregisteredstudents + "'";
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
     public java.util.Date function_get_attendancedate(int idattendance_pm, Connection conn) {
          try {
               String query = "SELECT apm.attendancedate FROM attendance_pm AS apm WHERE apm.idattendance_pm = '" + idattendance_pm + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    java.util.Date apm_attendancedate_rs = rs.getDate("apm.attendancedate");
                    return apm_attendancedate_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_statusin(int idattendane_pm, Connection conn) {
          try {
               String query = "SELECT apm.statusin FROM attendance_pm AS apm WHERE apm.idattendance_pm = '" + idattendane_pm + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String apm_statusi_rs = rs.getString("apm.statusin");
                    return apm_statusi_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_statusout(int idattendane_pm, Connection conn) {
          try {
               String query = "SELECT apm.statusout FROM attendance_pm AS apm WHERE apm.idattendance_pm = '" + idattendane_pm + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String apm_statusout_rs = rs.getString("apm.statusout");
                    return apm_statusout_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
}
