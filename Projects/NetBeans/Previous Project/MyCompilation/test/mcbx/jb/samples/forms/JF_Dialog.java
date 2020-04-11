package mcbx.jb.samples.forms;

import java.awt.TrayIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import mcbx.jb.classes.mycollection.FrameIconImage;
import mcbx.jb.classes.mycollection.MyFunctions;

public class JF_Dialog extends javax.swing.JFrame {

     private String icons_joptionpane = "mcbx/jb/icons/joptionpane/";
     private ImageIcon iconJOptionPane = new MyFunctions().createImageIcon(icons_joptionpane + "02_64x64_DOSCST.png");
     /* another option */
     private String icons_jframe = "mcbx/jb/icons/jframe/";
     private FrameIconImage icon1 = new FrameIconImage(icons_jframe + "01_14x14_Disable_Icon.png");

     public JF_Dialog() {
          initComponents();
          /* overide the existing value */
          iconJOptionPane.setImage(icon1.getImg());
     }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("OK (in the L&F's word)");
        jRadioButton6.setActionCommand("1");

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setText("YES/NO (in the L&F's word)");
        jRadioButton7.setActionCommand("2");

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setText("YES/NO (in the programmer's word)");
        jRadioButton8.setActionCommand("3");

        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setText("YES/NO/CANCEL (in the programmer's word)");
        jRadioButton9.setActionCommand("4");

        jButton3.setText("Show it");
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
                    .addComponent(jButton3)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton9))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Simple Modal Dialogs", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Non-auto-closing dialog");
        jRadioButton3.setActionCommand("3");

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Enter some text");
        jRadioButton2.setActionCommand("2");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Pick one of several choices");
        jRadioButton1.setActionCommand("1");

        jButton2.setText("Show it");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jButton2))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("More Dialogs", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup3.add(jRadioButton10);
        jRadioButton10.setText("Plain ");
        jRadioButton10.setActionCommand("1");

        buttonGroup3.add(jRadioButton11);
        jRadioButton11.setText("Information icon");
        jRadioButton11.setActionCommand("2");

        buttonGroup3.add(jRadioButton12);
        jRadioButton12.setText("Question icon");
        jRadioButton12.setActionCommand("3");

        buttonGroup3.add(jRadioButton13);
        jRadioButton13.setText("Error icon");
        jRadioButton13.setActionCommand("4");

        buttonGroup3.add(jRadioButton14);
        jRadioButton14.setText("Warning icon");
        jRadioButton14.setActionCommand("5");

        buttonGroup3.add(jRadioButton15);
        jRadioButton15.setText("Custom icon");
        jRadioButton15.setActionCommand("6");

        jButton1.setText("Show it");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton10)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14)
                    .addComponent(jRadioButton15)
                    .addComponent(jButton1))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dialog Icons", jPanel4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

         try {
              String command = buttonGroup2.getSelection().getActionCommand().toString();
              int cmd = Integer.parseInt(command);
              switch (cmd) {
// ----------------------------------------------------------------------------- PICK ONE COMMAND
                   case 1:
                        Object[] possibilities = {"BSIT", "BSAD", "BSN"};
                        String s = (String) JOptionPane.showInputDialog(
                                this,
                                "Course",
                                "Customized Dialog",
                                JOptionPane.PLAIN_MESSAGE,
                                iconJOptionPane,
                                possibilities,
                                "BSN");
                        if ((s != null) && (s.length() > 0)) {
                             setLabel("You choose: " + s + "!");
                             return;
                        }
                        setLabel("You cancel!");
                        break; // end;

// ----------------------------------------------------------------------------- TEXT ENTERED COMMAND
                   case 2:
                        String s2 = (String) JOptionPane.showInputDialog(
                                this,
                                "Type something: ",
                                "Customized Dialog",
                                JOptionPane.PLAIN_MESSAGE,
                                iconJOptionPane,
                                null,
                                "");
                        if ((s2 != null) && (s2.length() > 0)) {
                             setLabel("You typed: " + s2 + "!");
                             return;
                        }
                        setLabel("Come on, finish the sentence!");
                        break; // end;

// ----------------------------------------------------------------------------- NON-AUTO COMMAND
                   case 3:
                        final JOptionPane optionPane = new JOptionPane(
                                "The only way to close this dialog is by\n"
                                + "pressing one of the following buttons.\n"
                                + "Do you understand?",
                                JOptionPane.QUESTION_MESSAGE,
                                JOptionPane.YES_NO_OPTION);

                        //You can't use pane.createDialog() because that
                        //method sets up the JDialog with a property change
                        //listener that automatically closes the window
                        //when a button is clicked.
                        final JDialog dialog = new JDialog(this, "Click a button", true);
                        dialog.setContentPane(optionPane);
                        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                        dialog.addWindowListener(new WindowAdapter() {
                             public void windowClosing(WindowEvent we) {
                                  setLabel("Thwarted user attempt to close window.");
                             }
                        });

                        optionPane.addPropertyChangeListener(new PropertyChangeListener() {
                             public void propertyChange(PropertyChangeEvent e) {
                                  String prop = e.getPropertyName();
                                  if (dialog.isVisible()
                                          && (e.getSource() == optionPane)
                                          && (JOptionPane.VALUE_PROPERTY.equals(prop))) {
                                       //If you were going to check something
                                       //before closing the window, you'd do
                                       //it here.
                                       dialog.setVisible(false);
                                  }
                             }
                        });
                        dialog.pack();
                        dialog.setLocationRelativeTo(this);
                        dialog.setVisible(true);

                        int value = ((Integer) optionPane.getValue()).intValue();
                        if (value == JOptionPane.YES_OPTION) {
                             setLabel("Good.");
                        } else if (value == JOptionPane.NO_OPTION) {
                             setLabel("You choose no!");
                        } else {
                             setLabel("Window unavoidably closed (ESC?).");
                        }
                        break; // end;
              }
         } catch (Exception e) {
              System.out.println(e);
         }



    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

         try {
              String command = buttonGroup1.getSelection().getActionCommand().toString();
              int cmd = Integer.parseInt(command);
              switch (cmd) {
// ----------------------------------------------------------------------------- DEFAULT
                   case 1:
                        JOptionPane.showMessageDialog(this, "Eggs aren't supposed to be green.");
                        break; // end;

// ----------------------------------------------------------------------------- YES NO                    
                   case 2:
                        int n = JOptionPane.showConfirmDialog(
                                this,
                                "Would you like green eggs and ham?",
                                "An Inane Question",
                                JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                             setLabel("Ewww!");
                        } else if (n == JOptionPane.NO_OPTION) {
                             setLabel("Me neither!");
                        } else {
                             setLabel("Come on -- tell me!");
                        }
                        break; // end;

// ----------------------------------------------------------------------------- CHOICE1 CHOICE2
                   case 3:
                        Object[] options = {"Yes, please", "No way!"};
                        int n3 = JOptionPane.showOptionDialog(
                                this,
                                "Would you like green eggs and ham?",
                                "A Silly Question",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);

                        if (n3 == JOptionPane.YES_OPTION) {
                             setLabel("You're kidding!");
                        } else if (n3 == JOptionPane.NO_OPTION) {
                             setLabel("I don't like them, either.");
                        } else {
                             setLabel("Come on -- 'fess up!");
                        }

                        break; // end;

// ----------------------------------------------------------------------------- YES NO CANCEL
                   case 4:
                        Object[] options4 = {"Yes, please", "No, thanks", "No eggs, no ham!"};
                        int n4 = JOptionPane.showOptionDialog(
                                this,
                                "Would you like some green eggs to go with that ham?",
                                "A Silly Question",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options4,
                                options4[2]);

                        if (n4 == JOptionPane.YES_OPTION) {
                             setLabel("Here you go: green eggs and ham!");
                        } else if (n4 == JOptionPane.NO_OPTION) {
                             setLabel("OK, just the ham, then.");
                        } else if (n4 == JOptionPane.CANCEL_OPTION) {
                             setLabel("Well, I'm certainly not going to eat them!");
                        } else {
                             setLabel("Please tell me what you want!");
                        }
                        break; // end;

              }

         } catch (Exception e) {
              System.out.println(e);
         }





    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         try {
              String command = buttonGroup3.getSelection().getActionCommand().toString();
              int cmd = Integer.parseInt(command);
              switch (cmd) {
                   case 1:
                        JOptionPane.showMessageDialog(this,
                                "Eggs aren't supposed to be green.",
                                "A plain message",
                                JOptionPane.PLAIN_MESSAGE);
// ----------------------------------------------------------------------------- PLAIN
                        break; // end;

// ----------------------------------------------------------------------------- INFO
                   case 2:
                        JOptionPane.showMessageDialog(this,
                                "Eggs aren't supposed to be green.",
                                "Inane informational dialog",
                                JOptionPane.INFORMATION_MESSAGE);
                        break; // end;

// ----------------------------------------------------------------------------- QUESTION
                   case 3:
                        JOptionPane.showMessageDialog(this,
                                "You shouldn't use a message dialog (like this)\n for a question, OK?",
                                "Inane question",
                                JOptionPane.QUESTION_MESSAGE);
                        break; // end;

// ----------------------------------------------------------------------------- ERROR
                   case 4:
                        JOptionPane.showMessageDialog(this,
                                "Eggs aren't supposed to be green.",
                                "Inane error",
                                JOptionPane.ERROR_MESSAGE);
                        break; // end;

// ----------------------------------------------------------------------------- WARNING
                   case 5:
                        JOptionPane.showMessageDialog(this,
                                "Eggs aren't supposed to be green.",
                                "Inane warning",
                                JOptionPane.WARNING_MESSAGE);
                        break; // end;

// ----------------------------------------------------------------------------- CUSTOM
                   case 6:
                        JOptionPane.showMessageDialog(this,
                                "Eggs aren't supposed to be green.",
                                "Inane custom dialog",
                                JOptionPane.INFORMATION_MESSAGE,
                                iconJOptionPane);
                        break;
              }

         } catch (Exception e) {
              System.out.println(e);
         }

    }//GEN-LAST:event_jButton1ActionPerformed

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
               java.util.logging.Logger.getLogger(JF_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(JF_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(JF_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(JF_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                    JF_Dialog instanceThis = new JF_Dialog();
                    instanceThis.setLocationRelativeTo(null);
                    instanceThis.setVisible(true);

               }
          });
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

// ----------------------------------------------------------------------------- SET LABEL
     void setLabel(String newText) {
          jLabel1.setText(newText);
     }
}
