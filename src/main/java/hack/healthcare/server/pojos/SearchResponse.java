package hack.healthcare.server.pojos;

public class SearchResponse {

	private String name;
	private String address;
	private String pzs;
	private Boolean aps;
	private Boolean pharmacy;
	private Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPzs() {
		return pzs;
	}

	public void setPzs(String pzs) {
		this.pzs = pzs;
	}

	public Boolean getAps() {
		return aps;
	}

	public void setAps(Boolean aps) {
		this.aps = aps;
	}

	public Boolean getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Boolean pharmacy) {
		this.pharmacy = pharmacy;
	}

	public SearchResponse(String name, String address, String pzs, Boolean aps, Boolean pharmacy) {
		super();
		this.name = name;
		this.address = address;
		this.pzs = pzs;
		this.aps = aps;
		this.pharmacy = pharmacy;
	}

	public SearchResponse() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SearchResponse(String name, String address, String pzs, Boolean aps, Boolean pharmacy, Integer id) {
		super();
		this.name = name;
		this.address = address;
		this.pzs = pzs;
		this.aps = aps;
		this.pharmacy = pharmacy;
		this.id = id;
	}

}
