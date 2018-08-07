package com.tan.chicken.domain;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Chicken implements Serializable{

    private Long id;
    private String gender;
    private String modeOfTransportation;
    private Date birthday;
    private Date dateOfExit;
    private Date dateOfEntry;

    //@Relation(parentColumn = "id", entityColumn = "medicalRecordId", entity = MedicalRecord.class)
    private List<MedicalRecord> medicalRecords;
    //@Relation(parentColumn = "id", entityColumn = "sicknessId", entity = Sickness.class)
    private List<Sickness> sicknesses;
    //@Relation(parentColumn = "id", entityColumn = "feedDetailId", entity = FeedDetail.class)
    private List<FeedDetail> feedDetails;
    //@Relation(parentColumn = "id", entityColumn = "userId", entity = User.class)
    private List<User> users;

    private BigDecimal weight;
    private String name;
    private String originCountry;
    private String pedigree;
    private String approvedBy;
    private String shipper;
    private String seller;
    private String stopovers;
    private String locationOfEntry;
    private String rfid;
    private String lastLocation;

    public Chicken(@NonNull Long id, String gender, String modeOfTransportation, Date birthday, Date dateOfExit, Date dateOfEntry, List<MedicalRecord> medicalRecords, List<Sickness> sicknesses, List<FeedDetail> feedDetails, List<User> users, BigDecimal weight, String name, String originCountry, String pedigree, String approvedBy, String shipper, String seller, String stopovers, String locationOfEntry, String rfid, String lastLocation) {
        this.id = id;
        this.gender = gender;
        this.modeOfTransportation = modeOfTransportation;
        this.birthday = birthday;
        this.dateOfExit = dateOfExit;
        this.dateOfEntry = dateOfEntry;
        this.medicalRecords = medicalRecords;
        this.sicknesses = sicknesses;
        this.feedDetails = feedDetails;
        this.users = users;
        this.weight = weight;
        this.name = name;
        this.originCountry = originCountry;
        this.pedigree = pedigree;
        this.approvedBy = approvedBy;
        this.shipper = shipper;
        this.seller = seller;
        this.stopovers = stopovers;
        this.locationOfEntry = locationOfEntry;
        this.rfid = rfid;
        this.lastLocation = lastLocation;
    }

    public Chicken() {
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
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

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<Sickness> getSicknesses() {
        return sicknesses;
    }

    public void setSicknesses(List<Sickness> sicknesses) {
        this.sicknesses = sicknesses;
    }

    public List<FeedDetail> getFeedDetails() {
        return feedDetails;
    }

    public void setFeedDetails(List<FeedDetail> feedDetails) {
        this.feedDetails = feedDetails;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
    }
}

