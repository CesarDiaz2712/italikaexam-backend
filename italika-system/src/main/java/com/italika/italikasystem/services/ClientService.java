package com.italika.italikasystem.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.italika.italikasystem.dtos.ClienDto;

public interface ClientService {

    ResponseEntity<String> createClient(Map<String, String> mapRequest);

    ResponseEntity<ClienDto> getClientById(Long clientId);
    
    ResponseEntity<ClienDto> getClientByEmail(Long clientId);

    
}
