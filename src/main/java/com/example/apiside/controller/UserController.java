package com.example.apiside.controller;

import com.example.apiside.model.Account;
import com.example.apiside.model.Item;
import com.example.apiside.model.SaveState;
import com.example.apiside.model.User;
import com.example.apiside.repository.AccountRepository;
import com.example.apiside.repository.ItemRepository;
import com.example.apiside.repository.SaveStateRepository;
import com.example.apiside.repository.UserRepository;
import com.example.apiside.service.UserService;
import com.example.apiside.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final SaveStateRepository saveStateRepository;
    private final Utility utility;
    private final ObjectMapper objectMapper;
    private final UserService userService;
    private static final String frontEnd = "http://localhost:3000";


    /**
     * @param id    - id to find the user by
     * @return user - User found based off id, will be a new user (possibly a default
     *                  user from utility.getDefaultUser() later if needed
     * */
    @GetMapping("/player/{id}")
    @ResponseBody
    public User getUser(@PathVariable long id) {
        // may do more here later, having to unproxy the user through userService. not sure why
        return userService.getUserById(id);
    }



    /**
     *
     *
     * Want to do... maybe reject if there are more than 3 saves?
     *
     * @param userData - Json with the updated user info after some game play. new info needed to be saved to the saveState's data property
     * @return save    - the save that is created
     * */
    @PostMapping("/save/{id}")
    @CrossOrigin(origins = frontEnd)
    @ResponseBody
    public SaveState saveGame(@RequestBody User userData, @PathVariable long id) {
        SaveState save = (SaveState) Hibernate.unproxy(saveStateRepository.findById(id).orElse(utility.isNewGameSaveState()));
        userRepository.save(userData);
        try {
            save.setData(objectMapper.writeValueAsString(userData));
        } catch (Exception ex) {
            // TODO: something else later
            ex.printStackTrace();
        }
        Account account = accountRepository.findById(save.getAccount().getId()).orElse(new Account());
        List<SaveState> updatedSaveList = account.getSaveStateList()
                .stream()
                .map(saveState -> saveState.getId() == id ? save : saveState)
                .collect(Collectors.toList());
        account.setSaveStateList(updatedSaveList);
        accountRepository.save(account);
        return save;
    }

    /**
     * the items returned in this list have the cost on them too.. maybe show net worth of user
     * inventory or something?
     *
     * @param id         - id to find the user by
     * @return inventory - list of Items, the user's inventory
     * */
    @GetMapping("/player-items/{id}")
    public List<Item> getPlayerInventory(@PathVariable long id) {
        User user = userService.getUserById(id);
        // add an if user is new from the getUserById from the service, do something else maybe?
        return user.getInventory();
    }


}
