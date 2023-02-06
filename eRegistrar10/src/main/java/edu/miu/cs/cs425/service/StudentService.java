package edu.miu.cs.cs425.service;

import edu.miu.cs.cs425.dto.StudentRequest;
import edu.miu.cs.cs425.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    public Student addStudent(StudentRequest studentRequest);
    public Student getStudentById(Integer id);
    public Student updateStudent(Integer studentId , StudentRequest student);
    public void deleteStudentById(Integer id);

    Student searchStudent(String studentName);

    Student searchStudentByStudentNumber(String studentNumber);
}
