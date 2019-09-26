package com.buzilov.studying.practice.courses.service.impl;

import com.buzilov.studying.practice.courses.model.User;
import com.buzilov.studying.practice.courses.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            return new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.getEmail(), user.getDateOfBirth(), user.getRole());
        }

        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
