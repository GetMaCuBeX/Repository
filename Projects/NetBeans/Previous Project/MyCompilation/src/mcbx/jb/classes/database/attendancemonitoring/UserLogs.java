package mcbx.jb.classes.database.attendancemonitoring;

import mcbx.jb.classes.database.waterlevelmonitoring.*;

public class UserLogs {

     public static int iduser;
     public static String type;

     public static int getIduser() {
          return iduser;
     }

     public static void setIduser(int iduser) {
          UserLogs.iduser = iduser;
     }

     public static String getType() {
          return type;
     }

     public static void setType(String type) {
          UserLogs.type = type;
     }
}
