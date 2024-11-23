package com.stackoverflow.backend.Questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.ListResourceBundle;

public interface QuestionsRepository extends JpaRepository<QuestionsEntity,Integer> {

    QuestionsEntity findByQuestionIdOrderByTimestampDesc(Integer questionId);
    //QuestionsEntity findByQuestionId(Integer questionId);

    @Query("SELECT q FROM QuestionsEntity q ORDER BY q.timestamp DESC")
    List<QuestionsEntity> findAllSortedByTimestampAsc();

    void deleteByQuestionId(Integer questionId);

    @Query("SELECT q FROM QuestionsEntity q WHERE q.question LIKE %:value% OR q.heading LIKE %:value1% ORDER BY q.timestamp DESC")
    List<QuestionsEntity> findByQuestionContainingOrHeadingContainingOrdered(@Param("value") String value, @Param("value1") String value1);
    // List<QuestionsEntity> findAllByQuestionContainingOrHeadingContaining(String value,String value1);

    List<QuestionsEntity> findAllByUserNameOrderByTimestampDesc(String userName);
    // List<QuestionsEntity> findAllByUserName(String userName);

}
