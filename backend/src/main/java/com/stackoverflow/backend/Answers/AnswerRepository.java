package com.stackoverflow.backend.Answers;

import com.stackoverflow.backend.Questions.QuestionsEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerEntity,Integer> {
//     List<AnswerEntity> findByQuestionQuestionId(Integer questionId);
    @Query("SELECT a FROM AnswerEntity a WHERE a.question.questionId = :questionId ORDER BY a.timestamp DESC")
    List<AnswerEntity> findByQuestionQuestionId(@Param("questionId") Integer questionId);
    void deleteByAnswerId(Integer answerId);
    List<AnswerEntity> findAllByUserNameOrderByTimestampDesc(String UserName);
}
