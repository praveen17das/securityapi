package com.userlogin.Security.service;

import com.userlogin.Security.entity.UserEntity;
import com.userlogin.Security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserEntity registerUser(UserEntity user) {

        // password encrypt
        user.setPassword(
                encoder.encode(user.getPassword())
        );

        return userRepo.save(user);
    }
}