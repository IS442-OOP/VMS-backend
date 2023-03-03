package com.example.is442oop.vmsbackend.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
public class ResponseDto {
  private String message;
  private String token;
}