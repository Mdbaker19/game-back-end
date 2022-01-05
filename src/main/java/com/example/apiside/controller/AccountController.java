package com.example.apiside.controller;

import com.example.apiside.model.SaveState;
import com.example.apiside.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private static final String frontEnd = "http://localhost:3000";

    /**
     * @param name        - name to find the saveStates by, easier with the form in the UI
     * @return inventory  - list of Saves, the account's saveState list
     */

    @GetMapping("/account/{name}")
    public List<SaveState> getPlayerSaveList(@PathVariable String name) {
        return accountRepository.findAccountByAccountName(name).getSaveStateList();
    }

}
