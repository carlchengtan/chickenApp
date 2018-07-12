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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Chicken {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Sickness> sicknesses = new HashSet<Sickness>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<FeedDetail> feedDetails = new HashSet<FeedDetail>();

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private Owner owner;
	
	private BigDecimal weight;
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
	
	public Chicken(Gender gender, ModeOfTransportation modeOfTransportation, Date birthday, Date dateOfExit,
			Date dateOfEntry, Owner owner, BigDecimal weight, String originCountry, String pedigree, String approvedBy,
			String shipper, String seller, String stopovers, String locationOfEntry) {
		super();
		this.gender = gender;
		this.modeOfTransportation = modeOfTransportation;
		this.birthday = birthday;
		this.dateOfExit = dateOfExit;
		this.dateOfEntry = dateOfEntry;
		this.owner = owner;
		this.weight = weight;
		this.originCountry = originCountry;
		this.pedigree = pedigree;
		this.approvedBy = approvedBy;
		this.shipper = shipper;
		this.seller = seller;
		this.stopovers = stopovers;
		this.locationOfEntry = locationOfEntry;
	}

	public Chicken(Gender gender, ModeOfTransportation modeOfTransportation, Date birthday, Date dateOfExit,
			Date dateOfEntry, Set<MedicalRecord> medicalRecords, Set<Sickness> sicknesses, Set<FeedDetail> feedDetails,
			Owner owner, BigDecimal weight, String originCountry, String pedigree, String approvedBy, String shipper,
			String seller, String stopovers, String locationOfEntry) {
		super();
		this.gender = gender;
		this.modeOfTransportation = modeOfTransportation;
		this.birthday = birthday;
		this.dateOfExit = dateOfExit;
		this.dateOfEntry = dateOfEntry;
		this.medicalRecords = medicalRecords;
		this.sicknesses = sicknesses;
		this.feedDetails = feedDetails;
		this.owner = owner;
		this.weight = weight;
		this.originCountry = originCountry;
		this.pedigree = pedigree;
		this.approvedBy = approvedBy;
		this.shipper = shipper;
		this.seller = seller;
		this.stopovers = stopovers;
		this.locationOfEntry = locationOfEntry;
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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
		Chicken other = (Chicken) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chicken [id=" + id + ", gender=" + gender + ", modeOfTransportation=" + modeOfTransportation
				+ ", birthday=" + birthday + ", dateOfExit=" + dateOfExit + ", dateOfEntry=" + dateOfEntry
				+ ", medicalRecords=" + medicalRecords + ", sicknesses=" + sicknesses + ", feedDetails=" + feedDetails
				+ ", owner=" + owner + ", weight=" + weight + ", originCountry=" + originCountry + ", pedigree="
				+ pedigree + ", approvedBy=" + approvedBy + ", shipper=" + shipper + ", seller=" + seller
				+ ", stopovers=" + stopovers + ", locationOfEntry=" + locationOfEntry + "]";
	}
	
}
