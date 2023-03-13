package com.example.is442oop.vmsbackend.dao.sequence;
import com.example.is442oop.vmsbackend.entities.Sequence;
import com.example.is442oop.vmsbackend.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SequenceRepository extends JpaRepository<Sequence, Long> {

}
