package com.example.apiside.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned")
    private long id;

    private long lvl;

    private long playerLvl;

    private long health;

    private long exp;

    private String name;

    private String playerImage;


    @ManyToMany
    @JoinTable(name = "userToItems",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "item_id")}
    )
    private List<Item> inventory;

}
