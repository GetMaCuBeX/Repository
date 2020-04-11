package mcbx.jb.classes.database.gradebookmanagement;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import mcbx.jb.classes.databaseconnection.MySQL;

public class TestClasses extends MySQL {

    private static MySQL gradebookmanagement;
    private static authentication ref_authentication = new authentication();

    public static void main(String[] args) {
        gradebookmanagement = new MySQL("localhost", "3306", "gradebookmanagement", "root", "");
        gradebookmanagement.connectToServer();
        Connection con1 = gradebookmanagement.getConnection();

        ref_authentication.setUsername("ian");
        ref_authentication.setPassword("ian");

        boolean isExist = ref_authentication.function_is_username_and_password_exist(ref_authentication, con1);
        if(isExist){
            System.out.println(ref_authentication.getTeachers_id());
        }

//        testConnection_MySQL();
//        gradeLevel i_gradeLevel = new gradeLevel();
//        i_gradeLevel.setId(13);
//        i_gradeLevel.setLevelName("12");
//        new gradeLevel().delete_gradeLevel(i_gradeLevel, con1);
//        teachersgradingsystem i1 = new teachersgradingsystem();
//        i1.setSchoolYear_id(1);
//        i1.setGradeLevel_id(1);
//        i1.setSectionName("A-1");
//        i1.setClasses_id(1);
//        i1.setTeachers_id(1);
//        System.out.println("Exist :" + new teachersgradingsystem().function_is_percentageTotal_100_percent(i1, con1) + "");
//       new classroomClassTeachers().update_classroomClassTeachers(i1, con1);
//       new students().delete_students(i1, con1);
    }

    private static void testConnection_MySQL() {
        try {
            gradebookmanagement.connectToServer();
        } catch (Exception ex) {
            Logger.getLogger(TestClasses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TestClasses(String serverHostname, String portNumber, String schema, String username, String password) {
        super(serverHostname, portNumber, schema, username, password);
    }
}
