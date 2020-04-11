package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class booksauthors {

     private static Vector data;
     private int books_idbooks;
     private int authors_idauthors;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          booksauthors.data = data;
     }

     public int getBooks_idbooks() {
          return books_idbooks;
     }

     public void setBooks_idbooks(int books_idbooks) {
          this.books_idbooks = books_idbooks;
     }

     public int getAuthors_idauthors() {
          return authors_idauthors;
     }

     public void setAuthors_idauthors(int authors_idauthors) {
          this.authors_idauthors = authors_idauthors;
     }

     /* constructor */
     public booksauthors() {
     }

     public booksauthors(int books_idbooks, int authors_idauthors) {
          this.books_idbooks = books_idbooks;
          this.authors_idauthors = authors_idauthors;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_booksauthors(booksauthors new_booksauthors, Connection conn) {
          try {
               String query = "INSERT INTO booksauthors (books_idbooks, authors_idauthors) values (?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_booksauthors.getBooks_idbooks());
               statement.setInt(2, new_booksauthors.getAuthors_idauthors());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void insert_booksauthors(int[] authors_idauthors, int books_idbooks, Connection conn) {
          try {
               int i_idauthors;
               for (int x = 0; x < authors_idauthors.length; x++) {
                    i_idauthors = authors_idauthors[x];
                    boolean isExist_idbooks_idauthors = function_is_idbooks_idauthors_exist(books_idbooks, i_idauthors, conn);
                    if (isExist_idbooks_idauthors) {
                    } else {
                         String query = "INSERT INTO booksauthors (books_idbooks, authors_idauthors) values (?,?);";
                         PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                         statement.setInt(1, books_idbooks);
                         statement.setInt(2, i_idauthors);
                         statement.execute();
                    }
               }
               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_booksauthors(int books_idbooks, int authors_idauthors, booksauthors new_booksauthors, Connection conn) {
          try {
               String query = "UPDATE booksauthors SET books_idbooks=?, authors_idauthors=? WHERE books_idbooks = '" + books_idbooks + "' AND  authors_idauthors = '" + authors_idauthors + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_booksauthors.getBooks_idbooks());
               statement.setInt(2, new_booksauthors.getAuthors_idauthors());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_booksauthors(int books_idbooks, int authors_idauthors, Connection conn) {
          try {
               String query = "DELETE FROM booksauthors WHERE books_idbooks = '" + books_idbooks + "' AND authors_idauthors = '" + authors_idauthors + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_booksauthors(int[] delete_booksauthors, int books_idbooks, Connection conn) {
          try {

               int i_idauthors;
               for (int x = 0; x < delete_booksauthors.length; x++) {
                    i_idauthors = delete_booksauthors[x];
                    String query = "DELETE FROM booksauthors WHERE books_idbooks = '" + books_idbooks + "' AND authors_idauthors = '" + i_idauthors + "'; ";
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
               for (int i = 0; i < booksauthors.getData().size(); i++) {
                    System.out.println(booksauthors.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_idbooks_idauthors_exist(int idbooks, int idauthors, Connection conn) {
          try {
               String query = "SELECT b_a.books_idbooks FROM booksauthors AS b_a WHERE b_a.books_idbooks = '" + idbooks + "' AND b_a.authors_idauthors = '" + idauthors + "';";
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
