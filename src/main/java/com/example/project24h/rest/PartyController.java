package com.example.project24h.rest;

import com.example.project24h.models.Candidate;
import com.example.project24h.models.Party;
import com.example.project24h.services.CandidateService;
import com.example.project24h.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PartyController {


    PartyService partyService;

    public PartyController(PartyService partyService){
        this.partyService = partyService;
    }


    @GetMapping("/parties")
    public List<Party> getAllParties(){
        return partyService.findAll();
    }

    @PostMapping("/party")
    public Party saveParty(@RequestBody Party party){
        return partyService.save(party);
    }

}
