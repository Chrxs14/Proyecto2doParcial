/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import com.aspose.cells.Cell;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.christopher.testexcel.AlarmManager;
import com.christopher.testexcel.Session;
import com.christopher.testexcel.Unidades;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Home extends javax.swing.JFrame {
    int xMouse, yMouse;
    private Session userLogin;
    private horariosPanel horariosContentPanel;
    private materiasPanel materiasContentPanel;
    private Object valorCeldasUnidad;
    private Object valorCeldasContenido;
    private Object valorCeldasFecha;
    private Date fechaUnidad = null;

    private Object valorCeldasACD;
    private Object valorCeldasACDactividad;
    private Object valorCeldasACDtiempo;
    private Object valorCeldasACDevaluacion;

    private Object valorCeldasAPE;
    private Object valorCeldasAPEactividad;
    private Object valorCeldasAPEtiempo;
    private Object valorCeldasAPEevaluacion;

    private Object valorCeldasAA;
    private Object valorCeldasAAactividad;
    private Object valorCeldasAAtiempo;
    private Object valorCeldasAAevaluacion;
    
    private AlarmManager alarmManager;
    private Timer alarmTimer;

    private List<Unidades> listaUnidades = new ArrayList<>();
    
    Workbook wb = null;
    

    /**
     * Creates new form Home
     * @param userLogin
     * @param profesorList
     */
    public Home() {        
        initComponents();
        SetImageLabel(closeLabel, "src/main/java/Assets/close.png");
        
        
        horariosContentPanel = new horariosPanel();
        horariosContentPanel.setSize(880, 550);
        horariosContentPanel.setLocation(200, 80);
        
        materiasContentPanel = new materiasPanel();
        materiasContentPanel.setSize(880, 550);
        materiasContentPanel.setLocation(200, 80);
        alarmManager = new AlarmManager();
        initializeAlarmTimer();
        
    }
    
    private void initializeAlarmTimer() {
        int delay = 15 * 1000; // Verificar cada minuto (ajusta según tus necesidades)
        alarmTimer = new Timer(delay, e -> checkForDueActivities());
        alarmTimer.start();
    }
    
    private void checkForDueActivities() {
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DAY_OF_MONTH, 1); // Agrega 1 día a la fecha actual

        for (Unidades unidad : listaUnidades) {
            if (unidad.isReminderActive() && unidad.getFecha() != null) {
                // Verificar si la fecha de la unidad está a un día de distancia
                Calendar dueDate = Calendar.getInstance();
                dueDate.setTime(unidad.getFecha());

                if (dueDate.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                    dueDate.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
                    dueDate.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)) {
                    // Mostrar mensaje de notificación en la consola
                    System.out.println("¡Recordatorio! La actividad está programada para mañana: " + unidad.getDescripcion());

                    // Mostrar mensaje emergente
                    String message = "¡Recordatorio! La actividad está programada para mañana:\n" + unidad.getContenidos();
                    javax.swing.JOptionPane.showMessageDialog(this, message, "Recordatorio", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    
    private void SetImageLabel(JLabel labelName, String root){
         ImageIcon image = new ImageIcon(root);
         Icon icon  = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
         labelName.setIcon(icon);
         this.repaint();
    }   
    private class UnitDisplayPanel extends JPanel {
        public UnitDisplayPanel(Unidades unidad) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(154, 138, 189), 2));
            setBackground(new java.awt.Color(154, 138, 189)); // Set the background color
            
            JLabel unitLabel = new JLabel("<html><b>Unidad:</b> " + unidad.getDescripcion() + "</html>");
            JLabel contentLabel = new JLabel("<html><b>Contenido:</b> " + unidad.getContenidos() + "</html>");
            JLabel dateLabel = new JLabel("<html><b>Fecha:</b> " + unidad.getFormattedDate() + "</html>");
            
            unitLabel.setFont(new java.awt.Font("Gadugi", 1, 18));
            contentLabel.setFont(new java.awt.Font("Gadugi", 0, 16));
            dateLabel.setFont(new java.awt.Font("Gadugi", 0, 16));
            unitLabel.setForeground(Color.WHITE); // Set text color to white
            contentLabel.setForeground(Color.WHITE); // Set text color to white
            dateLabel.setForeground(Color.WHITE); // Set text color to white
            unitLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 0));
            contentLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
            dateLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 0));
            
            JButton editButton = new JButton("Editar");
            editButton.addActionListener(e -> {
            // Abre un cuadro de diálogo de edición
            EditUnitDialog editDialog = new EditUnitDialog(unidad);


            editDialog.setVisible(true);

            // Actualiza la visualización de la unidad después de la edición
            unitLabel.setText("<html><b>Unidad:</b> " + unidad.getDescripcion() + "</html>");
            contentLabel.setText("<html><b>Contenido:</b> " + unidad.getContenidos() + "</html>");
            dateLabel.setText("<html><b>Fecha:</b> " + unidad.getFormattedDate() + "</html>");
        });

        add(editButton);
            
            add(unitLabel);
            add(contentLabel);
            add(dateLabel);
            
        }
    }
    
    private JPanel createUnitPanel(Unidades unidad) {
        JPanel unitPanel = new UnitDisplayPanel(unidad);
        // Bloquea el botón "Editar" si la fecha de la unidad ya ha pasado
        Date currentDate = new Date();
        if (unidad.getFecha().before(currentDate)) {
            for (Component component : unitPanel.getComponents()) {
                if (component instanceof JButton && ((JButton) component).getText().equals("Editar")) {
                    ((JButton) component).setEnabled(false);
                    break; // No es necesario seguir buscando más botones "Editar"
                }
            }
        }

        // Add activity details
        for (Unidades.Actividad actividad : unidad.getActividadesDeAprendizaje()) {
            JLabel activityLabel = new JLabel("Actividad: " + actividad.getTipoDeActividad());
            JLabel activityDetailsLabel = new JLabel("- " + actividad.getActividad());
            JLabel timeLabel = new JLabel("Tiempo: " + actividad.getTiempo() + " hora(s)");
            JLabel evaluationLabel = new JLabel("Evaluación: " + actividad.getEvaluacion());

            unitPanel.add(activityLabel);
            unitPanel.add(activityDetailsLabel);
            unitPanel.add(timeLabel);
            unitPanel.add(evaluationLabel);
        }
        JCheckBox reminderCheckbox = new JCheckBox("Recordatorio");
        reminderCheckbox.setSelected(unidad.isReminderActive());
        reminderCheckbox.addActionListener(e -> {
            boolean isChecked = reminderCheckbox.isSelected();
            unidad.setReminderActive(isChecked);
        });
        unitPanel.add(reminderCheckbox);

        return unitPanel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homePanel = new javax.swing.JPanel();
        toolBarPanel = new javax.swing.JPanel();
        logOutLabel = new javax.swing.JLabel();
        LogoSap = new javax.swing.JLabel();
        btnCursos = new javax.swing.JLabel();
        btnHorarios = new javax.swing.JLabel();
        topBar = new javax.swing.JPanel();
        closeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelActivities = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelBusqueda = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        buscarPorFecha = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setLocationByPlatform(true);
        setName("Home"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homePanel.setBackground(new java.awt.Color(240, 233, 255));
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toolBarPanel.setBackground(new java.awt.Color(154, 138, 189));
        toolBarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        toolBarPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        toolBarPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                toolBarPanelMouseDragged(evt);
            }
        });
        toolBarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toolBarPanelMousePressed(evt);
            }
        });
        toolBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutLabel.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        logOutLabel.setForeground(new java.awt.Color(255, 255, 255));
        logOutLabel.setText("Log out");
        toolBarPanel.add(logOutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, -1, -1));

        LogoSap.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        LogoSap.setForeground(new java.awt.Color(255, 255, 255));
        LogoSap.setText("SAP");
        toolBarPanel.add(LogoSap, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 70, -1));

        btnCursos.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        btnCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnCursos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCursos.setText("Paralelo");
        btnCursos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCursosMouseClicked(evt);
            }
        });
        toolBarPanel.add(btnCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 160, 60));

        btnHorarios.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        btnHorarios.setForeground(new java.awt.Color(255, 255, 255));
        btnHorarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHorarios.setText("Horarios");
        btnHorarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHorariosMouseClicked(evt);
            }
        });
        toolBarPanel.add(btnHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 160, 70));

        topBar.setBackground(new java.awt.Color(154, 138, 189));
        topBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 233, 255), 2));
        topBar.setPreferredSize(new java.awt.Dimension(200, 200));
        topBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topBarMouseDragged(evt);
            }
        });
        topBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topBarMousePressed(evt);
            }
        });
        topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chris\\Desktop\\Proyecto Ecturas de datos\\testExcel\\src\\main\\java\\Assets\\close.png")); // NOI18N
        closeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeLabelMousePressed(evt);
            }
        });
        topBar.add(closeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, -1, 50));

        toolBarPanel.add(topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 70));

        homePanel.add(toolBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 70));

        jScrollPane1.setBackground(new java.awt.Color(154, 138, 189));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(192, 177, 224));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelActivities.setBackground(new java.awt.Color(154, 138, 189));
        jScrollPane2.setViewportView(panelActivities);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 640, 460));

        panelBusqueda.setBackground(new java.awt.Color(154, 138, 189));
        jScrollPane3.setViewportView(panelBusqueda);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 360, 400));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 90, -1));

        buscarPorFecha.setText("buscar");
        buscarPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorFechaActionPerformed(evt);
            }
        });
        jPanel1.add(buscarPorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 35, -1, 30));

        jScrollPane1.setViewportView(jPanel1);

        homePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 1070, 500));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Subir plan analitico: ");
        homePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jButton1.setBackground(new java.awt.Color(154, 138, 189));
        jButton1.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jButton1.setText("Subir archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        homePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 150, 40));

        getContentPane().add(homePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeLabelMouseClicked

    private void toolBarPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolBarPanelMouseDragged
        
    }//GEN-LAST:event_toolBarPanelMouseDragged

    private void toolBarPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolBarPanelMousePressed

    }//GEN-LAST:event_toolBarPanelMousePressed

    private void closeLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMousePressed
        System.exit(0);
    }//GEN-LAST:event_closeLabelMousePressed

    private void topBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);        
    }//GEN-LAST:event_topBarMouseDragged

    private void topBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBarMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();       
    }//GEN-LAST:event_topBarMousePressed

    private void btnHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorariosMouseClicked
        
    }//GEN-LAST:event_btnHorariosMouseClicked

    private void btnCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCursosMouseClicked
     
    }//GEN-LAST:event_btnCursosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JFileChooser fileChooser = new JFileChooser();

        // Filtrar solo archivos con extensión XLSX (Excel)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel", "xlsx");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            java.io.File selectedFile = fileChooser.getSelectedFile();

            // Verificar si la extensión del archivo es XLSX
            if (selectedFile.getName().endsWith(".xlsx")) {
                try {
                    System.out.println("Archivo Excel seleccionado: " + selectedFile.getName());
                    
                    // Cargar archivo de Excel
                    wb = new Workbook(selectedFile.getName());
                    
                    // Obtener la hoja uno del libro
                    Worksheet worksheet = wb.getWorksheets().get(0); // Hoja uno tiene el índice 0
                    
                    System.out.println("Unidades");
                    int valor1 = 3;
                    int valor2 = 4;
                    
                    int valor3 = 5;
                    int valor4 = 6;
                    
                    int valor5 = 7;
                    int valor6 = 8;
                    
                    do{
                        Cell celdaUnidad = worksheet.getCells().get("A" + valor1);
                        valorCeldasUnidad = celdaUnidad.getStringValue();
                        if(!(valorCeldasUnidad.equals(""))){
                            
                            Cell celdaContenido = worksheet.getCells().get("B" + valor1);
                            valorCeldasContenido = celdaContenido.getStringValue();
                            Cell celdaFecha = worksheet.getCells().get("F" + valor1);
                            valorCeldasFecha = celdaFecha.getStringValue();
                            fechaUnidad = new SimpleDateFormat("dd/MM/yyyy").parse((String)valorCeldasFecha);
                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            String formattedDate = dateFormat.format(fechaUnidad);
                            
                            //Aprendizaje en Contacto con el Docente-----------------------------------------
                            Cell celdaACD = worksheet.getCells().get("C" + valor1);
                            valorCeldasACD = celdaACD.getStringValue();
                            
                            //actividad
                            Cell celdaACDactividad = worksheet.getCells().get("C" + valor2);
                            valorCeldasACDactividad = celdaACDactividad.getStringValue();
                            //tiempo de la actividad
                            Cell celdaACDtiempo = worksheet.getCells().get("D" + valor2);
                            valorCeldasACDtiempo = celdaACDtiempo.getStringValue();
                            //evaluacion
                            Cell celdaACDevaluacion = worksheet.getCells().get("E" + valor2);
                            valorCeldasACDevaluacion = celdaACDevaluacion.getStringValue();
                            
                            //Aprendizaje práctico experimental-----------------------------------------
                            
                            Cell celdaAPE = worksheet.getCells().get("C" + valor3);
                            valorCeldasAPE = celdaAPE.getStringValue();
                            
                            //actividad
                            Cell celdaAPEactividad = worksheet.getCells().get("C" + valor4);
                            valorCeldasAPEactividad = celdaAPEactividad.getStringValue();
                            
                            //tiempo de la actividad
                            Cell celdaAPEtiempo = worksheet.getCells().get("D" + valor4);
                            valorCeldasAPEtiempo = celdaAPEtiempo.getStringValue();
                            
                            //evaluacion
                            Cell celdaAPEevaluacion = worksheet.getCells().get("E" + valor4);
                            valorCeldasAPEevaluacion = celdaAPEevaluacion.getStringValue();
                            
                            //Aprendizaje autónomo-----------------------------------------
                            
                            Cell celdaAA = worksheet.getCells().get("C" + valor5);
                            valorCeldasAA = celdaAA.getStringValue();
                            
                            //actividad
                            Cell celdaAAactividad = worksheet.getCells().get("C" + valor6);
                            valorCeldasAAactividad = celdaAAactividad.getStringValue();
                            
                            //tiempo de la actividad
                            Cell celdaAAtiempo = worksheet.getCells().get("D" + valor6);
                            valorCeldasAAtiempo = celdaAAtiempo.getStringValue();
                            
                            //evaluacion
                            Cell celdaAAevaluacion = worksheet.getCells().get("E" + valor6);
                            valorCeldasAAevaluacion = celdaAAevaluacion.getStringValue();
                            
                            
                            //Generar una instancia de la clase Unidad
                            List<Unidades.Actividad> actividadesDeAprendizaje = new ArrayList<>();
                            actividadesDeAprendizaje.add(new Unidades.Actividad((String)valorCeldasACD, (String) valorCeldasACDactividad, (String) valorCeldasACDtiempo, (String) valorCeldasACDevaluacion));
                            actividadesDeAprendizaje.add(new Unidades.Actividad((String)valorCeldasAPE, (String) valorCeldasAPEactividad, (String) valorCeldasAPEtiempo, (String) valorCeldasAPEevaluacion));
                            actividadesDeAprendizaje.add(new Unidades.Actividad((String)valorCeldasAA, (String) valorCeldasAAactividad, (String) valorCeldasAAtiempo, (String) valorCeldasAAevaluacion));
                            
                            
                            Unidades unidad = new Unidades(
                                    (String) valorCeldasUnidad, (String) valorCeldasContenido,
                                    actividadesDeAprendizaje, fechaUnidad, formattedDate);
                            listaUnidades.add(unidad);
                            
                        }
                        valor1 += 6;
                        valor2 += 6;
                        valor3 += 6;
                        valor4 += 6;
                        valor5 += 6;
                        valor6 += 6;
                    }while (!valorCeldasUnidad.equals(""));
                    
                    // Ahora la listaUnidades contiene todas las instancias de Unidades creadas en el bucle
                    
                    // Puedes consultar los datos de las unidades almacenadas en la lista
                    for (Unidades unidad : listaUnidades) {
                        System.out.println("Nombre de la Unidad: " + unidad.getDescripcion());
                        System.out.println("Contenido de la Unidad: " + unidad.getContenidos());
                        System.out.println("Fecha de la Unidad: " + unidad.getFormattedDate());
                        
                        System.out.println("Actividades de la Unidad:");
                        
                        for (Unidades.Actividad actividad : unidad.getActividadesDeAprendizaje()) {
                            if(actividad.getActividad().equals("")){
                                System.out.println(" Tipo de Actividad: " + actividad.getTipoDeActividad());
                                System.out.println("- No hay actividad asignada" );
                                System.out.println("  Tiempo: " + actividad.getTiempo() + " hora(s)");
                                System.out.println("  Evaluación: ---");
                            }else{
                                System.out.println(" Tipo de Actividad: " + actividad.getTipoDeActividad());
                                System.out.println("- " + actividad.getActividad());
                                System.out.println("  Tiempo: " + actividad.getTiempo() + " hora(s)");
                                
                                if (actividad.getEvaluacion().startsWith("Tarea") || actividad.getEvaluacion().startsWith("Taller")) {
                                    System.out.println(actividad.getEvaluacion());
                                } else {
                                    System.out.println("  Evaluación: " + actividad.getEvaluacion());
                                }
                            }
                        }
                        
                        System.out.println();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "El archivo seleccionado no es un archivo de excel ");
            }
        }
        panelActivities.setLayout(new BoxLayout(panelActivities, BoxLayout.Y_AXIS));

        panelActivities.removeAll();
        panelActivities.revalidate();
        panelActivities.repaint();

        // Create and add unit panels
        for (Unidades unidad : listaUnidades) {
            JPanel unitPanel = createUnitPanel(unidad);
            panelActivities.add(unitPanel);

            // Add vertical glue for spacing
            panelActivities.add(Box.createVerticalGlue());
        }

        // Update the scroll pane
        jScrollPane2.setViewportView(panelActivities);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscarPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorFechaActionPerformed
           Date selectedDate = jDateChooser1.getDate();

    if (selectedDate != null) {
        panelBusqueda.removeAll();
        panelBusqueda.revalidate();
        panelBusqueda.repaint();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedSelectedDate = dateFormat.format(selectedDate);

        for (Unidades unidad : listaUnidades) {
            if (unidad.getFormattedDate().equals(formattedSelectedDate)) {
                JPanel unitPanel = createUnitPanel(unidad);
                panelBusqueda.add(unitPanel);
                panelBusqueda.add(Box.createVerticalGlue());
            }
        }

        // Update the scroll pane
        jScrollPane3.setViewportView(panelBusqueda);
    }
    }//GEN-LAST:event_buscarPorFechaActionPerformed


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoSap;
    private javax.swing.JLabel btnCursos;
    private javax.swing.JLabel btnHorarios;
    private javax.swing.JButton buscarPorFecha;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logOutLabel;
    private javax.swing.JPanel panelActivities;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel toolBarPanel;
    private javax.swing.JPanel topBar;
    // End of variables declaration//GEN-END:variables
}
