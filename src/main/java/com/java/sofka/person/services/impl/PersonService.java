package com.java.sofka.person.services.impl;

import com.java.sofka.person.common.PersonException;
import com.java.sofka.person.dto.CreatePersonDTO;
import com.java.sofka.person.dto.PersonDTO;
import com.java.sofka.person.dto.UpdateClientDTO;
import com.java.sofka.person.dto.UpdatePersonDTO;
import com.java.sofka.person.mappers.PersonMapper;
import com.java.sofka.person.model.ClientEntity;
import com.java.sofka.person.model.PersonEntity;
import com.java.sofka.person.repositories.PersonRepository;
import com.java.sofka.person.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonEntity create(CreatePersonDTO person) {
        return personRepository.save(PersonMapper.INSTANCE.createPersonDtoToPersonEntity(person));
    }

    @Override
    public PersonEntity edit(Long clientId, UpdateClientDTO person) {
        PersonEntity personEntity = PersonMapper.INSTANCE.updatePersonDtoToPersonEntity(person);
//        personEntity.setClientEntity(ClientEntity.builder().clientId(clientId).build());
        return personRepository.save(personEntity);
    }

    @Override
    public void update(Long clientId, UpdatePersonDTO person) {
        // 1. Busco la persona
        PersonEntity personEntity = personRepository.findById(person.getPersonId())
                .orElseThrow(() -> new PersonException("No existe persona con id: " + person.getPersonId()));
//        personEntity.setClientEntity(ClientEntity.builder().clientId(clientId).build());
        // 2. Compruebo que campos se pide actualizar
        if(person.getName() != null){
            personEntity.setName(person.getName());
        }
        if(person.getGender() != null){
            personEntity.setGender(person.getGender());
        }
        if(person.getAge() != null){
            personEntity.setAge(person.getAge());
        }
        if(person.getIdentification() != null){
            personEntity.setIdentification(person.getIdentification());
        }
        if(person.getAddress() != null){
            personEntity.setAddress(person.getAddress());
        }
        if(person.getPhone() != null){
            personEntity.setPhone(person.getPhone());
        }
        // 3. Actualizo
        personRepository.save(personEntity);
    }

    public Optional<PersonEntity> findByIdentification(String identification){
        return personRepository.findByIdentification(identification);
    }

    @Override
    public void delete(Long personId) {

    }
}
