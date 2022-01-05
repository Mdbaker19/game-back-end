package com.example.apiside.util;

import com.example.apiside.model.SaveState;
import com.example.apiside.model.User;
import com.example.apiside.repository.AccountRepository;
import com.example.apiside.repository.SaveStateRepository;
import com.example.apiside.repository.UserRepository;
import com.example.apiside.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Utility {

    private final ObjectMapper objectMapper;
    private final SaveStateRepository saveStateRepository;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final UserService userService;

    // this will be for much later, when i add the option for new game. how do i get the account this is associated to?
    public SaveState isNewGameSaveState() {
        return new SaveState();
    }


}
