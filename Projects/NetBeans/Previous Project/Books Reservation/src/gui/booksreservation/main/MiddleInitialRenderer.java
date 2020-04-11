package gui.booksreservation.main;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

class MiddleInitialRenderer implements TableCellRenderer {

     protected JComponent renderComponent;
     protected RenderDelegate delegate;
     //
     protected static final Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

     public MiddleInitialRenderer(final JLabel label) {
          renderComponent = label;
          delegate = new RenderDelegate() {
               @Override
               public void setValue(Object value) {
                    String valueString = (String) value;
                    label.setIconTextGap(5);
                    //label.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
                    //label.setLayout(new java.awt.BorderLayout());
                    label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    label.setFont(new java.awt.Font("Arial", 0, 12));
//                    label.setBackground(new java.awt.Color(153, 0, 0));
                    label.setText((value != null) ? value.toString() : "");
                    label.setForeground(new java.awt.Color(255, 255, 255));
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
