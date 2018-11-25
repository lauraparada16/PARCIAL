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
public class Escuela {

    private int codEscuela;
    private String nombreEscuela;
    
    public Escuela() {
    }

    public Escuela(int codEscuela, String NombreEscuela) {
        this.codEscuela = codEscuela;
        this.nombreEscuela = NombreEscuela;
    }

    public int getCodEscuela() {
        return codEscuela;
    }

    public void setCodEscuela(int codEscuela) {
        this.codEscuela = codEscuela;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String NombreEscuela) {
        this.nombreEscuela = NombreEscuela;
    }
    
    
    
}
