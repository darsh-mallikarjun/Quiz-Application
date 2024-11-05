package com.application.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.quiz.entity.Quiz;


@Repository
public interface QuizRepo  extends JpaRepository<Quiz, Integer>{

}
