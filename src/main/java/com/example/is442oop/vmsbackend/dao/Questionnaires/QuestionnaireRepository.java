package com.example.is442oop.vmsbackend.dao.Questionnaires;

import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.is442oop.vmsbackend.entities.QuestionOption;
import com.example.is442oop.vmsbackend.entities.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
  @Query("select q from Questionnaire q")
  List<Questionnaire> getAllQuestionnaires();

  // @Query("select q.qo from Questionnaire qt INNER JOIN Question q INNER JOIN QuestionOption qo")
  @Query(value="SELECT q.question ,qo.option_type,qo.optionid,qo.question_option,qo.questionid FROM vms.questionnaire qt INNER JOIN vms.question q ON qt.questionnaireid=q.questionnaireid INNER JOIN vms.question_option qo ON q.questionid=qo.questionid",nativeQuery = true)
  List<QuestionOption> getAllQuestionOptions();
}
