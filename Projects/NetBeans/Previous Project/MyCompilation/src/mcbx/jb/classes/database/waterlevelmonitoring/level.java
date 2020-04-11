package mcbx.jb.classes.database.waterlevelmonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class level {

     private static Vector data;
     private int idlevel;
     private int iscritical;
     private String message;
     private String description;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          level.data = data;
     }

     public int getIdlevel() {
          return idlevel;
     }

     public void setIdlevel(int idlevel) {
          this.idlevel = idlevel;
     }

     public int getIscritical() {
          return iscritical;
     }

     public void setIscritical(int iscritical) {
          this.iscritical = iscritical;
     }

     public String getMessage() {
          return message;
     }

     public void setMessage(String message) {
          this.message = message;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     /* constructor */
     public level() {
     }

     public level(int idlevel, int iscritical, String message, String description) {
          this.idlevel = idlevel;
          this.iscritical = iscritical;
          this.message = message;
          this.description = description;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_level(level new_level, Connection conn) {
          try {
               String query = "INSERT INTO level (idlevel, iscritical, message) values (?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_level.getIdlevel());
               statement.setInt(2, new_level.getIscritical());
               statement.setString(3, new_level.getMessage());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_level(int idlevel, level new_level, Connection conn) {
          try {
               String query = "UPDATE level SET idlevel=?, iscritical=?, message=? WHERE idlevel = '" + idlevel + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_level.getIdlevel());
               statement.setInt(2, new_level.getIscritical());
               statement.setString(3, new_level.getMessage());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_level_idlevel(int idlevel, int iscritical, Connection conn) {
          try {
               String query = "UPDATE level SET idlevel=? WHERE idlevel = '" + idlevel + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, idlevel);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_level_iscritical(int idlevel, int iscritical, Connection conn) {
          try {
               String query = "UPDATE level SET iscritical=? WHERE idlevel = '" + idlevel + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, iscritical);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_level_message(int idlevel, String message, Connection conn) {
          try {
               String query = "UPDATE level SET message=? WHERE idlevel = '" + idlevel + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, message);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_level_description(int idlevel, String description, Connection conn) {
          try {
               String query = "UPDATE level SET description=? WHERE idlevel = '" + idlevel + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, description);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_level(int idlevel, Connection conn) {
          try {
               String query = "DELETE FROM level WHERE idlevel = '" + idlevel + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_level(int[] idlevel, Connection conn) {
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
     public void display() {
          try {
               for (int i = 0; i < level.getData().size(); i++) {
                    System.out.println(level.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_exist_idlevel(int idlevel, Connection conn) {
          try {
               String query = "SELECT l.idlevel FROM level AS l WHERE l.idlevel = '" + idlevel + "';";
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
// ----------------------------------------------------------------------------- [RETURN VALUES]

     public boolean function_get_iscritical(int idlevel, Connection conn) {
          try {
               String query = "SELECT l.iscritical FROM level AS l WHERE l.idlevel = '" + idlevel + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    boolean l_iscritical_rs = rs.getBoolean("l.iscritical");
                    if (l_iscritical_rs) {
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

     public String function_get_message(int idlevel, Connection conn) {
          try {
               String query = "SELECT l.message FROM level AS l WHERE l.idlevel = '" + idlevel + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String l_message_rs = rs.getString("l.message");
                    return l_message_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }
     
     public String function_get_description(int idlevel, Connection conn){
          try {
               String query = "SELECT l.description FROM level AS l WHERE l.idlevel = '" + idlevel + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String l_description_rs = rs.getString("l.description");
                    return l_description_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
     public int select_all(Connection conn) {
          level.setData(new Vector());
          try {
               String query = "SELECT l.idlevel, l.iscritical, l.message FROM level AS l ;";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     private int executeQuery_all(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int l_idlevel_rs = rs.getInt("l.idlevel");
                    boolean l_iscritical_rs = rs.getBoolean("l.iscritical");
                    String l_message_rs = rs.getString("l.message");

                    if (l_message_rs == null) {
                         l_message_rs = "";
                    }

                    Vector row = new Vector();
                    row.add(l_idlevel_rs);
                    row.add(l_iscritical_rs + " " + l_message_rs);
                    level.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }
}
