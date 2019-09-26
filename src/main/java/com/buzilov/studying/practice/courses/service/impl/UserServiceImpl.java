package com.buzilov.studying.practice.courses.service.impl;

import com.buzilov.studying.practice.courses.dto.UserDTO;
import com.buzilov.studying.practice.courses.model.AccountBalance;
import com.buzilov.studying.practice.courses.model.User;
import com.buzilov.studying.practice.courses.repository.AccountBalanceRepository;
import com.buzilov.studying.practice.courses.repository.UserRepository;
import com.buzilov.studying.practice.courses.service.UserService;
import com.buzilov.studying.practice.courses.util.mapper.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final AccountBalanceRepository accountBalanceRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(AccountBalanceRepository accountBalanceRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.accountBalanceRepository = accountBalanceRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(UserDTO userDTO) {
        User newUser = convertUserDTOtoUser(userDTO);
        userRepository.save(newUser);
        accountBalanceRepository.save(new AccountBalance(0.0, newUser));
    }

    private User convertUserDTOtoUser(UserDTO userDTO) {
        User user = ObjectMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

}
