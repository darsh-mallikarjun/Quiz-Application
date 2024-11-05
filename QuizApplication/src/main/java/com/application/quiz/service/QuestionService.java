package com.application.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quiz.entity.Question;
import com.application.quiz.repo.QuestionRepo;


 

@Service
public class QuestionService {
	
	
	 @Autowired
	 QuestionRepo questionRepo;

	public List<Question> getAllQuestion() {
		
		return questionRepo.findAll();
	}

	public List<Question> getByCategery(String categery) {
		return questionRepo.findByCategory(categery);
	}
	
	

}
