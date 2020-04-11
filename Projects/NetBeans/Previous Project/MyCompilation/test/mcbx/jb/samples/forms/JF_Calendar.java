package mcbx.jb.samples.forms;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import mcbx.jb.classes.mycollection.CyclingSpinnerListModel;
import mcbx.jb.classes.mycollection.MyFunctions;

public class JF_Calendar extends javax.swing.JFrame {

     private JCalendar cal = new JCalendar();
     private JDateChooser dc = new JDateChooser(null, null, null, new JSpinnerDateEditor());
     private MyFunctions ref_MyFunctions = new MyFunctions();

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

// ----------------------------------------------------------------------------- POPUP CALENDAR DATECHOOSER
          dc.setDateFormatString("MMMM d, yyyy");
          Calendar dateMin = Calendar.getInstance();
          Calendar dateMax = Calendar.getInstance();
          dateMin.set(2012, 1 - 1, 2); // set callendar
          dateMax.set(2012, 11 - 1, 10); // set callendar
          Date minSD = dateMin.getTime();
          Date maxSD = dateMax.getTime();
          dc.setMinSelectableDate(minSD);
          dc.setMaxSelectableDate(maxSD);
          //((JDateChooser) dc).getJCalendar().getDayChooser().addDateEvaluator(new BirthdayEvaluator());
          //((JDateChooser) dc).getJCalendar().getDayChooser().addDateEvaluator(new TestDateEvaluator());
          ((JDateChooser) dc).getJCalendar().setTodayButtonVisible(true);
          ((JDateChooser) dc).getJCalendar().setNullDateButtonVisible(true);

          ((JDateChooser) dc).getJCalendar().setDecorationBordersVisible(false);
          ((JDateChooser) dc).getJCalendar().setDecorationBackgroundColor(Color.black);
          ((JDateChooser) dc).getJCalendar().setWeekdayForeground(Color.white);
          ((JDateChooser) dc).getJCalendar().setSundayForeground(Color.red);
          ((JDateChooser) dc).getJCalendar().setDecorationBackgroundVisible(true);

          ((JDateChooser) dc).getJCalendar().setWeekOfYearVisible(false);
          ((JDateChooser) dc).getJCalendar().setMaxDayCharacters(1);
          ((JDateChooser) dc).getJCalendar().setBackground(Color.black);
          jPanelCallendarDateChooser.add(dc);

// ----------------------------------------------------------------------------- MONTH SPINNER
          JFormattedTextField FTF = null;
          boolean monthFormat = true;
          String[] monthStrings = getMonthStrings(); //get month names
          SpinnerListModel monthModel = null;

          if (monthFormat) { //use custom model
               monthModel = new CyclingSpinnerListModel(monthStrings);
          } else { //use standard model
               monthModel = new SpinnerListModel(monthStrings);
          }

          jSpinnerMonth.setModel(monthModel);

          /* Tweak the spinner's formatted text field. */
          FTF = getTextField(jSpinnerMonth);
          if (FTF != null) {
               FTF.setColumns(8); //specify more width than we need
               FTF.setHorizontalAlignment(JTextField.RIGHT);
          }

// ----------------------------------------------------------------------------- YEAR SPINNER
          Calendar calendarYearSpinner = Calendar.getInstance();
          int currentYear = calendarYearSpinner.get(Calendar.YEAR);
          SpinnerModel yearModel = new SpinnerNumberModel(currentYear, //initial value
                  currentYear - 100, //min
                  currentYear + 100, //max
                  1);
          jSpinnerYear.setModel(yearModel);
          jSpinnerYear.setEditor(new JSpinner.NumberEditor(jSpinnerYear, "#"));


// ----------------------------------------------------------------------------- DATE SPINNER
          Calendar calendarDateSpinner = Calendar.getInstance();
          Date initDate = calendarDateSpinner.getTime();
          calendarDateSpinner.add(Calendar.YEAR, -100);
          Date earliestDate = calendarDateSpinner.getTime();
          calendarDateSpinner.add(Calendar.YEAR, 200);
          Date latestDate = calendarDateSpinner.getTime();
          SpinnerModel dateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR); //ignored for user input
          jSpinnerDate.setModel(dateModel);
          //dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
          jSpinnerDate.setEditor(new JSpinner.DateEditor(jSpinnerDate, "MMM dd, yyyy"));

          FTF = getTextField(jSpinnerDate);
          if (FTF != null) {
               FTF.setColumns(8); //specify more width than we need
               FTF.setHorizontalAlignment(JTextField.RIGHT);
          }

// ----------------------------------------------------------------------------- TIME SPINNER
          Calendar calendarTimeSpinner = Calendar.getInstance();
          calendarTimeSpinner.set(2012, 1 - 1, 1, 8, 00, 00);
          Date nowDate = calendarTimeSpinner.getTime();
          SpinnerModel timeModel = new SpinnerDateModel(nowDate, earliestDate, latestDate, Calendar.YEAR);
          timeSpinner.setModel(timeModel);
          timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "hh:mm a"));
          FTF = getTextField(timeSpinner);
          if (FTF != null) {
               FTF.setColumns(8); //specify more width than we need
               FTF.setHorizontalAlignment(JTextField.RIGHT);
          }


// ----------------------------------------------------------------------------- NUMBER SPINNER
          int initialNumber = 0;
          SpinnerModel numberModel = new SpinnerNumberModel(initialNumber, // Initial Value
                  0, // Min Number
                  100, // Max Number
                  1);     // Step Size
          jSpinnerNumber.setModel(numberModel);
          jSpinnerNumber.setEditor(new JSpinner.NumberEditor(jSpinnerNumber, "#"));



// ----------------------------------------------------------------------------- CALENDAR LISTENERS
//          String MDY = ref_MyFunctions.return_String_date_MonthDayYear(cal.getDate().toString());
          String MDY = new MyFunctions().function_get_YearMonthDay(cal.getDate());
          jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(MDY));
          cal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
               @Override
               public void propertyChange(java.beans.PropertyChangeEvent evt) {
//                String YYYYMMDD = ref_MyFunctions.return_String_date_YYYYMMDD(date);
                    String MonthDayYear = new MyFunctions().function_get_YearMonthDay(cal.getDate());
                    jTextArea.append(new SimpleDateFormat("yyyy-MM-dd").format(cal.getDate()) + "\n");
                    jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(MonthDayYear));
//                jTextArea.append(date.substring(0, 2) + "\n");
               }
          });



     } // end JF_Calendar();

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelCalendar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerMonth = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerYear = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerDate = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        timeSpinner = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelCallendarDateChooser = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jSpinnerNumber = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanelCalendar.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Year:");

        jLabel2.setText("Month:");

        jLabel5.setText("Date:");

        jButton1.setText("SOP DATE:");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Time:");

        jButton2.setText("SOP TIME:");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("SOP MONTH:");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("SOP YEAR:");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerYear)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSpinnerDate)
                        .addGap(1, 1, 1))
                    .addComponent(jSpinnerMonth, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(timeSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinnerMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("Min, Max (2012-1-1,2012-11-10)");

        jPanelCallendarDateChooser.setBackground(new java.awt.Color(255, 255, 204));
        jPanelCallendarDateChooser.setLayout(new java.awt.BorderLayout());

        jButton6.setText("SOP");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Change Format");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCallendarDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCallendarDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jTextArea.setColumns(20);
        jTextArea.setLineWrap(true);
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setText("Min = 0, Max = 100, Step =1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSpinnerNumber))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );

        jButton3.setMnemonic('e');
        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(jPanelCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         dateFormat();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         timeFormat();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         jTextArea.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         monthFormat();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         yearFormat();
    }//GEN-LAST:event_jButton5ActionPerformed

     private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

          java.util.Date date = dc.getDate();
          if (date != null) {
               jTextArea.append(new SimpleDateFormat("yyyy-MM-dd").format(date) + "\n");
          }
     }//GEN-LAST:event_jButton6ActionPerformed

     private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
          dc.setDateFormatString("MMM d, yyyy");
     }//GEN-LAST:event_jButton7ActionPerformed

     public static void main(String args[]) {


// ----------------------------------------------------------------------------- Nimbus LOOK&FEEL
        /* Set the Nimbus look and feel */
          //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
           * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
           */
          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                System.out.println(info.getName());
                    if ("Windows".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;
                    }
               }
          } catch (ClassNotFoundException ex) {
               java.util.logging.Logger.getLogger(JF_Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(JF_Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(JF_Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(JF_Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelCalendar;
    private javax.swing.JPanel jPanelCallendarDateChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerDate;
    private javax.swing.JSpinner jSpinnerMonth;
    private javax.swing.JSpinner jSpinnerNumber;
    private javax.swing.JSpinner jSpinnerYear;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JSpinner timeSpinner;
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

// ----------------------------------------------------------------------------- YEAR SPINNER
     private void yearFormat() {
          String year = jSpinnerYear.getValue().toString();
          int Year = Integer.parseInt(year);
          jTextArea.append(Year + "\n");
     } // end yearFormat();

// ----------------------------------------------------------------------------- MONTH SPINNER
     private void monthFormat() {
          String date = jSpinnerMonth.getValue().toString();
          //int Month = ref_MyFunctions.return_int_MM(date);
          int Month = new MyFunctions().function_get_Month(date);
          jTextArea.append(Month + "\n");
     } // end monthFormat();

// ----------------------------------------------------------------------------- DATE SPINNER
     private void dateFormat() {
          try{
          Object date = jSpinnerDate.getValue();
          String YearMonthDay = new SimpleDateFormat("E, MMMM dd, yyyy").format(date);
          jTextArea.append(YearMonthDay + "\n");
          }catch (Exception e){
               System.err.println(e);
          }
     } // end dateFormat();

// ----------------------------------------------------------------------------- TIME SPINNER
     private void timeFormat() {
          Object date = timeSpinner.getValue();
          jTextArea.append(new SimpleDateFormat("HH:mm:ss - hh:mm:ss a").format(date) + "\n");

     } // end timeFormat();
}
