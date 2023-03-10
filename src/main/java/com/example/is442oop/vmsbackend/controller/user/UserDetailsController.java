package com.example.is442oop.vmsbackend.controller.user;

import com.example.is442oop.vmsbackend.dto.request.UpdateUserDetailsDto;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.exception.NotFoundException;
import com.example.is442oop.vmsbackend.service.user.userDetails.UserDetailsService;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserDetailsController {

  private final UserDetailsService userDetailsService;

  @Autowired
  public UserDetailsController(UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @PutMapping(path = "/update")
  public ResponseEntity updatePassword(
          @RequestBody UpdateUserDetailsDto updateUserDetailsDto,
          @RequestAttribute("userId") String userId)
  {

    try {
      if (userDetailsService.updatePassword(updateUserDetailsDto, userId)) {
        return ResponseUtil.responseUpdateSuccess(userId);
      } else {
        return ResponseUtil.responseUpdateFail(userId);
      }
    } catch (Exception e) {
      return ResponseUtil.responseInternalServerError(e.getMessage());
    }
  }

  @GetMapping(path = "/details")
  public ResponseEntity getUserDetails(
          @RequestAttribute("userId") String userId)
  {

    try {
      User user = userDetailsService.getUserDetails(userId);
      System.out.println(user.toString());
      return ResponseUtil.responseOk(user);
    } catch (NotFoundException e) {
      return ResponseUtil.responseUserNotFoundId(userId);
    } catch (Exception e) {
      return ResponseUtil.responseInternalServerError(e.getMessage());
    }
  }
}
