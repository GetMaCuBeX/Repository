package mcbx.jb.classes.database.booksreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class members {

    private static Vector data;
    private String idnumber;
    private String firstname;
    private String middleinitial;
    private String lastname;
    private String dateofbirth;
    private String gender;
    private String address1;
    private String address2;
    private String phonenumber1;
    private String phonenumber2;
    private String emailaddress;
    private String registereddate;
    private String membertype;
    private int isblocked;
    private String username;
    private String password;

    public static Vector getData() {
        return data;
    }

    public static void setData(Vector data) {
        members.data = data;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleinitial() {
        return middleinitial;
    }

    public void setMiddleinitial(String middleinitial) {
        this.middleinitial = middleinitial;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhonenumber1() {
        return phonenumber1;
    }

    public void setPhonenumber1(String phonenumber1) {
        this.phonenumber1 = phonenumber1;
    }

    public String getPhonenumber2() {
        return phonenumber2;
    }

    public void setPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getRegistereddate() {
        return registereddate;
    }

    public void setRegistereddate(String registereddate) {
        this.registereddate = registereddate;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public int getIsblocked() {
        return isblocked;
    }

    public void setIsblocked(int isblocked) {
        this.isblocked = isblocked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* constructor */
    public members() {
    }

    public members(String idnumber, String firstname, String middleinitial, String lastname, String dateofbirth, String gender, String address1, String address2, String phonenumber1, String phonenumber2, String emailaddress, String registereddate, String membertype, int isblocked, String username, String password) {
        this.idnumber = idnumber;
        this.firstname = firstname;
        this.middleinitial = middleinitial;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.address1 = address1;
        this.address2 = address2;
        this.phonenumber1 = phonenumber1;
        this.phonenumber2 = phonenumber2;
        this.emailaddress = emailaddress;
        this.registereddate = registereddate;
        this.membertype = membertype;
        this.isblocked = isblocked;
        this.username = username;
        this.password = password;
    }

// ----------------------------------------------------------------------------- [INSERT]
    public void insert_members(members new_members, Connection conn) {
        try {
            String query = "INSERT INTO members (idnumber, firstname, middleinitial, lastname, dateofbirth, gender, address1, address2, phonenumber1, phonenumber2, emailaddress, registereddate, membertype, isblocked, username, password) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setString(1, new_members.getIdnumber());
            statement.setString(2, new_members.getFirstname());
            statement.setString(3, new_members.getMiddleinitial());
            statement.setString(4, new_members.getLastname());
            statement.setString(5, new_members.getDateofbirth());
            statement.setString(6, new_members.getGender());
            statement.setString(7, new_members.getAddress1());
            statement.setString(8, new_members.getAddress2());
            statement.setString(9, new_members.getPhonenumber1());
            statement.setString(10, new_members.getPhonenumber2());
            statement.setString(11, new_members.getEmailaddress());
            statement.setString(12, new_members.getRegistereddate());
            statement.setString(13, new_members.getMembertype());
            statement.setInt(14, new_members.getIsblocked());
            statement.setString(15, new_members.getUsername());
            statement.setString(16, new_members.getPassword());
            statement.execute();

            System.out.println("Successfully Inserted.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public void update_members(int idmembers, members new_members, Connection conn) {
        try {
            String query = "UPDATE members SET idnumber=?, firstname=?, middleinitial=?, lastname=?, dateofbirth=?, gender=?, address1=?, address2=?, phonenumber1=?, phonenumber2=?, emailaddress=?, registereddate=?, membertype=?, isblocked=?, username=?, password=? WHERE idmembers = '" + idmembers + "'";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            statement.setString(1, new_members.getIdnumber());
            statement.setString(2, new_members.getFirstname());
            statement.setString(3, new_members.getMiddleinitial());
            statement.setString(4, new_members.getLastname());
            statement.setString(5, new_members.getDateofbirth());
            statement.setString(6, new_members.getGender());
            statement.setString(7, new_members.getAddress1());
            statement.setString(8, new_members.getAddress2());
            statement.setString(9, new_members.getPhonenumber1());
            statement.setString(10, new_members.getPhonenumber2());
            statement.setString(11, new_members.getEmailaddress());
            statement.setString(12, new_members.getRegistereddate());
            statement.setString(13, new_members.getMembertype());
            statement.setInt(14, new_members.getIsblocked());
            statement.setString(15, new_members.getUsername());
            statement.setString(16, new_members.getPassword());
            statement.execute();

            System.out.println("Successfully Updated.");

        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_members(int idmembers, Connection conn) {
        try {
            String query = "DELETE FROM members WHERE idmembers = '" + idmembers + "'; ";
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
            for (int i = 0; i < members.getData().size(); i++) {
                System.out.println(members.getData().get(i).toString().replace("[", "").replace("]", ""));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- [RETURN VALUES]
    public boolean function_is_idnumber_exist_notLike_idmembers(String idnumber, int idmembers, Connection conn) {
        try {
            String query = "SELECT m.idnumber FROM members AS m WHERE m.idnumber = '" + idnumber + "' AND m.idmembers NOT LIKE '" + idmembers + "';";
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

    public boolean function_is_username_exist(String username, Connection conn) {
        try {
            String query = "SELECT m.idmembers FROM members AS m WHERE m.username = '" + username + "';";
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

    public boolean function_is_password_exist(String password, Connection conn) {
        try {
            String query = "SELECT m.idmembers FROM members AS m WHERE m.password = '" + password + "';";
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

    public boolean function_is_password_exist_notLike_idmembers(int idmembers, String password, Connection conn) {
        try {
            String query = "SELECT m.idmembers FROM members AS m WHERE m.`password` = '" + password + "' AND m.idmembers NOT LIKE '" + idmembers + "';";
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

    public boolean function_is_username_exist_notLike_idmembers(int idmembers, String username, Connection conn) {
        try {
            String query = "SELECT m.idmembers FROM members AS m WHERE m.username = '" + password + "' AND m.idmembers NOT LIKE '" + idmembers + "';";
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

    public boolean function_is_username_password_exist(String username, String password, Connection conn) {
        try {
            String query = "SELECT m.idmembers FROM members AS m WHERE m.username = '" + username + "' AND m.`password` = '" + password + "';";
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

    public int function_get_idmembers(String username, String password, Connection conn) {
        try {
            String query = "SELECT m.idmembers FROM members AS m WHERE m.username = '" + username + "' AND m.`password` = '" + password + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int m_idmembers_rs = rs.getInt("m.idmembers");
                return m_idmembers_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return 0;
    }

    public String function_get_idnumber(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.idnumber FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_idnumber_rs = rs.getString("m.idnumber");
                return m_idnumber_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_firstname(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.firstname FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_firstname_rs = rs.getString("m.firstname");
                return m_firstname_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_firstname_lastname(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.firstname, m.lastname FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_firstname_rs = rs.getString("m.firstname");
                String m_lastname_rs = rs.getString("m.lastname");
                System.out.println(m_firstname_rs+" "+m_lastname_rs);
                return m_firstname_rs+" "+m_lastname_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_firstname(String idnumber, Connection conn) {
        try {
            String query = "SELECT m.firstname FROM members AS m WHERE m.idnumber = '" + idnumber + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_firstname_rs = rs.getString("m.firstname");
                return m_firstname_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_middleinitial(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.middleinitial FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_middleinitial_rs = rs.getString("m.middleinitial");
                return m_middleinitial_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_lastname(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.lastname FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_lastname_rs = rs.getString("m.lastname");
                return m_lastname_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_lastname(String idnumber, Connection conn) {
        try {
            String query = "SELECT m.lastname FROM members AS m WHERE m.idnumber = '" + idnumber + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_lastname_rs = rs.getString("m.lastname");
                return m_lastname_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public java.util.Date function_get_dateofbirth(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.dateofbirth FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                java.util.Date m_dateofbirth_rs = rs.getDate("m.dateofbirth");
                return m_dateofbirth_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_gender(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.gender FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_gender_rs = rs.getString("m.gender");
                return m_gender_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_address1(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.address1 FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_address1_rs = rs.getString("m.address1");
                return m_address1_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_address2(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.address2 FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_address2_rs = rs.getString("m.address2");
                return m_address2_rs;
            }
        } catch (Exception sqle) {
            System.err.println(sqle);

        }
        return null;
    }

    public String function_get_phonenumber1(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.phonenumber1 FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_phonenumber1_rs = rs.getString("m.phonenumber1");
                return m_phonenumber1_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_phonenumber2(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.phonenumber2 FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_phonenumber2_rs = rs.getString("m.phonenumber2");
                return m_phonenumber2_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_emailaddress(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.emailaddress FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_emailaddress_rs = rs.getString("m.emailaddress");
                return m_emailaddress_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public java.util.Date function_get_registereddate(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.registereddate ROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                java.util.Date m_registereddate_rs = rs.getDate("m.registereddate");
                return m_registereddate_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_membertype(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.membertype FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_membertype_rs = rs.getString("m.membertype");
                return m_membertype_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public boolean function_get_isblocked(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.isblocked FROM members AS m WHERE m.idmembers = '" + idmembers + "' AND m.isblocked = '1';";
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

    public String function_get_username(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.username FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_username_rs = rs.getString("m.username");
                return m_username_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

    public String function_get_password(int idmembers, Connection conn) {
        try {
            String query = "SELECT m.password FROM members AS m WHERE m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String m_password_rs = rs.getString("m.password");
                return m_password_rs;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return null;
    }

// ----------------------------------------------------------------------------- [SELECT INFORMATION]
    public int count_select_all(Connection conn) {
        try {
            String query = "SELECT Count(m.idmembers) as resultCount FROM members AS m;";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                ResultSet rs;
                rs = statement.executeQuery();
                while (rs.next()) {
                    int m_resultCount_rs = rs.getInt("resultCount");
                    return m_resultCount_rs;
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

    public int count_select_all_by_membertype(String membertype, Connection conn) {
        try {
            String query = "SELECT Count(m.idmembers) as resultCount FROM members AS m WHERE m.membertype = '" + membertype + "';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
                ResultSet rs;
                rs = statement.executeQuery();
                while (rs.next()) {
                    int m_resultCount_rs = rs.getInt("resultCount");
                    return m_resultCount_rs;
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

    public int select_all(Connection conn) {
        members.setData(new Vector());
        try {
            String query = "SELECT m.idmembers, m.idnumber, m.firstname, m.middleinitial, m.lastname, m.dateofbirth, m.gender, m.address1, m.address2, m.phonenumber1, m.phonenumber2, m.emailaddress, m.registereddate, m.membertype, m.isblocked, m.username, m.`password` FROM members AS m ;";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_all(int limitFrom, int limitTo, Connection conn) {
        members.setData(new Vector());
        try {
            String query = "SELECT m.idmembers, m.idnumber, m.firstname, m.middleinitial, m.lastname, m.dateofbirth, m.gender, m.address1, m.address2, m.phonenumber1, m.phonenumber2, m.emailaddress, m.registereddate, m.membertype, m.isblocked, m.username, m.`password` FROM members AS m LIMIT " + limitFrom + ", " + limitTo + ";";
            int resultCount = executeQuery_all(query, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_all_by_membertype(String membertype, int limitFrom, int limitTo, Connection conn) {
        members.setData(new Vector());
        try {
            String query = "SELECT m.idmembers, m.idnumber, m.firstname, m.middleinitial, m.lastname, m.dateofbirth, m.gender, m.address1, m.address2, m.phonenumber1, m.phonenumber2, m.emailaddress, m.registereddate, m.membertype, m.isblocked, m.username, m.`password` FROM members AS m WHERE m.membertype = '" + membertype + "' LIMIT " + limitFrom + ", " + limitTo + ";";
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
                int m_idmembers_rs = rs.getInt("m.idmembers");
                String m_idnumber_rs = rs.getString("m.idnumber");
                String m_firstname_rs = rs.getString("m.firstname");
                String m_middleinitial_rs = rs.getString("m.middleinitial");
                String m_lastname_rs = rs.getString("m.lastname");
                java.util.Date m_dateofbirth_rs = rs.getDate("m.dateofbirth");
                String m_gender_rs = rs.getString("m.gender");
                String m_address1_rs = rs.getString("m.address1");
                String m_address2_rs = rs.getString("m.address2");
                String m_phonenumber1_rs = rs.getString("m.phonenumber1");
                String m_phonenumber2_rs = rs.getString("m.phonenumber2");
                String m_emailaddress_rs = rs.getString("m.emailaddress");
                java.util.Date m_registereddate_rs = rs.getDate("m.registereddate");
                String m_membertype_rs = rs.getString("m.membertype");
                boolean m_isblocked_rs = rs.getBoolean("m.isblocked");
                String m_username_rs = rs.getString("m.username");
                String m_password_rs = rs.getString("m.password");

                Vector row = new Vector();
                row.add(m_idmembers_rs);
                row.add(m_idnumber_rs);
                row.add(m_firstname_rs);
                row.add(m_middleinitial_rs);
                row.add(m_lastname_rs);
                row.add(m_dateofbirth_rs);
                row.add(m_gender_rs);
                row.add(m_address1_rs);
                row.add(m_address2_rs);
                row.add(m_phonenumber1_rs);
                row.add(m_phonenumber2_rs);
                row.add(m_emailaddress_rs);
                row.add(m_registereddate_rs);
                row.add(m_membertype_rs);
                row.add(m_isblocked_rs);
                row.add(m_username_rs);
                row.add(m_password_rs);
                members.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }

    /* search */
    public int count_select_search(String search, Connection conn) {
        try {
            String query = "SELECT Count(m.idmembers) as resultCount FROM members AS m WHERE m.idnumber LIKE '%" + search + "%' OR m.firstname LIKE '%" + search + "%' OR m.lastname LIKE '%" + search + "%' OR m.gender LIKE '%" + search + "%' OR m.address1 LIKE '%" + search + "%' OR m.address2 LIKE '%" + search + "%' OR m.phonenumber1 LIKE '%" + search + "%' OR m.phonenumber2 LIKE '%" + search + "%' OR m.emailaddress LIKE '%" + search + "%' OR m.membertype LIKE '%" + search + "%';";
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
        members.setData(new Vector());
        try {
            String query = "SELECT m.idmembers, m.idnumber, m.firstname, m.middleinitial, m.lastname, m.gender, m.membertype, m.phonenumber1, m.phonenumber2 FROM members AS m WHERE m.idnumber LIKE '%" + search + "%' OR m.firstname LIKE '%" + search + "%' OR m.lastname LIKE '%" + search + "%' OR m.gender LIKE '%" + search + "%' OR m.address1 LIKE '%" + search + "%' OR m.address2 LIKE '%" + search + "%' OR m.phonenumber1 LIKE '%" + search + "%' OR m.phonenumber2 LIKE '%" + search + "%' OR m.emailaddress LIKE '%" + search + "%' OR m.membertype LIKE '%" + search + "%' LIMIT " + limitFrom + ", " + limitTo + ";";
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
                int m_idmembers_rs = rs.getInt("m.idmembers");
                String m_idnumber_rs = rs.getString("m.idnumber");
                String m_firstname_rs = rs.getString("m.firstname");
                String m_middleinitial_rs = rs.getString("m.middleinitial");
                String m_lastname_rs = rs.getString("m.lastname");
                String m_gender_rs = rs.getString("m.gender");
                String m_membertype_rs = rs.getString("m.membertype");
                String m_phonenumber1_rs = rs.getString("m.phonenumber1");
                String m_phonenumber2_rs = rs.getString("m.phonenumber2");
                double get_totalFines = function_get_sum_fines_by_idmembers(m_idmembers_rs, conn);

                Vector row = new Vector();
                row.add(m_idmembers_rs);
                row.add(m_idnumber_rs);
                row.add(m_firstname_rs);
                row.add(m_middleinitial_rs);
                row.add(m_lastname_rs);
                row.add(m_gender_rs);
                row.add(m_membertype_rs);
                row.add(m_phonenumber1_rs);
                row.add(m_phonenumber2_rs);
                row.add(get_totalFines);
                members.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }

    private double function_get_sum_fines_by_idmembers(int idmembers, Connection conn) {
        double fines = 0;
        try {
            String query = "SELECT Sum(br.finedamount) AS totalFines FROM books AS b , borrow AS br , members AS m WHERE b.idbooks = br.books_idbooks AND m.idmembers = br.members_idmembers AND m.idmembers = '" + idmembers + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                double m_totalFines_rs = rs.getDouble("totalFines");
                return m_totalFines_rs;
            }
        } catch (Exception sqle) {
            System.err.println(sqle);

        }
        return fines;
    }
    /**/
}
