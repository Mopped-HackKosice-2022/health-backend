package hack.healthcare.server.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import hack.healthcare.server.model.Doctor;
import hack.healthcare.server.repository.DoctorRepository;

public class CsvService {

	public List<Doctor> storePediatersToDb() throws NullPointerException {
		List<Doctor> doctors = getDoctorsFromCsvFile();
		if (doctors == null) {
			throw new NullPointerException();
		}
		
		DoctorRepository repository = new DoctorRepository();
		
		doctors = repository.saveDoctors(doctors);
		
		if(doctors == null) {
			throw new NullPointerException();
		}
		
		return doctors;
	}

	private List<Doctor> getDoctorsFromCsvFile() {
		try {
			FileReader filereader = new FileReader("C:\\Users\\marti\\Desktop\\pediater_doctors_final.csv");
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			List<Doctor> doctors = new ArrayList<Doctor>();
			int y = 0;
			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				if (y == 0) {
					y = 1;
					continue;
				}
				Doctor doctor = new Doctor();
				doctor.setTitle(new String(nextRecord[0].getBytes(), StandardCharsets.UTF_8));
				doctor.setDoctorUrl(new String(nextRecord[1].getBytes(), StandardCharsets.UTF_8));
				doctor.setSpecialization(new String(nextRecord[2].getBytes(), StandardCharsets.UTF_8));
				doctor.setKraj(new String(nextRecord[3].getBytes(), StandardCharsets.UTF_8));
				doctor.setOkres(new String(nextRecord[4].getBytes(), StandardCharsets.UTF_8));
				doctor.setPediater(Integer.valueOf(nextRecord[5]));
				doctor.setKrajId(Integer.valueOf(nextRecord[6]));
				doctor.setOkresId(Integer.valueOf(nextRecord[7]));
				doctor.setDoctorId(new String(nextRecord[8].getBytes(), StandardCharsets.UTF_8));
				doctor.setInfo(new String(nextRecord[9].getBytes(), StandardCharsets.UTF_8));
				doctor.setOpenHours(new String(nextRecord[10].getBytes(), StandardCharsets.UTF_8));
				doctor.setLat(new String(nextRecord[11].getBytes(), StandardCharsets.UTF_8));
				doctor.setLng(new String(nextRecord[12].getBytes(), StandardCharsets.UTF_8));
				doctors.add(doctor);
			}
			return doctors;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
