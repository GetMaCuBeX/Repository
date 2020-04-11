package mcbx.jb.classes.database.attendancemonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class students {

     private static Vector data;
     private String idnumber;
     private String name;
     private String guardian;
     private String mobilenumber;
     private int isenablesms;
     private String status;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          students.data = data;
     }

     public students() {
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert(String idnumber, String name, String guardian, String mobilenumber, int isenablesms, String status, Connection conn) {
          try {
               String query = "INSERT INTO students (idnumber,name,guardian,mobilenumber,isenablesms,name, status) values (?,?,?,?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, idnumber);
               statement.setString(2, name);
               statement.setString(3, guardian);
               statement.setString(4, mobilenumber);
               statement.setInt(5, isenablesms);
               statement.setString(6, status);
               statement.execute();

               System.out.println("Successfully Inserted.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }
// ----------------------------------------------------------------------------- [UPDATE]

     public void update(int idstudents, String idnumber, String name, String guardian, String mobilenumber, int isenablesms, String status, Connection conn) {
          try {
               String query = "UPDATE students SET idnumber=?, name=?, guardian=?, mobilenumber=?, isenablesms=?, status=? WHERE idstudents = '" + idstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, idnumber);
               statement.setString(2, name);
               statement.setString(3, guardian);
               statement.setString(4, mobilenumber);
               statement.setInt(5, isenablesms);
               statement.setString(6, status);
               statement.execute();

               System.out.println("Successfully Updated.");
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete(int[] idstudents, Connection conn) {
          try {
               int i_idstudents;
               for (int x = 0; x < idstudents.length; x++) {
                    i_idstudents = idstudents[x];
                    String queryString = "DELETE FROM students WHERE idstudents = '" + i_idstudents + "'; ";
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(queryString);
                    statement.execute();
               }
          } catch (SQLException sqle) {
               System.out.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DISPLAY]
// ----------------------------------------------------------------------------- [RETURN VALUES]
     public String function_get_idnumber(int idstudents, Connection conn) {
          try {
               String query = "SELECT s.idnumber FROM students AS s WHERE s.idstudents = '" + idstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String s_idnumber_rs = rs.getString("s.idnumber");
                    return s_idnumber_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_name(int idstudents, Connection conn) {
          try {
               String query = "SELECT s.name FROM students AS s WHERE s.idstudents = '" + idstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String s_name_rs = rs.getString("s.name");
                    return s_name_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_guardian(int idstudents, Connection conn) {
          try {
               String query = "SELECT s.guardian FROM students AS s WHERE s.idstudents = '" + idstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String s_guardian_rs = rs.getString("s.guardian");
                    return s_guardian_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_mobilenumber(int idstudents, Connection conn) {
          try {
               String query = "SELECT s.mobilenumber FROM students AS s WHERE s.idstudents = '" + idstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String s_mobilenumber_rs = rs.getString("s.mobilenumber");
                    return s_mobilenumber_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public boolean function_get_isenablesms(int idstudents, Connection conn) {
          try {
               String query = "SELECT s.isenablesms FROM students AS s WHERE s.idstudents = '" + idstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    boolean s_isenablesms_rs = rs.getBoolean("s.isenablesms");
                    if (s_isenablesms_rs) {
                         return true;
                    } else {
                         return false;
                    }
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return false;
     }

     public String function_get_status(int idstudents, Connection conn) {
          try {
               String query = "SELECT s.status FROM students AS s WHERE s.idstudents = '" + idstudents + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String s_status_rs = rs.getString("s.status");
                    return s_status_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]

     public int count_select_all_by_search(String search, Connection conn) {
          try {
               String query = "SELECT Count(s.idstudents) FROM students AS s WHERE s.idnumber LIKE '%" + search + "%' OR s.`name` LIKE '%" + search + "%' OR s.mobilenumber LIKE '%" + search + "%';";
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
          students.setData(new Vector());
          try {
               String query = "SELECT s.idstudents, s.idnumber, s.`name`, s.guardian, s.mobilenumber, s.isenablesms, s.`status` FROM students AS s WHERE s.idnumber LIKE '%" + search + "%' OR s.`name` LIKE '%" + search + "%' OR s.mobilenumber LIKE '%" + search + "%' LIMIT " + limitFrom + ", " + limitTo + ";";
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
                    int s_idstudents_rs = rs.getInt("s.idstudents");
                    String s_idnumber_rs = rs.getString("s.idnumber");
                    String s_name_rs = rs.getString("s.name");
                    String s_guardian_rs = rs.getString("s.guardian");
                    String s_mobilenumber_rs = rs.getString("s.mobilenumber");
                    boolean s_isenablesms_rs = rs.getBoolean("s.isenablesms");
                    String s_status_rs = rs.getString("s.status");

                    if (s_name_rs == null) {
                         s_name_rs = "";
                    }
                    if (s_guardian_rs == null) {
                         s_guardian_rs = "";
                    }
                    if (s_mobilenumber_rs == null) {
                         s_mobilenumber_rs = "";
                    }

                    Vector row = new Vector();
                    row.add(s_idstudents_rs);
                    row.add(s_idnumber_rs);
                    row.add(s_name_rs);
                    row.add(s_guardian_rs);
                    row.add(s_mobilenumber_rs);
                    row.add(s_isenablesms_rs);
                    row.add(s_status_rs);
                    students.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }
}
