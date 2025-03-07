package com.java.sofka.person.mappers;

import com.java.sofka.person.dto.ClientDTO;
import com.java.sofka.person.dto.CreateClientDTO;
import com.java.sofka.person.dto.UpdateClientDTO;
import com.java.sofka.person.model.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientEntity createClientDtoToClientEntity(CreateClientDTO clientDTO);

    @Mapping(source = "personEntity.personId", target = "personId")
    @Mapping(source = "personEntity.name", target = "name")
    @Mapping(source = "personEntity.gender", target = "gender")
    @Mapping(source = "personEntity.age", target = "age")
    @Mapping(source = "personEntity.identification", target = "identification")
    @Mapping(source = "personEntity.address", target = "address")
    @Mapping(source = "personEntity.phone", target = "phone")
    ClientDTO clientEntityToClientDto(ClientEntity clientEntity);

    ClientEntity clientDtoToClientEntity(ClientDTO clientDTO);

    ClientEntity updateClientDtoToClientEntity(UpdateClientDTO clientDTO);

}
