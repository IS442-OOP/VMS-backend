package com.example.is442oop.vmsbackend.service.questionnaires;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.is442oop.vmsbackend.entities.Questionnaire;

interface QuestionnaireInterface {
    public ResponseEntity getAllQuestionnaires();
    
}
