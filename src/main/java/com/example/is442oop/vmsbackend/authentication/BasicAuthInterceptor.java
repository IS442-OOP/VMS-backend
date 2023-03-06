package com.example.is442oop.vmsbackend.authentication;

import com.example.is442oop.vmsbackend.exception.UserForbiddenException;
import com.example.is442oop.vmsbackend.exception.UserUnauthorizedException;
import com.example.is442oop.vmsbackend.utils.JwtUtil;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

public class BasicAuthInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    if (!request.getRequestURI().contains("account") && !request.getRequestURI().contains("error")) {
      try {
        String header = request.getHeader("Authorization").split(" ")[1];
        System.out.println(header);
        if (header == "") {
          response.setStatus(HttpStatus.UNAUTHORIZED.value());
          response.getWriter().write("User is forbidden to access");
          return false; // stop the request from reaching the controller
        }
        String token = header.split(" ")[1];
        Claims jwtValues = JwtUtil.verifyToken(token);
        request.setAttribute("userId", jwtValues.get("id"));
        return true;


      } catch(Exception e){
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write("User is forbidden to access");
        return false;

      }
    }

    return true;

  }

  public boolean postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("POST");
    try {
      return true;
    } catch(Exception e){
      throw new UserUnauthorizedException("User is unauthorized");
    }
  }
}
