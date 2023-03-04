package com.example.is442oop.vmsbackend.controller;
import com.example.is442oop.vmsbackend.service.questionnaires.QuestionnaireService;

import java.util.List;
import java.util.Map;

import com.example.is442oop.vmsbackend.entities.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity getAllQuestionnaires() {
        return questionnaireService.getAllQuestionnaires();
    }

    @GetMapping("/{questionnaireID}")
    public ResponseEntity getQuestionnaireByID(@PathVariable Long questionnaireID){
        return questionnaireService.getQuestionnaireByID(questionnaireID);
    }

    @PostMapping
    public @ResponseBody ResponseEntity createQuestionnaire(@RequestBody Map<String,String> questionnaireDetails){
        Long questionnaireID= Long.parseLong(questionnaireDetails.get("questionnaireID"));
        String name = questionnaireDetails.get("name");
        return questionnaireService.createQuestionnaire(questionnaireID, name);
    }

}
