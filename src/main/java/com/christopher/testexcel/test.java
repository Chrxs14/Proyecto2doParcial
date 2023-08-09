/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christopher.testexcel;

/**
 *
 * @author Chris
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class test extends JFrame {
    private JPanel generalPanel;
    private JButton createButton;
    private JPanel panelsContainer;
    private int panelCount = 0;

    public test() {
        setTitle("Panel Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        generalPanel = new JPanel();
        generalPanel.setLayout(new BorderLayout());

        createButton = new JButton("Crear");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewPanel();
            }
        });

        panelsContainer = new JPanel();
        panelsContainer.setLayout(new BoxLayout(panelsContainer, BoxLayout.Y_AXIS));
        panelsContainer.setAlignmentX(Component.RIGHT_ALIGNMENT);  // Alinea los paneles a la derecha


        generalPanel.add(createButton, BorderLayout.NORTH);
        generalPanel.add(new JScrollPane(panelsContainer), BorderLayout.CENTER);

        add(generalPanel);
    }

    private void createNewPanel() {
        TextEntryForm textEntryForm = new TextEntryForm(this);
        textEntryForm.setVisible(true);
    }
    private void addNewPanelWithText(String text) {
        panelCount++;
        JPanel newPanel = new JPanel();
        newPanel.setBorder(BorderFactory.createTitledBorder("Panel " + panelCount));
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.X_AXIS));

        JLabel label = new JLabel(text);  // Usa el texto ingresado en el formulario
        newPanel.add(label);

        panelsContainer.add(newPanel);
        panelsContainer.revalidate();
        panelsContainer.repaint();
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                test mainFrame = new test();
                mainFrame.setVisible(true);
            }
        });
    }
    class TextEntryForm extends JDialog {
        private JTextArea textArea;
        private JButton confirmButton;

        public TextEntryForm(JFrame parent) {
            super(parent, "Ingresar Texto", true);
            setSize(300, 200);
            setLocationRelativeTo(parent);

            textArea = new JTextArea(5, 20);
            confirmButton = new JButton("Confirmar");

            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String enteredText = textArea.getText();
                    addNewPanelWithText(enteredText);
                    dispose();  // Cierra la ventana emergente
                }
            });

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
            panel.add(confirmButton, BorderLayout.SOUTH);

            add(panel);
        }
        

    }
    

    
}
