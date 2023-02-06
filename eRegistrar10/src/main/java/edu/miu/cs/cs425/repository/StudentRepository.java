package edu.miu.cs.cs425.repository;

import edu.miu.cs.cs425.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.studentNumber = :studentNumber")
    Optional<Student> findStudentByStudentNumber(String studentNumber);



    @Query("select s from Student s where s.firstName = :studentName or s.middleName = :studentName or s.lastName = :studentName")
    Optional<Student> findStudentByName(String studentName);



    @Query("update Student s set s.firstName = :firstName, " +
            "s.middleName = :middleName, s.lastName = :lastName, " +
            "s.cgpa = :cgpa, s.enrollmentDate = :enrollmentDate, " +
            "s.isInternational = :isInternational " +
            "where s.studentId = :studentId")
    Optional<Student> updateStudent(String studentId, String firstName, String middleName, String lastName, Float cgpa, LocalDate enrollmentDate, Boolean isInternational);
}