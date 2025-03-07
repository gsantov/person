package com.java.sofka.person.repositories;

import com.java.sofka.person.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT cli.personEntity.id FROM ClientEntity cli WHERE cli.id = :clientId")
    Optional<Long> findPersonIdByClientId(@Param("clientId") Long clientId);

}
