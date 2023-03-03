package com.example.is442oop.vmsbackend.dao.Questionnaires;

import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Component
public class QuestionnaireDAO {
    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireDAO(QuestionnaireRepository questionnaireRepository){
      this.questionnaireRepository= questionnaireRepository;
    }
    
    public List<Questionnaire> getAllQuestionnaires(){
        return questionnaireRepository.getAllQuestionnaires();
    }
    
}
