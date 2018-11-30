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
import edu.co.sergio.mundo.vo.Results;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultsDAO implements IBaseDatos<Results> {
    
    /**
	 * Funcion que permite obtener una lista de los departamentos existentes en la base de datos
	 * @return List<Departamento> Retorna la lista de Departamentos existentes en la base de datos
	 */
	public List<Results> findAll() {
		List<Results> results= null;
	    String query = "SELECT * FROM RESULTS";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ResultsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int SID =0;
	    String CAT = null;
            int ENO =0;
            int POINTS =0;
	
	    while (rs.next()){
	    	if(results == null){
	    		results = new ArrayList<Results>();
	    	}
	      
	        Results registro= new Results();
                
	        SID = rs.getInt("SID");
	        registro.setSID(SID);
	        
	        CAT = rs.getString("CAT");
	        registro.setCAT(CAT);
	        
                ENO = rs.getInt("ENO");
	        registro.setENO(ENO);
                
                POINTS = rs.getInt("POINTS");
	        registro.setPOINTS(POINTS);
                
	        results.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de los Resultados");
			e.printStackTrace();
		}
	    
	    return results;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Departamento
	 * @param Departamento recibe un objeto de tipo Departamento 
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(Results results) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ResultsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into RESULTS (SID,CAT,ENO,POINTS)"  + " values (?,?,?,?)";
            PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, results.getSID());
                        preparedStmt.setString (2, results.getCAT());
                        preparedStmt.setInt (3, results.getENO());
                        preparedStmt.setInt (4, results.getPOINTS());
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
	public boolean update(Results results) {
		boolean result=false;
		Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ResultsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "update RESULTS set POINTS = ? where SID = ? AND CAT = ? AND ENO = ?";
		PreparedStatement preparedStmt=null;
		try {
		    preparedStmt = connection.prepareStatement(query);
                    preparedStmt.setInt   (2, results.getPOINTS());
                    preparedStmt.setInt   (2, results.getSID());
		    preparedStmt.setString(1,results.getCAT());
                    preparedStmt.setInt   (2, results.getENO());
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
	public boolean delete(Results results) {
	   boolean result=false;
	   Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ResultsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	   String query = "delete from RESULTS where SID = ? AND CAT = ? AND ENO = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, results.getSID());
                     preparedStmt.setString(2, results.getCAT());
                     preparedStmt.setInt(3, results.getENO());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
    
}
