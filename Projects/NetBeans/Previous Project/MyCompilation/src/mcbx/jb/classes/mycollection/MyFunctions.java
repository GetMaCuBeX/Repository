package mcbx.jb.classes.mycollection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;

public class MyFunctions {

// ----------------------------------------------------------------------------- RETURN MONTHS
    static protected String[] getMonthStrings() {
        String[] months = new java.text.DateFormatSymbols().getMonths();
        int lastIndex = months.length - 1;
        if (months[lastIndex] == null || months[lastIndex].length() <= 0) { //last item empty
            String[] monthStrings = new String[lastIndex];
            System.arraycopy(months, 0, monthStrings, 0, lastIndex);
            return monthStrings;
        } else { //last item not empty
            return months;
        }
    }

// ----------------------------------------------------------------------------- RETURN YYYY-MM-DD
    enum Month_MMM {

        Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
    }

    enum Month_MMMM {

        January, February, March, April, May, June, July, August, September, October, November, December
    }

    public String function_get_YearMonthDay(java.util.Date date) {
        String f_YearMonthDay = null;
        try {
            //Tue Sep 25 01:19:25 CST 2012  ---> java.util.Date
            //tokens[0] - Mon
            //tokens[1] - Oct
            //tokens[2] - 08
            //tokens[3] - 21:08:28
            //tokens[4] - PDT
            //tokens[5] - 2012
            if (date != null) {
                String[] tokens = date.toString().split(" ");
                String year = tokens[5];
                String month = tokens[1];
                int f_month = function_get_Month(month);
                String day = tokens[2];
                f_YearMonthDay = year + "-" + f_month + "-" + day;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return f_YearMonthDay;
    }

    public int function_get_Month(String month) {
        int f_Month = 0;
        try {
            switch (month.length()) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    f_Month = ((Month_MMM.valueOf(month)).ordinal() + 1);
                    break;
                default:
                    f_Month = ((Month_MMMM.valueOf(month)).ordinal() + 1);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return f_Month;
    }

    public String function_get_Month(int month) {
        String f_Month = null;
        try {
            switch (month) {
                case 1:
                    f_Month = "January";
                    break;
                case 2:
                    f_Month = "February";
                    break;
                case 3:
                    f_Month = "March";
                    break;
                case 4:
                    f_Month = "April";
                    break;
                case 5:
                    f_Month = "May";
                    break;
                case 6:
                    f_Month = "June";
                    break;
                case 7:
                    f_Month = "July";
                    break;
                case 8:
                    f_Month = "August";
                    break;
                case 9:
                    f_Month = "September";
                    break;
                case 10:
                    f_Month = "October";
                    break;
                case 11:
                    f_Month = "November";
                    break;
                case 12:
                    f_Month = "December";
                    break;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return f_Month;
    }

    public java.sql.Date select_currentDate(Connection conn) {
        try {
            String state = "SELECT CURDATE()AS CURRENTDATE;";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(state);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                java.sql.Date rs_currentDate = rs.getDate("CURRENTDATE");
                return rs_currentDate;

            }
            rs.close();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
        return null;
    }

    public java.sql.Date select_addedDate(String dateString, int addDate, Connection conn) {
        try {
            String QueryAddDate = "SELECT ADDDATE('" + dateString + "', " + addDate + ") AS addedDate";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(QueryAddDate);
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                java.sql.Date rs_addedDate = rs.getDate("addedDate");
                return rs_addedDate;
            }
            rs.close();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
        return null;
    }

// ----------------------------------------------------------------------------- SIMPLE DATE FORMAT
    public String return_DateTime(String DateTimeFormat) {
        //System.out.println(return_DateTime("HH:mm:ss"));
        //String YMD = NOW("yyyy-MM-dd");
        //String TIME = NOW("hh:mm:ss a");
        Calendar CAL = Calendar.getInstance();
        SimpleDateFormat SDF = new SimpleDateFormat(DateTimeFormat);
        return SDF.format(CAL.getTime());
    }

// ----------------------------------------------------------------------------- RETURN IMAGE ICON
    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ClassLoader.getSystemResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}