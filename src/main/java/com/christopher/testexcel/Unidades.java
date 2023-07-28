/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christopher.testexcel;

/**
 *
 * @author Chris
 */
import java.util.HashMap;
import java.util.Map;

public class Unidades {
    private String descripcion;
    private String contenidos;
    private Map<String, Actividad> actividadesDeAprendizaje;
    private String fecha;

    public Unidades(String descripcion, String contenidos, Map<String, Actividad> actividadesDeAprendizaje, String fecha) {
        this.descripcion = descripcion;
        this.contenidos = contenidos;
        this.actividadesDeAprendizaje = actividadesDeAprendizaje;
        this.fecha = fecha;
    }

    // Getters y setters para acceder a las propiedades

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenidos() {
        return contenidos;
    }

    public void setContenidos(String contenidos) {
        this.contenidos = contenidos;
    }

    public Map<String, Actividad> getActividadesDeAprendizaje() {
        return actividadesDeAprendizaje;
    }

    public void setActividadesDeAprendizaje(Map<String, Actividad> actividadesDeAprendizaje) {
        this.actividadesDeAprendizaje = actividadesDeAprendizaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Clase interna para representar las actividades de aprendizaje

    public static class Actividad {
        private String actividad;
        private String tiempo;
        private String evaluacion;

        public Actividad(String actividad, String tiempo, String evaluacion) {
            this.actividad = actividad;
            this.tiempo = tiempo;
            this.evaluacion = evaluacion;
        }

        // Getters y setters para acceder a las propiedades de la actividad

        public String getActividad() {
            return actividad;
        }

        public void setActividad(String actividad) {
            this.actividad = actividad;
        }

        public String getTiempo() {
            return tiempo;
        }

        public void setTiempo(String tiempo) {
            this.tiempo = tiempo;
        }

        public String getEvaluacion() {
            return evaluacion;
        }

        public void setEvaluacion(String evaluacion) {
            this.evaluacion = evaluacion;
        }
    }

    // Método main para ejemplo de uso

//    public static void main(String[] args) {
//        Map<String, Actividad> actividadesDeAprendizaje = new HashMap<>();
//        actividadesDeAprendizaje.put("actividadACD", new Actividad("Clases Expositiva Participativa Políticas y lineamientos del curso.", 2, "Preguntas y respuestas"));
//        actividadesDeAprendizaje.put("actividadAPE", new Actividad("No hay actividad asignada", 2, "No hay actividad asignada"));
//        actividadesDeAprendizaje.put("actividadAA", new Actividad("Investigación del tema: lectura y análisis de la Estructura de Datos, conceptos fundamentales", 4, "Tarea: Subir documento/diapositivas con tema investigado."));
//
//        Unidades unidad1 = new Unidades(
//                "UNIDAD 1: Introducción a las estructuras de datos (TDA) con objetos, conceptos y definiciones.",
//                "Introducción a las Estructuras de Datos",
//                actividadesDeAprendizaje,
//                "2-may-2023"
//        );
//
//        System.out.println(unidad1.getDescripcion());
//        System.out.println(unidad1.getContenidos());
//        System.out.println(unidad1.getFecha());
//        System.out.println("Actividades de aprendizaje:");
//
//        for (Actividad actividad : unidad1.getActividadesDeAprendizaje().values()) {
//            System.out.println("- " + actividad.getActividad());
//            System.out.println("  Tiempo: " + actividad.getTiempo() + " horas");
//            System.out.println("  Evaluación: " + actividad.getEvaluacion());
//        }
//    }
}

