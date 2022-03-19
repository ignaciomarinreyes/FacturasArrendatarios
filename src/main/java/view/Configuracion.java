package view;

import javax.swing.JOptionPane;
import persistence.DataBase;

public class Configuracion extends javax.swing.JFrame {

    private MainFrame mainFrame;
    private model.Configuracion configuracion;

    public Configuracion(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.configuracion = DataBase.selectConfiguracion();
        igicjTextField.setText(String.valueOf(configuracion.getIgic()));
        irpfjTextField.setText(String.valueOf(configuracion.getIrpf()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        irpfjTextField = new javax.swing.JTextField();
        igicjTextField = new javax.swing.JTextField();
        volverjButton = new javax.swing.JButton();
        aceptarjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("IRPF");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("IGIC");

        irpfjTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        irpfjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                irpfjTextFieldKeyTyped(evt);
            }
        });

        igicjTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        igicjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                igicjTextFieldKeyTyped(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(irpfjTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(volverjButton)
                                .addGap(18, 18, 18)
                                .addComponent(aceptarjButton)
                                .addGap(11, 11, 11))
                            .addComponent(igicjTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(irpfjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(igicjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverjButton)
                    .addComponent(aceptarjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        mainFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void aceptarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjButtonActionPerformed
        if (comprobarCampos()) {
            DataBase.updateConfiguracionSetIgicAndIrpfWhereIdConfiguracion(Float.parseFloat(irpfjTextField.getText()), Float.parseFloat(igicjTextField.getText()));
            this.mainFrame.setVisible(true);
            this.mainFrame.setConfiguracion(DataBase.selectConfiguracion());
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Los valores deben de estar en tanto por uno y rellene los dos campos");
        }
    }//GEN-LAST:event_aceptarjButtonActionPerformed

    private void irpfjTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_irpfjTextFieldKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_irpfjTextFieldKeyTyped

    private void igicjTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_igicjTextFieldKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_igicjTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JTextField igicjTextField;
    private javax.swing.JTextField irpfjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables

    private boolean comprobarCampos() {
        if (!irpfjTextField.getText().isEmpty() && !igicjTextField.getText().isEmpty()) {
            float igic = Float.parseFloat(igicjTextField.getText());
            float irpf = Float.parseFloat(irpfjTextField.getText());
            return igic <= 1 && igic > 0 && irpf <= 1 && irpf > 0;
        } else {
            return false;
        }
    }
}
