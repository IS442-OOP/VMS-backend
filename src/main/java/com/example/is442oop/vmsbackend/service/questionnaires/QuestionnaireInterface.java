package com.example.is442oop.vmsbackend.service.questionnaires;
import org.springframework.http.ResponseEntity;


interface QuestionnaireInterface {
    public ResponseEntity getAllQuestionnaires();
    public ResponseEntity getQuestionnaireByID(Long questionnaireID);
    
    
}
