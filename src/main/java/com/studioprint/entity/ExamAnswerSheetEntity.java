package com.studioprint.entity;

import javax.persistence.*;

/**
 * Created by lucifer on 17-5-18.
 */
@Entity
@Table(name = "exam_answerSheet", schema = "ExamSystem", catalog = "")
public class ExamAnswerSheetEntity {
    private int answerSheetId;
    private double grades;
    private String answerStructure;
    private ExamStudentEntity examStudentByStudentId;
    private ExamPaperEntity examPaperByPaperId;

    @Id
    @Column(name = "answerSheetId", nullable = false)
    public int getAnswerSheetId() {
        return answerSheetId;
    }

    public void setAnswerSheetId(int answerSheetId) {
        this.answerSheetId = answerSheetId;
    }

    @Basic
    @Column(name = "grades", nullable = false, precision = 0)
    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

    @Basic
    @Column(name = "answerStructure", nullable = true, length = -1)
    public String getAnswerStructure() {
        return answerStructure;
    }

    public void setAnswerStructure(String answerStructure) {
        this.answerStructure = answerStructure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamAnswerSheetEntity that = (ExamAnswerSheetEntity) o;

        if (answerSheetId != that.answerSheetId) return false;
        if (Double.compare(that.grades, grades) != 0) return false;
        if (answerStructure != null ? !answerStructure.equals(that.answerStructure) : that.answerStructure != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = answerSheetId;
        temp = Double.doubleToLongBits(grades);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (answerStructure != null ? answerStructure.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "studentId", nullable = false)
    public ExamStudentEntity getExamStudentByStudentId() {
        return examStudentByStudentId;
    }

    public void setExamStudentByStudentId(ExamStudentEntity examStudentByStudentId) {
        this.examStudentByStudentId = examStudentByStudentId;
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
