package hack.healthcare.server.pojos;

public class LiekResponse {

	private String name;
	private String code;
	private Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LiekResponse(String name, String code, Integer id) {
		super();
		this.name = name;
		this.code = code;
		this.id = id;
	}

	public LiekResponse() {
		super();
	}

}
