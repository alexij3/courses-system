package com.buzilov.studying.practice.courses.service.impl;

import com.buzilov.studying.practice.courses.model.AccountBalance;
import com.buzilov.studying.practice.courses.model.User;
import com.buzilov.studying.practice.courses.repository.AccountBalanceRepository;
import com.buzilov.studying.practice.courses.repository.UserRepository;
import com.buzilov.studying.practice.courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final AccountBalanceRepository accountBalanceRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(AccountBalanceRepository accountBalanceRepository, UserRepository userRepository) {
        this.accountBalanceRepository = accountBalanceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        User newUser = userRepository.save(user);
        accountBalanceRepository.save(new AccountBalance(0.0, newUser));
    }
}
