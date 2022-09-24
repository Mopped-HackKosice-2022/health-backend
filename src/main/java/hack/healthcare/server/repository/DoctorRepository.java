package hack.healthcare.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hack.healthcare.server.model.Doctor;
import hack.healthcare.server.utils.HibernateUtil;

public class DoctorRepository {

	public List<Doctor> saveDoctors(List<Doctor> doctors) {

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			doctors.stream().forEach(session::save);

			session.flush();
			transaction.commit();
			return doctors;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

}
