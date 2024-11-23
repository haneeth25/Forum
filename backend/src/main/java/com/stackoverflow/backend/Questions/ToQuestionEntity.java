package com.stackoverflow.backend.Questions;

import com.stackoverflow.backend.Topics.TopicRepository;
import com.stackoverflow.backend.Topics.TopicsEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ToQuestionEntity {

    private TopicRepository topicRepository;

    public ToQuestionEntity(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    public QuestionsEntity ConvertToQuestionEntity(QuestionDto questionDto){

        QuestionsEntity questionsEntity = new QuestionsEntity();
        questionsEntity.setQuestion(questionDto.getQuestion());
        questionsEntity.setHeading(questionDto.getHeading());
        questionsEntity.setUserName(questionDto.getUserName());
        Set<TopicsEntity> topics = new HashSet<>();

        String all_topics = questionDto.getTopics();
        String[] all_topic = all_topics.split(",");
        for(String each : all_topic){
            TopicsEntity topicsEntity = this.topicRepository.findByTopicName(each);
            if (topicsEntity == null){
                topicsEntity = new TopicsEntity();
                topicsEntity.setTopicName(each.toLowerCase());
            }
            topics.add(topicsEntity);
        }
        questionsEntity.setTopics(topics);
        return questionsEntity;

    }
}
