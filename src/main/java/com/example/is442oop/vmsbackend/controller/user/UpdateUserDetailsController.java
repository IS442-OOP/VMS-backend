package com.example.is442oop.vmsbackend.controller.user;

import com.example.is442oop.vmsbackend.dto.request.UpdateUserDetailsDto;
import com.example.is442oop.vmsbackend.entities.User;
import com.example.is442oop.vmsbackend.service.user.updateDetails.UpdateUserDetailsService;
import com.example.is442oop.vmsbackend.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/update")
public class UpdateUserDetailsController {

  private final UpdateUserDetailsService updateDetailsService;

  @Autowired
  public UpdateUserDetailsController(UpdateUserDetailsService updateDetailsService) {
    this.updateDetailsService = updateDetailsService;
  }

  @PutMapping
  public ResponseEntity updatePassword(
          @RequestBody UpdateUserDetailsDto updateUserDetailsDto,
          @RequestAttribute("userId") String userId)
  {

    try {
      if (updateDetailsService.updatePassword(updateUserDetailsDto, userId)) {
        return ResponseUtil.responseUpdateSuccess(userId);
      } else {
        return ResponseUtil.responseUpdateFail(userId);
      }
    } catch (Exception e) {
      return ResponseUtil.responseInternalServerError(e.getMessage());
    }
  }
}
