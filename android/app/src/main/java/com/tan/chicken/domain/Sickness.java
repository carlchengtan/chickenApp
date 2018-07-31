package com.tan.chicken.domain;

import java.util.Date;

public class Sickness {

    private Long id;
    private String sicknessType;
    private Date diagnosisDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSicknessType() {
        return sicknessType;
    }

    public void setSicknessType(String sicknessType) {
        this.sicknessType = sicknessType;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }
}
