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
public class Sickness {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id //@Setter(AccessLevel.NONE)
	private Long id;
	
	private String sicknessType;
	
	@Temporal(TemporalType.DATE)
	private Date diagnosisDate;
	
	public Sickness() {
		super();
	}

	public Sickness(String sicknessType, Date diagnosisDate) {
		super();
		this.sicknessType = sicknessType;
		this.diagnosisDate = diagnosisDate;
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

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Sickness other = (Sickness) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sickness [id=" + id + ", sicknessType=" + sicknessType + ", diagnosisDate=" + diagnosisDate + "]";
	}
	
}
