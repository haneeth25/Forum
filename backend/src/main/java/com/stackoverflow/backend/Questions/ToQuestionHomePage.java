package com.stackoverflow.backend.Questions;

import com.stackoverflow.backend.Topics.CustomTopicDto;
import com.stackoverflow.backend.Topics.TopicsEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ToQuestionHomePage {
    private List<TopicsEntity> validTopics;
    private List<CustomQuestionDto> customQuestionDtoList;
    private List<CustomTopicDto> customTopicDtoList;

    public QuestionTopicResponse homePageFormat(List<QuestionsEntity> questions , List<TopicsEntity> topics,String user){
        validTopics = new ArrayList<>();
        customQuestionDtoList = new ArrayList<>();
        customTopicDtoList = new ArrayList<>();
        for (QuestionsEntity each:questions){
            CustomQuestionDto customQuestionDto1 = new CustomQuestionDto();
            customQuestionDto1.setQuestionId(each.getQuestionId());
            customQuestionDto1.setHeading(each.getHeading());
            customQuestionDto1.setQuestion(each.getQuestion());
            customQuestionDto1.setTimestamp(each.getTimestamp());
            customQuestionDto1.setUserName(each.getUserName());
            System.out.println(each.getUserName()+user);
            if (user.equals(each.getUserName())){
                customQuestionDto1.setCanDelete(true);
            }
            else{
                customQuestionDto1.setCanDelete(false);
            }
            Set<TopicsEntity> topicEntity= each.getTopics();
            String topic_combined = "";
            for(TopicsEntity each_topic: topicEntity){
                topic_combined = topic_combined + (each_topic.getTopicName())+",";
            }
            customQuestionDto1.setTopics(topic_combined.substring(0, topic_combined.length() - 1));
            customQuestionDtoList.add(customQuestionDto1);
        }

        List<Integer> uniqueTopicId = new ArrayList<>();
        for (TopicsEntity each : topics) {
            // Get the list of questions associated with the topic
            Set<QuestionsEntity> temp = each.getQuestions(); // Assuming you have a method to get questions
            if (temp != null && !temp.isEmpty()) { // Check if questions are not null and not empty
                // Create a new CustomTopicDto
                CustomTopicDto customTopicDto1 = new CustomTopicDto();
                customTopicDto1.setTopicId(each.getTopicId());
                customTopicDto1.setTopicName(each.getTopicName());
                customTopicDto1.setQuestionCount(temp.size()); // Use the size of temp
                if (!uniqueTopicId.contains(each.getTopicId())){
                    customTopicDtoList.add(customTopicDto1);
                    uniqueTopicId.add(each.getTopicId());
                }
                // Print to verify values
                System.out.println("Topic ID: " + each.getTopicId() + ", Topic Name: " + each.getTopicName() + ", Question Count: " + temp.size());
            }
        }
        //customTopicDtoList.remove(0);
        Comparator<CustomTopicDto> compare_on_question_count = (CustomTopicDto i,CustomTopicDto j)->{
            if(i.getQuestionCount()<j.getQuestionCount()){
                return 1;
            }
            else{
                return -1;
            }
        };
        Collections.sort(customTopicDtoList,compare_on_question_count);
        QuestionTopicResponse homePageFormat = new QuestionTopicResponse(customQuestionDtoList,customTopicDtoList);
        return homePageFormat;
    }
}
