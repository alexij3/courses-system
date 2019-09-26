package com.buzilov.studying.practice.courses.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class UserDTO {

    @NotNull(message = "Username cannot be null.")
    @Size(min = 6, max = 20, message = "Username must contain from 6 to 20 characters.")
    private String username;

    @Size(min = 8, max = 32, message = "Password must contain from 8 to 32 characters.")
    private String password;

    @NotNull(message = "Email cannot be null.")
    @Email
    private String email;

    private boolean enabled = true;

    @NotNull(message = "Date of birth cannot be null.")
    private Date dateOfBirth;

    private String role = "ROLE_USER";

}
