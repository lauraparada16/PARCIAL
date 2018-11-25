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
          String sql = "CREATE TABLE Escuela(codEscuela integer, nombreEscuela varchar(250), PRIMARY KEY(codEscuela))";
          Connection connection = null;
            try {
                connection = Conexion.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql);
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(EscuelaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
             Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
            
          String sql1 = "CREATE TABLE Estudiante(codEstudiante integer PRIMARY KEY, nomEstudiante varchar(250), codEscuela integer,FOREIGN KEY (codEscuela) REFERENCES Escuela(codEscuela))";

            try {
                connection = Conexion.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql1);
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
             Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
           String sql2 = "CREATE TABLE Profesor(codProfesor integer PRIMARY KEY, nomProfe varchar(50), apeProfe varchar(50))";
            try {
                connection = Conexion.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql2);
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
             Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
            
          String sql3 = "CREATE TABLE Curso(codCurso integer, nomCurso varchar(250), codProfesor integer, FOREIGN KEY (codProfe) REFERENCES Profesor(codProfe))";
            try {
                connection = Conexion.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql3);
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
             Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
          String sql4 = "CREATE TABLE Registro(id integer PRIMARY KEY, codEstudiante integer, codCurso integer, semestre varchar(50), nota double)";
            try {
                connection = Conexion.getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(sql4);
                
            } catch (URISyntaxException ex) {
                Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
             Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
          
     }
}