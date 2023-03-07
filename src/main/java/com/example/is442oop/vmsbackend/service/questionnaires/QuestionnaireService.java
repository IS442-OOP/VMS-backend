package com.example.is442oop.vmsbackend.service.questionnaires;

import com.example.is442oop.vmsbackend.dao.Questionnaires.*;
import com.example.is442oop.vmsbackend.entities.Question;
import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public ResponseEntity getQuestionnaireByID(Long questionnaireID){
      return ResponseUtil.responseOkGetQuestionnaire(questionnaireDAO.getQuestionnaireByID(questionnaireID));
    }

    public ResponseEntity createQuestionnaire(Map<String,?> questionnaireDetails){
      return ResponseUtil.responseOkCreateQuestionnaire(questionnaireDAO.createQuestionnaire(questionnaireDetails));
    }

    public Questionnaire editQuestionnaireQuestions(Long questionnaireID,Map<?,?> questionnaireDetails){
      return questionnaireDAO.editQuestionnaireQuestions(questionnaireID, questionnaireDetails);
    }

    public Questionnaire editQuestionnaire(Long questionnaireID,Map<?,?> questionnaireDetails){
      return questionnaireDAO.editQuestionnaire(questionnaireID, questionnaireDetails);
    }

    
}
