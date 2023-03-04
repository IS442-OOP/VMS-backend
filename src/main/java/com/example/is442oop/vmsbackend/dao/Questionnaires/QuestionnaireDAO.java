package com.example.is442oop.vmsbackend.dao.Questionnaires;

import com.example.is442oop.vmsbackend.entities.QuestionOption;
import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class QuestionnaireDAO {
    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireDAO(QuestionnaireRepository questionnaireRepository){
      this.questionnaireRepository= questionnaireRepository;
    }
    
    public List<Questionnaire> getAllQuestionnaires(){
      try{
        return questionnaireRepository.getAllQuestionnaires();
      }
      catch(Exception e){
      }
      return null;
    }

    public List<QuestionOption> getAllQuestionOptions(){
      try{
        return questionnaireRepository.getAllQuestionOptions();
      }
      catch(Exception e){
      }
      return null;
    }
    
}
