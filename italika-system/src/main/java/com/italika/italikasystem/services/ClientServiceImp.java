package com.italika.italikasystem.services;

import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.italika.italikasystem.components.ClientConvertDto;
import com.italika.italikasystem.constans.ClientApiParams;
import com.italika.italikasystem.dtos.ClienDto;
import com.italika.italikasystem.models.Client;
import com.italika.italikasystem.repositories.ClientRepository;
import com.italika.italikasystem.utils.responsecustom.MessageCustom;
import com.italika.italikasystem.utils.responsecustom.ResponseEntityCustom;
import com.italika.italikasystem.utils.validations.ClientValidationRequest;

@Service
public class ClientServiceImp implements ClientService{

    private final ClientValidationRequest clientValidationRequest;
    private final ClientRepository clientRepository;
    private final ClientConvertDto clientConvertDto;

    public ClientServiceImp(ClientValidationRequest clientValidationRequest, ClientRepository clientRepository, ClientConvertDto clientConvertDto){
        this.clientValidationRequest = clientValidationRequest;
        this.clientRepository = clientRepository;
        this.clientConvertDto = clientConvertDto;

    }


    @Override
    public ResponseEntity<String> createClient(Map<String, String> mapRequest) {
        // TODO Auto-generated method stub;
        if(mapRequest!=null){
            if(clientValidationRequest.validateParamsToCreate(mapRequest)){
                Client client = getClientFromMap(mapRequest);
                clientRepository.save(client);
                return ResponseEntityCustom.getResponseEntity(MessageCustom.SUCCESSFULL, HttpStatus.CREATED);
            }else{
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<ClienDto> getClientById(Long clientId) {
        // TODO Auto-generated method stub
        if(clientId!=null){
            Optional<Client> clientOptional = clientRepository.findById(clientId);
            return ResponseEntity.ok().body(clientConvertDto.convertEntotyToDto(clientOptional.get()));
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<ClienDto> getClientByEmail(Long clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientByEmail'");
    }

    private Client getClientFromMap(Map<String, String> requestMap){

        if(requestMap!=null){
            if(!clientValidationRequest.validatePhoneNumber(requestMap.get(ClientApiParams.phoneNumberParam)) || !clientValidationRequest.valideEmail(ClientApiParams.emailParam))
                return null;
            else
                return new Client().instance(null, requestMap.get(ClientApiParams.nameParam), requestMap.get(ClientApiParams.lastnameParam), requestMap.get(ClientApiParams.surnameParam), requestMap.get(ClientApiParams.phoneNumberParam), requestMap.get(ClientApiParams.emailParam));
        }else{
            return null;
        }
    }

}
