package com.tecnica7.api.adapters.question.dto;

import com.tecnica7.api.domain.model.Question;

import lombok.Data;

@Data
public class QuestionResponseDto {
	private String question;
	private String answer;
   
    public QuestionResponseDto(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public static QuestionResponseDto of(Question question) {
        return new QuestionResponseDto(question.getQuestion(), question.getAnswer());
    }
} 