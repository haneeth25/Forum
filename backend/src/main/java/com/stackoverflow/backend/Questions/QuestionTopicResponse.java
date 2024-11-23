package com.stackoverflow.backend.Questions;

import com.stackoverflow.backend.Topics.CustomTopicDto;
import com.stackoverflow.backend.Topics.TopicsEntity;

import java.util.List;

public class QuestionTopicResponse {
    private List<CustomQuestionDto> questions;
    private List<CustomTopicDto> topics;
    public QuestionTopicResponse(List<CustomQuestionDto> questions , List<CustomTopicDto> topics){
        this.questions = questions;
        this.topics = topics;
    }

    public List<CustomQuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<CustomQuestionDto> questions) {
        this.questions = questions;
    }

    public List<CustomTopicDto> getTopics() {
        return topics;
    }

    public void setTopics(List<CustomTopicDto> topics) {
        this.topics = topics;
    }
}
