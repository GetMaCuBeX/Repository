package mcbx.jb.classes.database.attendancemonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class users {

     private static Vector data;
     public String name;
     public String username;
     public String password;
     public String type;

     public users() {
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert(String name, String username, String password, String type, Connection conn) {
          try {
               String query = "INSERT INTO users (name, username, password, type) values (?,?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, name);
               statement.setString(2, username);
               statement.setString(3, password);
               statement.setString(4, type);
               statement.execute();

               System.out.println("Successfully Inserted.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }
// ----------------------------------------------------------------------------- [UPDATE]

     public void update(int idusers, String name, String username, String password, String type, Connection conn) {
          try {
               String query = "UPDATE users SET name=?, username=?, password=?, type=? WHERE idusers = '" + idusers + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, name);
               statement.setString(2, username);
               statement.setString(3, password);
               statement.setString(4, type);
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
     public boolean function_is_username_and_password_exist(String username, String password, Connection conn) {
          try {
               String query = "SELECT users.idusers FROM users WHERE users.username = '" + username + "' AND users.`password` = '" + password + "';";
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

     public int function_get_idusers(String username, String password, Connection conn) {
          try {
               String query = "SELECT u.idusers FROM users AS u WHERE u.username = '" + username + "' AND u.`password` = '" + password + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int u_idusers_rs = rs.getInt("u.idusers");
                    return u_idusers_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public String function_get_name(int idusers, Connection conn) {
          try {
               String query = "SELECT u.`name` FROM users WHERE u.idusers = '" + idusers + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String u_name_rs = rs.getString("u.name");
                    return u_name_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_username(int idusers, Connection conn) {
          try {
               String query = "SELECT u.username FROM users WHERE u.idusers = '" + idusers + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String u_username_rs = rs.getString("u.username");
                    return u_username_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_password(int idusers, Connection conn) {
          try {
               String query = "SELECT u.password FROM users WHERE u.idusers = '" + idusers + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String u_password_rs = rs.getString("u.password");
                    return u_password_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_type(int idusers, Connection conn) {
          try {
               String query = "SELECT u.type FROM users AS u WHERE u.idusers = '" + idusers + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String u_type_rs = rs.getString("u.type");
                    return u_type_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
               sqle.printStackTrace();
          }
          return null;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
}
