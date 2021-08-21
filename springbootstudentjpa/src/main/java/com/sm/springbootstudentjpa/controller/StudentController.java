package com.sm.springbootstudentjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sm.springbootstudentjpa.service.StudentService;
import com.sm.springbootstudentjpa.student.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/studentsdata")
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {
		Student savedStudent = studentService.saveStudent(student);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> listOfAllStuds=studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(listOfAllStuds,HttpStatus.OK); 
	}

	@GetMapping("/students-id/{studentId}")
	public ResponseEntity<?> getStudentById(@RequestParam Long studentId) {
		Student studRetrieved=studentService.getStudentById(studentId);
		return new ResponseEntity<Student>(studRetrieved,HttpStatus.OK);
	}

	@GetMapping("/students-name")
	public ResponseEntity<List<Student>> getStudentByName(@RequestParam String firstName, @RequestParam String lastName) {
		List<Student> listOfStuds=studentService.getStudentByName(firstName, lastName);
		return new ResponseEntity<List<Student>>(listOfStuds,HttpStatus.OK);
	}

	@GetMapping("/students-address")
	public ResponseEntity<List<Student>> getStudentsByAddress(@RequestParam String address) {
		List<Student> listOfStuds=studentService.getStudentsByAddress(address);
		return new ResponseEntity<List<Student>>(listOfStuds,HttpStatus.OK);
	
	}

	@GetMapping("/students-age")
	public ResponseEntity<List<Student>> getStudentsByAgeLessThan(@RequestParam int age) {
		List<Student> listOfStuds=studentService.getStudentsByAgeLessThan(age);
		return new ResponseEntity<List<Student>>(listOfStuds,HttpStatus.OK);

	}

}
