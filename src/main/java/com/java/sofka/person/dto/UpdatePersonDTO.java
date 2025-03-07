package com.java.sofka.person.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePersonDTO {

    private Long personId;
    private String name;
    private String gender;
    private Short age;
    private String identification;
    private String address;
    private String phone;

}
