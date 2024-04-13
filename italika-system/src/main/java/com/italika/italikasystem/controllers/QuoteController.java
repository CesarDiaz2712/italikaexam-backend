package com.italika.italikasystem.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.italika.italikasystem.services.QuoteService;

import java.text.ParseException;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
        
    }

    @GetMapping("/quote")
    public ResponseEntity<?> get(@RequestParam Map<String, String> requestMap) throws ParseException {
        Preconditions.checkNotNull(requestMap);

        return quoteService.getQuoteOfCar(requestMap);
    }
    
}
