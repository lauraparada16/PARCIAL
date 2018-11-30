/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabian Giraldo
 */
public class CreateDataBase {
     public static void run(){
          String sql = "CREATE TABLE STUDENTS(SID integer, FIRSTN varchar(250), LASTN varchar(250), EMAIL varchar(250), PRIMARY KEY(SID))";
          Connection connection = null;
            try {
                connection = Conexion.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql);
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
             Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
            
          String sql1 = "CREATE TABLE EXERCISES(CAT varchar(50), ENO integer, TOPIC varchar(250),MAXPT integer, PRIMARY KEY(CAD,ENO))";

            try {
                connection = Conexion.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql1);
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(ExercisesDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
             Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
           String sql2 = "CREATE TABLE RESULTS(SID integer, CAT varchar(50), ENO integer, POINTS integer, FOREIGN KEY(SID) REFERENCES STUDENTS(SID), "
                   + "FOREIGN KEY(CAT) REFERENCES EXERCISES(CAT), FOREIGN KEY(ENO) REFERENCES EXERCISES(ENO))";
            try {
                connection = Conexion.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql2);
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(ResultsDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
             Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
          
     }
}