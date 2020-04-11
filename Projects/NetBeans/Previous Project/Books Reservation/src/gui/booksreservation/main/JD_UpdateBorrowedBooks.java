package gui.booksreservation.main;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.Color;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import mcbx.jb.classes.database.booksreservation.UserLogs;
import mcbx.jb.classes.database.booksreservation.borrow;
import mcbx.jb.classes.database.booksreservation.reserve;
import mcbx.jb.classes.databaseconnection.Database;
import mcbx.jb.classes.mycollection.MyFunctions;

public class JD_UpdateBorrowedBooks extends javax.swing.JDialog {

    /**/
    private borrow ref_borrow = new borrow();
    /**/
    private int idborrow = 0;
    public boolean isUpdated = false;

    public boolean isIsUpdated() {
        return isUpdated;
    }

    public void setIsUpdated(boolean isUpdated) {
        this.isUpdated = isUpdated;
    }

    public int getIdborrow() {
        return idborrow;
    }

    public void setIdborrow(int idborrow) {
        this.idborrow = idborrow;
    }

    public JD_UpdateBorrowedBooks(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        /**/
//          JDC_1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
//               @Override
//               public void propertyChange(java.beans.PropertyChangeEvent evt) {
//                    JDC_2.setMinSelectableDate(JDC_1.getDate());
//                    JDC_2.setDate(JDC_1.getDate());
//                    /**/
//                    JDC_3.setMinSelectableDate(JDC_1.getDate());
//                    JDC_3.setDate(JDC_1.getDate());
//               }
//          });
          /**/
        refreshForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel_1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel_2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel_3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel_1 = new javax.swing.JLabel();
        jLabel_2 = new javax.swing.JLabel();
        jLabel_3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Borrowed Books");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Borrowed Date:");

        jPanel_1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_1.setLayout(new java.awt.BorderLayout());

        jButton2.setText("Update");
        jButton2.setToolTipText("Update Information");
        jButton2.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel_2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_2.setLayout(new java.awt.BorderLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Due Date:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Copy:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Notes:");

        jButton3.setText("Cancel");
        jButton3.setToolTipText("Update Information");
        jButton3.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel_3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_3.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Remarks:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextField2.setMargin(new java.awt.Insets(1, 4, 1, 4));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Fines:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Status:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Borrowed", "Returned" }));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Returned Copy:");

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jButton4.setText("Reset");
        jButton4.setToolTipText("Update Information");
        jButton4.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Returned Date:");

        jLabel_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel_2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel_3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jLabel_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
     }//GEN-LAST:event_formKeyReleased

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         updateBorrowedBooks();
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         this.dispose();
     }//GEN-LAST:event_jButton3ActionPerformed

     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         refreshForm();
     }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JD_UpdateBorrowedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_UpdateBorrowedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_UpdateBorrowedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_UpdateBorrowedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_UpdateBorrowedBooks dialog = new JD_UpdateBorrowedBooks(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    private static javax.swing.JComboBox jComboBox1;
    static javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_1;
    private javax.swing.JLabel jLabel_2;
    private javax.swing.JLabel jLabel_3;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JPanel jPanel_1;
    private static javax.swing.JPanel jPanel_2;
    private static javax.swing.JPanel jPanel_3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JSpinner jSpinner1;
    private static javax.swing.JSpinner jSpinner2;
    private static javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
    private JDateChooser JDC_1 = new JDateChooser(null, null, null, new JSpinnerDateEditor());
    private JDateChooser JDC_2 = new JDateChooser(null, null, null, new JSpinnerDateEditor());
    private JDateChooser JDC_3 = new JDateChooser(null, null, null, new JSpinnerDateEditor());
    private MyFunctions ref_MyFunctions = new MyFunctions();

    private void setDatechooserPanel_1() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                JDC_1.setMinSelectableDate(ref_MyFunctions.select_currentDate(conn));
                JDC_1.setDate(ref_MyFunctions.select_currentDate(conn));
                setDateChooser("MMMM dd, yyyy", JDC_1, jPanel_1);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setDatechooserPanel_2() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                JDC_2.setMinSelectableDate(ref_MyFunctions.select_currentDate(conn));
                JDC_2.setDate(ref_MyFunctions.select_currentDate(conn));
                setDateChooser("MMMM dd, yyyy", JDC_2, jPanel_2);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setDatechooserPanel_3() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                JDC_3.setMinSelectableDate(ref_MyFunctions.select_currentDate(conn));
                JDC_3.setDate(ref_MyFunctions.select_currentDate(conn));
                setDateChooser("MMMM dd, yyyy", JDC_3, jPanel_3, true);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setDateChooser(String SDF, JDateChooser JDC_dateChooser, JPanel JP_dateChooser) {
        JDC_dateChooser.setDateFormatString(SDF);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setTodayButtonVisible(true);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setNullDateButtonVisible(false);

        ((JDateChooser) JDC_dateChooser).getJCalendar().setDecorationBordersVisible(false);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setDecorationBackgroundColor(Color.black);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setWeekdayForeground(Color.white);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setSundayForeground(Color.red);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setDecorationBackgroundVisible(true);

        ((JDateChooser) JDC_dateChooser).getJCalendar().setWeekOfYearVisible(false);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setMaxDayCharacters(1);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setBackground(Color.black);
        JP_dateChooser.add(JDC_dateChooser);
    }

    private void setDateChooser(String SDF, JDateChooser JDC_dateChooser, JPanel JP_dateChooser, boolean isNullButttonVisible) {
        JDC_dateChooser.setDateFormatString(SDF);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setTodayButtonVisible(true);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setNullDateButtonVisible(isNullButttonVisible);

        ((JDateChooser) JDC_dateChooser).getJCalendar().setDecorationBordersVisible(false);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setDecorationBackgroundColor(Color.black);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setWeekdayForeground(Color.white);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setSundayForeground(Color.red);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setDecorationBackgroundVisible(true);

        ((JDateChooser) JDC_dateChooser).getJCalendar().setWeekOfYearVisible(false);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setMaxDayCharacters(1);
        ((JDateChooser) JDC_dateChooser).getJCalendar().setBackground(Color.black);
        JP_dateChooser.add(JDC_dateChooser);
    }

    public void refreshForm() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idborrow_ = this.getIdborrow();

                jLabel_1.setText("");
                jLabel_2.setText("");
                jLabel_3.setText("");

                java.sql.Time timeBorrowed = ref_borrow.function_get_borroweddate_time_update(idborrow_, conn);
                if (timeBorrowed != null) {
                    jLabel_1.setText("@ " + (new SimpleDateFormat("hh:mm:ss a").format(timeBorrowed)));
                    jLabel_2.setText("@ " + (new SimpleDateFormat("hh:mm:ss a").format(timeBorrowed)));
                }

                java.sql.Time timeReturned = ref_borrow.function_get_returneddate_time_update(idborrow_, conn);
                if (timeReturned != null) {
                    jLabel_3.setText("@ " + (new SimpleDateFormat("hh:mm:ss a").format(timeReturned)));
                }



                /**/
//                    JDC_1.setMinSelectableDate(ref_borrow.function_get_borroweddate(idborrow_, conn));
                JDC_1.setDate(ref_borrow.function_get_borroweddate(idborrow_, conn));
                setDateChooser("MMMM dd, yyyy", JDC_1, jPanel_1, false);
                /**/
//                    JDC_2.setMinSelectableDate(ref_borrow.function_get_borrowedduedate(idborrow_, conn));
                JDC_2.setDate(ref_borrow.function_get_borrowedduedate(idborrow_, conn));
                setDateChooser("MMMM dd, yyyy", JDC_2, jPanel_2, false);
                /**/
                jSpinner1.setValue(ref_borrow.function_get_copies(idborrow_, conn));
                /**/
                jTextArea1.setText(ref_borrow.function_get_notes(idborrow_, conn));
                /**/
//                    JDC_3.setMinSelectableDate(ref_borrow.function_get_returneddate(idborrow_, conn));
                java.util.Date isNull = ref_borrow.function_get_returneddate(idborrow_, conn);
                if (isNull == null) {
                    JDC_3.setDate(Calendar.getInstance().getTime());
                    setDateChooser("MMMM dd, yyyy", JDC_3, jPanel_3, true);
                } else {
                    JDC_3.setDate(ref_borrow.function_get_returneddate(idborrow_, conn));
                    setDateChooser("MMMM dd, yyyy", JDC_3, jPanel_3, true);
                }
                /**/
                jTextArea2.setText(ref_borrow.function_get_remarks(idborrow_, conn));
                /**/
                jFormattedTextField2.setValue(ref_borrow.function_get_finedamount(idborrow_, conn));
                /**/
                jComboBox1.setSelectedItem(ref_borrow.function_get_status(idborrow_, conn));
                /**/
                jSpinner2.setValue(ref_borrow.function_get_returnedcopies(idborrow_, conn));
                /**/

                jComboBox1.setSelectedItem("Returned");

                
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**/
    private void reserveBooks() {
    }

    /**/
    private void updateBorrowedBooks() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {

                int idborrow_ = this.getIdborrow();
                java.util.Date time_ = ref_borrow.function_get_borroweddate_time(idborrow_, conn);
                String timeNow_ = new MyFunctions().return_DateTime("hh:mm:ss");

                String str_borroweddate = (new SimpleDateFormat("yyyy-MM-dd").format(JDC_1.getDate()));
                String str_borrowedduedate = (new SimpleDateFormat("yyyy-MM-dd").format(JDC_2.getDate()));

                int copies_ = jSpinner1.getValue().hashCode();
                String notes_ = jTextArea1.getText().trim().toString();
                String remarks_ = jTextArea2.getText().trim().toString();
                double finedamount_ = Double.parseDouble(jFormattedTextField2.getValue().toString() + "");
                String status_ = jComboBox1.getSelectedItem().toString();
                int returnedcopies_ = jSpinner2.getValue().hashCode();
                if (JDC_3.getDate() != null) {
                    String str_returneddate = (new SimpleDateFormat("yyyy-MM-dd").format(JDC_3.getDate()));
                    ref_borrow.update_borrow(idborrow_, str_borroweddate + " " + time_, str_borrowedduedate + " " + time_, copies_, notes_, str_returneddate + " " + timeNow_, remarks_, finedamount_, status_, returnedcopies_, conn);
                    JOptionPane.showMessageDialog(this, "Borrowed Books Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE, null);

                    this.setIsUpdated(true);
                } else {
                    ref_borrow.update_borrow(idborrow_, str_borroweddate + " " + time_, str_borrowedduedate + " " + time_, copies_, notes_, remarks_, finedamount_, status_, returnedcopies_, conn);
                    JOptionPane.showMessageDialog(this, "Borrowed Books Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE, null);

                    this.setIsUpdated(true);

                }
                refreshForm();

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
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
