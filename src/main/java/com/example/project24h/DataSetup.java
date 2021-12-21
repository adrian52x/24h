package com.example.project24h;

import com.example.project24h.models.Municipality;
import com.example.project24h.models.Party;
import com.example.project24h.repos.CandidateRepo;
import com.example.project24h.repos.MunicipalityRepo;
import com.example.project24h.repos.PartyRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSetup implements CommandLineRunner {

    PartyRepo partyRepo;
    CandidateRepo candidateRepo;
    MunicipalityRepo municipalityRepo;


    public DataSetup(PartyRepo partyRepo, CandidateRepo candidateRepo, MunicipalityRepo municipalityRepo){
        this.partyRepo = partyRepo;
        this.candidateRepo = candidateRepo;
        this.municipalityRepo = municipalityRepo;
    }



    @Override
    public void run(String... args) throws Exception {

    municipalityRepo.save(new Municipality("Copenhagen"));

    partyRepo.save(new Party("Social Democrats","Mette Frederiksen"));
    partyRepo.save(new Party("Venstre","Jakob Ellemann-Jensen"));
    partyRepo.save(new Party("Conservative","Søren Pape Poulsen"));
    partyRepo.save(new Party("SF","Pia Olsen Dyhr"));
    partyRepo.save(new Party("Red–Green","Mai Villadsen"));



    }


}
