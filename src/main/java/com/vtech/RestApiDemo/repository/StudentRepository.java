package com.vtech.RestApiDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtech.RestApiDemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
