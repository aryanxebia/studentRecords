package com.student.records.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.student.records.entity.Student;
import com.student.records.exception.StudentRecordsException;

public interface StudentService {
    void saveStudentsFromCsv(MultipartFile file) throws StudentRecordsException, IOException;
    List<Student> getAllStudents();
}
