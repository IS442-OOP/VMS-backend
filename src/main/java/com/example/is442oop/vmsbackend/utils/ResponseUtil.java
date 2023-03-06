package com.example.is442oop.vmsbackend.utils;

import com.example.is442oop.vmsbackend.dto.LoginResponseDto;
import com.example.is442oop.vmsbackend.dto.ResponseDto;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.entities.Workflow;
import org.hibernate.jdbc.Work;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ResponseUtil {

  private final static String responseConflictEmail = "User already exists for email: ";
  private final static String responseCreated = "User has been created for Id: ";
  private final static String responseInternalServerError = "Internal Server Error has occured";
  private final static String responseUserNotFound = "User cannot be found with email: ";
  private final static String responseTaskNotFound = "Task cannot be found for Id: ";
  private final static String responseTaskDeleted = "Task has been deleted for Id: ";
  private final static String responseTaskUpdated = "Task has been updated for Id: ";
  private final static String responseNotAuthorized = "User not authorized";
  private final static String responseLoginSuccess = "User has login successfully for Id: ";

  public static ResponseDto createReturnValue(String message) {
    return ResponseDto.builder()
            .message(message)
            .build();
  }

  public static ResponseDto createReturnValue(String message, String token) {
    return ResponseDto.builder()
            .message(message)
            .token(token)
            .build();
  }

  public static LoginResponseDto createReturnValue(String message, String token, User user) {
    return LoginResponseDto.builder()
            .message(message)
            .token(token)
            .user(user)
            .build();
  }

  public static ResponseEntity<User> responseOk(User user) {
    return ResponseEntity.status(HttpStatus.OK)
            .body(user);
  }

  public static ResponseEntity<User> responseVendorCreated(User user) {
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(user);
  }

  public static ResponseEntity<LoginResponseDto> responseOk(String message, String token, User user) {
    return ResponseEntity.status(HttpStatus.OK)
            .body(createReturnValue(message, token, user));
  }


  public static ResponseEntity responseTaskDeleted(Long Id) {
    ResponseDto body = createReturnValue(responseTaskDeleted + Id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(body);
  }

  public static ResponseEntity responseTaskUpdated(Long Id) {
    ResponseDto body = createReturnValue(responseTaskUpdated + Id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(body);
  }

  public static ResponseEntity responseTaskNotFound(Long Id) {
    ResponseDto body = createReturnValue(responseTaskNotFound + Id);
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(body);
  }

  public static ResponseEntity responseUserNotFound(String email) {
    ResponseDto body = createReturnValue(responseUserNotFound + email);
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(body);
  }

  public static ResponseEntity responseConflict(String email) {
    ResponseDto body = createReturnValue(responseConflictEmail + email);
    return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(body);
  }

  public static ResponseEntity responseTaskCreated(Long Id) {
    ResponseDto body = createReturnValue(responseCreated + Id);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(body);
  }

  public static ResponseEntity responseUserCreated(Long Id, String token) {
    ResponseDto body = createReturnValue(responseCreated + Id, token);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(body);
  }

  public static ResponseEntity responseLoginSuccess(Long Id, String token, User user) {
    ResponseDto body = createReturnValue(responseLoginSuccess + Id, token, user);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(body);
  }

  public static ResponseEntity responseInternalServerError() {
    ResponseDto body = createReturnValue(responseInternalServerError);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(body);
  }

  public static ResponseEntity responseNotAuthorized() {
    ResponseDto body = createReturnValue(responseNotAuthorized);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(body);
  }

  public static ResponseEntity <List<Workflow>> responseOk(List<Workflow> list){
    return ResponseEntity.status(HttpStatus.OK)
            .body(list);
  }

}
