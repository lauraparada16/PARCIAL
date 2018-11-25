/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Curso;
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
public class CursoDAO implements IBaseDatos<Curso>{

    
	public List<Curso> findAll() {
            List<Curso> curso= null;
	    String query = "SELECT * FROM Curso";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int codCurso =0;
	    String nomCurso = null;
	
	    while (rs.next()){
	    	if(curso == null){
	    		curso= new ArrayList<Curso>();
	    	}
	      
	        Curso cursito= new Curso();
	        codCurso = rs.getInt("codCurso");
	        cursito.setCodCurso(codCurso);
	        
	        nomCurso = rs.getString("nomCurso");
	        cursito.setNomCurso(nomCurso);
	        
	        curso.add(cursito);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Cursos");
			e.printStackTrace();
		}
	    
	    return curso;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Curso
	 * @param Curso recibe un objeto de tipo Curso
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(Curso curso) {
            boolean result=false;
            Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " INSERT INTO Curso (codCurso,nomCurso)"  + " values (?,?)";
            PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, curso.getCodCurso());
                        preparedStmt.setString (2, curso.getNomCurso());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Curso
	 * @param Curso recibe un objeto de tipo Departamento 
	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
	 */
	public boolean update(Curso curso) {
            boolean result=false;
            Connection connection= null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		String query = "update Curso set nomCurso = ? where codCurso = ?";
		PreparedStatement preparedStmt=null;
		try {
		    preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setString(1, curso.getNomCurso());
                    preparedStmt.setInt(2, curso.getCodCurso());
		    if (preparedStmt.executeUpdate() > 0){
		    	result=true;
		    }
			    
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		return result;
	}

	/**
	 * Funcion que permite realizar la eliminario de registro en la tabla Curso
	 * @param Curso recibe un objeto de tipo Curso
	 * @return boolean retorna true si la operacion de borrado es exitosa.
	 */
	public boolean delete(Curso curso) {
	   boolean result=false;
	   Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	   String query = "delete from Curso where codCurso = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, curso.getCodCurso());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
    
}
