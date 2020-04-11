package gui.booksreservation.main;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import mcbx.jb.classes.database.booksreservation.UserLogs;
import mcbx.jb.classes.database.booksreservation.books;
import mcbx.jb.classes.database.booksreservation.borrow;
import mcbx.jb.classes.database.booksreservation.category;
import mcbx.jb.classes.database.booksreservation.members;
import mcbx.jb.classes.database.booksreservation.reserve;
import mcbx.jb.classes.databaseconnection.Database;
import mcbx.jb.classes.mycollection.DesktopPane;
import mcbx.jb.classes.mycollection.JIFrameJasperReportsViewer;
import mcbx.jb.classes.mycollection.MyFunctions;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.swing.JRViewer;

public class JIF_Container_Administrator extends javax.swing.JInternalFrame {

    public JIF_Administrator_Reports_Image ref_JIF_Administrator_Reports_Image;
    private Thread ThreadFirst;
    long ThreadSleep = 1;
    public JIFrameJasperReportsViewer ref_JIF_Reports, ref_JIF_Reports_Single;
    private String reportsDirectory = System.getProperty("user.dir") + "/reports/booksreservation/";
    String SUBREPORT_DIR = (System.getProperty("user.dir") + "\\reports\\booksreservation\\").toString().replace("\\", "\\\\");
    /**/
    public JF_Administrator JF_Administrator = new JF_Administrator();
    private JF_Administrator_BooksBorrowed JF_BooksBorrowed = new JF_Administrator_BooksBorrowed();
    private JF_Administrator_BooksReserved JF_BooksReserved = new JF_Administrator_BooksReserved();
    private JD_AddNewMembers ref_JD_AddNewMembers = new JD_AddNewMembers(JF_Administrator, false);
    private JD_BorrowBooks ref_JD_BorrowBooks = new JD_BorrowBooks(JF_Administrator, false);
    private JD_Reports_MostBorrowedBooks ref_JD_Reports_MostBorrowedBooks = new JD_Reports_MostBorrowedBooks(JF_Administrator, false);
    /**/
    private books ref_books = new books();
    private members ref_members = new members();
    private reserve ref_reserve = new reserve();
    private category ref_category = new category();
    private MyFunctions ref_MyFunctions = new MyFunctions();
    /**/
    private JF_BooksInformation ref_BooksInformation = new JF_BooksInformation();

    public JIF_Container_Administrator() {
        initComponents();

        ref_BooksInformation = new JF_BooksInformation();
        ref_BooksInformation.check_userlogs();

        addComponents();
        addEvents();
        //
        getSelectedRowCount_JF_Administrator_BooksReserved_jTableReserved();
        getSelectedRowCount_JF_Administrator_BooksBorrowed_jTableBorrowed();

        jMenu4.setVisible(false);
        jMenu7.setVisible(false);

        setThread();


        ref_JD_Reports_MostBorrowedBooks.set_jDialogReports();


    }

    private void setThread() {
        ThreadFirst = new Thread() {
            @Override
            public void run() {
                try {
                    jMenuItem17.setEnabled(false);
                    if (!JF_Administrator.jToggleButton4.isSelected()) {
                        JF_Administrator.jToggleButton4.setSelected(true);
                    }
                    sleep(ThreadSleep);
                    generateReports_Single(1);
                    if (!JF_Administrator.jToggleButton4.isSelected()) {
                        JF_Administrator.jToggleButton4.setSelected(true);

                    }
                    jMenuItem17.setEnabled(true);
                } catch (InterruptedException ex) {
                    System.err.println("Interrupted Exception");
                }
            }
        };

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

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administrator");
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setMnemonic('p');
        jMenu1.setText("Profile");

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

        jMenu2.setMnemonic('b');
        jMenu2.setText("Books");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setMnemonic('n');
        jMenuItem2.setText("New Books");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenu6.setMnemonic('s');
        jMenu6.setText("Books Information");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setMnemonic('c');
        jMenuItem9.setText("Category");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);
        jMenu6.add(jSeparator3);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setMnemonic('a');
        jMenuItem10.setText("Authors");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setMnemonic('p');
        jMenuItem11.setText("Publishers");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setMnemonic('s');
        jMenuItem12.setText("Subjects");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenu2.add(jMenu6);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setMnemonic('f');
        jMenuItem3.setText("View Information");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem20.setText("Generate Reports");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem20);
        jMenu2.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setMnemonic('b');
        jMenuItem4.setText("Borrow Books");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setMnemonic('r');
        jMenuItem6.setText("Return Books");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);
        jMenu2.add(jSeparator2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setMnemonic('c');
        jMenuItem5.setText("Cancel Reservation");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setMnemonic('m');
        jMenu3.setText("Members");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setMnemonic('n');
        jMenuItem7.setText("New Member");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem8.setMnemonic('f');
        jMenuItem8.setText("View Information");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem19.setText("Generate Reports");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem19);
        jMenu3.add(jSeparator4);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem14.setMnemonic('r');
        jMenuItem14.setText("Return Books");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem15.setMnemonic('d');
        jMenuItem15.setText("Update Penalties");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);
        jMenu3.add(jSeparator5);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem13.setMnemonic('c');
        jMenuItem13.setText("Cancel Reservation");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuBar1.add(jMenu3);

        jMenu4.setMnemonic('r');
        jMenu4.setText("Records");
        jMenuBar1.add(jMenu4);

        jMenu5.setMnemonic('e');
        jMenu5.setText("Reports");

        jMenu8.setText("Most Borrowed Books");

        jMenuItem22.setText("Pie Chart");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem22);

        jMenuItem23.setText("Bar Graph");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem23);

        jMenu5.add(jMenu8);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Reports Sample");

        jMenuItem16.setText("Multiple Reports");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem16);

        jMenuItem17.setMnemonic('s');
        jMenuItem17.setText("Single Reports");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem17);

        jMenuItem18.setText("Members Reports @ Single Reports");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem18);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        show_books_information();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        if (ref_BooksInformation.isVisible()) {
            ref_BooksInformation.dispose();
        }


    }//GEN-LAST:event_formInternalFrameClosed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        ref_BooksInformation.validateAddBooksForms_addBooks();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ref_BooksInformation.show_jDialog_Category();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        ref_BooksInformation.show_JD_Authors();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        ref_BooksInformation.show_JD_Publishers();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        ref_BooksInformation.show_JD_Subjects();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        return_borrowedBooks();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        cancel_reservedBooks();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//
//        ref_JD_AddNewMembers.setSize(ref_JD_AddNewMembers.getPreferredSize());
//        ref_JD_AddNewMembers.setLocationRelativeTo(null);
//        ref_JD_AddNewMembers.setAlwaysOnTop(true);
//        ref_JD_AddNewMembers.setVisible(true);


        ref_JD_AddNewMembers.setEnabled_viewInformation(UserLogs.getIdmembers());
        view_user_log_information();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        ref_JD_AddNewMembers.setEnabled_addMembers();
        add_new_members();

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        borrow_selected_books();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        cancelMembers_booksReservation();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        view_members_information();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        return_borrowedBooks();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        update_membersPenalties();

    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed

        generateReports_Multiple();
        JF_Administrator.jToggleButton4.setSelected(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    @SuppressWarnings("CallToThreadRun")
    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        try {

            if (Thread.currentThread().getId() == ThreadFirst.getId()) {
                JOptionPane.showMessageDialog(this, "Generating report Thread1 is running...\nPlease wait...", "Warning", JOptionPane.WARNING_MESSAGE, null);
            } else {
                if (ThreadFirst.getState() == Thread.State.NEW) {
                    ThreadFirst.start();
                } else if (ThreadFirst.getState() == Thread.State.TERMINATED) { // TERMINATED
                    ThreadFirst.run();
                }
            }
        } catch (Exception e) {
            System.err.println("Exception");
        }


    }//GEN-LAST:event_jMenuItem17ActionPerformed

    @SuppressWarnings("CallToThreadRun")
    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        jMenuItem19.setEnabled(false);
                        if (!JF_Administrator.jToggleButton4.isSelected()) {
                            JF_Administrator.jToggleButton4.setSelected(true);
                        }
                        sleep(ThreadSleep);

                        generateReports_MembersInformation();
                        if (!JF_Administrator.jToggleButton4.isSelected()) {
                            JF_Administrator.jToggleButton4.setSelected(true);
                        }
                        jMenuItem19.setEnabled(true);
                    } catch (InterruptedException ex) {
                        System.err.println("Interrupted Exception");
                    }
                }
            }.start();
        } catch (Exception e) {
            System.err.println("Exception");
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        jMenuItem19.setEnabled(false);
                        if (!JF_Administrator.jToggleButton4.isSelected()) {
                            JF_Administrator.jToggleButton4.setSelected(true);
                        }
                        sleep(ThreadSleep);

                        generateReports_MembersInformation();
                        if (!JF_Administrator.jToggleButton4.isSelected()) {
                            JF_Administrator.jToggleButton4.setSelected(true);
                        }
                        jMenuItem19.setEnabled(true);
                    } catch (InterruptedException ex) {
                        System.err.println("Interrupted Exception");
                    }
                }
            }.start();
        } catch (Exception e) {
            System.err.println("Exception");
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        jMenuItem20.setEnabled(false);
                        if (!JF_Administrator.jToggleButton4.isSelected()) {
                            JF_Administrator.jToggleButton4.setSelected(true);
                        }
                        sleep(ThreadSleep);

                        generateReports_BooksInformation();
                        if (!JF_Administrator.jToggleButton4.isSelected()) {
                            JF_Administrator.jToggleButton4.setSelected(true);
                        }
                        jMenuItem20.setEnabled(true);
                    } catch (InterruptedException ex) {
                        System.err.println("Interrupted Exception");
                    }
                }
            }.start();
        } catch (Exception e) {
            System.err.println("Exception");
        }
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed

        ref_JD_Reports_MostBorrowedBooks.setReportType("PieChart");
        view_JD_Reports_MostBorrowedBooks();


//        

    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        ref_JD_Reports_MostBorrowedBooks.setReportType("BarGraph");
        view_JD_Reports_MostBorrowedBooks();



    }//GEN-LAST:event_jMenuItem23ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    // End of variables declaration//GEN-END:variables

// ----------------------------------------------------------------------------- ADD COMPONENTS    
    private void addComponents() {
        /* JF_Administrator */
        jPanel1.add(JF_Administrator.jPanel1);
        JF_Administrator.itemStateChange();
        /* JF_Administrator_Books */
        JF_Administrator.JF_Books.jTabbedPane1.add("    Books Reservation    ", JF_BooksReserved.jPanel2);
        JF_Administrator.JF_Books.jTabbedPane1.add("    Borrower    ", JF_BooksBorrowed.jPanel2);

        /* INITIALIZE TABLES */
        JF_Administrator.JF_Books.initialize_results_fill_jTableBooks();
        JF_BooksReserved.initialize_results_fill_jTableMembers();
        JF_BooksBorrowed.initialize_results_fill_jTableBorrowed();
    }

// ----------------------------------------------------------------------------- ADD EVENTS
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

                                JF_Administrator.REF_JF_Administrator_Members.fill_jTableMembers(JF_Administrator.REF_JF_Administrator_Members.getSearchTextField_Keyword(), JF_Administrator.REF_JF_Administrator_Members.limit_first, JF_Administrator.REF_JF_Administrator_Members.limit_second, conn);
                                JF_Administrator.REF_JF_Administrator_Members.getSelectedRowCount_jTableMembers();

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
        ref_JD_Reports_MostBorrowedBooks.jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Connection conn = Database._function_getConnection(Database._booksreservation);
                    if (conn != null) {
                        new Thread() {
                            @Override
                            public void run() {
                                try {
                                    jMenuItem22.setEnabled(false);
                                    jMenuItem23.setEnabled(false);
                                    ref_JD_Reports_MostBorrowedBooks.jButton1.setEnabled(false);

                                    if (!JF_Administrator.jToggleButton4.isSelected()) {
                                        JF_Administrator.jToggleButton4.setSelected(true);
                                    }
                                    sleep(ThreadSleep);

                                    java.util.Date dateFrom = ref_JD_Reports_MostBorrowedBooks.JDC_dateFrom.getDate();
                                    java.util.Date dateTo = ref_JD_Reports_MostBorrowedBooks.JDC_dateTo.getDate();
                                    String title_ = ref_JD_Reports_MostBorrowedBooks.jTextField1.getText().trim().toString();
                                    generateReports_MostBorrowedBooks_BarGraph(title_, dateFrom, dateTo);

                                    if (!JF_Administrator.jToggleButton4.isSelected()) {
                                        JF_Administrator.jToggleButton4.setSelected(true);
                                    }

                                    jMenuItem22.setEnabled(true);
                                    jMenuItem23.setEnabled(true);
                                    ref_JD_Reports_MostBorrowedBooks.jButton1.setEnabled(true);
                                } catch (InterruptedException ex) {
                                    System.err.println("Interrupted Exception");
                                }
                            }
                        }.start();
                    } else {
                        Database._open_JD_MySQLConnect(Database._booksreservation);
                    }
                } catch (Exception e) {
                }

            }
        });


        addEvents_JF_BooksInformation();
        addEvents_JD_Authors();
        addEvents_JD_Publishers();
        addEvents_JD_Subjects();

        addEvents_JF_Administrator();
        addEvents_REF_JF_Administrator_Members();
        addEvents_REF_JF_MembersBooksBorrowed();
        addEvents_REF_JF_MembersBooksPenalties();
        addEvents_REF_JF_MembersBooksReserved();

        addEvents_JF_Administrator_Books();
        addEvents_JF_Administrator_BooksReserved();
        addEvents_JF_Administrator_BooksBorrowed();
        addEvents_JF_Administrator_Members();
        addEvents_JF_Administrator_Records();
        addEvents_JF_Administrator_Reports();
    }

    private void addEvents_JF_BooksInformation() {
        ref_BooksInformation.jButton_updateBooksInformation.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (ref_BooksInformation.updateBooksInformation() == true) {
                    Connection conn = Database._function_getConnection(Database._booksreservation);
                    if (conn != null) {
                        JOptionPane.showMessageDialog(ref_BooksInformation, "Books Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE, null);
                        JF_Administrator.JF_Books.fill_jTableBooks(JF_Administrator.JF_Books.getSearchTextField_Keyword(), JF_Administrator.JF_Books.limit_first, JF_Administrator.JF_Books.limit_second, conn);
                        getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                    } else {
                        Database._open_JD_MySQLConnect(Database._booksreservation);
                        if (Database._booksreservation.getConnection() != null) {
                        }
                    }
                }
            }
        });
        ref_BooksInformation.jButton_updateCategoryName.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (ref_BooksInformation.updateSelectedCategory() == true) {
                    Connection conn = Database._function_getConnection(Database._booksreservation);
                    if (conn != null) {
                        JOptionPane.showMessageDialog(ref_BooksInformation.jDialog_Category, "Books Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE, null);
                        JF_Administrator.JF_Books.fill_jTableBooks(JF_Administrator.JF_Books.getSearchTextField_Keyword(), JF_Administrator.JF_Books.limit_first, JF_Administrator.JF_Books.limit_second, conn);
                        getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                    } else {
                        Database._open_JD_MySQLConnect(Database._booksreservation);
                        if (Database._booksreservation.getConnection() != null) {
                        }
                    }
                }
            }
        });

        ref_BooksInformation.ref_JD_Authors.jButton_updateAuthor.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (ref_BooksInformation.updateSelected_JD_Authors() == true) {
                    Connection conn = Database._function_getConnection(Database._booksreservation);
                    if (conn != null) {
                        JF_Administrator.JF_Books.fill_jTableBooks(JF_Administrator.JF_Books.getSearchTextField_Keyword(), JF_Administrator.JF_Books.limit_first, JF_Administrator.JF_Books.limit_second, conn);
                        getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                    } else {
                        Database._open_JD_MySQLConnect(Database._booksreservation);
                        if (Database._booksreservation.getConnection() != null) {
                        }
                    }
                }
            }
        });
        ref_BooksInformation.ref_JD_Publishers.jButton_updatePublisher.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (ref_BooksInformation.updateSelected_JD_Publishers() == true) {
                    Connection conn = Database._function_getConnection(Database._booksreservation);
                    if (conn != null) {
                        JF_Administrator.JF_Books.fill_jTableBooks(JF_Administrator.JF_Books.getSearchTextField_Keyword(), JF_Administrator.JF_Books.limit_first, JF_Administrator.JF_Books.limit_second, conn);
                        getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                    } else {
                        Database._open_JD_MySQLConnect(Database._booksreservation);
                        if (Database._booksreservation.getConnection() != null) {
                        }
                    }
                }
            }
        });
    }

    private void addEvents_JD_Authors() {
        ref_BooksInformation.ref_JD_Authors.jTableAuthors.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableAuthorsKeyReleased(evt);
            }

            private void jTableAuthorsKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_JD_Authors_jTableAuthors();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_JD_Authors_jTableAuthors();
                        break;
                }
            }
        });
        ref_BooksInformation.ref_JD_Authors.jTableAuthors.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAuthorsMouseClicked(evt);
            }

            private void jTableAuthorsMouseClicked(MouseEvent evt) {
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
                            getSelectedRowCount_JD_Authors_jTableAuthors();
                            //jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableAuthorsMouseReleased(evt);
            }

            private void jTableAuthorsMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_JD_Authors_jTableAuthors();
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
        ref_BooksInformation.ref_JD_Authors.jScrollPaneAuthors.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneAuthorsMouseClicked(evt);
            }

            private void jScrollPaneAuthorsMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_JD_Authors_jTableAuthors();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });

    }

    private void getSelectedRowCount_JD_Authors_jTableAuthors() {
//        ref_BooksInformation.ref_JD_Authors.getSelectedRowCount_jTableAuthors();
        boolean isVisible_ = isVisible_ref_BooksInformation();

        int getSelectedRowCount = ref_BooksInformation.ref_JD_Authors.jTableAuthors.getSelectedRowCount();
        if (getSelectedRowCount == 0) {
            ref_BooksInformation.ref_JD_Authors.jMenuItem_addToBooksInformation.setEnabled(false);
            ref_BooksInformation.ref_JD_Authors.jMenuItem4.setEnabled(false);
            ref_BooksInformation.ref_JD_Authors.jMenuItem5.setEnabled(false);
            /**/
        } else if (getSelectedRowCount == 1) {
            /**/
            ref_BooksInformation.ref_JD_Authors.jMenuItem_addToBooksInformation.setEnabled(isVisible_);
            ref_BooksInformation.ref_JD_Authors.jMenuItem4.setEnabled(true);
            ref_BooksInformation.ref_JD_Authors.jMenuItem5.setEnabled(true);
        } else if (getSelectedRowCount > 1) {
            /**/
            ref_BooksInformation.ref_JD_Authors.jMenuItem_addToBooksInformation.setEnabled(isVisible_);
            ref_BooksInformation.ref_JD_Authors.jMenuItem4.setEnabled(false);
            ref_BooksInformation.ref_JD_Authors.jMenuItem5.setEnabled(true);
        } else {
            ref_BooksInformation.ref_JD_Authors.jMenuItem_addToBooksInformation.setEnabled(false);
        }

    }

    private void addEvents_JD_Publishers() {
        ref_BooksInformation.ref_JD_Publishers.jTablePublishers.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePublishersKeyReleased(evt);
            }

            private void jTablePublishersKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_JD_Publishers_jTablePublishers();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_JD_Publishers_jTablePublishers();
                        break;
                }
            }
        });
        ref_BooksInformation.ref_JD_Publishers.jTablePublishers.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePublishersMouseClicked(evt);
            }

            private void jTablePublishersMouseClicked(MouseEvent evt) {
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
                            getSelectedRowCount_JD_Publishers_jTablePublishers();
                            //jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTablePublishersMouseReleased(evt);
            }

            private void jTablePublishersMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_JD_Publishers_jTablePublishers();
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
        ref_BooksInformation.ref_JD_Publishers.jScrollPanePublishers.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPanePublishersMouseClicked(evt);
            }

            private void jScrollPanePublishersMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_JD_Publishers_jTablePublishers();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
    }

    private void getSelectedRowCount_JD_Publishers_jTablePublishers() {

        boolean isVisible_ = isVisible_ref_BooksInformation();

        int getSelectedRowCount = ref_BooksInformation.ref_JD_Publishers.jTablePublishers.getSelectedRowCount();
        if (getSelectedRowCount == 0) {
            ref_BooksInformation.ref_JD_Publishers.jMenuItem_addToBooksInformation.setEnabled(false);
            ref_BooksInformation.ref_JD_Publishers.jMenuItem4.setEnabled(false);
            ref_BooksInformation.ref_JD_Publishers.jMenuItem5.setEnabled(false);
            /**/
        } else if (getSelectedRowCount == 1) {
            /**/
            ref_BooksInformation.ref_JD_Publishers.jMenuItem_addToBooksInformation.setEnabled(isVisible_);
            jMenuItem4.setEnabled(true);
            jMenuItem5.setEnabled(true);
        } else if (getSelectedRowCount > 1) {
            /**/
            ref_BooksInformation.ref_JD_Publishers.jMenuItem_addToBooksInformation.setEnabled(isVisible_);
            ref_BooksInformation.ref_JD_Publishers.jMenuItem4.setEnabled(false);
            ref_BooksInformation.ref_JD_Publishers.jMenuItem5.setEnabled(true);
        } else {
            ref_BooksInformation.ref_JD_Publishers.jMenuItem_addToBooksInformation.setEnabled(false);
        }


    }

    private void addEvents_JD_Subjects() {
        ref_BooksInformation.ref_JD_Subjects.jTableSubjects.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSubjectsKeyReleased(evt);
            }

            private void jTableSubjectsKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_JD_Subjects_jTableSubjects();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_JD_Subjects_jTableSubjects();
                        break;
                }
            }
        });
        ref_BooksInformation.ref_JD_Subjects.jTableSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSubjectsMouseClicked(evt);
            }

            private void jTableSubjectsMouseClicked(MouseEvent evt) {
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
                            getSelectedRowCount_JD_Subjects_jTableSubjects();
                            //jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }

                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSubjectsMouseReleased(evt);
            }

            private void jTableSubjectsMouseReleased(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        getSelectedRowCount_JD_Subjects_jTableSubjects();
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
        ref_BooksInformation.ref_JD_Subjects.jScrollPaneSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneSubjectsMouseClicked(evt);
            }

            private void jScrollPaneSubjectsMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_JD_Subjects_jTableSubjects();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
    }

    private void getSelectedRowCount_JD_Subjects_jTableSubjects() {

        boolean isVisible_ = isVisible_ref_BooksInformation();

        int getSelectedRowCount = ref_BooksInformation.ref_JD_Subjects.jTableSubjects.getSelectedRowCount();
        if (getSelectedRowCount == 0) {
            ref_BooksInformation.ref_JD_Subjects.jMenuItem_addToBooksInformation.setEnabled(false);
            ref_BooksInformation.ref_JD_Subjects.jMenuItem4.setEnabled(false);
            ref_BooksInformation.ref_JD_Subjects.jMenuItem5.setEnabled(false);
            /**/
        } else if (getSelectedRowCount == 1) {
            /**/
            ref_BooksInformation.ref_JD_Subjects.jMenuItem_addToBooksInformation.setEnabled(isVisible_);
            ref_BooksInformation.ref_JD_Subjects.jMenuItem4.setEnabled(true);
            ref_BooksInformation.ref_JD_Subjects.jMenuItem5.setEnabled(true);
        } else if (getSelectedRowCount > 1) {
            /**/
            ref_BooksInformation.ref_JD_Subjects.jMenuItem_addToBooksInformation.setEnabled(isVisible_);
            ref_BooksInformation.ref_JD_Subjects.jMenuItem4.setEnabled(false);
            ref_BooksInformation.ref_JD_Subjects.jMenuItem5.setEnabled(true);
        } else {
            ref_BooksInformation.ref_JD_Subjects.jMenuItem_addToBooksInformation.setEnabled(false);
        }
    }

    private boolean isVisible_ref_BooksInformation() {
        if (!ref_BooksInformation.isVisible()) {
            return false;
        }
        return true;
    }

    //
    private void addEvents_JF_Administrator() {
        JF_Administrator.jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                setEnabled_MenuItem();
            }
        });
        JF_Administrator.jToggleButton2.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                setEnabled_MenuItem();
            }
        });
        JF_Administrator.jToggleButton3.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                setEnabled_MenuItem();
            }
        });
        JF_Administrator.jToggleButton4.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                setEnabled_MenuItem();
            }
        });

    }

    //
    private void addEvents_REF_JF_Administrator_Members() {
        JF_Administrator.REF_JF_Administrator_Members.jTableMembers.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }

            private void jTableKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_REF_JF_Administrator_Members();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_REF_JF_Administrator_Members();
                        break;
                }
            }
        });
        JF_Administrator.REF_JF_Administrator_Members.jTableMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }

            private void jTableMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        int clickCOunt = evt.getClickCount();
                        if (clickCOunt == 2) {
                            view_members_information();
                        }
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_REF_JF_Administrator_Members();
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
                        getSelectedRowCount_REF_JF_Administrator_Members();
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
        JF_Administrator.REF_JF_Administrator_Members.jScrollPaneMembers.addMouseListener(new java.awt.event.MouseAdapter() {
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
                            getSelectedRowCount_REF_JF_Administrator_Members();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });

        JF_Administrator.REF_JF_Administrator_Members.jButtonViewInfo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_members_information();
            }
        });
        JF_Administrator.REF_JF_Administrator_Members.jButtonCancelReservation.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        JF_Administrator.REF_JF_Administrator_Members.jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_borrowedBooks();
            }
        });
        JF_Administrator.REF_JF_Administrator_Members.jButtonUpdatePenalties.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_membersPenalties();
            }
        });


    }

    private void getSelectedRowCount_REF_JF_Administrator_Members() {
        try {
            int getSelectedRowCount = JF_Administrator.REF_JF_Administrator_Members.jTableMembers.getSelectedRowCount();
            if (getSelectedRowCount == 0) {
                jMenuItem19.setEnabled(false);
                /**/
            } else if (getSelectedRowCount == 1) {
                jMenuItem19.setEnabled(true);
                /**/
            } else if (getSelectedRowCount > 1) {
                jMenuItem19.setEnabled(false);
                /**/
            } else {
                jMenuItem19.setEnabled(false);
            }

            setEnabled_MenuItem();
        } catch (Exception e) {
        }
    }

    private void addEvents_REF_JF_MembersBooksBorrowed() {
        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.addKeyListener(new java.awt.event.KeyAdapter() {
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
        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }

            private void jTableMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        int clickCOunt = evt.getClickCount();
                        if (clickCOunt == 2) {
                            return_borrowedBooks();
                        }
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
        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.jScrollPaneMembersBooksBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
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
            int getSelectedRowCount = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.getSelectedRowCount();
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
        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.jTableMembersBooksPenalties.addKeyListener(new java.awt.event.KeyAdapter() {
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
        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.jTableMembersBooksPenalties.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }

            private void jTableMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        int clickCOunt = evt.getClickCount();
                        if (clickCOunt == 2) {
                            update_membersPenalties();
                        }
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
        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.jScrollPaneMembersBooksPenalties.addMouseListener(new java.awt.event.MouseAdapter() {
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
            int getSelectedRowCount = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.jTableMembersBooksPenalties.getSelectedRowCount();
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
        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.jTableMembersBooksReserved.addKeyListener(new java.awt.event.KeyAdapter() {
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
        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.jTableMembersBooksReserved.addMouseListener(new java.awt.event.MouseAdapter() {
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
        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.jScrollPaneMembersBooksReserved.addMouseListener(new java.awt.event.MouseAdapter() {
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

            int getSelectedRowCount = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.jTableMembersBooksReserved.getSelectedRowCount();
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

    //
    private void addEvents_JF_Administrator_Books() {
        JF_Administrator.JF_Books.jTableBooks.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableBooksKeyReleased(evt);
            }

            private void jTableBooksKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                        break;
                }
            }
        });
        JF_Administrator.JF_Books.jTableBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBooksMouseClicked(evt);
            }

            private void jTableBooksMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                int clickCOunt = evt.getClickCount();
                if (clickCOunt == 2) {
                    show_books_information();
                }
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                            //jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
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
                        getSelectedRowCount_JF_Administrator_Books_jTableBooks();
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
        JF_Administrator.JF_Books.jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
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
                            getSelectedRowCount_JF_Administrator_Books_jTableBooks();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        //
        JF_Administrator.JF_Books.jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                empty_reservedMembers_borrowedMembers();
            }
        });
        JF_Administrator.JF_Books.jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                try {
                    if (JF_Administrator.JF_Books.jCheckBox1.isSelected()) { // auto search
                        getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                    } else {
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        });

        JF_Administrator.JF_Books.jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                getSelectedRowCount_JF_Administrator_Books_jTableBooks();
            }
        });

        JF_Administrator.JF_Books.jSpinner_limitresults.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                empty_reservedMembers_borrowedMembers();
            }
        });
        JF_Administrator.JF_Books.jButton_FirstRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empty_reservedMembers_borrowedMembers();
            }
        });
        JF_Administrator.JF_Books.jButton_PreviousRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empty_reservedMembers_borrowedMembers();
            }
        });
        JF_Administrator.JF_Books.jButton_NextRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empty_reservedMembers_borrowedMembers();
            }
        });
        JF_Administrator.JF_Books.jButton_LastRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empty_reservedMembers_borrowedMembers();
            }
        });

        JF_Administrator.JF_Books.jButtonViewInfo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_books_information();
            }
        });

        //
        JF_Administrator.JF_Books.jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                stateChange_JF_Administrator_Books_jTabbedPane();
            }
        });


        JF_Administrator.JF_Books.jButtonBorrow.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrow_selected_books();
            }
        });

    }

    private void getSelectedRowCount_JF_Administrator_Books_jTableBooks() {
        try {
            getSelectedRowCount_JF_Administrator_BooksReserved_jTableReserved();
            getSelectedRowCount_JF_Administrator_BooksBorrowed_jTableBorrowed();
            //
            int getSelectedRowCount = JF_Administrator.JF_Books.jTableBooks.getSelectedRowCount();
            switch (getSelectedRowCount) {
                case 0:
                    empty_reservedMembers_borrowedMembers();
                    JF_Administrator.JF_Books.jButtonViewInfo.setEnabled(false);
                    JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                    break;
                case 1:
                    int selectedColumn = function_getColumnNumber_jTable("idbooks", JF_Administrator.JF_Books.jTableBooks);
                    int selectedRow = JF_Administrator.JF_Books.jTableBooks.getSelectedRow();
                    int idbooks = JF_Administrator.JF_Books.jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();

                    show_reservedMembers(idbooks);
                    show_borrowedMembers(idbooks);
                    setEnabled_JF_Administrator_Books(idbooks);
                    JF_Administrator.JF_Books.jButtonViewInfo.setEnabled(true);
                    break;
                case 2:
                    empty_reservedMembers_borrowedMembers();
                    JF_Administrator.JF_Books.jButtonViewInfo.setEnabled(false);
                    JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                    break;
                default:
                    empty_reservedMembers_borrowedMembers();
                    JF_Administrator.JF_Books.jButtonViewInfo.setEnabled(false);
                    JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                    break;
            } // END SWITCH

            stateChange_JF_Administrator_Books_jTabbedPane();
            setEnabled_MenuItem();
        } catch (Exception e) {
            System.err.println();
        }
    }

    //
    private void addEvents_JF_Administrator_BooksReserved() {
        JF_BooksReserved.jTableReserved.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableBooksKeyReleased(evt);
            }

            private void jTableBooksKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_JF_Administrator_BooksReserved_jTableReserved();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_JF_Administrator_BooksReserved_jTableReserved();
                        break;
                }
            }
        });
        JF_BooksReserved.jTableReserved.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBooksMouseClicked(evt);
            }

            private void jTableBooksMouseClicked(MouseEvent evt) {
                int buttonChoice = evt.getButton();
                int clickCOunt = evt.getClickCount();
                if (clickCOunt == 2) {
//                    view_books_information();
                }
                switch (buttonChoice) {
                    case 1: // IF MOUSE IS LEFT CLICKED
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_JF_Administrator_BooksReserved_jTableReserved();
                            //jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
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
                        getSelectedRowCount_JF_Administrator_BooksReserved_jTableReserved();
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
        JF_BooksReserved.jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
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
                            getSelectedRowCount_JF_Administrator_BooksReserved_jTableReserved();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        //
        JF_BooksReserved.jSpinner_limitresults.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            }
        });
        JF_BooksReserved.jButton_FirstRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        JF_BooksReserved.jButton_PreviousRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        JF_BooksReserved.jButton_NextRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        JF_BooksReserved.jButton_LastRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });


        JF_Administrator.JF_Books.jButtonCancelReservation.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_reservedBooks();
            }
        });

    }

    private void getSelectedRowCount_JF_Administrator_BooksReserved_jTableReserved() {
        try {
            int getSelectedRowCount = JF_BooksReserved.jTableReserved.getSelectedRowCount();
            switch (getSelectedRowCount) {
                case 0:
                    JF_Administrator.JF_Books.jButtonCancelReservation.setEnabled(false);
                    JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                    int getSelectedRowCount_jTableBooks = JF_Administrator.JF_Books.jTableBooks.getSelectedRowCount();
                    switch (getSelectedRowCount_jTableBooks) {
                        case 0:
                            break;
                        case 1:
                            int selectedColumn = function_getColumnNumber_jTable("idbooks", JF_Administrator.JF_Books.jTableBooks);
                            int selectedRow = JF_Administrator.JF_Books.jTableBooks.getSelectedRow();
                            int idbooks = JF_Administrator.JF_Books.jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();
                            setEnabled_JF_Administrator_Books(idbooks);
                            break;
                        case 2:
                            break;
                        default:
                            break;
                    }
                    break;
                case 1:
                    JF_Administrator.JF_Books.jButtonCancelReservation.setEnabled(true);
                    JF_Administrator.JF_Books.jButtonBorrow.setEnabled(true);
                    break;
                case 2:
                    JF_Administrator.JF_Books.jButtonCancelReservation.setEnabled(true);
                    JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                    break;
                default:
                    JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                    break;
            } // END SWITCH
            setEnabled_MenuItem();
        } catch (Exception e) {
            System.err.println();
        }
    }

    //
    private void addEvents_JF_Administrator_BooksBorrowed() {

        JF_BooksBorrowed.jTableBorrowed.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableBooksKeyReleased(evt);
            }

            private void jTableBooksKeyReleased(KeyEvent evt) {
                int keyCode = evt.getKeyCode();
                switch (keyCode) {
                    case 10: // IF HIT 'ENTER' KEY
                        getSelectedRowCount_JF_Administrator_BooksBorrowed_jTableBorrowed();
                        break;
                    case 32: // IF HIT 'SPACE' KEY
                        break;
                    case 127: // IF HIT 'DELETE' KEY
                        System.out.println("Delete");
                        break;
                    default:
                        getSelectedRowCount_JF_Administrator_BooksBorrowed_jTableBorrowed();
                        break;
                }
            }
        });
        JF_BooksBorrowed.jTableBorrowed.addMouseListener(new java.awt.event.MouseAdapter() {
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
                            return_borrowedBooks();
                        }
                        break;
                    case 2:
                        break;
                    case 3: // IF MOUSE IS RIGHT CLICKED
                        if (!evt.isPopupTrigger()) {
                            getSelectedRowCount_JF_Administrator_BooksBorrowed_jTableBorrowed();
                            //jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
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
                        getSelectedRowCount_JF_Administrator_BooksBorrowed_jTableBorrowed();
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
        JF_BooksBorrowed.jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
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
                            getSelectedRowCount_JF_Administrator_BooksBorrowed_jTableBorrowed();
//                                       jPopupMenu_jTableBooks.show(evt.getComponent(), evt.getX(), evt.getY());
                        }
                        break;
                    default: // IF MOUSE IS !RIGHTCLICK
                        break;
                }
            }
        });
        //
        JF_BooksBorrowed.jSpinner_limitresults.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
            }
        });
        JF_BooksBorrowed.jButton_FirstRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        JF_BooksBorrowed.jButton_PreviousRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        JF_BooksBorrowed.jButton_NextRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        JF_BooksBorrowed.jButton_LastRecord.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });



        JF_Administrator.JF_Books.jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_borrowedBooks();
            }
        });
    }

    private void getSelectedRowCount_JF_Administrator_BooksBorrowed_jTableBorrowed() {
        try {
            int getSelectedRowCount = JF_BooksBorrowed.jTableBorrowed.getSelectedRowCount();
            switch (getSelectedRowCount) {
                case 0:
                    JF_Administrator.JF_Books.jButtonReturn.setEnabled(false);
                    break;
                case 1:
                    JF_Administrator.JF_Books.jButtonReturn.setEnabled(true);
                    break;
                case 2:
                    JF_Administrator.JF_Books.jButtonReturn.setEnabled(false);
                    break;
                default:
                    JF_Administrator.JF_Books.jButtonReturn.setEnabled(false);
                    break;
            } // END SWITCH
            setEnabled_MenuItem();
        } catch (Exception e) {
            System.err.println();
        }
    }

    /* JF_Administrator_Members */
    //
    private void addEvents_JF_Administrator_Members() {
    }

    /* JF_Administrator_Records */
    //
    private void addEvents_JF_Administrator_Records() {
    }

    /* JF_Administrator_Reports */
    //
    private void addEvents_JF_Administrator_Reports() {
    }

// ----------------------------------------------------------------------------- SHOW MEMBERS RESERVATION & BORRORWED
    private void empty_reservedMembers_borrowedMembers() {
        show_reservedMembers(0);
        show_borrowedMembers(0);
        setEnabled_JF_Administrator_Books(0);
    }

    private void show_reservedMembers(int idbooks) {
        try {
            JF_BooksReserved.setIdbooks_reserve(idbooks);
            JF_BooksReserved.initialize_results_fill_jTableMembers();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void show_borrowedMembers(int idbooks) {
        try {
            JF_BooksBorrowed.setIdbooks_borrow(idbooks);
            JF_BooksBorrowed.initialize_results_fill_jTableBorrowed();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- setEnabled
    private void setEnabled_JF_Administrator_Books(int idbooks) {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                boolean isReservedBooks_GreaterThan_or_EqualTo_TheRemainingCopy = ref_books.function_is_total_reserved_greater_than_or_equal_to_the_remaining_copy_of_the_books(idbooks, conn);
                if (isReservedBooks_GreaterThan_or_EqualTo_TheRemainingCopy) {
                    JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                } else {
                    int isBorrowable = ref_books.function_get_isborrowable(idbooks, conn);
                    if (isBorrowable == 1) { // 1 = Loanable
                        JF_Administrator.JF_Books.jButtonBorrow.setEnabled(true);
                    } else { // 0 = not Borrowable/Loanable
                        JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                    }
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
                if (Database._booksreservation.getConnection() != conn) {
                }
            } // END CONNECTION 
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setEnabled_JF_Administrator_BooksReserved() {
        try {
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setEnabled_JF_Administrator_BooksBorrowed() {
        try {
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- SHOW BOOKS INFORMATION
    private void show_books_information() {
        try {
            int selectedColumn = function_getColumnNumber_jTable("idbooks", JF_Administrator.JF_Books.jTableBooks);
            int selectedRow = JF_Administrator.JF_Books.jTableBooks.getSelectedRow();
            int idbooks = JF_Administrator.JF_Books.jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();

            //
//            if (ref_BooksInformation == null || !ref_BooksInformation.isVisible()) {
            if (!ref_BooksInformation.isVisible()) {
//                ref_BooksInformation = new JF_BooksInformation();
                // ref_BooksInformation.add(image1);
                // ref_BooksInformation.setSize(image1.getWidth(),image1.getHeight());
                ref_BooksInformation.setLocationRelativeTo(JF_Administrator);
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

// ----------------------------------------------------------------------------- STATECHANGE jTabbedPane
    private void stateChange_JF_Administrator_Books_jTabbedPane() {
        try {
            if (JF_BooksReserved.jPanel2.isVisible()) {
                getSelectedRowCount_JF_Administrator_BooksReserved_jTableReserved();
            } else {
                JF_Administrator.JF_Books.jButtonCancelReservation.setEnabled(false);
                JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);

                int getSelectedRowCount = JF_Administrator.JF_Books.jTableBooks.getSelectedRowCount();
                switch (getSelectedRowCount) {
                    case 0:
                        break;
                    case 1:
                        int selectedColumn = function_getColumnNumber_jTable("idbooks", JF_Administrator.JF_Books.jTableBooks);
                        int selectedRow = JF_Administrator.JF_Books.jTableBooks.getSelectedRow();
                        int idbooks = JF_Administrator.JF_Books.jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();
                        if (function_isReservedBooks_GreaterThan_or_EqualTo_TheRemainingCopy(idbooks) == true) {
                            JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                        } else {
                            JF_Administrator.JF_Books.jButtonBorrow.setEnabled(true);
                        }
                        break;
                    default:
                        break;

                }
            }

            if (JF_BooksBorrowed.jPanel2.isVisible()) {
                getSelectedRowCount_JF_Administrator_BooksBorrowed_jTableBorrowed();
            } else {
                JF_Administrator.JF_Books.jButtonReturn.setEnabled(false);
            }
            setEnabled_MenuItem();
        } catch (Exception e) {
            System.err.println("stateChange_JF_Administrator_Books_jTabbedPane");
        }
    }

// ----------------------------------------------------------------------------- MENU ITEM setEnabled
    private void setEnabled_MenuItem() {

        if (JF_Administrator.jToggleButton1.isSelected()) {
            jMenuItem3.setEnabled((JF_Administrator.JF_Books.jButtonViewInfo.isEnabled()) ? true : false);
            jMenuItem6.setEnabled((JF_Administrator.JF_Books.jButtonReturn.isEnabled()) ? true : false);
            jMenuItem5.setEnabled((JF_Administrator.JF_Books.jButtonCancelReservation.isEnabled()) ? true : false);
            jMenuItem4.setEnabled((JF_Administrator.JF_Books.jButtonBorrow.isEnabled()) ? true : false);
            jMenuItem19.setEnabled((jMenuItem8.isEnabled()) ? true : false);
            jMenuItem20.setEnabled((jMenuItem3.isEnabled()) ? true : false);
        } else {
            jMenuItem3.setEnabled(false);
            jMenuItem6.setEnabled(false);
            jMenuItem5.setEnabled(false);
            jMenuItem4.setEnabled(false);
            jMenuItem19.setEnabled(false);
            jMenuItem20.setEnabled(false);
        }

        if (JF_Administrator.jToggleButton2.isSelected()) {
            jMenuItem8.setEnabled((JF_Administrator.REF_JF_Administrator_Members.jButtonViewInfo.isEnabled()) ? true : false);
            jMenuItem13.setEnabled((JF_Administrator.REF_JF_Administrator_Members.jButtonCancelReservation.isEnabled()) ? true : false);
            jMenuItem14.setEnabled((JF_Administrator.REF_JF_Administrator_Members.jButtonReturn.isEnabled()) ? true : false);
            jMenuItem15.setEnabled((JF_Administrator.REF_JF_Administrator_Members.jButtonUpdatePenalties.isEnabled()) ? true : false);
            jMenuItem19.setEnabled((jMenuItem8.isEnabled()) ? true : false);
        } else {
            jMenuItem8.setEnabled(false);
            jMenuItem13.setEnabled(false);
            jMenuItem14.setEnabled(false);
            jMenuItem15.setEnabled(false);
            jMenuItem19.setEnabled(false);
        }

        if (JF_Administrator.jToggleButton4.isSelected()) {
            jMenuItem20.setEnabled(false);
            jMenuItem19.setEnabled(false);
        } else {
        }

    }

    private boolean function_isReservedBooks_GreaterThan_or_EqualTo_TheRemainingCopy(int idbooks) {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                boolean isReservedBooks_GreaterThan_or_EqualTo_TheRemainingCopy = ref_books.function_is_total_reserved_greater_than_or_equal_to_the_remaining_copy_of_the_books(idbooks, conn);
                if (isReservedBooks_GreaterThan_or_EqualTo_TheRemainingCopy) {
                    JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
                    return true;
                } else {
//                    int isBorrowable = ref_books.function_get_isborrowable(idbooks, conn);
//                    if (isBorrowable == 1) { // 1 = Loanable
//                        JF_Administrator.JF_Books.jButtonBorrow.setEnabled(true);
//                    } else { // 0 = not Borrowable/Loanable
//                        JF_Administrator.JF_Books.jButtonBorrow.setEnabled(false);
//                    }
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
                if (Database._booksreservation.getConnection() != conn) {
                }
            } // END CONNECTION 
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

// ----------------------------------------------------------------------------- RETURN BORROWED BOOKS
    private void return_borrowedBooks() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                // BOOKS VIEW
                if (JF_Administrator.jToggleButton1.isSelected()) {
                    int getSelectedRowCount = JF_BooksBorrowed.jTableBorrowed.getSelectedRowCount();
                    if (getSelectedRowCount == 1) {
                        int selectedColumn = function_getColumnNumber_jTable("idborrow", JF_BooksBorrowed.jTableBorrowed);
                        int selectedRow = JF_BooksBorrowed.jTableBorrowed.getSelectedRow();
                        int idborrow_ = JF_BooksBorrowed.jTableBorrowed.getValueAt(selectedRow, selectedColumn).hashCode();

                        view_JD_UpdateBorrowedBooks(idborrow_, conn);

                    }
                } else {
                }

                // MEMBERS VIEW
                if (JF_Administrator.jToggleButton2.isSelected()) {
                    int getSelectedRowCount = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.getSelectedRowCount();
                    if (getSelectedRowCount == 1) {
                        int selectedColumn = function_getColumnNumber_jTable("idborrow", JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.jTableMembersBooksBorrowed);
                        int selectedRow = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.getSelectedRow();
                        int idborrow_ = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.jTableMembersBooksBorrowed.getValueAt(selectedRow, selectedColumn).hashCode();

                        view_JD_UpdateBorrowedBooks(idborrow_, conn);
                    }

                } else {
                }




            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
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
                r_idreserve = JF_BooksReserved.jTableReserved.getSelectedRows();
                for (int c = 0; c < JF_BooksReserved.jTableReserved.getColumnCount(); c++) {
                    String columnName = JF_BooksReserved.jTableReserved.getColumnName(c);
                    if ("idreserve".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_idreserve.length; r++) {
                            r_idreserve[r] = JF_BooksReserved.jTableReserved.getValueAt(r_idreserve[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (r_idreserve.length > 0) {
                    ref_reserve.update_reserve_status_to_canceled(r_idreserve, conn);
                    /**/
                    JF_Administrator.JF_Books.fill_jTableBooks(JF_Administrator.JF_Books.getSearchTextField_Keyword(), JF_Administrator.JF_Books.limit_first, JF_Administrator.JF_Books.limit_second, conn);
                    getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- VIEW USERLOG INFORMATION
    public void view_user_log_information() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                ref_JD_AddNewMembers.setLocationRelativeTo(JF_Administrator);
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

    public void add_new_members() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                ref_JD_AddNewMembers.setLocationRelativeTo(JF_Administrator);
                ref_JD_AddNewMembers.setModal(true);
                ref_JD_AddNewMembers.setAlwaysOnTop(true);
                ref_JD_AddNewMembers.setIsneedupdate(false);
                ref_JD_AddNewMembers.setTitle("Add New User");
                ref_JD_AddNewMembers.clearTheForm();
                ref_JD_AddNewMembers.jButton_Add.setVisible(true);
                ref_JD_AddNewMembers.jButton_update.setVisible(false);
                ref_JD_AddNewMembers.student_view_form(true);
                ref_JD_AddNewMembers.setVisible(true);

                if (ref_JD_AddNewMembers.isIsneedupdate()) {
//                    fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
//                    getSelectedRowCount_jTableMembers();
                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- VIEW JD_BorrowBooks
    public void borrow_selected_books() {
        try {
            /**/
            ref_JD_BorrowBooks.setLocationRelativeTo(JF_Administrator);
            ref_JD_BorrowBooks.setModal(true);
            ref_JD_BorrowBooks.setAlwaysOnTop(true);
            ref_JD_BorrowBooks.setIsNeedRefresh(false);
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                ref_JD_BorrowBooks.jTextArea1.setText("");
                ref_JD_BorrowBooks.initialize_results_fill_jTableMembers();
                int row_selected_in_the_reservation = JF_BooksReserved.jTableReserved.getSelectedRowCount();
                if (row_selected_in_the_reservation == 1) {
                    Object[] options = {"  Yes  ", "  No  "};
                    int n3 = JOptionPane.showOptionDialog(
                            this,
                            "Borrow selected reservation?",
                            "Confirmation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                    if (n3 == JOptionPane.YES_OPTION) {
                        int selectedColumn = function_getColumnNumber_jTable("idbooks", JF_BooksReserved.jTableReserved);
                        int selectedRow = JF_BooksReserved.jTableReserved.getSelectedRow();
                        int idreserve_ = JF_BooksReserved.jTableReserved.getValueAt(selectedRow, selectedColumn).hashCode();
                        int idbooks_ = ref_reserve.funtion_get_idbooks_by_idreserve(idreserve_, conn);

                        int selectedColumn_IDNumber = function_getColumnNumber_jTable("ID Number", JF_BooksReserved.jTableReserved);
                        int selectedRow_IDNumber = JF_BooksReserved.jTableReserved.getSelectedRow();
                        String member_idnumber_ = JF_BooksReserved.jTableReserved.getValueAt(selectedRow_IDNumber, selectedColumn_IDNumber).toString();

                        ref_JD_BorrowBooks.setBorrow_idbooks(idbooks_);
                        ref_JD_BorrowBooks.setTitle("Title: " + ref_books.function_get_title(idbooks_, conn));
                        int members_idmembers = new reserve().funtion_get_members_idmembers_by_idreserve(idreserve_, conn);
                        String members_idnumber = new members().function_get_idnumber(members_idmembers, conn);
                        ref_JD_BorrowBooks.setBorrow_idmember(members_idmembers);
                        ref_JD_BorrowBooks.setSearchMember_keyword(members_idnumber);
                        ref_JD_BorrowBooks.jTextField1.setText(members_idnumber);
                        ref_JD_BorrowBooks.validate_BooksImage();

                        ref_JD_BorrowBooks.setSearchMember_keyword(member_idnumber_);
                        ref_JD_BorrowBooks.set_the_idnumber(ref_reserve.funtion_get_idmember_by_idreserve(idreserve_, conn));
                        ref_JD_BorrowBooks.initialize_results_fill_jTableMembers();
                        ref_JD_BorrowBooks.getSelectedRowCount_jTableMembers();
                        ref_JD_BorrowBooks.setVisible(true);
                    } else if (n3 == JOptionPane.NO_OPTION) {


                        setBorrowBook();
                    } else {
//                    setBorrowBook();
                    }
                } else {
                    // show selectect member to borrow


                    setBorrowBook();

                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
            if (ref_JD_BorrowBooks.isIsNeedRefresh()) {
                JF_Administrator.JF_Books.fill_jTableBooks(JF_Administrator.JF_Books.getSearchTextField_Keyword(), JF_Administrator.JF_Books.limit_first, JF_Administrator.JF_Books.limit_second, conn);
                getSelectedRowCount_JF_Administrator_Books_jTableBooks();

//                fill_jTableBooks(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
//                ref_BooksReservedMembers.fill_jTableMembers(ref_BooksReservedMembers.getIdbooks_reserve(), ref_BooksReservedMembers.limit_first, ref_BooksReservedMembers.limit_second, conn);
//                ref_BooksBorrowedMembers.fill_jTableMembers(ref_BooksBorrowedMembers.getIdbooks_borrow(), ref_BooksReservedMembers.limit_first, ref_BooksReservedMembers.limit_second, conn);
//                getSelectedRowCount_jTableBooks();
//                getSelectedRowCount_jTableMembers_ref_BooksBorrowedMembers();
//                getSelectedRowCount_jTableMembers_ref_BooksReservedMembers();
            }
            /**/
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void setBorrowBook() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {

                int selectedColumn = function_getColumnNumber_jTable("idbooks", JF_Administrator.JF_Books.jTableBooks);
                int selectedRow = JF_Administrator.JF_Books.jTableBooks.getSelectedRow();
                int idbooks_ = JF_Administrator.JF_Books.jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();

                ref_JD_BorrowBooks.setBorrow_idbooks(idbooks_);
                ref_JD_BorrowBooks.setTitle("Title: " + ref_books.function_get_title(idbooks_, conn));
                ref_JD_BorrowBooks.setBorrow_idmember(0);
                ref_JD_BorrowBooks.validate_BooksImage();
                ref_JD_BorrowBooks.setSearchMember_keyword("");
                ref_JD_BorrowBooks.jTextField1.setText("");
                ref_JD_BorrowBooks.set_form_disable();
                ref_JD_BorrowBooks.initialize_results_fill_jTableMembers();
                ref_JD_BorrowBooks.getSelectedRowCount_jTableMembers();
                ref_JD_BorrowBooks.setVisible(true);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

// ----------------------------------------------------------------------------- VOEW MEMBERS INFORMATION
    private void view_members_information() {

        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int getSelectedRowCount = JF_Administrator.REF_JF_Administrator_Members.jTableMembers.getSelectedRowCount();
                if (getSelectedRowCount == 1) {
                    int selectedColumn = function_getColumnNumber_jTable("idmembers", JF_Administrator.REF_JF_Administrator_Members.jTableMembers);
                    int selectedRow = JF_Administrator.REF_JF_Administrator_Members.jTableMembers.getSelectedRow();
                    int idmember_ = JF_Administrator.REF_JF_Administrator_Members.jTableMembers.getValueAt(selectedRow, selectedColumn).hashCode();

                    ref_JD_AddNewMembers.setEnabled_viewInformation(idmember_);
                    ref_JD_AddNewMembers.setLocationRelativeTo(JF_Administrator);
                    ref_JD_AddNewMembers.setModal(true);
                    ref_JD_AddNewMembers.setAlwaysOnTop(true);
                    ref_JD_AddNewMembers.setIsneedupdate(false);

                    ref_JD_AddNewMembers.setIdmembers(idmember_);
                    ref_JD_AddNewMembers.setTitle("Update Member");
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
//                              fill_jTableMembers(this.getSearchTextField_Keyword(), limit_first, limit_second, conn);
//                              getSelectedRowCount_jTableMembers();
                    }
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
        }
    }

    private void cancelMembers_booksReservation() {
        try {
            /**/
            Object[] options = {"  Yes  ", "  No  "};
            int n3 = JOptionPane.showOptionDialog(
                    JF_Administrator,
                    "Cancel selected reservation?",
                    "Cancel Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (n3 == JOptionPane.YES_OPTION) {
                cancel_reservation_yes();
            } else if (n3 == JOptionPane.NO_OPTION) {
            } else {
            }
            /**/
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void cancel_reservation_yes() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int r_idreserve[];
                r_idreserve = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.jTableMembersBooksReserved.getSelectedRows();
                for (int c = 0; c < JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.jTableMembersBooksReserved.getColumnCount(); c++) {
                    String columnName = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.jTableMembersBooksReserved.getColumnName(c);
                    if ("idreserve".equals(columnName)) { // GET THE COLUMN NUMBER
                        for (int r = 0; r < r_idreserve.length; r++) {
                            r_idreserve[r] = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.jTableMembersBooksReserved.getValueAt(r_idreserve[r], c).hashCode();
                        }
                        break;
                    }
                }
                if (r_idreserve.length > 0) {
                    ref_reserve.update_reserve_status_to_canceled(r_idreserve, conn);

                    JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.fill_jTableMembers(JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.getIdmembers(), JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.limit_first, JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksReserved.limit_second, conn);
                    getSelectedRowCount_REF_JF_MembersBooksBorrowed();

                }
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void view_JD_UpdateBorrowedBooks(int idborrow_, Connection conn) {
        try {
            JF_Administrator.ref_JD_UpdateBorrowedBooks.setIdborrow(idborrow_);
            JF_Administrator.ref_JD_UpdateBorrowedBooks.refreshForm();
            JF_Administrator.ref_JD_UpdateBorrowedBooks.setModal(true);
            JF_Administrator.ref_JD_UpdateBorrowedBooks.setVisible(true);
            /**/
            if (JF_Administrator.ref_JD_UpdateBorrowedBooks.isUpdated == true) {
                /**/
                // BOOKS VIEW
                if (JF_Administrator.jToggleButton1.isSelected()) {
                    JF_Administrator.JF_Books.fill_jTableBooks(JF_Administrator.JF_Books.getSearchTextField_Keyword(), JF_Administrator.JF_Books.limit_first, JF_Administrator.JF_Books.limit_second, conn);
                    getSelectedRowCount_JF_Administrator_Books_jTableBooks();
                    JF_Administrator.ref_JD_UpdateBorrowedBooks.setIsUpdated(false);
                }

                // MEMBERS VIEW
                if (JF_Administrator.jToggleButton2.isSelected()) {
                    JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.fill_jTableMembers(JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.getIdmembers(), JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.limit_first, JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.limit_second, conn);
                    getSelectedRowCount_REF_JF_MembersBooksBorrowed();
                    JF_Administrator.ref_JD_UpdateBorrowedBooks.setIsUpdated(false);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void update_membersPenalties() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int getSelectedRowCount = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.jTableMembersBooksPenalties.getSelectedRowCount();
                if (getSelectedRowCount == 1) {
                    int selectedColumn = function_getColumnNumber_jTable("idborrow", JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.jTableMembersBooksBorrowed);
                    int selectedRow = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.jTableMembersBooksPenalties.getSelectedRow();
                    int idborrow_ = JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.jTableMembersBooksPenalties.getValueAt(selectedRow, selectedColumn).hashCode();

                    JF_Administrator.ref_JD_UpdateBorrowedBooks.setIdborrow(idborrow_);
                    JF_Administrator.ref_JD_UpdateBorrowedBooks.refreshForm();
                    JF_Administrator.ref_JD_UpdateBorrowedBooks.setModal(true);
                    JF_Administrator.ref_JD_UpdateBorrowedBooks.setVisible(true);

                    /**/
                    if (JF_Administrator.ref_JD_UpdateBorrowedBooks.isUpdated == true) {
                        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.fill_jTableMembers(JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.getIdmembers(), JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.limit_first, JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksBorrowed.limit_second, conn);
                        getSelectedRowCount_REF_JF_MembersBooksBorrowed();
                        JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.fill_jTableMembers(JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.getIdmembers(), JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.limit_first, JF_Administrator.REF_JF_Administrator_Members.ref_MembersBooksPenalties.limit_second, conn);
                        JF_Administrator.REF_JF_Administrator_Members.getSelectedRowCount_jTableMembers_ref_MembersBooksPenalties();
                        JF_Administrator.ref_JD_UpdateBorrowedBooks.setIsUpdated(false);
                    }
                }

            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
        }
    }

// -----------------------------------------------------------------------------  GENERATE REPORTS
    private void generateReports_Multiple() {
        open_JIF_Reports_Single_MultipleInstance(1);
    }

    private void open_JIF_Reports_Single_MultipleInstance(int idbooks) {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                int widht = 400;
                int height = 400;
                String iReport = reportsDirectory + "booksInformation.jasper";
                HashMap parameters = new HashMap();
                parameters.put("idbooks", idbooks);

                ref_JIF_Reports = new JIFrameJasperReportsViewer(iReport, parameters, conn);
                ref_JIF_Reports.setSize(widht, height);
                open_JInternalFrame(ref_JIF_Reports, JF_Administrator.ref_JF_Administrator_Reports.DP1);
                ref_JIF_Reports.setClosable(true);
                ref_JIF_Reports.setFocusCycleRoot(true);
                ref_JIF_Reports.setIconifiable(false);
                ref_JIF_Reports.setLayer(2);
                ref_JIF_Reports.setMaximizable(true);
                ref_JIF_Reports.setMaximum(false);
                ref_JIF_Reports.setResizable(true);
                ref_JIF_Reports.setRequestFocusEnabled(true);
                ref_JIF_Reports.setTitle("Multiple Instance");
                ref_JIF_Reports.setVerifyInputWhenFocusTarget(true);
                ref_JIF_Reports.setVisible(true);
                ref_JIF_Reports.setSelected(true);
//                    int w = 400;
//                    int h = 400;
//                    int x = w / 2;
//                    int y = h / 2;
//                    /* set JInternalFrame to center position */
//                    int newX = JF_Administrator.ref_JF_Administrator_Reports.DP1.getWidth() / 2 - x;
//                    int newY = JF_Administrator.ref_JF_Administrator_Reports.DP1.getHeight() / 2 - y;
//
////                    ref_JIF_Reports.setBounds(newX, newY, w, h);
//                    // OR set Maximum   
//                    ref_JIF_Reports.setSize(w, h);                    
//                    JF_Administrator.ref_JF_Administrator_Reports.DP1.add(ref_JIF_Reports);
//                    ref_JIF_Reports.setLocation(newX, newY);


            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    //

    private void generateReports_Single(int idbooks) {
        report_BooksInformation_JIFrame_Single(idbooks);
    }

    private void report_BooksInformation_JIFrame_Single(int idbooks) {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                String jasperFileDirectory = reportsDirectory + "booksInformation.jasper";
                HashMap parameters = new HashMap();
                parameters.put("idbooks", idbooks);
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

    private void generate_JIF_Single(String JIF_Title, String jasperFileDirectory, HashMap parameters, Connection conn) {
        try {
            ref_JIF_Reports_Single = new JIFrameJasperReportsViewer(jasperFileDirectory, parameters, conn, true);
            ref_JIF_Reports_Single.setBorder(null);
            ref_JIF_Reports_Single.setClosable(true);
            ref_JIF_Reports_Single.setIconifiable(true);
            ref_JIF_Reports_Single.setMaximizable(true);
            ref_JIF_Reports_Single.setResizable(true);
            ref_JIF_Reports_Single.setTitle(JIF_Title);
            ref_JIF_Reports_Single.setLayer(1);
            JF_Administrator.ref_JF_Administrator_Reports.DP1.add(ref_JIF_Reports_Single);

            /* set JInternalFrame to center position */
            int w = 400;
            int h = 400;
            int x = w / 2;
            int y = h / 2;
            int newX = JF_Administrator.ref_JF_Administrator_Reports.DP1.getWidth() / 2 - x;
            int newY = JF_Administrator.ref_JF_Administrator_Reports.DP1.getHeight() / 2 - y;

//            ref_JIF_Reports_Single.setBounds(newX, newY, w, h);
            // OR set Maximum   
            ref_JIF_Reports_Single.setSize(w, h);
            ref_JIF_Reports_Single.setLocation(newX, newY);
            ref_JIF_Reports_Single.setMaximum(true);

            ref_JIF_Reports_Single.setVisible(true);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void generateReports_MembersInformation() {
        try {
            int getSelectedRowCount = JF_Administrator.REF_JF_Administrator_Members.jTableMembers.getSelectedRowCount();
            if (getSelectedRowCount == 1) {
                int selectedColumn = function_getColumnNumber_jTable("idmembers", JF_Administrator.REF_JF_Administrator_Members.jTableMembers);
                int selectedRow = JF_Administrator.REF_JF_Administrator_Members.jTableMembers.getSelectedRow();
                int idmembers = JF_Administrator.REF_JF_Administrator_Members.jTableMembers.getValueAt(selectedRow, selectedColumn).hashCode();

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
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void generateReports_BooksInformation() {
        try {
            int getSelectedRowCount = JF_Administrator.JF_Books.jTableBooks.getSelectedRowCount();
            if (getSelectedRowCount == 1) {
                int selectedColumn = function_getColumnNumber_jTable("idbooks", JF_Administrator.JF_Books.jTableBooks);
                int selectedRow = JF_Administrator.JF_Books.jTableBooks.getSelectedRow();
                int idbooks = JF_Administrator.JF_Books.jTableBooks.getValueAt(selectedRow, selectedColumn).hashCode();


                Connection conn = Database._function_getConnection(Database._booksreservation);
                if (conn != null) {
                    int remaining_copy = new borrow().function_get_the_remaining_copies_of_the_idbooks(idbooks, conn);

                    String jasperFileDirectory;
                    jasperFileDirectory = reportsDirectory + "master_booksInformation.jasper";

                    HashMap parameters = new HashMap();
                    parameters.put("idbooks", idbooks);
                    parameters.put("remainingcopy", remaining_copy);
                    parameters.put("SUBREPORT_DIR", SUBREPORT_DIR);

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
            }




        } catch (Exception e) {
            System.err.println("generateReports_BooksInformation");
        }

    }

    public void view_JD_Reports_MostBorrowedBooks() {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                ref_JD_Reports_MostBorrowedBooks.setLocationRelativeTo(JF_Administrator);
                ref_JD_Reports_MostBorrowedBooks.setModal(true);
                ref_JD_Reports_MostBorrowedBooks.setAlwaysOnTop(true);
                ref_JD_Reports_MostBorrowedBooks.setTitle("Books Records");
//                ref_JD_Reports_MostBorrowedBooks.set_jDialogReports();

//                if ("Administrator".equals(UserLogs.getMembertype())) {
//                    ref_JD_Reports_MostBorrowedBooks.student_view_form(true);
//                } else {
//                    ref_JD_Reports_MostBorrowedBooks.student_view_form(false);
//                }
                ref_JD_Reports_MostBorrowedBooks.setVisible(true);
            } else {
                Database._open_JD_MySQLConnect(Database._booksreservation);
            }
        } catch (Exception e) {
        }
    }

    private void generateReports_MostBorrowedBooks_BarGraph(String title, java.util.Date dateFrom, java.util.Date dateTo) {
        try {
            Connection conn = Database._function_getConnection(Database._booksreservation);
            if (conn != null) {
                String jasperFileDirectory;
                if ("BarGraph".equals(ref_JD_Reports_MostBorrowedBooks.getReportType())) {
                    jasperFileDirectory = reportsDirectory + "booksInformation_BarGraph.jasper";
                } else {
                    jasperFileDirectory = reportsDirectory + "booksInformation_PieChart.jasper";
                }
                HashMap parameters = new HashMap();
                parameters.put("title", title);
                parameters.put("dateFrom", dateFrom);
                parameters.put("dateTo", dateTo);

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
            System.err.println("generateReports_BooksInformation");
        }

    }

    private void generateReports_MostBorrowedBooks_PieChart() {
    }
    /* open JInternalFrame */

    private void open_JIF_Reports_Single_Instance(String JIF_Title, String jasperFileDirectory, HashMap parameters, Connection conn) {
        try {
            int widht = 400;
            int height = 400;
            ref_JIF_Reports_Single = new JIFrameJasperReportsViewer(jasperFileDirectory, parameters, conn, true);
            ref_JIF_Reports_Single.setSize(widht, height);
            open_JInternalFrame(ref_JIF_Reports_Single, JF_Administrator.ref_JF_Administrator_Reports.DP1);
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
}
