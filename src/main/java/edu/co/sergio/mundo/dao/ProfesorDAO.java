/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Profesor;
import java.util.List;

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
public class ProfesorDAO implements IBaseDatos<Profesor>{
    
    
    	public List<Profesor> findAll() {
            List<Profesor> profesor= null;
	    String query = "SELECT * FROM Profesor";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int codProfesor =0;
	    String nomProfe = null;
            String apeProfe = null;
	
	    while (rs.next()){
	    	if(profesor == null){
	    		profesor = new ArrayList<Profesor>();
	    	}
	      
	        Profesor profe= new Profesor();
	        codProfesor = rs.getInt("codProfesor");
	        profe.setCodProfesor(codProfesor);
	        
	        nomProfe = rs.getString("nomProfe");
	        profe.setNomProfe(nomProfe);
                
                apeProfe = rs.getString("apeProfe");
	        profe.setApeProfe(apeProfe);
	        
	        profesor.add(profe);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Profesores");
			e.printStackTrace();
		}
	    
	    return profesor;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Profesor
	 * @param Profesor recibe un objeto de tipo Profesor
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(Profesor profesor) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into Profesor (codProfesor,nomProfe,apeProfe)"  + " values (?,?,?)";
            PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, profesor.getCodProfesor());
                        preparedStmt.setString (2, profesor.getNomProfe());
                        preparedStmt.setString (3, profesor.getApeProfe());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Profesor
	 * @param Profesor recibe un objeto de tipo Profesor
	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
	 */
	public boolean update(Profesor profesor) {
		boolean result=false;
		Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "update Profesor set nomProfe = ?, apeProfe = ? where codProfesor = ?";
		PreparedStatement preparedStmt=null;
		try {
		    preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setString(1, profesor.getNomProfe());
                    preparedStmt.setString(2, profesor.getApeProfe());
                    preparedStmt.setInt(3, profesor.getCodProfesor());
		    if (preparedStmt.executeUpdate() > 0){
		    	result=true;
		    }
			    
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		return result;
	}

	/**
	 * Funcion que permite realizar la eliminario de registro en la tabla Profesor
	 * @param Profesor recibe un objeto de tipo Profesor
	 * @return boolean retorna true si la operacion de borrado es exitosa.
	 */
	public boolean delete(Profesor profesor) {
	   boolean result=false;
	   Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	   String query = "delete from Profesor where codProfesor = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		    preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setInt(1, profesor.getCodProfesor());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}

}
