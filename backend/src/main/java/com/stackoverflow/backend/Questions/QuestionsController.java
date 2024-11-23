package com.stackoverflow.backend.Questions;

import com.stackoverflow.backend.Topics.TopicRepository;
import com.stackoverflow.backend.Topics.TopicsEntity;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionsController {

    // Creating a repository using dependency injection
    private QuestionsRepository questionsRepository;
    private ToQuestionEntity toQuestionEntity;
    private TopicRepository topicRepository;
    private ToQuestionHomePage toQuestionHomePage;
    public QuestionsController(QuestionsRepository questionsRepository , ToQuestionEntity toQuestionEntity , TopicRepository topicRepository,ToQuestionHomePage toQuestionHomePage){
        this.questionsRepository = questionsRepository;
        this.toQuestionEntity = toQuestionEntity;
        this.topicRepository = topicRepository;
        this.toQuestionHomePage = toQuestionHomePage;
    }

    // To receive all questions
    @PostMapping("/create-question")
    public QuestionsEntity createQuestion(
            @RequestBody QuestionDto questionDto
    ){
        var question = toQuestionEntity.ConvertToQuestionEntity(questionDto);
        return questionsRepository.save(question);
    }

    @GetMapping("/question-topic/{user}")
    public QuestionTopicResponse getQuestionAndTopic(
            @PathVariable("user") String user
    ){
        List<QuestionsEntity> questions = questionsRepository.findAllSortedByTimestampAsc();
        List<TopicsEntity> topics = topicRepository.findAll();
        return toQuestionHomePage.homePageFormat(questions,topics,user);
    }

    @Transactional
    @GetMapping("/delete/{questionId}")
    public void deleteQuestion(
            @PathVariable("questionId") Integer questionId
    ){
        questionsRepository.deleteByQuestionId(questionId);
    }

    @GetMapping("/search/{value}")
    public SearchResponse sendSearchResponse(
            @PathVariable("value") String value
    ){
        SearchResponse searchResponse = new SearchResponse();
        String value1 = value;
        searchResponse.setQuestionsEntity(questionsRepository.findByQuestionContainingOrHeadingContainingOrdered(value,value1));
        searchResponse.setTopicsEntities(topicRepository.findByTopicNameContaining(value));
        return searchResponse;
    }


}
