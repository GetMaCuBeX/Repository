package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class publishers {

     private static Vector data;
     private String name;
     private String city;
     private String contactinformation;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          publishers.data = data;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getCity() {
          return city;
     }

     public void setCity(String city) {
          this.city = city;
     }

     public String getContactinformation() {
          return contactinformation;
     }

     public void setContactinformation(String contactinformation) {
          this.contactinformation = contactinformation;
     }

     /* constructor */
     public publishers() {
     }

     public publishers(String name, String city, String contactinformation) {
          this.name = name;
          this.city = city;
          this.contactinformation = contactinformation;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_publishers(publishers new_publishers, Connection conn) {
          try {
               String query = "INSERT INTO publishers (name, city, contactinformation) values (?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_publishers.getName());
               statement.setString(2, new_publishers.getCity());
               statement.setString(3, new_publishers.getContactinformation());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_publishers(int idpublishers, publishers new_publishers, Connection conn) {
          try {
               String query = "UPDATE publishers SET name=?, city=?, contactinformation=? WHERE idpublishers = '" + idpublishers + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_publishers.getName());
               statement.setString(2, new_publishers.getCity());
               statement.setString(3, new_publishers.getContactinformation());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_publishers(int idpublishers, Connection conn) {
          try {
               String query = "DELETE FROM publishers WHERE idpublishers = '" + idpublishers + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_publishers(int[] idpublishers, Connection conn) {
          try {
               int i_idpublishers;
               for (int x = 0; x < idpublishers.length; x++) {
                    i_idpublishers = idpublishers[x];
                    boolean isHasForeignKey = function_is_idauthors_has_foreignKey(i_idpublishers, conn);
                    if (isHasForeignKey) {
                    } else {
                         String queryString = "DELETE FROM publishers WHERE idpublishers = '" + i_idpublishers + "'; ";
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
               for (int i = 0; i < publishers.getData().size(); i++) {
                    System.out.println(publishers.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_idauthors_has_foreignKey(int idpublishers, Connection conn) {
          try {
               String query = "SELECT p.idpublishers FROM bookspublishers AS b_p , publishers AS p WHERE p.idpublishers = b_p.publishers_idpublishers AND p.idpublishers = '"+idpublishers+"';";
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

     public String function_get_name(int idpublishers, Connection conn) {
          try {
               String query = "SELECT pb.`name` FROM publishers AS pb WHERE pb.idpublishers = '" + idpublishers + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String pb_name_rs = rs.getString("pb.name");
                    return pb_name_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_city(int idpublishers, Connection conn) {
          try {
               String query = "SELECT pb.city FROM publishers AS pb WHERE pb.idpublishers = '" + idpublishers + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String pb_city_rs = rs.getString("pb.city");
                    return pb_city_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_contactinformation(int idpublishers, Connection conn) {
          try {
               String query = "SELECT pb.contactinformation FROM publishers AS pb WHERE pb.idpublishers = '" + idpublishers + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String pb_contactinformation_rs = rs.getString("pb.contactinformation");
                    return pb_contactinformation_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
     public int count_select_all(Connection conn) {
          try {
               String query = "SELECT Count(p.idpublishers) as resultCount FROM publishers AS p;";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int b_resultCount_rs = rs.getInt("resultCount");
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

     public int select_all(int limitFrom, int limitTo, Connection conn) {
          publishers.setData(new Vector());
          try {
               String query = "SELECT p.idpublishers, p.`name`, p.city, p.contactinformation FROM publishers AS p LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idbooks(int idbooks, int limitFrom, int limitTo, Connection conn) {
          publishers.setData(new Vector());
          try {
               String query = "SELECT p.idpublishers, p.`name`, p.city, p.contactinformation FROM publishers AS p , bookspublishers AS b_p , books AS b WHERE b_p.books_idbooks = b.idbooks AND b_p.publishers_idpublishers = p.idpublishers AND b.idbooks = " + idbooks + " LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idbooks(int idbooks, Connection conn) {
          publishers.setData(new Vector());
          try {
               String query = "SELECT p.idpublishers, p.`name`, p.city, p.contactinformation FROM publishers AS p , bookspublishers AS b_p , books AS b WHERE b_p.books_idbooks = b.idbooks AND b_p.publishers_idpublishers = p.idpublishers AND b.idbooks = " + idbooks + "  ;";
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
                    int p_idpublishers_rs = rs.getInt("p.idpublishers");
                    String p_name_rs = rs.getString("p.name");
                    String p_contactinformation_rs = rs.getString("p.contactinformation");

                    Vector row = new Vector();
                    row.add(p_idpublishers_rs);
                    row.add(p_name_rs);
                    row.add(p_contactinformation_rs);
                    publishers.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }

     /**/
     public int count_select_search(String search, Connection conn) {
          try {
               String query = "SELECT Count(p.idpublishers) as resultCount FROM publishers AS p WHERE p.`name` LIKE '%" + search + "%' OR p.city LIKE '%" + search + "%' OR p.contactinformation LIKE '%" + search + "%';";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int b_resultCount_rs = rs.getInt("resultCount");
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

     public int select_by_search(String search, int limitFrom, int limitTo, Connection conn) {
          publishers.setData(new Vector());
          try {
               String query = "SELECT p.idpublishers, p.`name`, p.city, p.contactinformation FROM publishers AS p WHERE p.`name` LIKE '%" + search + "%' OR p.city LIKE '%" + search + "%' OR p.contactinformation LIKE '%" + search + "%' LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_search(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     private int executeQuery_search(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int p_idpublishers_rs = rs.getInt("p.idpublishers");
                    String p_name_rs = rs.getString("p.name");
                    String p_city_rs = rs.getString("p.city");
                    String p_contactinformation_rs = rs.getString("p.contactinformation");

                    Vector row = new Vector();
                    row.add(p_idpublishers_rs);
                    row.add(p_name_rs);
                    row.add(p_city_rs);
                    row.add(p_contactinformation_rs);
                    publishers.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }
}
