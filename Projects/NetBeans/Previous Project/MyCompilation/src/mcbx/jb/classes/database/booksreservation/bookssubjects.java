package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class bookssubjects {

     private static Vector data;
     private int books_idbooks;
     private int subjects_idsubjects;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          bookssubjects.data = data;
     }

     public int getBooks_idbooks() {
          return books_idbooks;
     }

     public void setBooks_idbooks(int books_idbooks) {
          this.books_idbooks = books_idbooks;
     }

     public int getSubjects_idsubjects() {
          return subjects_idsubjects;
     }

     public void setSubjects_idsubjects(int subjects_idsubjects) {
          this.subjects_idsubjects = subjects_idsubjects;
     }

     /* constructor */
     public bookssubjects() {
     }

     public bookssubjects(int books_idbooks, int subjects_idsubjects) {
          this.books_idbooks = books_idbooks;
          this.subjects_idsubjects = subjects_idsubjects;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_bookssubjects(bookssubjects new_bookssubjects, Connection conn) {
          try {
               String query = "INSERT INTO bookssubjects (books_idbooks, subjects_idsubjects) values (?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_bookssubjects.getBooks_idbooks());
               statement.setInt(2, new_bookssubjects.getSubjects_idsubjects());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void insert_bookssubjects(int[] subjects_idsubjects, int books_idbooks, Connection conn) {
          try {

               int i_idsubjects;
               for (int x = 0; x < subjects_idsubjects.length; x++) {
                    i_idsubjects = subjects_idsubjects[x];
                    boolean isExist_idbooks_idsubjects = function_is_idbooks_idsubjects_exist(books_idbooks, i_idsubjects, conn);
                    if (isExist_idbooks_idsubjects) {
                    } else {
                         String query = "INSERT INTO bookssubjects (books_idbooks, subjects_idsubjects) values (?,?);";
                         PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                         statement.setInt(1, books_idbooks);
                         statement.setInt(2, i_idsubjects);
                         statement.execute();
                    }
               }
               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_bookssubjects(int books_idbooks, int subjects_idsubjects, bookssubjects new_bookssubjects, Connection conn) {
          try {
               String query = "UPDATE bookssubjects SET books_idbooks=?, subjects_idsubjects=? WHERE books_idbooks = '" + books_idbooks + "' AND  subjects_idsubjects = '" + subjects_idsubjects + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_bookssubjects.getBooks_idbooks());
               statement.setInt(2, new_bookssubjects.getSubjects_idsubjects());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_bookssubjects(int books_idbooks, int subjects_idsubjects, Connection conn) {
          try {
               String query = "DELETE FROM bookssubjects WHERE books_idbooks = '" + books_idbooks + "' AND subjects_idsubjects = '" + subjects_idsubjects + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_bookssubjects(int[] subjects_idsubjects, int books_idbooks, Connection conn) {
          try {

               int i_idsubjects;
               for (int x = 0; x < subjects_idsubjects.length; x++) {
                    i_idsubjects = subjects_idsubjects[x];
                    String query = "DELETE FROM bookssubjects WHERE books_idbooks = '" + books_idbooks + "' AND subjects_idsubjects = '" + i_idsubjects + "'; ";
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
               for (int i = 0; i < bookssubjects.getData().size(); i++) {
                    System.out.println(bookssubjects.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }
// ----------------------------------------------------------------------------- [RETURN VALUES]

     public boolean function_is_idbooks_idsubjects_exist(int idbooks, int idsubjects, Connection conn) {
          try {
               String query = "SELECT b_s.books_idbooks FROM bookssubjects AS b_s WHERE b_s.books_idbooks = '" + idbooks + "' AND b_s.subjects_idsubjects = '" + idsubjects + "';";
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
