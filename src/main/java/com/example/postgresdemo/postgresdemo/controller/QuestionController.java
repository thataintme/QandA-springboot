package com.example.postgresdemo.postgresdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.postgresdemo.entity.Question;
import com.example.postgresdemo.postgresdemo.service.ServiceProvider;

@RestController
public class QuestionController {

	@Autowired
	ServiceProvider serviceProvider;
	
	//all questions
	
	@GetMapping("/questions")
	public List<Question> getAllQuestions(){
		return serviceProvider.getQuestions();
	}
	
	@GetMapping("/questions/{qid}")
	public Question getquesti(@PathVariable long qid) {
		return serviceProvider.getque(qid);
		
	}
	
	//insert question
	@PostMapping("/questions")
	public Question createQuestion(@Valid @RequestBody Question question) {
		return serviceProvider.createQuestion(question);
	}
	
	//update Question
	@PutMapping("/questions/{qid}")
	public Question updateQuestion(@PathVariable long qid,
									@Valid @RequestBody Question question) {
		return serviceProvider.updateQuestion(qid, question);
	}
	
	
	
	//delete Question
	@DeleteMapping("/questions/{qid}")
	public ResponseEntity<?> deleteQuestion(@PathVariable long qid){
		return serviceProvider.deleteQuestion(qid);
	}
	
	
	
	
	
}
