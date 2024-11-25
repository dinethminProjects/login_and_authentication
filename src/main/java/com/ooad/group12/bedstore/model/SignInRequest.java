package com.ooad.group12.bedstore.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {

    @NotNull(message = "Please enter email")
    @NotEmpty(message = "Please enter email")
    private String email;

    @NotNull(message = "Please enter User Password")
    @NotEmpty(message = "Please enter User Password")
    private String password;
}
