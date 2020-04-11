package gui.booksreservation.main;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import mcbx.jb.classes.mycollection.MyFunctions;

public class JF_Calendar extends javax.swing.JFrame {

    private JCalendar cal = new JCalendar();

    public JF_Calendar() {
        initComponents();

// ----------------------------------------------------------------------------- CALENDAR
        cal.setWeekOfYearVisible(false);
        cal.setWeekdayForeground(Color.black);
        cal.setTodayButtonVisible(true);
        cal.setMaxDayCharacters(1);
        cal.setOpaque(false);
        cal.setFocusable(true);

        cal.setDecorationBordersVisible(true);
        cal.setDecorationBackgroundVisible(true);
        cal.setDecorationBackgroundColor(Color.black);
        cal.setWeekdayForeground(Color.green);
        cal.setSundayForeground(Color.red);

        cal.setBackground(Color.black);
        cal.setForeground(Color.black);

        jPanelCalendar.add(cal);


// ----------------------------------------------------------------------------- CALENDAR LISTENERS
//          String MDY = new MyFunctions().function_get_YearMonthDay(cal.getDate());
//          jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(MDY));
        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(new SimpleDateFormat("MMMM dd, yyyy").format(cal.getDate())));

        cal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
//                    String MonthDayYear = new MyFunctions().function_get_YearMonthDay(cal.getDate());
//                    jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(MonthDayYear));

//                    System.out.println(new SimpleDateFormat("MMMM dd, yyyy").format(cal.getDate()));
                jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(new SimpleDateFormat("MMMM dd, yyyy").format(cal.getDate())));
            }
        });



    } // end JF_Calendar();    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCalendar = new javax.swing.JPanel();

        setTitle("Calendar");
        setResizable(false);

        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanelCalendar.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {


// ----------------------------------------------------------------------------- Nimbus LOOK&FEEL       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JF_Calendar instanceThis = new JF_Calendar();
                instanceThis.setLocationRelativeTo(null);
                instanceThis.setVisible(true);

            }
        });

    } // end main();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelCalendar;
    // End of variables declaration//GEN-END:variables

// ----------------------------------------------------------------------------- MONTH SPINNER
    static protected String[] getMonthStrings() {
        String[] months = new java.text.DateFormatSymbols().getMonths();
        int lastIndex = months.length - 1;

        if (months[lastIndex] == null
                || months[lastIndex].length() <= 0) { //last item empty
            String[] monthStrings = new String[lastIndex];
            System.arraycopy(months, 0,
                    monthStrings, 0, lastIndex);
            return monthStrings;
        } else { //last item not empty
            return months;
        }
    } // end getMonthStrings();

    public JFormattedTextField getTextField(JSpinner spinner) {
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            return ((JSpinner.DefaultEditor) editor).getTextField();
        } else {
            System.err.println("Unexpected editor type: "
                    + spinner.getEditor().getClass()
                    + " isn't a descendant of DefaultEditor");
            return null;
        }
    } // end getTextField();
}
