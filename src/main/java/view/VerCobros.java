package view;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Cobro;
import model.Contrato;
import model.Inmueble;
import persistence.DataBase;

public class VerCobros extends javax.swing.JFrame {

    private MainFrame mainFrame;
    private int idRegistroFactura;
    private Contrato contrato;
    private double cobrado;
    private double precio;
    private model.Configuracion configuracion;

    public VerCobros(MainFrame mainFrame, int idRegistroFactura, Contrato contrato, Inmueble inmueble, model.Configuracion configuracion) {
        this.mainFrame = mainFrame;
        this.idRegistroFactura = idRegistroFactura;
        this.contrato = contrato;
        this.precio = 0;
        this.configuracion = configuracion;
        switch (inmueble.getTipoInmueble()) {
            case VIVIENDA:
                precio = contrato.getPrecio1Inmueble();
                break;
            case APARCAMIENTO:
                precio = contrato.getPrecio1Inmueble();
                break;
            case LOCAL:
                precio = calcularPrecioNeto();
                break;
        }
        initComponents();
        setResizable(false);
        configurarJTable();
        titulojLabel1.setFont(new Font("TimesRoman", Font.BOLD, 16));
        titulojLabel2.setFont(new Font("TimesRoman", Font.BOLD, 16));
        titulojLabel3.setFont(new Font("TimesRoman", Font.BOLD, 16));
        JTextFieldDateEditor editor = (JTextFieldDateEditor) fechajDateChooser.getDateEditor();
        editor.setEditable(false);
        ocultarColumna(cobrosjTable, 0);
        setLocationRelativeTo(null);
        setVisible(true);
        rellenarCobrosTable(DataBase.selectAllCobroByidRegistroFactura(idRegistroFactura));
        actualizarCobradoYPendienteCobrar();
        preciojLabel.setText(String.valueOf(precio));
        importejTextField.setText(String.valueOf(Math.floor((precio - cobrado) * 100) / 100));
        fechajDateChooser.setDate(new java.util.Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        cobrosjTable = new javax.swing.JTable();
        importejTextField = new javax.swing.JTextField();
        nuevojButton = new javax.swing.JButton();
        EliminarjButton = new javax.swing.JButton();
        fechajDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        volverjButton = new javax.swing.JButton();
        titulojLabel2 = new javax.swing.JLabel();
        titulojLabel3 = new javax.swing.JLabel();
        titulojLabel1 = new javax.swing.JLabel();
        preciojLabel = new javax.swing.JLabel();
        cobradojLabel = new javax.swing.JLabel();
        pendientejLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cobrosjTable.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cobrosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idCobro", "Fecha", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cobrosjTable);

        importejTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        importejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                importejTextFieldKeyTyped(evt);
            }
        });

        nuevojButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        nuevojButton.setText("Cobrar");
        nuevojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevojButtonActionPerformed(evt);
            }
        });

        EliminarjButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        EliminarjButton.setText("Eliminar");
        EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarjButtonActionPerformed(evt);
            }
        });

        fechajDateChooser.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Fecha");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Importe");

        volverjButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        volverjButton.setText("Volver");
        volverjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverjButtonActionPerformed(evt);
            }
        });

        titulojLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titulojLabel2.setText("Cobrado");

        titulojLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titulojLabel3.setText("Pendiente");

        titulojLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titulojLabel1.setText("Precio");

        preciojLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        preciojLabel.setText("jLabel6");

        cobradojLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        cobradojLabel.setText("jLabel6");

        pendientejLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        pendientejLabel.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(titulojLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(preciojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(titulojLabel2)
                        .addGap(17, 17, 17)
                        .addComponent(cobradojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titulojLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fechajDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(importejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nuevojButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EliminarjButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(volverjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pendientejLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulojLabel2)
                    .addComponent(titulojLabel3)
                    .addComponent(titulojLabel1)
                    .addComponent(preciojLabel)
                    .addComponent(cobradojLabel)
                    .addComponent(pendientejLabel))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(importejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nuevojButton)
                        .addComponent(EliminarjButton)
                        .addComponent(volverjButton)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fechajDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverjButtonActionPerformed
        mainFrame.setVisible(true);
        mainFrame.rellenarTablaRegistroFactura(DataBase.selectRegistroFacturaByDniArrendatarioAndIdInmueble(mainFrame.getArrendatario().getDni(), mainFrame.getInmueble().getIdInmueble()));
        dispose();
    }//GEN-LAST:event_volverjButtonActionPerformed

    private void nuevojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevojButtonActionPerformed
        if (comprobarCampos()) {
            LocalDate fechaCobro = fechajDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            double importe = Double.parseDouble(importejTextField.getText());
            double pendiente = Math.floor((precio - cobrado) * 100) / 100;
            if (importe <= pendiente) {
                DataBase.insertCobro(idRegistroFactura, fechaCobro, importe);
                rellenarCobrosTable(DataBase.selectAllCobroByidRegistroFactura(idRegistroFactura));
                actualizarCobradoYPendienteCobrar();
                if (cobrado == precio) {
                    DataBase.updateRegistroFacturaSetCobradoWhereIdRegistroFactura(true, idRegistroFactura);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El cobro supera la cantidad pendiente de cobrar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos e introduzca una cantidad superior a 0");
        }
    }//GEN-LAST:event_nuevojButtonActionPerformed

    private void EliminarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarjButtonActionPerformed
        int[] filasSeleccionadas = cobrosjTable.getSelectedRows();
        if (filasSeleccionadas.length != 0) {
            for (int i = 0; i < filasSeleccionadas.length; i++) {
                DataBase.deleteCobroByIdCobro((int) cobrosjTable.getValueAt(filasSeleccionadas[i], 0));
            }
            if (cobrado == precio) {
                DataBase.updateRegistroFacturaSetCobradoWhereIdRegistroFactura(false, idRegistroFactura);
            }
            rellenarCobrosTable(DataBase.selectAllCobroByidRegistroFactura(idRegistroFactura));
            actualizarCobradoYPendienteCobrar();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar uno o varios cobros para eliminar");
        }
    }//GEN-LAST:event_EliminarjButtonActionPerformed

    private void importejTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importejTextFieldKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < ',' || car > '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_importejTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarjButton;
    private javax.swing.JLabel cobradojLabel;
    private javax.swing.JTable cobrosjTable;
    private com.toedter.calendar.JDateChooser fechajDateChooser;
    private javax.swing.JTextField importejTextField;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevojButton;
    private javax.swing.JLabel pendientejLabel;
    private javax.swing.JLabel preciojLabel;
    private javax.swing.JLabel titulojLabel1;
    private javax.swing.JLabel titulojLabel2;
    private javax.swing.JLabel titulojLabel3;
    private javax.swing.JButton volverjButton;
    // End of variables declaration//GEN-END:variables

    private void rellenarCobrosTable(ArrayList<Cobro> cobros) {
        DefaultTableModel model = (DefaultTableModel) cobrosjTable.getModel();
        model.setRowCount(0);
        cobrado = 0;
        for (Cobro cobro : cobros) {
            model.addRow(new Object[]{cobro.getIdCobro(), cobro.getFechaCobro(), cobro.getImporte()});
            cobrado += cobro.getImporte();
        }
    }

    private void ocultarColumna(JTable myTable, int numeroColumna) {
        myTable.getColumn(myTable.getColumnName(numeroColumna)).setWidth(0);
        myTable.getColumn(myTable.getColumnName(numeroColumna)).setMinWidth(0);
        myTable.getColumn(myTable.getColumnName(numeroColumna)).setMaxWidth(0);
    }

    private void actualizarCobradoYPendienteCobrar() {
        double pendiente = Math.floor((precio - cobrado) * 100) / 100;
        pendientejLabel.setText(String.valueOf(pendiente));
        cobradojLabel.setText(String.valueOf(cobrado));
        importejTextField.setText(String.valueOf(pendiente));
    }

    private boolean comprobarCampos() {
        return !importejTextField.getText().isEmpty() && Double.valueOf(importejTextField.getText()) > 0 && fechajDateChooser.getDate() != null;
    }

    private void configurarJTable() {
        JTableHeader th = cobrosjTable.getTableHeader();
        Font fuente = new Font("Arial", Font.PLAIN, 20);
        th.setFont(fuente);
        cobrosjTable.setRowHeight(25);
    }

    private double calcularPrecioNeto() {
        double precio1 = contrato.getPrecio1Inmueble();
        double retencion = precio1 * configuracion.getIrpf();
        double igic = precio1 * configuracion.getIgic();
        return Math.floor((precio1 - retencion + igic) * 100) / 100;
    }
}