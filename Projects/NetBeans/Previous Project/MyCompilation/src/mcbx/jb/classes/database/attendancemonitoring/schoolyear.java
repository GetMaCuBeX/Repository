package mcbx.jb.classes.database.attendancemonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class schoolyear {

     private static Vector data;
     private int from;
     private int to;

     public schoolyear() {
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert(int from, int to, Connection conn) {
          try {
               String query = "INSERT INTO schoolyear (from, to) values (?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, from);
               statement.setInt(2, to);
               statement.execute();

               System.out.println("Successfully Inserted.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update(int idschoolyear, int from, int to, Connection conn) {
          try {
               String query = "UPDATE schoolyear SET from=?, to=? WHERE idschoolyear = '" + idschoolyear + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, from);
               statement.setInt(2, to);
               statement.execute();

               System.out.println("Successfully Updated.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }
// ----------------------------------------------------------------------------- [DELETE]

     public void delete(int[] idschoolyear, Connection conn) {
          try {
               int i_idschoolyear;
               for (int x = 0; x < idschoolyear.length; x++) {
                    i_idschoolyear = idschoolyear[x];
                    String queryString = "DELETE FROM schoolyear WHERE idschoolyear = '" + i_idschoolyear + "'; ";
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(queryString);
                    statement.execute();
               }
          } catch (SQLException sqle) {
               System.out.println(sqle);
          }

     }

// ----------------------------------------------------------------------------- [DISPLAY]
// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_from_and_to_exist(int from, int to, Connection conn) {
          try {
               String query = "SELECT sy.idschoolyear FROM schoolyear AS sy WHERE sy.from = '" + from + "' AND sy.to = '" + to + "';";
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

     public int function_get_idschoolyear_by_from_and_to(int from, int to, Connection conn) {
          try {
               String query = "SELECT sy.idschoolyear FROM schoolyear AS sy WHERE sy.from = '" + from + "' AND sy.to = '" + to + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int sy_idschoolyear_rs = rs.getInt("sy.idschoolyear");
                    return sy_idschoolyear_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public int function_get_from(int idschoolyear, Connection conn) {
          try {
               String query = "SELECT sy.`from` FROM schoolyear AS sy WHERE sy.idschoolyear = '" + idschoolyear + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int sy_from_rs = rs.getInt("sy.from");
                    return sy_from_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public int function_get_to(int idschoolyear, Connection conn) {
          try {
               String query = "SELECT sy.`to` FROM schoolyear AS sy WHERE sy.idschoolyear = '" + idschoolyear + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int sy_to_rs = rs.getInt("sy.to");
                    return sy_to_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
}
