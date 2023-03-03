package com.example.is442oop.vmsbackend.controller;
import com.example.is442oop.vmsbackend.service.questionnaires.QuestionnaireService;

import java.util.List;
import com.example.is442oop.vmsbackend.entities.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public @ResponseBody List<Questionnaire> getAllQuestionnaires() {
        return questionnaireService.getAllQuestionnaires();
    }

}
