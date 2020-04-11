package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import org.omg.PortableServer.IdUniquenessPolicy;

public class books {

     private static reserve ref_reserve = new reserve();
     private static Vector data;
     private String barcode;
     private String isbn;
     private String title;
     private int pages;
     private String description;
     private String language;
     private double cost;
     private double purchasedcost;
     private int copynumber;
     private String acquireddate;
     private int isborrowable;
     private String category_name;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          books.data = data;
     }

     public String getBarcode() {
          return barcode;
     }

     public void setBarcode(String barcode) {
          this.barcode = barcode;
     }

     public String getIsbn() {
          return isbn;
     }

     public void setIsbn(String isbn) {
          this.isbn = isbn;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public int getPages() {
          return pages;
     }

     public void setPages(int pages) {
          this.pages = pages;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getLanguage() {
          return language;
     }

     public void setLanguage(String language) {
          this.language = language;
     }

     public double getCost() {
          return cost;
     }

     public void setCost(double cost) {
          this.cost = cost;
     }

     public double getPurchasedcost() {
          return purchasedcost;
     }

     public void setPurchasedcost(double purchasedcost) {
          this.purchasedcost = purchasedcost;
     }

     public int getCopynumber() {
          return copynumber;
     }

     public void setCopynumber(int copynumber) {
          this.copynumber = copynumber;
     }

     public String getAcquireddate() {
          return acquireddate;
     }

     public void setAcquireddate(String acquireddate) {
          this.acquireddate = acquireddate;
     }

     public int getIsborrowable() {
          return isborrowable;
     }

     public void setIsborrowable(int isborrowable) {
          this.isborrowable = isborrowable;
     }

     public String getCategory_name() {
          return category_name;
     }

     public void setCategory_name(String category_name) {
          this.category_name = category_name;
     }

     /* constructor */
     public books() {
     }

     public books(String barcode, String isbn, String title, int pages, String description, String language, double cost, double purchasedcost, int copynumber, String acquireddate, int isborrowable, String category_name) {
          this.barcode = barcode;
          this.isbn = isbn;
          this.title = title;
          this.pages = pages;
          this.description = description;
          this.language = language;
          this.cost = cost;
          this.purchasedcost = purchasedcost;
          this.copynumber = copynumber;
          this.acquireddate = acquireddate;
          this.isborrowable = isborrowable;
          this.category_name = category_name;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_books(books new_books, Connection conn) {
          try {
               String query = "INSERT INTO books (barcode, isbn, title, pages, description, language, cost, purchasedcost, copynumber, acquireddate, isborrowable, category_name) values (?,?,?,?,?,?,?,?,?,?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_books.getBarcode());
               statement.setString(2, new_books.getIsbn());
               statement.setString(3, new_books.getTitle());
               statement.setInt(4, new_books.getPages());
               statement.setString(5, new_books.getDescription());
               statement.setString(6, new_books.getLanguage());
               statement.setDouble(7, new_books.getCost());
               statement.setDouble(8, new_books.getPurchasedcost());
               statement.setInt(9, new_books.getCopynumber());
               statement.setString(10, new_books.getAcquireddate());
               statement.setInt(11, new_books.getIsborrowable());
               statement.setString(12, new_books.getCategory_name());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_books(int idbooks, books new_books, Connection conn) {
          try {
               String query = "UPDATE books SET barcode=?, isbn=?, title=?, pages=?, description=?, language=?, cost=?, purchasedcost=?, copynumber=?, acquireddate=?, isborrowable=?, category_name=? WHERE idbooks = '" + idbooks + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_books.getBarcode());
               statement.setString(2, new_books.getIsbn());
               statement.setString(3, new_books.getTitle());
               statement.setInt(4, new_books.getPages());
               statement.setString(5, new_books.getDescription());
               statement.setString(6, new_books.getLanguage());
               statement.setDouble(7, new_books.getCost());
               statement.setDouble(8, new_books.getPurchasedcost());
               statement.setInt(9, new_books.getCopynumber());
               statement.setString(10, new_books.getAcquireddate());
               statement.setInt(11, new_books.getIsborrowable());
               statement.setString(12, new_books.getCategory_name());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_books(int idbooks, Connection conn) {
          try {
               String query = "DELETE FROM books WHERE idbooks = '" + idbooks + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_books(int[] idbooks, Connection conn) {
          try {

               int i_idbooks;
               for (int x = 0; x < idbooks.length; x++) {
                    i_idbooks = idbooks[x];
                    String query = "DELETE FROM books WHERE idbooks = '" + i_idbooks + "'; ";
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
               for (int i = 0; i < books.getData().size(); i++) {
                    System.out.println(books.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_barcode_exist(String barcode, Connection conn) {
          try {
               String query = "SELECT b.barcode FROM books AS b WHERE b.barcode = '" + barcode + "';";
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

     public boolean function_is_barcode_exist_notLike(String barcode, String notLike_idbooks, Connection conn) {
          try {
               String query = "SELECT b.barcode FROM books AS b WHERE b.barcode = '" + barcode + "' AND b.idbooks NOT LIKE '" + notLike_idbooks + "';";
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

     public boolean function_is_isbn_exist(String isbn, Connection conn) {
          try {
               String query = "SELECT b.isbn FROM books AS b WHERE b.isbn = '" + isbn + "';";
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

     public boolean function_is_isbn_exist_notLike(String isbn, String notLike_idbooks, Connection conn) {
          try {
               String query = "SELECT b.isbn FROM books AS b WHERE b.isbn = '" + isbn + "' AND b.idbooks NOT LIKE '" + notLike_idbooks + "';";
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

     public boolean function_is_barcode_isbn_exist(String barcode, String isbn, Connection conn) {
          try {
               String query = "SELECT b.isbn FROM books AS b WHERE b.barcode = '" + barcode + "' AND b.isbn = '" + isbn + "';";
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

     public boolean function_is_barcode_isbn_exist_notLike(String barcode, String isbn, int idbooks, Connection conn) {
          try {
               String query = "SELECT b.isbn FROM books AS b WHERE b.barcode = '" + barcode + "' AND b.isbn = '" + isbn + "' AND b.idbooks NOT LIKE '" + idbooks + "';";
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

     public int function_get_idbooks(String barcode, String isbn, Connection conn) {
          try {
               String query = "SELECT b.idbooks FROM books AS b WHERE b.barcode = '" + barcode + "' AND b.isbn = '" + isbn + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int b_idbooks_rs = rs.getInt("b.idbooks");
                    return b_idbooks_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public String function_get_barcode(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.barcode FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String b_barcode_rs = rs.getString("b.barcode");
                    return b_barcode_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public int function_get_idbooks(String isbn, Connection conn) {
          try {
               String query = "SELECT b.idbooks FROM books AS b WHERE b.isbn = '" + isbn + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int b_idbooks_rs = rs.getInt("b.idbooks");
                    return b_idbooks_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public String function_get_isbn(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.isbn FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String b_isbn_rs = rs.getString("b.isbn");
                    return b_isbn_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_title(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.title FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String b_title_rs = rs.getString("b.title");
                    return b_title_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_description(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.description FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String b_description_rs = rs.getString("b.description");
                    return b_description_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_language(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.language FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String b_language_rs = rs.getString("b.language");
                    return b_language_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public double function_get_cost(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.cost FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    double b_cost_rs = rs.getDouble("b.cost");
                    return b_cost_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public double function_get_purchasedcost(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.purchasedcost FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    double b_purchasedcost_rs = rs.getDouble("b.purchasedcost");
                    return b_purchasedcost_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public int function_get_pages(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.pages FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int b_pages_rs = rs.getInt("b.pages");
                    return b_pages_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public int function_get_copynumber(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.copynumber FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int b_copynumber_rs = rs.getInt("b.copynumber");
                    return b_copynumber_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public java.util.Date function_get_acquireddate(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.acquireddate FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    java.util.Date b_acquireddate_rs = rs.getDate("b.acquireddate");
                    return b_acquireddate_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public int function_get_isborrowable(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.isborrowable FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int b_isborrowable_rs = rs.getInt("b.isborrowable");
                    return b_isborrowable_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public String function_get_category_name(int idbooks, Connection conn) {
          try {
               String query = "SELECT b.category_name FROM books AS b WHERE b.idbooks = '" + idbooks + "' ;";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String b_category_name_rs = rs.getString("b.category_name");
                    return b_category_name_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }
     
     /**/
     public boolean function_is_total_reserved_greater_than_or_equal_to_the_remaining_copy_of_the_books (int idbooks, Connection conn) {
              try {
                    int remaining_copy = ref_borrow.function_get_the_remaining_copies_of_the_idbooks(idbooks, conn);
                    int sum_copies_of_reservation = ref_reserve.administrator_sum_of_total_copies_of_information_by_idbooks_reserve_history_and_not_expired_and_status_is_reserved(idbooks, conn);
                    if(sum_copies_of_reservation>=remaining_copy){
                         return true;
                    }
          } catch (Exception e) {
               System.err.println(e);
          }
          return false;
     }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
     public int count_select_all(Connection conn) {
          try {
               String query = "SELECT Count(b.idbooks) as resultCount FROM books AS b;";
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
          books.setData(new Vector());
          try {
               // String query = "SELECT b.idbooks, b.barcode, b.isbn, b.title, b.pages, b.description, b.`language`, b.cost, b.purchasedcost, b.copynumber, b.acquireddate, b.isborrowable, b.category_name FROM books AS b , subjects AS s , bookssubjects AS b_s , `authors` AS a , booksauthors AS b_a , category AS c, publishers AS p WHERE b_s.books_idbooks = b.idbooks AND b_s.subjects_idsubjects = s.idsubjects AND b_a.books_idbooks = b.idbooks AND b_a.authors_idauthors = a.idauthors AND c.`name` = b.category_name AND p.idpublishers = b.publishers_idpublishers LIMIT " + limitFrom + ", " + limitTo + ";";
               String query = "SELECT b.idbooks, b.barcode, b.isbn, b.title, b.pages, b.description, b.`language`, b.cost, b.purchasedcost, b.copynumber, b.acquireddate, b.isborrowable, b.category_name FROM books AS b LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idpublishers(int idpublishers, int limitFrom, int limitTo, Connection conn) {
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, b.barcode, b.isbn, b.title, b.pages, b.description, b.`language`, b.cost, b.purchasedcost, b.copynumber, b.acquireddate, b.isborrowable, b.category_name FROM books AS b , publishers AS p , bookspublishers AS b_p WHERE b_p.books_idbooks = b.idbooks AND b_p.publishers_idpublishers = p.idpublishers AND p.idpublishers = " + idpublishers + " LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idsubjects(int idsubjects, int limitFrom, int limitTo, Connection conn) {
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, b.barcode, b.isbn, b.title, b.pages, b.description, b.`language`, b.cost, b.purchasedcost, b.copynumber, b.acquireddate, b.isborrowable, b.category_name FROM books AS b , subjects AS s , bookssubjects AS b_s WHERE b_s.subjects_idsubjects = s.idsubjects AND b_s.books_idbooks = b.idbooks AND s.idsubjects = " + idsubjects + " LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idauthors(int idauthors, int limitFrom, int limitTo, Connection conn) {
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, b.barcode, b.isbn, b.title, b.pages, b.description, b.`language`, b.cost, b.purchasedcost, b.copynumber, b.acquireddate, b.isborrowable, b.category_name FROM books AS b , `authors` AS a , booksauthors AS b_a WHERE b_a.books_idbooks = b.idbooks AND b_a.authors_idauthors = a.idauthors AND a.idauthors = " + idauthors + " LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     /* search */
     public int count_select_search(String search, Connection conn) {
          try {
               String query = "SELECT Count(b.idbooks) as resultCount FROM books AS b WHERE b.barcode LIKE '%" + search + "%' OR b.isbn LIKE '%" + search + "%' OR b.title LIKE '%" + search + "%' OR b.description LIKE '%" + search + "%' OR b.`language` LIKE '%" + search + "%' OR b.category_name LIKE '%" + search + "%';";
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

     public int select_all_by_search(String search, int limitFrom, int limitTo, Connection conn) {
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, b.barcode, b.isbn, b.title, b.pages, b.description, b.`language`, b.cost, b.purchasedcost, b.copynumber, b.acquireddate, b.isborrowable, b.category_name FROM books AS b WHERE b.barcode LIKE '%" + search + "%' OR b.isbn LIKE '%" + search + "%' OR b.title LIKE '%" + search + "%' OR b.description LIKE '%" + search + "%' OR b.`language` LIKE '%" + search + "%' OR b.category_name LIKE '%" + search + "%' LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }
     private borrow ref_borrow = new borrow();

     private int executeQuery_all(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int b_idbooks_rs = rs.getInt("b.idbooks");
                    String b_barcode_rs = rs.getString("b.barcode");
                    String b_isbn_rs = rs.getString("b.isbn");
                    String b_title_rs = rs.getString("b.title");
                    String b_pages_rs = rs.getString("b.pages");
                    String b_description_rs = rs.getString("b.description");
                    String b_language_rs = rs.getString("b.language");
                    double b_cost_rs = rs.getDouble("b.cost");
                    double b_purchasedcost_rs = rs.getDouble("b.purchasedcost");
                    int b_copynumber_rs = rs.getInt("b.copynumber");
                    java.util.Date b_acquireddate_rs = rs.getDate("b.acquireddate");
                    boolean b_isborrowable_rs = rs.getBoolean("b.isborrowable");
                    String b_category_name_rs = rs.getString("b.category_name");
                    int remaining_copy = ref_borrow.function_get_the_remaining_copies_of_the_idbooks(b_idbooks_rs, conn);

                    Vector row = new Vector();
                    row.add(b_idbooks_rs);
                    row.add(b_barcode_rs);
                    row.add(b_isbn_rs);
                    row.add(b_title_rs);
                    row.add(b_pages_rs);
                    row.add(b_description_rs);
                    row.add(b_language_rs);
                    row.add(b_cost_rs);
                    row.add(b_purchasedcost_rs);
                    row.add(b_copynumber_rs);
                    row.add(remaining_copy);
                    row.add(b_acquireddate_rs);
                    row.add(b_isborrowable_rs);
                    row.add(b_category_name_rs);
                    books.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }

     /**/
     public void select_all_by_search_idauthors(int idauthors, Connection conn) {
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, b.barcode, b.isbn, b.title, b.pages, b.description, b.`language`, b.cost, b.purchasedcost, b.copynumber, b.acquireddate, b.isborrowable, b.category_name FROM books AS b , `authors` AS a , booksauthors AS b_a WHERE b.idbooks = b_a.books_idbooks AND a.idauthors = b_a.authors_idauthors AND a.idauthors = '" + idauthors + "';";
               executeQuery_all(query, conn);
          } catch (Exception e) {
               System.err.println(e);
          }
     }

     public void select_all_by_search_idpublishers(int idpublishers, Connection conn) {
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, b.barcode, b.isbn, b.title, b.pages, b.description, b.`language`, b.cost, b.purchasedcost, b.copynumber, b.acquireddate, b.isborrowable, b.category_name FROM books AS b , publishers AS p , bookspublishers AS b_p WHERE b.idbooks = b_p.books_idbooks AND p.idpublishers = b_p.publishers_idpublishers AND p.idpublishers = '" + idpublishers + "';";
               executeQuery_all(query, conn);
          } catch (Exception e) {
               System.err.println(e);
          }
     }

     /* guest */
     public int guest_count_select_by_search_in_books(String search, Connection conn) {
          try {
               String query = "SELECT Count(b.idbooks) as resultCount FROM books AS b WHERE b.barcode LIKE '" + search + "' OR b.title LIKE '%" + search + "%' OR b.description LIKE '%" + search + "%' OR b.`language` LIKE '%" + search + "%';";
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

     public int guest_select_books_information_by_search_in_books(String search, int limitFrom, int limitTo, Connection conn) {
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, (SELECT p.`name` AS p_name  FROM publishers AS p , bookspublishers AS b_p WHERE p.idpublishers = b_p.publishers_idpublishers AND b_p.books_idbooks = b.idbooks LIMIT 1 ) AS p_name, (SELECT CONCAT(a.firstname,\" \",a.lastname) AS a_name FROM `authors` AS a , booksauthors AS b_a WHERE a.idauthors = b_a.authors_idauthors AND b_a.books_idbooks = b.idbooks LIMIT 1) AS a_name, b.title, b.pages, b.description, b.`language`, b.copynumber, b.isborrowable, b.category_name FROM books AS b WHERE b.barcode LIKE '" + search + "' OR b.title LIKE '%" + search + "%' OR b.description LIKE '%" + search + "%' OR b.`language` LIKE '%" + search + "%' LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = guest_executeQuery(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int guest_count_select_by_search_in_category(String search, Connection conn) {
          try {
               String query = "SELECT Count(b.idbooks) as resultCount FROM books AS b WHERE b.category_name LIKE '%" + search + "%';";
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

     public int guest_select_books_information_by_search_in_category(String search, int limitFrom, int limitTo, Connection conn) {
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, (SELECT p.`name` AS p_name  FROM publishers AS p , bookspublishers AS b_p WHERE p.idpublishers = b_p.publishers_idpublishers AND b_p.books_idbooks = b.idbooks LIMIT 1 ) AS p_name, (SELECT CONCAT(a.firstname,\" \",a.lastname) AS a_name FROM `authors` AS a , booksauthors AS b_a WHERE a.idauthors = b_a.authors_idauthors AND b_a.books_idbooks = b.idbooks LIMIT 1) AS a_name, b.title, b.pages, b.description, b.`language`, b.copynumber, b.isborrowable, b.category_name FROM books AS b WHERE b.category_name LIKE '%" + search + "%' LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = guest_executeQuery(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     /**/
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
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, a.idauthors, (SELECT p.`name` AS p_name  FROM publishers AS p , bookspublishers AS b_p WHERE p.idpublishers = b_p.publishers_idpublishers AND b_p.books_idbooks = b.idbooks LIMIT 1 ) AS p_name, CONCAT(IFNULL(a.firstname,''),\" \", IFNULL(a.lastname,'') ) AS a_name, b.title, b.pages, b.description, b.`language`, b.copynumber, b.isborrowable, b.category_name FROM `authors` AS a INNER JOIN booksauthors AS b_a ON a.idauthors = b_a.authors_idauthors INNER JOIN books AS b ON b.idbooks = b_a.books_idbooks WHERE a.firstname LIKE '%" + search + "%' OR a.lastname LIKE '%" + search + "%' OR b.title LIKE '%" + search + "%' OR b.description LIKE '%" + search + "%' OR b.language LIKE '%" + search + "%' OR b.category_name LIKE '%" + search + "%' ORDER BY a.firstname ASC LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = guest_executeQuery(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;

     }
     /**/

     public int guest_count_select_by_search_int_publishers(String search, Connection conn) {
          try {
               String query = "SELECT COUNT(b.idbooks) as resultCount FROM publishers AS p INNER JOIN bookspublishers AS b_p ON p.idpublishers = b_p.publishers_idpublishers INNER JOIN books AS b ON b.idbooks = b_p.publishers_idpublishers WHERE p.`name` LIKE '%" + search + "%' OR b.title LIKE '%" + search + "%' OR b.description LIKE '%" + search + "%' OR b.language LIKE '%" + search + "%' OR b.category_name LIKE '%" + search + "%' ORDER BY p.`name` ASC;";
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

     public int guest_select_books_information_by_search_in_publishers(String search, int limitFrom, int limitTo, Connection conn) {
          books.setData(new Vector());
          try {
               String query = "SELECT b.idbooks, IFNULL(p.`name`,'') AS p_name, (SELECT CONCAT(a.firstname,\" \",a.lastname) AS a_name FROM `authors` AS a , booksauthors AS b_a WHERE a.idauthors = b_a.authors_idauthors AND b_a.books_idbooks = b.idbooks LIMIT 1) AS a_name, b.title, b.pages, b.description, b.`language`, b.copynumber, b.isborrowable, b.category_name FROM publishers AS p INNER JOIN bookspublishers AS b_p ON p.idpublishers = b_p.publishers_idpublishers INNER JOIN books AS b ON b.idbooks = b_p.publishers_idpublishers WHERE p.`name` LIKE '%" + search + "%' OR b.title LIKE '%" + search + "%' OR b.description LIKE '%" + search + "%' OR b.language LIKE '%" + search + "%' OR b.category_name LIKE '%" + search + "%' ORDER BY p.`name` ASC LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = guest_executeQuery(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;

     }

     private int guest_executeQuery(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int b_idbooks_rs = rs.getInt("b.idbooks");
                    String p_name_rs = rs.getString("p_name");
                    String a_name_rs = rs.getString("a_name");
//                    String b_barcode_rs = rs.getString("b.barcode");
//                    String b_isbn_rs = rs.getString("b.isbn");
                    String b_title_rs = rs.getString("b.title");
                    String b_pages_rs = rs.getString("b.pages");
                    String b_description_rs = rs.getString("b.description");
                    String b_language_rs = rs.getString("b.language");
//                    double b_cost_rs = rs.getDouble("b.cost");
//                    double b_purchasedcost_rs = rs.getDouble("b.purchasedcost");
                    int b_copynumber_rs = rs.getInt("b.copynumber");
//                    java.util.Date b_acquireddate_rs = rs.getDate("b.acquireddate");
                    boolean b_isborrowable_rs = rs.getBoolean("b.isborrowable");
                    String b_category_name_rs = rs.getString("b.category_name");
                    int remaining_copy = ref_borrow.function_get_the_remaining_copies_of_the_idbooks(b_idbooks_rs, conn);
                    int sum_copies_of_reservation = ref_reserve.administrator_sum_of_total_copies_of_information_by_idbooks_reserve_history_and_not_expired_and_status_is_reserved(b_idbooks_rs, conn);

                    int in_books = remaining_copy;
                    int out_books = b_copynumber_rs - remaining_copy;
                    if (out_books < 0) {
                         out_books = 0;
                    }
                    
                    Vector row = new Vector();
                    row.add(b_idbooks_rs);
                    row.add(p_name_rs);
                    row.add(a_name_rs);
                    row.add(b_title_rs);
                    row.add(b_pages_rs);
                    row.add(b_description_rs);
                    row.add(b_language_rs);
//                    row.add(b_cost_rs);
//                    row.add(b_purchasedcost_rs);
                    row.add(b_copynumber_rs);
                    row.add(out_books);
                    row.add(in_books);
                    row.add(sum_copies_of_reservation);
//                    row.add(b_acquireddate_rs);
                    row.add(b_isborrowable_rs);
                    row.add(b_category_name_rs);
                    books.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);

          }
          return resultCount;
     }
     /**/
}
