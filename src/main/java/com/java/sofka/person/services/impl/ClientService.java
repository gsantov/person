package com.java.sofka.person.services.impl;

import com.java.sofka.person.common.PersonException;
import com.java.sofka.person.dto.ClientDTO;
import com.java.sofka.person.dto.CreateClientDTO;
import com.java.sofka.person.dto.UpdateClientDTO;
import com.java.sofka.person.mappers.ClientMapper;
import com.java.sofka.person.model.ClientEntity;
import com.java.sofka.person.model.PersonEntity;
import com.java.sofka.person.repositories.ClientRepository;
import com.java.sofka.person.services.IClientService;
import com.java.sofka.person.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IPersonService personService;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDTO create(CreateClientDTO client) {
        // 1. Verifico si existe un cliente con la identificacion
        personService.findByIdentification(client.getIdentification())
                .ifPresent(personEntity -> {
                    throw new PersonException("Ya existe un cliente con la identificación " + client.getIdentification());
                });
        // 2. Creo el cliente
        ClientEntity clientEntity = ClientMapper.INSTANCE.createClientDtoToClientEntity(client);
        clientEntity.setPersonEntity(personService.create(client));
        return ClientMapper.INSTANCE.clientEntityToClientDto(clientRepository.save(clientEntity));
    }

    @Override
    public ClientDTO edit(Long clientId, UpdateClientDTO client) {
        // 1. Busco el id de la persona por cliente
        client.setPersonId(findPersonByClientId(clientId));
        // 2. Edito la persona
        PersonEntity person = personService.edit(clientId, client);
        // 3. Edito el cliente
        ClientEntity clientEntity = ClientMapper.INSTANCE.updateClientDtoToClientEntity(client);
        clientEntity.setPersonEntity(person);
        return ClientMapper.INSTANCE.clientEntityToClientDto(clientRepository.save(clientEntity));
    }

    @Override
    public void update(Long clientId, UpdateClientDTO client) {
        // 1. Busco el id de la persona por cliente
        client.setPersonId(findPersonByClientId(clientId));
        // 2. Actualizo la persona
        personService.update(clientId, client);
        // 3. Busco el cliente por id
        ClientEntity clientEntity = clientRepository.findById(clientId)
                .orElseThrow(() -> new PersonException("No existe cliente con id: " + clientId));
        // 4. Compruebo que campos se pide actualizar
        if (client.getPassword() != null) {
            clientEntity.setPassword(client.getPassword());
        }
        if (client.getStatus() != null) {
            clientEntity.setStatus(client.getStatus());
        }
        // 5. Actualizo
        clientRepository.save(clientEntity);
    }

    @Override
    public void delete(Long clientId) {
        clientRepository.findById(clientId)
                .ifPresentOrElse(clientEntity -> {
                    clientEntity.setStatus(Boolean.FALSE);
                    clientRepository.save(clientEntity);
                }, () -> {
                    throw new PersonException("No existe el cliente con id: " + clientId);
                });
    }

    @Override
    public ClientDTO findById(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper.INSTANCE::clientEntityToClientDto)
                .orElseThrow(() -> new PersonException("No existe el cliente con id: " + id));
    }

    private Long findPersonByClientId(Long clientId) {
        return clientRepository.findPersonIdByClientId(clientId)
                .orElseThrow(() -> new PersonException("No existe el cliente con id: " + clientId));
    }
}
