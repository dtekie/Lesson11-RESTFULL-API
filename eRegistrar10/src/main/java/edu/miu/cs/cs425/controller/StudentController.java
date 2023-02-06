package edu.miu.cs.cs425.controller;


import edu.miu.cs.cs425.dto.StudentRequest;
import edu.miu.cs.cs425.model.Student;
import edu.miu.cs.cs425.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Controller
@RequestMapping(value = "/eregister/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Student>> students() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping(value = {"/searchById/{id}"})
    public ResponseEntity<Student> searchStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping(value = {"/add"})
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequest student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @PutMapping(value = {"/update/{id}"})
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody StudentRequest student) {
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{id}"})
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = {"/search/{search}"})
    public ResponseEntity<Student> searchStudent(@PathVariable String search) {
        return ResponseEntity.ok(studentService.searchStudent(search));
    }
}
