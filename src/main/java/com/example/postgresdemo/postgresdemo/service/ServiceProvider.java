package com.example.postgresdemo.postgresdemo.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.example.postgresdemo.postgresdemo.entity.Answer;
import com.example.postgresdemo.postgresdemo.entity.Question;

public interface ServiceProvider {

	public List<Answer> getAnsByQid(long qid);
	
	public Question getque(long qid);
	
	public Answer addAns(long qid , Answer ans);
	
	public Answer updateAns(long qid , long aid, Answer ans);
	
	public ResponseEntity<?> deleteAnswe(long qid , long aid);

	public List<Question> getQuestions();
	
	public Question createQuestion(Question question);
	
	public Question updateQuestion(long qid , Question question);
	
	public ResponseEntity<?> deleteQuestion(long qid);

}
