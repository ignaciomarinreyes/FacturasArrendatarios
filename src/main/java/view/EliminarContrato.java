package view;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Contrato;
import persistence.DataBase;

public class EliminarContrato extends javax.swing.JFrame {

    private MainFrame mainFrame;

    public EliminarContrato(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        rellenarContratoComboBox(DataBase.selectAllContratosJoinArrendatariosJoinInmueble());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverjButton = new javax.swing.JButton();
        eliminarjButton = new javax.swing.JButton();
        contratojComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        volverjButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        volverjButton.setText("Volver");
        volverjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverjButtonActionPerformed(evt);
            }
        });

        eliminarjButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        eliminarjButton.setText("Eliminar");
        eliminarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarjButtonActionPerformed(evt);
            }
        });

        contratojComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarjButton))
                    .addComponent(contratojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(contratojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverjButton)
                    .addComponent(eliminarjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void eliminarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarjButtonActionPerformed
        Contrato contrato = (Contrato) contratojComboBox.getSelectedItem();
        if (contratojComboBox.getSelectedIndex() > 0) {
            DataBase.deleteContratoByIdContrato(contrato.getIdContrato());
            rellenarContratoComboBox(DataBase.selectAllContratosJoinArrendatariosJoinInmueble());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún contrato");
        }
    }//GEN-LAST:event_eliminarjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> contratojComboBox;
    private javax.swing.JButton eliminarjButton;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables

    private void rellenarContratoComboBox(ArrayList<Contrato> contratos) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(new Contrato(" -- Seleccione un contrato --"));
        for (Contrato contrato : contratos) {
            model.addElement(contrato);
        }
        contratojComboBox.setModel(model);
    }
}