package com.tan.chicken.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data

public class Chicken {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id //@Setter(AccessLevel.NONE)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private ModeOfTransportation modeOfTransportation;

	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Temporal(TemporalType.DATE)
	private Date dateOfExit;
	@Temporal(TemporalType.DATE)
	private Date dateOfEntry;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<MedicalRecord> medicalRecords = new HashSet<MedicalRecord>();
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<Sickness> sicknesses = new HashSet<Sickness>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<FeedDetail> feedDetails = new HashSet<FeedDetail>();

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<User> pastUsers = new HashSet<User>();
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
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
	
	public Chicken() {
		super();
	}
	
	public Set<User> getPastUsers() {
		return pastUsers;
	}

	public void setPastUsers(Set<User> pastUsers) {
		this.pastUsers = pastUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addFeedDetail(FeedDetail feedDetail) {
		this.feedDetails.add(feedDetail);
	}
	
	public void addMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecords.add(medicalRecord);
	}
	
	public void addSickness(Sickness sickness) {
		this.sicknesses.add(sickness);
	}

	public void changeOwner(User newOwner) {
		this.pastUsers.add(this.user);
		this.user = newOwner;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ModeOfTransportation getModeOfTransportation() {
		return modeOfTransportation;
	}

	public void setModeOfTransportation(ModeOfTransportation modeOfTransportation) {
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

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
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

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Chicken other = (Chicken) obj;
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
		return "Chicken [id=" + id + ", gender=" + gender + ", modeOfTransportation=" + modeOfTransportation
				+ ", birthday=" + birthday + ", dateOfExit=" + dateOfExit + ", dateOfEntry=" + dateOfEntry
				+ ", medicalRecords=" + medicalRecords + ", sicknesses=" + sicknesses + ", feedDetails=" + feedDetails
				+ ", pastUsers=" + pastUsers + ", user=" + user + ", weight=" + weight + ", name=" + name
				+ ", originCountry=" + originCountry + ", pedigree=" + pedigree + ", approvedBy=" + approvedBy
				+ ", shipper=" + shipper + ", seller=" + seller + ", stopovers=" + stopovers + ", locationOfEntry="
				+ locationOfEntry + "]";
	}
	
}
