package com.ooad.group12.bedstore.service.impl;

import com.ooad.group12.bedstore.entity.User;
import com.ooad.group12.bedstore.model.PasswordResetRequest;
import com.ooad.group12.bedstore.model.SignInRequest;
import com.ooad.group12.bedstore.model.SignUpRequest;
import com.ooad.group12.bedstore.model.UserInfoDto;
import com.ooad.group12.bedstore.repository.UserRepository;
import com.ooad.group12.bedstore.service.UserService;
import com.ooad.group12.bedstore.service.exception.BusinessException;
import com.ooad.group12.bedstore.service.exception.BusinessExceptionType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void sigUp(SignUpRequest request) {
        log.info("Service Layer-Request received to create user with {}",request);

        Optional<User> emailUser = userRepository.findByEmail(request.getEmail());
        if (emailUser.isPresent()) {
            throw new BusinessException(BusinessExceptionType.BUSINESS,"Email exists");
        }

        User user = new User();
        BeanUtils.copyProperties(request, user);

        String encodedPassword = DigestUtils.sha256Hex(request.getPassword());
        user.setPassword(encodedPassword);
        user.setActive(Boolean.TRUE);
        userRepository.save(user);
        log.info("Service Layer-Successfully saved user with {}",user);
    }

    @Override
    public UserInfoDto signIn(SignInRequest request) {
        log.info("Service Layer-Request received to sign in user with {}",request);

        String encodedPassword = DigestUtils.sha256Hex(request.getPassword());
        Optional<User> loginUser = userRepository.findByEmailAndPassword(request.getEmail(),encodedPassword);


        if (loginUser.isPresent()) {

            if (!loginUser.get().getActive()) {
                throw new BusinessException(BusinessExceptionType.USER_DISABLED,"User Disabled");
            }
            return new UserInfoDto(loginUser.get());
        } else {
            throw new BusinessException(BusinessExceptionType.USER_NOT_FOUND,"User name or Password incorrect");
        }

    }

    @Override
    @Transactional
    public void resetPassword(Long userId,PasswordResetRequest request) {
        log.info("Service Layer-Request received to reset password with {}",request);

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new BusinessException(BusinessExceptionType.USER_NOT_FOUND,"User not found");
        }
        if (!user.get().getActive()) {
            throw new BusinessException(BusinessExceptionType.USER_DISABLED,"User Disabled");
        }

        User existUser = user.get();
        String existPassword = DigestUtils.sha256Hex(request.getOldPassword());
        String newPassword = DigestUtils.sha256Hex(request.getNewPassword());
        if (!existPassword.equals(existUser.getPassword())) {
            throw new BusinessException(BusinessExceptionType.BUSINESS, "Incorrect old password");
        }

        existUser.setPassword(newPassword);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new BusinessException(BusinessExceptionType.USER_NOT_FOUND,"User not found");
        }
        if (!user.get().getActive()) {
            throw new BusinessException(BusinessExceptionType.USER_DISABLED,"User Disabled");
        }

        user.get().setActive(Boolean.FALSE);
    }

    @Override
    @Transactional
    public void updateProfile(Long userId,SignUpRequest request) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new BusinessException(BusinessExceptionType.USER_NOT_FOUND,"User not found");
        }
        BeanUtils.copyProperties(request,user);
    }
}
