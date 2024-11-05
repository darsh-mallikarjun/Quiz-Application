package com.application.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.quiz.enity.Response;
import com.application.quiz.entity.Question;
import com.application.quiz.entity.QuestionWapper;
import com.application.quiz.entity.Quiz;
import com.application.quiz.repo.QuestionRepo;
import com.application.quiz.repo.QuizRepo;

@Service
public class QuizService {

	 @Autowired
	 QuizRepo quizRepo;

	 @Autowired
	 QuestionRepo questionRepo;

	public  String createQuiz(String category, int numQ, String tittle) 
	
	{
		
		List<Question> questions = questionRepo.findRandomQuestionsByCategory(category ,numQ );
		Quiz q = new Quiz();
	    q.setTitle(tittle);
	    q.setQuestions(questions);
	    quizRepo.save(q);
		return "success" ;
	}

	public List<QuestionWapper> getQuiz(int id) {
		Quiz q =  quizRepo.findById(id).get();
		List<Question> qDb = q.getQuestions();
		List<QuestionWapper> qUser = new ArrayList<>();
		for(Question question :qDb ) {
			QuestionWapper qw = new QuestionWapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4()
					);
			qUser.add(qw);
		}
		
		return qUser;
		  
		  
	}

	public Integer resultQuiz(Integer id, List<Response> response) {
		Quiz quiz = quizRepo.findById(id).get();
		List<Question> question = quiz.getQuestions();
		int right =0;
		int i =0;
		
		for(Response responses : response ) {
			
			if(responses.getResponse().equals(question.get(i).getRightAnswer()))
			right++;
			
			i++;
		}
		return right;
	}
}
