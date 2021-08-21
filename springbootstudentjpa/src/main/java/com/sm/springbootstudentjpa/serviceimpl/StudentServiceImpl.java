package com.sm.springbootstudentjpa.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.springbootstudentjpa.repository.StudentRepository;
import com.sm.springbootstudentjpa.service.StudentService;
import com.sm.springbootstudentjpa.student.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}

	@Override
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		return student.get();
	}

	@Override
	public List<Student> getStudentByName(String firstName, String lastName) {
		List<Student> students = studentRepository.getStudentByName(firstName, lastName);
		return students;
	}

	@Override
	public List<Student> getStudentsByAddress(String address) {

		List<Student> students = studentRepository.findByAddress(address);

		return students;
	}

	@Override
	public List<Student> getStudentsByAgeLessThan(int age) {

		List<Student> students = studentRepository.findByAgeLessThan(age);

		return students;
	}

}
