package com.vtech.RestApiDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vtech.RestApiDemo.entity.Student;
import com.vtech.RestApiDemo.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repo;

	@GetMapping("/student/all")
	public List<Student> getAllStudents() {
		List<Student> allStudent = repo.findAll();
		return allStudent;
	}

	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		Optional<Student> byId = repo.findById(id);
		Student s1 = null;
		if (byId.isPresent()) {
			s1 = byId.get();
		}
		return s1;
	}

	@PostMapping("/student/add")
	public Student addStudent(@RequestBody Student s) {
		Student save = repo.save(s);
		return save;
	}

	@PutMapping("/student/update/{id}")
	public Student updateStudent(@RequestBody Student updateStud, @PathVariable int id) {
		Student oldStudent = repo.findById(id).get();
		oldStudent.setBranch(updateStud.getBranch());
		oldStudent.setName(updateStud.getName());
		oldStudent.setPercentage(updateStud.getPercentage());
		Student updatedStudent = repo.save(oldStudent);
		return updatedStudent;
	}

	@DeleteMapping("/student/delete/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteStudent(@PathVariable int id) {
		repo.deleteById(id);
	}

}
