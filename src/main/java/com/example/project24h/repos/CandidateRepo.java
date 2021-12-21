package com.example.project24h.repos;

import com.example.project24h.models.Candidate;
import com.example.project24h.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Integer> {
    List<Candidate> findCandidatesByParty(Party party);
}



