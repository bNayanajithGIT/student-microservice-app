package com.student.studenttransactions.service;

import com.student.studenttransactions.dto.StudentDto;
import com.student.studenttransactions.dto.StudentInfoDto;
import com.student.studenttransactions.entity.Student;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentInfoDto> getAllStudents(Optional<Integer> pageNumber, Optional<Integer> pageAmount);

    Student createStudent(StudentDto studentDto);

    Student saveStudent(Student student);
}
