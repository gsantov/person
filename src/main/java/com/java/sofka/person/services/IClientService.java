package com.java.sofka.person.services;

import com.java.sofka.person.dto.ClientDTO;
import com.java.sofka.person.dto.CreateClientDTO;
import com.java.sofka.person.dto.UpdateClientDTO;

import java.util.List;

public interface IClientService {

    /**
     * Crear un nuevo cliente
     * @param client informacion del cliente
     * @return cliente creado
     */
    ClientDTO create(CreateClientDTO client);

    /**
     * Editar toda la informacion de un cliente
     * @param client informacion del cliente
     * @return cliente editado
     */
    ClientDTO edit(Long clientId, UpdateClientDTO client);

    /**
     * Actualizar solamente cierta información del cliente
     * @param client informacion del cliente
     */
    void update(Long clientId, UpdateClientDTO client);

    /**
     * Eliminar logicamente un cliente
     * @param clientId id del cliente
     */
    void delete(Long clientId);

    ClientDTO findById(Long id);
}
