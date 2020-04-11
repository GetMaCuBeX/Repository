package mcbx.jb.samples.forms;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.MenuShortcut;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import mcbx.jb.classes.mycollection.DesktopPane;
import mcbx.jb.classes.mycollection.FloatingPaletteHandler;

public class JF_Main extends javax.swing.JFrame {

    private static String images_jdesktoppane = "mcbx/jb/images/jdesktoppane/";
    private static String icons_TrayIcon = "mcbx/jb/icons/TrayIcon/";
    private DesktopPane image1 = new DesktopPane(images_jdesktoppane + "Fish.jpg");
    /* NOTE: OTHER FORM CAN CONTROL THIS JInternalFrame BY (public static) KEYWORD */
    public static JInternalFrame iJIF_OpenForms1, iJIF_OpenForms2, iJIF_OpenForms3, iJIF_OpenForms4;
    private JFrame ref_JF_OpenForms1;
    private JFrame ref_JF_Calendar;
    private JFrame ref_JF_Dialog;
    private JFrame ref_JF_MySQLConnect;
    private JFrame ref_JF_SetImageIcon;
    private JD_OpenForms1 ref_JD_OpenForms1 = new JD_OpenForms1(new javax.swing.JFrame(), true);
    private JDialog smallHPalette;
    int count = 0;
    /* TRAY ICON */
    //final TrayIcon TrayIcon_MyTrayIcon = new TrayIcon(new ImageIcon(icons_TrayIcon + "bulb.gif", "tray icon").getImage());
    static final TrayIcon TrayIcon_MyTrayIcon = new TrayIcon(new ImageIcon(JF_Main.class.getResource("TrayIcon.gif"), "tray icon").getImage());
    final SystemTray tray = SystemTray.getSystemTray();
    
    public JF_Main() {
        initComponents();
        jPanel2.add(image1, java.awt.BorderLayout.CENTER);

        /* TRAY ICON */        
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
        } else {
            try {
                tray.add(TrayIcon_MyTrayIcon);
            } catch (AWTException e) {
                System.out.println("TrayIcon could not be added.");
            }
            TrayIcon_MyTrayIcon.setPopupMenu(popupMenu1_Tray);
            TrayIcon_MyTrayIcon.setImageAutoSize(((checkboxMenuItem1.getState())?true:false));
            TrayIcon_MyTrayIcon.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    TrayIcon_MyTrayIconMouseClicked(evt);
                }

                private void TrayIcon_MyTrayIconMouseClicked(MouseEvent evt) {
                    int getButton = evt.getButton();
                    switch (getButton) {
                        case 1: // LEFT CLICK
                            JOptionPane.showMessageDialog(null, "This dialog box is run from System Tray");
                            break;
                        case 2: // MIDDLE CLICK
                            break;
                        case 3: // RIGHT CLICK
                            break;
                        default:
                            break;

                    }
                }
            });
        }


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        popupMenu1_Tray = new java.awt.PopupMenu();
        menuItem1 = new java.awt.MenuItem();
        checkboxMenuItem1 = new java.awt.CheckboxMenuItem();
        checkboxMenuItem2 = new java.awt.CheckboxMenuItem();
        menu1 = new java.awt.Menu();
        menuItem3 = new java.awt.MenuItem();
        menuItem4 = new java.awt.MenuItem();
        menuItem5 = new java.awt.MenuItem();
        menuItem7 = new java.awt.MenuItem();
        menuItem6 = new java.awt.MenuItem();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuItem11.setText("jMenuItem11");
        jPopupMenu1.add(jMenuItem11);

        jMenuItem12.setText("jMenuItem12");
        jPopupMenu1.add(jMenuItem12);

        jMenuItem13.setText("jMenuItem13");
        jPopupMenu1.add(jMenuItem13);

        popupMenu1_Tray.setLabel("popupMenu1");

        menuItem1.setLabel("About");
        menuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem1ActionPerformed(evt);
            }
        });
        popupMenu1_Tray.add(menuItem1);

        checkboxMenuItem1.setLabel("Set auto size");
        checkboxMenuItem1.setState(true);
        checkboxMenuItem1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkboxMenuItem1ItemStateChanged(evt);
            }
        });
        popupMenu1_Tray.add(checkboxMenuItem1);

        checkboxMenuItem2.setLabel("Set tooltip");
        checkboxMenuItem2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkboxMenuItem2ItemStateChanged(evt);
            }
        });
        popupMenu1_Tray.add(checkboxMenuItem2);

        menu1.setLabel("Display");

        menuItem3.setLabel("None");
        menuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem3ActionPerformed(evt);
            }
        });
        menu1.add(menuItem3);

        menuItem4.setLabel("Info");
        menuItem4.setName("");
        menuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem4ActionPerformed(evt);
            }
        });
        menu1.add(menuItem4);

        menuItem5.setLabel("Warning");
        menuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem5ActionPerformed(evt);
            }
        });
        menu1.add(menuItem5);

        menuItem7.setLabel("Error");
        menuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem7ActionPerformed(evt);
            }
        });
        menu1.add(menuItem7);

        popupMenu1_Tray.add(menu1);

        menuItem6.setLabel("Exit");
        menuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem6ActionPerformed(evt);
            }
        });
        popupMenu1_Tray.add(menuItem6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WINDOW FORMS");
        setMinimumSize(new java.awt.Dimension(993, 679));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Forms");
        jMenu3.setToolTipText("Sample for opening different Swing GUI Forms");

        jMenu4.setText("OpenForms");

        jMenu5.setText("JDialog");

        jMenuItem1.setText("JD_OpenForms1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenu4.add(jMenu5);

        jMenu6.setText("JFrame");

        jMenuItem2.setText("JF_OpenForms1");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);
        jMenu6.add(jSeparator1);

        jMenuItem14.setText("JF_Calendar");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuItem15.setText("JF_Dialog");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuItem16.setText("JF_MySQLConnect");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem16);

        jMenuItem17.setText("JF_SetImageIcon");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenu4.add(jMenu6);

        jMenu7.setText("JInternalFrame");

        jMenuItem3.setText("JIF_OpenForms1");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem3);

        jMenuItem4.setText("JIF_OpenForms2");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);

        jMenuItem5.setText("JIF_OpenForms3");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

        jMenuItem6.setText("JIF_OpenForms4");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem6);

        jMenu4.add(jMenu7);

        jMenu8.setText("JPanel");

        jMenuItem7.setText("JP_OpenForms1");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem7);

        jMenu4.add(jMenu8);

        jMenu9.setText("Pallete");

        jMenuItem8.setText("Pallete1");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem8);

        jMenu4.add(jMenu9);

        jMenu3.add(jMenu4);

        jMenuBar1.add(jMenu3);

        jMenu10.setText("Open");

        jMenu11.setText("Windows");

        jMenu12.setText("Calculator");

        jMenuItem9.setText("Calculator 1");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem9);

        jMenuItem10.setText("Calculator 2");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem10);

        jMenu11.add(jMenu12);

        jMenu10.add(jMenu11);

        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            ref_JD_OpenForms1.setLocationRelativeTo(null);
            ref_JD_OpenForms1.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed
//
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            if (ref_JF_OpenForms1 == null || !ref_JF_OpenForms1.isVisible()) {
                ref_JF_OpenForms1 = new JF_OpenForms1();
                // ref_JF_OpenForms1.add(image1);
                // ref_JF_OpenForms1.setSize(image1.getWidth(),image1.getHeight());
                ref_JF_OpenForms1.setLocationRelativeTo(image1);
                ref_JF_OpenForms1.setLocationRelativeTo(null);
                // ref_JF_OpenForms1.setAlwaysOnTop(true);
                ref_JF_OpenForms1.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        try {
            if (iJIF_OpenForms1 == null || iJIF_OpenForms1.isClosed()) {
                iJIF_OpenForms1 = new JIF_OpenForms1();
                image1.add(iJIF_OpenForms1);
                iJIF_OpenForms1.setSelected(true);
                int a = iJIF_OpenForms1.getWidth() / 2;
                int b = iJIF_OpenForms1.getHeight() / 2;
                iJIF_OpenForms1.setLocation(image1.getWidth() / 2 - a, image1.getHeight() / 2 - b);
                iJIF_OpenForms1.setLayer(2);
//                iJIF_OpenForms1.setMaximum(true);
                iJIF_OpenForms1.setVisible(true);
            } else {
                iJIF_OpenForms1.setSelected(true);
                iJIF_OpenForms1.setVisible(true);
                if (iJIF_OpenForms1.isIcon()) {
                    iJIF_OpenForms1.setIcon(false);
                }
            }
        } catch (Exception e) {
            System.out.println("NULL " + e);
        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            if (iJIF_OpenForms2 == null || iJIF_OpenForms2.isClosed()) {
                iJIF_OpenForms2 = new JIF_OpenForms2();
                image1.add(iJIF_OpenForms2);
                iJIF_OpenForms2.setSelected(true);
                int a = iJIF_OpenForms2.getWidth() / 2;
                int b = iJIF_OpenForms2.getHeight() / 2;
                iJIF_OpenForms2.setLocation(image1.getWidth() / 2 - a, image1.getHeight() / 2 - b);
//                iJIF_OpenForms2.setLocation(0, 0);
//                iJIF_OpenForms2.setSize(300, jPanel2.getHeight());
//                iJIF_OpenForms2.setMaximum(true);
                iJIF_OpenForms2.setLayer(1);
                iJIF_OpenForms2.setVisible(true);
            } else {

                iJIF_OpenForms2.setSelected(true);
                iJIF_OpenForms2.setVisible(true);
                if (iJIF_OpenForms2.isIcon()) {
                    iJIF_OpenForms2.setIcon(false);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            if (iJIF_OpenForms3 == null || iJIF_OpenForms3.isClosed()) {
                iJIF_OpenForms3 = new JIF_OpenForms3();
                image1.add(iJIF_OpenForms3);
                iJIF_OpenForms3.setSelected(true);
                int a = iJIF_OpenForms3.getWidth() / 2;
                int b = iJIF_OpenForms3.getHeight() / 2;
                iJIF_OpenForms3.setLocation(image1.getWidth() / 2 - a, image1.getHeight() / 2 - b);
                iJIF_OpenForms3.setLayer(1);
//                iJIF_OpenForms3.setMaximum(true);
                iJIF_OpenForms3.setVisible(true);
            } else {

                iJIF_OpenForms3.setSelected(true);
                iJIF_OpenForms3.setVisible(true);
                if (iJIF_OpenForms3.isIcon()) {
                    iJIF_OpenForms3.setIcon(false);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            if (iJIF_OpenForms4 == null || iJIF_OpenForms4.isClosed()) {
                iJIF_OpenForms4 = new JIF_OpenForms4();
                image1.add(iJIF_OpenForms4);
                iJIF_OpenForms4.setSelected(true);
                int a = iJIF_OpenForms4.getWidth() / 2;
                int b = iJIF_OpenForms4.getHeight() / 2;
                iJIF_OpenForms4.setLocation(image1.getWidth() / 2 - a, image1.getHeight() / 2 - b);
                iJIF_OpenForms4.setLayer(1);
//                iJIF_OpenForms4.setMaximum(true);
                iJIF_OpenForms4.setVisible(true);
            } else {
                iJIF_OpenForms4.setSelected(true);
                iJIF_OpenForms4.setVisible(true);
                if (iJIF_OpenForms4.isIcon()) {
                    iJIF_OpenForms4.setIcon(false);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed
//     private JP_OpenForms1 ref_JP_OpenForms1 = new JP_OpenForms1("mcbx/jb/images/jpanel/02_300x300_DOSCST.png");
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        JP_OpenForms1 ref_JP_OpenForms1 = new JP_OpenForms1("mcbx/jb/images/jpanel/02_300x300_DOSCST.png");
        image1.remove(ref_JP_OpenForms1);
        ref_JP_OpenForms1.setSize(100, 100);
        int a = ref_JP_OpenForms1.getWidth() / 2;
        int b = ref_JP_OpenForms1.getHeight() / 2;
        ref_JP_OpenForms1.setLocation(image1.getWidth() / 2 - a, image1.getHeight() / 2 - b);
        image1.add(ref_JP_OpenForms1);
        ref_JP_OpenForms1.setVisible(true);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        if (smallHPalette == null) {
            JDialog d = new JDialog((Frame) SwingUtilities.getWindowAncestor(this));
            if (UIManager.getLookAndFeel().getSupportsWindowDecorations()) {
                d.setUndecorated(true);
            }

            d.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
            d.getRootPane().setFont(UIManager.getFont("SmallSystemFont"));
            d.getRootPane().putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
            d.getRootPane().putClientProperty("Quaqua.RootPane.isPalette", Boolean.FALSE);
//                d.getRootPane().putClientProperty("Window.style", "small");
            d.setAlwaysOnTop(true);
            FloatingPaletteHandler.getInstance().addPalette(d);
            d.add(jPanel3, java.awt.BorderLayout.CENTER);
            d.setSize(jPanel3.getPreferredSize());
            d.setLocationRelativeTo(null);
            d.setTitle("Small Horizontal Palette");
            smallHPalette = d;

        }
        smallHPalette.setVisible(true);


    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        try {
            Runtime.getRuntime().exec("calc");
        } catch (Exception e) {
            System.out.println("error===" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Runtime run = Runtime.getRuntime();
        Process p = null;
        try {
            String s = "calc.exe";
            p = run.exec(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

     private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
         try {
             if (ref_JF_Calendar == null || !ref_JF_Calendar.isVisible()) {
                 ref_JF_Calendar = new JF_Calendar();
                 // ref_JF_Calendar.add(image1);
                 // ref_JF_Calendar.setSize(image1.getWidth(),image1.getHeight());
                 ref_JF_Calendar.setLocationRelativeTo(image1);
                 ref_JF_Calendar.setLocationRelativeTo(null);
                 // ref_JF_Calendar.setAlwaysOnTop(true);
                 ref_JF_Calendar.setVisible(true);
             }
         } catch (Exception e) {
             System.out.println(e);
         }
     }//GEN-LAST:event_jMenuItem14ActionPerformed

     private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
         try {
             if (ref_JF_Dialog == null || !ref_JF_Dialog.isVisible()) {
                 ref_JF_Dialog = new JF_Dialog();
                 // ref_JF_Dialog.add(image1);
                 // ref_JF_Dialog.setSize(image1.getWidth(),image1.getHeight());
                 ref_JF_Dialog.setLocationRelativeTo(image1);
                 ref_JF_Dialog.setLocationRelativeTo(null);
                 // ref_JF_Dialog.setAlwaysOnTop(true);
                 ref_JF_Dialog.setVisible(true);
             }
         } catch (Exception e) {
             System.out.println(e);
         }
     }//GEN-LAST:event_jMenuItem15ActionPerformed

     private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
         try {
             if (ref_JF_MySQLConnect == null || !ref_JF_MySQLConnect.isVisible()) {
                 ref_JF_MySQLConnect = new JF_MySQLConnect();
                 // ref_JF_MySQLConnect.add(image1);
                 // ref_JF_MySQLConnect.setSize(image1.getWidth(),image1.getHeight());
                 ref_JF_MySQLConnect.setLocationRelativeTo(image1);
                 ref_JF_MySQLConnect.setLocationRelativeTo(null);
                 // ref_JF_MySQLConnect.setAlwaysOnTop(true);
                 ref_JF_MySQLConnect.setVisible(true);
             }
         } catch (Exception e) {
             System.out.println(e);
         }
     }//GEN-LAST:event_jMenuItem16ActionPerformed

     private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
         try {
             if (ref_JF_SetImageIcon == null || !ref_JF_SetImageIcon.isVisible()) {
                 ref_JF_SetImageIcon = new JF_SetImageIcon();
                 // ref_JF_SetImageIcon.add(image1);
                 // ref_JF_SetImageIcon.setSize(image1.getWidth(),image1.getHeight());
                 ref_JF_SetImageIcon.setLocationRelativeTo(image1);
                 ref_JF_SetImageIcon.setLocationRelativeTo(null);
                 // ref_JF_SetImageIcon.setAlwaysOnTop(true);
                 ref_JF_SetImageIcon.setVisible(true);
             }
         } catch (Exception e) {
             System.out.println(e);
         }
     }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void menuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem1ActionPerformed
        JOptionPane.showMessageDialog(null,
                "This dialog box is run from the About menu item");
    }//GEN-LAST:event_menuItem1ActionPerformed

    private void checkboxMenuItem1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkboxMenuItem1ItemStateChanged
        int cb1Id = evt.getStateChange();
        if (cb1Id == ItemEvent.SELECTED) {
            TrayIcon_MyTrayIcon.setImageAutoSize(true);
        } else {
            TrayIcon_MyTrayIcon.setImageAutoSize(false);
        }
    }//GEN-LAST:event_checkboxMenuItem1ItemStateChanged

    private void checkboxMenuItem2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkboxMenuItem2ItemStateChanged
        int cb2Id = evt.getStateChange();
        if (cb2Id == ItemEvent.SELECTED) {
            TrayIcon_MyTrayIcon.setToolTip("Sun TrayIcon");
        } else {
            TrayIcon_MyTrayIcon.setToolTip(null);
        }
    }//GEN-LAST:event_checkboxMenuItem2ItemStateChanged

    private void menuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem3ActionPerformed
        TrayIcon_MyTrayIcon.displayMessage("Sun TrayIcon Demo",
                "This is an ordinary message", TrayIcon.MessageType.NONE);
    }//GEN-LAST:event_menuItem3ActionPerformed

    private void menuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem4ActionPerformed
        TrayIcon_MyTrayIcon.displayMessage("Sun TrayIcon Demo",
                "This is an info message", TrayIcon.MessageType.INFO);
    }//GEN-LAST:event_menuItem4ActionPerformed

    private void menuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem5ActionPerformed
        TrayIcon_MyTrayIcon.displayMessage("Sun TrayIcon Demo",
                "This is a warning message", TrayIcon.MessageType.WARNING);
    }//GEN-LAST:event_menuItem5ActionPerformed

    private void menuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem7ActionPerformed
        TrayIcon_MyTrayIcon.displayMessage("Sun TrayIcon Demo",
                "This is an error message", TrayIcon.MessageType.ERROR);
    }//GEN-LAST:event_menuItem7ActionPerformed

    private void menuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem6ActionPerformed
        tray.remove(TrayIcon_MyTrayIcon);
        System.exit(0);
    }//GEN-LAST:event_menuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JF_Main instanceJF_Main = new JF_Main();
                instanceJF_Main.setLocationRelativeTo(null);
                instanceJF_Main.setVisible(true);

            }
        });

// ----------------------------------------------------------------------------- QuaQua LOOK&FEEL  
//        SwingUtilities.invokeLater(
//                new Runnable() {
//                    public void run() {
//                        try {
//                            UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
//                        } catch (Exception e) {
//                            System.out.println(e);
//                        }
//                        JF_Main M = new JF_Main();
//                        M.setVisible(true);
//                        M.setLocationRelativeTo(null);
//                        M.setSize(M.getPreferredSize());
//                        M.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
//                        M.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
//                        JFrame.setDefaultLookAndFeelDecorated(true);
//                        JDialog.setDefaultLookAndFeelDecorated(true);
//                    }
//                });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.CheckboxMenuItem checkboxMenuItem1;
    private java.awt.CheckboxMenuItem checkboxMenuItem2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
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
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private java.awt.Menu menu1;
    private java.awt.MenuItem menuItem1;
    private java.awt.MenuItem menuItem3;
    private java.awt.MenuItem menuItem4;
    private java.awt.MenuItem menuItem5;
    private java.awt.MenuItem menuItem6;
    private java.awt.MenuItem menuItem7;
    private java.awt.PopupMenu popupMenu1_Tray;
    // End of variables declaration//GEN-END:variables
    JComponent component = null;

    public JComponent getComponent(String classComponents) {
        if (component == null) {
            try {
                component = (JComponent) Class.forName(classComponents).newInstance();
            } catch (Throwable ex) {
                component = new JLabel(ex.toString());
                //showErrorThrowable();
            }
        }
        return component;
    }

// ----------------------------------------------------------------------------- OPEN DIALOG
    private void openDialog() {
        try {
            JD_OpenForms1 JD1 = new JD_OpenForms1(new javax.swing.JFrame(), true);
            JD1.setLocationRelativeTo(null);
            JD1.setVisible(true);
        } catch (Exception e) {
        }
    }

// ----------------------------------------------------------------------------- OPEN JFRAME    
    private void openJFrame() {
        try {
            if (ref_JF_OpenForms1 == null || !ref_JF_OpenForms1.isVisible()) {
                ref_JF_OpenForms1 = new JF_OpenForms1();
                // ref_JF_OpenForms1.add(image1);
                // ref_JF_OpenForms1.setSize(image1.getWidth(),image1.getHeight());
                ref_JF_OpenForms1.setLocationRelativeTo(image1);
                ref_JF_OpenForms1.setLocationRelativeTo(null);
                // ref_JF_OpenForms1.setAlwaysOnTop(true);
                ref_JF_OpenForms1.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

// ----------------------------------------------------------------------------- OPEN JINTERNAL FRAME    
    private void openJInternalFrame() {

        try {
            if (iJIF_OpenForms1 == null || iJIF_OpenForms1.isClosed()) {
                iJIF_OpenForms1 = new JIF_OpenForms1();
                image1.add(iJIF_OpenForms1);
                iJIF_OpenForms1.setSelected(true);
                int a = iJIF_OpenForms1.getWidth() / 2;
                int b = iJIF_OpenForms1.getHeight() / 2;
                iJIF_OpenForms1.setLocation(image1.getWidth() / 2 - a, image1.getHeight() / 2 - b);
                iJIF_OpenForms1.setLayer(2);
//                iJIF_OpenForms1.setMaximum(true);
                iJIF_OpenForms1.setVisible(true);
            } else {
                iJIF_OpenForms1.setVisible(true);
                if (iJIF_OpenForms1.isIcon()) {
                    iJIF_OpenForms1.setIcon(false);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

// ----------------------------------------------------------------------------- OPEN JPANEL    
    private void openJPanel() {
//          if (ref_JP_OpenForms1.isShowing() == false || ref_JP_OpenForms1.isVisible() == false) {
//               image1.remove(ref_JP_OpenForms1);
//               ref_JP_OpenForms1.setSize(ref_JP_OpenForms1.getPreferredSize());
//               int a = ref_JP_OpenForms1.getWidth() / 2;
//               int b = ref_JP_OpenForms1.getHeight() / 2;
//               ref_JP_OpenForms1.setLocation(image1.getWidth() / 2 - a, image1.getHeight() / 2 - b);
//               image1.add(ref_JP_OpenForms1);
//               ref_JP_OpenForms1.setVisible(true);
//          } else {
//               //image1.repaint();
//               System.out.println("Repaint " + count++);
//          }
    }

// ----------------------------------------------------------------------------- OPEN PALLETE
    private void openPallete() {
        if (smallHPalette == null) {
            JDialog d = new JDialog((Frame) SwingUtilities.getWindowAncestor(this));
            if (UIManager.getLookAndFeel().getSupportsWindowDecorations()) {
                d.setUndecorated(true);
            }
            d.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
            d.getRootPane().setFont(UIManager.getFont("SmallSystemFont"));
            d.getRootPane().putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
            d.getRootPane().putClientProperty("Quaqua.RootPane.isPalette", Boolean.FALSE);
//                d.getRootPane().putClientProperty("Window.style", "small");
            d.setAlwaysOnTop(true);
            FloatingPaletteHandler.getInstance().addPalette(d);
            d.add(jPanel3, java.awt.BorderLayout.CENTER);
            d.setSize(jPanel3.getPreferredSize());
            d.setLocationRelativeTo(null);
            d.setTitle("Small Horizontal Palette");
            smallHPalette = d;
        }
        smallHPalette.setVisible(true);

    }

// ----------------------------------------------------------------------------- OPEN OTHER APPLICATION (WINDOW'S CALCULATOR)
    private void openCalculator() {
        /* OTHER WAY
         try {
         Runtime.getRuntime().exec("calc");
         } catch (Exception e) {
         System.out.println("error===" + e.getMessage());
         e.printStackTrace();
         }
         */
        /* OTHER WAY
         Runtime run = Runtime.getRuntime();
         Process p = null;
         try {
         String s = "calc.exe";
         p = run.exec(s);
         } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
         }
         */
    }

// ----------------------------------------------------------------------------- OPEN .JAR APPLICATION
    private void openJarApplication() {
        /* OTHER WAY
         String filePath = "C:\\dist\\SpecialStudy.jar";
         //    String filePath = System.getProperty("user.dir")+"\\dist\\SpecialStudy.jar";
         System.out.println(filePath);
         try {
         Runtime.getRuntime().exec(" java -jar " + filePath);
         } catch (Exception e) {
         System.out.println("error===" + e.getMessage());
         e.printStackTrace();
         }
         */
    }
}
