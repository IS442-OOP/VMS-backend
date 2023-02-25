package com.example.is442oop.vmsbackend.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ResponseDto {
  private String message;
  private String token;
}