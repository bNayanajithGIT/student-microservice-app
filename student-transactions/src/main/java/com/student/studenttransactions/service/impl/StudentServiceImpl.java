package com.student.studenttransactions.service.impl;

import com.student.studenttransactions.dto.StudentDto;
import com.student.studenttransactions.dto.StudentInfoDto;
import com.student.studenttransactions.entity.Student;
import com.student.studenttransactions.enums.UserStatus;
import com.student.studenttransactions.repository.StudentRepository;
import com.student.studenttransactions.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentInfoDto> getAllStudents(Optional<Integer> pageNumber, Optional<Integer> pageAmount) {
        log.info("Getting Student Details from DB");

        Pageable page = PageRequest.of(pageNumber.orElse(0), Integer.MAX_VALUE);

        if(pageNumber.isPresent() && pageAmount.isPresent())
            page = PageRequest.of(pageNumber.get(), pageAmount.get());


        return studentRepository.findAllStudents(page).getContent();
    }

    @Override
    @Transactional
    public Student createStudent(StudentDto studentDto) {
        log.info("Create Student : {}", studentDto);

        //Generate UUID for Operation
        UUID uuid = UUID.randomUUID();
        Student student = createStudentFromStudentDto(studentDto);
        student.setMsisdn(uuid.toString());

        student = saveStudent(student);
        return student;
    }

    private Student createStudentFromStudentDto(StudentDto studentDto) {
        Student student = new Student();
        student.setfName(studentDto.getfName());
        student.setlName(studentDto.getlName());
        student.setMsisdn(studentDto.getMsisdn());
        student.setStatus(UserStatus.ACTIVE.getName());

        return student;
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        student = studentRepository.save(student);
        log.info("Student is saved id {}", student.getId());
        return student;
    }
}
