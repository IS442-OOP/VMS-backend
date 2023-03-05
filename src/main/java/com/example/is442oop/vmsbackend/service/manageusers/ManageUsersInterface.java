package com.example.is442oop.vmsbackend.service.manageusers;

import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserWorkflow;

import java.util.List;


public interface ManageUsersInterface {
    public List<User> getAllUsers();

    public List<UserWorkflow> getUserWorkflows(Long userid);
}
