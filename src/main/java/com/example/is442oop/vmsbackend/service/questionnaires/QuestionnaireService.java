package com.example.is442oop.vmsbackend.service.questionnaires;

import com.example.is442oop.vmsbackend.authentication.BasicAuthInterceptor;
import com.example.is442oop.vmsbackend.dao.Questionnaires.*;
import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.exception.InternalServerException;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import com.example.is442oop.vmsbackend.exception.UserForbiddenException;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService implements QuestionnaireInterface {

    private final QuestionnaireDAO questionnaireDAO;
    @Autowired
    public QuestionnaireService(QuestionnaireDAO questionnaireDAO){
      this.questionnaireDAO = questionnaireDAO;
    }
    public ResponseEntity getAllQuestionnaires() {
      return ResponseUtil.responseOk(questionnaireDAO.getAllQuestionnaires());
    }
  


    
}
