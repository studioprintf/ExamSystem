package com.studioprint.dao;

import com.studioprint.entity.ExamStudentEntity;

import java.io.Serializable;

/**
 * Created by lucifer on 17-5-22.
 */
public interface Exam_studentDao {
    Serializable save(ExamStudentEntity studentEntity);
    ExamStudentEntity findById(Serializable id);
}
