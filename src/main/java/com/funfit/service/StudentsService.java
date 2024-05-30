package com.funfit.service;

import java.util.List;

import com.funfit.bean.Students;
import com.funfit.dao.StudentsDao;

public class StudentsService {
	
	StudentsDao sDao = new StudentsDao();
	
	public String addStudent(Students students) {
		if(sDao.addStudent(students)>0) {
			return "Student created Successfully!";
		}else {
			return "Error creating Student ...";
		}
	}
	
	public List<Students> fetchAllStudents() {
		return sDao.fetchAllStudents();
	}
	
	public String updateStudent(Students student) {
		if(sDao.updateStudent(student)>0) {
			return "Updated Student!";
		}else {
			return "Error Updating Student ...";
		}
	}
	
	public String deleteStudent(String id) {
		if(sDao.deleteStudent(id)>0) {
			return "Deleted Student!";
		}else {
			return "Error Deleting Student ...";
		}
	}

}
