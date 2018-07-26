package com.tan.chicken.domain;

import java.math.BigInteger;
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
public class FeedDetail {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id //@Setter(AccessLevel.NONE)
	private Long id;
	
	private String name;
	private Integer feedAmount;
	
	@Temporal(TemporalType.DATE)
	private Date dailyRotation;
	
	public FeedDetail() {
		super();
	}

	public FeedDetail(String name, Integer feedAmount, Date dailyRotation) {
		super();
		this.name = name;
		this.feedAmount = feedAmount;
		this.dailyRotation = dailyRotation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFeedAmount() {
		return feedAmount;
	}

	public void setFeedAmount(Integer feedAmount) {
		this.feedAmount = feedAmount;
	}

	public Date getDailyRotation() {
		return dailyRotation;
	}

	public void setDailyRotation(Date dailyRotation) {
		this.dailyRotation = dailyRotation;
	}
	
}
