package com.example.apiside.controller;

import com.example.apiside.model.Item;
import com.example.apiside.model.SaveState;
import com.example.apiside.model.User;
import com.example.apiside.repository.ItemRepository;
import com.example.apiside.repository.SaveStateRepository;
import com.example.apiside.repository.UserRepository;
import com.example.apiside.service.UserService;
import com.example.apiside.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DataCreation {

    private final ItemRepository itemRepository;
    private final SaveStateRepository saveStateRepository;
    private final UserService userService;
    private final Utility utility;
    private static final String frontEnd = "http://localhost:3000";


    /**
     * Used to create a new item for a user, may require changes or a separate method
     * for adding items to the user inventory, going from 1x potion to 2x potions or something
     *
     * @param item     - Item Json from UI
     * @param playerId - the id for the current player
     * @param saveId   - id for the current save state being played for this player
     * @return item
     * */
    @PostMapping("/create-item/{playerId}/{saveId}")
    @ResponseBody
    @CrossOrigin(origins = frontEnd)
    public Item createItemTest(@RequestBody Item item, @PathVariable long playerId, @PathVariable long saveId) {
        User user = userService.getUserById(playerId);
        Item newItem = null;
        try {
            newItem = (Item) Hibernate.unproxy(itemRepository.getByName(item.getName()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(newItem == null) {
            itemRepository.save(item);
        }
        List<Item> inventory = user.getInventory();
        inventory.add(item);
        user.setInventory(inventory);

        // update the user's specific save state this item is being added to
        SaveState saveState = saveStateRepository.findById(saveId).get();

//        utility.updateSaveStateData(user, saveState);

        return item;
    }

}
