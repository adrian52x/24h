package com.example.project24h.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String age;
    private int votes;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Party party;

    public Candidate(String firstName, String lastName, String age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


   /* public void addParty(Party party){
        this.party = party;
    }*/

}
