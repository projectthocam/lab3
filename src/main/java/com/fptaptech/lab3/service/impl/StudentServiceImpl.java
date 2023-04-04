package com.fptaptech.lab3.service.impl;

import com.fptaptech.lab3.model.Student;
import com.fptaptech.lab3.model.StudentSearch;
import com.fptaptech.lab3.repository.impl.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @Override
    public void add(Student s) {
        studentRepository.save(s);
    }

    @Override
    public Set<Student> search(StudentSearch studentSearch) {
        Set<Student> result = new HashSet<>();
        if(!"".equals(studentSearch.getFirstName()))
        {
            result.addAll(studentRepository.findByFirstname(studentSearch.getFirstName()));
        }
        if(!"".equals(studentSearch.getLastName()))
        {
            result.addAll(studentRepository.findByLastname((studentSearch.getLastName())));
        }
        if(!"".equals(studentSearch.getEmail()) && !"".equals(studentSearch.getPhone()))
        {
            result.addAll(studentRepository.findByEmailOrPhone(studentSearch.getEmail() , studentSearch.getPhone()));
        }
        if(!"".equals(studentSearch.getFirstName()) && !"".equals(studentSearch.getLastName()) && !"".equals(studentSearch.getEmail()) && !"".equals(studentSearch.getPhone()))
        {
            result.addAll(studentRepository.findByfirstnameOrLastnameOrEmailOrPhone(studentSearch.getFirstName(),studentSearch.getLastName(),studentSearch.getEmail(),studentSearch.getPhone()));
        }
        return result;
    }

    @Override
    public Student detail(int id) {
        return studentRepository.getById(id);
    }
}
