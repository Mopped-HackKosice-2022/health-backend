package hack.healthcare.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "liek", schema = "public")
public class Liek {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;
	@Column(name = "kod", length = 1000)
	private String kod;
	@Column(name = "typ", length = 1000)
	private String type;
	@Column(name = "nazov", length = 1000)
	private String nazov;
	@Column(name = "doplnok", length = 1000)
	private String doplnok;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public String getDoplnok() {
		return doplnok;
	}

	public void setDoplnok(String doplnok) {
		this.doplnok = doplnok;
	}

	public Liek() {
		super();
	}

	public Liek(Integer id, String kod, String type, String nazov, String doplnok) {
		super();
		this.id = id;
		this.kod = kod;
		this.type = type;
		this.nazov = nazov;
		this.doplnok = doplnok;
	}

}
