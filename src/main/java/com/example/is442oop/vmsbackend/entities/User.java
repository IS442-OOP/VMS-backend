package com.example.is442oop.vmsbackend.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public List <UserWorkflow> userWorkflow;
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="userTypeID", insertable=false, updatable = false)
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

    @JsonIgnore
    public Long getUserID() {
        return userID;
    }

    @JsonIgnore
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        this.name = name;
    }
    
    public UserType getUserType() {
        return userType;
    }


    

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", isAccountActivated=" + isAccountActivated +
                ", userWorkflow=" + userWorkflow +
                ", userType=" + userType +
                '}';
    }
}
