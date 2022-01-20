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

import com.example.postgresdemo.postgresdemo.entity.Answer;
import com.example.postgresdemo.postgresdemo.service.ServiceProvider;

@RestController
public class AnswerController {


	@Autowired
	ServiceProvider serviceProvider;
	
/// get answers for qid
	@GetMapping("/questions/{qid}/answers")
	public List<Answer> getAnsByQid(@PathVariable long qid) {
		return serviceProvider.getAnsByQid(qid);
	}
	
///add answer to a question
	@PostMapping("/questions/{qid}/answers")
	public Answer addAnswertoQuestion(@Valid @RequestBody Answer ans , @PathVariable long qid) {
		return serviceProvider.addAns(qid, ans);
	}
	
	// update an answer
	@PutMapping("/questions/{qid}/answers/{aid}")
	public Answer updateAnswer(@Valid @RequestBody Answer ans , @PathVariable long qid , 
			@PathVariable long aid) {
		return serviceProvider.updateAns(qid, aid, ans);
	}
	
	
	//delete an answer for question
	@DeleteMapping("/questions/{qid}/answers/{aid}")
	public ResponseEntity<?> deleteAnswer(@PathVariable long qid , @PathVariable long aid){
		
		return serviceProvider.deleteAnswe(qid, aid);
	}
	
}
