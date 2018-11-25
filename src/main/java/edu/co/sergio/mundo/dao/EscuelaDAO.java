/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Escuela;
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
public class EscuelaDAO implements IBaseDatos<Escuela>{
    
    	public List<Escuela> findAll() {
            List<Escuela> escuela= null;
	    String query = "SELECT * FROM Escuela";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(EscuelaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int codEscuela =0;
	    String nombreEscuela = null;
	
	    while (rs.next()){
	    	if(escuela == null){
	    		escuela= new ArrayList<Escuela>();
	    	}
	      
	        Escuela escuelita= new Escuela();
	        codEscuela = rs.getInt("codEscuela");
	        escuelita.setCodEscuela(codEscuela);
	        
	        nombreEscuela = rs.getString("nombreEscuela");
	        escuelita.setNombreEscuela(nombreEscuela);
	        
	        escuela.add(escuelita);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Escuelas");
			e.printStackTrace();
		}
	    
	    return escuela;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Escuelas
	 * @param Escuela recibe un objeto de tipo Escuela
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(Escuela escuela) {
            boolean result=false;
            Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(EscuelaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " INSERT INTO Escuela (codEscuela,nombreEscuela)"  + " values (?,?)";
            PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, escuela.getCodEscuela());
                        preparedStmt.setString (2, escuela.getNombreEscuela());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Escuela
	 * @param Escuela recibe un objeto de tipo Escuela
	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
	 */
	public boolean update(Escuela escuela) {
		boolean result=false;
		Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(EscuelaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "update Escuela set nombreEcuela = ? where codEscuela = ?";
		PreparedStatement preparedStmt=null;
		try {
		    preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setString(1, escuela.getNombreEscuela());
                    preparedStmt.setInt   (2, escuela.getCodEscuela());
		    if (preparedStmt.executeUpdate() > 0){
		    	result=true;
		    }
			    
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		return result;
	}

	/**
	 * Funcion que permite realizar la eliminario de registro en la tabla Escuela
	 * @param Escuela recibe un objeto de tipo Escuela
	 * @return boolean retorna true si la operacion de borrado es exitosa.
	 */
	public boolean delete(Escuela escuela) {
	   boolean result=false;
	   Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(EscuelaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	   String query = "delete from Escuela where codEscuela= ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, escuela.getCodEscuela());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
}
