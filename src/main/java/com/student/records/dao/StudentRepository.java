package com.student.records.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.records.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
