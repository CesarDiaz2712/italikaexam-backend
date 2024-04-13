package com.italika.italikasystem.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italika.italikasystem.dtos.ClienDto;
import com.italika.italikasystem.services.ClientService;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.google.common.base.Preconditions;


@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService ClientService;

    public ClientController(ClientService clientService){
        this.ClientService = clientService;
        
    }

    @PostMapping("/client")
    public ResponseEntity<String> post(@RequestBody Map<String, String> mapRequest) {
        //TODO: process POST request
        
        Preconditions.checkNotNull(mapRequest);

        return ClientService.createClient(mapRequest);
    }

    @PostMapping("/client/{id}")
    public ResponseEntity<ClienDto> get(@PathVariable(name = "id") Long clientId) {
        //TODO: process POST request
        
        Preconditions.checkNotNull(clientId);

        return ClientService.getClientById(clientId);
    }
    
}
