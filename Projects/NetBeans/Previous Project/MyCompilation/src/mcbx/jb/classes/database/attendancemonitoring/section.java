package mcbx.jb.classes.database.attendancemonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class section {

     private static Vector data;
     private String name;
     private int level_idlevel;

     public section() {
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert(String name, int level_idlevel, Connection conn) {
          try {
               String query = "INSERT INTO section (name, level_idlevel) values (?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, name);
               statement.setInt(2, level_idlevel);
               statement.execute();

               System.out.println("Successfully Inserted.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update(int idsection, String name, int level_idlevel, Connection conn) {
          try {
               String query = "UPDATE section SET name=?, level_idlevel=? WHERE idsection = '" + idsection + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, name);
               statement.setInt(2, level_idlevel);
               statement.execute();

               System.out.println("Successfully Updated.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     
     public void delete(int[] idusers, Connection conn) {
          try {
               int i_idusers;
               for (int x = 0; x < idusers.length; x++) {
                    i_idusers = idusers[x];
                    String queryString = "DELETE FROM users WHERE idusers = '" + i_idusers + "'; ";
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(queryString);
                    statement.execute();
               }
          } catch (SQLException sqle) {
               System.out.println(sqle);
          }

     }
// ----------------------------------------------------------------------------- [DISPLAY]
// ----------------------------------------------------------------------------- [RETURN VALUES]
     public String function_get_name(int idsection, Connection conn) {
          try {
               String query = "SELECT s.`name` FROM section AS s WHERE s.idsection = '" + idsection + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String s_name_rs = rs.getString("s.name");
                    return s_name_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
}
