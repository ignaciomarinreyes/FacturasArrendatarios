package view;

import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import persistence.DataBase;

public class NuevoArrendatario extends javax.swing.JFrame {

    private MainFrame mainFrame;

    public NuevoArrendatario(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        rellenarTipoPersonajComboBox();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NIFjLabel = new javax.swing.JLabel();
        nombrejLabel = new javax.swing.JLabel();
        apellidosjLabel = new javax.swing.JLabel();
        dniTextField = new javax.swing.JTextField();
        nombreTextField = new javax.swing.JTextField();
        apellidosTextField = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        tipoPersonajComboBox = new javax.swing.JComboBox<>();
        tipojLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NIFjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        NIFjLabel.setText("NIF");

        nombrejLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        nombrejLabel.setText("Nombre");

        apellidosjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        apellidosjLabel.setText("Apellidos");

        dniTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        nombreTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        apellidosTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        aceptarButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        volverButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        tipoPersonajComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        tipoPersonajComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoPersonajComboBoxItemStateChanged(evt);
            }
        });

        tipojLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        tipojLabel.setText("Persona");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(nombrejLabel)
                            .addGap(24, 24, 24))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(apellidosjLabel)
                            .addGap(15, 15, 15)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NIFjLabel)
                            .addComponent(tipojLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dniTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(volverButton)
                            .addGap(18, 18, 18)
                            .addComponent(aceptarButton))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(apellidosTextField)
                            .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tipoPersonajComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoPersonajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipojLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIFjLabel)
                    .addComponent(dniTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrejLabel)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidosjLabel)
                    .addComponent(apellidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarButton)
                    .addComponent(volverButton))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        DataBase.insertArrendatario((String) tipoPersonajComboBox.getSelectedItem(), dniTextField.getText(), nombreTextField.getText(), apellidosTextField.getText());
        mainFrame.rellenarArrendatarioComboBox(DataBase.selectAllArendatarios());
        limpiarTextFields();
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        dispose();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_volverButtonActionPerformed

    private void tipoPersonajComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoPersonajComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (tipoPersonajComboBox.getSelectedIndex() == 0) {
                mostrarVentanaPersonaFisica();
            } else {
                mostrarVentanaPersonaJurídica();
            }
            limpiarTextFields();
        }
    }//GEN-LAST:event_tipoPersonajComboBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NIFjLabel;
    private javax.swing.JButton aceptarButton;
    private javax.swing.JTextField apellidosTextField;
    private javax.swing.JLabel apellidosjLabel;
    private javax.swing.JTextField dniTextField;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JLabel nombrejLabel;
    private javax.swing.JComboBox<String> tipoPersonajComboBox;
    private javax.swing.JLabel tipojLabel;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables

    private void limpiarTextFields() {
        dniTextField.setText("");
        nombreTextField.setText("");
        apellidosTextField.setText("");
    }

    private void rellenarTipoPersonajComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Física");
        model.addElement("Jurídica");
        tipoPersonajComboBox.setModel(model);
    }

    private void mostrarVentanaPersonaFisica() {
        apellidosjLabel.setVisible(true);
        apellidosTextField.setVisible(true);
        pack();
    }

    private void mostrarVentanaPersonaJurídica() {
        apellidosjLabel.setVisible(false);
        apellidosTextField.setVisible(false);
        pack();
    }
}