package com.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Student;

public class StudentDao {
	
	private Connection conn;

	public StudentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addstudent(Student student)
	{
		boolean f=false;
		
		try {
			
			String sql ="insert into student(name,dob,address,email,qualification) values(?,?,?,?,?)";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, student.getFullName());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getQulifaction());
			
			
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	public List<Student> getAllStudent(){
		
		List<Student> list = new ArrayList<Student>();
		Student s=null;
		
		try {
			String sql="select * from student";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next())
			{
				s=new Student();
				s.setId(rs.getInt(1));
				s.setFullName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setAddress(rs.getString(4));
				s.setEmail(rs.getString(5));
				s.setQulifaction(rs.getString(6));
				list.add(s);
			}
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		
		
		return list;
		
	}
	
	public Student getStudentbyId(int id)
	{
		
           Student s=null;
		
		try {
			String sql="select * from student where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next())
			{
				s=new Student();
				s.setId(rs.getInt(1));
				s.setFullName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setAddress(rs.getString(4));
				s.setEmail(rs.getString(5));
				s.setQulifaction(rs.getString(6));
				
			}
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return s;
		
		
		
	}
	
	public boolean updatestudent(Student student)
	{
		boolean f=false;
		
		try {
			
			String sql ="update student set name=?,dob=?,address=?,email=?,qualification=? where id=?"; 
			
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, student.getFullName());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getQulifaction());
			ps.setInt(6, student.getId());
			
			
			
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	
	public boolean DeleteStudent(int id)
	{
		boolean f=false;
		
		try {
			
			String sql="delete from student where id=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
       int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) 
		{
          e.printStackTrace();

		}
		
		return f;
	}
	
	

}
