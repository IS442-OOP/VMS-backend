package com.example.is442oop.vmsbackend.dao.Questionnaires;

import com.example.is442oop.vmsbackend.entities.Question;
import com.example.is442oop.vmsbackend.entities.QuestionOption;
import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class QuestionnaireDAO {
    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireDAO(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public List<Questionnaire> getAllQuestionnaires() {
        try {
            return questionnaireRepository.getAllQuestionnaires();
        } catch (Exception e) {
        }
        return null;
    }

    public Questionnaire getQuestionnaireByID(Long questionnaireID) {
        try {
            return questionnaireRepository.getQuestionnaireByID(questionnaireID);
        } catch (Exception e) {
        }
        return null;
    }

    public Questionnaire createQuestionnaire(Map<String,?> questionnaireDetails) {
        String name = (String) questionnaireDetails.get("name");
        String description = (String) questionnaireDetails.get("description");
        String dateCreated = (String) questionnaireDetails.get("dateCreated");

        try {
            Questionnaire newQuestionnaire = new Questionnaire(name, description, dateCreated);
            return questionnaireRepository.save(newQuestionnaire);
        } catch (Exception e) {

        }
        return null;
    }

    public Questionnaire editQuestionnaire(Long questionnaireID, Map<?, ?> questionnaireDetails) {
        try {
            Questionnaire questionnaire = this.getQuestionnaireByID(questionnaireID);
            // String name = (String) questionnaireDetails.get("name");
            // String description = (String) questionnaireDetails.get("description");
            // String dateCreated = (String) questionnaireDetails.get("dateCreated");

            ArrayList<Map<String, ?>> questions = (ArrayList) questionnaireDetails.get("questions");
            questionnaire.clearQuestions();
            for (Map<String, ?> question : questions) {
                String questionType = (String) question.get("questionType");
                String questionName = (String) question.get("question");
                // Boolean isRequired = (Boolean) question.get("isRequired");
                ArrayList<Map<String, ?>> options = (ArrayList) question.get("options");
                Question newQuestion = new Question(questionName, questionType);
                newQuestion.setQuestionnaire(questionnaire);
                for (Map<String, ?> option : options) {
                    String optionName = (String) option.get("questionOption");
                    QuestionOption questionOption = new QuestionOption(optionName);
                    questionOption.setQuestion(newQuestion);
                    newQuestion.addOption(questionOption);
                }
                questionnaire.addQuestion(newQuestion);
            }
            // questionnaire.setName(name);
            // questionnaire.setDescription(description);
            // questionnaire.setDateCreated(dateCreated);
            return questionnaireRepository.save(questionnaire);
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

}
