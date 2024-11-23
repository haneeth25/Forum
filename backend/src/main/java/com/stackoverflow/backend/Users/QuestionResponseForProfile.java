package com.stackoverflow.backend.Users;

import java.time.LocalDateTime;

public class QuestionResponseForProfile {
    private Integer questionId;
    private String Heading;
    private LocalDateTime timestamp;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

