package com.jsp.StudentManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceDaoImpl implements StudentServiceDao {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public String addStudent(Student student) {
		StudentEntity studentEntity = new StudentEntity();
		BeanUtils.copyProperties(student, studentEntity);
		studentRepository.save(studentEntity);
		return "Added";
	}

	@Override
	public List<Student> getStudents() {
		List<StudentEntity> studentsEntity = studentRepository.findAll();
		List<Student> students = new ArrayList<Student>();
		for (StudentEntity studentEntity : studentsEntity) {
			Student student = new Student();
			BeanUtils.copyProperties(studentEntity, student);
			students.add(student);
		}
		return students;
	}

	@Override
	public Student getStudent(int id) {
		Optional<StudentEntity> opt = studentRepository.findById(id);
		Student student = new Student();
		if (opt.isPresent()) {
			BeanUtils.copyProperties(opt.get(), student);
		}
		return student;
	}

	@Override
	public String updateStudent(Student student, int id) {
		Student student2 = getStudent(id);
		student2 = student;
		StudentEntity studentEntity = new StudentEntity();
		BeanUtils.copyProperties(student, studentEntity);
		StudentEntity studentEntity2 = studentRepository.save(studentEntity);
		return "Update Successfully";
	}

	@Override
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public String deleteAllStudents() {
		studentRepository.deleteAll();
		return "All Record Deleted";
	}

}
