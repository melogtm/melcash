package org.melogtm.melcash.repository;

import org.melogtm.melcash.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.id = :id")
    Optional<Client> findClientById(Long id);
}
