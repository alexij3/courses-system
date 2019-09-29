package com.buzilov.studying.practice.courses.service;

import com.buzilov.studying.practice.courses.dto.UserDTO;

public interface UserService {

    void create(UserDTO user);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
