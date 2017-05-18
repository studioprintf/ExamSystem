package com.studioprint.controller;

import com.studioprint.entity.ExamStudentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lucifer on 17-5-18.
 */
@Controller
@RequestMapping(value = "/user")
public class UserManagerController {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String loginPage(ExamStudentEntity examStudentEntity){
        return "user/loginPage";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(){
        return "index";
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String registerPage(){
        return "user/registerPage";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(){
        return "index";
    }
}
