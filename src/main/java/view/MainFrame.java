/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Arrendatario;
import model.Contrato;
import model.Inmueble;
import model.RegistroFactura;
import model.diseno.factoria.FactoriaFactura;
import model.diseno.factura.GeneradorPDFFactura;
import persistence.DataBase;
import model.Configuracion;
import model.diseno.factoria.FactoriaFianza;
import model.diseno.fianza.GeneradorPDFFianza;

/**
 *
 * @author ignacio
 */
public class MainFrame extends javax.swing.JFrame {

    private Arrendatario arrendatario;
    private Inmueble inmueble;
    private Contrato contrato;
    private RegistroFactura ultimoRegistroFactura;
    private final FactoriaFactura factoriaFactura;
    private Configuracion configuracion;
    private Boolean prueba;
    private final FactoriaFianza factoriaFianza;

    public MainFrame() {
        initComponents();
        configurarJTable();
        ocultarColumna(RegistroFacturaTable, 0);
        Dimension dimensionScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimensionScreen.getWidth() - this.getWidth()) / 2);
        this.setLocation(x, 20);
        setResizable(false);
        configurarNumeroMesesSpinner();
        setVisible(true);
        rellenarArrendatarioComboBox(DataBase.selectAllArendatarios());
        this.configuracion = DataBase.selectConfiguracion();
        factoriaFactura = new FactoriaFactura(false, configuracion);
        factoriaFianza = new FactoriaFianza();
        prueba = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        ArrendatarioLabel = new javax.swing.JLabel();
        InmuebleLabel = new javax.swing.JLabel();
        InmuebleComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        RegistroFacturaTable = new javax.swing.JTable();
        FechaInicioTextField = new javax.swing.JTextField();
        FechaFinTextField = new javax.swing.JTextField();
        numeroMesesSpinner = new javax.swing.JSpinner();
        CrearFacturaButton = new javax.swing.JButton();
        EliminarFacturaButton = new javax.swing.JButton();
        GenerarPDFFacturasButton = new javax.swing.JButton();
        generarPDFFianzaButton = new javax.swing.JButton();
        ArrendatarioComboBox = new javax.swing.JComboBox();
        pruebajCheckBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        numeroMesesFianzajSpinner = new javax.swing.JSpinner();
        fianzaMesjMonthChooser = new com.toedter.calendar.JMonthChooser();
        fianzaYearjYearChooser = new com.toedter.calendar.JYearChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        arrendatariojMenu = new javax.swing.JMenu();
        nuevoArrendatariojMenuItem = new javax.swing.JMenuItem();
        eliminarArrendatariojMenuItem = new javax.swing.JMenuItem();
        eliminarInmuebleMenu = new javax.swing.JMenu();
        nuevoInmueblejMenuItem = new javax.swing.JMenuItem();
        eliminarInmueblejMenuItem = new javax.swing.JMenuItem();
        contratojMenu = new javax.swing.JMenu();
        nuevoContratoMenuItem = new javax.swing.JMenuItem();
        eliminarContratoMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cobrosjMenuItem = new javax.swing.JMenuItem();
        configuracionjMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ArrendatarioLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ArrendatarioLabel.setText("Arrendatario");

        InmuebleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        InmuebleLabel.setText("Inmueble");

        InmuebleComboBox.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        InmuebleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                InmuebleComboBoxItemStateChanged(evt);
            }
        });

        RegistroFacturaTable.setAutoCreateRowSorter(true);
        RegistroFacturaTable.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        RegistroFacturaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idRegistroFactura", "Número Factura", "Fecha Factura", "Cobrado", "Agua", "Luz"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RegistroFacturaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        RegistroFacturaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistroFacturaTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RegistroFacturaTable);
        if (RegistroFacturaTable.getColumnModel().getColumnCount() > 0) {
            RegistroFacturaTable.getColumnModel().getColumn(0).setResizable(false);
        }

        FechaInicioTextField.setEditable(false);
        FechaInicioTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        FechaFinTextField.setEditable(false);
        FechaFinTextField.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        numeroMesesSpinner.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        numeroMesesSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numeroMesesSpinnerStateChanged(evt);
            }
        });

        CrearFacturaButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        CrearFacturaButton.setText("Crear Registro");
        CrearFacturaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearFacturaButtonActionPerformed(evt);
            }
        });

        EliminarFacturaButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        EliminarFacturaButton.setText("Eliminar Registro");
        EliminarFacturaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarFacturaButtonActionPerformed(evt);
            }
        });

        GenerarPDFFacturasButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        GenerarPDFFacturasButton.setText("Generar PDF Facturas");
        GenerarPDFFacturasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarPDFFacturasButtonActionPerformed(evt);
            }
        });

        generarPDFFianzaButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        generarPDFFianzaButton.setText("Generar Fianza");
        generarPDFFianzaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarPDFFianzaButtonActionPerformed(evt);
            }
        });

        ArrendatarioComboBox.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ArrendatarioComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ArrendatarioComboBoxItemStateChanged(evt);
            }
        });

        pruebajCheckBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        pruebajCheckBox.setText("Prueba");
        pruebajCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebajCheckBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Meses correspondientes");

        numeroMesesFianzajSpinner.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        fianzaMesjMonthChooser.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Fecha Inicio");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Fecha Fin");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Número Registros");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setText("Registros");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("Fecha Inicio");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel8.setText("Fianzas");

        jSeparator4.setPreferredSize(new java.awt.Dimension(10, 12));
        jSeparator4.setSize(new java.awt.Dimension(5, 0));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel9.setText("PDF");

        Archivo.setText("Archivo");
        Archivo.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                ArchivoMenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });

        arrendatariojMenu.setText("Arrendatario");

        nuevoArrendatariojMenuItem.setText("Nuevo");
        nuevoArrendatariojMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoArrendatariojMenuItemActionPerformed(evt);
            }
        });
        arrendatariojMenu.add(nuevoArrendatariojMenuItem);

        eliminarArrendatariojMenuItem.setText("Eliminar");
        eliminarArrendatariojMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarArrendatariojMenuItemActionPerformed(evt);
            }
        });
        arrendatariojMenu.add(eliminarArrendatariojMenuItem);

        Archivo.add(arrendatariojMenu);

        eliminarInmuebleMenu.setText("Inmueble");

        nuevoInmueblejMenuItem.setText("Nuevo");
        nuevoInmueblejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoInmueblejMenuItemActionPerformed(evt);
            }
        });
        eliminarInmuebleMenu.add(nuevoInmueblejMenuItem);

        eliminarInmueblejMenuItem.setText("Eliminar");
        eliminarInmueblejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarInmueblejMenuItemActionPerformed(evt);
            }
        });
        eliminarInmuebleMenu.add(eliminarInmueblejMenuItem);

        Archivo.add(eliminarInmuebleMenu);

        contratojMenu.setText("Contrato");

        nuevoContratoMenuItem.setText("Nuevo");
        nuevoContratoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoContratoMenuItemActionPerformed(evt);
            }
        });
        contratojMenu.add(nuevoContratoMenuItem);

        eliminarContratoMenuItem.setText("Eliminar");
        eliminarContratoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarContratoMenuItemActionPerformed(evt);
            }
        });
        contratojMenu.add(eliminarContratoMenuItem);

        Archivo.add(contratojMenu);

        jMenu2.setText("Informe");

        cobrosjMenuItem.setText("Cobros");
        cobrosjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobrosjMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(cobrosjMenuItem);

        Archivo.add(jMenu2);

        configuracionjMenuItem.setText("Ventana secundaria");
        configuracionjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuracionjMenuItemActionPerformed(evt);
            }
        });
        Archivo.add(configuracionjMenuItem);

        jMenuBar1.add(Archivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ArrendatarioLabel)
                            .addComponent(InmuebleLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ArrendatarioComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InmuebleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(numeroMesesFianzajSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(284, 284, 284)
                                        .addComponent(generarPDFFianzaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(79, 79, 79)
                                                .addComponent(fianzaMesjMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fianzaYearjYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jSeparator6)
                                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(7, 7, 7))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel9))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel5)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLabel3))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(numeroMesesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(CrearFacturaButton))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                    .addComponent(FechaInicioTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                                                    .addComponent(FechaFinTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(EliminarFacturaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(26, 26, 26)))))
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(pruebajCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(GenerarPDFFacturasButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArrendatarioLabel)
                    .addComponent(ArrendatarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InmuebleLabel)
                    .addComponent(InmuebleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fianzaMesjMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(fianzaYearjYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numeroMesesFianzajSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(25, 25, 25)
                        .addComponent(generarPDFFianzaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(FechaInicioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(FechaFinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(EliminarFacturaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(numeroMesesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(CrearFacturaButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pruebajCheckBox)
                            .addComponent(GenerarPDFFacturasButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearFacturaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearFacturaButtonActionPerformed
        if (InmuebleComboBox.getSelectedIndex() > 0) {
            int numeroRegistroFacturasACrear = (Integer) numeroMesesSpinner.getValue();
            if (RegistroFacturaTable.getRowCount() != 0) {
                ultimoRegistroFactura = DataBase.selectRegistroFacturasUltimaFechaFacturaFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
                int numeroFactura = ultimoRegistroFactura.getNumeroFactura() + 1;
                int maximoMeses = contrato.getDuracionContrato() * 12;
                LocalDate fechaFactura = ultimoRegistroFactura.getFechaFactura().plusMonths(1);
                for (int i = 0; i < numeroRegistroFacturasACrear; i++) {
                    if (numeroFactura > maximoMeses) {
                        numeroFactura = 1;
                    }
                    DataBase.insertRegistroFactura(arrendatario.getDni(), inmueble.getIdInmueble(), numeroFactura, fechaFactura, false, false, false, contrato.getIdContrato());
                    numeroFactura++;
                    fechaFactura = fechaFactura.plusMonths(1);
                }
                rellenarTablaRegistroFactura(DataBase.selectRegistroFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble()));
                FechaInicioTextField.setText(fechaFactura.toString());
                numeroFactura--;
                ultimoRegistroFactura.setNumeroFactura(numeroFactura);
                ultimoRegistroFactura.setFechaFactura(fechaFactura.minusMonths(1));
                FechaFinTextField.setText(fechaFactura.toString());
                numeroMesesSpinner.setValue(1);
            } else {
                new InicioFechaRegistroFacturaJTable(this).setVisible(true);
            }
        } else{
            JOptionPane.showMessageDialog(null, "Elige un arrendatario y un inmueble");
        }
    }//GEN-LAST:event_CrearFacturaButtonActionPerformed

    private void EliminarFacturaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarFacturaButtonActionPerformed
        int filaSeleccionada = RegistroFacturaTable.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idRegistroFacturaFilaSeleccionada = (int) RegistroFacturaTable.getValueAt(filaSeleccionada, 0);
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere eliminar la fila seleccionada con mayor número de factura y las superiores?", "Eliminar facturas", JOptionPane.YES_NO_OPTION) == 0) {
                ultimoRegistroFactura = DataBase.selectRegistroFacturasUltimaFechaFacturaFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
                LocalDate fechaFacturaInicial = (LocalDate) RegistroFacturaTable.getValueAt(filaSeleccionada, 2);
                DataBase.deleteRegistroFacturaByIdRegistroFactura(idRegistroFacturaFilaSeleccionada, ultimoRegistroFactura.getIdRegistroFactura());
                rellenarTablaRegistroFactura(DataBase.selectRegistroFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble()));
                ultimoRegistroFactura = DataBase.selectRegistroFacturasUltimaFechaFacturaFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
                FechaInicioTextField.setText(fechaFacturaInicial.toString());
                FechaFinTextField.setText(fechaFacturaInicial.toString());
                numeroMesesSpinner.setValue(1);
                if (RegistroFacturaTable.getRowCount() == 0) {
                    new InicioFechaRegistroFacturaJTable(this).setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");
        }
    }//GEN-LAST:event_EliminarFacturaButtonActionPerformed

    private void GenerarPDFFacturasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarPDFFacturasButtonActionPerformed
        if (InmuebleComboBox.getSelectedIndex() > 0) {
            GeneradorPDFFactura generador = factoriaFactura.metodoFactoria(arrendatario, inmueble, contrato);
            generador.crearCarpeta();
            if (!prueba) {
                int[] filasSeleccionadas = RegistroFacturaTable.getSelectedRows();
                String[] rutasDocumentos = new String[filasSeleccionadas.length];
                if (filasSeleccionadas.length != 0) {
                    for (int i = 0; i < filasSeleccionadas.length; i++) {
                        rutasDocumentos[i] = generador.crearPDF((int) RegistroFacturaTable.getValueAt(filasSeleccionadas[i], 1), (LocalDate) RegistroFacturaTable.getValueAt(filasSeleccionadas[i], 2));
                    }
                    generador.fusionarPDF(rutasDocumentos);
                } else {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");
                }
            } else {
                new InicioDatosFacturaPrueba(this, generador);
            }
        }
    }//GEN-LAST:event_GenerarPDFFacturasButtonActionPerformed

    private void ArrendatarioComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ArrendatarioComboBoxItemStateChanged
        limpiarRegistroFacturaTable();
        if (evt.getStateChange() == ItemEvent.SELECTED && ArrendatarioComboBox.getSelectedIndex() > 0) {
            arrendatario = (Arrendatario) ArrendatarioComboBox.getSelectedItem();
            rellenarInmuebleComboBox(DataBase.selectContratoJoinInmuebleByDniArrendatario(arrendatario.getDni()));
        } else if (ArrendatarioComboBox.getSelectedIndex() == 0) {
            InmuebleComboBox.removeAllItems();
            limpiarRegistroFacturaTable();
            FechaInicioTextField.setText("");
        }
        FechaFinTextField.setText("");
    }//GEN-LAST:event_ArrendatarioComboBoxItemStateChanged

    private void InmuebleComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_InmuebleComboBoxItemStateChanged
        if (InmuebleComboBox.getSelectedIndex() > 0 && evt.getStateChange() == ItemEvent.SELECTED) {
            inmueble = (Inmueble) InmuebleComboBox.getSelectedItem();
            ultimoRegistroFactura = DataBase.selectRegistroFacturasUltimaFechaFacturaFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
            rellenarTablaRegistroFactura(DataBase.selectRegistroFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble()));
            contrato = DataBase.selectContratoByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
            if (RegistroFacturaTable.getRowCount() != 0) {
                FechaInicioTextField.setText(ultimoRegistroFactura.getFechaFactura().plusMonths(1).toString());
                FechaFinTextField.setText(ultimoRegistroFactura.getFechaFactura().plusMonths((Integer) numeroMesesSpinner.getValue()).toString());
            } else {
                FechaInicioTextField.setText("");
                FechaFinTextField.setText("");
            }
        } else if (InmuebleComboBox.getSelectedIndex() == 0) {
            limpiarRegistroFacturaTable();
            FechaInicioTextField.setText("");
            FechaFinTextField.setText("");
        }
    }//GEN-LAST:event_InmuebleComboBoxItemStateChanged

    private void numeroMesesSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numeroMesesSpinnerStateChanged
        if (InmuebleComboBox.getSelectedIndex() > 0 && RegistroFacturaTable.getRowCount() != 0) {
            FechaFinTextField.setText(ultimoRegistroFactura.getFechaFactura().plusMonths((Integer) numeroMesesSpinner.getValue()).toString());
        }
    }//GEN-LAST:event_numeroMesesSpinnerStateChanged

    private void nuevoArrendatariojMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArrendatariojMenuItemActionPerformed
        setVisible(false);
        new NuevoArrendatario(this);
    }//GEN-LAST:event_nuevoArrendatariojMenuItemActionPerformed

    private void nuevoInmueblejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoInmueblejMenuItemActionPerformed
        setVisible(false);
        new NuevoInmueble(this);
    }//GEN-LAST:event_nuevoInmueblejMenuItemActionPerformed

    private void eliminarInmueblejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarInmueblejMenuItemActionPerformed
        setVisible(false);
        new EliminarInmueble(this);
    }//GEN-LAST:event_eliminarInmueblejMenuItemActionPerformed

    private void eliminarArrendatariojMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarArrendatariojMenuItemActionPerformed
        setVisible(false);
        new EliminarArrendatario(this);
    }//GEN-LAST:event_eliminarArrendatariojMenuItemActionPerformed

    private void nuevoContratoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoContratoMenuItemActionPerformed
        setVisible(false);
        new NuevoContrato(this);
    }//GEN-LAST:event_nuevoContratoMenuItemActionPerformed

    private void eliminarContratoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarContratoMenuItemActionPerformed
        setVisible(false);
        new EliminarContrato(this);
    }//GEN-LAST:event_eliminarContratoMenuItemActionPerformed

    private void ArchivoMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_ArchivoMenuSelected
        if (ArrendatarioComboBox.getItemCount() > 1) {
            ArrendatarioComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_ArchivoMenuSelected

    private void RegistroFacturaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroFacturaTableMouseClicked
        int filaSeleccionada = RegistroFacturaTable.rowAtPoint(evt.getPoint());
        int columnaSeleccionada = RegistroFacturaTable.columnAtPoint(evt.getPoint());
        if (evt.getClickCount() == 2) {
            int idRegistroFactura = (int) RegistroFacturaTable.getValueAt(filaSeleccionada, 0);
            setVisible(false);
            new VerCobros(this, idRegistroFactura, contrato, inmueble, configuracion);
        } else if (columnaSeleccionada == 3) {
            int idRegistroFactura = (int) RegistroFacturaTable.getValueAt(filaSeleccionada, 0);
            setVisible(false);
            new VerCobros(this, idRegistroFactura, contrato, inmueble, configuracion);
        } else if (columnaSeleccionada == 4) {
            int idRegistroFactura = (int) RegistroFacturaTable.getValueAt(filaSeleccionada, 0);
            boolean agua = (boolean) RegistroFacturaTable.getValueAt(filaSeleccionada, 4);
            DataBase.updateRegistroFacturaSetAguaWhereIdRegistroFactura(agua, idRegistroFactura);
        } else if (columnaSeleccionada == 5) {
            int idRegistroFactura = (int) RegistroFacturaTable.getValueAt(filaSeleccionada, 0);
            boolean luz = (boolean) RegistroFacturaTable.getValueAt(filaSeleccionada, 5);
            DataBase.updateRegistroFacturaSetLuzWhereIdRegistroFactura(luz, idRegistroFactura);
        }
    }//GEN-LAST:event_RegistroFacturaTableMouseClicked

    private void pruebajCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebajCheckBoxActionPerformed
        this.prueba = (Boolean) pruebajCheckBox.isSelected();
        factoriaFactura.setVersion(prueba);
    }//GEN-LAST:event_pruebajCheckBoxActionPerformed

    private void configuracionjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuracionjMenuItemActionPerformed
        setVisible(false);
        new MainFrame2(this);
    }//GEN-LAST:event_configuracionjMenuItemActionPerformed

    private void generarPDFFianzaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarPDFFianzaButtonActionPerformed
        if (InmuebleComboBox.getSelectedIndex() > 0 && (Integer) numeroMesesFianzajSpinner.getValue() > 0) {
            GeneradorPDFFianza generador = factoriaFianza.metodoFactoria(arrendatario, inmueble, contrato);
            generador.crearCarpeta();
            LocalDate fechaFianza = LocalDate.of(fianzaYearjYearChooser.getValue(), fianzaMesjMonthChooser.getMonth() + 1, 1);
            generador.crearPDF((Integer) numeroMesesFianzajSpinner.getValue(), fechaFianza);
            generador.abrirArchivo();
        } else {
            JOptionPane.showMessageDialog(null, "Introduzca un número de meses y elija un inmueble");
        }
    }//GEN-LAST:event_generarPDFFianzaButtonActionPerformed

    private void cobrosjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobrosjMenuItemActionPerformed
        setVisible(false);
        new InformeCobros(this);
    }//GEN-LAST:event_cobrosjMenuItemActionPerformed

    void rellenarTablaRegistroFactura(ArrayList<RegistroFactura> registroFacturas) {
        DefaultTableModel model = (DefaultTableModel) RegistroFacturaTable.getModel();
        model.setRowCount(0);
        for (RegistroFactura registroFactura : registroFacturas) {
            model.addRow(new Object[]{registroFactura.getIdRegistroFactura(), registroFactura.getNumeroFactura(), registroFactura.getFechaFactura(), registroFactura.isCobrado(), registroFactura.isAgua(), registroFactura.isLuz()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Archivo;
    private javax.swing.JComboBox ArrendatarioComboBox;
    private javax.swing.JLabel ArrendatarioLabel;
    private javax.swing.JButton CrearFacturaButton;
    private javax.swing.JButton EliminarFacturaButton;
    private javax.swing.JTextField FechaFinTextField;
    private javax.swing.JTextField FechaInicioTextField;
    private javax.swing.JButton GenerarPDFFacturasButton;
    private javax.swing.JComboBox<Inmueble> InmuebleComboBox;
    private javax.swing.JLabel InmuebleLabel;
    private javax.swing.JTable RegistroFacturaTable;
    private javax.swing.JMenu arrendatariojMenu;
    private javax.swing.JMenuItem cobrosjMenuItem;
    private javax.swing.JMenuItem configuracionjMenuItem;
    private javax.swing.JMenu contratojMenu;
    private javax.swing.JMenuItem eliminarArrendatariojMenuItem;
    private javax.swing.JMenuItem eliminarContratoMenuItem;
    private javax.swing.JMenu eliminarInmuebleMenu;
    private javax.swing.JMenuItem eliminarInmueblejMenuItem;
    private com.toedter.calendar.JMonthChooser fianzaMesjMonthChooser;
    private com.toedter.calendar.JYearChooser fianzaYearjYearChooser;
    private javax.swing.JButton generarPDFFianzaButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JMenuItem nuevoArrendatariojMenuItem;
    private javax.swing.JMenuItem nuevoContratoMenuItem;
    private javax.swing.JMenuItem nuevoInmueblejMenuItem;
    private javax.swing.JSpinner numeroMesesFianzajSpinner;
    private javax.swing.JSpinner numeroMesesSpinner;
    private javax.swing.JCheckBox pruebajCheckBox;
    // End of variables declaration//GEN-END:variables

    void rellenarArrendatarioComboBox(ArrayList<Arrendatario> arrendatarios) {
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

    private void ocultarColumna(JTable myTable, int numeroColumna) {
        myTable.getColumn(myTable.getColumnName(numeroColumna)).setWidth(0);
        myTable.getColumn(myTable.getColumnName(numeroColumna)).setMinWidth(0);
        myTable.getColumn(myTable.getColumnName(numeroColumna)).setMaxWidth(0);
    }

    private void configurarNumeroMesesSpinner() {
        SpinnerNumberModel nm = new SpinnerNumberModel();
        SpinnerNumberModel na = new SpinnerNumberModel();
        nm.setMinimum(1);
        na.setMinimum(0);
        nm.setValue(1);
        numeroMesesSpinner.setModel(nm);
        numeroMesesFianzajSpinner.setModel(na);
    }

    public JTextField getFechaInicioTextField() {
        return FechaInicioTextField;
    }

    private void limpiarRegistroFacturaTable() {
        DefaultTableModel model = (DefaultTableModel) RegistroFacturaTable.getModel();
        model.setRowCount(0);
    }

    public Arrendatario getArrendatario() {
        return arrendatario;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    private void configurarJTable() {
        JTableHeader th = RegistroFacturaTable.getTableHeader();
        Font fuente = new Font("Arial", Font.PLAIN, 20);
        th.setFont(fuente);
        RegistroFacturaTable.setRowHeight(25);
    }

    void setUltimoRegistroFactura(RegistroFactura ultimoRegistroFactura) {
        this.ultimoRegistroFactura = ultimoRegistroFactura;
    }

    public JTextField getFechaFinTextField() {
        return FechaFinTextField;
    }

    public int getNumeroMesesSpinner() {
        return (Integer) numeroMesesSpinner.getValue();
    }
   
}