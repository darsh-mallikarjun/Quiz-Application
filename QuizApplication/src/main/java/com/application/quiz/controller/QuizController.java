package com.application.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.quiz.enity.Response;
import com.application.quiz.entity.Question;
import com.application.quiz.entity.QuestionWapper;
import com.application.quiz.entity.Quiz;
import com.application.quiz.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	
	@Autowired
	QuizService quizService;
	
	
	@PostMapping("create")
	public String createQuiz(@RequestParam String category ,@RequestParam int numQ ,@RequestParam String title){
		return quizService.createQuiz(category , numQ , title);
	}
	
	@GetMapping("get/{id}")
	public List<QuestionWapper> createQuiz(@PathVariable int id ){
		return quizService.getQuiz(id);
	}
	

	@PostMapping("submit/{id}")
	public Integer resultQuiz(@PathVariable Integer id ,@RequestBody List<Response> response){
		return quizService.resultQuiz(id , response);
	}
	
	
	
}
