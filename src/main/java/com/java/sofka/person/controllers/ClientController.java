package com.java.sofka.person.controllers;

import com.java.sofka.person.dto.ClientDTO;
import com.java.sofka.person.dto.CreateClientDTO;
import com.java.sofka.person.dto.ResponseDTO;
import com.java.sofka.person.dto.UpdateClientDTO;
import com.java.sofka.person.services.IClientService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping("{clientId}")
    public ResponseEntity<ResponseDTO<ClientDTO>> findById(@NotNull @PathVariable Long clientId) {
        return new ResponseEntity<>(ResponseDTO.<ClientDTO>builder()
                .data(clientService.findById(clientId))
                .build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<ClientDTO>> createClient(@RequestBody CreateClientDTO clientDTO) {
        return new ResponseEntity<>(ResponseDTO.<ClientDTO>builder()
                .data(clientService.create(clientDTO))
                .build(), HttpStatus.OK);
    }

    @PutMapping("{clientId}")
    public ResponseEntity<ResponseDTO<ClientDTO>> edit(@NotNull @PathVariable Long clientId,
                                                       @RequestBody UpdateClientDTO clientDTO) {
        return new ResponseEntity<>(ResponseDTO.<ClientDTO>builder()
                .data(clientService.edit(clientId, clientDTO))
                .build(), HttpStatus.OK);
    }

    @PatchMapping("{clientId}")
    public ResponseEntity<ResponseDTO<Void>> update(@NotNull @PathVariable Long clientId,
                                                    @RequestBody UpdateClientDTO clientDTO) {
        clientService.update(clientId, clientDTO);
        return new ResponseEntity<>(ResponseDTO.<Void>builder().build(), HttpStatus.OK);
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<ResponseDTO<Void>> delete(@NotNull @PathVariable Long clientId) {
        clientService.delete(clientId);
        return new ResponseEntity<>(ResponseDTO.<Void>builder().build(), HttpStatus.OK);
    }

}
