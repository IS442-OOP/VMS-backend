package com.example.is442oop.vmsbackend.entities;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="User")
public class User {
    @Id 
    private Integer userID;
    private String email;
    private String password;
    private Boolean isAccountActivated;
    private String vendorName; 

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List <UserWorkflow> userWorkflow; 
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="userTypeID", insertable=false, updatable = false)
    private UserType userType;
    

    public User(Integer userID, String email, String password, boolean isAccountActivated, String vendorName) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.isAccountActivated = isAccountActivated;
        this.vendorName = vendorName;
    }

    public User(){
        
    }



    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
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

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }





    


    

    
}
