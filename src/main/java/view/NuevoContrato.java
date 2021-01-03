package view;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import model.Arrendatario;
import model.Inmueble;
import persistence.DataBase;

public class NuevoContrato extends javax.swing.JFrame {

    private MainFrame mainFrame;

    public NuevoContrato(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        configurarNumeroMesesSpinner();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        rellenarArrendatarioComboBox(DataBase.selectAllArendatarios());
        rellenarInmueblesComboBox(DataBase.selectInmuebleByIdInmuebleNotInContrato());
    }

    private void rellenarArrendatarioComboBox(ArrayList<Arrendatario> arrendatarios) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(new Arrendatario(" -- Seleccione un arrendatario --"));
        for (Arrendatario arrendatario : arrendatarios) {
            model.addElement(arrendatario);
        }
        arrendatariosjComboBox.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        arrendatariosjComboBox = new javax.swing.JComboBox<>();
        inmueblesjComboBox = new javax.swing.JComboBox<>();
        duracionContratojSpinner = new javax.swing.JSpinner();
        precioPruebaInmueblejTextField = new javax.swing.JTextField();
        aceptarjButton = new javax.swing.JButton();
        volverjButton = new javax.swing.JButton();
        precio2jLabel = new javax.swing.JLabel();
        precioNormalInmueblejTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Duración contrato");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Precio normal");

        arrendatariosjComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        inmueblesjComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        duracionContratojSpinner.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        precioPruebaInmueblejTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        precioPruebaInmueblejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioPruebaInmueblejTextFieldKeyTyped(evt);
            }
        });

        aceptarjButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        aceptarjButton.setText("Aceptar");
        aceptarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarjButtonActionPerformed(evt);
            }
        });

        volverjButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        volverjButton.setText("Volver");
        volverjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverjButtonActionPerformed(evt);
            }
        });

        precio2jLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        precio2jLabel.setText("Precio prueba");

        precioNormalInmueblejTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        precioNormalInmueblejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioNormalInmueblejTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arrendatariosjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inmueblesjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(precio2jLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(precioPruebaInmueblejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(duracionContratojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(precioNormalInmueblejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aceptarjButton)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(arrendatariosjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inmueblesjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(duracionContratojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(precioNormalInmueblejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio2jLabel)
                    .addComponent(precioPruebaInmueblejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverjButton)
                    .addComponent(aceptarjButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void aceptarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjButtonActionPerformed
        Arrendatario arrendatario = (Arrendatario) arrendatariosjComboBox.getSelectedItem();
        Inmueble inmueble = (Inmueble) inmueblesjComboBox.getSelectedItem();
        if (comprobarCampos()) {
            DataBase.insertContrato(arrendatario.getDni(), inmueble.getIdInmueble(), (Integer) duracionContratojSpinner.getValue(), Double.parseDouble(precioNormalInmueblejTextField.getText()), Double.parseDouble(precioPruebaInmueblejTextField.getText()));
            resetearCampos();
            rellenarInmueblesComboBox(DataBase.selectInmuebleByIdInmuebleNotInContrato());
        } else {
            JOptionPane.showMessageDialog(null, "Se tiene que seleccionar un arrendatario e inmueble, todos los campos tienen que estar rellenados, y los precios tienen que ser mayor o igual que 0");
        }
    }//GEN-LAST:event_aceptarjButtonActionPerformed

    private void precioNormalInmueblejTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioNormalInmueblejTextFieldKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_precioNormalInmueblejTextFieldKeyTyped

    private void precioPruebaInmueblejTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioPruebaInmueblejTextFieldKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_precioPruebaInmueblejTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JComboBox<String> arrendatariosjComboBox;
    private javax.swing.JSpinner duracionContratojSpinner;
    private javax.swing.JComboBox<String> inmueblesjComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel precio2jLabel;
    private javax.swing.JTextField precioNormalInmueblejTextField;
    private javax.swing.JTextField precioPruebaInmueblejTextField;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables

    private void rellenarInmueblesComboBox(ArrayList<Inmueble> inmuebles) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(new Inmueble(" -- Seleccione un inmueble --"));
        for (Inmueble inmueble : inmuebles) {
            model.addElement(inmueble);
        }
        inmueblesjComboBox.setModel(model);
    }

    private void resetearCampos() {
        arrendatariosjComboBox.setSelectedIndex(0);
        inmueblesjComboBox.setSelectedIndex(0);
        duracionContratojSpinner.setValue(0);
        precioNormalInmueblejTextField.setText("");
        precioPruebaInmueblejTextField.setText("");
    }

    private void configurarNumeroMesesSpinner() {
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMinimum(0);
        duracionContratojSpinner.setModel(nm);
    }

    private boolean comprobarCampos() {
        return arrendatariosjComboBox.getSelectedIndex() > 0 && inmueblesjComboBox.getSelectedIndex() > 0 && !precioNormalInmueblejTextField.getText().equals("") && !precioPruebaInmueblejTextField.getText().equals("") && Double.parseDouble(precioNormalInmueblejTextField.getText()) >= 0 && Double.parseDouble(precioPruebaInmueblejTextField.getText()) >= 0 ? true : false;
    }
}