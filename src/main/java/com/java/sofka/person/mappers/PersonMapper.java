package com.java.sofka.person.mappers;

import com.java.sofka.person.dto.CreatePersonDTO;
import com.java.sofka.person.dto.PersonDTO;
import com.java.sofka.person.dto.UpdatePersonDTO;
import com.java.sofka.person.model.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonEntity createPersonDtoToPersonEntity(CreatePersonDTO createPersonDTO);

    PersonEntity personDtoToPersonEntity(PersonDTO personDTO);

    PersonEntity updatePersonDtoToPersonEntity(UpdatePersonDTO personDTO);

}
