package com.example.is442oop.vmsbackend.controller;

import com.example.is442oop.vmsbackend.service.questionnaires.QuestionnaireService;

import java.util.List;
import java.util.Map;

import com.example.is442oop.vmsbackend.entities.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/questionnaires")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping
    public ResponseEntity getAllQuestionnaires(@RequestHeader(name = "Authorization") String token) {
        return questionnaireService.getAllQuestionnaires();
    }

    @GetMapping("/{questionnaireID}")
    public ResponseEntity getQuestionnaireByID(@RequestHeader(name = "Authorization") String token,
            @PathVariable Long questionnaireID) {
        return questionnaireService.getQuestionnaireByID(questionnaireID);
    }

    @PostMapping
    public @ResponseBody ResponseEntity createQuestionnaire(@RequestHeader(name = "Authorization") String token,
            @RequestBody Map<String, String> questionnaireDetails) {
        return questionnaireService.createQuestionnaire(questionnaireDetails);
    }

    @PostMapping("/{questionnaireID}")
    public @ResponseBody Questionnaire editQuestionnaire(@RequestHeader(name = "Authorization") String token,
            @PathVariable Long questionnaireID, @RequestBody Map<String, ?> questionnaireDetails) {
        return questionnaireService.editQuestionnaire(questionnaireID, questionnaireDetails);

    }

}