package com.tan.chicken.domain;

import java.io.Serializable;
import java.util.Date;

public class MedicalRecord implements Serializable {

    private Long id;
    private Date vaccineDate;
    private String vaccineType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(Date vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }
}
