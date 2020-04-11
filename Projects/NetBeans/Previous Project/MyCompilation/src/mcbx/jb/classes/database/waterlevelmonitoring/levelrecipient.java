package mcbx.jb.classes.database.waterlevelmonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import mcbx.jb.classes.database.booksreservation.books;

public class levelrecipient {

     private static Vector data;
     private int idlevelrecipient;
     private String name;
     private String mobilenumber;
     private int level_idlevel;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          levelrecipient.data = data;
     }

     public int getIdlevelrecipient() {
          return idlevelrecipient;
     }

     public void setIdlevelrecipient(int idlevelrecipient) {
          this.idlevelrecipient = idlevelrecipient;
     }

     public int getLevel_idlevel() {
          return level_idlevel;
     }

     public void setLevel_idlevel(int level_idlevel) {
          this.level_idlevel = level_idlevel;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getMobilenumber() {
          return mobilenumber;
     }

     public void setMobilenumber(String mobilenumber) {
          this.mobilenumber = mobilenumber;
     }

     /* constructor */
     public levelrecipient() {
     }

     public levelrecipient(int idlevelrecipient, int level_idlevel, String name, String mobilenumber) {
          this.idlevelrecipient = idlevelrecipient;
          this.level_idlevel = level_idlevel;
          this.name = name;
          this.mobilenumber = mobilenumber;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_levelrecipient(levelrecipient new_levelrecipient, Connection conn) {
          try {
               String query = "INSERT INTO levelrecipient (name, mobilenumber, level_idlevel) values (?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_levelrecipient.getName());
               statement.setString(2, new_levelrecipient.getMobilenumber());
               statement.setInt(3, new_levelrecipient.getLevel_idlevel());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void insert_levelrecipient(String name, String mobilenumber, int level_idlevel, Connection conn) {
          try {
               String query = "INSERT INTO levelrecipient (name, mobilenumber, level_idlevel) values (?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, name);
               statement.setString(2, mobilenumber);
               statement.setInt(3, level_idlevel);
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_levelrecipient(int idlevelrecipient, levelrecipient new_levelrecipient, Connection conn) {
          try {
               String query = "UPDATE levelrecipient SET name=?, mobilenumber=?, level_idlevel=? WHERE idlevelrecipient = '" + idlevelrecipient + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_levelrecipient.getName());
               statement.setString(2, new_levelrecipient.getMobilenumber());
               statement.setInt(3, new_levelrecipient.getLevel_idlevel());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_levelrecipient_name(int idlevelrecipient, String name, Connection conn) {
          try {
               String query = "UPDATE levelrecipient SET name=? WHERE idlevelrecipient = '" + idlevelrecipient + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, name);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_levelrecipient_mobilenumber(int idlevelrecipient, String mobilenumber, Connection conn) {
          try {
               String query = "UPDATE levelrecipient SET mobilenumber=? WHERE idlevelrecipient = '" + idlevelrecipient + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, mobilenumber);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_levelrecipient_level_idlevel(int idlevelrecipient, int level_idlevel, Connection conn) {
          try {
               String query = "UPDATE levelrecipient SET level_idlevel=? WHERE idlevelrecipient = '" + idlevelrecipient + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, level_idlevel);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_levelrecipient(int idlevelrecipient, Connection conn) {
          try {
               String query = "DELETE FROM levelrecipient WHERE idlevelrecipient = '" + idlevelrecipient + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_level(int[] idlevelrecipient, Connection conn) {
          try {
               int i_idlevelrecipient;
               for (int x = 0; x < idlevelrecipient.length; x++) {
                    i_idlevelrecipient = idlevelrecipient[x];
                    String queryString = "DELETE FROM levelrecipient WHERE idlevelrecipient = '" + i_idlevelrecipient + "'; ";
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
               for (int i = 0; i < levelrecipient.getData().size(); i++) {
                    System.out.println(levelrecipient.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_exist_mobilenumber_and_level_idlevel(String mobilenumber, int level_idlevel, Connection conn) {
          try {
               String query = "SELECT lr.idlevelrecipient FROM levelrecipient AS lr WHERE lr.mobilenumber = '" + mobilenumber + "' AND lr.level_idlevel = '" + level_idlevel + "';";
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

     public String function_get_mobilenumber(int level_idlevel, Connection conn) {
          try {
               String query = "SELECT lc.mobilenumber FROM levelrecipient AS lc WHERE lc.level_idlevel = '" + level_idlevel + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String lc_mobilenumber = rs.getString("lc.mobilenumber");
                    return lc_mobilenumber;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return "";
     }

     public int function_count_mobilenumber_by_level_idlevel(int level_idlevel, Connection conn) {
          try {
               String query = "SELECT Count(lr.mobilenumber) FROM levelrecipient AS lr WHERE lr.level_idlevel = '" + level_idlevel + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int lr_resultCount_rs = rs.getInt(1);
                    return lr_resultCount_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public String[] function_get_mobilenumber_by_level_idlevel(int level_idlevel, Connection conn) {
          int count_ = function_count_mobilenumber_by_level_idlevel(level_idlevel, conn);
          String[] mobilenumber_ = new String[count_];
          try {
               String query = "SELECT lr.mobilenumber FROM levelrecipient AS lr WHERE lr.level_idlevel = '" + level_idlevel + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               int x = 0;
               while (rs.next()) {
                    String lr_mobilenumber_rs = rs.getString("lr.mobilenumber");
                    mobilenumber_[x] = lr_mobilenumber_rs;
                    x++;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return mobilenumber_;
     }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
     public int select_all_by_level_idlevel(int level_idlevel, Connection conn) {
          levelrecipient.setData(new Vector());
          try {
               String query = "SELECT lr.idlevelrecipient, lr.name, lr.mobilenumber, lr.mobilenumber, lr.level_idlevel FROM levelrecipient AS lr WHERE lr.level_idlevel = '" + level_idlevel + "';";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all(Connection conn) {
          levelrecipient.setData(new Vector());
          try {
               String query = "SELECT lr.idlevelrecipient, lr.name, lr.mobilenumber, lr.mobilenumber, lr.level_idlevel FROM levelrecipient AS lr ;";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     //
     public int guest_count_select_by_search_int_authors(String search, Connection conn) {
          try {
               String query = "SELECT COUNT(b.idbooks) as resultCount FROM `authors` AS a INNER JOIN booksauthors AS b_a ON a.idauthors = b_a.authors_idauthors INNER JOIN books AS b ON b.idbooks = b_a.books_idbooks WHERE a.firstname LIKE '%" + search + "%' OR a.lastname LIKE '%" + search + "%' OR b.title LIKE '%" + search + "%' OR b.description LIKE '%" + search + "%' OR b.language LIKE '%" + search + "%' OR b.category_name LIKE '%" + search + "%' ORDER BY a.firstname ASC;";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int b_resultCount_rs = rs.getInt(1);
                         return b_resultCount_rs;
                    }
                    rs.close();
               } catch (SQLException sqle) {
                    System.err.println(sqle);
               }
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int guest_select_books_information_by_search_in_authors(String search, int limitFrom, int limitTo, Connection conn) {
          levelrecipient.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, a.idauthors, (SELECT p.`name` AS p_name  FROM publishers AS p , bookspublishers AS b_p WHERE p.idpublishers = b_p.publishers_idpublishers AND b_p.books_idbooks = b.idbooks LIMIT 1 ) AS p_name, CONCAT(IFNULL(a.firstname,''),\" \", IFNULL(a.lastname,'') ) AS a_name, b.title, b.pages, b.description, b.`language`, b.copynumber, b.isborrowable, b.category_name FROM `authors` AS a INNER JOIN booksauthors AS b_a ON a.idauthors = b_a.authors_idauthors INNER JOIN books AS b ON b.idbooks = b_a.books_idbooks WHERE a.firstname LIKE '%" + search + "%' OR a.lastname LIKE '%" + search + "%' OR b.title LIKE '%" + search + "%' OR b.description LIKE '%" + search + "%' OR b.language LIKE '%" + search + "%' OR b.category_name LIKE '%" + search + "%' ORDER BY a.firstname ASC LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;

     }

     //
     public int count_select_all_by_search(String search, Connection conn) {
          try {
               String query = "SELECT Count(lr.idlevelrecipient) FROM levelrecipient as lr WHERE lr.`name` LIKE '%" + search + "%' OR lr.mobilenumber LIKE '%" + search + "%' OR lr.mobilenumber LIKE '%" + search + "%' ;";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int b_resultCount_rs = rs.getInt(1);
                         return b_resultCount_rs;
                    }
                    rs.close();
               } catch (SQLException sqle) {
                    System.err.println(sqle);
               }
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all(String search, int limitFrom, int limitTo, Connection conn) {
          levelrecipient.setData(new Vector());
          try {
               String query = "SELECT lr.idlevelrecipient, lr.`name`, lr.mobilenumber, lr.level_idlevel FROM levelrecipient as lr WHERE lr.`name` LIKE '%" + search + "%' OR lr.mobilenumber LIKE '%" + search + "%' OR lr.mobilenumber LIKE '%" + search + "%' ORDER BY lr.level_idlevel ASC LIMIT " + limitFrom + ", " + limitTo + ";";
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
                    int lr_idlevelrecipient_rs = rs.getInt("lr.idlevelrecipient");
                    String lr_name_rs = rs.getString("lr.name");
                    String lr_mobilenumber_rs = rs.getString("lr.mobilenumber");
                    int lr_level_idlevel_rs = rs.getInt("lr.level_idlevel");

                    if (lr_name_rs == null) {
                         lr_name_rs = "";
                    }

                    if (lr_mobilenumber_rs == null) {
                         lr_mobilenumber_rs = "";
                    }

                    Vector row = new Vector();
                    row.add(lr_idlevelrecipient_rs);
                    row.add(lr_level_idlevel_rs);
                    row.add(lr_name_rs);
                    row.add(lr_mobilenumber_rs);
                    levelrecipient.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }
}
