package com.student.records.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.records.exception.StudentRecordsException;
import com.student.records.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) throws StudentRecordsException, IOException {
        if (file.isEmpty()) {
        	 throw new StudentRecordsException(HttpStatus.BAD_REQUEST, com.student.records.util.ConstantUtil.CSV_NOT_VALID);	
        }

        studentService.saveStudentsFromCsv(file);
        return new ResponseEntity<>("File uploaded and data saved to database!", HttpStatus.OK);
    }
}
