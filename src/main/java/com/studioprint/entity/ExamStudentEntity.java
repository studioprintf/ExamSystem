package com.studioprint.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by lucifer on 17-5-18.
 */
@Entity
@Table(name = "exam_student", schema = "ExamSystem", catalog = "")
public class ExamStudentEntity {
    private int studentId;
    private String studentName;
    private String studentPasswd;
    private int studentClass;
    private Collection<ExamAnswerSheetEntity> examAnswerSheetsByStudentId;

    @Id
    @Column(name = "studentId", nullable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "studentName", nullable = false, length = 45)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "studentPasswd", nullable = false, length = 45)
    public String getStudentPasswd() {
        return studentPasswd;
    }

    public void setStudentPasswd(String studentPasswd) {
        this.studentPasswd = studentPasswd;
    }

    @Basic
    @Column(name = "studentClass", nullable = false)
    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamStudentEntity that = (ExamStudentEntity) o;

        if (studentId != that.studentId) return false;
        if (studentClass != that.studentClass) return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        if (studentPasswd != null ? !studentPasswd.equals(that.studentPasswd) : that.studentPasswd != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (studentPasswd != null ? studentPasswd.hashCode() : 0);
        result = 31 * result + studentClass;
        return result;
    }

    @OneToMany(mappedBy = "examStudentByStudentId")
    public Collection<ExamAnswerSheetEntity> getExamAnswerSheetsByStudentId() {
        return examAnswerSheetsByStudentId;
    }

    public void setExamAnswerSheetsByStudentId(Collection<ExamAnswerSheetEntity> examAnswerSheetsByStudentId) {
        this.examAnswerSheetsByStudentId = examAnswerSheetsByStudentId;
    }
}
