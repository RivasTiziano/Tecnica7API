package com.tecnica7.api.domain.ports.question;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnica7.api.adapters.question.dto.QuestionRequestDto;
import com.tecnica7.api.domain.model.Question;

import jakarta.transaction.Transactional;


@Service
public class QuestionService {
    
    @Autowired
    private QuestionRepository qRepository;

    @Transactional
    public void create(QuestionRequestDto request) throws IOException {

        // Crea un objeto customer
        Question question = new Question();
        question.setQuestion(request.getQuestion());
        question.setMail(request.getMail());
        question.setContact(request.getContact());

        // Guarda el objeto question en la base de datos
        qRepository.save(question);
    }


    public Question getById(Long id) {
        return qRepository.findById(id).get();
    }

}
