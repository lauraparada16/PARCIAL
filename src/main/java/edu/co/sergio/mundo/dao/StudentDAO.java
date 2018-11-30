/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

/**
 *
 * @author Laura Parada
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Student;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO implements IBaseDatos<Student> {
    
    /**
	 * Funcion que permite obtener una lista de los departamentos existentes en la base de datos
	 * @return List<Departamento> Retorna la lista de Departamentos existentes en la base de datos
	 */
	public List<Student> findAll() {
		List<Student> students= null;
	    String query = "SELECT * FROM STUDENT";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int SID=0;
	    String FIRST = null;
            String LAST = null;
            String EMAIL = null;
	
	    while (rs.next()){
	    	if(students == null){
	    		students= new ArrayList<Student>();
	    	}
	      
	        Student registro= new Student();
	        SID = rs.getInt("SID");
	        registro.setSID(SID);
	        
	        FIRST = rs.getString("FIRST");
	        registro.setFIRST(FIRST);
                
                LAST = rs.getString("LAST");
	        registro.setLAST(LAST);
                
                EMAIL = rs.getString("EMAIL");
	        registro.setEMAIL(EMAIL);
	        
	        students.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Estudiantes");
			e.printStackTrace();
		}
	    
	    return students;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Departamento
	 * @param Departamento recibe un objeto de tipo Departamento 
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(Student students) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into STUDENTS (SID,FIRST,LAST,EMAIL)"  + " values (?,?,?,?)";
        PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, students.getSID());
                        preparedStmt.setString (2, students.getFIRST());
                        preparedStmt.setString (3, students.getLAST());
                        preparedStmt.setString (4, students.getEMAIL());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Departamento
	 * @param Departamento recibe un objeto de tipo Departamento 
	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
	 */
	public boolean update(Student students) {
		boolean result=false;
		Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "update STUDENTS set FIRST = ?, LAST = ?, EMAIL = ? where SID = ?";
		PreparedStatement preparedStmt=null;
		try {
		    preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setString(1, students.getFIRST());
                    preparedStmt.setString(2, students.getLAST());
                    preparedStmt.setString(3, students.getEMAIL());
                    preparedStmt.setInt   (4, students.getSID());
		    if (preparedStmt.executeUpdate() > 0){
		    	result=true;
		    }
			    
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		return result;
	}

	/**
	 * Funcion que permite realizar la eliminario de registro en la tabla Departamento
	 * @param Departamento recibe un objeto de tipo Departamento 
	 * @return boolean retorna true si la operacion de borrado es exitosa.
	 */
	public boolean delete(Student students) {
	   boolean result=false;
	   Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	   String query = "delete from STUDENT where SID = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, students.getSID());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
    
}
