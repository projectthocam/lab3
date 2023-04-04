package com.fptaptech.lab3.repository.impl;

import com.fptaptech.lab3.model.SiteClass;
import com.fptaptech.lab3.model.SiteClassSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteClassRepository extends JpaRepository<SiteClass , Long> {
    @Query("SELECT sc from SiteClass sc WHERE sc.name =?1")
    public List<SiteClass> findByName(String name);
}
