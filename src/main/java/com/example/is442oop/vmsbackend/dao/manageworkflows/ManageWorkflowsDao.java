package com.example.is442oop.vmsbackend.dao.manageworkflows;

import com.example.is442oop.vmsbackend.dao.Questionnaires.QuestionnaireRepository;
import com.example.is442oop.vmsbackend.dao.sequence.SequenceDAO;
import com.example.is442oop.vmsbackend.dao.sequence.SequenceRepository;
import com.example.is442oop.vmsbackend.dao.user.UserRepository;
import com.example.is442oop.vmsbackend.dao.usertype.UserTypeRepository;
import com.example.is442oop.vmsbackend.entities.*;
import com.example.is442oop.vmsbackend.exception.InternalServerException;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.aspectj.weaver.ast.Not;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class ManageWorkflowsDao {
    private final ManageWorkflowsRepository manageWorkflowsRepository;
    private final SequenceRepository sequenceRepository;
    private final QuestionnaireRepository questionnaireRepository;

    private final UserTypeRepository userTypeRepository;

    @Autowired
    public ManageWorkflowsDao(ManageWorkflowsRepository manageWorkflowsRepository, SequenceRepository sequenceRepository, QuestionnaireRepository questionnaireRepository, UserTypeRepository userTypeRepository) {
        this.manageWorkflowsRepository = manageWorkflowsRepository;
        this.sequenceRepository = sequenceRepository;
        this.questionnaireRepository = questionnaireRepository;
        this.userTypeRepository = userTypeRepository;
    }

    public List<Workflow> retrieveWorkflows() {
        return manageWorkflowsRepository.getAllWorkflows();
    }

    public Workflow createWorkflow(Map<String, ?> workflowDetails) {
        String workflowNo = (String) workflowDetails.get("workflowNo");
        String name = (String) workflowDetails.get("name");
        try {
            Workflow newWorkflow = new Workflow(name, workflowNo);
            return manageWorkflowsRepository.save(newWorkflow);
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void editWorkflow(String workflowID, Map<String, ?> workflowDetails) {
        try{
            manageWorkflowsRepository.findById(workflowID);
            String name = (String) workflowDetails.get("name");
            String workflowNo = (String) workflowDetails.get("workflowNo");
            manageWorkflowsRepository.updateWorkflow(workflowID, name, workflowNo);
        }
        catch (NotFoundException e){
            throw new NotFoundException("Workflow not found for ID :" + workflowID);
        }
    }

    public Set<Sequence> getListOfSequences(String workflowID) {
        try{
            Workflow workflow = manageWorkflowsRepository.findById(workflowID).orElse(null);

            return workflow.getListOfSequences();
        }
        catch (NotFoundException e){
            throw new NotFoundException("Workflow not found for ID :" + workflowID);
        }
    }

    public Sequence addWorkflowSequence(String workflowid, Map<String, ?> sequenceDetails){
        try{
            Workflow workflow = manageWorkflowsRepository.findById(workflowid).orElse(null);
            Integer sequence = (Integer) sequenceDetails.get("sequence");
            Boolean isDone = (Boolean) sequenceDetails.get("isDone");
            Boolean questionnaireSequence = (Boolean) sequenceDetails.get("questionnaireSequence");
            Boolean approvalSequence = (Boolean) sequenceDetails.get("approvalSequence");
            Integer questionnaireID = (Integer) sequenceDetails.get("questionnaireID");

            Integer approveSequenceID = (Integer) sequenceDetails.get("approveSequenceID");

            if(questionnaireSequence == true){
                Questionnaire aQuestionnaire = questionnaireRepository.findById(Long.valueOf(questionnaireID)).orElse(null);

                Sequence seq = new Sequence(sequence, isDone, Sequence.sequenceTypeEnum.QUESTIONNAIRE);
                QuestionnaireSequence qnsSeq = new QuestionnaireSequence(seq, aQuestionnaire);
                seq.setQuestionnaireSequence(qnsSeq);
                return sequenceRepository.save(seq);
            }
            else if (approvalSequence == true){
                Sequence seq = sequenceRepository.findById(Long.valueOf(approveSequenceID)).orElseThrow(EntityNotFoundException::new);
                seq.setSequenceTypeEnum(Sequence.sequenceTypeEnum.APPROVAL);

                ApprovalSequence appSeq = new ApprovalSequence(seq, seq);
                seq.setApprovalSequence(appSeq);

                return sequenceRepository.save(seq);
            }


        }
        catch (NotFoundException e){
            throw new NotFoundException("Workflow not found for ID :" + workflowid);
        }
        return null;
    }

    public Sequence deleteWorkflowSequence(String workflowid, String sequenceid) {
        try {
            Sequence seq = sequenceRepository.findById(Long.valueOf(sequenceid)).orElse(null);
            sequenceRepository.delete(seq);
            return seq;
        }
        catch (NotFoundException e){
            throw new NotFoundException("Sequence not found for ID :" + sequenceid);
        }
    }

}
