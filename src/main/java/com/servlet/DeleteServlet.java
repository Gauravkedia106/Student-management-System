package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao dao =new StudentDao(DBConnect.getConn());
		boolean f =dao.DeleteStudent(id);
		
		HttpSession session =req.getSession();
		
		
		if(f)
		{
			session.setAttribute("succMsg", "Delete succesfully");
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
