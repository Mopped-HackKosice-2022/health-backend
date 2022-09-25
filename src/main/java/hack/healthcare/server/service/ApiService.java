package hack.healthcare.server.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import hack.healthcare.server.model.Aps;
import hack.healthcare.server.model.Lekaren;
import hack.healthcare.server.model.Liek;
import hack.healthcare.server.model.ZilinaAbsencie;
import hack.healthcare.server.model.ZilinaData;
import hack.healthcare.server.pojos.LiekResponse;
import hack.healthcare.server.pojos.SearchRequest;
import hack.healthcare.server.pojos.SearchResponse;
import hack.healthcare.server.pojos.ZilinaAbsencieResponse;
import hack.healthcare.server.pojos.ZilinaDataResponse2;
import hack.healthcare.server.repository.ZilinaRepository;
import hack.healthcare.server.utils.LocationComparator;

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

		for (int i = 0; i < 10; i++) {
			if (i < zilinaDatas.size()) {
				responses.add(new SearchResponse(zilinaDatas.get(i).getTitle(), zilinaDatas.get(i).getAdresa(),
						zilinaDatas.get(i).getDoctorId(), false, false, zilinaDatas.get(i).getId()));
			}
		}
//		for (int i = 0; i < 5; i++) {
//			if (i < lekarne.size()) {
//				responses.add(new SearchResponse(lekarne.get(i).getTitle(), lekarne.get(i).getAdresa(),
//						lekarne.get(i).getDoctorId(), false, true, lekarne.get(i).getId()));
//			}
//		}
//		for (int i = 0; i < 5; i++) {
//			if (i < aps.size()) {
//				responses.add(new SearchResponse(aps.get(i).getTitle(), aps.get(i).getAdresa(),
//						aps.get(i).getDoctorId(), true, false, aps.get(i).getId()));
//			}
//		}

		return responses;
	}

	public List<Aps> getAllAps() {
		ZilinaRepository repository = new ZilinaRepository();

		List<Aps> data = repository.getAllAps();
		
		data.stream().forEach(leakren -> leakren.setInfo(leakren.getInfo().replaceAll("'", "\"")));

		return data;
	}

	public List<Lekaren> getLekarenByOkres(Integer id) {
		ZilinaRepository repository = new ZilinaRepository();
		
		ZilinaData zilinaData = repository.getDoctorDetail(id);
		
		List<Lekaren> lekarens = repository.getLekarenByOkres(zilinaData.getOkresId());
		
		lekarens.stream().forEach(leakren -> leakren.setInfo(leakren.getInfo().replaceAll("'", "\"")));
		
		Collections.sort(lekarens, new LocationComparator(zilinaData));
		
		return lekarens;
	}

	public ZilinaDataResponse2 getDoctorDetail(Integer id) {
		ZilinaRepository repository = new ZilinaRepository();
		
		ZilinaData zilinaData = repository.getDoctorDetail(id);
		
		zilinaData.setInfo(zilinaData.getInfo().replaceAll("'", "\""));
		
		int hours = new Random().nextInt(1 - 0 + 1) + 0;
		int minutes = new Random().nextInt(59 - 0 + 1) + 0;
		
		String dobraCakania = String.format("%s H %s min", hours, minutes);
		
		Integer pocetLudiVCakarni = new Random().nextInt(10 - 1 + 1) + 1;
		ZilinaDataResponse2 response2 = new ZilinaDataResponse2(zilinaData.getId(), zilinaData.getDoctorId(),
				zilinaData.getInfo(), zilinaData.getOpenHours(), zilinaData.getLat(), zilinaData.getLng(),
				zilinaData.getAdresa(), zilinaData.getTitle(), zilinaData.getDoctorUrl(),
				zilinaData.getSpecialization(), zilinaData.getKraj(), zilinaData.getOkres(), zilinaData.getPediater(),
				zilinaData.getKrajId(), zilinaData.getOkresId(), dobraCakania, pocetLudiVCakarni);
		
		return response2;
	}

	public List<ZilinaAbsencieResponse> getAbsencieByDoctorId(Integer id) {
		ZilinaRepository zilinaRepository = new ZilinaRepository();
		
		ZilinaData zilinaData = zilinaRepository.getZilinaDataById(id);
		
		List<ZilinaAbsencie> absencies = zilinaRepository.getAbsencie(zilinaData.getDoctorId());
		
		List<ZilinaAbsencieResponse> responses = new ArrayList<>();
		
		for (ZilinaAbsencie zilinaAbsencie : absencies) {
			ZilinaAbsencieResponse response = new ZilinaAbsencieResponse(zilinaAbsencie.getId(),
					zilinaAbsencie.getTitle(), zilinaAbsencie.getDoctorUrl(), zilinaAbsencie.getSpecialization(),
					zilinaAbsencie.getKraj(), zilinaAbsencie.getNepritomnost(), zilinaAbsencie.getDoctorId(),
					zilinaAbsencie.getZastupenie());
			
			ZilinaData data = zilinaRepository.getDoctorByDoctorId(zilinaAbsencie.getDoctorId());
			
			if(data != null) {
				response.setZilinaDataId(data.getId());
			}
			
			responses.add(response);
		} 
		
		return responses;
	}

	public List<LiekResponse> getLieky(String key) {
		ZilinaRepository repository = new ZilinaRepository();
		
		List<Liek> lieky = repository.getLieky(key);
		
		List<LiekResponse> responses = new ArrayList<>();

		lieky.forEach(like -> responses.add(new LiekResponse(like.getNazov(), like.getKod(), like.getId())));
		
		return responses;
	}

}
