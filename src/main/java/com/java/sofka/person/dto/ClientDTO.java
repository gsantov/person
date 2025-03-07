package com.java.sofka.person.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ClientDTO extends PersonDTO {

    @NotNull
    private Long clientId;
    @NotBlank
    private String password;
    @NotNull
    private Boolean status;

}
