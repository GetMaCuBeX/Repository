package gui.booksreservation.main;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import mcbx.jb.classes.database.booksreservation.UserLogs;
import mcbx.jb.classes.database.booksreservation.books;
import mcbx.jb.classes.database.booksreservation.category;
import mcbx.jb.classes.database.booksreservation.members;
import mcbx.jb.classes.database.booksreservation.reserve;
import mcbx.jb.classes.databaseconnection.Database;
import mcbx.jb.classes.mycollection.DesktopPane;
import mcbx.jb.classes.mycollection.JIFrameJasperReportsViewer;
import mcbx.jb.classes.mycollection.MyFunctions;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.swing.JRViewer;

public class JIF_Container_Member extends javax.swing.JInternalFrame {

    long ThreadSleep = 1;
    public JIFrameJasperReportsViewer ref_JIF_Reports_Single;
    private String reportsDirectory = System.getProperty("user.dir") + "/reports/booksreservation/";
    //
    public REF_JF_MembersBooksReserved ref_MembersBooksReserved = new REF_JF_MembersBooksReserved();
    public REF_JF_MembersBooksBorrowed ref_MembersBooksBorrowed = new REF_JF_MembersBooksBorrowed();
    public REF_JF_MembersBooksPenalties ref_MembersBooksPenalties = new REF_JF_MembersBooksPenalties();
    public JF_Member JF_Member = new JF_Member();
    private JD_ReserveBooks ref_JD_ReserveBooks = new JD_ReserveBooks(JF_Member, false);
    private JD_AddNewMembers ref_JD_AddNewMembers = new JD_AddNewMembers(JF_Member, false);
    private books ref_books = new books();
    private members ref_members = new members();
    private reserve ref_reserve = new reserve();
    private category ref_category = new category();
    private MyFunctions ref_MyFunctions = new MyFunctions();
    /**/
    private JF_BooksInformation ref_BooksInformation = new JF_BooksInformation();

    public JIF_Container_Member() {
        initComponents();

        ref_BooksInformation = new JF_BooksInformation();
        ref_BooksInformation.check_userlogs();

        addComponents();
        addEvents();


    }

// ----------------------------------------------------------------------------- FUNTIONS
    public int function_getColumnNumber_jTable(String jTableColumn_Name, JTable jTable_Name) {
        int get_columnNumber = 0;
        try {
            /*
             int selectedColumn = function_getColumnNumber_jTable("idbooks", jTableBooks);
             int selectedRow = jTableBooks.getSelectedRow();
             int idbooks = jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();                
             */
            // iterate and find the column "column_Name"
            for (int c = 0; c < jTable_Name.getColumnCount(); c++) {
                String columnName = jTable_Name.getColumnName(c);
                // check if it is equal to the column "column_Name"
                if (jTableColumn_Name.equals(columnName)) { // GET THE COLUMN NUMBER
                    // set and return the column number
                    get_columnNumber = c;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return get_columnNumber;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuMembers_jTableBooks = new javax.swing.JPopupMenu();
        jMenuItemMembers_ReserveSelected = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItemMembers_ReserveSelected.setText("Reserve Selected");
        jPopupMenuMembers_jTableBooks.add(jMenuItemMembers_ReserveSelected);

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Member");
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setMnemonic('p');
        jMenu1.setText("Profile");

        jMenuItem5.setText("My Books Records");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator1);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setMnemonic('f');
        jMenuItem1.setText("My Information");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Books");
        jMenu2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu2MenuSelected(evt);
            }
        });

        jMenuItem2.setText("Cancel Reservation");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Reserve Selected");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("View Information");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        ref_JD_AddNewMembers.setEnabled_viewInformation(UserLogs.getIdmembers());
        view_user_log_information();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        show_books_information();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        reserveBook();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        cancel_reservedBooks();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        getSelectedRowCount_JF_Member_JF_Books_jTableBooks();
        setEnabled_MenuItem();
    }//GEN-LAST:event_jMenu2MenuSelected

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        jMenuItem5.setEnabled(false);
                        if (!JF_Member.jToggleButton4.isSelected()) {
                            JF_Member.jToggleButton4.setSelected(true);
                        }
                        sleep(ThreadSleep);

                        generateReports(UserLogs.getIdmembers());
                        if (!JF_Member.jToggleButton4.isSelected()) {
                            JF_Member.jToggleButton4.setSelected(true);
                        }
                        jMenuItem5.setEnabled(true);
                    } catch (InterruptedException ex) {
                        System.err.println("Interrupted Exception");
                    }
                }
            }.start();
        } catch (Exception e) {
            System.err.println("Exception");
        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemMembers_ReserveSelected;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenuMembers_jTableBooks;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void addComponents() {
        /**/
        jPanel1.add(JF_Member.jPanel1);
        JF_Member.itemStateChange();

        /**/
        JF_Member.JF_Books.jTabbedPane1.add("    Reserved Books    ", ref_MembersBooksReserved.jPanel2);
        JF_Member.JF_Books.jTabbedPane1.add("    Borrowed Books    ", ref_MembersBooksBorrowed.jPanel2);
        JF_Member.JF_Books.jTabbedPane1.add("    Penalties    ", ref_MembersBooksPenalties.jPanel2);
        /**/
        ref_JD_AddNewMembers.setLocationRelativeTo(null);
        /**/

        int idmembers_ = UserLogs.getIdmembers();
        JF_Member.JF_Books.initialize_results_fill_jTableBooks();

        JF_Member.JF_Books.jTableBooks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JF_Member.JF_Books.jButtonBorrow.setVisible(false);
        JF_Member.JF_Books.jButtonReturn.setVisible(false);

        ref_MembersBooksReserved.setIdmembers(idmembers_);
        ref_MembersBooksBorrowed.setIdmembers(idmembers_);
        ref_MembersBooksPenalties.setIdmembers(idmembers_);

        ref_MembersBooksReserved.initialize_results_fill_jTableMembers();
        ref_MembersBooksBorrowed.initialize_results_fill_jTableMembers();
        ref_MembersBooksPenalties.initialize_results_fill_jTableMembers();

        getSelectedRowCount_JF_Member_JF_Books_jTableBooks();
        getSelectedRowCount_REF_JF_MembersBooksBorrowed();
        getSelectedRowCount_REF_JF_MembersBooksPenalties();
        getSelectedRowCount_REF_JF_MembersBooksReserved();

    }

    private void addEvents() {
        
        ref_JD_AddNewMembers.jButton_update.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    Connection conn = Database._function_getConnection(Database._booksreservation);
                    if (conn != null) {
                        boolean isPassed = ref_JD_AddNewMembers.checkTheFormFirst();
                        if (isPassed) { // all data is valid
                            boolean isUpdatedCorrectly = ref_JD_AddNewMembers.updatemember();
                            if (isUpdatedCorrectly == true) {
                                // MEMBERS VIEW
//                                if (JF_Administrator.jToggleButton2.isSelected()) {
//                                    JF_Administrator.REF_JF_Administrator_Members.fill_jTableMembers(JF_Administrator.REF_JF_Administrator_Members.getSearchTextField_Keyword(), JF_Administrator.REF_JF_Administrator_Members.limit_first, JF_Administrator.REF_JF_Administrator_Members.limit_second, conn);
//                                    JF_Administrator.REF_JF_Administrator_Members.getSelectedRowCount_jTableMembers();
//                                }
                            } else {
                            }
                        }

                    } else {
                        Database._open_JD_MySQLConnect(Database._booksreservation);
                    }
                } catch (Exception e) {
                }

            }
        });
        
        
        
        addEvents_JF_Members_JF_Books();
        addEvents_JD_ReserveBooks();
        addEvents_REF_JF_MembersBooksBorrowed();
        addEvents_REF_JF_MembersBooksPenalties();
        addEvents_REF_JF_MembersBooksReserved();

    }

    private void addEvents_JF_Members_JF_Books() {
        JF_Member.JF_Books.jTableBooks.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableBooksKeyReleased(evt);
            }

            private void jTableBooksKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_JF_Member_JF_Books_jTableBooks();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_JF_Member_JF_Books_jTableBooks();
                        break;
                }
            }
        });
        JF_Member.JF_Books.jTableBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBooksMouseClicked(evt);
            }

            private void jTableBooksMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        int clickCOunt = evt.getClickCount();
                        if (clickCOunt == 2) {
                            show_books_information();
                        }
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_JF_Member_JF_Books_jTableBooks();
                            jPopupMenuMembers_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableBooksMouseReleased(evt);
            }

            private void jTableBooksMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_JF_Member_JF_Books_jTableBooks();
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        JF_Member.JF_Books.jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }

            private void jScrollPane1MouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_JF_Member_JF_Books_jTableBooks();
                            jPopupMenuMembers_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });

        jMenuItemMembers_ReserveSelected.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveBook();
            }
        });

        JF_Member.JF_Books.jButtonViewInfo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_books_information();
            }
        });

        JF_Member.JF_Books.jButtonCancelReservation.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_reservedBooks();
            }
        });

        JF_Member.jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                setEnabled_MenuItem();
            }
        });

        JF_Member.jToggleButton4.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                getSelectedRowCount_JF_Member_JF_Books_jTableBooks();
            }
        });


        JF_Member.JF_Books.jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                stateChange_JF_Member_Books_jTabbedPane();
            }
        });


    }

    private void getSelectedRowCount_JF_Member_JF_Books_jTableBooks() {
        try {
            int getSelectedRowCount = JF_Member.JF_Books.jTableBooks.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jMenuItemMembers_ReserveSelected.setEnabled(false);
                JF_Member.JF_Books.jButtonViewInfo.setEnabled(false);
                jMenuItem4.setEnabled(false);
                jMenuItem3.setEnabled(false);
                /**/
            } else if (getSelectedRowCount == 1) {
                jMenuItemMembers_ReserveSelected.setEnabled(true);
                JF_Member.JF_Books.jButtonViewInfo.setEnabled(true);
                jMenuItem3.setEnabled(true);
                jMenuItem4.setEnabled(true);
                /**/
            } else if (getSelectedRowCount > 1) {
                jMenuItemMembers_ReserveSelected.setEnabled(false);
                JF_Member.JF_Books.jButtonViewInfo.setEnabled(false);
                jMenuItem3.setEnabled(false);
                jMenuItem4.setEnabled(false);
                /**/
            } else {
                jMenuItemMembers_ReserveSelected.setEnabled(false);
                JF_Member.JF_Books.jButtonViewInfo.setEnabled(false);
                jMenuItem3.setEnabled(false);
                jMenuItem4.setEnabled(false);
            }

            setEnabled_MenuItem();
        } catch (Exception e) {
        }
    }

    private void addEvents_JD_ReserveBooks() {
        ref_JD_ReserveBooks.jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveBook_update();
            }
        });
    }

    private void addEvents_REF_JF_MembersBooksBorrowed() {
        ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }

            private void jTableKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_REF_JF_MembersBooksBorrowed();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_REF_JF_MembersBooksBorrowed();
                        break;
                }
            }
        });
        ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }

            private void jTableMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
//                        int clickCOunt = evt.getClickCount();
//                        if (clickCOunt == 2) {
//                            return_borrowedBooks();
//                        }
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_REF_JF_MembersBooksBorrowed();
                            //jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMouseReleased(evt);
            }

            private void jTableMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_REF_JF_MembersBooksBorrowed();
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        ref_MembersBooksBorrowed.jScrollPaneMembersBooksBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneMouseClicked(evt);
            }

            private void jScrollPaneMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_REF_JF_MembersBooksBorrowed();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });

    }

    private void getSelectedRowCount_REF_JF_MembersBooksBorrowed() {
        try {
            int getSelectedRowCount = ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                /**/
            } else if (getSelectedRowCount == 1) {
                /**/
            } else if (getSelectedRowCount > 1) {
                /**/
            } else {
            }
            setEnabled_MenuItem();
        } catch (Exception e) {
        }


    }

    private void addEvents_REF_JF_MembersBooksPenalties() {
        ref_MembersBooksPenalties.jTableMembersBooksPenalties.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }

            private void jTableKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_REF_JF_MembersBooksPenalties();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_REF_JF_MembersBooksPenalties();
                        break;
                }
            }
        });
        ref_MembersBooksPenalties.jTableMembersBooksPenalties.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }

            private void jTableMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
//                        int clickCOunt = evt.getClickCount();
//                        if (clickCOunt == 2) {
//                            update_membersPenalties();
//                        }
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_REF_JF_MembersBooksPenalties();
                            //jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMouseReleased(evt);
            }

            private void jTableMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_REF_JF_MembersBooksPenalties();
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        ref_MembersBooksPenalties.jScrollPaneMembersBooksPenalties.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneMouseClicked(evt);
            }

            private void jScrollPaneMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_REF_JF_MembersBooksPenalties();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });

    }

    private void getSelectedRowCount_REF_JF_MembersBooksPenalties() {
        try {
            int getSelectedRowCount = ref_MembersBooksPenalties.jTableMembersBooksPenalties.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                /**/
            } else if (getSelectedRowCount == 1) {
                /**/
            } else if (getSelectedRowCount > 1) {
                /**/
            } else {
            }
            setEnabled_MenuItem();
        } catch (Exception e) {
        }
    }

    private void addEvents_REF_JF_MembersBooksReserved() {
        ref_MembersBooksReserved.jTableMembersBooksReserved.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }

            private void jTableKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_REF_JF_MembersBooksReserved();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_REF_JF_MembersBooksReserved();
                        break;
                }
            }
        });
        ref_MembersBooksReserved.jTableMembersBooksReserved.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }

            private void jTableMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
//                int clickCOunt = evt.getClickCount();
//                if (clickCOunt == 2) {
//                    show_books_information();
//                }
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_REF_JF_MembersBooksReserved();
                            //jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMouseReleased(evt);
            }

            private void jTableMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_REF_JF_MembersBooksReserved();
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        ref_MembersBooksReserved.jScrollPaneMembersBooksReserved.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneMouseClicked(evt);
            }

            private void jScrollPaneMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_REF_JF_MembersBooksReserved();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });

    }

    private void getSelectedRowCount_REF_JF_MembersBooksReserved() {
        try {

            int getSelectedRowCount = ref_MembersBooksReserved.jTableMembersBooksReserved.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                JF_Member.JF_Books.jButtonCancelReservation.setEnabled(false);
                jMenuItem2.setEnabled(false);
                /**/
            } else if (getSelectedRowCount == 1) {
                JF_Member.JF_Books.jButtonCancelReservation.setEnabled(true);
                jMenuItem2.setEnabled(true);
                /**/
            } else if (getSelectedRowCount > 1) {
                JF_Member.JF_Books.jButtonCancelReservation.setEnabled(true);
                jMenuItem2.setEnabled(true);
                /**/
            } else {
                JF_Member.JF_Books.jButtonCancelReservation.setEnabled(false);
                jMenuItem2.setEnabled(false);
            }
            setEnabled_MenuItem();
        } catch (Exception e) {
        }

    }

    private void setEnabled_MenuItem() {

        if (JF_Member.jToggleButton1.isSelected()) {
            jMenuItem2.setEnabled((JF_Member.JF_Books.jButtonCancelReservation.isEnabled()) ? true : false);
            jMenuItem3.setEnabled((jMenuItemMembers_ReserveSelected.isEnabled()) ? true : false);
            jMenuItem4.setEnabled((JF_Member.JF_Books.jButtonViewInfo.isEnabled()) ? true : false);
        } else {
            jMenuItem2.setEnabled(false);
            jMenuItem3.setEnabled(false);
        }

        if (JF_Member.jToggleButton4.isSelected()) {
        } else {
        }
    }

    private void reserveSelectedBooks() {
    }

// ----------------------------------------------------------------------------- SHOW BOOKS INFORMATION
    private void show_books_information() {
        try {
            int selectedColumn = function_getColumnNumber_jTable("idbooks", JF_Member.JF_Books.jTableBooks);
            int selectedRow = JF_Member.JF_Books.jTableBooks.getSelectedRow();
            int idbooks = JF_Member.JF_Books.jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();

//            if (ref_BooksInformation == null || !ref_BooksInformation.isVisible()) {
            if (!ref_BooksInformation.isVisible()) {
//                ref_BooksInformation = new JF_BooksInformation();
                // ref_BooksInformation.add(image1);
                // ref_BooksInformation.setSize(image1.getWidth(),image1.getHeight());
                ref_BooksInformation.setLocationRelativeTo(JF_Member);
                ref_BooksInformation.setAlwaysOnTop(true);
                ref_BooksInformation.setVisible(true);
            }

            ref_BooksInformation.setIdbooks_information(idbooks);
            ref_BooksInformation.validate_BooksInformation();
            ref_BooksInformation.validate_BooksImage();
            ref_BooksInformation.validate_BooksInformation_Additional();
            ref_BooksInformation.check_userlogs();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void view_user_log_information() {

        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                ref_JD_AddNewMembers.setLocationRelativeTo(JF_Member);
                ref_JD_AddNewMembers.setModal(true);
                ref_JD_AddNewMembers.setAlwaysOnTop(true);
                ref_JD_AddNewMembers.setIsneedupdate(false);
                ref_JD_AddNewMembers.setIdmembers(UserLogs.getIdmembers());
                ref_JD_AddNewMembers.setTitle("Information");
                ref_JD_AddNewMembers.refreshForm();
                ref_JD_AddNewMembers.jButton_Add.setVisible(false);
                ref_JD_AddNewMembers.jButton_update.setVisible(true);
                if ("Administrator".equals(UserLogs.getMembertype())) {
                    ref_JD_AddNewMembers.student_view_form(true);
                } else {
                    ref_JD_AddNewMembers.student_view_form(false);
                }
                ref_JD_AddNewMembers.setTitle(ref_members.function_get_firstname_lastname(ref_JD_AddNewMembers.getIdmembers(), conn));
                ref_JD_AddNewMembers.setVisible(true);

                if (ref_JD_AddNewMembers.isIsneedupdate()) {
//                    fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
//                    getSelectedRowCount_jTableMembers();
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
        }
    }

// ----------------------------------------------------------------------------- [RESERVE BOOKS]
    public void reserveBook() {
        try {
            ref_JD_ReserveBooks.setLocationRelativeTo(JF_Member);
            ref_JD_ReserveBooks.setModal(true);
            ref_JD_ReserveBooks.setAlwaysOnTop(true);
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int getSelectedRowCount = JF_Member.JF_Books.jTableBooks.getSelectedRowCount();
                if (getSelectedRowCount == 1) {

                    int selectedColumn = function_getColumnNumber_jTable("idbooks", JF_Member.JF_Books.jTableBooks);
                    int selectedRow = JF_Member.JF_Books.jTableBooks.getSelectedRow();
                    int idbooks_ = JF_Member.JF_Books.jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();

                    int isBooksBorrowable = ref_books.function_get_isborrowable(idbooks_, conn);
                    if (isBooksBorrowable == 0) { // IF NOT BORROWABLE -> 0
                        JOptionPane.showMessageDialog(JF_Member, "Sorry...\nThis book is not Loanable...", "Reservation Failed", JOptionPane.ERROR_MESSAGE);
                    } else {
                        boolean can_reserve = ref_reserve.function_is_idmembers_can_reserve_again_to_this_idbook(UserLogs.getIdmembers(), idbooks_, conn);
                        if (can_reserve) {
                            try {
                                ref_JD_ReserveBooks.setIdbooks(idbooks_);
                                ref_JD_ReserveBooks.setVisible(true);
                                ref_JD_ReserveBooks.refreshForm();
                                ref_JD_ReserveBooks.jButton2.setVisible(true);
                            } catch (Exception e) {
                                System.err.println(e);
                            }
                        } else {
                            JOptionPane.showMessageDialog(JF_Member, "Sorry...\nYou already reserved this book...", "Reservation Failed", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    private void reserveBook_update() {
        Connection conn = Database._function_getConnection(Database._booksreservation);
        if (conn != null) {
            boolean isReserved = ref_JD_ReserveBooks.reserveBooks();
            if (isReserved) {
                JOptionPane.showMessageDialog(ref_JD_ReserveBooks, "Item Successfully Reserved", "Message", JOptionPane.PLAIN_MESSAGE);
                ref_JD_ReserveBooks.dispose();
                JF_Member.JF_Books.fill_jTableBooks(JF_Member.JF_Books.getSearchTextField_Keyword(), JF_Member.JF_Books.limit_first, JF_Member.JF_Books.limit_second, conn);
                ref_MembersBooksReserved.initialize_results_fill_jTableMembers();
            }
        }
    }

// ----------------------------------------------------------------------------- CANCEL RESERVED BOOKS
    private void cancel_reservedBooks() {
        try {
            /**/
            Object[] options = {"  Yes  ", "  No  "};
            int n3 = JOptionPane.showOptionDialog(
                    this,
                    "Cancel selected reservation?",
                    "Cancel Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (n3 == JOptionPane.YES_OPTION) {
                cancel_reservedBooks_yes();
            } else if (n3 == JOptionPane.NO_OPTION) {
            } else {
            }
            /**/
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void cancel_reservedBooks_yes() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int r_idreserve[];
                r_idreserve = ref_MembersBooksReserved.jTableMembersBooksReserved.getSelectedRows();
                for (int c = 0; c < ref_MembersBooksReserved.jTableMembersBooksReserved.getColumnCount(); c++) {
                    String columnName = ref_MembersBooksReserved.jTableMembersBooksReserved.getColumnName(c);
                    if ("idreserve".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_idreserve.length; r++) {
                            r_idreserve[r] = ref_MembersBooksReserved.jTableMembersBooksReserved.getValueAt(r_idreserve[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (r_idreserve.length > 0) {
                    ref_reserve.update_reserve_status_to_canceled(r_idreserve, conn);

                    ref_MembersBooksReserved.initialize_results_fill_jTableMembers();
                    getSelectedRowCount_REF_JF_MembersBooksReserved();
                    JF_Member.JF_Books.fill_jTableBooks(JF_Member.JF_Books.getSearchTextField_Keyword(), JF_Member.JF_Books.limit_first, JF_Member.JF_Books.limit_second, conn);
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- STATECHANGE jTabbedPane
    private void stateChange_JF_Member_Books_jTabbedPane() {
        try {
            if (ref_MembersBooksReserved.jPanel2.isVisible()) {
                getSelectedRowCount_REF_JF_MembersBooksReserved();
            } else {
                JF_Member.JF_Books.jButtonCancelReservation.setEnabled(false);
            }
            setEnabled_MenuItem();
        } catch (Exception e) {
            System.err.println("stateChange_JF_Administrator_Books_jTabbedPane");
        }
    }

// ----------------------------------------------------------------------------- GENERATE REPORTS    
    private void generateReports(int idmembers) {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                String jasperFileDirectory = reportsDirectory + "membersInformation.jasper";
                HashMap parameters = new HashMap();
                parameters.put("idmembers", idmembers);
                String title_ = "JIF SINGLE INSTANCE";
                if (ref_JIF_Reports_Single == null || ref_JIF_Reports_Single.isClosed()) {
                    open_JIF_Reports_Single_Instance(title_, jasperFileDirectory, parameters, conn);
                } else {
                    ref_JIF_Reports_Single.setJasperPrint(JasperFillManager.fillReport(jasperFileDirectory, parameters, conn));
                    JRViewer viewer = new JRViewer(ref_JIF_Reports_Single.getJasperPrint());

                    ref_JIF_Reports_Single.getInstanceContainer().removeAll();
                    ref_JIF_Reports_Single.getInstanceContainer().add(viewer);
                    ref_JIF_Reports_Single.validate();

                    ref_JIF_Reports_Single.setVisible(true);
                    if (ref_JIF_Reports_Single.isIcon()) {
                        ref_JIF_Reports_Single.setIcon(false);
                    }
                    ref_JIF_Reports_Single.setSelected(true);
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /* open JInternalFrame */
    private void open_JIF_Reports_Single_Instance(String JIF_Title, String jasperFileDirectory, HashMap parameters, Connection conn) {
        try {
            int widht = 400;
            int height = 400;
            ref_JIF_Reports_Single = new JIFrameJasperReportsViewer(jasperFileDirectory, parameters, conn, true);
            ref_JIF_Reports_Single.setSize(widht, height);
            open_JInternalFrame(ref_JIF_Reports_Single, JF_Member.ref_JF_Administrator_Reports.DP1);
            ref_JIF_Reports_Single.setBorder(null);
            ref_JIF_Reports_Single.setClosable(true);
            ref_JIF_Reports_Single.setFocusCycleRoot(true);
            ref_JIF_Reports_Single.setIconifiable(true);
            ref_JIF_Reports_Single.setLayer(1);
            ref_JIF_Reports_Single.setMaximizable(true);
            ref_JIF_Reports_Single.setMaximum(true);
            ref_JIF_Reports_Single.setResizable(true);
            ref_JIF_Reports_Single.setRequestFocusEnabled(true);
            ref_JIF_Reports_Single.setTitle(JIF_Title);
            ref_JIF_Reports_Single.setVerifyInputWhenFocusTarget(true);
            ref_JIF_Reports_Single.setVisible(true);
            ref_JIF_Reports_Single.setSelected(true);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

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
// ----------------------------------------------------------------------------- END GENERATE REPORTS    
}
