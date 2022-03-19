package view;

import auxiliar.MyLocalDate;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import model.Arrendatario;
import model.Contrato;
import model.Inmueble;
import model.RegistroFactura;
import model.diseno.factoria.FactoriaFactura;
import model.diseno.factura.GeneradorPDFFactura;
import persistence.DataBase;
import model.Configuracion;
import model.NotificationContract;
import model.diseno.factoria.FactoriaFianza;
import model.diseno.fianza.GeneradorPDFFianza;

/**
 *
 * @author Ignacio Reyes
 */
public class MainFrame extends javax.swing.JFrame {

    private Arrendatario arrendatario;
    private Inmueble inmueble;
    private Contrato contrato;
    private RegistroFactura ultimoRegistroFactura;
    private final FactoriaFactura factoriaFactura;
    private Configuracion configuracion;
    private Boolean noRecord;
    private final FactoriaFianza factoriaFianza;

    public MainFrame() {
        initComponents();
        configurateRecordJTable();
        ocultarColumna(recordFacturaJTable, 0);
        this.setLocationRelativeTo(null);
        setResizable(false);
        configurarNumeroMesesSpinner();
        setVisible(true);
        rellenarArrendatarioComboBox(DataBase.selectAllArendatarios());
        this.configuracion = DataBase.selectConfiguracion();
        factoriaFactura = new FactoriaFactura(false, configuracion);
        factoriaFianza = new FactoriaFianza();
        noRecord = false;
        notificationContractjTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        configurarteNotificationContractjTable();
        loadNotificationContract();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArrendatarioLabel = new javax.swing.JLabel();
        InmuebleLabel = new javax.swing.JLabel();
        ArrendatarioComboBox = new javax.swing.JComboBox<>();
        InmuebleComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        recordFacturaJTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        fianzaMesjMonthChooser = new com.toedter.calendar.JMonthChooser();
        fianzaYearjYearChooser = new com.toedter.calendar.JYearChooser();
        generarPDFFianzaButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        numeroMesesFianzajSpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        noRecordjCheckBox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        CrearFacturaButton = new javax.swing.JButton();
        FechaInicioTextField = new javax.swing.JTextField();
        FechaFinTextField = new javax.swing.JTextField();
        numeroMesesSpinner = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        EliminarFacturaButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        GenerarPDFFacturasButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        notificationContractjTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        nuevoArrendatariojMenuItem = new javax.swing.JMenuItem();
        eliminarArrendatariojMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        nuevoInmueblejMenuItem = new javax.swing.JMenuItem();
        eliminarInmueblejMenuItem = new javax.swing.JMenuItem();
        contratojMenu = new javax.swing.JMenu();
        nuevoContratoMenuItem = new javax.swing.JMenuItem();
        eliminarContratoMenuItem = new javax.swing.JMenuItem();
        cobrosjMenuItem = new javax.swing.JMenuItem();
        taxjMenuItem = new javax.swing.JMenuItem();
        contractModeljMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ArrendatarioLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ArrendatarioLabel.setText("Arrendatario");

        InmuebleLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        InmuebleLabel.setText("Inmueble");

        ArrendatarioComboBox.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ArrendatarioComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ArrendatarioComboBoxItemStateChanged(evt);
            }
        });

        InmuebleComboBox.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        InmuebleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                InmuebleComboBoxItemStateChanged(evt);
            }
        });

        recordFacturaJTable.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        recordFacturaJTable.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        recordFacturaJTable.setColumnSelectionAllowed(true);
        recordFacturaJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordFacturaJTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(recordFacturaJTable);
        recordFacturaJTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (recordFacturaJTable.getColumnModel().getColumnCount() > 0) {
            recordFacturaJTable.getColumnModel().getColumn(2).setCellRenderer(null);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fianzas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        fianzaMesjMonthChooser.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        generarPDFFianzaButton.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        generarPDFFianzaButton.setText("Generar Fianza");
        generarPDFFianzaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarPDFFianzaButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Fecha Inicio");

        numeroMesesFianzajSpinner.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Meses");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(numeroMesesFianzajSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(generarPDFFianzaButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fianzaMesjMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(fianzaYearjYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel4)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fianzaYearjYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fianzaMesjMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(numeroMesesFianzajSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generarPDFFianzaButton))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opción", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        noRecordjCheckBox.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        noRecordjCheckBox.setText("No registrar");
        noRecordjCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noRecordjCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(noRecordjCheckBox)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(noRecordjCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        CrearFacturaButton.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        CrearFacturaButton.setText("Crear Registros");
        CrearFacturaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearFacturaButtonActionPerformed(evt);
            }
        });

        FechaInicioTextField.setEditable(false);
        FechaInicioTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        FechaFinTextField.setEditable(false);
        FechaFinTextField.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        numeroMesesSpinner.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        numeroMesesSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numeroMesesSpinnerStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setText("Fecha Inicio");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel8.setText("Fecha Fin");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel9.setText("Número Registros");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        EliminarFacturaButton.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        EliminarFacturaButton.setText("Eliminar Registros");
        EliminarFacturaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarFacturaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EliminarFacturaButton)
                .addGap(118, 118, 118))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(EliminarFacturaButton)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(numeroMesesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(CrearFacturaButton))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FechaFinTextField)
                            .addComponent(FechaInicioTextField))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(FechaInicioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaFinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(numeroMesesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrearFacturaButton))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Factura", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16))); // NOI18N

        GenerarPDFFacturasButton.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        GenerarPDFFacturasButton.setText("Generar Facturas PDF");
        GenerarPDFFacturasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarPDFFacturasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GenerarPDFFacturasButton)
                .addGap(109, 109, 109))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(GenerarPDFFacturasButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        notificationContractjTable.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        notificationContractjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Arrendatario", "Inmueble", "Fecha vencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(notificationContractjTable);

        Archivo.setText("Archivo");
        Archivo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Archivo.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                ArchivoMenuSelected(evt);
            }
        });

        jMenu1.setText("Arrendatario");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        nuevoArrendatariojMenuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        nuevoArrendatariojMenuItem.setText("Nuevo");
        nuevoArrendatariojMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoArrendatariojMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoArrendatariojMenuItem);

        eliminarArrendatariojMenuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        eliminarArrendatariojMenuItem.setText("Eliminar");
        eliminarArrendatariojMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarArrendatariojMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(eliminarArrendatariojMenuItem);

        Archivo.add(jMenu1);

        jMenu2.setText("Inmueble");
        jMenu2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        nuevoInmueblejMenuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        nuevoInmueblejMenuItem.setText("Nuevo");
        nuevoInmueblejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoInmueblejMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(nuevoInmueblejMenuItem);

        eliminarInmueblejMenuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        eliminarInmueblejMenuItem.setText("Eliminar");
        eliminarInmueblejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarInmueblejMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(eliminarInmueblejMenuItem);

        Archivo.add(jMenu2);

        contratojMenu.setText("Contrato");
        contratojMenu.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        nuevoContratoMenuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        nuevoContratoMenuItem.setText("Nuevo");
        nuevoContratoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoContratoMenuItemActionPerformed(evt);
            }
        });
        contratojMenu.add(nuevoContratoMenuItem);

        eliminarContratoMenuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        eliminarContratoMenuItem.setText("Eliminar");
        eliminarContratoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarContratoMenuItemActionPerformed(evt);
            }
        });
        contratojMenu.add(eliminarContratoMenuItem);

        Archivo.add(contratojMenu);

        cobrosjMenuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cobrosjMenuItem.setText("Cobros");
        cobrosjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobrosjMenuItemActionPerformed(evt);
            }
        });
        Archivo.add(cobrosjMenuItem);

        taxjMenuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        taxjMenuItem.setText("Impuestos");
        taxjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxjMenuItemActionPerformed(evt);
            }
        });
        Archivo.add(taxjMenuItem);

        contractModeljMenuItem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        contractModeljMenuItem.setText("Modelos contrato");
        contractModeljMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contractModeljMenuItemActionPerformed(evt);
            }
        });
        Archivo.add(contractModeljMenuItem);

        jMenuBar1.add(Archivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ArrendatarioLabel)
                            .addComponent(InmuebleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InmuebleComboBox, 0, 1733, Short.MAX_VALUE)
                            .addComponent(ArrendatarioComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1373, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArrendatarioLabel)
                    .addComponent(ArrendatarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InmuebleLabel)
                    .addComponent(InmuebleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InmuebleComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_InmuebleComboBoxItemStateChanged
        if (InmuebleComboBox.getSelectedIndex() > 0 && evt.getStateChange() == ItemEvent.SELECTED) {
            inmueble = (Inmueble) InmuebleComboBox.getSelectedItem();
            ultimoRegistroFactura = DataBase.selectRegistroFacturasUltimaFechaFacturaFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
            rellenarTablaRegistroFactura(DataBase.selectRegistroFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble()));
            contrato = DataBase.selectContratoByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
            if (recordFacturaJTable.getRowCount() != 0) {
                FechaInicioTextField.setText(MyLocalDate.myToString(ultimoRegistroFactura.getFechaFactura().plusMonths(1)));
                FechaFinTextField.setText(MyLocalDate.myToString(ultimoRegistroFactura.getFechaFactura().plusMonths((Integer) numeroMesesSpinner.getValue())));
            } else {
                FechaInicioTextField.setText("");
                FechaFinTextField.setText("");
            }
        } else if (InmuebleComboBox.getSelectedIndex() == 0) {
            limpiarRegistroFacturaTable();
            FechaInicioTextField.setText("");
            FechaFinTextField.setText("");
        }    }//GEN-LAST:event_InmuebleComboBoxItemStateChanged

    private void recordFacturaJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordFacturaJTableMouseClicked
        int filaSeleccionada = recordFacturaJTable.rowAtPoint(evt.getPoint());
        int columnaSeleccionada = recordFacturaJTable.columnAtPoint(evt.getPoint());
        if (evt.getClickCount() == 2) {
            int idRegistroFactura = (int) recordFacturaJTable.getValueAt(filaSeleccionada, 0);
            setVisible(false);
            new VerCobros(this, idRegistroFactura, contrato, inmueble, configuracion);
        } else if (columnaSeleccionada == 3) {
            int idRegistroFactura = (int) recordFacturaJTable.getValueAt(filaSeleccionada, 0);
            setVisible(false);
            new VerCobros(this, idRegistroFactura, contrato, inmueble, configuracion);
        } else if (columnaSeleccionada == 4) {
            int idRegistroFactura = (int) recordFacturaJTable.getValueAt(filaSeleccionada, 0);
            boolean agua = (boolean) recordFacturaJTable.getValueAt(filaSeleccionada, 4);
            DataBase.updateRegistroFacturaSetAguaWhereIdRegistroFactura(agua, idRegistroFactura);
        } else if (columnaSeleccionada == 5) {
            int idRegistroFactura = (int) recordFacturaJTable.getValueAt(filaSeleccionada, 0);
            boolean luz = (boolean) recordFacturaJTable.getValueAt(filaSeleccionada, 5);
            DataBase.updateRegistroFacturaSetLuzWhereIdRegistroFactura(luz, idRegistroFactura);
        }    }//GEN-LAST:event_recordFacturaJTableMouseClicked

    private void numeroMesesSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numeroMesesSpinnerStateChanged
        if (InmuebleComboBox.getSelectedIndex() > 0 && recordFacturaJTable.getRowCount() != 0) {
            FechaFinTextField.setText(MyLocalDate.myToString(ultimoRegistroFactura.getFechaFactura().plusMonths((Integer) numeroMesesSpinner.getValue())));
        }    }//GEN-LAST:event_numeroMesesSpinnerStateChanged

    private void CrearFacturaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearFacturaButtonActionPerformed
        if (InmuebleComboBox.getSelectedIndex() > 0) {
            int numeroRegistroFacturasACrear = (Integer) numeroMesesSpinner.getValue();
            if (recordFacturaJTable.getRowCount() != 0) {
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
                FechaInicioTextField.setText(MyLocalDate.myToString(fechaFactura));
                numeroFactura--;
                ultimoRegistroFactura.setNumeroFactura(numeroFactura);
                ultimoRegistroFactura.setFechaFactura(fechaFactura.minusMonths(1));
                FechaFinTextField.setText(MyLocalDate.myToString(fechaFactura));
                numeroMesesSpinner.setValue(1);
            } else {
                new InicioFechaRegistroFacturaJTable(this).setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Elige un arrendatario y un inmueble");
        }
    }//GEN-LAST:event_CrearFacturaButtonActionPerformed

    private void EliminarFacturaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarFacturaButtonActionPerformed
        int filaSeleccionada = recordFacturaJTable.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idRegistroFacturaFilaSeleccionada = (int) recordFacturaJTable.getValueAt(filaSeleccionada, 0);
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere eliminar la fila seleccionada con mayor número de factura y las superiores?", "Eliminar facturas", JOptionPane.YES_NO_OPTION) == 0) {
                ultimoRegistroFactura = DataBase.selectRegistroFacturasUltimaFechaFacturaFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
                LocalDate fechaFacturaInicial = (LocalDate) recordFacturaJTable.getValueAt(filaSeleccionada, 2);
                DataBase.deleteRegistroFacturaByIdRegistroFactura(idRegistroFacturaFilaSeleccionada, ultimoRegistroFactura.getIdRegistroFactura());
                rellenarTablaRegistroFactura(DataBase.selectRegistroFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble()));
                ultimoRegistroFactura = DataBase.selectRegistroFacturasUltimaFechaFacturaFacturaByDniArrendatarioAndIdInmueble(arrendatario.getDni(), inmueble.getIdInmueble());
                FechaInicioTextField.setText(MyLocalDate.myToString(fechaFacturaInicial));
                FechaFinTextField.setText(MyLocalDate.myToString(fechaFacturaInicial));
                numeroMesesSpinner.setValue(1);
                if (recordFacturaJTable.getRowCount() == 0) {
                    new InicioFechaRegistroFacturaJTable(this).setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");
        }    }//GEN-LAST:event_EliminarFacturaButtonActionPerformed

    private void GenerarPDFFacturasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarPDFFacturasButtonActionPerformed
        if (InmuebleComboBox.getSelectedIndex() > 0) {
            GeneradorPDFFactura generador = factoriaFactura.metodoFactoria(arrendatario, inmueble, contrato);
            generador.crearCarpeta();
            if (!noRecord) {
                int[] filasSeleccionadas = recordFacturaJTable.getSelectedRows();
                String[] rutasDocumentos = new String[filasSeleccionadas.length];
                if (filasSeleccionadas.length != 0) {
                    for (int i = 0; i < filasSeleccionadas.length; i++) {
                        rutasDocumentos[i] = generador.crearPDF((int) recordFacturaJTable.getValueAt(filasSeleccionadas[i], 1), (LocalDate) recordFacturaJTable.getValueAt(filasSeleccionadas[i], 2));
                    }
                    generador.fusionarPDF(rutasDocumentos);
                } else {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");
                }
            } else {
                new InicioDatosFacturaPrueba(this, generador);
            }
        }    }//GEN-LAST:event_GenerarPDFFacturasButtonActionPerformed

    private void generarPDFFianzaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarPDFFianzaButtonActionPerformed
        if (InmuebleComboBox.getSelectedIndex() > 0 && (Integer) numeroMesesFianzajSpinner.getValue() > 0) {
            GeneradorPDFFianza generador = factoriaFianza.metodoFactoria(arrendatario, inmueble, contrato);
            generador.crearCarpeta();
            LocalDate fechaFianza = LocalDate.of(fianzaYearjYearChooser.getValue(), fianzaMesjMonthChooser.getMonth() + 1, 1);
            generador.crearPDF((Integer) numeroMesesFianzajSpinner.getValue(), fechaFianza);
            generador.abrirArchivo();
        } else {
            JOptionPane.showMessageDialog(null, "Introduzca un número de meses y elija un inmueble");
        }    }//GEN-LAST:event_generarPDFFianzaButtonActionPerformed

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
        FechaFinTextField.setText("");    }//GEN-LAST:event_ArrendatarioComboBoxItemStateChanged

    private void noRecordjCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noRecordjCheckBoxActionPerformed
        this.noRecord = (Boolean) noRecordjCheckBox.isSelected();
        factoriaFactura.setVersion(noRecord);
    }//GEN-LAST:event_noRecordjCheckBoxActionPerformed

    private void ArchivoMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_ArchivoMenuSelected
        if (ArrendatarioComboBox.getItemCount() > 1) {
            ArrendatarioComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_ArchivoMenuSelected

    private void eliminarContratoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarContratoMenuItemActionPerformed
        setVisible(false);
        new EliminarContrato(this);
    }//GEN-LAST:event_eliminarContratoMenuItemActionPerformed

    private void nuevoContratoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoContratoMenuItemActionPerformed
        setVisible(false);
        new NuevoContrato(this);
    }//GEN-LAST:event_nuevoContratoMenuItemActionPerformed

    private void eliminarInmueblejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarInmueblejMenuItemActionPerformed
        setVisible(false);
        new EliminarInmueble(this);
    }//GEN-LAST:event_eliminarInmueblejMenuItemActionPerformed

    private void nuevoInmueblejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoInmueblejMenuItemActionPerformed
        setVisible(false);
        new NuevoInmueble(this);
    }//GEN-LAST:event_nuevoInmueblejMenuItemActionPerformed

    private void eliminarArrendatariojMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarArrendatariojMenuItemActionPerformed
        setVisible(false);
        new EliminarArrendatario(this);
    }//GEN-LAST:event_eliminarArrendatariojMenuItemActionPerformed

    private void nuevoArrendatariojMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArrendatariojMenuItemActionPerformed
        setVisible(false);
        new NuevoArrendatario(this);
    }//GEN-LAST:event_nuevoArrendatariojMenuItemActionPerformed

    private void taxjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxjMenuItemActionPerformed
        setVisible(false);
        new view.Configuracion(this);
    }//GEN-LAST:event_taxjMenuItemActionPerformed

    private void contractModeljMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contractModeljMenuItemActionPerformed
        setVisible(false);
        new ModelosContrato(this);
    }//GEN-LAST:event_contractModeljMenuItemActionPerformed

    private void cobrosjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobrosjMenuItemActionPerformed
        setVisible(false);
        new InformeCobros(this);
    }//GEN-LAST:event_cobrosjMenuItemActionPerformed

    void rellenarTablaRegistroFactura(ArrayList<RegistroFactura> registroFacturas) {
        DefaultTableModel model = (DefaultTableModel) recordFacturaJTable.getModel();
        model.setRowCount(0);
        for (RegistroFactura registroFactura : registroFacturas) {
            model.addRow(new Object[]{registroFactura.getIdRegistroFactura(), registroFactura.getNumeroFactura(), registroFactura.getFechaFactura(), registroFactura.isCobrado(), registroFactura.isAgua(), registroFactura.isLuz()});
        }
    }

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
        DefaultTableModel model = (DefaultTableModel) recordFacturaJTable.getModel();
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

    private void configurateRecordJTable() {
        JTableHeader th = recordFacturaJTable.getTableHeader();
        Font fuente = new Font("Arial", Font.PLAIN, 20);
        th.setFont(fuente);
        recordFacturaJTable.setRowHeight(25);
        recordFacturaJTable.getColumnModel().getColumn(2).setCellRenderer(new DateRenderer());
        DefaultTableCellRenderer alignment = new DefaultTableCellRenderer();
        alignment.setHorizontalAlignment(SwingConstants.CENTER);
        recordFacturaJTable.getColumnModel().getColumn(1).setCellRenderer(alignment);
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

    private void loadNotificationContract() {
        DefaultTableModel model = (DefaultTableModel) notificationContractjTable.getModel();
        model.setRowCount(0);
        ArrayList<NotificationContract> notificationContracts = DataBase.selectAllNotificationExpirationContractsOrderByFechaExpiracion();
        for (NotificationContract notificationContract : notificationContracts) {
            model.addRow(new Object[]{notificationContract.getLessee(), notificationContract.getProperty(), notificationContract.getExpirationDate()});
        }
    }

    private void configurarteNotificationContractjTable() {
        JTableHeader th = notificationContractjTable.getTableHeader();
        Font fuente = new Font("Arial", Font.PLAIN, 20);
        th.setFont(fuente);
        notificationContractjTable.setRowHeight(25);
        notificationContractjTable.setDefaultRenderer(Object.class, new NotificationContractJTableCellRenderer());
        notificationContractjTable.getColumnModel().getColumn(2).setCellRenderer(new DateRenderer());
    }

    private class NotificationContractJTableCellRenderer extends JLabel implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (((LocalDate) table.getModel().getValueAt(row, 2)).isBefore(LocalDate.now())) {
                setForeground(Color.RED);
            } else {
                setForeground(Color.BLACK);
            }
            setText(String.valueOf(value));
            setFont(new Font("Arial", Font.PLAIN, 20));
            return this;
        }
    }

    private class DateRenderer extends JLabel implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(MyLocalDate.myToString((LocalDate) value));
            setFont(new Font("Arial", Font.PLAIN, 20));
            setHorizontalAlignment(SwingConstants.CENTER);
            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Archivo;
    private javax.swing.JComboBox<String> ArrendatarioComboBox;
    private javax.swing.JLabel ArrendatarioLabel;
    private javax.swing.JButton CrearFacturaButton;
    private javax.swing.JButton EliminarFacturaButton;
    private javax.swing.JTextField FechaFinTextField;
    private javax.swing.JTextField FechaInicioTextField;
    private javax.swing.JButton GenerarPDFFacturasButton;
    private javax.swing.JComboBox<String> InmuebleComboBox;
    private javax.swing.JLabel InmuebleLabel;
    private javax.swing.JMenuItem cobrosjMenuItem;
    private javax.swing.JMenuItem contractModeljMenuItem;
    private javax.swing.JMenu contratojMenu;
    private javax.swing.JMenuItem eliminarArrendatariojMenuItem;
    private javax.swing.JMenuItem eliminarContratoMenuItem;
    private javax.swing.JMenuItem eliminarInmueblejMenuItem;
    private com.toedter.calendar.JMonthChooser fianzaMesjMonthChooser;
    private com.toedter.calendar.JYearChooser fianzaYearjYearChooser;
    private javax.swing.JButton generarPDFFianzaButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox noRecordjCheckBox;
    private javax.swing.JTable notificationContractjTable;
    private javax.swing.JMenuItem nuevoArrendatariojMenuItem;
    private javax.swing.JMenuItem nuevoContratoMenuItem;
    private javax.swing.JMenuItem nuevoInmueblejMenuItem;
    private javax.swing.JSpinner numeroMesesFianzajSpinner;
    private javax.swing.JSpinner numeroMesesSpinner;
    private javax.swing.JTable recordFacturaJTable;
    private javax.swing.JMenuItem taxjMenuItem;
    // End of variables declaration//GEN-END:variables
}
