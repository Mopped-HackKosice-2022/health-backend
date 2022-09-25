package hack.healthcare.server.pojos;

public class ZilinaDataResponse2 {
	private Integer id;
	private String doctorId;
	private String info;
	private String openHours;
	private String lat;
	private String lng;
	private String adresa;

	private String title;
	private String doctorUrl;
	private String specialization;
	private String kraj;
	private String okres;
	private Integer pediater;
	private Integer krajId;
	private Integer okresId;

	private String dobaCakania;
	private Integer pocetLudiVCakarni;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getOpenHours() {
		return openHours;
	}

	public void setOpenHours(String openHours) {
		this.openHours = openHours;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDoctorUrl() {
		return doctorUrl;
	}

	public void setDoctorUrl(String doctorUrl) {
		this.doctorUrl = doctorUrl;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	public String getOkres() {
		return okres;
	}

	public void setOkres(String okres) {
		this.okres = okres;
	}

	public Integer getPediater() {
		return pediater;
	}

	public void setPediater(Integer pediater) {
		this.pediater = pediater;
	}

	public Integer getKrajId() {
		return krajId;
	}

	public void setKrajId(Integer krajId) {
		this.krajId = krajId;
	}

	public Integer getOkresId() {
		return okresId;
	}

	public void setOkresId(Integer okresId) {
		this.okresId = okresId;
	}

	public String getDobaCakania() {
		return dobaCakania;
	}

	public void setDobaCakania(String dobaCakania) {
		this.dobaCakania = dobaCakania;
	}

	public Integer getPocetLudiVCakarni() {
		return pocetLudiVCakarni;
	}

	public void setPocetLudiVCakarni(Integer pocetLudiVCakarni) {
		this.pocetLudiVCakarni = pocetLudiVCakarni;
	}

	public ZilinaDataResponse2(Integer id, String doctorId, String info, String openHours, String lat, String lng,
			String adresa, String title, String doctorUrl, String specialization, String kraj, String okres,
			Integer pediater, Integer krajId, Integer okresId, String dobaCakania, Integer pocetLudiVCakarni) {
		super();
		this.id = id;
		this.doctorId = doctorId;
		this.info = info;
		this.openHours = openHours;
		this.lat = lat;
		this.lng = lng;
		this.adresa = adresa;
		this.title = title;
		this.doctorUrl = doctorUrl;
		this.specialization = specialization;
		this.kraj = kraj;
		this.okres = okres;
		this.pediater = pediater;
		this.krajId = krajId;
		this.okresId = okresId;
		this.dobaCakania = dobaCakania;
		this.pocetLudiVCakarni = pocetLudiVCakarni;
	}

	public ZilinaDataResponse2() {
		super();
	}

}
