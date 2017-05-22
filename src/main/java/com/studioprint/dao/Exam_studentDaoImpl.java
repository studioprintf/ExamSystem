package com.studioprint.dao;

import com.studioprint.entity.ExamStudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by lucifer on 17-5-22.
 */
@Repository
public class Exam_studentDaoImpl implements Exam_studentDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public Serializable save(ExamStudentEntity studentEntity) {
        return  getSession().save(studentEntity);
    }

    public ExamStudentEntity findById(Serializable id) {
        return getSession().get(ExamStudentEntity.class,id);
    }
}
