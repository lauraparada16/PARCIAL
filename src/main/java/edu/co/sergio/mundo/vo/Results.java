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
public class Results {
    
    private int SID;
    private String CAT;
    private int ENO;
    private int POINTS;

    public Results() {
    }

    public Results(int SID, String CAT, int ENO, int POINTS) {
        this.SID = SID;
        this.CAT = CAT;
        this.ENO = ENO;
        this.POINTS = POINTS;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
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

    public int getPOINTS() {
        return POINTS;
    }

    public void setPOINTS(int POINTS) {
        this.POINTS = POINTS;
    }
    
}
