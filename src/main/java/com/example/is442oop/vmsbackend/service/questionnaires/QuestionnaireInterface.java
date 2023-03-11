package com.example.is442oop.vmsbackend.service.questionnaires;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.is442oop.vmsbackend.entities.Questionnaire;


interface QuestionnaireInterface {
    public List<Questionnaire> getAllQuestionnaires();
    public Questionnaire getQuestionnaireByID(Long questionnaireID);
    public Questionnaire createQuestionnaire(Map<String,?> questionnaireDetails);
}
