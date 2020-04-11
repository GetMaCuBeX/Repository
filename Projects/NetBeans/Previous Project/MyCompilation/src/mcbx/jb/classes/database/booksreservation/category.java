package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Logger;

public class category {

     private static Vector data;
     private String name;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          category.data = data;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     /* constructor */
     public category() {
     }

     public category(String name) {
          this.name = name;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_category(category new_category, Connection conn) {
          try {
               String query = "INSERT INTO category (name) values (?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_category.getName());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_category(String name, category new_category, Connection conn) {
          try {
               String query = "UPDATE category SET name=? WHERE name = '" + name + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_category.getName());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_category(String name, Connection conn) {
          try {
               String query = "DELETE FROM category WHERE name = '" + name + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_category(String[] name, Connection conn) {
          try {
               String i_name;
               for (int x = 0; x < name.length; x++) {
                    i_name = name[x];
                    boolean isHasForeignKey = function_is_name_has_foreignKey(i_name, conn);
                    if (isHasForeignKey) {
                    } else {
                         String queryString = "DELETE FROM category WHERE name = '" + i_name + "'; ";
                         PreparedStatement statement = (PreparedStatement) conn.prepareStatement(queryString);
                         statement.execute();
                    }
               }
          } catch (SQLException sqle) {
               System.out.println(sqle);
          }

     }

// ----------------------------------------------------------------------------- [DISPLAY]
     public void display() {
          try {
               for (int i = 0; i < category.getData().size(); i++) {
                    System.out.println(category.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     private boolean function_is_name_has_foreignKey(String name, Connection conn) {
          try {
               String query = "SELECT c.`name` FROM category AS c , books WHERE c.`name` = books.category_name AND books.category_name = '" + name + "';";
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

     public boolean function_is_name_exist(String name, Connection conn) {
          try {
               String query = "SELECT name FROM category WHERE name = '" + name + "';";
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

     
     public boolean function_is_name_exist_notLike(String name, String notLike, Connection conn) {
          try {
               String query = "SELECT name FROM category WHERE category.`name` = '"+name+"' AND category.`name` NOT LIKE '"+notLike+"';";
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
     public void select_name(Connection conn) {
          category.setData(new Vector());
          try {
               String query = "SELECT c.`name` FROM category AS c ORDER BY c.`name` ASC;";
               executeQuery_name(query, conn);
          } catch (Exception e) {
               System.err.println(e);
          }
     }

     private void executeQuery_name(String query, Connection conn) {
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    String c_name_rs = rs.getString("c.name");
                    Vector row = new Vector();
                    row.add(c_name_rs);
                    category.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }
}
