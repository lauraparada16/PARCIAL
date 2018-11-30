/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.vo;

/**
 *
 * @author Laura Parada
 */
public class Exercises {
    
    private String CAT;
    private int ENO;
    private String TOPIC;
    private int MAXPT;

    public Exercises() {
    }

    public Exercises(String CAT, int ENO, String TOPIC, int MAXPT) {
        this.CAT = CAT;
        this.ENO = ENO;
        this.TOPIC = TOPIC;
        this.MAXPT = MAXPT;
    }

    public String getCAT() {
        return CAT;
    }

    public void setCAT(String CAT) {
        this.CAT = CAT;
    }

    public int getENO() {
        return ENO;
    }

    public void setENO(int ENO) {
        this.ENO = ENO;
    }

    public String getTOPIC() {
        return TOPIC;
    }

    public void setTOPIC(String TOPIC) {
        this.TOPIC = TOPIC;
    }

    public int getMAXPT() {
        return MAXPT;
    }

    public void setMAXPT(int MAXPT) {
        this.MAXPT = MAXPT;
    }
    
    
}
