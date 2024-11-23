package com.stackoverflow.backend.Topics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;


public interface TopicRepository extends JpaRepository<TopicsEntity,Integer> {
    TopicsEntity findByTopicName(String Name);
    TopicsEntity findByTopicId(Integer id);
    Set<TopicsEntity> findByTopicNameContaining(String value);
}
