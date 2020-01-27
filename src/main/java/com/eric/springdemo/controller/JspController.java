package com.eric.springdemo.controller;

import com.eric.springdemo.config.MyConfigBean;
import com.eric.springdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @Autowired
    private MyConfigBean myConfigBean;

    @GetMapping(value = "/index")
    public String toIndex(Model model){
        model.addAttribute("person", new Person(myConfigBean.getMyId(), myConfigBean.getMyName(), myConfigBean.getMyGender()));
        return "index";
    }

}
