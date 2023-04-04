package com.fptaptech.lab3.repository.impl;

import com.fptaptech.lab3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("SELECT s from Student s WHERE s.firstName = ?1")
    public List<Student> findByFirstname(String firstName);
    @Query("SELECT s from Student s WHERE s.email = ?1 or s.phone = ?2")
    public List<Student> findByEmailOrPhone(String email,String phone);
    @Query("SELECT s from Student s WHERE s.lastName = ?1")
    public List<Student> findByLastname(String lastname);
    @Query("select  s from Student s WHERE s.firstName = ?1 or s.lastName = ?1 or s.email = ?1 or s.phone = ?1")
    public List<Student> findByfirstnameOrLastnameOrEmailOrPhone(String firstname , String lastname , String email , String phone);
}
