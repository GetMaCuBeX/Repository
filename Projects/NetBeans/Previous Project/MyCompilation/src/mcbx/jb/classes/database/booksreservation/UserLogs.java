package mcbx.jb.classes.database.booksreservation;

public class UserLogs {

     private static int idmembers = 1;
     private static String membertype = "Administrator";

     public static int getIdmembers() {
          return idmembers;
     }

     public static void setIdmembers(int idmembers) {
          UserLogs.idmembers = idmembers;
     }

     public static String getMembertype() {
          return membertype;
     }

     public static void setMembertype(String membertype) {
          UserLogs.membertype = membertype;
     }
}
