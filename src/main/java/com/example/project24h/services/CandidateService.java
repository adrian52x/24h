package com.example.project24h.services;

import com.example.project24h.models.Candidate;
import com.example.project24h.models.Party;
import com.example.project24h.repos.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.lang.Math;

@Service
public class CandidateService {
    @Autowired
    CandidateRepo candidateRepo;

    public List<Candidate> findAll() {
        return candidateRepo.findAll();
    }

    public Candidate findById(int id){
        return candidateRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No candidate found for ID: " + id));
    }

    public List<Candidate> findCandidatesByParty(Party party){
        return candidateRepo.findCandidatesByParty(party);
    }

    public Candidate save(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    public void delete(Candidate candidate){
        candidateRepo.delete(candidate);
    }


    public void getRandomVotes(){
        int min = 50;
        int max = 500;
        List<Candidate> candidates = candidateRepo.findAll();

        for (Candidate person : candidates)
        {
            person.setVotes((int)(Math.random()*(max-min+1)+min));
            candidateRepo.save(person);
        }
    }


}
