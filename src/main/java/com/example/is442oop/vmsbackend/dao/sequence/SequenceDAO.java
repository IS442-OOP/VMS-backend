package com.example.is442oop.vmsbackend.dao.sequence;

import com.example.is442oop.vmsbackend.entities.UserType;
import com.example.is442oop.vmsbackend.entities.Workflow;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SequenceDAO {
    private final SequenceRepository sequenceRepository;

    public SequenceDAO(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

}
