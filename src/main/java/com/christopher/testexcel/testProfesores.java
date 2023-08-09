/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christopher.testexcel;

import com.aspose.cells.Cell;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Chris
 */

public class testProfesores {
    public static void main(String[] args) throws Exception {
        Object valorCeldaId_profesor;
        Object valorCeldaProfesor_name;
        Object valorCeldaProfesor_usuario;
        Object valorCeldaProfesor_pass;
        Object valorCelda_cabecera;
        List<Profesores> profesoresList = new ArrayList<>();
        
        // Cargar archivo de Excel
        Workbook wb = new Workbook("Profesores_base.xlsx");

        // Obtener la hoja uno del libro
        Worksheet worksheet = wb.getWorksheets().get(0); // Hoja uno tiene el índice 0
        
        System.out.println("Profesores");
        int valor1 = 1;
        int valor2 =  2;
        
        
        
        do{
            Cell celdaCabecera = worksheet.getCells().get("A" + valor1);
            valorCelda_cabecera = celdaCabecera.getStringValue();
            Cell celdaId_profesor = worksheet.getCells().get("A" + valor2);
            valorCeldaId_profesor = celdaId_profesor.getStringValue();
            if(!(valorCeldaId_profesor.equals(""))){
                
                Cell celdaProfesor = worksheet.getCells().get("B" + valor2);
                valorCeldaProfesor_name = celdaProfesor.getStringValue();
                Cell celdaUsuario = worksheet.getCells().get("C" + valor2);
                valorCeldaProfesor_usuario = celdaUsuario.getStringValue();
                Cell celdaContrasena = worksheet.getCells().get("D" + valor2);
                valorCeldaProfesor_pass = celdaContrasena.getStringValue();

//                System.out.println("ProfesorId: " + valorCeldaId_profesor);
//                System.out.println("-Profesor: " + valorCeldaProfesor_name);
//                System.out.println("-Usuario profesor: " + valorCeldaProfesor_usuario);
//                System.out.println("-Usuario contrasena: " + valorCeldaProfesor_pass);
                
                
                Profesores profesor = new Profesores((String) valorCeldaId_profesor, (String) valorCeldaProfesor_name, (String) valorCeldaProfesor_usuario, (String) valorCeldaProfesor_pass);
                profesoresList.add(profesor);
                
            }
            valor1 += 1;
            valor2 += 1;
        }while (!valorCelda_cabecera.equals(""));
        
        for (Profesores profesor : profesoresList) {
            System.out.println("ProfesorId: " + profesor.getId_profesor());
            System.out.println("-Profesor: " + profesor.getProfesor());
            System.out.println("-Usuario profesor: " + profesor.getUsuario());
            System.out.println("-Usuario contrasena: " + profesor.getPass());
        }
    }
}