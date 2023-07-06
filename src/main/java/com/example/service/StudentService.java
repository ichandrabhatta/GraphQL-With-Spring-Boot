package com.example.service;

import com.example.entity.Student;
import com.example.repository.AddressRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public List<Student> getAllStudents () {
        return studentRepository.findAll();
    }

    public String getFirstNameById (int id) {
        return studentRepository.findById(id).get().getFirstName();
    }
    public String getLastNameById (int id) {
        return studentRepository.findById(id).get().getLastName();
    }

    public Student getStudentById(Integer id) {

        return studentRepository.findById(id).get();
    }

}
