package com.example.is442oop.vmsbackend.service.questionnaires;

import com.example.is442oop.vmsbackend.dao.Questionnaires.*;
import com.example.is442oop.vmsbackend.entities.Question;
import com.example.is442oop.vmsbackend.entities.QuestionOption;
import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class QuestionnaireService implements QuestionnaireInterface {
  private final QuestionnaireDAO questionnaireDAO;

  @Autowired
  public QuestionnaireService(QuestionnaireDAO questionnaireDAO) {
    this.questionnaireDAO = questionnaireDAO;
  }

  public List<Questionnaire> getAllQuestionnaires() {
    return questionnaireDAO.getAllQuestionnaires();
  }

  public Questionnaire getQuestionnaireByID(Long questionnaireID) {
    return questionnaireDAO.getQuestionnaireByID(questionnaireID);
  }

  public Questionnaire createQuestionnaire(Map<String, ?> questionnaireDetails) {
    String name = (String) questionnaireDetails.get("name");
    String description = (String) questionnaireDetails.get("description");
    String dateCreated = (String) questionnaireDetails.get("dateCreated");
    try {
      Questionnaire newQuestionnaire = new Questionnaire(name, description, dateCreated);
      Question question = new Question("", "text", 1);
      newQuestionnaire.addQuestion(question);
      question.setQuestionnaire(newQuestionnaire);
      return questionnaireDAO.createQuestionnaire(newQuestionnaire);

    } catch (Exception e) {

    }
    return null;
  }

  public Questionnaire editQuestionnaireQuestions(Long questionnaireID, Map<?, ?> questionnaireDetails) {
    try {
      Questionnaire questionnaire = this.getQuestionnaireByID(questionnaireID);
      ArrayList<Map<String, ?>> questions = (ArrayList) questionnaireDetails.get("questions");
      List<Integer> deleteQuestionIds = (List) questionnaireDetails.get("deleteQuestions");
      List<Question> newQuestions = new ArrayList<Question>();

      for (Integer id : deleteQuestionIds) {
        questionnaire.removeQuestionById(Long.valueOf(id));
      }

      for (Map<String, ?> question : questions) {
        String questionType = (String) question.get("questionType");
        String questionName = (String) question.get("question");
        Integer questionOrder = (Integer) question.get("questionOrder");
        Object questionIDExists = question.get("questionID");
        if (questionIDExists != null) {
          Long questionID = Long.valueOf((Integer) questionIDExists);
          Question questionObj = questionnaire.getQuestionById(questionID);
          questionObj.setQuestionType(questionType);
          questionObj.setQuestion(questionName);
          questionObj.setQuestionOrder(questionOrder);
          List<Integer> deleteOptionIds = question.get("deleteOptionIds") != null
              ? (List) question.get("deleteOptionIds")
              : new ArrayList<Integer>();

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
          Question questionObj = new Question(questionName, questionType, questionOrder);
          questionObj.setQuestionnaire(questionnaire);
          newQuestions.add(questionObj);
          ArrayList<Map<String, ?>> options = (ArrayList) question.get("options");

          for (Map<String, ?> option : options) {
            String questionOption = (String) option.get("questionOption");
            QuestionOption optionObj = new QuestionOption(questionOption);
            questionObj.addOption(optionObj);
            optionObj.setQuestion(questionObj);
          }
        }

      }

      for (Question newQuestion : newQuestions) {
        questionnaire.addQuestion(newQuestion);
      }

      return questionnaireDAO.editQuestionnaireQuestions(questionnaire);
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
      return questionnaireDAO.editQuestionnaire(questionnaire);

    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

  public Questionnaire deleteQuestionnaire(Long questionnaireID) {
    return questionnaireDAO.deleteQuestionnaire(questionnaireID);
  }

  public Questionnaire saveQuestionnaire(Long questionnaireID) {
    return questionnaireDAO.saveQuestionnaire(questionnaireID);
  }

}
