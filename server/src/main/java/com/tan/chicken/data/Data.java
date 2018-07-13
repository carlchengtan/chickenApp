package com.tan.chicken.data;

import java.math.BigDecimal;
import java.util.Locale;

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
	
	//@PostConstruct
	public void init() {

		Owner owner1 = new Owner(OwnerType.OWNER);
		
		FeedDetail feed1 = new FeedDetail("SuperFeed", 2, new LocalDate(2018, 1, 1).toDate());
		MedicalRecord med1 = new MedicalRecord(new LocalDate(2018, 2, 2).toDate(), "VaccineEX");
		Sickness sickness1 = new Sickness("Pneumonia", new LocalDate(2018, 3, 3).toDate());
		
		Locale obj = new Locale("", "US");
		String originCountry = obj.getCountry();
		
		Chicken chicken1 = new Chicken();
				chicken1.setGender(Gender.MALE);
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
		
		owner1.addChicken(chicken1);
		
		ownerRepository.save(owner1);
	}
	
}
