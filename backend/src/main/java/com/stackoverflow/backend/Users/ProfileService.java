package com.stackoverflow.backend.Users;

import com.stackoverflow.backend.Answers.AnswerEntity;
import com.stackoverflow.backend.Questions.QuestionsEntity;
import com.stackoverflow.backend.Questions.QuestionsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {


    public ProfileResponse toProfileResponse(UserEntity userEntity, List<QuestionsEntity> questionsEntities, List<AnswerEntity> answerEntities){
        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setUserEntities(userEntity);

        List<QuestionResponseForProfile> questionResponseForProfiles = new ArrayList<>();
        for(QuestionsEntity each:questionsEntities){
            QuestionResponseForProfile questionResponseForProfile = new QuestionResponseForProfile();
            questionResponseForProfile.setQuestionId(each.getQuestionId());
            questionResponseForProfile.setHeading(each.getHeading());
            questionResponseForProfile.setTimestamp(each.getTimestamp());
            questionResponseForProfiles.add(questionResponseForProfile);
        }
        List<AnswerResponseForProfile> answerResponseForProfiles = new ArrayList<>();

        for(AnswerEntity each:answerEntities){
            AnswerResponseForProfile answerResponseForProfile = new AnswerResponseForProfile();
            answerResponseForProfile.setAnswer(each.getAnswer());
            answerResponseForProfile.setTimestamp(each.getTimestamp());
            QuestionsEntity questionsEntity1 = each.getQuestion();
            answerResponseForProfile.setQuestionId(questionsEntity1.getQuestionId());
            answerResponseForProfiles.add(answerResponseForProfile);
        }
        profileResponse.setQuestionResponseForProfiles(questionResponseForProfiles);
        profileResponse.setAnswerResponseForProfiles(answerResponseForProfiles);
        return profileResponse;
    }
}
