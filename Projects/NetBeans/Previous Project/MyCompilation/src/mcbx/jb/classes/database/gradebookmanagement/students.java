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
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class students {

    final private String className = this.getClass().getSimpleName();
    private static Vector data;
    private int id;
    private String firstName = null;
    private String middleName = null;
    private String lastName = null;
    private String sex;
    private String birthDate = null;
    private String religion = null;
    private String ethnicGroup = null;
    private String streetAddress = null;
    private String barangayAddress = null;
    private String municipality = null;
    private String province = null;
    private String fatherName = null;
    private String motherName = null;
    private String occupation = null;
    private String guardianName = null;
    private String guardianAddress = null;
    private String guardianRelationship = null;
    private String guardianOccupation = null;
    private String guardianContactNumber = null;
    private String LRN = null;
    private String registeredDate = null;
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

    public String getQuerySearch() {
        return querySearch;
    }

    public void setQuerySearch(String querySearch) {
        this.querySearch = querySearch;
    }

    public static Vector getData() {
        return data;
    }

    public static void setData(Vector data) {
        students.data = data;
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

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianAddress() {
        return guardianAddress;
    }

    public void setGuardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress;
    }

    public String getGuardianRelationship() {
        return guardianRelationship;
    }

    public void setGuardianRelationship(String guardianRelationship) {
        this.guardianRelationship = guardianRelationship;
    }

    public String getGuardianOccupation() {
        return guardianOccupation;
    }

    public void setGuardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
    }

    public String getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public void setGuardianContactNumber(String guardianContactNumber) {
        this.guardianContactNumber = guardianContactNumber;
    }

    public String getLRN() {
        return LRN;
    }

    public void setLRN(String LRN) {
        this.LRN = LRN;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getBarangayAddress() {
        return barangayAddress;
    }

    public void setBarangayAddress(String barangayAddress) {
        this.barangayAddress = barangayAddress;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public students() {
    }

// ----------------------------------------------------------------------------- [RETURN]
    public boolean function_is_students_id_exist(students i_this, Connection conn) {
        try {
            String q1 = "SELECT " + className + ".id FROM " + className + " "
                    + "WHERE " + className + ".id = " + i_this.getId() + ";";
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

    public boolean function_is_students_name_exist(students i_this, Connection conn) {
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

    public boolean function_is_students_has_foreignKey(int students_id, Connection conn) {
//        try {
//            String q1 = "";
//            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
//            ResultSet rs = s1.executeQuery();
//            while (rs.next()) {
//                return true;
//            }
//        } catch (SQLException sqle) {
//            System.err.println(sqle);
//        }
        return false;
    }

    public String function_get_students_firstName(students i_this, Connection conn) {
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

    public String function_get_students_lastName(students i_this, Connection conn) {
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

    public String function_get_students_middleName(students i_this, Connection conn) {
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

// ----------------------------------------------------------------------------- [INSERT]
    public String insert_students(students i_this, Connection conn) {
        try {
            String q1 = "INSERT INTO " + className + " (firstName,middleName,lastName,sex,birthDate,religion,ethnicGroup,streetAddress,barangayAddress,municipality,province,fatherName,motherName,occupation,guardianName,guardianAddress,guardianRelationship,guardianOccupation,guardianContactNumber,LRN,registeredDate,information) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getFirstName());
            s1.setString(2, i_this.getMiddleName());
            s1.setString(3, i_this.getLastName());
            s1.setString(4, i_this.getSex());
            s1.setString(5, i_this.getBirthDate());
            s1.setString(6, i_this.getReligion());
            s1.setString(7, i_this.getEthnicGroup());
            s1.setString(8, i_this.getStreetAddress());
            s1.setString(9, i_this.getBarangayAddress());
            s1.setString(10, i_this.getMunicipality());
            s1.setString(11, i_this.getProvince());
            s1.setString(12, i_this.getFatherName());
            s1.setString(13, i_this.getMotherName());
            s1.setString(14, i_this.getOccupation());
            s1.setString(15, i_this.getGuardianName());
            s1.setString(16, i_this.getGuardianAddress());
            s1.setString(17, i_this.getGuardianRelationship());
            s1.setString(18, i_this.getGuardianOccupation());
            s1.setString(19, i_this.getGuardianContactNumber());
            s1.setString(20, i_this.getLRN());
            s1.setString(21, i_this.getRegisteredDate());
            s1.setString(22, i_this.getInformation());
            s1.execute();

            return (globalmessages.crude_info_insert);
        } catch (SQLException sqle) {
            return (globalmessages.crude_error_insert + "\n" + sqle);
        }
    }

// ----------------------------------------------------------------------------- [UPDATE]
    public String update_students(students i_this, Connection conn) {
        try {
            String q1 = "UPDATE " + className + " SET "
                    + "firstName=?,"
                    + "middleName=?,"
                    + "lastName=?,"
                    + "sex=?,"
                    + "birthDate=?,"
                    + "religion=?,"
                    + "ethnicGroup=?,"
                    + "streetAddress=?,"
                    + "barangayAddress=?,"
                    + "municipality=?,"
                    + "province=?,"
                    + "fatherName=?,"
                    + "motherName=?,"
                    + "occupation=?,"
                    + "guardianName=?,"
                    + "guardianAddress=?,"
                    + "guardianRelationship=?,"
                    + "guardianOccupation=?,"
                    + "guardianContactNumber=?,"
                    + "LRN=?,"
                    + "registeredDate=?, "
                    + "information=? "
                    + "WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.setString(1, i_this.getFirstName());
            s1.setString(2, i_this.getMiddleName());
            s1.setString(3, i_this.getLastName());
            s1.setString(4, i_this.getSex());
            s1.setString(5, i_this.getBirthDate());
            s1.setString(6, i_this.getReligion());
            s1.setString(7, i_this.getEthnicGroup());
            s1.setString(8, i_this.getStreetAddress());
            s1.setString(9, i_this.getBarangayAddress());
            s1.setString(10, i_this.getMunicipality());
            s1.setString(11, i_this.getProvince());
            s1.setString(12, i_this.getFatherName());
            s1.setString(13, i_this.getMotherName());
            s1.setString(14, i_this.getOccupation());
            s1.setString(15, i_this.getGuardianName());
            s1.setString(16, i_this.getGuardianAddress());
            s1.setString(17, i_this.getGuardianRelationship());
            s1.setString(18, i_this.getGuardianOccupation());
            s1.setString(19, i_this.getGuardianContactNumber());
            s1.setString(20, i_this.getLRN());
            s1.setString(21, i_this.getRegisteredDate());
            s1.setString(22, i_this.getInformation());
            s1.execute();
            return (globalmessages.crude_info_update);
        } catch (SQLException sqle) {
            System.err.println(sqle);
            return (globalmessages.crude_error_update + "\n" + sqle);
        }
    }

// ----------------------------------------------------------------------------- [DELETE]
    public void delete_students(students i_this, Connection conn) {
        try {
            String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getId() + ";";
            PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
            s1.execute();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    public void delete_students_array(students i_this, Connection conn) {
        try {
            for (int x = 0; x < i_this.getArray_id().length; x++) {

                String q1 = "DELETE FROM " + className + " WHERE id = " + i_this.getArray_id()[x] + "; ";
                PreparedStatement s1 = (PreparedStatement) conn.prepareStatement(q1);
                s1.execute();

            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

    }

// ----------------------------------------------------------------------------- [QUERY]
    public int count_select_search(students i_this, Connection conn) {
        try {
            String q1 = "SELECT Count(s.id) as resultCount "
                    + "FROM " + className + " AS s "
                    + "WHERE "
                    + "s.firstName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "s.middleName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "s.lastName LIKE '%" + i_this.getQuerySearch() + "%' OR "
                    + "s.LRN LIKE '%" + i_this.getQuerySearch() + "%';";
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

    public String select_String_attributes(students i_this, String attributes, Connection conn) {
        String returnValue = null;
        try {
            String q1 = "SELECT " + attributes + " as attributes "
                    + "FROM " + className + " "
                    + "WHERE id = " + i_this.getId() + ";";
            try {
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q1);
                ResultSet rs;
                rs = statement.executeQuery();
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

    public java.util.Date select_Date_attributes(students i_this, String attributes, Connection conn) {
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

    public int select_students(Connection conn) {
        students.setData(new Vector());
        try {
            String q1 = "SELECT s.id, s.firstName, s.middleName, s.lastName, s.sex, s.birthDate, s.religion, s.ethnicGroup, s.streetAddress, s.barangayAddress, s.municipality, s.province, s.fatherName, s.motherName, s.occupation, s.guardianName, s.guardianAddress, s.guardianRelationship, s.guardianOccupation, s.guardianContactNumber, s.LRN, s.registeredDate FROM " + className + " AS s;";
            int resultCount = executeQuery(q1, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }

    public int select_students_by_search(students i_this, Connection conn) {
        students.setData(new Vector());
        try {
            String q1 = "SELECT s.id, s.firstName, s.middleName, s.lastName, s.sex, s.birthDate, s.religion, s.ethnicGroup, s.streetAddress, s.barangayAddress, s.municipality, s.province, s.fatherName, s.motherName, s.occupation, s.guardianName, s.guardianAddress, s.guardianRelationship, s.guardianOccupation, s.guardianContactNumber, s.LRN, s.registeredDate "
                    + "FROM " + className + " AS s "
                    + "WHERE s.firstName LIKE '%" + i_this.getQuerySearch() + "%' OR s.middleName LIKE '%" + i_this.getQuerySearch() + "%' OR s.lastName LIKE '%" + i_this.getQuerySearch() + "%' OR s.LRN LIKE '%" + i_this.getQuerySearch() + "%' "
                    + "LIMIT " + i_this.getQueryLimitFrom() + ", " + i_this.getQueryLimitTo() + ";";
            int resultCount = executeQuery(q1, conn);
            return resultCount;
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
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

                int id_rs = rs.getInt("s.id");
                String firstName_rs = rs.getString("s.firstName");
                String middleName_rs = rs.getString("s.middleName");
                String lastName_rs = rs.getString("s.lastName");
                String sex_rs = rs.getString("s.sex");
                java.util.Date birthDate_rs = rs.getDate("s.birthDate");
                String religion_rs = rs.getString("s.religion");
                String ethnicGroup_rs = rs.getString("s.ethnicGroup");
                String streetAddress_rs = rs.getString("s.streetAddress");
                String barangayAddress_rs = rs.getString("s.barangayAddress");
                String municipality_rs = rs.getString("s.municipality");
                String province_rs = rs.getString("s.province");
                String fatherName_rs = rs.getString("s.fatherName");
                String motherName_rs = rs.getString("s.motherName");
                String occupation_rs = rs.getString("s.occupation");
                String guardianName_rs = rs.getString("s.guardianName");
                String guardianAddress_rs = rs.getString("s.guardianAddress");
                String guardianRelationship_rs = rs.getString("s.guardianRelationship");
                String guardianOccupation_rs = rs.getString("s.guardianOccupation");
                String guardianContactNumber_rs = rs.getString("s.guardianContactNumber");
                String LRN_rs = rs.getString("s.LRN");
                String registeredDate_rs = rs.getString("s.registeredDate");

                Vector row = new Vector();
                row.add(id_rs);
                row.add(firstName_rs);
                row.add(middleName_rs);
                row.add(lastName_rs);
                row.add(sex_rs);
                row.add(birthDate_rs);
                row.add(religion_rs);
                row.add(ethnicGroup_rs);
                row.add(streetAddress_rs);
                row.add(barangayAddress_rs);
                row.add(municipality_rs);
                row.add(province_rs);
                row.add(fatherName_rs);
                row.add(motherName_rs);
                row.add(occupation_rs);
                row.add(guardianName_rs);
                row.add(guardianAddress_rs);
                row.add(guardianRelationship_rs);
                row.add(guardianOccupation_rs);
                row.add(guardianContactNumber_rs);
                row.add(LRN_rs);
                row.add(registeredDate_rs);
                students.getData().add(row);
            }
            rs.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return resultCount;
    }

}
