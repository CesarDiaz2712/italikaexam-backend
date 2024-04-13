package com.italika.italikasystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQuery(name = "Code.findAll", query = "SELECT c FROM Code c")
@Table(name = "italika_code")
public class Code extends AbstractPersistableCustom<Long>{

    @Column(name = "code", nullable = false)
    private String code;

    public Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    
}
