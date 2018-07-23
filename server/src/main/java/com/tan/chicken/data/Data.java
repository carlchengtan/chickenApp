package com.tan.chicken.data;

import java.math.BigDecimal;
import java.util.Locale;

import javax.annotation.PostConstruct;

//import javax.annotation.PostConstruct;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.domain.FeedDetail;
import com.tan.chicken.domain.Gender;
import com.tan.chicken.domain.MedicalRecord;
import com.tan.chicken.domain.ModeOfTransportation;
import com.tan.chicken.domain.Owner;
import com.tan.chicken.domain.OwnerType;
import com.tan.chicken.domain.Sickness;
import com.tan.chicken.repository.OwnerRepository;

@Component
public class Data {
	
	@Autowired
	private OwnerRepository ownerRepository;	
	
	public void init() {

		Owner owner1 = new Owner("John", OwnerType.OWNER);
		
		FeedDetail feed1 = new FeedDetail("SuperFeed", 2, new LocalDate(2018, 1, 1).toDate());
		MedicalRecord med1 = new MedicalRecord(new LocalDate(2018, 2, 2).toDate(), "VaccineEX");
		Sickness sickness1 = new Sickness("Pneumonia", new LocalDate(2018, 3, 3).toDate());
		
		Locale obj = new Locale("", "US");
		String originCountry = obj.getCountry();
		
		Chicken chicken1 = new Chicken();
				chicken1.setGender(Gender.MALE);
				chicken1.setName("Pedro");
				chicken1.setModeOfTransportation(ModeOfTransportation.AIR);
				chicken1.setBirthday(new LocalDate(2018, 1, 1).toDate());
				chicken1.setDateOfExit(new LocalDate(2018, 1, 2).toDate());
				chicken1.setDateOfEntry(new LocalDate(2018, 1, 3).toDate());
				chicken1.setOwner(owner1);
				chicken1.setWeight(new BigDecimal(10L));
				chicken1.setOriginCountry(originCountry);
				chicken1.setPedigree("Horned Chicken");
				chicken1.setApprovedBy("John");
				chicken1.setShipper("FedEx");
				chicken1.setSeller("Jollibee");
				chicken1.setStopovers("Manila");
				chicken1.setLocationOfEntry("NAIA Gate 1");
		chicken1.addFeedDetail(feed1);
		chicken1.addMedicalRecord(med1);
		chicken1.addSickness(sickness1);

		Sickness sickness2 = new Sickness("Fever", new LocalDate(2018, 3, 3).toDate());
		FeedDetail feed2 = new FeedDetail("MegaFeed", 2, new LocalDate(2018, 1, 1).toDate());
		MedicalRecord med2 = new MedicalRecord(new LocalDate(2018, 2, 2).toDate(), "Morphine");
		
		Locale obj2 = new Locale("", "CA");
		String originCountry2 = obj2.getCountry();

		Chicken chicken2 = new Chicken();
				chicken2.setGender(Gender.FEMALE);
				chicken2.setName("Jane");
				chicken2.setModeOfTransportation(ModeOfTransportation.SEA);
				chicken2.setBirthday(new LocalDate(2018, 4, 5).toDate());
				chicken2.setDateOfExit(new LocalDate(2018, 6, 7).toDate());
				chicken2.setDateOfEntry(new LocalDate(2018, 8, 9).toDate());
				chicken2.setOwner(owner1);
				chicken2.setWeight(new BigDecimal(8L));
				chicken2.setOriginCountry(originCountry2);
				chicken2.setPedigree("Feathered Chicken");
				chicken2.setApprovedBy("Maria");
				chicken2.setShipper("Xend");
				chicken2.setSeller("Mcdo");
				chicken2.setStopovers("California");
				chicken2.setLocationOfEntry("NAIA Gate 2");
		chicken2.addFeedDetail(feed2);
		chicken2.addMedicalRecord(med2);
		chicken2.addSickness(sickness2);
		
		FeedDetail feed3 = new FeedDetail("UltraFeed", 2, new LocalDate(2018, 1, 1).toDate());
		MedicalRecord med3 = new MedicalRecord(new LocalDate(2018, 2, 2).toDate(), "Antivirus");
		Sickness sickness3 = new Sickness("Cough", new LocalDate(2018, 3, 3).toDate());
	
		Locale obj3 = new Locale("", "GB");
		String originCountry3 = obj3.getCountry();

		Chicken chicken3 = new Chicken();
				chicken3.setGender(Gender.MALE);
				chicken3.setName("Juan");
				chicken3.setModeOfTransportation(ModeOfTransportation.AIR);
				chicken3.setBirthday(new LocalDate(2018, 2, 3).toDate());
				chicken3.setDateOfExit(new LocalDate(2018, 4, 5).toDate());
				chicken3.setDateOfEntry(new LocalDate(2018, 6, 7).toDate());
				chicken3.setOwner(owner1);
				chicken3.setWeight(new BigDecimal(6L));
				chicken3.setOriginCountry(originCountry3);
				chicken3.setPedigree("Long-legged Chicken");
				chicken3.setApprovedBy("Alex");
				chicken3.setShipper("UPS");
				chicken3.setSeller("KFC");
				chicken3.setStopovers("India");
				chicken3.setLocationOfEntry("NAIA Gate 5");
		chicken3.addFeedDetail(feed3);
		chicken3.addMedicalRecord(med3);
		chicken3.addSickness(sickness3);
		
		owner1.addChicken(chicken1);
		owner1.addChicken(chicken2);
		owner1.addChicken(chicken3);
		
		ownerRepository.save(owner1);
	}
	
}
