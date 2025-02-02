package org.melogtm.melcash.repository;

import jakarta.transaction.Transactional;
import org.melogtm.melcash.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.id = :id")
    Optional<Client> findClientById(Long id);


    @Transactional
    @Modifying
    @Query("UPDATE Client c SET c.cash = c.cash + :value WHERE c.id = :id")
    void addCash(Long id, Double value);

    @Transactional
    @Modifying
    @Query("UPDATE Client c SET c.cash = c.cash - :value WHERE c.id = :id")
    void removeCash(Long id, Double value);
}
