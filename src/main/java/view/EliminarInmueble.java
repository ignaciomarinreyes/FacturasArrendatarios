package view;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Inmueble;
import persistence.DataBase;

public class EliminarInmueble extends javax.swing.JFrame {

    private MainFrame mainFrame;

    public EliminarInmueble(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        rellenarInmueblejComboBox(DataBase.selectAllInmuebles());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverjButton = new javax.swing.JButton();
        eliminarjButton = new javax.swing.JButton();
        inmueblejComboBox = new javax.swing.JComboBox<>();

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

        inmueblejComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inmueblejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarjButton)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(inmueblejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverjButton)
                    .addComponent(eliminarjButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void eliminarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarjButtonActionPerformed
        Inmueble inmueble = (Inmueble) inmueblejComboBox.getSelectedItem();
        if (inmueblejComboBox.getSelectedIndex() > 0) {
            DataBase.deleteInmuebleByIdInmueble(inmueble.getIdInmueble());
            rellenarInmueblejComboBox(DataBase.selectAllInmuebles());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún arrendatario");
        }
    }//GEN-LAST:event_eliminarjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarjButton;
    private javax.swing.JComboBox<String> inmueblejComboBox;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables

    private void rellenarInmueblejComboBox(ArrayList<Inmueble> inmuebles) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(new Inmueble(" -- Seleccione un inmueble --"));
        for (Inmueble inmueble : inmuebles) {
            model.addElement(inmueble);
        }
        inmueblejComboBox.setModel(model);
    }
}