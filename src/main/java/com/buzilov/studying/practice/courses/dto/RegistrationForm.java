package com.buzilov.studying.practice.courses.dto;

import com.buzilov.studying.practice.courses.model.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Data
public class RegistrationForm {

    private String username;
    private String password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateOfBirth;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), true, dateOfBirth);
    }

}
