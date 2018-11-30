package com.crunchify.jsp.servlet;
 

import edu.co.sergio.mundo.dao.StudentDAO;
import edu.co.sergio.mundo.vo.Student;
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
        String SID = request.getParameter("SID");
        String FIRST = request.getParameter("FIRST");
        String LAST = request.getParameter("LAST");
        String EMAIL = request.getParameter("EMAIL");
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        StudentDAO dao = new StudentDAO();
        
        Student estudiantes = new Student();
        estudiantes.setSID(Integer.parseInt(SID));
        estudiantes.setFIRST(FIRST);
        estudiantes.setLAST(LAST);
        estudiantes.setEMAIL(EMAIL);
        
        //Listando la informacion  
        List<Student> students =  dao.findAll();
        request.setAttribute("Estudiantes ", students);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        
        }
}
