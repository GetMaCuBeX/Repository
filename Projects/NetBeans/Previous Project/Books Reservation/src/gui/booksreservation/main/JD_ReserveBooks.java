package gui.booksreservation.main;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import mcbx.jb.classes.database.booksreservation.UserLogs;
import mcbx.jb.classes.database.booksreservation.booksimage;
import mcbx.jb.classes.database.booksreservation.borrow;
import mcbx.jb.classes.database.booksreservation.members;
import mcbx.jb.classes.database.booksreservation.reserve;
import mcbx.jb.classes.databaseconnection.Database;
import mcbx.jb.classes.mycollection.MyFunctions;

public class JD_ReserveBooks extends javax.swing.JDialog {

    /**/
    private reserve ref_reserve = new reserve();
    /**/
    private boolean isNeedRefresh = false;
    private int maximumReservationDate = 3;

    public int getMaximumReservationDate() {
        return maximumReservationDate;
    }

    public void setMaximumReservationDate(int maximumReservationDate) {
        this.maximumReservationDate = maximumReservationDate;
    }

    public boolean isIsNeedRefresh() {
        return isNeedRefresh;
    }

    public void setIsNeedRefresh(boolean isNeedRefresh) {
        this.isNeedRefresh = isNeedRefresh;
    }
    private int idbooks = 0;

    public int getIdbooks() {
        return idbooks;
    }

    public void setIdbooks(int idbooks) {
        this.idbooks = idbooks;
    }

    public JD_ReserveBooks(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        /**/
        setDatechooserPanel_1();
        setDatechooserPanel_2();
        /**/
        JDC_1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Connection conn = Database._function_getConnection(Database._booksreservation);
                if (conn != null) {
                    String JDC_1_Date = new SimpleDateFormat("yyyy-MM-dd").format(JDC_1.getDate());
                    JDC_2.setMinSelectableDate(ref_MyFunctions.select_addedDate(JDC_1_Date, 1, conn));
                    JDC_2.setDate(ref_MyFunctions.select_addedDate(JDC_1_Date, 1, conn));
                                        
//                    JDC_2.setMinSelectableDate(JDC_1.getDate());
//                    JDC_2.setDate(JDC_1.getDate());

                }


            }
        });

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reserve Books");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("From:");

        jPanel_1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel_1.setLayout(new java.awt.BorderLayout());

        jButton2.setText("Reserve");
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
        jLabel10.setText("To:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1, 1));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(4, 4, 4)))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
     }//GEN-LAST:event_formKeyReleased

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//         reserveBooks();
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         this.dispose();
     }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JD_ReserveBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_ReserveBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_ReserveBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_ReserveBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_ReserveBooks dialog = new JD_ReserveBooks(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel_1;
    public javax.swing.JPanel jPanel_2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSpinner jSpinner1;
    public javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    private JDateChooser JDC_1 = new JDateChooser(null, null, null, new JSpinnerDateEditor());
    private JDateChooser JDC_2 = new JDateChooser(null, null, null, new JSpinnerDateEditor());
    private MyFunctions ref_MyFunctions = new MyFunctions();

    private void setDatechooserPanel_1() {
        try {

            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {

                String dateNow_ = new MyFunctions().return_DateTime("yyyy-MM-dd");
                JDC_1.setMinSelectableDate(ref_MyFunctions.select_currentDate(conn));
                JDC_1.setMaxSelectableDate(ref_MyFunctions.select_addedDate(dateNow_, this.maximumReservationDate, conn));
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

                String dateNow_ = new MyFunctions().return_DateTime("yyyy-MM-dd");

//                JDC_2.setMinSelectableDate(ref_MyFunctions.select_currentDate(conn));
                JDC_2.setMinSelectableDate(ref_MyFunctions.select_addedDate(dateNow_, 1, conn));
                JDC_2.setMaxSelectableDate(ref_MyFunctions.select_addedDate(dateNow_, this.maximumReservationDate, conn));
                JDC_2.setDate(ref_MyFunctions.select_addedDate(dateNow_, 1, conn));
                setDateChooser("MMMM dd, yyyy", JDC_2, jPanel_2);
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

    /**/
    public void refreshForm() {
        setDatechooserPanel_1();
        setDatechooserPanel_2();
        jTextArea1.setText("");
    }

    /**/
    public boolean reserveBooks() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int idmembers_ = UserLogs.getIdmembers();
                int idbooks_ = this.getIdbooks();

                String timeNow_ = new MyFunctions().return_DateTime("hh:mm:ss");
                String reserveddate_ = (new SimpleDateFormat("yyyy-MM-dd").format(JDC_1.getDate()));
                String reservedlimitdate_ = (new SimpleDateFormat("yyyy-MM-dd").format(JDC_2.getDate()));
                int copies_ = jSpinner1.getValue().hashCode();
                String notes_ = jTextArea1.getText().trim().toString();
                String status_ = "Borrowed";
                ref_reserve.insert_reserve(new reserve(idmembers_, idbooks_, reserveddate_ + " " + timeNow_, reservedlimitdate_ + " " + timeNow_, copies_, notes_, status_), conn);
//                JOptionPane.showMessageDialog(null, "Item Successfully Reserved", "Message", JOptionPane.PLAIN_MESSAGE);
                jButton2.setVisible(false);
                return true;
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
}
