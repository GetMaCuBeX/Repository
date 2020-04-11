package mcbx.jb.classes.database.gradebookmanagement;

public class UserLogs {

    private static int teachers_id = 0;
    private static String teachersType = "Administrator";
    private static int schoolyear_id = 0;
    private static int gradelevel_id = 0;

    public static int getSchoolyear_id() {
        return schoolyear_id;
    }

    public static void setSchoolyear_id(int schoolyear_id) {
        UserLogs.schoolyear_id = schoolyear_id;
    }

    public static int getGradelevel_id() {
        return gradelevel_id;
    }

    public static void setGradelevel_id(int gradelevel_id) {
        UserLogs.gradelevel_id = gradelevel_id;
    }

    public static int getTeachers_id() {
        return teachers_id;
    }

    public static void setTeachers_id(int teachers_id) {
        UserLogs.teachers_id = teachers_id;
    }

    public static String getTeachersType() {
        return teachersType;
    }

    public static void setTeachersType(String teachersType) {
        UserLogs.teachersType = teachersType;
    }

}
