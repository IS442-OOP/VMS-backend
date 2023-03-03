package com.example.is442oop.vmsbackend.service.questionnaires;

import com.example.is442oop.vmsbackend.dao.Questionnaires.*;
import com.example.is442oop.vmsbackend.entities.Questionnaire;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService implements QuestionnaireInterface {

    private final QuestionnaireDAO questionnaireDAO;
    @Autowired
    public QuestionnaireService(QuestionnaireDAO questionnaireDAO){
      this.questionnaireDAO = questionnaireDAO;
    }
    public List<Questionnaire> getAllQuestionnaires() {
      return questionnaireDAO.getAllQuestionnaires();
    }
  


    
}
