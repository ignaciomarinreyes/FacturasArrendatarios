package view;

import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import model.TipoInmueble;
import persistence.DataBase;

public class NuevoInmueble extends javax.swing.JFrame {

    private MainFrame mainFrame;

    public NuevoInmueble(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        rellenarTipoInmueblejComboBox();
        rellenarTipoViajComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreCallejLabel = new javax.swing.JLabel();
        numeroCallejLabel = new javax.swing.JLabel();
        municipiojLabel = new javax.swing.JLabel();
        tipoInmueblejLabel = new javax.swing.JLabel();
        numeroInmueblejLabel = new javax.swing.JLabel();
        nombreCallejTextField = new javax.swing.JTextField();
        numeroCallejTextField = new javax.swing.JTextField();
        localidadjTextField = new javax.swing.JTextField();
        numeroInmueblejTextField = new javax.swing.JTextField();
        tipoInmueblejComboBox = new javax.swing.JComboBox<>();
        volverjButton = new javax.swing.JButton();
        aceptarjButton = new javax.swing.JButton();
        tipoViajComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombreCallejLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        nombreCallejLabel.setText("Nombre");

        numeroCallejLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        numeroCallejLabel.setText("Número");

        municipiojLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        municipiojLabel.setText("Municipio");

        tipoInmueblejLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        tipoInmueblejLabel.setText("Tipo Inmueble");

        numeroInmueblejLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        numeroInmueblejLabel.setText("Número Inmueble");

        nombreCallejTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        numeroCallejTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        localidadjTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        numeroInmueblejTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        tipoInmueblejComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        tipoInmueblejComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoInmueblejComboBoxItemStateChanged(evt);
            }
        });

        volverjButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        volverjButton.setText("Volver");
        volverjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverjButtonActionPerformed(evt);
            }
        });

        aceptarjButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        aceptarjButton.setText("Aceptar");
        aceptarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarjButtonActionPerformed(evt);
            }
        });

        tipoViajComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(municipiojLabel)
                    .addComponent(numeroCallejLabel)
                    .addComponent(nombreCallejLabel)
                    .addComponent(tipoInmueblejLabel)
                    .addComponent(numeroInmueblejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numeroInmueblejTextField)
                    .addComponent(numeroCallejTextField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tipoViajComboBox, 0, 127, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreCallejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(localidadjTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tipoInmueblejComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volverjButton)
                .addGap(18, 18, 18)
                .addComponent(aceptarjButton)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoInmueblejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoInmueblejLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(municipiojLabel)
                    .addComponent(localidadjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreCallejLabel)
                    .addComponent(nombreCallejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoViajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroCallejLabel)
                    .addComponent(numeroCallejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroInmueblejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroInmueblejLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aceptarjButton)
                    .addComponent(volverjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void aceptarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjButtonActionPerformed
        DataBase.insertInmueble(tipoViajComboBox.getSelectedItem().toString() + " " + nombreCallejTextField.getText(), numeroCallejTextField.getText(), localidadjTextField.getText(), numeroInmueblejTextField.getText(), (TipoInmueble) tipoInmueblejComboBox.getSelectedItem());
        limpiarTextFields();
    }//GEN-LAST:event_aceptarjButtonActionPerformed

    private void tipoInmueblejComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoInmueblejComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (tipoInmueblejComboBox.getSelectedIndex() == 2) {
                mostrarAlgunosCampos();
            } else {
                mostrarTodosCampos();
            }
            limpiarTextFields();
        }
    }//GEN-LAST:event_tipoInmueblejComboBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JTextField localidadjTextField;
    private javax.swing.JLabel municipiojLabel;
    private javax.swing.JLabel nombreCallejLabel;
    private javax.swing.JTextField nombreCallejTextField;
    private javax.swing.JLabel numeroCallejLabel;
    private javax.swing.JTextField numeroCallejTextField;
    private javax.swing.JLabel numeroInmueblejLabel;
    private javax.swing.JTextField numeroInmueblejTextField;
    private javax.swing.JComboBox<String> tipoInmueblejComboBox;
    private javax.swing.JLabel tipoInmueblejLabel;
    private javax.swing.JComboBox<String> tipoViajComboBox;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables

    private void rellenarTipoInmueblejComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(TipoInmueble.VIVIENDA);
        model.addElement(TipoInmueble.APARCAMIENTO);
        model.addElement(TipoInmueble.LOCAL);
        tipoInmueblejComboBox.setModel(model);
    }

    private void limpiarTextFields() {
        nombreCallejTextField.setText("");
        numeroCallejTextField.setText("");
        localidadjTextField.setText("");
        numeroInmueblejTextField.setText("");
    }

    private void rellenarTipoViajComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("avd.");
        model.addElement("c.");
        tipoViajComboBox.setModel(model);
    }

    private void mostrarAlgunosCampos() {
        numeroInmueblejTextField.setVisible(false);
        numeroInmueblejLabel.setVisible(false);
        pack();
    }

    private void mostrarTodosCampos() {
        numeroInmueblejTextField.setVisible(true);
        numeroInmueblejLabel.setVisible(true);
        pack();
    }
}