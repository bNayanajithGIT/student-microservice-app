package com.student.studenttransactions.repository;

import com.student.studenttransactions.dto.StudentDto;
import com.student.studenttransactions.dto.StudentInfoDto;
import com.student.studenttransactions.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s.id as id, s.fName as fName,s.lName as lName, s.msisdn as msisdn, "
            + " s.status as status,"
            + " s.created_date as createdDate, s.modified_date as modifiedDate"
            + " FROM student_data s"
            + " ORDER BY s.id DESC",
            countQuery = "SELECT count(*) FROM student_data", nativeQuery = true)
    Page<StudentInfoDto> findAllStudents(Pageable pageable);
}
