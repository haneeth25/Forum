package com.stackoverflow.backend.Questions;

import com.stackoverflow.backend.Topics.TopicsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public class SearchResponse {
    private List<QuestionsEntity> questionsEntity;
    private Set<TopicsEntity> topicsEntities;

    public List<QuestionsEntity> getQuestionsEntity() {
        return questionsEntity;
    }

    public void setQuestionsEntity(List<QuestionsEntity> questionsEntity) {
        this.questionsEntity = questionsEntity;
    }

    public Set<TopicsEntity> getTopicsEntities() {
        return topicsEntities;
    }

    public void setTopicsEntities(Set<TopicsEntity> topicsEntities) {
        this.topicsEntities = topicsEntities;
    }
}
