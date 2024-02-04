package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDao;
import com.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class updateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		int id =Integer.parseInt(req.getParameter("id"));
		
				
		Student student = new Student(id,name,dob,address,qualification,email);
		StudentDao dao =new StudentDao(DBConnect.getConn());
		
		HttpSession session =req.getSession();
		boolean f=dao.updatestudent(student);
		
		if(f)
		{
			session.setAttribute("succMsg", "Update succesfully");
			resp.sendRedirect("index.jsp");
			//System.out.println("Insert succesfully");
		}
		else
		{
			session.setAttribute("errorMsg", "Somthing wrong on server");
			resp.sendRedirect("index.jsp");
			//System.out.println("Not Inserted..Somthing wrong on server");
		}
		
		
	}
	
	

}
