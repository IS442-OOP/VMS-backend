package com.example.is442oop.vmsbackend.dto.response;
import com.example.is442oop.vmsbackend.entities.User;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
public class LoginResponseDto extends ResponseDto {
    private User user; 
}









