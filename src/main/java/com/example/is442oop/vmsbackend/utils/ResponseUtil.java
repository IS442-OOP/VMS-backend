package com.example.is442oop.vmsbackend.utils;

import com.example.is442oop.vmsbackend.dto.response.LoginResponseDto;
import com.example.is442oop.vmsbackend.dto.response.ResponseDto;
import com.example.is442oop.vmsbackend.dto.response.TrueFalseDto;
import com.example.is442oop.vmsbackend.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

  private final static String responseConflictEmail = "User already exists for email: ";
  private final static String responseCreated = "User has been created for Id: ";
  private final static String responseInternalServerError = "Internal Server Error has occured";
  private final static String responseUserNotFoundEmail = "User cannot be found with email: ";

  private final static String responseUserNotFoundId = "User cannot be found with id: ";
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

  public static TrueFalseDto createReturnValue(String message, boolean state) {
    return TrueFalseDto.builder()
            .isCompleted(state)
            .message(message)
            .build();
  }

  public static ResponseEntity<User> responseOk(User user) throws JsonProcessingException {
//    System.out.println(user.toString());
//    ObjectMapper mapper = new ObjectMapper();
//    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//    String json = mapper.writeValueAsString(user);
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

  public static ResponseEntity responseUserNotFoundEmail(String email) {
    ResponseDto body = createReturnValue(responseUserNotFoundEmail + email);
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(body);
  }

  public static ResponseEntity responseUserNotFoundId(String userId) {
    ResponseDto body = createReturnValue(responseUserNotFoundId + userId);
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
    ResponseDto body = createReturnValue(responseLoginSuccess + Id, token);
    return ResponseEntity.status(HttpStatus.OK)
            .body(body);
  }

  public static ResponseEntity responseUpdateSuccess(String Id) {
    TrueFalseDto body = createReturnValue(responseLoginSuccess + Id, true);
    return ResponseEntity.status(HttpStatus.OK)
            .body(body);
  }

  public static ResponseEntity responseUpdateFail(String Id) {
    TrueFalseDto body = createReturnValue(responseLoginSuccess + Id, false);
    return ResponseEntity.status(HttpStatus.OK)
            .body(body);
  }

  public static ResponseEntity responseInternalServerError() {
    ResponseDto body = createReturnValue(responseInternalServerError);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(body);
  }

  public static ResponseEntity responseInternalServerError(String message) {
    ResponseDto body = createReturnValue(message);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(body);
  }

  public static ResponseEntity responseNotAuthorized() {
    ResponseDto body = createReturnValue(responseNotAuthorized);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(body);
  }
}
