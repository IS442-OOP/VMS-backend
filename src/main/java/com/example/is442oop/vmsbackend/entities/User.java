package com.example.is442oop.vmsbackend.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long userID;
    private String name;
    private String email;

    private String password;
    private boolean isAccountActivated;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List <UserWorkflow> userWorkflows;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="userTypeID")
    private UserType userType;

    public User(@JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("name") String name,
                @JsonProperty("isAccountActivated") boolean isAccountActivated) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.isAccountActivated = isAccountActivated;
    }

    public User(){

    }

    public Long getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserWorkflow> getUserWorkflows(){ 
        return userWorkflows;
    }

    @JsonIgnore
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
        this.name = vendorName;
    }
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    public UserType getUserType() {
        return userType;
    }


    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", isAccountActivated=" + isAccountActivated +
                ", userWorkflow=" + userWorkflows +
                ", userType=" + userType +
                '}';
    }
}
