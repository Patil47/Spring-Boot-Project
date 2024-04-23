package com.jsp.StudentManagementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceDaoImpl studentService;
	
	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}
	
	@PutMapping("/student/{id}")
	public String updateStudent(@RequestBody Student student, @PathVariable int id) {
		return studentService.updateStudent(student, id);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	@DeleteMapping("/student")
	public String deleteAllRecords() {
		return studentService.deleteAllStudents();
	}
}
