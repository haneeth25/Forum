package com.stackoverflow.backend.Topics;

import com.stackoverflow.backend.Questions.QuestionsEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController {
    private TopicRepository topicRepository;
    public TopicController(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    @GetMapping("topic-filter/{topic_id}")
    public TopicsEntity getQuestionByTopicId(
            @PathVariable("topic_id") Integer topic_id
    ){
        return topicRepository.findByTopicId(topic_id);
    }
}
