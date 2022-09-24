package hack.healthcare.server.service;

import java.util.ArrayList;
import java.util.List;

import hack.healthcare.server.model.Aps;
import hack.healthcare.server.model.Lekaren;
import hack.healthcare.server.model.ZilinaData;
import hack.healthcare.server.pojos.SearchRequest;
import hack.healthcare.server.pojos.SearchResponse;
import hack.healthcare.server.repository.ZilinaRepository;

public class ApiService {

	public List<SearchResponse> search(SearchRequest request) throws IllegalArgumentException {
		if (request == null || request.getSearch() == null) {
			throw new IllegalArgumentException();
		}

		ZilinaRepository zilinaRepository = new ZilinaRepository();

		List<ZilinaData> zilinaDatas = zilinaRepository.searchZilinaData(request.getSearch());
		List<Lekaren> lekarne = zilinaRepository.searchLekarne(request.getSearch());
		List<Aps> aps = zilinaRepository.searchAps(request.getSearch());

		List<SearchResponse> responses = new ArrayList<SearchResponse>();

		zilinaDatas.forEach(zilinaData -> responses.add(new SearchResponse(zilinaData.getTitle(),
				zilinaData.getAdresa(), zilinaData.getDoctorId(), false, false)));
		lekarne.forEach(lekaren -> responses
				.add(new SearchResponse(lekaren.getTitle(), lekaren.getAdresa(), lekaren.getDoctorId(), false, true)));
		aps.forEach(apsEntity -> responses
				.add(new SearchResponse(apsEntity.getTitle(), apsEntity.getAdresa(), apsEntity.getDoctorId(), true, false)));

		return responses;
	}

}
