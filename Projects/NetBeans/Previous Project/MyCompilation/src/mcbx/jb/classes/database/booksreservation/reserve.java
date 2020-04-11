package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import mcbx.jb.classes.mycollection.MyFunctions;

public class reserve {

     private static MyFunctions ref_MyFunctions = new MyFunctions();
     private static Vector data;
     private int members_idmembers;
     private int books_idbooks;
     private String reserveddate;
     private String reservedlimitdate;
     private int copies;
     private String notes;
     private String status;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          reserve.data = data;
     }

     public int getMembers_idmembers() {
          return members_idmembers;
     }

     public void setMembers_idmembers(int members_idmembers) {
          this.members_idmembers = members_idmembers;
     }

     public int getBooks_idbooks() {
          return books_idbooks;
     }

     public void setBooks_idbooks(int books_idbooks) {
          this.books_idbooks = books_idbooks;
     }

     public String getReserveddate() {
          return reserveddate;
     }

     public void setReserveddate(String reserveddate) {
          this.reserveddate = reserveddate;
     }

     public String getReservedlimitdate() {
          return reservedlimitdate;
     }

     public void setReservedlimitdate(String reservedlimitdate) {
          this.reservedlimitdate = reservedlimitdate;
     }

     public int getCopies() {
          return copies;
     }

     public void setCopies(int copies) {
          this.copies = copies;
     }

     public String getNotes() {
          return notes;
     }

     public void setNotes(String notes) {
          this.notes = notes;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     /* constructor */
     public reserve() {
     }

     public reserve(int members_idmembers, int books_idbooks, String reserveddate, String reservedlimitdate, int copies, String notes, String status) {
          this.members_idmembers = members_idmembers;
          this.books_idbooks = books_idbooks;
          this.reserveddate = reserveddate;
          this.reservedlimitdate = reservedlimitdate;
          this.copies = copies;
          this.notes = notes;
          this.status = status;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_reserve(reserve new_reserve, Connection conn) {
          try {
               String query = "INSERT INTO reserve (members_idmembers, books_idbooks, reserveddate, reservedlimitdate, copies, notes, status) values (?,?,?,?,?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_reserve.getMembers_idmembers());
               statement.setInt(2, new_reserve.getBooks_idbooks());
               statement.setString(3, new_reserve.getReserveddate());
               statement.setString(4, new_reserve.getReservedlimitdate());
               statement.setInt(5, new_reserve.getCopies());
               statement.setString(6, new_reserve.getNotes());
               statement.setString(7, "Reserved");
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_reserve(int idreserve, reserve new_reserve, Connection conn) {
          try {
               String query = "UPDATE reserve SET members_idmembers=?, books_idbooks=?, reserveddate=?, reservedlimitdate=?, copies=?, notes=?, status=? WHERE idreserve = '" + idreserve + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setInt(1, new_reserve.getMembers_idmembers());
               statement.setInt(2, new_reserve.getBooks_idbooks());
               statement.setString(3, new_reserve.getReserveddate());
               statement.setString(4, new_reserve.getReservedlimitdate());
               statement.setInt(5, new_reserve.getCopies());
               statement.setString(6, new_reserve.getNotes());
               statement.setString(7, new_reserve.getStatus());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_reserve_renew_date(int idreserve, String reserveddate, String reservedlimitdate, Connection conn) {
          try {
               String query = "UPDATE reserve SET reserveddate=?, reservedlimitdate=? WHERE idreserve = '" + idreserve + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, reserveddate);
               statement.setString(2, reservedlimitdate);
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_reserve_status_to_canceled(int idreserve, Connection conn) {
          try {
               String query = "UPDATE reserve SET status=? WHERE idreserve = '" + idreserve + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, "Canceled");
               statement.execute();
               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_reserve_status_to_borrowed(int idreserve, Connection conn) {
          try {
               String query = "UPDATE reserve SET status=? WHERE idreserve = '" + idreserve + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, "Borrowed");
               statement.execute();
               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void update_reserve_status_to_canceled(int[] idreserve, Connection conn) {
          try {
               int i_idreserve;
               for (int x = 0; x < idreserve.length; x++) {
                    i_idreserve = idreserve[x];
                    String query = "UPDATE reserve SET status=? WHERE idreserve = '" + i_idreserve + "'";
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    statement.setString(1, "Canceled");
                    statement.execute();
                    System.out.println("Successfully Canceled.");
               }

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_reserve(int idreserve, Connection conn) {
          try {
               String query = "DELETE FROM reserve WHERE idreserve = '" + idreserve + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_reserve(int[] idreserve, Connection conn) {
          try {
               int i_idreserve;
               for (int x = 0; x < idreserve.length; x++) {
                    i_idreserve = idreserve[x];
                    String query = "DELETE FROM reserve WHERE idreserve = '" + i_idreserve + "'; ";
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
               for (int i = 0; i < reserve.getData().size(); i++) {
                    System.out.println(reserve.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_idmembers_idbooks_exist(int idmembers, int idbooks, Connection conn) {
          try {
               String query = "SELECT r.members_idmembers FROM reserve AS r WHERE r.members_idmembers = '" + idmembers + "' AND r.books_idbooks = '" + idbooks + "';";
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

     public int funtion_get_idbooks_by_idreserve(int idreserve, Connection conn) {
          try {
               String query = "SELECT r.books_idbooks FROM reserve AS r WHERE r.idreserve = '" + idreserve + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int r_books_idbooks_rs = rs.getInt("r.books_idbooks");
                    return r_books_idbooks_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

          public int funtion_get_members_idmembers_by_idreserve(int idreserve, Connection conn) {
          try {
               String query = "SELECT r.members_idmembers FROM reserve AS r WHERE r.idreserve = '" + idreserve + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int r_members_idmembers_rs = rs.getInt("r.members_idmembers");
                    return r_members_idmembers_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     
     
     
     public int funtion_get_idmember_by_idreserve(int idreserve, Connection conn) {
          try {
               String query = "SELECT r.members_idmembers FROM reserve AS r WHERE r.idreserve = '" + idreserve + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int r_members_idmembers_rs = rs.getInt("r.members_idmembers");
                    return r_members_idmembers_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public java.util.Date function_get_reserveddate(int idmembers, int idbooks, Connection conn) {
          try {
               String query = "SELECT r.reserveddate FROM reserve AS r WHERE r.members_idmembers = '" + idmembers + "' AND r.books_idbooks = '" + idbooks + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    java.util.Date r_reserveddate_rs = rs.getDate("br.reserveddate");
                    return r_reserveddate_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public java.util.Date function_get_reservedlimitdate(int idmembers, int idbooks, Connection conn) {
          try {
               String query = "SELECT r.reservedlimitdate FROM reserve AS r WHERE r.members_idmembers = '" + idmembers + "' AND r.books_idbooks = '" + idbooks + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    java.util.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    return r_reservedlimitdate_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public int function_get_copies(int idmembers, int idbooks, Connection conn) {
          try {
               String query = "SELECT r.copies FROM reserve AS r WHERE r.members_idmembers = '" + idmembers + "' AND r.books_idbooks = '" + idbooks + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int r_copies_rs = rs.getInt("r.copies");
                    return r_copies_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public String function_get_notes(int idmembers, int idbooks, Connection conn) {
          try {
               String query = "SELECT r.notes FROM reserve AS r WHERE r.members_idmembers = '" + idmembers + "' AND r.books_idbooks = '" + idbooks + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String r_notes_rs = rs.getString("r.notes");
                    return r_notes_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_status(int idmembers, int idbooks, Connection conn) {
          try {
               String query = "SELECT r.status FROM reserve AS r WHERE r.members_idmembers = '" + idmembers + "' AND r.books_idbooks = '" + idbooks + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String r_status_rs = rs.getString("r.status");
                    return r_status_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     /**/
     public boolean function_is_idmembers_can_reserve_again_to_this_idbook(int idmembers, int idbooks, Connection conn) {
          try {
               String query = "SELECT r.reserveddate, r.reservedlimitdate FROM books AS b , reserve AS r WHERE b.idbooks = r.books_idbooks AND r.members_idmembers = '" + idmembers + "' AND r.books_idbooks = '" + idbooks + "' AND r.status = 'Reserved';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    java.sql.Date r_creserveddate_rs = rs.getDate("r.reserveddate");
                    java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                    boolean isExpired_Reservation = isExpired_Between(currentDate, r_creserveddate_rs, r_reservedlimitdate_rs, conn);

                    if (isExpired_Reservation) {
                         return true; // idmembers cannot reserve this book again because it is not expired yet
                    } else {
                         return false;
                    }
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return true;
     }

     public int function_get_count_all_reservation_of_idmembers_of_this_day(int idmembers, Connection conn) {
          try {
               java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
               String str_currentDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
               String query = "SELECT Count(r.idreserve) r_idreserve FROM reserve AS r WHERE r.reserveddate = '" + str_currentDate + "' AND r.members_idmembers = '" + idmembers + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int r_idreserve_rs = rs.getInt("r_idreserve");
                    return r_idreserve_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
     public int count_select_all(Connection conn) {
          try {
               String query = "SELECT Count(r.members_idmembers) as resultCount FROM reserve AS r;";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int r_resultCount_rs = rs.getInt("resultCount");
                         return r_resultCount_rs;
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

     public int count_select_all_by_idmembers(int members_idmembers, Connection conn) {
          try {
               String query = "SELECT Count(r.members_idmembers) as resultCount FROM reserve AS r WHERE r.members_idmembers = " + members_idmembers + ";";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int r_resultCount_rs = rs.getInt("resultCount");
                         return r_resultCount_rs;
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

     public int count_select_all_by_idbooks(int books_idbooks, Connection conn) {
          try {
               String query = "SELECT Count(r.members_idmembers) as resultCount FROM reserve AS r WHERE r.books_idbooks = " + books_idbooks + ";";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int r_resultCount_rs = rs.getInt("resultCount");
                         return r_resultCount_rs;
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

     public int count_select_all_by_idmembers_idbooks(int members_idmembers, int books_idbooks, Connection conn) {
          try {
               String query = "SELECT Count(r.members_idmembers) as resultCount FROM reserve AS r WHERE r.members_idmembers = " + members_idmembers + " AND r.books_idbooks = " + books_idbooks + ";";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int r_resultCount_rs = rs.getInt("resultCount");
                         return r_resultCount_rs;
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
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.members_idmembers, r.books_idbooks, r.reserveddate, r.reservedlimitdate, r.copies, r.notes, r.`status` FROM reserve AS r LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idmembers(int members_idmembers, int limitFrom, int limitTo, Connection conn) {
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.members_idmembers, r.books_idbooks, r.reserveddate, r.reservedlimitdate, r.copies, r.notes, r.`status` FROM reserve AS r WHERE r.members_idmembers = " + members_idmembers + " LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idbooks(int books_idbooks, int limitFrom, int limitTo, Connection conn) {
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.members_idmembers, r.books_idbooks, r.reserveddate, r.reservedlimitdate, r.copies, r.notes, r.`status` FROM reserve AS r WHERE r.books_idbooks = " + books_idbooks + " LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_all(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     public int select_all_by_idmembers_idbooks(int members_idmembers, int books_idbooks, int limitFrom, int limitTo, Connection conn) {
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.members_idmembers, r.books_idbooks, r.reserveddate, r.reservedlimitdate, r.copies, r.notes, r.`status` FROM reserve AS r WHERE r.members_idmembers = " + members_idmembers + " AND r.books_idbooks = " + books_idbooks + " LIMIT " + limitFrom + ", " + limitTo + ";";
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
                    int r_members_idmembers_rs = rs.getInt("r.members_idmembers");
                    int r_books_idbooks_rs = rs.getInt("r.books_idbooks");
                    java.util.Date r_reserveddate_rs = rs.getDate("r.reserveddate");
                    java.util.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    int r_copies_rs = rs.getInt("r.copies");
                    String r_notes_rs = rs.getString("r.notes");
                    String r_status_rs = rs.getString("r.status");

                    Vector row = new Vector();
                    row.add(r_members_idmembers_rs);
                    row.add(r_books_idbooks_rs);
                    row.add(r_reserveddate_rs);
                    row.add(r_reservedlimitdate_rs);
                    row.add(r_copies_rs);
                    row.add(r_notes_rs);
                    row.add(r_status_rs);
                    reserve.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }

     /**/
     public int count_information_by_idmembers(int members_idmembers, Connection conn) {
          try {
               String query = "SELECT Count(r.members_idmembers) as resultCount FROM reserve AS r , members AS m , books AS b WHERE r.members_idmembers = m.idmembers AND r.books_idbooks = b.idbooks AND m.idmembers = '" + members_idmembers + "';";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int r_resultCount_rs = rs.getInt("resultCount");
                         return r_resultCount_rs;
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

     public int select_information_by_idmembers(int members_idmembers, int limitFrom, int limitTo, Connection conn) {
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.idreserve, m.idnumber, b.barcode, b.isbn, b.title, r.reserveddate, r.reservedlimitdate, r.copies, r.notes, r.`status` FROM reserve AS r , members AS m , books AS b WHERE r.members_idmembers = m.idmembers AND r.books_idbooks = b.idbooks AND m.idmembers = '" + members_idmembers + "' LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_table_information_idmembers(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     private int executeQuery_table_information_idmembers(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int r_idreserve_rs = rs.getInt("r.idreserve");
                    String m_idnumber_rs = rs.getString("m.idnumber");
                    String b_barcode_rs = rs.getString("b.barcode");
                    String b_isbn_rs = rs.getString("b.isbn");
                    String b_title_rs = rs.getString("b.title");
                    java.sql.Date r_creserveddate_rs = rs.getDate("r.reserveddate");
                    java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    int r_copies_rs = rs.getInt("r.copies");
                    String r_notes_rs = rs.getString("r.notes");
                    String r_status_rs = rs.getString("r.status");
                    java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                    boolean isExpired_Reservation = isExpired_Between(currentDate, r_creserveddate_rs, r_reservedlimitdate_rs, conn);


                    Vector row = new Vector();
                    row.add(r_idreserve_rs);
                    row.add(m_idnumber_rs);
                    row.add(b_barcode_rs);
                    row.add(b_isbn_rs);
                    row.add(b_title_rs);
                    row.add(r_creserveddate_rs);
                    row.add(r_reservedlimitdate_rs);
                    row.add(r_copies_rs);
                    row.add(r_notes_rs);
                    row.add(isExpired_Reservation);
                    reserve.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }

     private boolean isExpired_Between(java.sql.Date currentDate, java.sql.Date reserveddate, java.sql.Date reservedlimitdate, Connection conn) {
          try {
               String query = "SELECT '" + currentDate + "' BETWEEN '" + reserveddate + "' AND '" + reservedlimitdate + "' AS isExpired;";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         boolean r_isBetween_rs = rs.getBoolean("isExpired"); // is between
                         if (r_isBetween_rs) {
                              return false;
                         } else {
                              // check if currentdate is greater the reserveddate 
                              String query_2 = "SELECT " + currentDate + " >= " + reserveddate + " AS isGreaterThan;";
                              PreparedStatement statement_2 = (PreparedStatement) conn.prepareStatement(query_2);
                              ResultSet rs_2;
                              rs_2 = statement_2.executeQuery();
                              while (rs_2.next()) {
                                   boolean isGreaterThan = rs_2.getBoolean("isGreaterThan");
                                   if (isGreaterThan) {
                                        return false;
                                   } else {
                                        return true;
                                   }
                              }
                         }


                    }
                    rs.close();
               } catch (SQLException sqle) {
                    System.err.println(sqle);
               }
          } catch (Exception e) {
               System.err.println(e);
          }
          return false;
     }

     /**/
     public int count_information_by_idbooks_reserve_history(int idbooks, Connection conn) {
          try {
               String query = "SELECT Count(r.idreserve) as resultCount FROM books AS b , members AS m , reserve AS r WHERE r.members_idmembers = m.idmembers AND b.idbooks = r.books_idbooks AND b.idbooks = '" + idbooks + "';";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int r_resultCount_rs = rs.getInt("resultCount");
                         return r_resultCount_rs;
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

     public int select_information_by_idbooks_reserve_history(int idbooks, int limitFrom, int limitTo, Connection conn) {
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.idreserve, b.barcode, b.isbn, m.idnumber, m.firstname, m.middleinitial, m.lastname, b.title, b.description, b.category_name, r.reserveddate, r.reservedlimitdate, r.copies, r.notes FROM books AS b , members AS m , reserve AS r WHERE r.members_idmembers = m.idmembers AND b.idbooks = r.books_idbooks AND b.idbooks = '" + idbooks + "' LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = executeQuery_table_information_idbooks_reserve_history(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     private int executeQuery_table_information_idbooks_reserve_history(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int r_idreserve_rs = rs.getInt("r.idreserve");
                    String b_barcode_rs = rs.getString("b.barcode");
                    String b_isbn_rs = rs.getString("b.isbn");
                    String m_idnumber_rs = rs.getString("m.idnumber");
                    String m_firstname_rs = rs.getString("m.firstname");
                    String m_middleinitial_rs = rs.getString("m.middleinitial");
                    String m_lastname_rs = rs.getString("m.lastname");
                    String b_title_rs = rs.getString("b.title");
                    String b_description_rs = rs.getString("b.description");
                    String b_category_name_rs = rs.getString("b.category_name");
                    java.sql.Date r_reserveddate_rs = rs.getDate("r.reserveddate");
                    java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    int r_copies_rs = rs.getInt("r.copies");
                    String r_notes_rs = rs.getString("r.notes");
                    java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                    boolean isExpired_Reservation = isExpired_Between(currentDate, r_reserveddate_rs, r_reservedlimitdate_rs, conn);


                    Vector row = new Vector();
                    row.add(r_idreserve_rs);
                    row.add(b_barcode_rs);
                    row.add(b_isbn_rs);
                    row.add(m_idnumber_rs);
                    row.add(m_firstname_rs + " " + m_middleinitial_rs + " " + m_lastname_rs);
                    row.add(b_title_rs);
                    row.add(b_description_rs);
                    row.add(r_reserveddate_rs);
                    row.add(r_reservedlimitdate_rs);
                    row.add(r_copies_rs);
                    row.add(r_notes_rs);
                    row.add(isExpired_Reservation);
                    reserve.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);

          }
          return resultCount;
     }

     /* Administrator */
     public int administrator_count_information_by_idbooks_reserve_history(int idbooks, Connection conn) {
          try {
               String query = "SELECT Count(r.idreserve) as resultCount FROM books AS b , members AS m , reserve AS r WHERE r.members_idmembers = m.idmembers AND b.idbooks = r.books_idbooks AND b.idbooks = '" + idbooks + "';";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         int r_resultCount_rs = rs.getInt("resultCount");
                         return r_resultCount_rs;
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

     public int administrator_select_information_by_idbooks_reserve_history(int idbooks, int limitFrom, int limitTo, Connection conn) {
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.idreserve, b.barcode, b.isbn, m.idnumber, m.firstname, m.middleinitial, m.lastname, b.title, b.description, b.category_name, r.reserveddate, r.reservedlimitdate, r.copies, r.notes FROM books AS b , members AS m , reserve AS r WHERE r.members_idmembers = m.idmembers AND b.idbooks = r.books_idbooks AND b.idbooks = '" + idbooks + "' LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = administrator_executeQuery_table_information_idbooks_reserve_history(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     private int administrator_executeQuery_table_information_idbooks_reserve_history(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int r_idreserve_rs = rs.getInt("r.idreserve");
                    String b_barcode_rs = rs.getString("b.barcode");
                    String b_isbn_rs = rs.getString("b.isbn");
                    String m_idnumber_rs = rs.getString("m.idnumber");
                    String m_firstname_rs = rs.getString("m.firstname");
                    String m_middleinitial_rs = rs.getString("m.middleinitial");
                    String m_lastname_rs = rs.getString("m.lastname");
                    String b_title_rs = rs.getString("b.title");
                    String b_description_rs = rs.getString("b.description");
                    String b_category_name_rs = rs.getString("b.category_name");
                    java.sql.Date r_reserveddate_rs = rs.getDate("r.reserveddate");
                    java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    int r_copies_rs = rs.getInt("r.copies");
                    String r_notes_rs = rs.getString("r.notes");
                    java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                    boolean isExpired_Reservation = isExpired_Between(currentDate, r_reserveddate_rs, r_reservedlimitdate_rs, conn);

                    Vector row = new Vector();
                    row.add(r_idreserve_rs);
                    row.add(m_idnumber_rs);
                    row.add(b_barcode_rs);
//                    row.add(b_isbn_rs);
//                    row.add(m_firstname_rs + " " + m_middleinitial_rs + " " + m_lastname_rs);
                    row.add(b_title_rs);
                    row.add(b_description_rs);
                    row.add(r_reserveddate_rs);
                    row.add(r_reservedlimitdate_rs);
                    row.add(r_copies_rs);
//                    row.add(r_notes_rs);
                    row.add(isExpired_Reservation);
                    reserve.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);

          }
          return resultCount;
     }

     /* where not expired */
     public int administrator_count_information_by_idbooks_reserve_history_and_not_expired_and_status_is_reserved(int idbooks, Connection conn) {
          int r_resultCount_rs = 0;
          try {
               String query = "SELECT r.idreserve, r.reserveddate, r.reservedlimitdate FROM books AS b ,  members AS m ,  reserve AS r WHERE  r.members_idmembers = m.idmembers AND  b.idbooks = r.books_idbooks AND r.status = 'Reserved' AND b.idbooks = '" + idbooks + "';";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         java.sql.Date r_reserveddate_rs = rs.getDate("r.reserveddate");
                         java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                         java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                         boolean isExpired_Reservation = isExpired_Between(currentDate, r_reserveddate_rs, r_reservedlimitdate_rs, conn);

                         if (isExpired_Reservation) {
                         } else {
                              r_resultCount_rs++;
                         }

                    }
                    rs.close();
               } catch (SQLException sqle) {
                    System.err.println(sqle);
               }
          } catch (Exception e) {
               System.err.println(e);
          }
          return r_resultCount_rs;
     }

     public int administrator_select_information_by_idbooks_reserve_history_and_not_expired_and_status_is_reserved(int idbooks, int limitFrom, int limitTo, Connection conn) {
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.idreserve, b.barcode, b.isbn, m.idnumber, m.firstname, m.middleinitial, m.lastname, b.title, b.description, b.category_name, r.reserveddate, r.reservedlimitdate, r.copies, r.notes FROM books AS b , members AS m , reserve AS r WHERE r.members_idmembers = m.idmembers AND r.status = 'Reserved' AND b.idbooks = r.books_idbooks AND b.idbooks = '" + idbooks + "' LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = administrator_executeQuery_table_information_idbooks_reserve_history_and_not_expired_and_status_is_reserved(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     private int administrator_executeQuery_table_information_idbooks_reserve_history_and_not_expired_and_status_is_reserved(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int r_idreserve_rs = rs.getInt("r.idreserve");
                    String b_barcode_rs = rs.getString("b.barcode");
//                    String b_isbn_rs = rs.getString("b.isbn");
                    String m_idnumber_rs = rs.getString("m.idnumber");
                    String m_firstname_rs = rs.getString("m.firstname");
                    String m_middleinitial_rs = rs.getString("m.middleinitial");
                    String m_lastname_rs = rs.getString("m.lastname");
                    String b_title_rs = rs.getString("b.title");
//                    String b_description_rs = rs.getString("b.description");
//                    String b_category_name_rs = rs.getString("b.category_name");
                    java.sql.Date r_reserveddate_rs = rs.getDate("r.reserveddate");
                    java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    int r_copies_rs = rs.getInt("r.copies");
                    String r_notes_rs = rs.getString("r.notes");
                    java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                    boolean isExpired_Reservation = isExpired_Between(currentDate, r_reserveddate_rs, r_reservedlimitdate_rs, conn);

                    if (isExpired_Reservation) {
                    } else {
                         Vector row = new Vector();
                         row.add(r_idreserve_rs);
                         row.add(m_idnumber_rs);
                         row.add(m_firstname_rs + " " + m_middleinitial_rs + " " + m_lastname_rs);
                         row.add(b_barcode_rs);
//                    row.add(b_isbn_rs);
                         row.add(b_title_rs);
                         row.add(r_notes_rs);
//                         row.add(b_description_rs);
                         row.add(r_reserveddate_rs);
                         row.add(r_reservedlimitdate_rs);
                         row.add(r_copies_rs);
                         row.add(isExpired_Reservation);
                         reserve.getData().add(row);
                    }
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);

          }
          return resultCount;
     }

     public int administrator_sum_of_total_copies_of_information_by_idbooks_reserve_history_and_not_expired_and_status_is_reserved(int idbooks, Connection conn) {
          int total_copies = 0;
          try {
               String query = "SELECT r.idreserve, b.barcode, b.isbn, m.idnumber, m.firstname, m.middleinitial, m.lastname, b.title, b.description, b.category_name, r.reserveddate, r.reservedlimitdate, r.copies, r.notes FROM books AS b , members AS m , reserve AS r WHERE r.members_idmembers = m.idmembers AND r.status = 'Reserved' AND b.idbooks = r.books_idbooks AND b.idbooks = '" + idbooks + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    int r_copies_rs = rs.getInt("r.copies");
                    java.sql.Date r_reserveddate_rs = rs.getDate("r.reserveddate");
                    java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                    boolean isExpired_Reservation = isExpired_Between(currentDate, r_reserveddate_rs, r_reservedlimitdate_rs, conn);
                    if (isExpired_Reservation) {
                    } else {
                         total_copies += r_copies_rs;
                    }
               }
               rs.close();
          } catch (Exception e) {
               System.err.println(e);
               e.printStackTrace();
          }
          return total_copies;
     }

     /* remove reservation after the borrow */
     public int remove_reservation_automatic_select_information_by_idbooks_and_idmembers_of_reserve_history_and_not_expired_and_status_is_reserved(int idbooks, int idmembers, Connection conn) {
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.idreserve, r.reserveddate, r.reservedlimitdate, r.copies, r.notes FROM reserve AS r WHERE r.`status` = 'Reserved' AND r.members_idmembers = '" + idmembers + "' AND r.books_idbooks = '" + idbooks + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    int r_reserve_rs = rs.getInt("r.idreserve");
                    java.sql.Date r_reserveddate_rs = rs.getDate("r.reserveddate");
                    java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                    boolean isExpired_Reservation = isExpired_Between(currentDate, r_reserveddate_rs, r_reservedlimitdate_rs, conn);
                    if (isExpired_Reservation) {
                    } else {
                         update_reserve_status_to_canceled(r_reserve_rs, conn);
                    }
               }
               rs.close();
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     /* Members */
     public int administrator_count_information_by_idmembers_reserve_history_and_not_expired_and_status_is_reserved(int idmembers, Connection conn) {
          int r_resultCount_rs = 0;
          try {
               String query = "SELECT r.idreserve, r.reserveddate, r.reservedlimitdate FROM books AS b ,  members AS m ,  reserve AS r WHERE  r.members_idmembers = m.idmembers AND  b.idbooks = r.books_idbooks AND r.status = 'Reserved' AND m.idmembers = '" + idmembers + "';";
               try {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         java.sql.Date r_reserveddate_rs = rs.getDate("r.reserveddate");
                         java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                         java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                         boolean isExpired_Reservation = isExpired_Between(currentDate, r_reserveddate_rs, r_reservedlimitdate_rs, conn);

                         if (isExpired_Reservation) {
                         } else {
                              r_resultCount_rs++;
                         }

                    }
                    rs.close();
               } catch (SQLException sqle) {
                    System.err.println(sqle);
               }
          } catch (Exception e) {
               System.err.println(e);
          }
          return r_resultCount_rs;
     }

     public int administrator_select_information_by_idmembers_reserve_history_and_not_expired_and_status_is_reserved(int idmembers, int limitFrom, int limitTo, Connection conn) {
          reserve.setData(new Vector());
          try {
               String query = "SELECT r.idreserve, b.barcode, b.isbn, m.idnumber, m.firstname, m.middleinitial, m.lastname, b.title, b.description, b.category_name, r.reserveddate, r.reservedlimitdate, r.copies, r.notes FROM books AS b , members AS m , reserve AS r WHERE r.members_idmembers = m.idmembers AND r.status = 'Reserved' AND b.idbooks = r.books_idbooks AND m.idmembers = '" + idmembers + "' LIMIT " + limitFrom + ", " + limitTo + ";";
               int resultCount = administrator_executeQuery_table_information_idmembers_reserve_history_and_not_expired_and_status_is_reserved(query, conn);
               return resultCount;
          } catch (Exception e) {
               System.err.println(e);
          }
          return 0;
     }

     private int administrator_executeQuery_table_information_idmembers_reserve_history_and_not_expired_and_status_is_reserved(String query, Connection conn) {
          int resultCount = 0;
          try {
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs;
               rs = statement.executeQuery();
               while (rs.next()) {
                    resultCount++;
                    int r_idreserve_rs = rs.getInt("r.idreserve");
                    String b_barcode_rs = rs.getString("b.barcode");
//                    String b_isbn_rs = rs.getString("b.isbn");
                    String m_idnumber_rs = rs.getString("m.idnumber");
                    String m_firstname_rs = rs.getString("m.firstname");
                    String m_middleinitial_rs = rs.getString("m.middleinitial");
                    String m_lastname_rs = rs.getString("m.lastname");
                    String b_title_rs = rs.getString("b.title");
//                    String b_description_rs = rs.getString("b.description");
//                    String b_category_name_rs = rs.getString("b.category_name");
                    java.sql.Date r_reserveddate_rs = rs.getDate("r.reserveddate");
                    java.sql.Date r_reservedlimitdate_rs = rs.getDate("r.reservedlimitdate");
                    int r_copies_rs = rs.getInt("r.copies");
                    String r_notes_rs = rs.getString("r.notes");
                    java.sql.Date currentDate = ref_MyFunctions.select_currentDate(conn);
                    boolean isExpired_Reservation = isExpired_Between(currentDate, r_reserveddate_rs, r_reservedlimitdate_rs, conn);

                    if (isExpired_Reservation) {
                    } else {
                         Vector row = new Vector();
                         row.add(r_idreserve_rs);
                         row.add(m_idnumber_rs);
                         row.add(m_firstname_rs + " " + m_middleinitial_rs + " " + m_lastname_rs);
                         row.add(b_barcode_rs);
//                    row.add(b_isbn_rs);
                         row.add(b_title_rs);
                         row.add(r_notes_rs);
//                         row.add(b_description_rs);
                         row.add(r_reserveddate_rs);
                         row.add(r_reservedlimitdate_rs);
                         row.add(r_copies_rs);
                         row.add(isExpired_Reservation);
                         reserve.getData().add(row);
                    }
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);

          }
          return resultCount;
     }
}
