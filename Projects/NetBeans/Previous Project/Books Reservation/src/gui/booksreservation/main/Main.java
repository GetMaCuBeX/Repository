package gui.booksreservation.main;

import java.awt.Frame;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import mcbx.jb.classes.database.booksreservation.UserLogs;
import mcbx.jb.classes.database.booksreservation.members;
import mcbx.jb.classes.databaseconnection.Database;
import mcbx.jb.classes.mycollection.DesktopPane;
import mcbx.jb.classes.mycollection.FloatingPaletteHandler;

public class Main extends javax.swing.JFrame {

    private static final String DP_IMAGE_LOCATION = "mcbx/jb/images/jdesktoppane/";
    private static final DesktopPane DP1 = new DesktopPane(DP_IMAGE_LOCATION + "Fish.jpg");
    private static ImageIcon iconFrame = new ImageIcon(Main.class.getResource("icons/1_32x32_JFrame.png"));
    private static DesktopPane ref_DesktopPane_LogIn = new DesktopPane(DP_IMAGE_LOCATION + "Library Automation System.jpg");
    /**/
    public JInternalFrame ref_JIF_Container_Guest, ref_JIF_Container_Administrator, ref_JIF_Container_Member;
    public JInternalFrame ref_JIF_Guest_Container;
    public JInternalFrame ref_JIF_Container_Calendar;
    /**/
    private members ref_members = new members();
    private JFrame ref_JF_Calendar;

    public Main() {
        initComponents();
//        this.setIconImage(iconFrame.getImage());

        initComponents_jDialogLogIn();
        initComponents_MainDesktopPane();
        //
        jMenuItem1.setVisible(true); // Log In
        jMenuItem3.setVisible(false); // Log Out
        //
        jMenu3.setVisible(false);

        UserLogs.setIdmembers(0);
        isLogIn();

    }

    private void initComponents_jDialogLogIn() {
        jPanel4.add(ref_DesktopPane_LogIn, java.awt.BorderLayout.CENTER);

        jDialogLogIn.setSize(jDialogLogIn.getPreferredSize());
        jDialogLogIn.setMinimumSize(jDialogLogIn.getPreferredSize());
        jDialogLogIn.setModal(true);
        jDialogLogIn.setLocationRelativeTo(null);
    }

    private void initComponents_MainDesktopPane() {
        jPanel7.add(DP1, java.awt.BorderLayout.CENTER);
    }

    /* open JInternalFrame */
    public static void open_JInternalFrame(JInternalFrame ref_JInternalFrame, DesktopPane iDesktopPane) {
        try {
            iDesktopPane.add(ref_JInternalFrame);
            ref_JInternalFrame.setSelected(true);
            int a = ref_JInternalFrame.getWidth() / 2;
            int b = ref_JInternalFrame.getHeight() / 2;
            ref_JInternalFrame.setLocation(iDesktopPane.getWidth() / 2 - a, iDesktopPane.getHeight() / 2 - b);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogLogIn = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();

        jDialogLogIn.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogLogIn.setTitle("User Log In");
        jDialogLogIn.setMinimumSize(new java.awt.Dimension(402, 295));
        jDialogLogIn.setPreferredSize(new java.awt.Dimension(402, 295));
        jDialogLogIn.setResizable(false);
        jDialogLogIn.setType(java.awt.Window.Type.POPUP);

        jPanel1.setPreferredSize(new java.awt.Dimension(277, 132));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setMargin(new java.awt.Insets(1, 4, 1, 4));
        jTextField1.setPreferredSize(new java.awt.Dimension(66, 22));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.setEchoChar('|');
        jPasswordField1.setMargin(new java.awt.Insets(1, 4, 1, 4));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Password:");

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("LogIn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 244, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jDialogLogIn.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jButton3.setText("jButton3");
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
                .addComponent(jButton3)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        jFrame1.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Automation System");
        setMinimumSize(new java.awt.Dimension(900, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel7.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setText("Log In");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Log Out");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem13.setText("Guest ");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Setup");

        jMenuItem4.setText("MySQL Connection");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Window");

        jMenuItem15.setText("Calendar");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Help");

        jMenuItem9.setText("About");
        jMenu5.add(jMenuItem9);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("Show");

        jMenuItem5.setText("Guest");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);
        jMenu3.add(jSeparator2);

        jMenuItem7.setText("Guest Container");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Administrator Container");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem12.setText("Administrator LogIn");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);
        jMenu3.add(jSeparator3);

        jMenu4.setText("Palette");

        jMenuItem6.setText("1");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenu3.add(jMenu4);

        jMenuItem10.setText("Calendar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Books Information");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);
        jMenu3.add(jSeparator5);

        jMenuItem14.setText("jMenuItem14");
        jMenu3.add(jMenuItem14);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

         setVisible_jDialogLogIn(true);




     }//GEN-LAST:event_jMenuItem1ActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         process_LogIn();


     }//GEN-LAST:event_jButton1ActionPerformed

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         jDialogLogIn.dispose();
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         Database._open_JD_MySQLConnect(Database._booksreservation);
     }//GEN-LAST:event_jMenuItem4ActionPerformed

     private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

         try {
             Connection conn = Database._function_getConnection(Database._booksreservation);
             if (conn != null) {
                 JIF_Container_Guest();
             } else {
                 Database._open_JD_MySQLConnect(Database._booksreservation);
                 if (Database._booksreservation.getConnection() != null) {
                     JIF_Container_Guest();
                 }
             }
         } catch (Exception e) {
             System.err.println(e);
         }





     }//GEN-LAST:event_jMenuItem5ActionPerformed

     private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_jTextField1ActionPerformed
    private JDialog smallHPalette;
     private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

         if (smallHPalette == null) {
             JDialog d = new JDialog((Frame) SwingUtilities.getWindowAncestor(this));
             if (UIManager.getLookAndFeel().getSupportsWindowDecorations()) {
                 d.setUndecorated(true);
             }

             d.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
             d.getRootPane().setFont(UIManager.getFont("SmallSystemFont"));
             d.getRootPane().putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
             d.getRootPane().putClientProperty("Quaqua.RootPane.isPalette", Boolean.FALSE);
             d.getRootPane().putClientProperty("Window.style", "small");
             d.setAlwaysOnTop(true);
             FloatingPaletteHandler.getInstance().addPalette(d);
             d.add(jPanel2, java.awt.BorderLayout.CENTER);
             d.setSize(jPanel2.getPreferredSize());
             d.setLocationRelativeTo(null);
             d.setTitle("Small Horizontal Palette");
             smallHPalette = d;

         }
         smallHPalette.setVisible(true);

     }//GEN-LAST:event_jMenuItem6ActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         try {
             Connection conn = Database._function_getConnection(Database._booksreservation);
             if (conn != null) {
//                    JIF_Guest_Container();
             } else {
                 Database._open_JD_MySQLConnect(Database._booksreservation);
                 if (Database._booksreservation.getConnection() != null) {
//                         JIF_Guest_Container();
                 }
             }
         } catch (Exception e) {
             System.err.println(e);
         }


     }//GEN-LAST:event_formWindowOpened

     private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         try {
             Connection conn = Database._function_getConnection(Database._booksreservation);
             if (conn != null) {
                 JIF_Guest_Container();
             } else {
                 Database._open_JD_MySQLConnect(Database._booksreservation);
                 if (Database._booksreservation.getConnection() != null) {
                     JIF_Guest_Container();
                 }
             }
         } catch (Exception e) {
             System.err.println(e);
         }
     }//GEN-LAST:event_jMenuItem7ActionPerformed

     private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
         try {
             Connection conn = Database._function_getConnection(Database._booksreservation);
             if (conn != null) {
                 UserLogs.setIdmembers(0);
                 UserLogs.setMembertype("Guest");
                 JIF_Container_Administrator();
             } else {
                 Database._open_JD_MySQLConnect(Database._booksreservation);
                 if (Database._booksreservation.getConnection() != null) {
                     UserLogs.setIdmembers(0);
                     UserLogs.setMembertype("Gues");
                     JIF_Container_Administrator();
                 }
             }
         } catch (Exception e) {
             System.err.println(e);
         }

     }//GEN-LAST:event_jMenuItem8ActionPerformed

     private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
         try {
             if (ref_JF_Calendar == null) {
                 ref_JF_Calendar = new JF_Calendar();
                 // ref_JF_Calendar.add(image1);
                 // ref_JF_Calendar.setSize(image1.getWidth(),image1.getHeight());
                 ref_JF_Calendar.setLocationRelativeTo(DP1);
                 ref_JF_Calendar.setLocationRelativeTo(null);
                 ref_JF_Calendar.setAlwaysOnTop(true);
                 ref_JF_Calendar.setVisible(true);
             } else {
                 ref_JF_Calendar.setVisible(true);
             }
         } catch (Exception e) {
             System.out.println(e);
         }
     }//GEN-LAST:event_jMenuItem10ActionPerformed

     private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
         JIF_Books_Information();

     }//GEN-LAST:event_jMenuItem11ActionPerformed

     private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
         try {
             Connection conn = Database._function_getConnection(Database._booksreservation);
             if (conn != null) {
                 UserLogs.setIdmembers(2);
                 UserLogs.setMembertype("Administrator");
                 JIF_Container_Administrator();
             } else {
                 Database._open_JD_MySQLConnect(Database._booksreservation);
                 if (Database._booksreservation.getConnection() != null) {
                     UserLogs.setIdmembers(2);
                     UserLogs.setMembertype("Administrator");
                     JIF_Container_Administrator();
                 }
             }
         } catch (Exception e) {
             System.err.println(e);
         }

     }//GEN-LAST:event_jMenuItem12ActionPerformed

     private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

         removeAll_JIF_Components();


         jMenuItem1.setVisible(true); // Log In
         jMenuItem3.setVisible(false); // Log Out
         UserLogs.setIdmembers(0);
         isLogIn();

     }//GEN-LAST:event_jMenuItem3ActionPerformed

     private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed

         try {
             Connection conn = Database._function_getConnection(Database._booksreservation);
             if (conn != null) {
                 JIF_Container_Guest();
             } else {
                 Database._open_JD_MySQLConnect(Database._booksreservation);
                 if (Database._booksreservation.getConnection() != null) {
                     JIF_Container_Guest();
                 }
             }
         } catch (Exception e) {
             System.err.println(e);
         }
     }//GEN-LAST:event_jMenuItem13ActionPerformed

     private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
         process_LogIn();
     }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        try {
            if (ref_JF_Calendar == null) {
                ref_JF_Calendar = new JF_Calendar();
                // ref_JF_Calendar.add(image1);
                // ref_JF_Calendar.setSize(image1.getWidth(),image1.getHeight());
                ref_JF_Calendar.setLocationRelativeTo(DP1);
                ref_JF_Calendar.setLocationRelativeTo(null);
                ref_JF_Calendar.setAlwaysOnTop(true);
                ref_JF_Calendar.setVisible(true);
            } else {
                ref_JF_Calendar.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                    new Main().setVisible(true);
                Main ref_Main = new Main();
                ref_Main.setSize(950, 600);
                ref_Main.setLocationRelativeTo(null);
                ref_Main.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialogLogIn;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    // ------------------------------------------------------------------------ []
    private void setVisible_jDialogLogIn(boolean b) {
        try {
            if (jDialogLogIn.isVisible() || jDialogLogIn.isShowing()) {
                jDialogLogIn.setLocationRelativeTo(DP1);
                jDialogLogIn.setVisible(b);
            } else {
                jDialogLogIn.setLocationRelativeTo(DP1);
                jDialogLogIn.setVisible(b);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // ------------------------------------------------------------------------ []
    private void validateInputUsernamePassword() {
        String username_ = jTextField1.getText().trim().toString();
        String password_ = jPasswordField1.getText().trim().toString();
        System.out.println("Username: " + username_);
        System.out.println("Password: " + password_);
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {

                boolean isExist = ref_members.function_is_username_password_exist(username_, password_, conn);
                if (isExist) {
                    int idmembers_ = ref_members.function_get_idmembers(username_, password_, conn);
                    String membertype_ = ref_members.function_get_membertype(idmembers_, conn);
                    UserLogs.setIdmembers(idmembers_);
                    UserLogs.setMembertype(membertype_);
                    jMenuItem1.setVisible(false); // Log In
                    jMenuItem3.setVisible(true); // Log Out

                    switch (membertype_) {
                        case "Administrator":
                            JIF_Container_Administrator();
                            break;
                        case "Student":
                            JIF_Container_Member();
                            break;
                        case "Instructor":
                            JIF_Container_Member();
                            break;
                        case "Officer":
                            JIF_Container_Member();
                        default:
                            break;
                    }

                    jTextField1.setText("");
                    jPasswordField1.setText("");
                    jDialogLogIn.dispose();

                    if (ref_JIF_Container_Guest.isVisible()) {
                        ref_JIF_Container_Guest.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(jDialogLogIn, "Invalid username and password", "Error", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
                if (Database._function_getConnection(Database._booksreservation) != null) {
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //
    public void JIF_Container_Guest() {
        try {
            if (ref_JIF_Container_Guest == null || ref_JIF_Container_Guest.isClosed()) {
                open_JInternalFrame(ref_JIF_Container_Guest = new JIF_Container_Guest(), DP1);
                ref_JIF_Container_Guest.setLayer(1);
                ref_JIF_Container_Guest.setMaximum(true);
                ref_JIF_Container_Guest.setVisible(true);
            } else {
                ref_JIF_Container_Guest.setVisible(true);
                if (ref_JIF_Container_Guest.isIcon()) {
                    ref_JIF_Container_Guest.setIcon(false);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void JIF_Container_Administrator() {
        try {
            if (ref_JIF_Container_Administrator == null || ref_JIF_Container_Administrator.isClosed()) {
                open_JInternalFrame(ref_JIF_Container_Administrator = new JIF_Container_Administrator(), DP1);
                ref_JIF_Container_Administrator.setLayer(2);
                ref_JIF_Container_Administrator.setMaximum(false);
                ref_JIF_Container_Administrator.setVisible(true);
            } else {
                ref_JIF_Container_Administrator.setVisible(true);
                if (ref_JIF_Container_Administrator.isIcon()) {
                    ref_JIF_Container_Administrator.setIcon(false);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void JIF_Container_Member() {
        try {
            if (ref_JIF_Container_Member == null || ref_JIF_Container_Member.isClosed()) {
                open_JInternalFrame(ref_JIF_Container_Member = new JIF_Container_Member(), DP1);
                ref_JIF_Container_Member.setLayer(2);
                ref_JIF_Container_Member.setMaximum(false);
                ref_JIF_Container_Member.setVisible(true);
            } else {
                ref_JIF_Container_Member.setVisible(true);
                if (ref_JIF_Container_Member.isIcon()) {
                    ref_JIF_Container_Member.setIcon(false);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //
    public void JIF_Guest_Container() {
        try {
            if (ref_JIF_Guest_Container == null || ref_JIF_Guest_Container.isClosed()) {
                open_JInternalFrame(ref_JIF_Guest_Container = new JIF_Guest_Container(), DP1);
                ref_JIF_Guest_Container.setLayer(1);
                ref_JIF_Guest_Container.setMaximum(true);
                ref_JIF_Guest_Container.setVisible(true);
            } else {
                ref_JIF_Guest_Container.setVisible(true);
                if (ref_JIF_Guest_Container.isIcon()) {
                    ref_JIF_Guest_Container.setIcon(false);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**/
    public void JIF_Books_Information() {
        try {
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void removeAll_JIF_Components() {
        try {
            if (ref_JIF_Container_Administrator == null || ref_JIF_Container_Administrator.isClosed()) {
            } else {
                ref_JIF_Container_Administrator.dispose();
            }
            if (ref_JIF_Container_Member == null || ref_JIF_Container_Member.isClosed()) {
            } else {
                ref_JIF_Container_Member.dispose();
            }
            if (ref_JIF_Guest_Container == null || ref_JIF_Guest_Container.isClosed()) {
            } else {
                ref_JIF_Guest_Container.dispose();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void process_LogIn() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                validateInputUsernamePassword();
                isLogIn();
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
                if (Database._function_getConnection(Database._booksreservation) != null) {
                    validateInputUsernamePassword();
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void isLogIn() {
        if (UserLogs.getIdmembers() == 0) {
            jMenuItem13.setVisible(true);
        } else {
            jMenuItem13.setVisible(false);
        }
    }
}
