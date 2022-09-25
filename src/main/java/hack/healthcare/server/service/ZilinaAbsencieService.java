package hack.healthcare.server.service;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import hack.healthcare.server.model.ZilinaAbsencie;
import hack.healthcare.server.repository.ZilinaAbsencieRepository;

public class ZilinaAbsencieService {

	public void createZilinaAbsencieData() throws NullPointerException {
		List<ZilinaAbsencie> datas = getZilinaAbsencieDataFromCsvFile();
		if (datas == null) {
			throw new NullPointerException();
		}

		ZilinaAbsencieRepository repository = new ZilinaAbsencieRepository();

		datas = repository.saveZilinaAbsencieDatas(datas);

		if (datas == null) {
			throw new NullPointerException();
		}

	}

	private List<ZilinaAbsencie> getZilinaAbsencieDataFromCsvFile() {
		try {
			FileReader filereader = new FileReader("C:\\Users\\marti\\Desktop\\žilina_absence.csv", StandardCharsets.UTF_8);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			List<ZilinaAbsencie> datas = new ArrayList<ZilinaAbsencie>();
			int y = 0;
			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				if (y == 0) {
					y = 1;
					continue;
				}

				ZilinaAbsencie zilinaAbsencie = new ZilinaAbsencie();
				
				zilinaAbsencie.setTitle(nextRecord[0]);
				zilinaAbsencie.setDoctorUrl(nextRecord[1]);
				zilinaAbsencie.setSpecialization(nextRecord[2]);
				zilinaAbsencie.setKraj(nextRecord[3]);
				zilinaAbsencie.setNepritomnost(nextRecord[4]);
				zilinaAbsencie.setDoctorId(nextRecord[5]);
				zilinaAbsencie.setZastupenie(nextRecord[6]);
				datas.add(zilinaAbsencie);
			}
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
