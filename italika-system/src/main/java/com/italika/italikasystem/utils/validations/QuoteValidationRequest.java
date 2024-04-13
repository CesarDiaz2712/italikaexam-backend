package com.italika.italikasystem.utils.validations;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.italika.italikasystem.constans.QuoteApiParams;

@Component
public class QuoteValidationRequest {

    
    public boolean validateParamsToCreate(Map<String, String> mapRequest){

        if(mapRequest.containsKey(QuoteApiParams.carIdParam) && mapRequest.containsKey(QuoteApiParams.financialPlanParam)){
            return true;
        }else
        return false;
    }
}
