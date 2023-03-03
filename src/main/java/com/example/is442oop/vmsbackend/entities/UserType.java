package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserType {
    @Id
    private Long userTypeID;
    private String userType;
    @OneToMany(mappedBy="userType", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <User> user; 

    @OneToMany(mappedBy="userType", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Sequence> sequence;  



    public UserType(Long userTypeID, String userType) {
        this.userTypeID = userTypeID;
        this.userType = userType;
    }

    public UserType(){

    }



    public Long getUserTypeID() {
        return userTypeID;
    }
    public void setUserTypeID(Long userTypeID) {
        this.userTypeID = userTypeID;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    
}
