package mcbx.jb.classes.database.attendancemonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import mcbx.jb.classes.database.booksreservation.subjects;

public class registeredstudents {

     private static Vector data;
     private int isregistered;
     private String notes;
     private int students_idstudents;
     private int schoolyear_idschoolyear;
     private int section_idsection;

     public registeredstudents() {
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert(int isregistered, String notes, int students_idstudents, int schoolyear_idschoolyear, int section_idsection, Connection conn) {
          try {
               String query = "INSERT INTO registeredstudents (isregistered, notes, students_idstudents, schoolyear_idschoolyear, section_idsection) values (?,?,?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, isregistered);
               statement.setString(2, notes);
               statement.setInt(3, students_idstudents);
               statement.setInt(4, schoolyear_idschoolyear);
               statement.setInt(5, section_idsection);
               statement.execute();

               System.out.println("Successfully Inserted.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update(int idregisteredstudents, int isregistered, String notes, int students_idstudents, int schoolyear_idschoolyear, int section_idsection, Connection conn) {
          try {
               String query = "UPDATE registeredstudents SET isregistered=?, notes=?, students_idstudents=?, schoolyear_idschoolyear=?, section_idsection=? WHERE idsubjects = '" + idregisteredstudents + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, isregistered);
               statement.setString(2, notes);
               statement.setInt(3, students_idstudents);
               statement.setInt(4, schoolyear_idschoolyear);
               statement.setInt(5, section_idsection);
               statement.execute();
               System.out.println("Successfully Updated.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update(int idregisteredstudents, int isregistered, String notes, Connection conn) {
          try {
               String query = "UPDATE registeredstudents SET isregistered=?, notes=? WHERE idsubjects = '" + idregisteredstudents + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, isregistered);
               statement.setString(2, notes);
               statement.execute();
               System.out.println("Successfully Updated.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update(int idregisteredstudents, int isregistered, Connection conn) {
          try {
               String query = "UPDATE registeredstudents SET isregistered=? WHERE idsubjects = '" + idregisteredstudents + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, isregistered);
               statement.execute();
               System.out.println("Successfully Updated.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update(int idregisteredstudents, String notes, Connection conn) {
          try {
               String query = "UPDATE registeredstudents SET notes=? WHERE idsubjects = '" + idregisteredstudents + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, notes);
               statement.execute();

               System.out.println("Successfully Updated.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete(int[] idregisteredstudents, Connection conn) {
          try {
               int i_idregisteredstudents;
               for (int x = 0; x < idregisteredstudents.length; x++) {
                    i_idregisteredstudents = idregisteredstudents[x];
                    String queryString = "DELETE FROM registeredstudents WHERE idregisteredstudents = '" + i_idregisteredstudents + "'; ";
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(queryString);
                    statement.execute();

               }
          } catch (SQLException sqle) {
               System.out.println(sqle);
          }

     }
// ----------------------------------------------------------------------------- [DISPLAY]
// ----------------------------------------------------------------------------- [RETURN VALUES]

     public boolean function_is_isregistered(int idregisteredstudents, Connection conn) {
          try {
               String query = "SELECT rs.isregistered FROM registeredstudents AS rs WHERE rs.idregisteredstudents = '" + idregisteredstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    boolean rs_isregistered_rs = rs.getBoolean("rs.isregistered");
                    if (rs_isregistered_rs) {
                         return true;
                    } else {
                         return false;
                    }
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return false;
     }

     public String function_get_notes(int idregisteredstudents, Connection conn) {
          try {
               String query = "SELECT rs.notes FROM registeredstudents AS rs WHERE rs.idregisteredstudents = '" + idregisteredstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String rs_notes_rs = rs.getString("rs.notes");
                    return rs_notes_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public int function_get_idstudents(int idregisteredstudents, Connection conn) {
          try {
               String query = "SELECT rs.students_idstudents FROM registeredstudents AS rs WHERE rs.idregisteredstudents = '" + idregisteredstudents + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int rs_students_idstudents_rs = rs.getInt("rs.students_idstudents");
                    return rs_students_idstudents_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public int function_get_idschoolyear(int idregisteredstudents, Connection conn) {
          try {
               String query = "SELECT rs.schoolyear_idschoolyear FROM registeredstudents AS rs WHERE rs.idregisteredstudents = '" + idregisteredstudents + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int rs_schoolyear_idschoolyear_rs = rs.getInt("rs.schoolyear_idschoolyear");
                    return rs_schoolyear_idschoolyear_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public int function_get_idsection(int idregisteredstudents, Connection conn) {
          try {
               String query = "SELECT rs.section_idsection FROM registeredstudents AS rs WHERE rs.idregisteredstudents = '" + idregisteredstudents + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int rs_section_idsection_rs = rs.getInt("rs.section_idsection");
                    return rs_section_idsection_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public boolean function_is_idnumber_exist_by_schoolyear_and_idnumber(int idschoolyear, String idnumber, Connection conn) {
          try {
               String query = "SELECT rs.idregisteredstudents FROM registeredstudents AS rs , students AS s , schoolyear AS sy WHERE rs.schoolyear_idschoolyear = sy.idschoolyear AND rs.students_idstudents = s.idstudents AND s.idnumber = '" + idnumber + "' AND sy.idschoolyear = '" + idschoolyear + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    return true;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return false;
     }

     public boolean function_is_isregistered_by_schoolyear_and_idnumber(int idschoolyear, String idnumber, Connection conn) {
          try {
               String query = "SELECT rs.idregisteredstudents FROM registeredstudents AS rs , students AS s , schoolyear AS sy WHERE rs.schoolyear_idschoolyear = sy.idschoolyear AND rs.students_idstudents = s.idstudents AND s.idnumber = '" + idnumber + "' AND sy.idschoolyear = '" + idschoolyear + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    boolean rs_idregisteredstudents_rs = rs.getBoolean("rs.idregisteredstudents");
                    if (rs_idregisteredstudents_rs) {
                         return true;
                    } else {
                         return false;
                    }
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return false;
     }

     public int function_get_idregisteredstudents_by_idnumber(int idnumber, Connection conn) {
          try {
               String query = "SELECT rs.idregisteredstudents FROM registeredstudents AS rs , students AS s WHERE s.idstudents = rs.students_idstudents AND s.idnumber = '" + idnumber + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int rs_idregisteredstudents_rs = rs.getInt("rs.idregisteredstudents");
                    return rs_idregisteredstudents_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
}
