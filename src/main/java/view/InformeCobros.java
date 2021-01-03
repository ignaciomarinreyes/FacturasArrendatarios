/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JTextFieldDateEditor;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import model.diseno.informe.CobrosCliente;

/**
 *
 * @author ignacio
 */
public class InformeCobros extends javax.swing.JFrame {

    
    MainFrame mainFrame;
    
    public InformeCobros(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        LocalDate now = LocalDate.now();
        LocalDate fechaInicio = LocalDate.of(now.getYear(), 1, 1);
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) IniciojDateChooser.getDateEditor();
        editor1.setDate(Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        editor1.setEditable(false);
        LocalDate fechaFin = LocalDate.of(now.getYear(), 12, 1);
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) finjDateChooser.getDateEditor();
        editor2.setDate(Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant()));     
        editor2.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IniciojDateChooser = new com.toedter.calendar.JDateChooser();
        finjDateChooser = new com.toedter.calendar.JDateChooser();
        generarjButton = new javax.swing.JButton();
        volverjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        generarjButton.setText("Generar");
        generarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarjButtonActionPerformed(evt);
            }
        });

        volverjButton.setText("Volver");
        volverjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverjButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Inicio");

        jLabel2.setText("Fin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(generarjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(IniciojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(finjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(finjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(13, 13, 13))
                    .addComponent(IniciojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverjButton)
                    .addComponent(generarjButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void generarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarjButtonActionPerformed
        LocalDate fechaInicio = IniciojDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaFin = finjDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        new CobrosCliente(fechaInicio, fechaFin);
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_generarjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser IniciojDateChooser;
    private com.toedter.calendar.JDateChooser finjDateChooser;
    private javax.swing.JButton generarjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables
}