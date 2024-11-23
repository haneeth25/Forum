package com.stackoverflow.backend.Answers;

import java.time.LocalDateTime;
import java.util.List;

public class AnswerResponse {
    private String question;
    private String headline;
    private LocalDateTime timestamp;
    private String topics;
    private List<SendAnswerDto> answers;


    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<SendAnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<SendAnswerDto> answers) {
        this.answers = answers;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
