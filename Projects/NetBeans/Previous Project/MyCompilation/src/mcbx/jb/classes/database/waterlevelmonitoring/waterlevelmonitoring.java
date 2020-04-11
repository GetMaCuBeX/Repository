package mcbx.jb.classes.database.waterlevelmonitoring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class waterlevelmonitoring {

     private static Vector data;
     private String date;
     private String time;
     private int level_idlevel;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          waterlevelmonitoring.data = data;
     }

     public String getDate() {
          return date;
     }

     public void setDate(String date) {
          this.date = date;
     }

     public String getTime() {
          return time;
     }

     public void setTime(String time) {
          this.time = time;
     }

     public int getLevel_idlevel() {
          return level_idlevel;
     }

     public void setLevel_idlevel(int level_idlevel) {
          this.level_idlevel = level_idlevel;
     }

     /* constructor */
     public waterlevelmonitoring() {
     }

     public waterlevelmonitoring(String date, String time, int level_idlevel) {
          this.date = date;
          this.time = time;
          this.level_idlevel = level_idlevel;
     }

  

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_waterlevelmonitoring(waterlevelmonitoring new_waterlevelmonitoring, Connection conn) {
          try {
               String query = "INSERT INTO waterlevelmonitoring (date, time, level_idlevel) values (?, ?, ?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_waterlevelmonitoring.getDate());
               statement.setString(2, new_waterlevelmonitoring.getTime());
               statement.setInt(3, new_waterlevelmonitoring.getLevel_idlevel());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_waterlevelmonitoring(int idwaterlevelmonitoring, waterlevelmonitoring new_waterlevelmonitoring, Connection conn) {
          try {
               String query = "UPDATE waterlevelmonitoring SET date=?, time=?, level_idlevel=? WHERE idwaterlevelmonitoring = '" + idwaterlevelmonitoring + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_waterlevelmonitoring.getDate());
               statement.setString(2, new_waterlevelmonitoring.getTime());
               statement.setInt(3, new_waterlevelmonitoring.getLevel_idlevel());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_waterlevelmonitoring(int idwaterlevelmonitoring, Connection conn) {
          try {
               String query = "DELETE FROM waterlevelmonitoring WHERE idwaterlevelmonitoring = '" + idwaterlevelmonitoring + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

     public void delete_waterlevelmonitoring(int[] idwaterlevelmonitoring, Connection conn) {
          try {
               int i_idwaterlevelmonitoring;
               for (int x = 0; x < idwaterlevelmonitoring.length; x++) {
                    i_idwaterlevelmonitoring = idwaterlevelmonitoring[x];
                    String queryString = "DELETE FROM waterlevelmonitoring WHERE idwaterlevelmonitoring = '" + i_idwaterlevelmonitoring + "'; ";
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
               for (int i = 0; i < waterlevelmonitoring.getData().size(); i++) {
                    System.out.println(waterlevelmonitoring.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }
// ----------------------------------------------------------------------------- [RETURN VALUES]
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
  /*
      public int select_all_between(String dateFrom, String dateTo, Connection conn) {
      waterlevelmonitoring.setData(new Vector());
      try {
      String query = "SELECT s.idsubjects, s.`name` FROM subjects AS s ORDER BY s.`name` ASC LIMIT " + limitFrom + ", " + limitTo + ";";
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
      int s_idsubjects_rs = rs.getInt("s.idsubjects");
      String s_name_rs = rs.getString("s.name");
      Vector row = new Vector();
      row.add(s_idsubjects_rs);
      row.add(s_name_rs);
      subjects.getData().add(row);
      }
      rs.close();
      } catch (SQLException sqle) {
      System.err.println(sqle);
      }
      return resultCount;
      }*/
     
     
}
