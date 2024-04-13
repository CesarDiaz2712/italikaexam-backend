package com.italika.italikasystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NamedQuery(name = "FinancialPlan.findAll", query = "SELECT c FROM FinancialPlan c")
@Table(name = "italika_financial_plan")
@NoArgsConstructor
public class FinancialPlan extends AbstractPersistableCustom<Long>{

    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "percentage", nullable = false)
    private Float percentage;

    public FinancialPlan(String name, Float percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    
}
