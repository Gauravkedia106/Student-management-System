package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.*;
import com.entity.Student;
import com.conn.DBConnect;
import com.dao.StudentDao;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		
				
		Student student = new Student(name,dob,address,qualification,email);
		//System.out.println(student);
		
		HttpSession session =req.getSession();
		
		StudentDao dao =new StudentDao(DBConnect.getConn());
		
		boolean f=dao.addstudent(student);
		
		if(f)
		{
			session.setAttribute("succMsg", "Insert succesfully");
			resp.sendRedirect("add_student.jsp");
			//System.out.println("Insert succesfully");
		}
		else
		{
			session.setAttribute("errorMsg", "Somthing wrong on server");
			resp.sendRedirect("add_student.jsp");
			//System.out.println("Not Inserted..Somthing wrong on server");
		}

		
		
	}
	
	
	
	
	
	

}
