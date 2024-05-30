package com.funfit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.funfit.bean.Students;
import com.funfit.service.StudentsService;

/**
 * Servlet implementation class StudentsController
 */
@WebServlet("/studentsController")
public class StudentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentsService studentsService = new StudentsService();

    /**
     * Default constructor. 
     */
    public StudentsController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession hs = request.getSession();
		
		List<Students> studentList = studentsService.fetchAllStudents();
		hs.setAttribute("students", studentList);
		response.sendRedirect("viewStudents.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
	
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            
        	String studentId = request.getParameter("pid");
            // Call your delete method with the batchId
            String result = studentsService.deleteStudent(studentId);
            // Redirect or forward to the appropriate page after deletion
            RequestDispatcher rd = request.getRequestDispatcher("viewStudents.jsp");
            pw.print(result);
            rd.include(request, response);
            
        } else if ("update".equals(action)) {
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            int age = Integer.parseInt(request.getParameter("age"));
            String phonenumber = request.getParameter("phonenumber");
            int bid = Integer.parseInt(request.getParameter("bid"));
            int pid = Integer.parseInt(request.getParameter("pid"));

            Students student = new Students();
            student.setFname(fname);
            student.setLname(lname);
            student.setAge(age);
            student.setPhonenumber(phonenumber);
            student.setBid(bid);
            student.setPid(pid);

            String result = studentsService.updateStudent(student);
            request.setAttribute("result", result);
            RequestDispatcher rd = request.getRequestDispatcher("viewStudents.jsp");
            rd.include(request, response);
        
		} else {
        	
    		String fname = request.getParameter("fname");
    		String lname = request.getParameter("lname");
    		int age  = Integer.parseInt(request.getParameter("age"));
    		String phonenumber = request.getParameter("phonenumber");
    		int bid = Integer.parseInt(request.getParameter("bid"));
    		
    		RequestDispatcher rd = request.getRequestDispatcher("addStudents.jsp");
        	
    		Students student = new Students();
    		student.setFname(fname);
    		student.setLname(lname);
    		student.setAge(age);
    		student.setPhonenumber(phonenumber);
    		student.setBid(bid);
    		
    		String result = studentsService.addStudent(student);
    		pw.print(result);
    		rd.include(request, response);
    		
        }
		
	}

}
