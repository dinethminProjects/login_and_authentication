package com.ooad.group12.bedstore.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotNull(message = "Please enter full Name")
    @NotEmpty(message = "User name can't be empty")
    private String fullName;

    @NotNull(message = "Please enter Email")
    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Please enter Password")
    @NotEmpty(message = "Password can't be empty")
    private String password;

    @NotNull(message = "Please enter Address")
    @NotEmpty(message = "Address can't be empty")
    private String address;

}
