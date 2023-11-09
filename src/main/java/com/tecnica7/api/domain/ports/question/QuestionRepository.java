package com.tecnica7.api.domain.ports.question;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnica7.api.domain.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
