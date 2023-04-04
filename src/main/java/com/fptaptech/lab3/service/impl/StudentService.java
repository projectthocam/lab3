package com.fptaptech.lab3.service.impl;

import com.fptaptech.lab3.model.Student;
import com.fptaptech.lab3.model.StudentSearch;

import java.util.List;
import java.util.Set;

public interface StudentService {
    public List<Student> list();
    public void add(Student s);
    public Set<Student> search(StudentSearch studentSearch);
    public Student detail(int id);
}
