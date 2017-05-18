package com.studioprint.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by lucifer on 17-5-18.
 */
@Entity
@Table(name = "exam_paper", schema = "ExamSystem", catalog = "")
public class ExamPaperEntity {
    private int paperid;
    private String paperStructure;
    private int score;
    private Collection<ExamAnswerSheetEntity> examAnswerSheetsByPaperid;
    private ExamTeacherEntity examTeacherByPaperAuthor;
    private Collection<ExamTestEntity> examTestsByPaperid;

    @Id
    @Column(name = "paperid", nullable = false)
    public int getPaperid() {
        return paperid;
    }

    public void setPaperid(int paperid) {
        this.paperid = paperid;
    }

    @Basic
    @Column(name = "paperStructure", nullable = false, length = -1)
    public String getPaperStructure() {
        return paperStructure;
    }

    public void setPaperStructure(String paperStructure) {
        this.paperStructure = paperStructure;
    }

    @Basic
    @Column(name = "score", nullable = false)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamPaperEntity that = (ExamPaperEntity) o;

        if (paperid != that.paperid) return false;
        if (score != that.score) return false;
        if (paperStructure != null ? !paperStructure.equals(that.paperStructure) : that.paperStructure != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paperid;
        result = 31 * result + (paperStructure != null ? paperStructure.hashCode() : 0);
        result = 31 * result + score;
        return result;
    }

    @OneToMany(mappedBy = "examPaperByPaperId")
    public Collection<ExamAnswerSheetEntity> getExamAnswerSheetsByPaperid() {
        return examAnswerSheetsByPaperid;
    }

    public void setExamAnswerSheetsByPaperid(Collection<ExamAnswerSheetEntity> examAnswerSheetsByPaperid) {
        this.examAnswerSheetsByPaperid = examAnswerSheetsByPaperid;
    }

    @ManyToOne
    @JoinColumn(name = "paperAuthor", referencedColumnName = "teacherId", nullable = false)
    public ExamTeacherEntity getExamTeacherByPaperAuthor() {
        return examTeacherByPaperAuthor;
    }

    public void setExamTeacherByPaperAuthor(ExamTeacherEntity examTeacherByPaperAuthor) {
        this.examTeacherByPaperAuthor = examTeacherByPaperAuthor;
    }

    @OneToMany(mappedBy = "examPaperByPaperId")
    public Collection<ExamTestEntity> getExamTestsByPaperid() {
        return examTestsByPaperid;
    }

    public void setExamTestsByPaperid(Collection<ExamTestEntity> examTestsByPaperid) {
        this.examTestsByPaperid = examTestsByPaperid;
    }
}
