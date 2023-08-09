/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import com.christopher.testexcel.Unidades;
import java.awt.Dialog;
import javax.swing.JDialog;

/**
 *
 * @author Chris
 */
import javax.swing.*;
import java.awt.Dialog;

// ...

class EditUnitDialog extends JDialog {
    private Unidades unidad;

    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JTextField descripcionTextField;
    private javax.swing.JLabel contenidosLabel;
    private javax.swing.JTextField contenidosTextField;
    private javax.swing.JButton saveButton;
    

    public EditUnitDialog(Unidades unidad) {
        this.unidad = unidad;
        initComponents();
    }

    private void initComponents() {
        setTitle("Editar Unidad");
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        descripcionLabel = new javax.swing.JLabel("Descripción:");
        descripcionTextField = new javax.swing.JTextField(unidad.getDescripcion());

        contenidosLabel = new javax.swing.JLabel("Contenidos:");
        contenidosTextField = new javax.swing.JTextField(unidad.getContenidos());

        saveButton = new javax.swing.JButton("Guardar");
        saveButton.addActionListener(this::saveButtonActionPerformed);
        

        // Diseño y disposición de componentes en el diálogo
        // Puedes utilizar un GroupLayout u otro layout de tu elección

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcionLabel)
                            .addComponent(contenidosLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(contenidosTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionLabel)
                    .addComponent(descripcionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contenidosLabel)
                    .addComponent(contenidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addContainerGap())
        );
        

        pack();
        setLocationRelativeTo(null); // Centrar el diálogo en la pantalla
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String newDescripcion = descripcionTextField.getText();
        String newContenidos = contenidosTextField.getText();

        unidad.setDescripcion(newDescripcion);
        unidad.setContenidos(newContenidos);

        dispose();
    }
    
}

