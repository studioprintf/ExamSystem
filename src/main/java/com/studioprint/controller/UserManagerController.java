package com.studioprint.controller;

import com.studioprint.dao.Exam_studentDao;
import com.studioprint.entity.ExamStudentEntity;
import com.studioprint.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lucifer on 17-5-18.
 */
@Controller
@RequestMapping(value = "/user")
public class UserManagerController {

    @Autowired
    UserManager userManager;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String loginPage(ExamStudentEntity examStudentEntity){
        return "user/loginPage";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(ExamStudentEntity examStudentEntity){
        userManager.user_login(examStudentEntity);
        return "index";
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String registerPage(ExamStudentEntity examStudentEntity){
        return "user/registerPage";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(ExamStudentEntity examStudentEntity){
        userManager.user_register(examStudentEntity);
        return "index";
    }
}
