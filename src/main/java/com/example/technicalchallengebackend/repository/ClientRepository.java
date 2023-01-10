package com.example.technicalchallengebackend.repository;

import com.example.technicalchallengebackend.domain.Client;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
