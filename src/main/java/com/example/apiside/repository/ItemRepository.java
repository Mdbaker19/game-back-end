package com.example.apiside.repository;

import com.example.apiside.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item getByName(String name);
}
