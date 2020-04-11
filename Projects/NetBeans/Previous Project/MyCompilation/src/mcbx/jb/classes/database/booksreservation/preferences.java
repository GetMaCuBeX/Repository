package mcbx.jb.classes.database.booksreservation;

import java.util.Vector;

public class preferences {

     private static Vector data;
     private String settings;
     private int value;

     public static Vector getData() {
          return data;
     }

     public static void setData(Vector data) {
          preferences.data = data;
     }

// ----------------------------------------------------------------------------- [DISPLAY]
     public void display_preferences() {
          try {
               for (int i = 0; i < preferences.getData().size(); i++) {
                    System.out.println(preferences.getData().get(i).toString().replace("[", "").replace("]", ""));
               }
          } catch (Exception e) {
               System.err.println(e);
          }
     }
// ----------------------------------------------------------------------------- [RETURN VALUES]
}
