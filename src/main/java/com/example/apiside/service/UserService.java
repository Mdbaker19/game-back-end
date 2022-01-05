package com.example.apiside.service;

import com.example.apiside.model.User;
import com.example.apiside.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(long id) {
        return (User) Hibernate.unproxy(userRepository.findById(id).orElse(new User()));
    }



}
