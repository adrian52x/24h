package com.example.project24h.services;

import com.example.project24h.models.Party;
import com.example.project24h.repos.PartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PartyService {

    @Autowired
    PartyRepo partyRepo;

    public List<Party> findAll() {
        return partyRepo.findAll();
    }

    public Party findById(int id){
        return partyRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No party found for ID: " + id));
    }

    public Party save(Party party) {
        return partyRepo.save(party);
    }

}
