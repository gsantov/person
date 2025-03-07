package com.java.sofka.person.services;

import com.java.sofka.person.dto.PersonDTO;
import com.java.sofka.person.dto.CreatePersonDTO;
import com.java.sofka.person.dto.UpdateClientDTO;
import com.java.sofka.person.dto.UpdatePersonDTO;
import com.java.sofka.person.model.PersonEntity;

import java.util.Optional;

public interface IPersonService {

    /**
     * Crear una nueva persona
     * @param person informacion de persona
     * @return persona creada
     */
    PersonEntity create(CreatePersonDTO person);

    /**
     * Editar toda la informacion de una persona
     * @param person informacion de persona
     * @return persona editada
     */
    PersonEntity edit(Long clientId, UpdateClientDTO person);

    /**
     * Actualizar solamente cierta información de persona
     * @param person informacion de persona
     */
    void update(Long clientId, UpdatePersonDTO person);

    /**
     * Busca una persona por identificacion
     * @param identification
     * @return
     */
    Optional<PersonEntity> findByIdentification(String identification);

    /**
     * Eliminar logicamente una persona
     * @param personId id de persona
     */
    void delete(Long personId);
}
