/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.vo;

/**
 *
 * @author Labing
 */
public class Estudiante {
    
    private int codEstudiante;
    private String nomEstudiante;
    private int codEscuela;

    public Estudiante() {
    }

    public Estudiante(int codEstudiante, String nomEstudiante, int codEscuela) {
        this.codEstudiante = codEstudiante;
        this.nomEstudiante = nomEstudiante;
        this.codEscuela = codEscuela;
    }

    public int getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(int codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getNomEstudiante() {
        return nomEstudiante;
    }

    public void setNomEstudiante(String nomEstudiante) {
        this.nomEstudiante = nomEstudiante;
    }

    public int getCodEscuela() {
        return codEscuela;
    }

    public void setCodEscuela(int codEscuela) {
        this.codEscuela = codEscuela;
    }
   
    
    
}
