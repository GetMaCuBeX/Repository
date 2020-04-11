package mcbx.jb.classes.database.attendancemonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class level {

     private static Vector data;
     private String name;
     private String type;

     public level() {
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert(String name, String type, Connection conn) {
          try {
               String query = "INSERT INTO level (name, type) values (?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, name);
               statement.setString(2, type);
               statement.execute();

               System.out.println("Successfully Inserted.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }
// ----------------------------------------------------------------------------- [UPDATE]

     public void update(int idlevel, String name, String type, Connection conn) {
          try {
               String query = "UPDATE level SET name=?, type=? WHERE idlevel = '" + idlevel + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, name);
               statement.setString(2, type);
               statement.execute();

               System.out.println("Successfully Updated.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }
// ----------------------------------------------------------------------------- [DELETE]

     public void delete(int[] idlevel, Connection conn) {
          try {
               int i_idlevel;
               for (int x = 0; x < idlevel.length; x++) {
                    i_idlevel = idlevel[x];
                    String queryString = "DELETE FROM level WHERE idlevel = '" + i_idlevel + "'; ";
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(queryString);
                    statement.execute();
               }
          } catch (SQLException sqle) {
               System.out.println(sqle);
          }

     }

// ----------------------------------------------------------------------------- [DISPLAY]
// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_name_and_type_exist(String name, String type, Connection conn) {
          try {
               String query = "SELECT l.idlevel FROM `level` AS l WHERE l.`name` = '" + name + "' AND l.type = '" + type + "';";
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

     public int function_get_idlevel(String name, String type, Connection conn) {
          try {
               String query = "SELECT l.idlevel FROM `level` AS l WHERE l.`name` = '" + name + "' AND l.type = '" + type + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int l_idlevel_rs = rs.getInt("l.idlevel");
                    return l_idlevel_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public String function_get_name(int idlevel, Connection conn) {
          try {
               String query = "SELECT l.`name` FROM `level` AS l WHERE l.idlevel = '" + idlevel + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String l_name_rs = rs.getString("l.name");
                    return l_name_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_type(int idlevel, Connection conn) {
          try {
               String query = "SELECT l.type FROM `level` AS l WHERE l.idlevel = '" + idlevel + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String l_type_rs = rs.getString("l.type");
                    return l_type_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
}
