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
public class Profesor {
    
    private int codProfesor;
    private String nomProfe;
    private String apeProfe;

    public Profesor() {
    }

    public Profesor(int codProfesor, String nomProfe, String apeProfe) {
        this.codProfesor = codProfesor;
        this.nomProfe = nomProfe;
        this.apeProfe = apeProfe;
    }

    public int getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(int codProfesor) {
        this.codProfesor = codProfesor;
    }

    public String getNomProfe() {
        return nomProfe;
    }

    public void setNomProfe(String nomProfe) {
        this.nomProfe = nomProfe;
    }

    public String getApeProfe() {
        return apeProfe;
    }

    public void setApeProfe(String apeProfe) {
        this.apeProfe = apeProfe;
    }
    
    
}
