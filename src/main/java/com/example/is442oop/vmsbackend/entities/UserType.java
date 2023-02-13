package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserType {
    @Id
    private String userTypeID;
    private String userType;
    @OneToMany(mappedBy="userType", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <User> user; 

    @OneToMany(mappedBy="userType", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public Set <Sequence> sequence;  



    public UserType(String userTypeID, String userType) {
        this.userTypeID = userTypeID;
        this.userType = userType;
    }

    public UserType(){

    }



    public String getUserTypeID() {
        return userTypeID;
    }
    public void setUserTypeID(String userTypeID) {
        this.userTypeID = userTypeID;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    
}
