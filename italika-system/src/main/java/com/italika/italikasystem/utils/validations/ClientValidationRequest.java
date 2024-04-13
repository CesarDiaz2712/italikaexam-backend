package com.italika.italikasystem.utils.validations;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.italika.italikasystem.constans.ClientApiParams;

@Component
public class ClientValidationRequest {


    public boolean valideEmail (String email) {
		Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
    public boolean validatePhoneNumber(String phoneNumber){

        
        if(phoneNumber.length()==10){
            return true;
        }else
        return false;
    }

    public boolean validateParamsToCreate(Map<String, String> mapRequest){

        
        if(mapRequest.containsKey(ClientApiParams.nameParam) && mapRequest.containsKey(ClientApiParams.lastnameParam) && mapRequest.containsKey(ClientApiParams.surnameParam)
        && mapRequest.containsKey(ClientApiParams.phoneNumberParam) && mapRequest.containsKey(ClientApiParams.emailParam)){
            return true;
        }else
        return false;
    }
}
