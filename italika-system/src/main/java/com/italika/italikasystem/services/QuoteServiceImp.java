package com.italika.italikasystem.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.italika.italikasystem.constans.QuoteApiParams;
import com.italika.italikasystem.dtos.ScheduleQuoteDto;
import com.italika.italikasystem.models.FinancialPlan;
import com.italika.italikasystem.models.Motorcicle;
import com.italika.italikasystem.repositories.FinancialPlanRepository;
import com.italika.italikasystem.repositories.MotorcicleRepository;
import com.italika.italikasystem.utils.validations.QuoteValidationRequest;

@Service
public class QuoteServiceImp implements QuoteService{

    private final MotorcicleRepository motorcicleRepository;
    private final QuoteValidationRequest quoteValidationRequest;
    private final FinancialPlanRepository financialPlanRepository;

    public QuoteServiceImp(MotorcicleRepository motorcicleRepository, QuoteValidationRequest quoteValidationRequest, FinancialPlanRepository financialPlanRepository){
        this.motorcicleRepository = motorcicleRepository;
        this.quoteValidationRequest = quoteValidationRequest;
        this.financialPlanRepository = financialPlanRepository;
        
    }

    @Override
    public ResponseEntity<List<ScheduleQuoteDto>> getQuoteOfCar(Map<String, String> reqMap) throws ParseException {
        // TODO Auto-generated method stub;

        if(reqMap != null){
            if(quoteValidationRequest.validateParamsToCreate(reqMap)){

                Long carId = Long.parseLong(reqMap.get(QuoteApiParams.carIdParam));
                Long financialPLanId = Long.parseLong(reqMap.get(QuoteApiParams.financialPlanParam));
                
                Optional<Motorcicle> motorcicleOptional = motorcicleRepository.findById(carId);
                Optional<FinancialPlan> financialPlanOptional = financialPlanRepository.findById(financialPLanId);
                if(motorcicleOptional.isPresent() && financialPlanOptional.isPresent() ){
                    Motorcicle motorcicleFound = motorcicleOptional.get();
                    FinancialPlan financialPlan = financialPlanOptional.get();
                    Motorcicle motorcicle = new Motorcicle().instance(motorcicleFound.getSerialNumberMotot(), motorcicleFound.getModelCodeValue(), motorcicleFound.getColorCodeValue(), motorcicleFound.getPriceProducto(), motorcicleFound.getAccesoriesCost(), motorcicleFound.getInsuranceCost(), motorcicleFound.getAdministrationOutlay());

                    Long initial = Long.parseLong(reqMap.get(QuoteApiParams.initialPaymentParam));
                    BigDecimal initialPayment = BigDecimal.valueOf(initial);
                    BigDecimal finalCostWithoutCredit= motorcicle.getTotalCost();
                    BigDecimal remainingBalanceCar = finalCostWithoutCredit.subtract(initialPayment);

                    List<ScheduleQuoteDto> listSchedule = new ArrayList<>();
                    Integer month=1;
                    while (!remainingBalanceCar.equals(BigDecimal.ZERO)) {
                        Integer months = Integer.parseInt(reqMap.get(QuoteApiParams.monthsParam));
                        BigDecimal repaymentByMonthWithoutIVA = remainingBalanceCar.divide(new BigDecimal(months));
                        BigDecimal interesByMonth = repaymentByMonthWithoutIVA.multiply(new BigDecimal(financialPlan.getPercentage()));
                        BigDecimal totalToPayByMonth = repaymentByMonthWithoutIVA.add(interesByMonth);


                        listSchedule.add(new ScheduleQuoteDto(null, month, interesByMonth, interesByMonth.add(new BigDecimal(.16)), totalToPayByMonth, remainingBalanceCar));

                        remainingBalanceCar= remainingBalanceCar.subtract(totalToPayByMonth);
                        month++;
                    }

                    return ResponseEntity.ok().body(listSchedule);
                }
            }else
             return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();

    }

}
