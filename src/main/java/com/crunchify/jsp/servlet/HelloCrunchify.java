package com.crunchify.jsp.servlet;
 

import edu.co.sergio.mundo.dao.EstudianteDAO;
import edu.co.sergio.mundo.vo.Estudiante;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class HelloCrunchify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String codEstudiante = request.getParameter("CodEstudiante");
        String nomEstudiante = request.getParameter("NomEstudiante");
        String codEscuela = request.getParameter("CodEscuela");
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        EstudianteDAO dao = new EstudianteDAO();
        
        Estudiante estudiantes = new Estudiante();
        estudiantes.setCodEstudiante(Integer.parseInt(codEstudiante));
        estudiantes.setNomEstudiante(nomEstudiante);
        estudiantes.setCodEscuela(Integer.parseInt(codEscuela));
        
        //Listando la informacion  
        List<Estudiante> estudiante =  dao.findAll();
        request.setAttribute("Estudiantes ", estudiante);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        
        }
}
