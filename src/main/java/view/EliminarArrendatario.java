package view;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Arrendatario;
import persistence.DataBase;

public class EliminarArrendatario extends javax.swing.JFrame {

    private MainFrame mainFrame;

    public EliminarArrendatario(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        rellenarArrendatarioComboBox(DataBase.selectAllArendatarios());
    }

    private void rellenarArrendatarioComboBox(ArrayList<Arrendatario> arrendatarios) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(new Arrendatario(" -- Seleccione un arrendatario --"));
        for (Arrendatario arrendatario : arrendatarios) {
            model.addElement(arrendatario);
        }
        arrendatariosComboBox.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arrendatariosComboBox = new javax.swing.JComboBox<>();
        eliminarButton = new javax.swing.JButton();
        volverjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arrendatariosComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        eliminarButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        volverjButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        volverjButton.setText("Volver");
        volverjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(arrendatariosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volverjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarButton)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(arrendatariosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverjButton)
                    .addComponent(eliminarButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        Arrendatario arrendatario = (Arrendatario) arrendatariosComboBox.getSelectedItem();
        if (arrendatariosComboBox.getSelectedIndex() > 0) {
            DataBase.deleteArrendatarioByDni(arrendatario.getDni());
            rellenarArrendatarioComboBox(DataBase.selectAllArendatarios());
            mainFrame.rellenarArrendatarioComboBox(DataBase.selectAllArendatarios());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún arrendatario");
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> arrendatariosComboBox;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables
}