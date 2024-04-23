package com.jsp.StudentManagementSystem;

import java.util.List;

public interface StudentServiceDao {
	public String addStudent(Student student);
	public List<Student> getStudents();
	public Student getStudent(int id);
	public String updateStudent(Student student, int id);
	public String deleteStudent(int id);
	public String deleteAllStudents();
}
