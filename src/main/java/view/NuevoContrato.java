
package view;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import model.Arrendatario;
import model.Inmueble;
import model.Arrendador;
import persistence.DataBase;
import javax.swing.JOptionPane;

public class NuevoContrato extends javax.swing.JFrame {
   
    private MainFrame mainFrame;

    public NuevoContrato(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        configurarNumeroMesesSpinner();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        rellenarArrendadoresComboBox(DataBase.selectAllArrendadores());
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

        volverjButton = new javax.swing.JButton();
        aceptarjButton = new javax.swing.JButton();
        precioNormalInmueblejTextField = new javax.swing.JTextField();
        precioPruebaInmueblejTextField = new javax.swing.JTextField();
        arrendatariosjComboBox = new javax.swing.JComboBox<>();
        inmueblesjComboBox = new javax.swing.JComboBox<>();
        duracionContratojSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        arrendadorjComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        volverjButton.setText("Volver");
        volverjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverjButtonActionPerformed(evt);
            }
        });

        aceptarjButton.setText("Aceptar");
        aceptarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarjButtonActionPerformed(evt);
            }
        });

        precioNormalInmueblejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioNormalInmueblejTextFieldKeyTyped(evt);
            }
        });

        precioPruebaInmueblejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioPruebaInmueblejTextFieldKeyTyped(evt);
            }
        });

        jLabel1.setText("Arrendatario");

        jLabel2.setText("Inmueble");

        jLabel3.setText("Duración");

        jLabel4.setText("años");

        jLabel5.setText("Precio normal");

        jLabel6.setText("Precio prueba");

        jLabel7.setText("Arrendador");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(volverjButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(aceptarjButton)
                .add(19, 19, 19))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel2)
                            .add(jLabel1)
                            .add(jLabel3)
                            .add(jLabel5)
                            .add(jLabel7))
                        .add(26, 26, 26)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(duracionContratojSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jLabel4))
                            .add(arrendatariosjComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(inmueblesjComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(precioNormalInmueblejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 171, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(arrendadorjComboBox, 0, 430, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(jLabel6)
                        .add(18, 18, 18)
                        .add(precioPruebaInmueblejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 171, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(arrendadorjComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(arrendatariosjComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(inmueblesjComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(duracionContratojSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(precioNormalInmueblejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel6)
                    .add(precioPruebaInmueblejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(volverjButton)
                    .add(aceptarjButton))
                .add(16, 16, 16))
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
            Arrendador arrendador = (Arrendador) arrendadorjComboBox.getSelectedItem();
            if(DataBase.insertContrato(arrendatario.getDni(), inmueble.getIdInmueble(), (Integer) duracionContratojSpinner.getValue(), Double.parseDouble(precioNormalInmueblejTextField.getText()), Double.parseDouble(precioPruebaInmueblejTextField.getText()), arrendador.getIdArrendador())){
                JOptionPane.showMessageDialog(null, "La operación se realizó con éxito");
            } else{
                JOptionPane.showMessageDialog(null, "Se produjo un error");   
            }
            resetearCampos();
            rellenarInmueblesComboBox(DataBase.selectInmuebleByIdInmuebleNotInContrato());
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos tienen que estar rellenados, y los precios tienen que ser mayor o igual que 0");
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

    
    private void rellenarArrendadoresComboBox(ArrayList<Arrendador> arrendadores){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(new Inmueble(" -- Seleccione un arrendador --"));
        for (Arrendador arrendador : arrendadores) {
            model.addElement(arrendador);
        }
        arrendadorjComboBox.setModel(model);
    }
    
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
        return arrendadorjComboBox.getSelectedIndex() > 0 && arrendatariosjComboBox.getSelectedIndex() > 0 && inmueblesjComboBox.getSelectedIndex() > 0 && !precioNormalInmueblejTextField.getText().equals("") && !precioPruebaInmueblejTextField.getText().equals("") && Double.parseDouble(precioNormalInmueblejTextField.getText()) >= 0 && Double.parseDouble(precioPruebaInmueblejTextField.getText()) >= 0 ? true : false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JComboBox<String> arrendadorjComboBox;
    private javax.swing.JComboBox<String> arrendatariosjComboBox;
    private javax.swing.JSpinner duracionContratojSpinner;
    private javax.swing.JComboBox<String> inmueblesjComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField precioNormalInmueblejTextField;
    private javax.swing.JTextField precioPruebaInmueblejTextField;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables

}
