package com.example.apiside.controller;

import com.example.apiside.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class TestUserController {

    private final UserRepository userRepository;
    private final UserController userController;

    // does not work... how to test this if this is even a test for it
    @Test
    void test_getUser() {
        assertEquals(userRepository.findById(2L).get(), userController.getUser(1L));
    }
}
