package com.ooad.group12.bedstore.controller;

import com.ooad.group12.bedstore.model.PasswordResetRequest;
import com.ooad.group12.bedstore.model.SignInRequest;
import com.ooad.group12.bedstore.model.UserInfoDto;
import com.ooad.group12.bedstore.model.SignUpRequest;
import com.ooad.group12.bedstore.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping(value = "sign-up")
    public void sigUp(@RequestBody @Validated SignUpRequest request) {
        log.info("Api Layer-Request received to create user with {}",request);
        userService.sigUp(request);
    }

    @PostMapping(value = "update-profile/{user-id}")
    public void updateProfile(@PathVariable("user-id") Long userId,@RequestBody @Validated SignUpRequest request) {
        log.info("Api Layer-Request received to update user with {}",request);
        userService.updateProfile(userId,request);
    }

    @PostMapping(value = "sign-in")
    public UserInfoDto signIn(@RequestBody @Validated SignInRequest request) {
        log.info("Api Layer-Request received to login user with {}",request);
        return userService.signIn(request);
    }

    @PostMapping(value = "password-reset/{user-id}")
    public void resetPassword(@PathVariable("user-id") Long userId, @RequestBody @Validated PasswordResetRequest request) {
        log.info("Api Layer-Request received to reset password with {}", request);
        userService.resetPassword(userId,request);
    }

    @DeleteMapping(value = "{user-id}")
    public void deleteUser(@PathVariable("user-id") Long userId) {
        log.info("Api Layer-Request received to delete user with user id {}", userId);
        userService.deleteUser(userId);
    }



}
