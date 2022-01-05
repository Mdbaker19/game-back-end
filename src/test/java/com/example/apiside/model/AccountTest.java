package com.example.apiside.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getId() {
        Account a = new Account();
        a.setId(1);
        assertEquals(1, a.getId());
    }
}