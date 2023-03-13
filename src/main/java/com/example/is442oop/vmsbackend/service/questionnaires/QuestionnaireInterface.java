package com.example.is442oop.vmsbackend.service.questionnaires;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;


interface QuestionnaireInterface {
    public ResponseEntity getAllQuestionnaires();
    public ResponseEntity getQuestionnaireByID(Long questionnaireID);
    public ResponseEntity createQuestionnaire(Map<String,?> questionnaireDetails);
    public ResponseEntity editQuestionnaireQuestions(Long questionnaireID, Map<?, ?> questionnaireDetails);
    public ResponseEntity editQuestionnaire(Long questionnaireID, Map<?, ?> questionnaireDetails);
    public ResponseEntity deleteQuestionnaire(Long questionnaireID);
    public ResponseEntity saveQuestionnaire(Long questionnaireID);
}
