package com.example.is442oop.vmsbackend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrueFalseDto {
  private boolean isCompleted;
  private String message;
}
