package view;

import model.Arrendatario;
import model.Contrato;
import model.Inmueble;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import persistence.DataBase;
import javax.swing.DefaultComboBoxModel;
import model.TipoInmueble;
import model.modelosContrato.GeneradorPDFModeloContratoVivienda1;
import javax.swing.JOptionPane;
import model.modelosContrato.GeneradorPDFModeloContratoAparcamiento1;

public class ModelosContrato extends javax.swing.JFrame {
    
    private Arrendatario arrendatario;
    private Inmueble inmueble;
    private Contrato contrato;
    private MainFrame mainFrame;
    private TipoInmueble typeInmueble;
    private int numeroModel;

    public ModelosContrato(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        rellenarArrendatarioComboBox(DataBase.selectAllArendatarios());
        typeInmueble = TipoInmueble.VIVIENDA;
        rellenarNumberModeljComboBox();
        numeroModel = 1;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArrendatarioComboBox = new javax.swing.JComboBox<>();
        InmuebleComboBox = new javax.swing.JComboBox<>();
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
                    .add(numberModeljComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(76, 76, 76)
                .add(volverjButton)
                .add(68, 68, 68)
                .add(crearModelojButton)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(ArrendatarioComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(InmuebleComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(numberModeljComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(volverjButton)
                    .add(crearModelojButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        this.mainFrame.setVisible(true);
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

    private void numberModeljComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_numberModeljComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            numeroModel = (int) numberModeljComboBox.getSelectedItem();
        } 
    }//GEN-LAST:event_numberModeljComboBoxItemStateChanged

    private void crearModelojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearModelojButtonActionPerformed
        if(comprobarCampos()){
            switch(inmueble.getTipoInmueble()){
            case VIVIENDA:
                if(numeroModel == 1) new GeneradorPDFModeloContratoVivienda1(arrendatario, inmueble, contrato, numeroModel);
                break;
            case APARCAMIENTO:
                if(numeroModel == 1) new GeneradorPDFModeloContratoAparcamiento1(arrendatario, inmueble, contrato, numeroModel);
                break;
            default:
                JOptionPane.showMessageDialog(null, "No existe modelo de contrato para este tipo de inmueble");
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
            default:
                break;
        }
        numberModeljComboBox.setModel(model);
    }
    
    private boolean comprobarCampos(){
        return ArrendatarioComboBox.getSelectedIndex() > 0 && InmuebleComboBox.getSelectedIndex() > 0;
    }
}
