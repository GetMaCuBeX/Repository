package mcbx.jb.classes.database.lanes_data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class users {

     
     private static Vector data;
     private int GuestID;
     private String Lastname;
     private String Firstname;
     private String Middlename;
     private String Gender;
     private String Address;
     private String Contact;
     private String Role;


     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          users.data = data;
     }

     public int getGuestID() {
          return GuestID;
     }

     public void setGuestID(int GuestID) {
          this.GuestID = GuestID;
     }

     public String getLastname() {
          return Lastname;
     }

     public void setLastname(String Lastname) {
          this.Lastname = Lastname;
     }

     public String getFirstname() {
          return Firstname;
     }

     public void setFirstname(String Firstname) {
          this.Firstname = Firstname;
     }

     public String getMiddlename() {
          return Middlename;
     }

     public void setMiddlename(String Middlename) {
          this.Middlename = Middlename;
     }

     public String getGender() {
          return Gender;
     }

     public void setGender(String Gender) {
          this.Gender = Gender;
     }

     public String getAddress() {
          return Address;
     }

     public void setAddress(String Address) {
          this.Address = Address;
     }

     public String getContact() {
          return Contact;
     }

     public void setContact(String Contact) {
          this.Contact = Contact;
     }

     public String getRole() {
          return Role;
     }

     public void setRole(String Role) {
          this.Role = Role;
     }

     /* constructor */
     public users() {
     }

     public users(int GuestID, String Lastname, String Firstname, String Middlename, String Gender, String Address, String Contact, String Role) {
          this.GuestID = GuestID;
          this.Lastname = Lastname;
          this.Firstname = Firstname;
          this.Middlename = Middlename;
          this.Gender = Gender;
          this.Address = Address;
          this.Contact = Contact;
          this.Role = Role;
     }

// ----------------------------------------------------------------------------- [INSERT]
    
// ----------------------------------------------------------------------------- [UPDATE]


// ----------------------------------------------------------------------------- [DELETE]


// ----------------------------------------------------------------------------- [DISPLAY]


// ----------------------------------------------------------------------------- [RETURN VALUES]
   public String function_get_contact(int GuestID, Connection conn){
          try {
               String query = "SELECT u.Contact FROM users AS u WHERE u.GuestID = '"+GuestID+"';";
               PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
               ResultSet rs = statement.executeQuery();
               while (rs.next()) {
                    String u_Contact = rs.getString("u.Contact");
                    return u_Contact;
               }
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return "";
   }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
     /* search */
     public int count_select_search(String search, Connection conn) {
          try {
               String query = "SELECT Count(u.GuestID) AS resultCount FROM users AS u WHERE u.Lastname LIKE '%"+search+"%' OR u.Firstname LIKE '%"+search+"%' OR u.Gender LIKE '%"+search+"%' OR u.Contact LIKE '%"+search+"%' OR u.Role LIKE '%"+search+"%';";
//               String query = "SELECT Count(m.idmembers) as resultCount FROM members AS m WHERE m.idnumber LIKE '%" + search + "%' OR m.firstname LIKE '%" + search + "%' OR m.lastname LIKE '%" + search + "%' OR m.gender LIKE '%" + search + "%' OR m.address1 LIKE '%" + search + "%' OR m.address2 LIKE '%" + search + "%' OR m.phonenumber1 LIKE '%" + search + "%' OR m.phonenumber2 LIKE '%" + search + "%' OR m.emailaddress LIKE '%" + search + "%' OR m.membertype LIKE '%" + search + "%';";
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
          users.setData(new Vector());
          try {
               String query = "SELECT u.GuestID, u.Lastname, u.Firstname, u.Middlename, u.Gender, u.Address, u.Contact, u.Role FROM users AS u WHERE u.Lastname LIKE '%"+search+"%' OR u.Firstname LIKE '%"+search+"%' OR u.Gender LIKE '%"+search+"%' OR u.Contact LIKE '%"+search+"%' OR u.Role LIKE '%"+search+"%' LIMIT " + limitFrom + ", " + limitTo + ";";
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
                    int u_GuestID_rs = rs.getInt("u.GuestID");
                    String u_Lastname_rs = rs.getString("u.Lastname");
                    String u_Firstname_rs = rs.getString("u.Firstname");
                    String u_Middlename_rs = rs.getString("u.Middlename");
                    String u_Gender_rs = rs.getString("u.Gender");
                    String u_Address_rs = rs.getString("u.Address");
                    String u_Contact_rs = rs.getString("u.Contact");
                    String u_Role_rs = rs.getString("u.Role");

                    Vector row = new Vector();
                    row.add(u_GuestID_rs);
                    row.add(u_Firstname_rs);
                    row.add(u_Middlename_rs);
                    row.add(u_Lastname_rs);
                    row.add(u_Gender_rs);
                    row.add(u_Address_rs);
                    row.add(u_Contact_rs);
                    row.add(u_Role_rs);
                    users.getData().add(row);
               }
               rs.close();
          } catch (SQLException sqle) {
               System.err.println(sqle);
          }
          return resultCount;
     }

     /**/
}
