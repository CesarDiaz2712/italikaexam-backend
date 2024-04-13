package com.italika.italikasystem.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import com.italika.italikasystem.utils.validations.ClientValidationRequest;

public class ClientUnitTest {
    ClientValidationRequest clientValidationRequest;

    private final String emailCorrect = "calejo@gmail.com";
    private final String emailIncorrect = "calejo@gmailcom";
    
    private final String phoneNumberCorrect = "2282137829";
    private final String phoneNumberIncorrect = "228213782";

    private Map<String, String> mapRequestCorrect = null;
    private Map<String, String> mapRequestIncorrect = null;

    @BeforeEach
    public void init(){
        clientValidationRequest = new ClientValidationRequest();
        
        mapRequestCorrect= new HashMap<String,String>();
        mapRequestIncorrect= new HashMap<String,String>();

        mapRequestCorrect.put("name","Cesar");
        mapRequestCorrect.put("lastname","Cesar");
        mapRequestCorrect.put("surname","alejo");
        mapRequestCorrect.put("phoneNumber","diaz");
        mapRequestCorrect.put("email","ca@gmil.com");

        
        mapRequestIncorrect.put("name","Cesar");
        mapRequestIncorrect.put("lastname","Cesar");
        mapRequestIncorrect.put("surname","alejo");
        mapRequestIncorrect.put("phoneNumber","diaz");
    }

    @Test
    public void validationEmailSuccessfull(){
        assertThat(clientValidationRequest.valideEmail(emailCorrect)).isTrue();
    }
    
    @Test
    public void validationEmailIncorrect(){
        assertThat(clientValidationRequest.valideEmail(emailIncorrect)).isFalse();
    }

    @Test
    public void validatePhoneNumberIsCorrect(){
        assertThat(clientValidationRequest.validatePhoneNumber(phoneNumberCorrect)).isTrue();
    }
    
    @Test
    public void validatePhoneNumberIsIncorrect(){
        assertThat(clientValidationRequest.validatePhoneNumber(phoneNumberIncorrect)).isFalse();
    }

    @Test
    public void validateApiRequestParamIsCorrect(){
        assertThat(clientValidationRequest.validateParamsToCreate(mapRequestCorrect)).isTrue();
    }

    @Test
    public void validateApiRequestParamIsIncorrect(){

        assertThat(clientValidationRequest.validateParamsToCreate(mapRequestIncorrect)).isFalse();
    }
}
