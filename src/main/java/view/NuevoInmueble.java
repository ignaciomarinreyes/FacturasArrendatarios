package view;

import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import model.TipoInmueble;
import persistence.DataBase;
import javax.swing.JOptionPane;

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

        tipoInmueblejLabel = new javax.swing.JLabel();
        municipiojLabel = new javax.swing.JLabel();
        nombreCallejLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numeroInmueblejLabel = new javax.swing.JLabel();
        letraInmueblejLabel = new javax.swing.JLabel();
        tipoInmueblejComboBox = new javax.swing.JComboBox<>();
        tipoViajComboBox = new javax.swing.JComboBox<>();
        localidadjTextField = new javax.swing.JTextField();
        nombreCallejTextField = new javax.swing.JTextField();
        numeroCallejTextField = new javax.swing.JTextField();
        numeroInmueblejTextField = new javax.swing.JTextField();
        letraInmueblejTextField = new javax.swing.JTextField();
        volverjButton = new javax.swing.JButton();
        aceptarjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tipoInmueblejLabel.setText("Tipo Inmueble");

        municipiojLabel.setText("Municipio");

        nombreCallejLabel.setText("Nombre ");

        jLabel4.setText("Número");

        numeroInmueblejLabel.setText("Número Inmueble");

        letraInmueblejLabel.setText("Letra Inmueble");

        tipoInmueblejComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoInmueblejComboBoxItemStateChanged(evt);
            }
        });

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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(15, 15, 15)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(letraInmueblejLabel)
                            .add(jLabel4)
                            .add(tipoInmueblejLabel)
                            .add(municipiojLabel)
                            .add(nombreCallejLabel))
                        .add(37, 37, 37))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(numeroInmueblejLabel)
                        .add(18, 18, 18)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(numeroInmueblejTextField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, numeroCallejTextField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(tipoViajComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(nombreCallejTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, localidadjTextField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, tipoInmueblejComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(letraInmueblejTextField))
                .add(0, 19, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(volverjButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(aceptarjButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tipoInmueblejLabel)
                    .add(tipoInmueblejComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(municipiojLabel)
                    .add(localidadjTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreCallejLabel)
                    .add(tipoViajComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(nombreCallejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(numeroCallejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(numeroInmueblejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(numeroInmueblejLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(letraInmueblejLabel)
                    .add(letraInmueblejTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(aceptarjButton)
                    .add(volverjButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjButtonActionPerformed

        if (DataBase.insertInmueble(tipoViajComboBox.getSelectedItem().toString() + " " + nombreCallejTextField.getText(), numeroCallejTextField.getText(), localidadjTextField.getText(), numeroInmueblejTextField.getText(), (TipoInmueble) tipoInmueblejComboBox.getSelectedItem(), letraInmueblejTextField.getText())){
            JOptionPane.showMessageDialog(null, "La operación se realizó con éxito");   
         } else {
            JOptionPane.showMessageDialog(null, "Se produjo un error");   
        }  
        limpiarTextFields();   
    }//GEN-LAST:event_aceptarjButtonActionPerformed

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void tipoInmueblejComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoInmueblejComboBoxItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
             if (tipoInmueblejComboBox.getSelectedIndex() == 1){
                ocultarLetraInmueble(); 
             }else if (tipoInmueblejComboBox.getSelectedIndex() == 2) {
                ocultarNumeroYLetraInmueble();
            } else {
                mostrarTodosCampos();
            }
            limpiarTextFields();
        }
    }//GEN-LAST:event_tipoInmueblejComboBoxItemStateChanged
                                                                                             
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
        letraInmueblejTextField.setText("");
    }

    private void rellenarTipoViajComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("avd.");
        model.addElement("c.");
        tipoViajComboBox.setModel(model);
    }

    private void ocultarNumeroYLetraInmueble(){
        numeroInmueblejTextField.setVisible(false);
        numeroInmueblejLabel.setVisible(false);
        letraInmueblejTextField.setVisible(false);
        letraInmueblejLabel.setVisible(false);
        pack();
    }
    
    private void ocultarLetraInmueble() {
        letraInmueblejTextField.setVisible(false);
        letraInmueblejLabel.setVisible(false);
        numeroInmueblejTextField.setVisible(true);
        numeroInmueblejLabel.setVisible(true);
        pack();
    }

    private void mostrarTodosCampos() {
        numeroInmueblejTextField.setVisible(true);
        numeroInmueblejLabel.setVisible(true);
        letraInmueblejTextField.setVisible(true);
        letraInmueblejLabel.setVisible(true);
        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel letraInmueblejLabel;
    private javax.swing.JTextField letraInmueblejTextField;
    private javax.swing.JTextField localidadjTextField;
    private javax.swing.JLabel municipiojLabel;
    private javax.swing.JLabel nombreCallejLabel;
    private javax.swing.JTextField nombreCallejTextField;
    private javax.swing.JTextField numeroCallejTextField;
    private javax.swing.JLabel numeroInmueblejLabel;
    private javax.swing.JTextField numeroInmueblejTextField;
    private javax.swing.JComboBox<String> tipoInmueblejComboBox;
    private javax.swing.JLabel tipoInmueblejLabel;
    private javax.swing.JComboBox<String> tipoViajComboBox;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables

}
