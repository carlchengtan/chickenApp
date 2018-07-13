export class Chicken{
	id: number;
	gender: String;
	modeOfTransportation: String;
	birthday: Date;
	dateOfExit: Date;
	dateOfEntry: Date;
	owner: String;
	weight: number;
	originCountry: String;
	pedigree: String;
	approvedBy: String;
	shipper: String;
	seller: String;
	stopovers: String;
	locationOfEntry: String;

	/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<MedicalRecord> medicalRecords = new HashSet<MedicalRecord>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Sickness> sicknesses = new HashSet<Sickness>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<FeedDetail> feedDetails = new HashSet<FeedDetail>();
	*/
}