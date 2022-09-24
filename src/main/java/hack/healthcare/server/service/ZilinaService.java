package hack.healthcare.server.service;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import hack.healthcare.server.model.Aps;
import hack.healthcare.server.model.Lekaren;
import hack.healthcare.server.model.ZilinaData;
import hack.healthcare.server.repository.ZilinaRepository;

public class ZilinaService {

	public void createZilinaData() throws NullPointerException {
		List<ZilinaData> datas = getZilinaDataFromCsvFile();
		if (datas == null) {
			throw new NullPointerException();
		}

		ZilinaRepository repository = new ZilinaRepository();

		datas = repository.saveZilinaDatas(datas);

		if (datas == null) {
			throw new NullPointerException();
		}
	}

	private List<ZilinaData> getZilinaDataFromCsvFile() {
		try {
			FileReader filereader = new FileReader("C:\\Users\\marti\\Desktop\\zilina_data.csv");
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			List<ZilinaData> datas = new ArrayList<>();
			int y = 0;
			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				if (y == 0) {
					y = 1;
					continue;
				}

				ZilinaData zilinaData = new ZilinaData();
				zilinaData.setDoctorId(new String(nextRecord[0].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setInfo(new String(nextRecord[1].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setOpenHours(new String(nextRecord[2].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setLat(new String(nextRecord[3].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setLng(new String(nextRecord[4].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setAdresa(new String(nextRecord[5].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setTitle(new String(nextRecord[6].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setDoctorUrl(new String(nextRecord[7].getBytes(), StandardCharsets.UTF_8));

				zilinaData.setSpecialization(new String(nextRecord[8].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setKraj(new String(nextRecord[9].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setOkres(new String(nextRecord[10].getBytes(), StandardCharsets.UTF_8));
				zilinaData.setPediater(Integer.valueOf(nextRecord[11]));
				zilinaData.setKrajId(Integer.valueOf(nextRecord[12]));
				zilinaData.setOkresId(Integer.valueOf(nextRecord[13]));
				datas.add(zilinaData);
			}
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ZilinaData> getAllZilinaData() throws NullPointerException{
		ZilinaRepository repository = new ZilinaRepository();
		
		List<ZilinaData> data = repository.getAllZilinaData();
		if(data == null) {
			throw new NullPointerException();
		}
		
		return data;
	}

	public void createLekarneData() throws NullPointerException {
		List<Lekaren> datas = getLekarenDataFromCsvFile();
		if (datas == null) {
			throw new NullPointerException();
		}

		ZilinaRepository repository = new ZilinaRepository();

		datas = repository.saveLekarenDatas(datas);

		if (datas == null) {
			throw new NullPointerException();
		}
		
	}

	private List<Lekaren> getLekarenDataFromCsvFile() {
		try {
			FileReader filereader = new FileReader("C:\\Users\\marti\\Desktop\\žilina_lekarne.csv");
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			List<Lekaren> datas = new ArrayList<Lekaren>();
			int y = 0;
			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				if (y == 0) {
					y = 1;
					continue;
				}
				
				Lekaren lekaren = new Lekaren();
				lekaren.setDoctorId(new String(nextRecord[0].getBytes(), StandardCharsets.UTF_8));
				lekaren.setInfo(new String(nextRecord[1].getBytes(), StandardCharsets.UTF_8));
				lekaren.setOpenHours(new String(nextRecord[2].getBytes(), StandardCharsets.UTF_8));
				lekaren.setLat(new String(nextRecord[3].getBytes(), StandardCharsets.UTF_8));
				lekaren.setLng(new String(nextRecord[4].getBytes(), StandardCharsets.UTF_8));
				lekaren.setAdresa(new String(nextRecord[5].getBytes(), StandardCharsets.UTF_8));
				lekaren.setTitle(new String(nextRecord[6].getBytes(), StandardCharsets.UTF_8));
				lekaren.setDoctorUrl(new String(nextRecord[7].getBytes(), StandardCharsets.UTF_8));
				
				lekaren.setKrajId(Integer.valueOf(nextRecord[8]));
				lekaren.setOkres(new String(nextRecord[9].getBytes(), StandardCharsets.UTF_8));
				lekaren.setOkresId(Integer.valueOf(nextRecord[10]));

				
				datas.add(lekaren);

			}
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createApsData() throws NullPointerException {
		List<Aps> datas = getApsDataFromCsvFile();
		if (datas == null) {
			throw new NullPointerException();
		}

		ZilinaRepository repository = new ZilinaRepository();

		datas = repository.saveApsDatas(datas);

		if (datas == null) {
			throw new NullPointerException();
		}
	}

	private List<Aps> getApsDataFromCsvFile() {
		try {
			FileReader filereader = new FileReader("C:\\Users\\marti\\Desktop\\žilina_aps.csv");
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			List<Aps> datas = new ArrayList<Aps>();
			int y = 0;
			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				if (y == 0) {
					y = 1;
					continue;
				}
				
				Aps aps = new Aps();
				
				aps.setDoctorId(new String(nextRecord[0].getBytes(), StandardCharsets.UTF_8));
				aps.setInfo(new String(nextRecord[1].getBytes(), StandardCharsets.UTF_8));
				aps.setOpenHours(new String(nextRecord[2].getBytes(), StandardCharsets.UTF_8));
				aps.setLat(new String(nextRecord[3].getBytes(), StandardCharsets.UTF_8));
				aps.setLng(new String(nextRecord[4].getBytes(), StandardCharsets.UTF_8));
				aps.setAdresa(new String(nextRecord[5].getBytes(), StandardCharsets.UTF_8));
				aps.setTitle(new String(nextRecord[6].getBytes(), StandardCharsets.UTF_8));
				aps.setDoctorUrl(new String(nextRecord[7].getBytes(), StandardCharsets.UTF_8));
				
				aps.setKrajId(Integer.valueOf(nextRecord[8]));
				aps.setOkres(new String(nextRecord[9].getBytes(), StandardCharsets.UTF_8));
				aps.setOkresId(Integer.valueOf(nextRecord[10]));

				
				datas.add(aps);
			}
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
