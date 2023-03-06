package com.example.is442oop.vmsbackend.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserDetailsDto {
  private String newPassword;
  private String confirmPassword;
}
