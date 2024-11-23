package com.stackoverflow.backend.Answers;

import com.stackoverflow.backend.Questions.QuestionsEntity;
import com.stackoverflow.backend.Questions.QuestionsRepository;
import com.stackoverflow.backend.Topics.TopicRepository;
import com.stackoverflow.backend.Topics.TopicsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AnswersService {
    private QuestionsRepository questionsRepository;
    private AnswerRepository answerRepository;
    private QuestionsEntity questionsEntity;
    private List<AnswerEntity> answerEntity;
    private Integer questionId;
    private List<SendAnswerDto> answers;
    public AnswersService(QuestionsRepository questionsRepository,AnswerRepository answerRepository){
        this.questionsRepository  = questionsRepository;
        this.answerRepository = answerRepository;
    }

    public AnswerResponse toAnswerResponse(Integer questionId){
        this.questionId = questionId;
        AnswerResponse answerResponse = new AnswerResponse();
        questionsEntity = questionsRepository.findByQuestionIdOrderByTimestampDesc(this.questionId);
        answerResponse.setQuestion(questionsEntity.getQuestion());
        answerResponse.setHeadline(questionsEntity.getHeading());
        answerResponse.setTimestamp(questionsEntity.getTimestamp());
        Set<TopicsEntity> topics = questionsEntity.getTopics();
        String combined_topic = "";
        for(TopicsEntity each:topics){
            combined_topic = combined_topic + each.getTopicName()+",";
        }
        answerResponse.setTopics(combined_topic.substring(0,combined_topic.length()-1));
        answerEntity = answerRepository.findByQuestionQuestionId(this.questionId);
        answers = new ArrayList<>();
        for (AnswerEntity each:answerEntity){
            SendAnswerDto sendAnswerDto = new SendAnswerDto();
            sendAnswerDto.setAnswerId(each.getAnswerId());
            sendAnswerDto.setAnswer(each.getAnswer());
            sendAnswerDto.setTimestamp(each.getTimestamp());
            sendAnswerDto.setUserName(each.getUserName());
            answers.add(sendAnswerDto);
        }
        answerResponse.setAnswers(answers);
        return answerResponse;
    }
    public void toSaveAnswer(GetAnswerDto getAnswerDto){
        AnswerEntity answerentity = new AnswerEntity();
        answerentity.setAnswer(getAnswerDto.getAnswer());
        answerentity.setUserName(getAnswerDto.getUserName());
        questionsEntity = questionsRepository.findByQuestionIdOrderByTimestampDesc(getAnswerDto.getQuestionId());
        answerentity.setQuestion(questionsEntity);
        answerRepository.save(answerentity);
    }
}
