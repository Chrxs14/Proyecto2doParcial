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
class listaUnidades {
    private List<Unidades> listaUnidades;

    public listaUnidades() {
        listaUnidades = new ArrayList<>();
    }

    public List<Unidades> getUnidades() {
        return listaUnidades;
    }

    public void setProfesoresList(List<Unidades> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

}
