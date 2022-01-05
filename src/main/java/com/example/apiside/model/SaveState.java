package com.example.apiside.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "saveStates")
public class SaveState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned")
    private long id;

    @Column(columnDefinition = "TEXT")
    private String data;

    @JsonIgnore
    @ManyToOne
    private Account account;

    public SaveState(){}

}
