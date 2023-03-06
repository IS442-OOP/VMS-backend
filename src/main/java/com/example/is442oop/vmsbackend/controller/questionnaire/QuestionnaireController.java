package com.example.is442oop.vmsbackend.controller.questionnaire;

import com.example.is442oop.vmsbackend.service.questionnaires.QuestionnaireService;

import java.util.List;
import java.util.Map;

import com.example.is442oop.vmsbackend.entities.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity getAllQuestionnaires() {
        return questionnaireService.getAllQuestionnaires();
    }

    @GetMapping("/{questionnaireID}")
    public ResponseEntity getQuestionnaireByID(@PathVariable Long questionnaireID) {
        return questionnaireService.getQuestionnaireByID(questionnaireID);
    }

    @PostMapping
    public @ResponseBody ResponseEntity createQuestionnaire(@RequestBody Map<String, String> questionnaireDetails) {
        return questionnaireService.createQuestionnaire(questionnaireDetails);
    }

    @PutMapping("/{questionnaireID}")
    public @ResponseBody Questionnaire editQuestionnaire(@PathVariable Long questionnaireID, @RequestBody Map<String, ?> questionnaireDetails) {
        return questionnaireService.editQuestionnaire(questionnaireID, questionnaireDetails);

    }

}
