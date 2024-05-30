package com.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Students;
import com.funfit.config.DbConfig;

public class StudentsDao {
	
	public int addStudent(Students students) {
		try {
			Connection con = DbConfig.getDbConnection();
			PreparedStatement query = con.prepareStatement("insert into students(fname,lname,age,phonenumber,bid) values(?,?,?,?,?);");
			query.setString(1, students.getFname());
			query.setString(2, students.getLname());
			query.setInt(3, students.getAge());
			query.setString(4, students.getPhonenumber());
			query.setInt(5, students.getBid());
			return query.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<Students> fetchAllStudents() {
		List<Students> studentList = new ArrayList<>();
		
		try {
			Connection con = DbConfig.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from students");
			ResultSet results = pstmt.executeQuery();
			
			while(results.next()) {
				Students s = new Students();
				s.setPid(results.getInt(1));
				s.setFname(results.getString(2));
				s.setLname(results.getString(3));
				s.setAge(results.getInt(4));
				s.setPhonenumber(results.getString(5));
				s.setBid(results.getInt(6));
				studentList.add(s);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return studentList;
	}
	
	public int updateStudent(Students students) {
		try {
			Connection con = DbConfig.getDbConnection();
			PreparedStatement query = con.prepareStatement("update students set fname=?, lname=?, age=?, phonenumber=?, bid=? where pid=?");
			query.setString(1, students.getFname());
			query.setString(2, students.getLname());
			query.setInt(3, students.getAge());
			query.setString(4, students.getPhonenumber());
			query.setInt(5, students.getBid());
			query.setInt(6, students.getPid());
			return query.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int deleteStudent(String id) {
		try {
			Connection con = DbConfig.getDbConnection();
			PreparedStatement query = con.prepareStatement("delete from students where pid=?");
			query.setInt(1, Integer.valueOf(id));
			return query.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

}
