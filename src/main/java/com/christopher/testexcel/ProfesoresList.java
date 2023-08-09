package com.christopher.testexcel;

import java.util.ArrayList;
import java.util.List;

public class ProfesoresList {
    private List<Profesores> profesoresList;

    public ProfesoresList() {
        profesoresList = new ArrayList<>();
    }

    public List<Profesores> getProfesoresList() {
        return profesoresList;
    }

    public void setProfesoresList(List<Profesores> profesoresList) {
        this.profesoresList = profesoresList;
    }

   
}
