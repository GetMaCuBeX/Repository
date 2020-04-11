package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class authors {

     private static Vector data;
     private String firstname;
     private String lastname;
     private String contactinformation;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          authors.data = data;
     }

     public String getFirstname() {
          return firstname;
     }

     public void setFirstname(String firstname) {
          this.firstname = firstname;
     }

     public String getLastname() {
          return lastname;
     }

     public void setLastname(String lastname) {
          this.lastname = lastname;
     }

     public String getContactinformation() {
          return contactinformation;
     }

     public void setContactinformation(String contactinformation) {
          this.contactinformation = contactinformation;
     }

     /* constructor */
     public authors() {
     }

     public authors(String firstname, String lastname, String contactinformation) {
          this.firstname = firstname;
          this.lastname = lastname;
          this.contactinformation = contactinformation;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_authors(authors new_authors, Connection conn) {
          try {
               String query = "INSERT INTO authors (firstname, lastname, contactinformation) values (?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_authors.getFirstname());
               statement.setString(2, new_authors.getLastname());
               statement.setString(3, new_authors.getContactinformation());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_authors(int idauthors, authors new_authors, Connection conn) {
          try {
               String query = "UPDATE authors SET firstname=?, lastname=?, contactinformation=? WHERE idauthors = '" + idauthors + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_authors.getFirstname());
               statement.setString(2, new_authors.getLastname());
               statement.setString(3, new_authors.getContactinformation());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_authors(int idauthors, Connection conn) {
          try {
               String query = "DELETE FROM authors WHERE idauthors = '" + idauthors + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_authors(int[] idauthors, Connection conn) {
          try {
               int i_idauthors;
               for (int x = 0; x < idauthors.length; x++) {
                    i_idauthors = idauthors[x];
                    boolean isHasForeignKey = function_is_idauthors_has_foreignKey(i_idauthors, conn);
                    if (isHasForeignKey) {
                    } else {
                         String queryString = "DELETE FROM authors WHERE idauthors = '" + i_idauthors + "'; ";
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
               for (int i = 0; i < authors.getData().size(); i++) {
                    System.out.println(authors.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_idauthors_has_foreignKey(int idauthors, Connection conn) {
          try {
               String query = "SELECT b_a.authors_idauthors FROM `authors` AS a , booksauthors AS b_a WHERE a.idauthors = b_a.authors_idauthors AND a.idauthors = '" + idauthors + "';";
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

     public String function_get_firstname(int idauthors, Connection conn) {
          try {
               String query = "SELECT a.firstname FROM `authors` AS a WHERE a.idauthors = '" + idauthors + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String a_firstname_rs = rs.getString("a.firstname");
                    if (a_firstname_rs == null) {
                         a_firstname_rs = "";
                    }
                    return a_firstname_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_lastname(int idauthors, Connection conn) {
          try {
               String query = "SELECT a.lastname FROM `authors` AS a WHERE a.idauthors = '" + idauthors + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String a_lastname_rs = rs.getString("a.lastname");
                    if (a_lastname_rs == null) {
                         a_lastname_rs = "";
                    }
                    return a_lastname_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_contactinformation(int idauthors, Connection conn) {
          try {
               String query = "SELECT a.contactinformation FROM `authors` AS a WHERE a.idauthors = '" + idauthors + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String a_contactinformation_rs = rs.getString("a.contactinformation");
                    if (a_contactinformation_rs == null) {
                         a_contactinformation_rs = "";
                    }
                    return a_contactinformation_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]

     public int select_all(int limitFrom, int limitTo, Connection conn) {
          authors.setData(new Vector());
          try {
               String query = "SELECT a.idauthors, a.firstname, a.lastname, a.contactinformation FROM `authors` AS a LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idbooks(int idbooks, Connection conn) {
          authors.setData(new Vector());
          try {
               String query = "SELECT a.idauthors, a.firstname, a.lastname, a.contactinformation FROM `authors` AS a , books AS b , booksauthors AS b_a WHERE b_a.books_idbooks = b.idbooks AND b_a.authors_idauthors = a.idauthors AND b.idbooks = " + idbooks + " ;";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idbooks(int idbooks, int limitFrom, int limitTo, Connection conn) {
          authors.setData(new Vector());
          try {
               String query = "SELECT a.idauthors, a.firstname, a.lastname, a.contactinformation FROM `authors` AS a , books AS b , booksauthors AS b_a WHERE b_a.books_idbooks = b.idbooks AND b_a.authors_idauthors = a.idauthors AND b.idbooks = " + idbooks + " LIMIT " + limitFrom + ", " + limitTo + ";";
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
                    int a_idauthors_rs = rs.getInt("a.idauthors");
                    String a_firstname_rs = rs.getString("a.firstname");
                    String a_lastname_rs = rs.getString("a.lastname");
                    String a_contactinformation_rs = rs.getString("a.contactinformation");

                    if (a_firstname_rs == null) {
                         a_firstname_rs = "";
                    }
                    if (a_lastname_rs == null) {
                         a_lastname_rs = "";
                    }
                    if (a_contactinformation_rs == null) {
                         a_contactinformation_rs = "";
                    }

                    Vector row = new Vector();
                    row.add(a_idauthors_rs);
                    row.add(a_firstname_rs + " " + a_lastname_rs);
                    row.add(a_contactinformation_rs);
                    authors.getData().add(row);
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
               String query = "SELECT Count(a.idauthors) as resultCount FROM `authors` AS a WHERE a.firstname LIKE '%" + search + "%' OR a.lastname LIKE '%" + search + "%' OR a.contactinformation LIKE '%" + search + "%' ;";
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

     public int select_by_search(String search, int limitFrom, int limitTo, Connection conn) {
          authors.setData(new Vector());
          try {
               String query = "SELECT a.idauthors, a.firstname, a.lastname, a.contactinformation FROM `authors` AS a WHERE a.firstname LIKE '%" + search + "%' OR a.lastname LIKE '%" + search + "%' OR a.contactinformation LIKE '%" + search + "%' LIMIT " + limitFrom + ", " + limitTo + ";";
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
                    int a_idauthors_rs = rs.getInt("a.idauthors");
                    String a_firstname_rs = rs.getString("a.firstname");
                    String a_lastname_rs = rs.getString("a.lastname");
                    String a_contactinformation_rs = rs.getString("a.contactinformation");

                    if (a_firstname_rs == null) {
                         a_firstname_rs = "";
                    }
                    if (a_lastname_rs == null) {
                         a_lastname_rs = "";
                    }
                    if (a_contactinformation_rs == null) {
                         a_contactinformation_rs = "";
                    }

                    Vector row = new Vector();
                    row.add(a_idauthors_rs);
                    row.add(a_firstname_rs + " " + a_lastname_rs);
                    row.add(a_contactinformation_rs);
                    authors.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }
}
