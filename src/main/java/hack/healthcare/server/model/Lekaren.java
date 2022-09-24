package hack.healthcare.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lekaren", schema = "public")
public class Lekaren {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;
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
	@Column(name = "adresa", length = 1000)
	private String adresa;

	@Column(name = "title", length = 1000)
	private String title;
	@Column(name = "doctorUrl", length = 1000)
	private String doctorUrl;
	@Column(name = "krajId")
	private Integer krajId;
	@Column(name = "okres", length = 1000)
	private String okres;
	@Column(name = "okresId")
	private Integer okresId;

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

	public Integer getKrajId() {
		return krajId;
	}

	public void setKrajId(Integer krajId) {
		this.krajId = krajId;
	}

	public String getOkres() {
		return okres;
	}

	public void setOkres(String okres) {
		this.okres = okres;
	}

	public Integer getOkresId() {
		return okresId;
	}

	public void setOkresId(Integer okresId) {
		this.okresId = okresId;
	}

	public Lekaren(Integer id, String doctorId, String info, String openHours, String lat, String lng, String adresa,
			String title, String doctorUrl, Integer krajId, String okres, Integer okresId) {
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
		this.krajId = krajId;
		this.okres = okres;
		this.okresId = okresId;
	}

	public Lekaren() {
		super();
	}

}
