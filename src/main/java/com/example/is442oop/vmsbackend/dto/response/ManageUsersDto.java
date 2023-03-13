package com.example.is442oop.vmsbackend.dto.response;
import java.util.List;

import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.UserWorkflow;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManageUsersDto extends ResponseDto {
    private List<User> users;
    private User user;
    private List<UserWorkflow> userworkflows;
}









