package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

public class journals {

     private static Vector data;
     private String barcode;
     private String title;
     private int copynumber;
     private String acquireddate;
     private String description;
     private double cost;
     private double purchasedcost;
     private String category_name;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          journals.data = data;
     }

     public String getBarcode() {
          return barcode;
     }

     public void setBarcode(String barcode) {
          this.barcode = barcode;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
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

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
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

     public String getCategory_name() {
          return category_name;
     }

     public void setCategory_name(String category_name) {
          this.category_name = category_name;
     }

     /* constructor */
     public journals() {
     }

     public journals(String barcode, String title, int copynumber, String acquireddate, String description, double cost, double purchasedcost, String category_name) {
          this.barcode = barcode;
          this.title = title;
          this.copynumber = copynumber;
          this.acquireddate = acquireddate;
          this.description = description;
          this.cost = cost;
          this.purchasedcost = purchasedcost;
          this.category_name = category_name;
     }

// ----------------------------------------------------------------------------- [INSERT]
     public void insert_journals(journals new_journals, Connection conn) {
          try {
               String query = "INSERT INTO journals (barcode, title, copynumber, acquireddate, description, cost, purchasedcost, category_name) values (?,?,?,?,?,?,?,?);";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_journals.getBarcode());
               statement.setString(2, new_journals.getTitle());
               statement.setInt(3, new_journals.getCopynumber());
               statement.setString(4, new_journals.getAcquireddate());
               statement.setString(5, new_journals.getDescription());
               statement.setDouble(6, new_journals.getCost());
               statement.setDouble(7, new_journals.getPurchasedcost());
               statement.setString(8, new_journals.getCategory_name());
               statement.execute();

               System.out.println("Successfully Inserted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [UPDATE]
     public void update_journals(int idjournals, journals new_journals, Connection conn) {
          try {
               String query = "UPDATE journals SET barcode=?, title=?, copynumber=?, acquireddate=?, description=?, cost=?, purchasedcost=?, category_name=? WHERE idjournals = '" + idjournals + "'";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.setString(1, new_journals.getBarcode());
               statement.setString(2, new_journals.getTitle());
               statement.setInt(3, new_journals.getCopynumber());
               statement.setString(4, new_journals.getAcquireddate());
               statement.setString(5, new_journals.getDescription());
               statement.setDouble(6, new_journals.getCost());
               statement.setDouble(7, new_journals.getPurchasedcost());
               statement.setString(8, new_journals.getCategory_name());
               statement.execute();

               System.out.println("Successfully Updated.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DELETE]
     public void delete_journals(int idjournals, journals new_journals, Connection conn) {
          try {
               String query = "DELETE FROM journals WHERE idjournals = '" + idjournals + "'; ";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               statement.execute();

               System.out.println("Successfully Deleted.");

          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
     }

// ----------------------------------------------------------------------------- [DISPLAY]
     public void display() {
          try {
               for (int i = 0; i < journals.getData().size(); i++) {
                    System.out.println(journals.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }

// ----------------------------------------------------------------------------- [RETURN VALUES]
     public boolean function_is_barcode_exist(String barcode, Connection conn) {
          try {
               String query = "SELECT j.idjournals FROM journals AS j WHERE j.barcode = '" + barcode + "';";
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

     public int function_get_idjournals(int barcode, Connection conn) {
          try {
               String query = "SELECT j.idjournals FROM journals AS j WHERE j.barcode = '" + barcode + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int j_idjournals_rs = rs.getInt("j.idjournals");
                    return j_idjournals_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public String function_get_barcode(int idjournals, Connection conn) {
          try {
               String query = "SELECT j.barcode FROM journals AS j WHERE j.idjournals = '" + idjournals + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String j_barcode_rs = rs.getString("j.barcode");
                    return j_barcode_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_title(int idjournals, Connection conn) {
          try {
               String query = "SELECT j.title FROM journals AS j WHERE j.idjournals = '" + idjournals + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String j_title_rs = rs.getString("j.title");
                    return j_title_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public int function_get_copynumber(int idjournals, Connection conn) {
          try {
               String query = "SELECT j.copynumber FROM journals AS j WHERE j.idjournals = '" + idjournals + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    int j_copynumber_rs = rs.getInt("j.copynumber");
                    return j_copynumber_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public java.util.Date function_get_acquireddate(int idjournals, Connection conn) {
          try {
               String query = "SELECT j.acquireddate FROM journals AS j WHERE j.idjournals = '" + idjournals + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    java.util.Date j_acquireddate_rs = rs.getDate("j.acquireddate");
                    return j_acquireddate_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public String function_get_description(int idjournals, Connection conn) {
          try {
               String query = "SELECT j.description FROM journals AS j WHERE j.idjournals = '" + idjournals + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String j_description_rs = rs.getString("j.description");
                    return j_description_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return null;
     }

     public double function_get_cost(int idjournals, Connection conn) {
          try {
               String query = "SELECT j.cost FROM journals AS j WHERE j.idjournals = '" + idjournals + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    double j_cost_rs = rs.getDouble("j.cost");
                    return j_cost_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }

     public double function_get_purchasedcost(int idjournals, Connection conn) {
          try {
               String query = "SELECT j.purchasedcost FROM journals AS j WHERE j.idjournals = '" + idjournals + "';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    double j_purchasedcost_rs = rs.getDouble("j.purchasedcost");
                    return j_purchasedcost_rs;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return 0;
     }
// ----------------------------------------------------------------------------- [SELECT INFORMATION]
}
