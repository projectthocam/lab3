package com.fptaptech.lab3.service.impl;

import com.fptaptech.lab3.model.SiteClass;
import com.fptaptech.lab3.model.SiteClassSearch;

import java.util.List;

public interface SiteClassService {
    public void add(SiteClass siteClass);
    public List<SiteClass> list();
    public List<SiteClass> search(SiteClassSearch siteClassSearch);
    public SiteClass detail(long id);

}
