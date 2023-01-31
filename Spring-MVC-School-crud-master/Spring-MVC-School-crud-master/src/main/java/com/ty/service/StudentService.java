package com.ty.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.StudentDao;
import com.ty.dto.Student;

@Component
public class StudentService {
	@Autowired
	StudentDao studentDao;

	// save Students
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}
	// get Student By Id
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}
	// get All Student
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}
	// Delete Student By Id
	public boolean deleteStudentById(int id) {
	   return studentDao.deleteStudentById(id);
	}
	//Update Student
	public Student updateStudentById(int id,Student student) {
		return studentDao.updateStudentById(id, student);
	}
}
