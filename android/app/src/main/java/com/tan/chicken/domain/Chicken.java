package com.tan.chicken.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Chicken implements Serializable{
    private Long id;
    private String gender;
    private String modeOfTransportation;
    private Date birthday;
    private Date dateOfExit;
    private Date dateOfEntry;
    private Set<MedicalRecord> medicalRecords = new HashSet<MedicalRecord>();
    private Set<Sickness> sicknesses = new HashSet<Sickness>();
    private Set<FeedDetail> feedDetails = new HashSet<FeedDetail>();
    private Set<User> pastAccountUsers = new HashSet<User>();
    private User user;
    private BigDecimal weight;
    private String name;
    private String originCountry;
    private String pedigree;
    private String approvedBy;
    private String shipper;
    private String seller;
    private String stopovers;
    private String locationOfEntry;

    public Chicken(Long id, String gender, String modeOfTransportation, Date birthday, Date dateOfExit, Date dateOfEntry, Set<MedicalRecord> medicalRecords, Set<Sickness> sicknesses, Set<FeedDetail> feedDetails, Set<User> pastAccountUsers, User user, BigDecimal weight, String name, String originCountry, String pedigree, String approvedBy, String shipper, String seller, String stopovers, String locationOfEntry) {
        this.id = id;
        this.gender = gender;
        this.modeOfTransportation = modeOfTransportation;
        this.birthday = birthday;
        this.dateOfExit = dateOfExit;
        this.dateOfEntry = dateOfEntry;
        this.medicalRecords = medicalRecords;
        this.sicknesses = sicknesses;
        this.feedDetails = feedDetails;
        this.pastAccountUsers = pastAccountUsers;
        this.user = user;
        this.weight = weight;
        this.name = name;
        this.originCountry = originCountry;
        this.pedigree = pedigree;
        this.approvedBy = approvedBy;
        this.shipper = shipper;
        this.seller = seller;
        this.stopovers = stopovers;
        this.locationOfEntry = locationOfEntry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getModeOfTransportation() {
        return modeOfTransportation;
    }

    public void setModeOfTransportation(String modeOfTransportation) {
        this.modeOfTransportation = modeOfTransportation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateOfExit() {
        return dateOfExit;
    }

    public void setDateOfExit(Date dateOfExit) {
        this.dateOfExit = dateOfExit;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public Set<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(Set<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public Set<Sickness> getSicknesses() {
        return sicknesses;
    }

    public void setSicknesses(Set<Sickness> sicknesses) {
        this.sicknesses = sicknesses;
    }

    public Set<FeedDetail> getFeedDetails() {
        return feedDetails;
    }

    public void setFeedDetails(Set<FeedDetail> feedDetails) {
        this.feedDetails = feedDetails;
    }

    public Set<User> getPastAccountUsers() {
        return pastAccountUsers;
    }

    public void setPastAccountUsers(Set<User> pastAccountUsers) {
        this.pastAccountUsers = pastAccountUsers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getStopovers() {
        return stopovers;
    }

    public void setStopovers(String stopovers) {
        this.stopovers = stopovers;
    }

    public String getLocationOfEntry() {
        return locationOfEntry;
    }

    public void setLocationOfEntry(String locationOfEntry) {
        this.locationOfEntry = locationOfEntry;
    }
}
