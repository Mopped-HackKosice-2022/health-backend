package hack.healthcare.server.pojos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class ZilinaAbsencieResponse {
	private Integer id;
	private String title;
	private String doctorUrl;
	private String specialization;
	private String kraj;
	private String nepritomnost;
	private String doctorId;
	private String zastupenie;
	private Integer zilinaDataId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getNepritomnost() {
		return nepritomnost;
	}

	public void setNepritomnost(String nepritomnost) {
		this.nepritomnost = nepritomnost;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getZastupenie() {
		return zastupenie;
	}

	public void setZastupenie(String zastupenie) {
		this.zastupenie = zastupenie;
	}

	public Integer getZilinaDataId() {
		return zilinaDataId;
	}

	public void setZilinaDataId(Integer zilinaDataId) {
		this.zilinaDataId = zilinaDataId;
	}

	public ZilinaAbsencieResponse(Integer id, String title, String doctorUrl, String specialization, String kraj,
			String nepritomnost, String doctorId, String zastupenie) {
		super();
		this.id = id;
		this.title = title;
		this.doctorUrl = doctorUrl;
		this.specialization = specialization;
		this.kraj = kraj;
		this.nepritomnost = nepritomnost;
		this.doctorId = doctorId;
		this.zastupenie = zastupenie;
	}

	public ZilinaAbsencieResponse() {
		super();
	}

}
