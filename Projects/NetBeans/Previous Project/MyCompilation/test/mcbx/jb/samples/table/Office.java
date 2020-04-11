package mcbx.jb.samples.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import mcbx.jb.classes.databaseconnection.MySQL;

public class Office {

     private static MySQL ref_DoscstInventorySystem = new MySQL("localhost", "3306", "doscstinventorysystem", "root", "");
     private static Vector jTableOffice_data = new Vector();

// ----------------------------------------------------------------------------- [SETTER AND GETTER]
     public static Vector getjTableOffice_data() {
          return jTableOffice_data;
     }

     public static void setjTableOffice_data(Vector jTableOffice_data) {
          Office.jTableOffice_data = jTableOffice_data;
     }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
     public void select_information_jTable() {
          Office.setjTableOffice_data(new Vector());
          try {
               String query = "SELECT o.officeCode, o.officeDescription FROM office AS o;";
               executeQuery_jTable(query);
          } catch (Exception e) {
               System.out.println(e);
          }
     }

     private void executeQuery_jTable(String query) {
          try {
               ref_DoscstInventorySystem.connectToServer();
               Connection conn = ref_DoscstInventorySystem.getConnection();
               if (conn != null) {
                    PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                    ResultSet rs;
                    rs = statement.executeQuery();
                    while (rs.next()) {
                         Vector row = new Vector();
                         row.add(rs.getString("o.officeCode"));
                         row.add(rs.getString("o.officeDescription"));
                         Office.getjTableOffice_data().add(row);
                    }
                    rs.close();
               }
          } catch (Exception ex) {
               System.out.println(ex);
          }
     }

// ----------------------------------------------------------------------------- [RETURN COLUMN NUMBER]     
     public int function_getColumnNumber_jTable(String column_Name, JTable table_Name) {
          int get_columnNumber = 0;
          try {
               // iterate and find the column "column_Name"
               for (int c = 0; c < table_Name.getColumnCount(); c++) {
                    String columnName = table_Name.getColumnName(c);
                    // check if it is equal to the column "column_Name"
                    if (column_Name.equals(columnName)) { // GET THE COLUMN NUMBER
                         // set and return the column number
                         get_columnNumber = c;
                         break;
                    }
               }
          } catch (Exception e) {
               System.out.println(e);
          }
          return get_columnNumber;
     }
}
