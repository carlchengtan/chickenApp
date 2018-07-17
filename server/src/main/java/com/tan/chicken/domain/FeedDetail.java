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
//@Data 
//@AllArgsConstructor
//@Builder
public class FeedDetail {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id //@Setter(AccessLevel.NONE)
	private Long id;
	
	private String name;
	private int feedAmount;
	
	@Temporal(TemporalType.DATE)
	private Date dailyRotation;

	public FeedDetail() {
		super();
	}

	public FeedDetail(String name, int feedAmount, Date dailyRotation) {
		super();
		this.name = name;
		this.feedAmount = feedAmount;
		this.dailyRotation = dailyRotation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFeedAmount() {
		return feedAmount;
	}

	public void setFeedAmount(int feedAmount) {
		this.feedAmount = feedAmount;
	}

	public Date getDailyRotation() {
		return dailyRotation;
	}

	public void setDailyRotation(Date dailyRotation) {
		this.dailyRotation = dailyRotation;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dailyRotation == null) ? 0 : dailyRotation.hashCode());
		result = prime * result + feedAmount;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		FeedDetail other = (FeedDetail) obj;
		if (dailyRotation == null) {
			if (other.dailyRotation != null)
				return false;
		} else if (!dailyRotation.equals(other.dailyRotation))
			return false;
		if (feedAmount != other.feedAmount)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedDetail [id=" + id + ", name=" + name + ", feedAmount=" + feedAmount + ", dailyRotation="
				+ dailyRotation + "]";
	}
	
}
