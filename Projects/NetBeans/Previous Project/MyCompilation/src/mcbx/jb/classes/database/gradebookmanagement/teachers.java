/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcbx.jb.classes.database.gradebookmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class teachers {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int id;
    private String firstName = null;
    private String middleName = null;
    private String lastName = null;
    private String sex;
    private String birthDate = null;
    private String streetAddress = null;
    private String barangayAddress = null;
    private String municipality = null;
    private String province = null;
    private String contactNumber = null;
    private String alternativeContactNumber = null;
    private String teachersType = null;
    private String information = null;

    private String querySearch;
    private int queryLimitFrom;
    private int queryLimitTo;

    private int[] array_id;

    public int[] getArray_id() {
        return array_id;
    }

    public void setArray_id(int[] array_id) {
        this.array_id = array_id;
    }

    public String getQuerySearch() {
        return querySearch;
    }

    public void setQuerySearch(String querySearch) {
        this.querySearch = querySearch;
    }

    public int getQueryLimitFrom() {
        return queryLimitFrom;
    }

    public void setQueryLimitFrom(int queryLimitFrom) {
        this.queryLimitFrom = queryLimitFrom;
    }

    public int getQueryLimitTo() {
        return queryLimitTo;
    }

    public void setQueryLimitTo(int queryLimitTo) {
        this.queryLimitTo = queryLimitTo;
    }

    public static Vector getData() {
        return data;
    }

    public static void setData(Vector data) {
        teachers.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getBarangayAddress() {
        return barangayAddress;
    }

    public void setBarangayAddress(String barangayAddress) {
        this.barangayAddress = barangayAddress;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAlternativeContactNumber() {
        return alternativeContactNumber;
    }

    public void setAlternativeContactNumber(String alternativeContactNumber) {
        this.alternativeContactNumber = alternativeContactNumber;
    }

    public String getTeachersType() {
        return teachersType;
    }

    public void setTeachersType(String teachersType) {
        this.teachersType = teachersType;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public teachers() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_teachers_name_exist(teachers i_this, Connection conn) {
        try {
            String q1 = "SELECT " + className + ".id FROM " + className + " "
                    + "WHERE " + className + ".firstName LIKE '" + i_this.getFirstName() + "' "
                    + "AND " + className + ".lastName LIKE '" + i_this.getLastName() + "' "
                    + "AND " + className + ".middleName LIKE '" + i_this.getMiddleName() + "';";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return false;
    }

    public String function_get_teachers_firstName(teachers i_this, Connection conn) {
        try {
            String q1 = "SELECT firstName FROM " + className + " "
                    + "WHERE " + className + ".id = " + i_this.getId() + " ;";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                return rs.getString("firstName");
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";

    }

    public String function_get_teachers_middleName(teachers i_this, Connection conn) {
        try {
            String q1 = "SELECT lastName FROM " + className + " "
                    + "WHERE " + className + ".id = " + i_this.getId() + " ;";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                return rs.getString("lastName");
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";

    }

    public String function_get_teachers_lastName(teachers i_this, Connection conn) {
        try {
            String q1 = "SELECT middleName FROM " + className + " "
                    + "WHERE " + className + ".id = " + i_this.getId() + " ;";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                return rs.getString("middleName");
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";
    }


    public String function_get_teachers_firstName_lastName(int teachers_id, Connection conn) {
        try {
            String q1 = "SELECT firstName, lastName FROM " + className + " "
                    + "WHERE " + className + ".id = " + teachers_id + " ;";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                String firstName_rs = rs.getString("firstName");
                String lastName_rs = rs.getString("lastName");
                return rs.getString(firstName_rs+" "+lastName_rs);
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";

    }


    public String function_get_teachers_teachersType(teachers i_this, Connection conn) {
        try {
            String q1 = "SELECT teachersType FROM " + className + " "
                    + "WHERE " + className + ".id = " + i_this.getId() + " ;";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            ResultSet rs = s1.executeQuery();
            while (rs.next()) {
                return rs.getString("teachersType");
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return "";

    }

// ----------------------------------------------------------------------------- [INSERT]
    public String insert_teachers(teachers i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (firstName,middleName,lastName,sex,birthDate,streetAddress,barangayAddress,municipality,province,contactNumber,alternativeContactNumber,teachersType,information) values (?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getFirstName());
            s1.setString(2, i_this.getMiddleName());
            s1.setString(3, i_this.getLastName());
            s1.setString(4, i_this.getSex());
            s1.setString(5, i_this.getBirthDate());
            s1.setString(6, i_this.getStreetAddress());
            s1.setString(7, i_this.getBarangayAddress());
            s1.setString(8, i_this.getMunicipality());
            s1.setString(9, i_this.getProvince());
            s1.setString(10, i_this.getContactNumber());
            s1.setString(11, i_this.getAlternativeContactNumber());
            s1.setString(12, i_this.getTeachersType());
            s1.setString(13, i_this.getInformation());
            s1.execute();

            return (globalmessages.crude_info_insert);
        } catch (SQLException sqle) {
            return (globalmessages.crude_error_insert + "\n" + sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public String update_teachers(teachers i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET "
                    + "firstName=?,"
                    + "middleName=?,"
                    + "lastName=?,"
                    + "sex=?,"
                    + "birthDate=?,"
                    + "streetAddress=?,"
                    + "barangayAddress=?,"
                    + "municipality=?,"
                    + "province=?,"
                    + "contactNumber=?,"
                    + "alternativeContactNumber=?, "
                    + "teachersType=?, "
                    + "information=? "
                    + "WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getFirstName());
            s1.setString(2, i_this.getMiddleName());
            s1.setString(3, i_this.getLastName());
            s1.setString(4, i_this.getSex());
            s1.setString(5, i_this.getBirthDate());
            s1.setString(6, i_this.getStreetAddress());
            s1.setString(7, i_this.getBarangayAddress());
            s1.setString(8, i_this.getMunicipality());
            s1.setString(9, i_this.getProvince());
            s1.setString(10, i_this.getContactNumber());
            s1.setString(11, i_this.getAlternativeContactNumber());
            s1.setString(12, i_this.getTeachersType());
            s1.setString(13, i_this.getInformation());
            s1.execute();

             return (globalmessages.crude_info_update);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            return (globalmessages.crude_error_update+"\n"+sqle);
        }
    }

    public void update_teachers_teachersType(teachers i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET "
                    + "teachersType=? "
                    + "WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getTeachersType());
            s1.execute();

            System.out.println("Successfully Updated.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_teachers(teachers i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();

            System.out.println("Successfully Deleted.");
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_teachers_array(teachers i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_id().length; x++) {
                String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getArray_id()[x] + "; ";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();
            }
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

// ----------------------------------------------------------------------------- [QUERY]
    public int count_select_search(teachers i_this, Connection conn) {
        try {
            String q1 = "SELECT Count(t.id) as resultCount "
                    + "FROM " + className + " AS t "
                    + "WHERE "
                    + "t.firstName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "t.middleName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "t.lastName LIKE '%" + i_this.getQuerySearch() + "%';";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q1);
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

    public int select_teachers_by_search(teachers i_this, Connection conn) {
        teachers.setData(new Vector());
        try {
            String q1 = "SELECT t.id, t.firstName, t.middleName, t.lastName, t.sex, t.birthDate, t.streetAddress, t.barangayAddress, t.municipality, t.province, t.contactNumber, t.alternativeContactNumber, t.teachersType, t.information "
                    + "FROM " + className + " AS t "
                    + "WHERE t.firstName LIKE '%" + i_this.getQuerySearch() + "%' OR t.middleName LIKE '%" + i_this.getQuerySearch() + "%' OR t.lastName LIKE '%" + i_this.getQuerySearch() + "%' "
                    + "LIMIT " + i_this.getQueryLimitFrom() + ", " + i_this.getQueryLimitTo() + ";";
            int resultCount = executeQuery(q1, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public String select_String_attributes(teachers i_this, String attributes, Connection conn) {
        String returnValue = null;
        try {
            String q1 = "SELECT " + attributes + " as attributes "
                    + "FROM " + className + " "
                    + "WHERE id = " + i_this.getId() + ";";
            try {
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                ResultSet rs;
                rs = s1.executeQuery();
                while (rs.next()) {
                    return rs.getString("attributes");
                }
                rs.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return returnValue;
    }

    public java.util.Date select_Date_attributes(teachers i_this, String attributes, Connection conn) {
        java.util.Date birthDate_rs = null;
        try {
            String q1 = "SELECT " + attributes + " as attributes "
                    + "FROM " + className + " "
                    + "WHERE id = " + i_this.getId() + ";";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q1);
                ResultSet rs;
                rs = statement.executeQuery();
                while (rs.next()) {
                    birthDate_rs = rs.getDate("attributes");
                }
                rs.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return birthDate_rs;
    }

// ----------------------------------------------------------------------------- [EXECUTE QUERY]
    private int executeQuery(String query, Connection conn) {
        int resultCount = 0;
        try {
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs;
            rs = s1.executeQuery();
            while (rs.next()) {
                resultCount++;
                int id_rs = rs.getInt("t.id");
                String firstName_rs = rs.getString("t.firstName");
                String middleName_rs = rs.getString("t.middleName");
                String lastName_rs = rs.getString("t.lastName");
                String sex_rs = rs.getString("t.sex");
                java.util.Date birthDate_rs = rs.getDate("t.birthDate");
                String streetAddress_rs = rs.getString("t.streetAddress");
                String barangayAddress_rs = rs.getString("t.barangayAddress");
                String municipality_rs = rs.getString("t.municipality");
                String province_rs = rs.getString("t.province");
                String contactNumber_rs = rs.getString("t.contactNumber");
                String alternativeContactNumber_rs = rs.getString("t.alternativeContactNumber");
                String teachersType_rs = rs.getString("t.teachersType");
                String information_rs = rs.getString("t.information");

                Vector row = new Vector();
                row.add(id_rs);
                row.add(firstName_rs);
                row.add(middleName_rs);
                row.add(lastName_rs);
                row.add(sex_rs);
                row.add(birthDate_rs);
                row.add(streetAddress_rs);
                row.add(barangayAddress_rs);
                row.add(municipality_rs);
                row.add(province_rs);
                row.add(contactNumber_rs);
                row.add(alternativeContactNumber_rs);
                row.add(teachersType_rs);
                row.add(information_rs);
                teachers.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }
}
