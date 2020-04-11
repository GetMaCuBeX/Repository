package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class bookspublishers {

     private static Vector data;
     private int books_idbooks;
     private int publishers_idpublishers;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          bookspublishers.data = data;
     }

     public int getBooks_idbooks() {
          return books_idbooks;
     }

     public void setBooks_idbooks(int books_idbooks) {
          this.books_idbooks = books_idbooks;
     }

     public int getPublishers_idpublishers() {
          return publishers_idpublishers;
     }

     public void setPublishers_idpublishers(int publishers_idpublishers) {
          this.publishers_idpublishers = publishers_idpublishers;
     }

     /* constructor */
     public bookspublishers() {
     }

     public bookspublishers(int books_idbooks, int publishers_idpublishers) {
          this.books_idbooks = books_idbooks;
          this.publishers_idpublishers = publishers_idpublishers;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_bookspublishers(bookspublishers new_bookspublishers, Connection conn) {
          try {
               String query = "INSERT INTO bookspublishers (books_idbooks, publishers_idpublishers) values (?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_bookspublishers.getBooks_idbooks());
               statement.setInt(2, new_bookspublishers.getPublishers_idpublishers());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

    public void insert_bookspublishers(int[] publishers_idpublishers, int books_idbooks, Connection conn) {
          try {
               int i_idpublishers;
               for (int x = 0; x < publishers_idpublishers.length; x++) {
                    i_idpublishers = publishers_idpublishers[x];
                    boolean isExist_idbooks_idauthors = function_is_idbooks_idpublishers_exist(books_idbooks, i_idpublishers, conn);
                    if (isExist_idbooks_idauthors) {
                    } else {
                         String query = "INSERT INTO bookspublishers (books_idbooks, publishers_idpublishers) values (?,?);";
                         PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                         statement.setInt(1, books_idbooks);
                         statement.setInt(2, i_idpublishers);
                         statement.execute();
                    }
               }
               System.out.println("Successfully Inserted.");

          } catch (Exception sqle) {
               System.err.println(sqle);
          }
     }

     
// ----------------------------------------------------------------------------- [UPDATE]
     public void update_bookspublishers(int books_idbooks, int publishers_idpublishers, bookspublishers new_bookspublishers, Connection conn) {
          try {
               String query = "UPDATE bookspublishers SET books_idbooks=?, publishers_idpublishers=? WHERE books_idbooks = '" + books_idbooks + "' AND  publishers_idpublishers = '" + publishers_idpublishers + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_bookspublishers.getBooks_idbooks());
               statement.setInt(2, new_bookspublishers.getPublishers_idpublishers());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_bookspublishers(int books_idbooks, int publishers_idpublishers, Connection conn) {
          try {
               String query = "DELETE FROM bookspublishers WHERE books_idbooks = '" + books_idbooks + "' AND publishers_idpublishers = '" + publishers_idpublishers + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_bookspublishers(int[] publishers_idpublishers, int books_idbooks, Connection conn) {
          try {

               int i_idpublishers;
               for (int x = 0; x < publishers_idpublishers.length; x++) {
                    i_idpublishers = publishers_idpublishers[x];
                    String query = "DELETE FROM bookspublishers WHERE books_idbooks = '" + books_idbooks + "' AND publishers_idpublishers = '" + i_idpublishers + "'; ";
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    statement.execute();
               }
               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DISPLAY]
     public void display() {
          try {
               for (int i = 0; i < bookspublishers.getData().size(); i++) {
                    System.out.println(bookspublishers.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_idbooks_idpublishers_exist(int idbooks, int idpublishers, Connection conn) {
          try {
               String query = "SELECT b_p.books_idbooks FROM bookspublishers AS b_p WHERE b_p.books_idbooks = '" + idbooks + "' AND b_p.publishers_idpublishers = '" + idpublishers + "';";
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
