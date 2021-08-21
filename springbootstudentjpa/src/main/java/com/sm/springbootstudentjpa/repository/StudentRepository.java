package com.sm.springbootstudentjpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sm.springbootstudentjpa.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("from Student where firstName=:firstName and lastName=:lastName")
	List<Student> getStudentByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

	List<Student> findByAddress(String address);

	List<Student> findByAgeLessThan(int age);

}
