package com.student.records.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.student.records.exception.StudentRecordsException;

public interface StudentService {
    void saveStudentsFromCsv(MultipartFile file) throws StudentRecordsException, IOException;
}
