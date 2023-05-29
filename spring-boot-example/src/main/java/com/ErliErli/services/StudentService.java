package com.ErliErli.services;

import com.ErliErli.entities.Customer;
import com.ErliErli.entities.Student;
import com.ErliErli.repos.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student putStudent(Student student) {
        return studentRepository.save(student);
    }

}