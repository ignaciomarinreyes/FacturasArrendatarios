
package view;

import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import persistence.DataBase;
import javax.swing.JOptionPane;

public class NuevoArrendatario extends javax.swing.JFrame {

    private MainFrame mainFrame;

    public NuevoArrendatario(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        rellenarTipoPersonajComboBox();
        rellenarTipoCalleJComboBox();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        apellidosjLabel = new javax.swing.JLabel();
        tipoPersonajComboBox = new javax.swing.JComboBox<>();
        dniTextField = new javax.swing.JTextField();
        nombreTextField = new javax.swing.JTextField();
        apellidosTextField = new javax.swing.JTextField();
        volverButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nacionalidadjTextField = new javax.swing.JTextField();
        nombreCallejTextField = new javax.swing.JTextField();
        numeroCallejTextField = new javax.swing.JTextField();
        localidadjTextField = new javax.swing.JTextField();
        municipiojTextField = new javax.swing.JTextField();
        tipoCalleJComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Persona");

        jLabel2.setText("NIF");

        jLabel3.setText("Nombre");

        apellidosjLabel.setText("Apellidos");

        tipoPersonajComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoPersonajComboBoxItemStateChanged(evt);
            }
        });

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Nacionalidad");

        jLabel6.setText("Nombre");

        jLabel7.setText("Número");

        jLabel8.setText("Localidad");

        jLabel9.setText("Municipio");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(dniTextField)
                            .add(tipoPersonajComboBox, 0, 310, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(apellidosjLabel)
                            .add(jLabel7)
                            .add(jLabel6)
                            .add(jLabel5)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jLabel8)
                                .add(jLabel9)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(14, 14, 14)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, municipiojTextField)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, localidadjTextField)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, numeroCallejTextField)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(tipoCalleJComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(nombreCallejTextField))))
                            .add(layout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, nombreTextField)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, nacionalidadjTextField)
                                    .add(apellidosTextField))))))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .add(volverButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(aceptarButton)
                .add(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tipoPersonajComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(dniTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(apellidosjLabel)
                    .add(apellidosTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(nacionalidadjTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreCallejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(tipoCalleJComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(numeroCallejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .add(7, 7, 7)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(localidadjTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9)
                    .add(municipiojTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(volverButton)
                    .add(aceptarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        if(DataBase.insertArrendatario((String) tipoPersonajComboBox.getSelectedItem(), dniTextField.getText(), nombreTextField.getText(), apellidosTextField.getText(), nacionalidadjTextField.getText() , tipoCalleJComboBox.getSelectedItem().toString() + " " + nombreCallejTextField.getText(), numeroCallejTextField.getText(), localidadjTextField.getText(), municipiojTextField.getText())){
            JOptionPane.showMessageDialog(null, "La operación se realizó con éxito");  
        }else{
            JOptionPane.showMessageDialog(null, "Se produjo un error");   
        }
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

    private void limpiarTextFields() {
        dniTextField.setText("");
        nombreTextField.setText("");
        apellidosTextField.setText("");
        nacionalidadjTextField.setText("");
        nombreCallejTextField.setText("");
        numeroCallejTextField.setText("");
        localidadjTextField.setText("");
        municipiojTextField.setText("");
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
    
    private void rellenarTipoCalleJComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("avd.");
        model.addElement("c.");
        tipoCalleJComboBox.setModel(model);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JTextField apellidosTextField;
    private javax.swing.JLabel apellidosjLabel;
    private javax.swing.JTextField dniTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField localidadjTextField;
    private javax.swing.JTextField municipiojTextField;
    private javax.swing.JTextField nacionalidadjTextField;
    private javax.swing.JTextField nombreCallejTextField;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField numeroCallejTextField;
    private javax.swing.JComboBox<String> tipoCalleJComboBox;
    private javax.swing.JComboBox<String> tipoPersonajComboBox;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables

}
