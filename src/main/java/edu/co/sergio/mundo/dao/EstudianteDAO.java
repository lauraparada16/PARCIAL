/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Labing
 */
public class EstudianteDAO implements IBaseDatos<Estudiante> {
    
    	public List<Estudiante> findAll() {
		List<Estudiante> estudiante= null;
	    String query = "SELECT * FROM Estudiante";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int codEstudiante =0;
	    String nomEstudiante = null;
            int codProfesor=0;
	
	    while (rs.next()){
	    	if(estudiante == null){
	    		estudiante= new ArrayList<Estudiante>();
	    	}
	      
	        Estudiante estu= new Estudiante();
	        codEstudiante = rs.getInt("codEstudiante");
	        estu.setCodEstudiante(codEstudiante);
	        
                nomEstudiante= rs.getString("nomEscuela");
	        estu.setNomEstudiante(nomEstudiante);
                
                codProfesor = rs.getInt("codProfesor");
                estu.setCodEscuela(codProfesor);
	        
	        estudiante.add(estu);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Estudiantes");
			e.printStackTrace();
		}
	    
	    return estudiante;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Estudiante
	 * @param Estudiante recibe un objeto de tipo Estudiante
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(Estudiante estudiante) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into Estudiante(codEstudiante,nomEstudiante, codEscuela)"  + " values (?,?,?)";
        PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, estudiante.getCodEstudiante());
                        preparedStmt.setString (2, estudiante.getNomEstudiante());
                        preparedStmt.setInt(3, estudiante.getCodEscuela());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Estudiante
	 * @param Estudiante recibe un objeto de tipo Estudiante
	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
	 */
	public boolean update(Estudiante estudiante) {
		boolean result=false;
		Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "updateEstudiante set nomEstudiante = ?, codEscuela = ? where codEstudiante = ?";
		PreparedStatement preparedStmt=null;
		try {
		    preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setString(1, estudiante.getNomEstudiante());
                    preparedStmt.setInt(2, estudiante.getCodEscuela());
                    preparedStmt.setInt(3, estudiante.getCodEstudiante());
		    if (preparedStmt.executeUpdate() > 0){
		    	result=true;
		    }
			    
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		return result;
	}

	/**
	 * Funcion que permite realizar la eliminario de registro en la tabla Estudiante
	 * @param Estudiante recibe un objeto de tipo Estudiante
	 * @return boolean retorna true si la operacion de borrado es exitosa.
	 */
	public boolean delete(Estudiante estudiante) {
	   boolean result=false;
	   Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	   String query = "delete from Estudiante where codEstudiante = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, estudiante.getCodEstudiante());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
}
