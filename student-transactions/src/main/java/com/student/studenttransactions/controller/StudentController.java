package com.student.studenttransactions.controller;

import com.student.studenttransactions.dto.StudentDto;
import com.student.studenttransactions.dto.StudentInfoDto;
import com.student.studenttransactions.entity.Student;
import com.student.studenttransactions.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class StudentController {
    public static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    /**
     *Endpoint for student creation
     * @param
     * @return saved Student
     */
    @ResponseBody
    @PostMapping
    public Student createStudent(@RequestBody StudentDto studentDto) {
        log.info("POST Create student");
        return studentService.createStudent(studentDto);
    }

    /**
     *Endpoint for get all students details
     * @param pageAmount
     * @param pageNumber
     * @return valid student list
     */
    @GetMapping(value = "/getAllStudents")
    public @ResponseBody
    List<StudentInfoDto> getAllStudents(@RequestParam(value = "page-number") Optional<Integer> pageNumber,
                                        @RequestParam(value = "page-amount") Optional<Integer> pageAmount) {
        log.info("GET request init student details");
        return studentService.getAllStudents(pageNumber,pageAmount);
    }

    @GetMapping
    public @ResponseBody
    String getAllStudents() {
        log.info("GET request init student details");
        return "TEST";
    }

}
