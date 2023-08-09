package com.christopher.testexcel;

import java.util.Date;
import java.util.List;

public class Unidades {
    private String descripcion;
    private String contenidos;
    private List<Actividad> actividadesDeAprendizaje;
    private Date fecha;
    private String formattedDate;
    private boolean reminderActive;

    public Unidades(String descripcion, String contenidos, List<Actividad> actividadesDeAprendizaje, Date fecha, String formattedDate) {
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

    public List<Actividad> getActividadesDeAprendizaje() {
        return actividadesDeAprendizaje;
    }

    public void setActividadesDeAprendizaje(List< Actividad> actividadesDeAprendizaje) {
        this.actividadesDeAprendizaje = actividadesDeAprendizaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public boolean isReminderActive() {
        return reminderActive;
    }

    public void setReminderActive(boolean reminderActive) {
        this.reminderActive = reminderActive;
    }

    // Clase interna para representar las actividades de aprendizaje

    public static class Actividad {
        private String tipoDeActividad;
        private String actividad;
        private String tiempo;
        private String evaluacion;

        public Actividad(String tipoDeActividad, String actividad, String tiempo, String evaluacion) {
            this.tipoDeActividad = tipoDeActividad;
            this.actividad = actividad;
            this.tiempo = tiempo;
            this.evaluacion = evaluacion;
        }

        // Getters y setters para acceder a las propiedades de la actividad

        public String getTipoDeActividad() {
            return tipoDeActividad;
        }

        public void setTipoDeActividad(String tipoDeActividad) {
            this.tipoDeActividad = tipoDeActividad;
        }

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
