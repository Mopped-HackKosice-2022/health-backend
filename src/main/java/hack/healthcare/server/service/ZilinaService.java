package hack.healthcare.server.service;

import java.io.FileReader;
import java.nio.charset.Charset;
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
			FileReader filereader = new FileReader("C:\\Users\\marti\\Desktop\\zilina_data.csv", StandardCharsets.UTF_8);
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
//				zilinaData.setDoctorId(new String(nextRecord[0].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setInfo(new String(nextRecord[1].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setOpenHours(new String(nextRecord[2].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setLat(new String(nextRecord[3].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setLng(new String(nextRecord[4].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setAdresa(new String(nextRecord[5].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setTitle(new String(nextRecord[6].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setDoctorUrl(new String(nextRecord[7].getBytes(), StandardCharsets.UTF_8));
//
//				zilinaData.setSpecialization(new String(nextRecord[8].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setKraj(new String(nextRecord[9].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setOkres(new String(nextRecord[10].getBytes(), StandardCharsets.UTF_8));
//				zilinaData.setPediater(Integer.valueOf(nextRecord[11]));
//				zilinaData.setKrajId(Integer.valueOf(nextRecord[12]));
//				zilinaData.setOkresId(Integer.valueOf(nextRecord[13]));
				

				zilinaData.setDoctorId(nextRecord[0]);
				zilinaData.setInfo(nextRecord[1]);
				zilinaData.setOpenHours(nextRecord[2]);
				zilinaData.setLat(nextRecord[3]);
				zilinaData.setLng(nextRecord[4]);
				zilinaData.setAdresa(nextRecord[5]);
				zilinaData.setTitle(nextRecord[6]);
				zilinaData.setDoctorUrl(nextRecord[7]);

				zilinaData.setSpecialization(nextRecord[8]);
				zilinaData.setKraj(nextRecord[9]);
				zilinaData.setOkres(nextRecord[10]);
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
			FileReader filereader = new FileReader("C:\\Users\\marti\\Desktop\\žilina_lekarne.csv", StandardCharsets.UTF_8);
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
				lekaren.setDoctorId(nextRecord[0]);
				lekaren.setInfo(nextRecord[1]);
				lekaren.setOpenHours(nextRecord[2]);
				lekaren.setLat(nextRecord[3]);
				lekaren.setLng(nextRecord[4]);
				lekaren.setAdresa(nextRecord[5]);
				lekaren.setTitle(nextRecord[6]);
				lekaren.setDoctorUrl(nextRecord[7]);
				
				lekaren.setKrajId(Integer.valueOf(nextRecord[8]));
				lekaren.setOkres(nextRecord[9]);
				lekaren.setOkresId(Integer.valueOf(nextRecord[10]));
				

//				lekaren.setDoctorId(new String(nextRecord[0].getBytes(), StandardCharsets.UTF_8));
//				lekaren.setInfo(new String(nextRecord[1].getBytes(), StandardCharsets.UTF_8));
//				lekaren.setOpenHours(new String(nextRecord[2].getBytes(), StandardCharsets.UTF_8));
//				lekaren.setLat(new String(nextRecord[3].getBytes(), StandardCharsets.UTF_8));
//				lekaren.setLng(new String(nextRecord[4].getBytes(), StandardCharsets.UTF_8));
//				lekaren.setAdresa(new String(nextRecord[5].getBytes(), StandardCharsets.UTF_8));
//				lekaren.setTitle(new String(nextRecord[6].getBytes(), StandardCharsets.UTF_8));
//				lekaren.setDoctorUrl(new String(nextRecord[7].getBytes(), StandardCharsets.UTF_8));
//				
//				lekaren.setKrajId(Integer.valueOf(nextRecord[8]));
//				lekaren.setOkres(new String(nextRecord[9].getBytes(), StandardCharsets.UTF_8));
//				lekaren.setOkresId(Integer.valueOf(nextRecord[10]));

				
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
			FileReader filereader = new FileReader("C:\\Users\\marti\\Desktop\\zilina_aps.csv", StandardCharsets.UTF_8);
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
				
				aps.setDoctorId(nextRecord[0]);
				aps.setInfo(nextRecord[1]);
				aps.setOpenHours(nextRecord[2]);
				aps.setLat(nextRecord[3]);
				aps.setLng(nextRecord[4]);
				aps.setAdresa(nextRecord[6]);
				aps.setTitle(nextRecord[7]);
				aps.setDoctorUrl(nextRecord[8]);
				
				aps.setKrajId(Integer.valueOf(nextRecord[9]));
				aps.setOkres(nextRecord[10]);
				aps.setOkresId(Integer.valueOf(nextRecord[11]));
				
//				aps.setDoctorId(new String(nextRecord[0].getBytes(), StandardCharsets.UTF_8));
//				aps.setInfo(new String(nextRecord[1].getBytes(), StandardCharsets.UTF_8));
//				String info = new String(aps.getInfo().getBytes(StandardCharsets.UTF_16BE), "CP1250");
//				aps.setOpenHours(new String(nextRecord[2].getBytes(), StandardCharsets.UTF_8));
//				aps.setLat(new String(nextRecord[3].getBytes(), StandardCharsets.UTF_8));
//				aps.setLng(new String(nextRecord[4].getBytes(), StandardCharsets.UTF_8));
//				aps.setAdresa(new String(nextRecord[6].getBytes(), StandardCharsets.UTF_8));
//				aps.setTitle(new String(nextRecord[7].getBytes(), StandardCharsets.UTF_8));
//				aps.setDoctorUrl(new String(nextRecord[8].getBytes(), StandardCharsets.UTF_8));
//				
//				aps.setKrajId(Integer.valueOf(nextRecord[9]));
//				aps.setOkres(new String(nextRecord[10].getBytes(), StandardCharsets.UTF_8));
//				aps.setOkresId(Integer.valueOf(nextRecord[11]));

				
				datas.add(aps);
			}
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
