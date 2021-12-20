package com.example.project24h.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String leaderName;

    @OneToMany(mappedBy = "party")
    private Set<Candidate> candidates = new HashSet<>();

    public Party(String name, String leaderName){
        this.name = name;
        this.leaderName = leaderName;
    }

}
