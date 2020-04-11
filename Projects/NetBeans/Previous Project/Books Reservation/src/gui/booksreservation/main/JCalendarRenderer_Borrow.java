package gui.booksreservation.main;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

class JCalendarRenderer_Borrow implements TableCellRenderer {

     //
     protected JComponent renderComponent;
     protected RenderDelegate delegate;
     // JDateChooser javaDateChooser = new JDateChooser(null, null, null, new JSpinnerDateEditor());
     JDateChooser javaDateChooser = new JDateChooser(null, null, null, null);
     /**/
     protected static final Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

     public JCalendarRenderer_Borrow(final JPanel panel) {
          renderComponent = panel;
          delegate = new RenderDelegate() {
               @Override
               public void setValue(Object value) {
                    javaDateChooser.setDateFormatString("MMM d, yyyy");
                    javaDateChooser.setDate((java.util.Date) value);
                    panel.setLayout(new java.awt.BorderLayout());
                    panel.add(javaDateChooser);
               }
          };
     }

     public JCalendarRenderer_Borrow(final JLabel label) {
          renderComponent = label;
          delegate = new RenderDelegate() {
               @Override
               public void setValue(Object value) {
                    if (value != null) {
                         label.setText(new SimpleDateFormat("E, MMM dd, yyyy").format(value));
                    }else{
                         label.setText("");
                    }
                    label.setLayout(new java.awt.BorderLayout());
                    label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    label.setFont(new java.awt.Font("Arial", 0, 12));
                    label.setBackground(new java.awt.Color(153, 0, 0));
                    label.setForeground(new java.awt.Color(255, 255, 255));

               }
          };
     }

     public JCalendarRenderer_Borrow(final JTextArea textArea) {
          renderComponent = textArea;
          delegate = new RenderDelegate() {
               @Override
               public void setValue(Object value) {
                    textArea.setText(new SimpleDateFormat("MMM dd, yyyy").format(value));
                    textArea.setFont(new java.awt.Font("Tahoma", 0, 12));
               }
          };
     }

     @Override
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
          delegate.setValue(value);
          if (hasFocus) {
               renderComponent.setBackground(table.getSelectionBackground());
               renderComponent.setBorder(noFocusBorder);
               renderComponent.setOpaque(true);
          } else if (isSelected) {
               renderComponent.setBackground(table.getSelectionBackground());
               renderComponent.setBorder(noFocusBorder);
               renderComponent.setOpaque(true);
          } else {
               renderComponent.setBorder(noFocusBorder);
               renderComponent.setOpaque(false);
          }
          return renderComponent;
     }

     protected interface RenderDelegate {

          public void setValue(Object value);
     }
}
