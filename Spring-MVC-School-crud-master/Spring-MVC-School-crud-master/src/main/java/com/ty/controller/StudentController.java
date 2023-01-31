package com.ty.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dto.Student;
import com.ty.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/studentload")
	public ModelAndView loadMe() {
		ModelAndView modelAndView=new ModelAndView("createstudent.jsp");
		modelAndView.addObject("student1",new Student());
		return modelAndView;
	}
	@RequestMapping("/studentsave")
	public ModelAndView saveStudent(@ModelAttribute Student student ) {
		studentService.saveStudent(student);
		ModelAndView modelAndView=new ModelAndView("homepage.jsp");
		modelAndView.addObject("save",student.getName()+"is Added Successfully");
		return modelAndView;
	}
	@RequestMapping("/viewallstudents")
	public ModelAndView getAllStudents() {
		List<Student> students=studentService.getAllStudent();
		
		ModelAndView modelAndView=new ModelAndView("allstudents.jsp");
		modelAndView.addObject("students1", students);
		return modelAndView;
	}
	//Edit student
	@RequestMapping("/editstudents")
	public ModelAndView editStudent(@RequestParam(name = "id") int id, ModelAndView modelAndView) {
		Student student=studentService.getStudentById(id);
		modelAndView.setViewName("editstudent.jsp");
		modelAndView.addObject("student",student);
		return modelAndView;
	}
	//Update Student
	@RequestMapping("/updatestudents")
	public ModelAndView updateStudent(@ModelAttribute Student student, ModelAndView modelAndView) {
		studentService.updateStudentById(student.getId(), student);
		
		modelAndView.setViewName("allstudents.jsp");
		modelAndView.addObject("students1", studentService.getAllStudent());
		return modelAndView;
	}
	//Delete Student
	@RequestMapping("/deletestudents")
	public ModelAndView deleteStudent(@RequestParam(name = "id") int id, ModelAndView modelAndView) {
		Student student=studentService.getStudentById(id);
		modelAndView.setViewName("deletestudent.jsp");
		modelAndView.addObject("studentsdel",student);
		return modelAndView;
	}
}
