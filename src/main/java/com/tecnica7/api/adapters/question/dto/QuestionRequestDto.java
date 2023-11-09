package com.tecnica7.api.adapters.question.dto;

import lombok.Data;

@Data
public class QuestionRequestDto {
	private String question;
	private String mail;
	private String contact;
}
