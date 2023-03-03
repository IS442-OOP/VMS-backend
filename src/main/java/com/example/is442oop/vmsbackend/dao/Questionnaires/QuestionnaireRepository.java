package com.example.is442oop.vmsbackend.dao.Questionnaires;

import java.util.*;
import org.springframework.data.jpa.repository.Query;
import com.example.is442oop.vmsbackend.entities.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.is442oop.vmsbackend.entities.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
  @Query("select q from Questionnaires")
  List <Questionnaire> getAllQuestionnaires();
}
