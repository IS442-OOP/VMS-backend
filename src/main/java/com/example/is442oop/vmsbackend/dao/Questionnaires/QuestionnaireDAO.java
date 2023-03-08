package com.example.is442oop.vmsbackend.dao.Questionnaires;

import com.example.is442oop.vmsbackend.entities.Question;
import com.example.is442oop.vmsbackend.entities.QuestionOption;
import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.StackWalker.Option;
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

    public Questionnaire createQuestionnaire(Map<String, ?> questionnaireDetails) {
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

    public Questionnaire editQuestionnaireQuestions(Long questionnaireID, Map<?, ?> questionnaireDetails) {
        try {
            Questionnaire questionnaire = this.getQuestionnaireByID(questionnaireID);
            ArrayList<Map<String, ?>> questions = (ArrayList) questionnaireDetails.get("questions");
            List<Integer> deleteQuestionIds = (List) questionnaireDetails.get("deleteQuestions");

            for (Integer id : deleteQuestionIds) {
                questionnaire.removeQuestionById(Long.valueOf(id));
            }
            
            for (Map<String, ?> question : questions) {
                String questionType = (String) question.get("questionType");
                String questionName = (String) question.get("question");
                Object questionIDExists = question.get("questionID");

                if (questionIDExists != null) {
                    Long questionID = Long.valueOf((Integer) questionIDExists);
                    Question questionObj = questionnaire.getQuestionById(questionID);
                    questionObj.setQuestionType(questionType);
                    questionObj.setQuestion(questionName);
                    List<Integer> deleteOptionIds = question.get("deleteOptionIds") != null ? (List)question.get("deleteOptionIds") : new ArrayList<Integer>() ;

                    for (Integer id : deleteOptionIds) {
                        questionObj.removeOptionById(id);
                    }

                    ArrayList<Map<String, ?>> options = (ArrayList) question.get("options");
                    for (Map<String, ?> option : options) {
                        Object optionIDExists = option.get("optionID");
                        String questionOption = (String) option.get("questionOption");
                        if (optionIDExists != null) {
                            Integer optionID = (Integer) optionIDExists;
                            QuestionOption optionObj = questionObj.getOptionById(optionID);
                            optionObj.setQuestionOption(questionOption);
                        } else {
                            QuestionOption optionObj = new QuestionOption(questionOption);
                            questionObj.addOption(optionObj);
                            optionObj.setQuestion(questionObj);
                        }
                    }
                } else {
                    Question questionObj = new Question(questionName, questionType);
                    questionnaire.addQuestion(questionObj);
                    questionObj.setQuestionnaire(questionnaire);
                    ArrayList<Map<String, ?>> options = (ArrayList) question.get("options");
                    System.out.println(options);
                    for (Map<String, ?> option : options) {
                        String questionOption = (String) option.get("questionOption");
                        QuestionOption optionObj = new QuestionOption(questionOption);
                        questionObj.addOption(optionObj);
                        optionObj.setQuestion(questionObj);
                    }
                }

            }
            return questionnaireRepository.save(questionnaire);
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public Questionnaire editQuestionnaire(Long questionnaireID, Map<?, ?> questionnaireDetails) {
        try {
            Questionnaire questionnaire = this.getQuestionnaireByID(questionnaireID);
            String name = (String) questionnaireDetails.get("name");
            String description = (String) questionnaireDetails.get("description");
            questionnaire.setName(name);
            questionnaire.setDescription(description);
            return questionnaireRepository.save(questionnaire);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
