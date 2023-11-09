package com.tecnica7.api.adapters.question;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnica7.api.adapters.question.dto.QuestionRequestDto;
import com.tecnica7.api.adapters.question.dto.QuestionResponseDto;
import com.tecnica7.api.domain.ports.mail.IEmailService;
import com.tecnica7.api.domain.ports.question.QuestionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService qService;

    @Autowired
    private IEmailService emailService;

    @PostMapping()
    public String storeQuestion( @RequestBody QuestionRequestDto  request ) throws IOException  {

        qService.create(request);

        emailService.sendEmail(
            "tizicapo12345@gmail.com",
            "Pregunta de: " + request.getMail(),
            "Esto es una pregunta"
        );

        return "Pregunta guardada en la DB";
    }

    @GetMapping("/{id}")
    public QuestionResponseDto getById(@PathVariable Long id) {
        return QuestionResponseDto.of(qService.getById(id));
    }

}