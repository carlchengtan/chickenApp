package com.tan.chicken.domain;

import java.util.Date;

public class FeedDetail {

    private Long id;
    private String name;
    private Integer feedAmount;
    private Date dailyRotation;

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
