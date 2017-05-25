package com.studioprint.service;

import com.studioprint.dao.Exam_studentDao;
import com.studioprint.dao.Exam_studentDaoImpl;
import com.studioprint.entity.ExamStudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucifer on 17-5-18.
 */
@Service
@Transactional(readOnly = true)
public class UserManager {
    @Autowired
    Exam_studentDaoImpl exam_studentDao;

    public ExamStudentEntity user_login(String student){
        return exam_studentDao.findById(Integer.parseInt(student));
    }

    @Transactional(readOnly = false)
    public boolean user_register(ExamStudentEntity examStudentEntity){
        System.out.println(exam_studentDao.save(examStudentEntity));
        return true;
    }
}
