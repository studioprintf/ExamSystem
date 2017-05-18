package com.studioprint.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by lucifer on 17-5-18.
 */
@Entity
@Table(name = "exam_teacher", schema = "ExamSystem", catalog = "")
public class ExamTeacherEntity {
    private int teacherId;
    private String teacherName;
    private String teacherPasswd;
    private String manageClass;
    private Collection<ExamPaperEntity> examPapersByTeacherId;

    @Id
    @Column(name = "teacherId", nullable = false)
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "teacherName", nullable = false, length = 45)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "teacherPasswd", nullable = false, length = 45)
    public String getTeacherPasswd() {
        return teacherPasswd;
    }

    public void setTeacherPasswd(String teacherPasswd) {
        this.teacherPasswd = teacherPasswd;
    }

    @Basic
    @Column(name = "manageClass", nullable = true, length = 45)
    public String getManageClass() {
        return manageClass;
    }

    public void setManageClass(String manageClass) {
        this.manageClass = manageClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamTeacherEntity that = (ExamTeacherEntity) o;

        if (teacherId != that.teacherId) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (teacherPasswd != null ? !teacherPasswd.equals(that.teacherPasswd) : that.teacherPasswd != null)
            return false;
        if (manageClass != null ? !manageClass.equals(that.manageClass) : that.manageClass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherId;
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (teacherPasswd != null ? teacherPasswd.hashCode() : 0);
        result = 31 * result + (manageClass != null ? manageClass.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "examTeacherByPaperAuthor")
    public Collection<ExamPaperEntity> getExamPapersByTeacherId() {
        return examPapersByTeacherId;
    }

    public void setExamPapersByTeacherId(Collection<ExamPaperEntity> examPapersByTeacherId) {
        this.examPapersByTeacherId = examPapersByTeacherId;
    }
}
