package com.stackoverflow.backend.Questions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stackoverflow.backend.Answers.AnswerEntity;
import com.stackoverflow.backend.Topics.TopicsEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "questions")
public class QuestionsEntity {
    @Id
    @GeneratedValue
    private Integer questionId;
    @Lob
    private String heading;
    @Lob
    private String question;
    private String userName;
    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="Question_Topic",
    joinColumns = {
            @JoinColumn(name = "questionid",referencedColumnName = "questionid")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "topicId",referencedColumnName = "topicId")
    }
    )
    @JsonBackReference
    private Set<TopicsEntity> topics;

    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private Set<AnswerEntity> answers;


    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<TopicsEntity> getTopics() {
        return topics;
    }

    public void setTopics(Set<TopicsEntity> topics) {
        this.topics = topics;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Set<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerEntity> answers) {
        this.answers = answers;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
