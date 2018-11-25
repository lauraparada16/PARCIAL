/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Registro;

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
public class RegistroDAO implements IBaseDatos<Registro>{
    
    	public List<Registro> findAll() {
		List<Registro> registro= null;
	    String query = "SELECT * FROM Registro";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int id =0;
            int codEstudiante=0;
            int codCurso=0;
	    String semestre = null;
            double nota=0;
	
	    while (rs.next()){
	    	if(registro == null){
	    		registro= new ArrayList<Registro>();
	    	}
	      
	        Registro registrico= new Registro();
	        id = rs.getInt("id");
	        registrico.setId(id);
             
                codEstudiante = rs.getInt("codEstudiante");
	        registrico.setCodEstudiante(codEstudiante);
	        
                codCurso = rs.getInt("codCurso");
	        registrico.setCodCurso(codCurso);
                
	        semestre = rs.getString("semestre");
	        registrico.setSemestre(semestre);
                
                nota = rs.getInt("nota");
                registrico.setNota(nota);
	        
	        registro.add(registrico);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Registros");
			e.printStackTrace();
		}
	    
	    return registro;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Registro
	 * @param Registro recibe un objeto de tipo Registro
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(Registro registro) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into Registro (id, codEstudiante,codCurso,semestre,nota)"  + " values (?,?,?,?,?)";
            PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, registro.getId());
                        preparedStmt.setInt (2, registro.getCodEstudiante());
                        preparedStmt.setInt (3, registro.getCodCurso());
                        preparedStmt.setString (4, registro.getSemestre());
                        preparedStmt.setDouble (5, registro.getNota());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Registro
	 * @param Registro recibe un objeto de tipo Registro
	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
	 */
	public boolean update(Registro registro) {
		boolean result=false;
		Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "update Registro set codEstudiante = ?, codCurso = ?, semestre = ?, nota = ? where id = ?";
		PreparedStatement preparedStmt=null;
		try {
		    preparedStmt = connection.prepareStatement(query);
                        preparedStmt.setInt (1, registro.getCodEstudiante());
                        preparedStmt.setInt (2, registro.getCodCurso());
                        preparedStmt.setString (3, registro.getSemestre());
                        preparedStmt.setDouble (4, registro.getNota());
                        preparedStmt.setInt (5, registro.getId());
                        
		    if (preparedStmt.executeUpdate() > 0){
		    	result=true;
		    }
			    
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		return result;
	}

	/**
	 * Funcion que permite realizar la eliminario de registro en la tabla Registro
	 * @param Registro recibe un objeto de tipo Registro
	 * @return boolean retorna true si la operacion de borrado es exitosa.
	 */
	public boolean delete(Registro registro) {
	   boolean result=false;
	   Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	   String query = "delete from Registro where id = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, registro.getId());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
    
}
