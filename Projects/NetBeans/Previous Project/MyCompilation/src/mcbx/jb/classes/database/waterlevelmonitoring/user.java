package mcbx.jb.classes.database.waterlevelmonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class user {

     private static Vector data;
     private int iduser;
     private String username;
     private String password;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          user.data = data;
     }

     public int getIduser() {
          return iduser;
     }

     public void setIduser(int iduser) {
          this.iduser = iduser;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     /* constructor */
     public user() {
     }

     public user(String username, String password) {
          this.username = username;
          this.password = password;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_user(user new_user, Connection conn) {
          try {
               String query = "INSERT INTO user (username, password) values (?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_user.getUsername());
               statement.setString(2, new_user.getPassword());
               statement.execute();

               System.out.println("Successfully Inserted.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_user(int iduser, user new_user, Connection conn) {
          try {
               String query = "UPDATE user SET username=?, password=? WHERE iduser = '" + iduser + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_user.getUsername());
               statement.setString(2, new_user.getPassword());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_user_username(int iduser, String username, Connection conn) {
          try {
               String query = "UPDATE user SET username=? WHERE iduser = '" + iduser + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, iduser);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_user_password(int iduser, String password, Connection conn) {
          try {
               String query = "UPDATE user SET password=? WHERE iduser = '" + iduser + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, iduser);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_user(int iduser, Connection conn) {
          try {
               String query = "DELETE FROM user WHERE iduser = '" + iduser + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_user(int[] iduser, Connection conn) {
          try {
               int i_iduser;
               for (int x = 0; x < iduser.length; x++) {
                    i_iduser = iduser[x];
                    String queryString = "DELETE FROM user WHERE iduser = '" + i_iduser + "'; ";
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
               for (int i = 0; i < user.getData().size(); i++) {
                    System.out.println(user.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public String function_get_username(int iduser, Connection conn) {
          try {
               String query = "SELECT u.username FROM `user` AS u WHERE u.iduser = '" + iduser + "';";
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

     public String function_get_password(int iduser, Connection conn) {
          try {
               String query = "SELECT u.password FROM `user` AS u WHERE u.iduser = '" + iduser + "';";
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

     public int function_get_iduser_username_password(String username, String password, Connection conn) {
          try {
               String query = "SELECT u.iduser FROM `user` AS u WHERE u.username = '" + username + "' AND u.`password` = '" + password + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int u_iduser_rs = rs.getInt("u.iduser");
                    return u_iduser_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

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

     public boolean function_is_exist_username_and_password_notLike(int iduser, String username, String password, Connection conn) {
          try {
               String query = "SELECT u.username FROM `user` AS u WHERE u.username = '" + username + "' AND u.`password` = '" + password + "' AND u.iduser NOT LIKE '" + iduser + "';";
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

     public boolean function_is_exist_username_and_password(String username, String password, Connection conn) {
          try {
               String query = "SELECT u.username FROM `user` AS u WHERE u.username = '" + username + "' AND u.`password` = '" + password + "';";
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
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
}
