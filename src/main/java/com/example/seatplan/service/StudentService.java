package com.example.seatplan.service;

import com.example.seatplan.entity.Student;
import com.example.seatplan.exception.ResourceNotFoundException;
import com.example.seatplan.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // CREATE
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        existingStudent.setName(student.getName());
        existingStudent.setRegisterNumber(student.getRegisterNumber());
        existingStudent.setDepartment(student.getDepartment());

        return studentRepository.save(existingStudent);
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}