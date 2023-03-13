package com.example.is442oop.vmsbackend.controller.questionnaire;

import com.example.is442oop.vmsbackend.service.questionnaires.QuestionnaireService;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;

import java.util.List;
import java.util.Map;

import com.example.is442oop.vmsbackend.entities.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/questionnaires")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity getAllQuestionnaires() {
        return questionnaireService.getAllQuestionnaires();
    }

    @GetMapping("/{questionnaireID}")
    public @ResponseBody ResponseEntity getQuestionnaireByID(@PathVariable Long questionnaireID) {
        return questionnaireService.getQuestionnaireByID(questionnaireID);
    }

    @PostMapping
    public @ResponseBody ResponseEntity createQuestionnaire(@RequestBody Map<String, String> questionnaireDetails) {
        return questionnaireService.createQuestionnaire(questionnaireDetails);
    }

    @PutMapping("/{questionnaireID}/questions")
    public @ResponseBody ResponseEntity editQuestionnaireQuestions(@PathVariable Long questionnaireID, @RequestBody Map<?, ?> questionnaireDetails) {
        return questionnaireService.editQuestionnaireQuestions(questionnaireID, questionnaireDetails); 
    }

    @PutMapping("/{questionnaireID}")
    public @ResponseBody ResponseEntity editQuestionnaire(@PathVariable Long questionnaireID, @RequestBody Map<?, ?> questionnaireDetails){
        return questionnaireService.editQuestionnaire(questionnaireID, questionnaireDetails);
    }

    @DeleteMapping("/{questionnaireID}")
    public @ResponseBody ResponseEntity deleteQuestionnaire(@PathVariable Long questionnaireID){
        return questionnaireService.deleteQuestionnaire(questionnaireID);
    }

    @PutMapping("/{questionnaireID}/save")
    public @ResponseBody ResponseEntity saveQuestionnaire(@PathVariable Long questionnaireID){
        return questionnaireService.saveQuestionnaire(questionnaireID);
    }
}
