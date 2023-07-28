package com.christopher.testexcel;

/**
 *
 * @author Chris
 */

import java.util.Date;
import java.util.Map;

public class Unidades {
    private String descripcion;
    private String contenidos;
    private Map<String, Actividad> actividadesDeAprendizaje;
    private Date fecha;
    private String formattedDate;

    public Unidades(String descripcion, String contenidos, Map<String, Actividad> actividadesDeAprendizaje, Date fecha, String formattedDate) {
        this.descripcion = descripcion;
        this.contenidos = contenidos;
        this.actividadesDeAprendizaje = actividadesDeAprendizaje;
        this.fecha = fecha;
        this.formattedDate = formattedDate;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getformattedDate() {
        return formattedDate;
    }

    public void setformattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
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
}

