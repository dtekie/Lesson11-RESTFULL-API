package edu.miu.cs.cs425.service.studentImpl;

import edu.miu.cs.cs425.dto.StudentRequest;
import edu.miu.cs.cs425.model.Student;
import edu.miu.cs.cs425.repository.StudentRepository;
import edu.miu.cs.cs425.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {

        var newStudent = new Student(null,
                studentRequest.getStudentNumber(),
                studentRequest.getFirstName()
                ,studentRequest.getMiddleName()
                ,studentRequest.getLastName()
                ,studentRequest.getCgpa()
                ,studentRequest.getEnrollmentDate()
                        ,studentRequest.getIsInternational());

        return studentRepository.save(newStudent) ;
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(null);


    }

    @Override
    public Student updateStudent(Integer studentId , StudentRequest studentRequest) {
//
        var student= getStudentById(studentId);
            student.setStudentNumber(studentRequest.getStudentNumber());
            student.setFirstName(studentRequest.getFirstName());
               student.setMiddleName(studentRequest.getMiddleName());
             student.setLastName(studentRequest.getLastName());
                student.setCgpa(studentRequest.getCgpa());
       student.setEnrollmentDate(studentRequest.getEnrollmentDate());
        student.setIsInternational(studentRequest.getIsInternational());

//
//        var student = studentRepository.updateStudent(
//                studentRequest.getStudentNumber(),
//                studentRequest.getFirstName(),
//                studentRequest.getMiddleName(),
//                studentRequest.getLastName(),
//                studentRequest.getCgpa(),
//                studentRequest.getEnrollmentDate(),
//                studentRequest.getIsInternational());
//       // studentRepository.save(student);
//
        return studentRepository.save(student);
//
    }

    @Override
    public void deleteStudentById(Integer id) {

        studentRepository.deleteById(id);

    }


    public Student searchStudent(String studentName) {
        return studentRepository.findStudentByName(studentName).orElse(null);
    }

    @Override
    public Student searchStudentByStudentNumber(String studentNumber) {
        return studentRepository.findStudentByStudentNumber(studentNumber).orElse(null);
    }



}
