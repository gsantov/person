package com.java.sofka.person.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class ResponseDTO<T> {

    private T data;
    private Map<String, String> errors;
    private String message;

}