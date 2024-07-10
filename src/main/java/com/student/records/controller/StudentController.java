package com.student.records.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.records.entity.Student;
import com.student.records.exception.StudentRecordsException;
import com.student.records.service.StudentService;
import com.student.records.util.ConstantUtil;



@RequestMapping("/api/v1/")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) throws StudentRecordsException, IOException {
        if (file.isEmpty()) {
        	 throw new StudentRecordsException(HttpStatus.BAD_REQUEST, com.student.records.util.ConstantUtil.CSV_NOT_VALID);	
        }

        studentService.saveStudentsFromCsv(file);
        return new ResponseEntity<>(ConstantUtil.FILE_UPLOAD_SUCCESSFUL, HttpStatus.OK);
    }
    
    
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
