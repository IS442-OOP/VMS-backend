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
    public final QuestionnaireRepository questionnaireRepository;

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

    public Questionnaire createQuestionnaire(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    public Questionnaire editQuestionnaireQuestions(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    public Questionnaire editQuestionnaire(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    public Questionnaire deleteQuestionnaire(Long questionnaireID){
        try{
            questionnaireRepository.deleteById(questionnaireID);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

}
