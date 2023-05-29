package com.ErliErli.controllers;

import com.ErliErli.entities.Customer;
import com.ErliErli.entities.Student;
import com.ErliErli.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    record newStudentRequest(String name, String email, Integer age){}
    @PostMapping
    public void addStudent(@RequestBody StudentController.newStudentRequest request) {
        Student student = new Student();
        student.setName(request.name());
        student.setEmail(request.email());
        student.setAge(request.age());
        studentService.saveStudent(student);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody StudentController.newStudentRequest request) {
        Student student = new Student();
        student.setId(id);
        student.setName(request.name());
        student.setEmail(request.email());
        student.setAge(request.age());
        studentService.putStudent(student);
    }

}