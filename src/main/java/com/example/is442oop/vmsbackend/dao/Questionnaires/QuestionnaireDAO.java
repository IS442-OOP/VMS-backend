package com.example.is442oop.vmsbackend.dao.Questionnaires;
import com.example.is442oop.vmsbackend.entities.Question;
import com.example.is442oop.vmsbackend.entities.Questionnaire;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

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

    public Questionnaire getQuestionnaireByID(Long questionnaireID){
      try{
        return questionnaireRepository.getQuestionnaireByID(questionnaireID);
      }
      catch(Exception e){
      }
      return null;
    }

    public Questionnaire createQuestionnaire(Long questionnaireID, String name){

      try{
        Questionnaire newQuestionnaire = new Questionnaire(questionnaireID, name);
        return questionnaireRepository.save(newQuestionnaire);
      }
      catch(Exception e){

      }
      return null;


    }
    
    
}
