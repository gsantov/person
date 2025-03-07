package com.java.sofka.person.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PersonDTO {

    @NotNull
    private Long personId;
    @NotBlank
    private String name;
    private String gender;
    private Short age;
    @NotBlank
    private String identification;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;

}
