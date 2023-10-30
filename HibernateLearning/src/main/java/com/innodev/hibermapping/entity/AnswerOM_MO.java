package com.innodev.hibermapping.entity;

import javax.persistence.*;

@Entity
public class AnswerOM_MO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @ManyToOne
    private QuestionOM_MO question;

    public AnswerOM_MO() {
    }

    public AnswerOM_MO(int answerId, String answer, QuestionOM_MO question) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionOM_MO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionOM_MO question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "AnswerOM_MO{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }
}
