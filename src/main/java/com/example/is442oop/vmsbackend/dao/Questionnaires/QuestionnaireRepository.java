package com.example.is442oop.vmsbackend.dao.Questionnaires;
import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.is442oop.vmsbackend.entities.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
  @Query("select q from Questionnaire q")
  List<Questionnaire> getAllQuestionnaires();

  @Query("select q from Questionnaire q where q.questionnaireID=?1")
  Questionnaire getQuestionnaireByID(Long questionnaireID);
}
