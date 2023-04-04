package com.fptaptech.lab3.service.impl;

import com.fptaptech.lab3.model.SiteClass;
import com.fptaptech.lab3.model.SiteClassSearch;
import com.fptaptech.lab3.repository.impl.SiteClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteClassServiceImpl implements SiteClassService{
    @Autowired
    private SiteClassRepository siteClassRepository;
    SiteClassService siteClassService;
    @Override
    public void add(SiteClass siteClass) {

        siteClassRepository.save(siteClass);
    }

    @Override
    public List<SiteClass> list() {
        return siteClassRepository.findAll();
    }

    @Override
    public List<SiteClass> search(SiteClassSearch siteClassSearch)
    {
        List<SiteClass> result = new ArrayList<>();
        if(!"".equals(siteClassSearch.getName()))
        {
            result.addAll(siteClassRepository.findByName(siteClassSearch.getName()));
        }
        return result;
    }

    @Override
    public SiteClass detail(long id) {
        return siteClassRepository.getById(id);
    }
}
