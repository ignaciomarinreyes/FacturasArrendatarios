/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Arrendatario;
import model.Contrato;
import model.Inmueble;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import persistence.DataBase;
import javax.swing.DefaultComboBoxModel;
import model.TipoInmueble;
import java.awt.event.ActionEvent;
import model.modelosContrato.GeneradorPDFModeloContratoVivienda1;
import javax.swing.JOptionPane;
/**
 *
 * @author ignacio
 */
public class ModelosContrato extends javax.swing.JFrame {
    
    private Arrendatario arrendatario;
    private Inmueble inmueble;
    private Contrato contrato;
    private MainFrame2 mainFrame2;
    private TipoInmueble typeInmueble;
    private int numeroModel;
    /** Creates new form ModelosContrato */
    public ModelosContrato(MainFrame2 mainFrame2) {
        initComponents();
        this.mainFrame2 = mainFrame2;
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        rellenarArrendatarioComboBox(DataBase.selectAllArendatarios());
        rellenarTypeModelComboBox();
        typeInmueble = TipoInmueble.VIVIENDA;
        rellenarNumberModeljComboBox();
        numeroModel = 1;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArrendatarioComboBox = new javax.swing.JComboBox<>();
        InmuebleComboBox = new javax.swing.JComboBox<>();
        typeModeljComboBox = new javax.swing.JComboBox<>();
        numberModeljComboBox = new javax.swing.JComboBox<>();
        volverjButton = new javax.swing.JButton();
        crearModelojButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ArrendatarioComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ArrendatarioComboBoxItemStateChanged(evt);
            }
        });

        InmuebleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                InmuebleComboBoxItemStateChanged(evt);
            }
        });

        typeModeljComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeModeljComboBoxItemStateChanged(evt);
            }
        });

        numberModeljComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                numberModeljComboBoxItemStateChanged(evt);
            }
        });

        volverjButton.setText("Volver");
        volverjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverjButtonActionPerformed(evt);
            }
        });

        crearModelojButton.setText("Crear");
        crearModelojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearModelojButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ArrendatarioComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(InmuebleComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(typeModeljComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(numberModeljComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(74, 74, 74)
                .add(volverjButton)
                .add(71, 71, 71)
                .add(crearModelojButton)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(ArrendatarioComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(InmuebleComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(typeModeljComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(numberModeljComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(volverjButton)
                    .add(crearModelojButton))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        this.mainFrame2.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void ArrendatarioComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ArrendatarioComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED && ArrendatarioComboBox.getSelectedIndex() > 0) {
            arrendatario = (Arrendatario) ArrendatarioComboBox.getSelectedItem();
            rellenarInmuebleComboBox(DataBase.selectContratoJoinInmuebleByDniArrendatario(arrendatario.getDni()));
        } else if (ArrendatarioComboBox.getSelectedIndex() == 0) {
            InmuebleComboBox.removeAllItems();
        }
    }//GEN-LAST:event_ArrendatarioComboBoxItemStateChanged

    private void InmuebleComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_InmuebleComboBoxItemStateChanged
        if (InmuebleComboBox.getSelectedIndex() > 0 && evt.getStateChange() == ItemEvent.SELECTED) {
            inmueble = (Inmueble) InmuebleComboBox.getSelectedItem();
            contrato = DataBase.selectContratoByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
        } 
    }//GEN-LAST:event_InmuebleComboBoxItemStateChanged

    private void typeModeljComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeModeljComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            typeInmueble = (TipoInmueble) typeModeljComboBox.getSelectedItem();
            rellenarNumberModeljComboBox();
        } 
    }//GEN-LAST:event_typeModeljComboBoxItemStateChanged

    private void numberModeljComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_numberModeljComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            numeroModel = (int) numberModeljComboBox.getSelectedItem();
        } 
    }//GEN-LAST:event_numberModeljComboBoxItemStateChanged

    private void crearModelojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearModelojButtonActionPerformed
        if(comprobarCampos()){
            switch(typeInmueble){
            case VIVIENDA:
                if(numeroModel == 1) new GeneradorPDFModeloContratoVivienda1(arrendatario, inmueble, contrato, numeroModel);
                break;
            case APARCAMIENTO:
                if(numeroModel == 1) System.out.println("En construcción");
                break;               
            case LOCAL:
                if(numeroModel == 1) System.out.println("En construcción");
                break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Elija un arrendatario y un inmueble");
        }
    }//GEN-LAST:event_crearModelojButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ArrendatarioComboBox;
    private javax.swing.JComboBox<String> InmuebleComboBox;
    private javax.swing.JButton crearModelojButton;
    private javax.swing.JComboBox<String> numberModeljComboBox;
    private javax.swing.JComboBox<String> typeModeljComboBox;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables

    
    private void rellenarArrendatarioComboBox(ArrayList<Arrendatario> arrendatarios) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(new Arrendatario(" -- Seleccione un arrendatario --"));
        for (Arrendatario arrendatario : arrendatarios) {
            model.addElement(arrendatario);
        }
        ArrendatarioComboBox.setModel(model);
    }

    private void rellenarInmuebleComboBox(ArrayList<Inmueble> inmuebles) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(new Inmueble(" -- Seleccione un inmueble --"));
        for (Inmueble inmueble : inmuebles) {
            model.addElement(inmueble);
        }
        InmuebleComboBox.setModel(model);
    }
    
    private void rellenarTypeModelComboBox(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(TipoInmueble.VIVIENDA);
        model.addElement(TipoInmueble.APARCAMIENTO);
        model.addElement(TipoInmueble.LOCAL);
        typeModeljComboBox.setModel(model);
    }
    
    private void rellenarNumberModeljComboBox(){
        numberModeljComboBox.removeAllItems();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        switch(typeInmueble){
            case VIVIENDA:
                model.addElement(1);
                break;
            case APARCAMIENTO:
                model.addElement(1);
                break;               
            case LOCAL:
                model.addElement(1);
                break;
        }
        numberModeljComboBox.setModel(model);
    }
    
    private boolean comprobarCampos(){
        return ArrendatarioComboBox.getSelectedIndex() > 0 && InmuebleComboBox.getSelectedIndex() > 0;
    }
}
