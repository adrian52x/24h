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
public class CandidateController {

    CandidateService candidateService;
    PartyService partyService;


    public CandidateController(CandidateService candidateService,PartyService partyService){
        this.candidateService = candidateService;
        this.partyService = partyService;
    }

    // FETCH ALL
    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates(){
        return candidateService.findAll();
    }

    // FETCH BY ID
    @GetMapping("/candidate/{candidateId}")
    public Candidate getCandidateById(@PathVariable int candidateId){
        return candidateService.findById(candidateId);
    }

    // FETCH ALL BY PARTY
    @GetMapping("/candidates/{partyId}")
    public List<Candidate> getCandidatesByParty(@PathVariable int partyId){
        Party party = partyService.findById(partyId);
        return candidateService.findCandidatesByParty(party);
    }

    // SAVE CANDIDATE
    @PostMapping("/candidate")
    public Candidate saveCandidate(@RequestBody Candidate candidate){
        return candidateService.save(candidate);
    }

    // ASSIGN PARTY FOR A CANDIDATE
    @PutMapping("/assign-party/{candidateId}/{partyId}")
    public Candidate addPartyToCandidate(@PathVariable int candidateId, @PathVariable int partyId){
        Candidate candidate = candidateService.findById(candidateId);
        Party party = partyService.findById(partyId);

        candidate.setParty(party);
        return candidateService.save(candidate);
    }


    // EDIT CANDIDATE
    @PutMapping("/candidate/{candidateId}")
    public Candidate updateCandidate(@PathVariable int candidateId, @RequestBody Candidate updatedCandidate){
        Candidate candidate = candidateService.findById(candidateId);

        candidate.setFirstName(updatedCandidate.getFirstName());
        candidate.setLastName(updatedCandidate.getLastName());
        candidate.setAge(updatedCandidate.getAge());

        return candidateService.save(candidate);
    }


    // DELETE CANDIDATE
    @DeleteMapping("/candidate/{candidateId}")
    public void deleteCandidate(@PathVariable int candidateId){
        Candidate candidate = candidateService.findById(candidateId);
        candidateService.delete(candidate);
    }


    // GENERATE RANDOM VOTES
    @PutMapping("/getVotes")
    public void getRandomVotesForCandidates(){
        candidateService.getRandomVotes();
    }


}
