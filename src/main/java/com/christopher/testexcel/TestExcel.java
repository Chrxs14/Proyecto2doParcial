package com.christopher.testexcel;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.Cell;
import com.christopher.testexcel.Unidades.Actividad;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExcel {
    
    public static void main(String[] args) throws Exception {
        Object valorCeldasUnidad;
        Object valorCeldasContenido;
        Object valorCeldasFecha;
        Date fechaUnidad = null;
        
        Object valorCeldasACD;
        Object valorCeldasACDactividad;
        Object valorCeldasACDtiempo;
        Object valorCeldasACDevaluacion;
        
        Object valorCeldasAPE;
        Object valorCeldasAPEactividad;
        Object valorCeldasAPEtiempo;
        Object valorCeldasAPEevaluacion;
        
        Object valorCeldasAA;
        Object valorCeldasAAactividad;
        Object valorCeldasAAtiempo;
        Object valorCeldasAAevaluacion;
        
        List<Unidades> listaUnidades = new ArrayList<>();
        
        // Cargar archivo de Excel
        Workbook wb = new Workbook("SOF-S-MA-3-2-signed-3-8.xlsx");

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

                
//                System.out.println("Titulo de unidades: \n**" + valorCeldasUnidad);
//                System.out.println("Contenido de la unindad: \n****" + valorCeldasContenido);
//                System.out.println("Fecha estimada para presentacion de Unidad: " + fechaUnidad);
                
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
                
                /**
                 * 
                 * Nombres de las variables usadas en Aprendizaje en contacto con el docente
                 * valorCeldasACD -- Aprendizaje en contacto con el docente
                 * valorCeldasACDactividad -- Actividad asignada 
                 * valorCeldasACDtiempo --  tiempo asignado a la actividad
                 * valorCeldasACDevaluacion -- evaluacion respecto a la actividad
                 * 
                */
                
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
                
                /**
                 * 
                 * Nombres de las variables usadas en Aprendizaje practico experimental
                 * valorCeldasAPE -- Aprendizaje practico experimental
                 * valorCeldasAPEactividad -- Actividad asignada 
                 * valorCeldasAPEtiempo --  tiempo asignado a la actividad
                 * valorCeldasAPEevaluacion -- evaluacion respecto a la actividad
                 * 
                */
                
                
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
                
                /**
                 * 
                 * Nombres de las variables usadas en Aprendizaje autonomo
                 * valorCeldasAA -- Aprendizaje Autonomo
                 * valorCeldasAAactividad -- Actividad asignada 
                 * valorCeldasAAtiempo --  tiempo asignado a la actividad
                 * valorCeldasAAevaluacion -- evaluacion respecto a la actividad
                 * 
                */
                
                
                //Generar una instancia de la clase Unidad
                Map<String, Actividad> actividadesDeAprendizaje = new HashMap<>();
                actividadesDeAprendizaje.put("actividadACD", new Actividad((String) valorCeldasACDactividad, (String) valorCeldasACDtiempo, (String) valorCeldasACDevaluacion));
                actividadesDeAprendizaje.put("actividadAPE", new Actividad((String) valorCeldasAPEactividad, (String) valorCeldasAPEtiempo, (String) valorCeldasAPEevaluacion));
                actividadesDeAprendizaje.put("actividadAA", new Actividad((String) valorCeldasAAactividad, (String) valorCeldasAAtiempo, (String) valorCeldasAAevaluacion));
                
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
            System.out.println("Fecha de la Unidad: " + unidad.getformattedDate());

            System.out.println("Actividades de la Unidad:");
            for (Unidades.Actividad actividad : unidad.getActividadesDeAprendizaje().values()) {
                if(actividad.getActividad().equals("")){
                    System.out.println("- No hay actividad asignada" );
                    System.out.println("  Tiempo: " + actividad.getTiempo() + " hora(s)");
                    System.out.println("  Evaluación: ---");
                }else{
                    System.out.println("- " + actividad.getActividad());
                    System.out.println("  Tiempo: " + actividad.getTiempo() + " hora(s)");
                    System.out.println("  Evaluación: " + actividad.getEvaluacion());
                }
            }

            System.out.println();
        }
    }
}
