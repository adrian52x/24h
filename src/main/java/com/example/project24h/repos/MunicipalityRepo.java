package com.example.project24h.repos;

import com.example.project24h.models.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepo extends JpaRepository<Municipality,Integer> {
}
