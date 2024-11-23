package com.stackoverflow.backend.Answers;

import com.stackoverflow.backend.Questions.QuestionsEntity;
import com.stackoverflow.backend.Questions.QuestionsRepository;
import com.stackoverflow.backend.Topics.TopicRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AnswerController {
    private AnswersService answersService;
    private AnswerRepository answerRepository;

    public AnswerController(AnswersService answersService,AnswerRepository answerRepository){
        this.answersService = answersService;
        this.answerRepository = answerRepository;
    }

    @GetMapping("/answer/{questionId}")
    public AnswerResponse getAnswers(
            @PathVariable("questionId") Integer questionId
    ){
        return answersService.toAnswerResponse(questionId);
    }
    @PostMapping("/answer/{questionId}")
    public void SaveAnswer(
            @RequestBody GetAnswerDto answer
    ){
        answersService.toSaveAnswer(answer);
    }

    @Transactional
    @GetMapping("/delete/answer/{answerId}")
    public void deleteAnswer(
            @PathVariable("answerId") Integer answerId
    ){
        answerRepository.deleteByAnswerId(answerId);
    }
}
