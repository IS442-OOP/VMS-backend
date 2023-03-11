package com.example.is442oop.vmsbackend.service.questionnaires;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.is442oop.vmsbackend.entities.Questionnaire;


interface QuestionnaireInterface {
    public ResponseEntity getAllQuestionnaires();
    public ResponseEntity getQuestionnaireByID(Long questionnaireID);
    public ResponseEntity createQuestionnaire(Map<String,?> questionnaireDetails);
}
