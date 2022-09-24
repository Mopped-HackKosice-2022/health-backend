package hack.healthcare.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor", schema = "public")
public class Doctor {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;

	@Column(name = "title", length = 1000)
	private String title;
	@Column(name = "doctorUrl", length = 1000)
	private String doctorUrl;
	@Column(name = "specialization", length = 1000)
	private String specialization;
	@Column(name = "kraj", length = 1000)
	private String kraj;
	@Column(name = "okres", length = 1000)
	private String okres;
	@Column(name = "pediater")
	private Integer pediater;
	@Column(name = "krajId")
	private Integer krajId;
	@Column(name = "okresId")
	private Integer okresId;
	@Column(name = "doctorId", length = 1000)
	private String doctorId;
	@Column(name = "info", length = 1000)
	private String info;
	@Column(name = "openHours", length = 1000)
	private String openHours;
	@Column(name = "lat", length = 1000)
	private String lat;
	@Column(name = "lng", length = 1000)
	private String lng;

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

	public Doctor(String title, String doctorUrl, String specialization, String kraj, String okres, Integer pediater,
			Integer krajId, Integer okresId, String doctorId, String info, String openHours, String lat, String lng) {
		super();
		this.title = title;
		this.doctorUrl = doctorUrl;
		this.specialization = specialization;
		this.kraj = kraj;
		this.okres = okres;
		this.pediater = pediater;
		this.krajId = krajId;
		this.okresId = okresId;
		this.doctorId = doctorId;
		this.info = info;
		this.openHours = openHours;
		this.lat = lat;
		this.lng = lng;
	}

	public Doctor() {
		super();
	}

}
