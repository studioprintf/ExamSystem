package com.studioprint.entity;

import javax.persistence.*;

/**
 * Created by lucifer on 17-5-18.
 */
@Entity
@Table(name = "exam_subject", schema = "ExamSystem", catalog = "")
public class ExamSubjectEntity {
    private int subjectId;
    private String subjectType;
    private String subjectMain;
    private String subjectOptions;
    private String subjectAnswer;

    @Id
    @Column(name = "subjectId", nullable = false)
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "subjectType", nullable = false, length = 45)
    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    @Basic
    @Column(name = "subjectMain", nullable = false, length = 255)
    public String getSubjectMain() {
        return subjectMain;
    }

    public void setSubjectMain(String subjectMain) {
        this.subjectMain = subjectMain;
    }

    @Basic
    @Column(name = "subjectOptions", nullable = true, length = 255)
    public String getSubjectOptions() {
        return subjectOptions;
    }

    public void setSubjectOptions(String subjectOptions) {
        this.subjectOptions = subjectOptions;
    }

    @Basic
    @Column(name = "subjectAnswer", nullable = true, length = 45)
    public String getSubjectAnswer() {
        return subjectAnswer;
    }

    public void setSubjectAnswer(String subjectAnswer) {
        this.subjectAnswer = subjectAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamSubjectEntity that = (ExamSubjectEntity) o;

        if (subjectId != that.subjectId) return false;
        if (subjectType != null ? !subjectType.equals(that.subjectType) : that.subjectType != null) return false;
        if (subjectMain != null ? !subjectMain.equals(that.subjectMain) : that.subjectMain != null) return false;
        if (subjectOptions != null ? !subjectOptions.equals(that.subjectOptions) : that.subjectOptions != null)
            return false;
        if (subjectAnswer != null ? !subjectAnswer.equals(that.subjectAnswer) : that.subjectAnswer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectId;
        result = 31 * result + (subjectType != null ? subjectType.hashCode() : 0);
        result = 31 * result + (subjectMain != null ? subjectMain.hashCode() : 0);
        result = 31 * result + (subjectOptions != null ? subjectOptions.hashCode() : 0);
        result = 31 * result + (subjectAnswer != null ? subjectAnswer.hashCode() : 0);
        return result;
    }
}
