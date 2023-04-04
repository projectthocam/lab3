package com.fptaptech.lab3.controller;

import com.fptaptech.lab3.model.SiteClass;
import com.fptaptech.lab3.model.SiteClassSearch;
import com.fptaptech.lab3.service.impl.SiteClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/siteClass")
public class  SiteClassController {
    @Autowired
    SiteClassService siteClassService;
    @GetMapping("/siteClass-add")
    public String addSiteClass(Model model){
        model.addAttribute("siteClass", new SiteClass());
        return "/siteClass/add-siteClass";
    }
    @PostMapping("/save-siteClass")
    public String saveSiteClass(@ModelAttribute("siteClass") SiteClass siteClass , BindingResult result , ModelMap modelMap)
    {
        siteClassService.add(siteClass);
        return "redirect:/siteClass/siteClass-list";
    }
    @GetMapping("/siteClass-list")
    public String list(Model model)
    {
        model.addAttribute("siteClassSearch",new SiteClassSearch());
        model.addAttribute("list",siteClassService.list());
        return "/siteClass/siteClass-list";
    }
    @PostMapping("search-siteClass")
    public String search(@ModelAttribute("siteClassSearch") SiteClassSearch siteClassSearch , BindingResult result , ModelMap modelMap)
    {
        modelMap.addAttribute("list",siteClassService.search(siteClassSearch));
        modelMap.addAttribute("siteClassSearch", siteClassSearch);
        return "/siteClass/siteClass-list";
    }
    @GetMapping("/detail-siteClass/{id}")
    public String detailSiteClass(@PathVariable Long id, Model model){
        SiteClass siteClass = siteClassService.detail(id);
        model.addAttribute("siteClass",siteClass);
        return "siteClass/detail-siteClass";
    }
}
