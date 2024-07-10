package com.student.records.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.student.records.dao.StudentRepository;
import com.student.records.entity.Student;
import com.student.records.exception.StudentRecordsException;
import com.student.records.service.StudentService;
import com.student.records.util.ConstantUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudentsFromCsv(MultipartFile file) throws StudentRecordsException, IOException {
        Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        HeaderColumnNameTranslateMappingStrategy<Student> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(Student.class);
        Map<String, String> mapping = new HashMap<>();
        mapping.put("studentId", "studentId");
        mapping.put("name", "name");
        mapping.put("department", "department");
        mapping.put("address", "address");
        mapping.put("phoneNumber", "phoneNumber");
        strategy.setColumnMapping(mapping);

        CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                .withMappingStrategy(strategy)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        List<Student> students = csvToBean.parse();

        for (Student student : students) {
            if (student.getStudentId() == null || student.getStudentId().isEmpty()) {
                throw new StudentRecordsException(HttpStatus.BAD_REQUEST, ConstantUtil.INVALID_STUDENT_ID);
            }
        }

        studentRepository.saveAll(students);
    }
}
