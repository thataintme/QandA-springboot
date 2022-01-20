package com.example.postgresdemo.postgresdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.postgresdemo.dao.AnswerRepository;
import com.example.postgresdemo.postgresdemo.dao.QuestionRepository;
import com.example.postgresdemo.postgresdemo.entity.Answer;
import com.example.postgresdemo.postgresdemo.entity.Question;
import com.example.postgresdemo.postgresdemo.exception.ResourceNotFoundException;

@Service
public class ServiceProviderImp implements ServiceProvider {

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Override
	public List<Answer> getAnsByQid(long qid) {
		 return answerRepository.findByQuestionId(qid);
	}

	@Override
	public Answer addAns(long qid, Answer ans) {
		return questionRepository.findById(qid)
				.map( question -> {
					ans.setQuestion(question);
					return answerRepository.save(ans);
				}).orElseThrow( () -> new ResourceNotFoundException(" Question with id not found " +qid));
	}

	@Override
	public Answer updateAns(long qid, long aid, Answer ans) {
		Optional<Question> question = questionRepository.findById(qid);
		
		if(!question.isPresent())
			throw new ResourceNotFoundException(" Question with id not found " +qid);
			
			
		return answerRepository.findById(aid)
				.map(answer -> { 
					ans.setText(ans.getText());
				return answerRepository.save(ans);
				}).orElseThrow(() -> new ResourceNotFoundException(" Answer with id not found " +aid));
		
	}

	@Override
	public ResponseEntity<?> deleteAnswe(long qid, long aid) {
		Optional<Question> question = questionRepository.findById(qid);
		
		if(!question.isPresent())
			throw new ResourceNotFoundException(" Question with id not found " +qid);
			

		return answerRepository.findById(aid)
				.map(answer -> {
					answerRepository.delete(answer);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException(" Answer with id not found " +aid));
	
	}

	@Override
	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(long qid, Question questionReq) {
		return questionRepository.findById(qid)
				.map(question -> {
					question.setTitle(questionReq.getTitle());
					question.setDescription(questionReq.getDescription());
					return questionRepository.save(question);
				}).orElseThrow(() -> new ResourceNotFoundException("Question not found " + qid));
	}

	@Override
	public ResponseEntity<?> deleteQuestion(long qid) {
		return questionRepository.findById(qid)
				.map(question -> {
					questionRepository.delete(question);
					
					return ResponseEntity.ok().build();
				}).orElseThrow(()-> new ResourceNotFoundException("Question id not found " + qid));
	}

	@Override
	public Question getque(long qid) {
		return questionRepository.findById(qid).get();
	}

}
