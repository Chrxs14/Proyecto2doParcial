/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christopher.testexcel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris
 */
public class Profesores {
    private String id_profesor;
    private String profesor;
    private String usuario;
    private String pass;
    private List<Profesores> profesoresList;

    public Profesores(String id_profesor, String profesor, String usuario, String pass) {
        this.id_profesor = id_profesor;
        this.profesor = profesor;
        this.usuario = usuario;
        this.pass = pass;
    }

    public String getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Profesores> getProfesoresList() {
        return profesoresList;
    }

    public void setProfesoresList(List<Profesores> profesoresList) {
        this.profesoresList = profesoresList;
    }
    
    public class ProfesoresList {
        private List<Profesores> profesoresList;

        public ProfesoresList() {
            profesoresList = new ArrayList<>();
        }

        public List<Profesores> getProfesoresList() {
            return profesoresList;
        }

        public void agregarProfesor(Profesores profesor) {
            profesoresList.add(profesor);
        }

        public void eliminarProfesor(Profesores profesor) {
            profesoresList.remove(profesor);
        }
    }

}
