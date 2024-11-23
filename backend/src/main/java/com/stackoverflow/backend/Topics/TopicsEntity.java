package com.stackoverflow.backend.Topics;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stackoverflow.backend.Questions.QuestionsEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "topics")
public class TopicsEntity {

    @Id
    @GeneratedValue
    private Integer topicId;
    private String topicName;

    @ManyToMany(mappedBy = "topics")
    @JsonManagedReference
    private Set<QuestionsEntity> questions;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Set<QuestionsEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionsEntity> questions) {
        this.questions = questions;
    }
}
