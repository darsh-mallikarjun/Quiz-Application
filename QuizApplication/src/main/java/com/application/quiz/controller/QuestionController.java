package com.application.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.application.quiz.entity.Question;
import com.application.quiz.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	QuestionService  questionService;
	
	@GetMapping("/")
	public ResponseEntity<List<Question>> GetAllQuestion(){
		return  new ResponseEntity<> (questionService.getAllQuestion() , HttpStatus.OK);
	}
	
	
	@GetMapping("/categery/{categery}")
	public ResponseEntity<List<Question>> GetQuestionCategery(@PathVariable String categery){
		return new ResponseEntity<> (questionService.getByCategery(categery) , HttpStatus.OK );
	}
	
	

}
