package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import model.NotificationContract;
import persistence.DataBase;

public class Notification extends javax.swing.JFrame {

    public Notification() {
        initComponents();
        configurarJTable();
        setVisible(true);
        Dimension dimensionScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimensionScreen.getWidth() - this.getWidth()) / 2);
        this.setLocation(x, 844);
        loadNotificationContract();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        notificationContractjTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        notificationContractjTable.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        notificationContractjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Arrendatario", "Inmueble", "Fecha Vencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(notificationContractjTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1453, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable notificationContractjTable;
    // End of variables declaration//GEN-END:variables

    private void loadNotificationContract() {
        DefaultTableModel model = (DefaultTableModel) notificationContractjTable.getModel();
        model.setRowCount(0);
        ArrayList<NotificationContract> notificationContracts = DataBase.selectAllNotificationExpirationContractsOrderByFechaExpiracion();
        for (NotificationContract notificationContract : notificationContracts) {
            model.addRow(new Object[]{notificationContract.getLessee(), notificationContract.getProperty(), notificationContract.getExpirationDate()});
        }
    }

    private void configurarJTable() {
        JTableHeader th = notificationContractjTable.getTableHeader();
        Font fuente = new Font("Arial", Font.PLAIN, 20);
        th.setFont(fuente);
        notificationContractjTable.setRowHeight(25);
        notificationContractjTable.setDefaultRenderer(Object.class, new MyTableCellRenderer());
    }

    private class MyTableCellRenderer extends JLabel implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (((LocalDate) table.getModel().getValueAt(row, 2)).isBefore(LocalDate.now())) {
                setForeground(Color.RED);
            } else {
                setForeground(Color.BLACK);
            }
            setText(String.valueOf(value));
            return this;
        }
    }
}
