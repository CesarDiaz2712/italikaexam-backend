package com.italika.italikasystem.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

@Entity
@NamedQuery(name = "Motorcicle.findAll", query = "SELECT c FROM Motorcicle c")
@Table(name = "italika_motorcicle")
@NoArgsConstructor
public class Motorcicle extends AbstractPersistableCustom<Long>{

    @Column(name = "serial_number_motor", nullable = false)
    private BigDecimal serialNumberMotot;

    @ManyToOne
    @JoinColumn(name = "model_code_value_id", nullable = false)
    private CodeValue modelCodeValue;
    
    @ManyToOne
    @JoinColumn(name = "color_code_value_id", nullable = true)
    private CodeValue colorCodeValue;
    
    @Column(name = "price_producto", nullable = false)
    private BigDecimal priceProducto;

    @Column(name = "accesories_cost", nullable = false)
    private BigDecimal accesoriesCost;
    
    @Column(name = "insurance_cost", nullable = false)
    private BigDecimal insuranceCost;

    @Column(name = "administration_outlay", nullable = false)
    private BigDecimal administrationOutlay;
    
    @Transient
    private BigDecimal totalCost;

    @Transient
    private BigDecimal priceProductoIva;


    private Motorcicle(BigDecimal serialNumberMotot, CodeValue modelCodeValue, CodeValue colorCodeValue,
            BigDecimal priceProducto, BigDecimal accesoriesCost, BigDecimal insuranceCost, BigDecimal administrationOutlay) {
        this.serialNumberMotot = serialNumberMotot;
        this.modelCodeValue = modelCodeValue;
        this.colorCodeValue = colorCodeValue;
        this.priceProducto = priceProducto;
        this.accesoriesCost = accesoriesCost;
        this.insuranceCost = insuranceCost;
        this.administrationOutlay=administrationOutlay;

        this.priceProductoIva = getPriceProductIVA(priceProducto);
        BigDecimal[] array = {priceProductoIva, accesoriesCost, insuranceCost, administrationOutlay};
        this.totalCost= getFinalCost(array);
    }

    public Motorcicle instance(BigDecimal serialNumberMotot, CodeValue modelCodeValue, CodeValue colorCodeValue,
    BigDecimal priceProducto, BigDecimal accesoriesCost, BigDecimal insuranceCost, BigDecimal administrationOutlay){
        return new Motorcicle(serialNumberMotot, modelCodeValue, colorCodeValue, priceProducto, accesoriesCost, insuranceCost, administrationOutlay);

    }

    private BigDecimal getPriceProductIVA(BigDecimal priceProduct){
        return priceProduct.multiply(new BigDecimal(.16));
    }

    private BigDecimal getFinalCost(BigDecimal[] array){
        BigDecimal result = new BigDecimal(0);
        for (BigDecimal num : array) {
            if(num!=null)
                result.add(num);
            
        }
        return result;
    }

    public BigDecimal getAdministrationOutlay() {
        return administrationOutlay;
    }
    public void setAdministrationOutlay(BigDecimal administrationOutlay) {
        this.administrationOutlay = administrationOutlay;
    }
    public BigDecimal getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
    public BigDecimal getPriceProductoIva() {
        return priceProductoIva;
    }
    public void setPriceProductoIva(BigDecimal priceProductoIva) {
        this.priceProductoIva = priceProductoIva;
    }
    public BigDecimal getSerialNumberMotot() {
        return serialNumberMotot;
    }

    public void setSerialNumberMotot(BigDecimal serialNumberMotot) {
        this.serialNumberMotot = serialNumberMotot;
    }

    public CodeValue getModelCodeValue() {
        return modelCodeValue;
    }

    public void setModelCodeValue(CodeValue modelCodeValue) {
        this.modelCodeValue = modelCodeValue;
    }

    public CodeValue getColorCodeValue() {
        return colorCodeValue;
    }

    public void setColorCodeValue(CodeValue colorCodeValue) {
        this.colorCodeValue = colorCodeValue;
    }

    public BigDecimal getPriceProducto() {
        
        BigDecimal[] array = {priceProducto, accesoriesCost, insuranceCost, administrationOutlay};
        return getFinalCost(array);
    }

    public void setPriceProducto(BigDecimal priceProducto) {
        this.priceProducto = priceProducto;
    }

    public BigDecimal getAccesoriesCost() {
        return accesoriesCost;
    }

    public void setAccesoriesCost(BigDecimal accesoriesCost) {
        this.accesoriesCost = accesoriesCost;
    }

    public BigDecimal getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(BigDecimal insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    
}
