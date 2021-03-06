package com.sm.springbootstudentjpa.service;

import java.util.List;

import com.sm.springbootstudentjpa.student.Student;

public interface StudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudent();

	public Student getStudentById(Long studId);

	public List<Student> getStudentByName(String firstName, String lastName);

	public List<Student> getStudentsByAddress(String address);

	public List<Student> getStudentsByAgeLessThan(int age);

}
