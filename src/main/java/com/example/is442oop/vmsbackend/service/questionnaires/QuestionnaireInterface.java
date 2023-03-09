package com.example.is442oop.vmsbackend.service.questionnaires;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.is442oop.vmsbackend.entities.Questionnaire;


interface QuestionnaireInterface {
    public ResponseEntity getAllQuestionnaires();
    public Questionnaire getQuestionnaireByID(Long questionnaireID);
    public Questionnaire createQuestionnaire(Map<String,?> questionnaireDetails);
}
