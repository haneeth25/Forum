package com.stackoverflow.backend.Answers;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.stackoverflow.backend.Questions.QuestionsEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="answers")
public class AnswerEntity {

    @Id
    @GeneratedValue
    private Integer answerId;
    @Lob
    private String answer;
    private String userName;
    private LocalDateTime timestamp = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonBackReference
    private QuestionsEntity question;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionsEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionsEntity question) {
        this.question = question;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
