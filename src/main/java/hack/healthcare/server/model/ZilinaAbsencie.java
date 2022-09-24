package hack.healthcare.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zilina_absencie", schema = "public")
public class ZilinaAbsencie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "nepritomnost", length = 1000)
	private String nepritomnost;
	@Column(name = "doctorId", length = 1000)
	private String doctorId;

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

	public ZilinaAbsencie(Integer id, String title, String doctorUrl, String specialization, String kraj,
			String nepritomnost, String doctorId) {
		super();
		this.id = id;
		this.title = title;
		this.doctorUrl = doctorUrl;
		this.specialization = specialization;
		this.kraj = kraj;
		this.nepritomnost = nepritomnost;
		this.doctorId = doctorId;
	}

	public ZilinaAbsencie() {
		super();
	}

}
