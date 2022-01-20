package com.example.postgresdemo.postgresdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.postgresdemo.postgresdemo.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
