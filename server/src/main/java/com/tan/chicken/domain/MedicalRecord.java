package com.tan.chicken.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Builder
public class MedicalRecord {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id //@Setter(AccessLevel.NONE)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date vaccineDate;
	
	private String vaccineType;
	
	public MedicalRecord() {
		super();
	}

	public MedicalRecord(Date vaccineDate, String vaccineType) {
		super();
		this.vaccineDate = vaccineDate;
		this.vaccineType = vaccineType;
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

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vaccineDate == null) ? 0 : vaccineDate.hashCode());
		result = prime * result + ((vaccineType == null) ? 0 : vaccineType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalRecord other = (MedicalRecord) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vaccineDate == null) {
			if (other.vaccineDate != null)
				return false;
		} else if (!vaccineDate.equals(other.vaccineDate))
			return false;
		if (vaccineType == null) {
			if (other.vaccineType != null)
				return false;
		} else if (!vaccineType.equals(other.vaccineType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicalRecord [id=" + id + ", vaccineDate=" + vaccineDate + ", vaccineType=" + vaccineType + "]";
	}
	
}
