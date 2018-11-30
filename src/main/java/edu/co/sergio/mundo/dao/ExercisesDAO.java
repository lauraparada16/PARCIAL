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
import edu.co.sergio.mundo.vo.Exercises;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExercisesDAO implements IBaseDatos<Exercises>{
    
    /**
	 * Funcion que permite obtener una lista de los departamentos existentes en la base de datos
	 * @return List<Departamento> Retorna la lista de Departamentos existentes en la base de datos
	 */
	public List<Exercises> findAll() {
		List<Exercises> exercises= null;
	    String query = "SELECT * FROM EXERCISES";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ExercisesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    String CAT = null;
            int ENO =0;
            String TOPIC = null;
            int MAXPT =0;
	
	    while (rs.next()){
	    	if(exercises == null){
	    		exercises= new ArrayList<Exercises>();
	    	}
	      
                Exercises registro= new Exercises();
	        CAT= rs.getString("SID");
	        registro.setCAT(CAT);
	        
	        ENO = rs.getInt("ENO");
	        registro.setENO(ENO);
	        
                TOPIC= rs.getString("TOPIC");
                registro.setTOPIC(TOPIC);
                
                MAXPT = rs.getInt("MAXPT");
	        registro.setMAXPT(MAXPT);
                
	        exercises.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Ejercicios");
			e.printStackTrace();
		}
	    
	    return exercises;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Departamento
	 * @param Departamento recibe un objeto de tipo Departamento 
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(Exercises exercises) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ExercisesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into EXERCISES (CAT,ENO,TOPIC,MAXPT)"  + " values (?,?,?,?)";
        PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
                        preparedStmt.setString (1, exercises.getCAT());
			preparedStmt.setInt (2, exercises.getENO());
                        preparedStmt.setString (3, exercises.getTOPIC());
                        preparedStmt.setInt (4, exercises.getMAXPT());
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
	public boolean update(Exercises exercises) {
		boolean result=false;
		Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ExercisesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "update EXERCISES set TOPIC = ?, MAXPT = ? where CAT = ? AND ENO = ?";
		PreparedStatement preparedStmt=null;
		try {
		    preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setString(1, exercises.getTOPIC());
                    preparedStmt.setInt   (2, exercises.getMAXPT());
                    preparedStmt.setString(3, exercises.getCAT());
                    preparedStmt.setInt   (4, exercises.getENO());
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
	public boolean delete(Exercises exercises) {
	   boolean result=false;
	   Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ExercisesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	   String query = "DELETE from EXERCISES where CAT = ? AND ENO = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
                     preparedStmt.setString(1, exercises.getCAT());
		     preparedStmt.setInt(2, exercises.getENO());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
    
}
