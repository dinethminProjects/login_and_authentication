package com.ooad.group12.bedstore.service;

import com.ooad.group12.bedstore.model.PasswordResetRequest;
import com.ooad.group12.bedstore.model.SignInRequest;
import com.ooad.group12.bedstore.model.SignUpRequest;
import com.ooad.group12.bedstore.model.UserInfoDto;

public interface UserService {


    void sigUp(SignUpRequest request);


    UserInfoDto signIn(SignInRequest request);

    void resetPassword(Long userId,PasswordResetRequest request);

    void deleteUser(Long userId);

    void updateProfile(Long userId,SignUpRequest request);
}
