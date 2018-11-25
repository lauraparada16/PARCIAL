package com.crunchify.jsp.servlet;
 

import DAO.EstudianteDAO;
import VO.Estudiante;
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
        String codEstudiante = request.getParameter("codEstudiante");
        String nomEstudiante = request.getParameter("nomEstudiante");
        String codEscuela = request.getParameter("codEscuela");
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        EstudianteDAO dao = new EstudianteDAO();
        
        Estudiante estudiante = new Estudiante();
        estudiante.setCodEstudiante(Integer.parseInt(codEstudiante));
        estudiante.setNomEstudiante(nomEstudiante);
        estudiante.setCodEscuela(Integer.parseInt(codEscuela));
        
        //Listando la informacion  
        List<Estudiante> estudiantes =  dao.findAll();
        request.setAttribute("Estudiantes ", estudiantes);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        
        }
}
