package hack.healthcare.server.pojos;

public class TestResourceResponse {

	private String text;
	private Integer id;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TestResourceResponse(String text, Integer id) {
		super();
		this.text = text;
		this.id = id;
	}

	public TestResourceResponse(String text) {
		super();
		this.text = text;
	}

	public TestResourceResponse() {
		super();
	}

}
