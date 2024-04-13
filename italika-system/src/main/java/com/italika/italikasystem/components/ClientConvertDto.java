package com.italika.italikasystem.components;

import org.springframework.stereotype.Component;

import com.italika.italikasystem.dtos.ClienDto;
import com.italika.italikasystem.models.Client;

@Component
public class ClientConvertDto {

    public ClienDto convertEntotyToDto(Client client){
        if(client != null){
            return ClienDto.builder().id(client.getId()).name(client.getName()).lastname(client.getLastname())
            .surname(client.getSurname()).phoneNumber(client.getPhoneNumber()).email(client.getEmail()).build();
        }
        return null;
    }
}
