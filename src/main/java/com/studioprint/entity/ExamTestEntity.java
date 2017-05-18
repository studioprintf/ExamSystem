package com.studioprint.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by lucifer on 17-5-18.
 */
@Entity
@Table(name = "exam_test", schema = "ExamSystem", catalog = "")
public class ExamTestEntity {
    private int testId;
    private Integer studentClass;
    private Time testTime;
    private ExamPaperEntity examPaperByPaperId;

    @Id
    @Column(name = "testId", nullable = false)
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "studentClass", nullable = true)
    public Integer getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Integer studentClass) {
        this.studentClass = studentClass;
    }

    @Basic
    @Column(name = "testTime", nullable = false)
    public Time getTestTime() {
        return testTime;
    }

    public void setTestTime(Time testTime) {
        this.testTime = testTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamTestEntity that = (ExamTestEntity) o;

        if (testId != that.testId) return false;
        if (studentClass != null ? !studentClass.equals(that.studentClass) : that.studentClass != null) return false;
        if (testTime != null ? !testTime.equals(that.testTime) : that.testTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId;
        result = 31 * result + (studentClass != null ? studentClass.hashCode() : 0);
        result = 31 * result + (testTime != null ? testTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "paperId", referencedColumnName = "paperid", nullable = false)
    public ExamPaperEntity getExamPaperByPaperId() {
        return examPaperByPaperId;
    }

    public void setExamPaperByPaperId(ExamPaperEntity examPaperByPaperId) {
        this.examPaperByPaperId = examPaperByPaperId;
    }
}
