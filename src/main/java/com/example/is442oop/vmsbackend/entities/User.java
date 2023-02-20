package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class User {
    @Id 
    private Long userID;
    private String email;
    private String password;
    private Boolean isAccountActivated;
    private String name;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List <UserWorkflow> userWorkflow; 
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="userTypeID", insertable=false, updatable = false)
    private UserType userType;
    

    public User(Long userID, String email, String password, boolean isAccountActivated, String name) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.isAccountActivated = isAccountActivated;
        this.name = name;
    }

    public User(){
        
    }



    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountActivated() {
        return isAccountActivated;
    }

    public void setAccountActivated(boolean isAccountActivated) {
        this.isAccountActivated = isAccountActivated;
    }

    public String getName() {
        return name;
    }

    public void setName(String vendorName) {
        this.name = name;
    }





    


    

    
}
