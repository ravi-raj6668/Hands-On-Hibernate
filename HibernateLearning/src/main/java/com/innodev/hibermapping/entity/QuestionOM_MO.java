package com.innodev.hibermapping.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
public class QuestionOM_MO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3072598892504253840L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;
    private String question;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<AnswerOM_MO> answer;

    public QuestionOM_MO() {
    }

    public QuestionOM_MO(int questionId, String question, List<AnswerOM_MO> answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerOM_MO> getAnswer() {
        return answer;
    }

    public void setAnswer(List<AnswerOM_MO> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionOM_MO{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
