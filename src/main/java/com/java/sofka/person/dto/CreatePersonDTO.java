package com.java.sofka.person.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonDTO {

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
