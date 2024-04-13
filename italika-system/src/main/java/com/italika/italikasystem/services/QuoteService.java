package com.italika.italikasystem.services;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.italika.italikasystem.dtos.ScheduleQuoteDto;

public interface QuoteService {

    ResponseEntity<List<ScheduleQuoteDto>> getQuoteOfCar(Map<String, String> reqMap) throws ParseException;
}
