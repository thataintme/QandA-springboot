package com.example.postgresdemo.postgresdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "answers")
@Entity
public class Answer {


	@Id
	@GeneratedValue(generator = "answer_generator")
	@SequenceGenerator(
			name = "answer_generator",
			sequenceName = "answer_sequence",
			initialValue = 100
			)
	private long id; 
	
	
	@Column(columnDefinition = "text")
	private String text;
	
	
	
	//many to one mapping
	//many side reference of one
	//unidirectional join column alone is enough
	//
	
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "qid" , nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Question question;



	public void setQuestion(Question question) {
		this.question = question;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Answer(String text, Question question) {
		this.text = text;
		this.question = question;
	}
	public Answer() {
		
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public Question getQuestion() {
		return question;
	}
	
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	
}
