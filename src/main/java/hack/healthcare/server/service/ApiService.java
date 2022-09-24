package hack.healthcare.server.service;

import java.util.List;

import hack.healthcare.server.pojos.SearchRequest;
import hack.healthcare.server.pojos.SearchResponse;

public class ApiService {

	public List<SearchResponse> search(SearchRequest request) throws IllegalArgumentException{
		if(request == null || request.getSearch() == null) {
			throw new IllegalArgumentException();
		}
		
		
		return null;
	}

	
}
