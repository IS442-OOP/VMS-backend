package com.example.is442oop.vmsbackend.authentication;

import com.example.is442oop.vmsbackend.exception.UserForbiddenException;
import com.example.is442oop.vmsbackend.exception.UserUnauthorizedException;
import com.example.is442oop.vmsbackend.utils.JwtUtil;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class BasicAuthInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    if (!request.getRequestURI().contains("account")) {
      try {
        String token = request.getHeader("Authorization").split(" ")[1];
        try {
          Claims jwtValues = JwtUtil.verifyToken(token);
          request.setAttribute("userId", jwtValues.get("id"));

          return true;

        } catch (Exception e){
          System.out.println(e.getMessage());
          return false;
        }

      } catch(Exception e){
        System.out.println(e.getMessage());
        if (e instanceof UserForbiddenException){
          throw new UserForbiddenException(e.getMessage());
        } else {
          return false;
        }
      }
    }

    return true;
  }

  public boolean postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    try {
      return true;
    } catch(Exception e){
      throw new UserUnauthorizedException("User is unauthorized");
    }
  }
}
