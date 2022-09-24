package hack.healthcare.server.service;

import java.util.ArrayList;
import java.util.List;

import hack.healthcare.server.model.Test;
import hack.healthcare.server.pojos.TestResourceRequest;
import hack.healthcare.server.pojos.TestResourceResponse;
import hack.healthcare.server.repository.TestRepository;

public class TestService {

	public TestResourceResponse createTest(TestResourceRequest request) throws NullPointerException {
		if (request == null || request.getText() == null) {
			throw new NullPointerException();
		}
		TestRepository repository = new TestRepository();

		Test test = new Test(request.getText());

		test = repository.save(test);

		if (test == null) {
			throw new NullPointerException();
		}

		return new TestResourceResponse(test.getText(), test.getId());
	}

	public List<TestResourceResponse> getTests() {
		TestRepository repository = new TestRepository();

		List<Test> tests = repository.getTests();

		if (tests == null) {
			throw new NullPointerException();
		}

		List<TestResourceResponse> responses = new ArrayList<TestResourceResponse>();
		tests.forEach(test -> responses.add(new TestResourceResponse(test.getText(), test.getId())));

		return responses;
	}

	public TestResourceResponse getTestById(Integer id) throws NullPointerException, IllegalArgumentException {
		if (id == null) {
			throw new IllegalArgumentException();
		}

		TestRepository repository = new TestRepository();

		Test test = repository.getTestById(id);

		if (test == null) {
			throw new NullPointerException();
		}

		return new TestResourceResponse(test.getText(), test.getId());
	}

	public TestResourceResponse updateTestById(Integer id, TestResourceRequest request)
			throws IllegalArgumentException, NullPointerException {
		if (id == null || request == null) {
			throw new IllegalArgumentException();
		}

		TestRepository testRepository = new TestRepository();

		Test test = testRepository.getTestById(id);

		if (test == null) {
			throw new NullPointerException();
		}

		test.setText(request.getText());

		test = testRepository.save(test);
		if (test == null) {
			throw new NullPointerException();
		}

		return new TestResourceResponse(test.getText(), test.getId());
	}

	public boolean deleteTestById(Integer id) throws NullPointerException, IllegalArgumentException {
		if (id == null) {
			throw new IllegalArgumentException();
		}

		TestRepository repository = new TestRepository();

		int result = repository.deleteTestById(id);

		if (result < 1) {
			throw new NullPointerException();
		}

		return true;
	}

}
