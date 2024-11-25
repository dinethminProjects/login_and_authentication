package com.ooad.group12.bedstore.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResetRequest {

    @NotNull(message = "Please enter old Password")
    @NotEmpty(message = "Please enter old Password")
    private String oldPassword;

    @NotNull(message = "Please enter new Password")
    @NotEmpty(message = "Please enter new Password")
    private String newPassword;
}
