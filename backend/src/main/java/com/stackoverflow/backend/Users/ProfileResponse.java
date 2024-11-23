package com.stackoverflow.backend.Users;

import com.stackoverflow.backend.Answers.AnswerEntity;
import com.stackoverflow.backend.Questions.QuestionsEntity;

import java.util.List;

public class ProfileResponse {
    UserEntity userEntities;

    List<AnswerResponseForProfile> answerResponseForProfiles;
    List<QuestionResponseForProfile> questionResponseForProfiles;

    public UserEntity getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(UserEntity userEntities) {
        this.userEntities = userEntities;
    }

    public List<AnswerResponseForProfile> getAnswerResponseForProfiles() {
        return answerResponseForProfiles;
    }

    public void setAnswerResponseForProfiles(List<AnswerResponseForProfile> answerResponseForProfiles) {
        this.answerResponseForProfiles = answerResponseForProfiles;
    }

    public List<QuestionResponseForProfile> getQuestionResponseForProfiles() {
        return questionResponseForProfiles;
    }

    public void setQuestionResponseForProfiles(List<QuestionResponseForProfile> questionResponseForProfiles) {
        this.questionResponseForProfiles = questionResponseForProfiles;
    }
}
