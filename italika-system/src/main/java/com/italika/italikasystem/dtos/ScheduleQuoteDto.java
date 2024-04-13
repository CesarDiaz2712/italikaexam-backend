package com.italika.italikasystem.dtos;

import java.math.BigDecimal;

public class ScheduleQuoteDto {

    private Long id;
    private Integer month;
    private BigDecimal interes;
    private BigDecimal interestIVA;
    private BigDecimal repayment;
    private BigDecimal remainingBalance;

    public ScheduleQuoteDto(Long id, Integer month, BigDecimal interes, BigDecimal interestIVA, BigDecimal repayment,
            BigDecimal remainingBalance) {
        this.id = id;
        this.month = month;
        this.interes = interes;
        this.interestIVA = interestIVA;
        this.repayment = repayment;
        this.remainingBalance = remainingBalance;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getMonth() {
        return month;
    }
    public void setMonth(Integer month) {
        this.month = month;
    }
    public BigDecimal getInteres() {
        return interes;
    }
    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }
    public BigDecimal getInterestIVA() {
        return interestIVA;
    }
    public void setInterestIVA(BigDecimal interestIVA) {
        this.interestIVA = interestIVA;
    }
    public BigDecimal getRepayment() {
        return repayment;
    }
    public void setRepayment(BigDecimal repayment) {
        this.repayment = repayment;
    }
    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }
    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    
}
