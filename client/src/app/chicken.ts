export class Chicken{
	name: String;
	gender: String;
	modeOfTransportation: String;
	birthday: Date;
	dateOfExit: Date;
	dateOfEntry: Date;
	weight: number;
	originCountry: String;
	pedigree: String;
	approvedBy: String;
	shipper: String;
	seller: String;
	stopovers: String;
	locationOfEntry: String;

	owner: Owner;
	pastOwners: Owner[];

	medicalRecords: MedicalRecord[];
	feedDetails: FeedDetail[];
	sicknesses: Sickness[];
}

export class Owner{
	name: String;
	ownerType: String;
	chickens: Chicken[];
}

export class FeedDetail{
	name: String;
	feedAmount: number;
	dailyRotation: Date;
}

export class MedicalRecord{
	vaccineDate: Date;
	vaccineType: String;
}

export class Sickness{
	sicknessType: String;
	diagnosisDate: Date;
}
