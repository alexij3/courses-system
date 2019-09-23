package com.buzilov.studying.practice.courses.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDTO {

    @NotNull(message = "Username cannot be null.")
    @Min(value = 6, message = "Username must have at least 6 characters.")
    @Max(value = 20, message = "Username must not exceed 20 characters.")
    private String username;

    @Min(value = 8, message = "Password must have at least 6 characters.")
    @Max(value = 32, message = "Password must not exceed 32 characters.")
    private String password;

    @NotNull(message = "Email cannot be null.")
    @Email
    private String email;

    private boolean enabled;

    @NotNull(message = "Date of birth cannot be null.")
    private Date dateOfBirth;

}
