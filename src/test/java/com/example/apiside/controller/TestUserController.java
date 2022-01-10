package com.example.apiside.controller;

import com.example.apiside.model.User;
import com.example.apiside.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserController {

    private static UserRepository userRepository;
    private static UserController userController;

    private User user;

    @BeforeEach
    public void before() {
        user = userRepository.findById(1L).get();
    }

    // does not work... how to test this if this is even a test for it
    @Test
    void test_getUser() {
        assertEquals(1, 1);
//        Mockito.when(userRepository.findById(1L).get().getHealth()).thenReturn(100L);
        long hp = userController.getUser(1).getHealth();
        assertEquals(hp, 100L);
//        assertEquals(userRepository.findById(2L).get(), userController.getUser(1L));
    }
}
