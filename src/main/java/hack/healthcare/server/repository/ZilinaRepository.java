package hack.healthcare.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hack.healthcare.server.model.Aps;
import hack.healthcare.server.model.Lekaren;
import hack.healthcare.server.model.Liek;
import hack.healthcare.server.model.Test;
import hack.healthcare.server.model.ZilinaAbsencie;
import hack.healthcare.server.model.ZilinaData;
import hack.healthcare.server.utils.HibernateUtil;

public class ZilinaRepository {

	public List<ZilinaData> saveZilinaDatas(List<ZilinaData> datas) {

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			datas.stream().forEach(session::save);

			session.flush();
			transaction.commit();
			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public List<ZilinaData> getAllZilinaData() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<ZilinaData> datas = session.createQuery("from ZilinaData", ZilinaData.class).list();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<Lekaren> saveLekarenDatas(List<Lekaren> datas) {

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			datas.stream().forEach(session::save);

			session.flush();
			transaction.commit();
			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public List<Aps> saveApsDatas(List<Aps> datas) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			datas.stream().forEach(session::save);

			session.flush();
			transaction.commit();
			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public List<Lekaren> getAllLekarne() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<Lekaren> datas = session.createQuery("from Lekaren", Lekaren.class).list();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<Aps> getAllAps() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<Aps> datas = session.createQuery("from Aps", Aps.class).list();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<ZilinaData> searchZilinaData(String search) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<ZilinaData> datas = session
					.createQuery("from ZilinaData where lower(title) like :search or lower(adresa) = :search",
							ZilinaData.class)
					.setParameter("search", '%' + search + '%').list();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<Lekaren> searchLekarne(String search) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<Lekaren> datas = session
					.createQuery("from Lekaren where lower(title) like :search or lower(adresa) = :search",
							Lekaren.class)
					.setParameter("search", '%' + search + '%').list();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<Aps> searchAps(String search) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<Aps> datas = session
					.createQuery("from Aps where lower(title) like :search or lower(adresa) = :search", Aps.class)
					.setParameter("search", '%' + search + '%').list();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<Lekaren> getLekarenByOkres(Integer okresId) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<Lekaren> datas = session.createQuery("from Lekaren where okresId = :okresId", Lekaren.class)
					.setParameter("okresId", okresId).list();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ZilinaData getDoctorDetail(Integer id) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			ZilinaData datas = session.createQuery("from ZilinaData where id = :id", ZilinaData.class)
					.setParameter("id", id).getSingleResult();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ZilinaData getZilinaDataById(Integer id) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			ZilinaData datas = session.createQuery("from ZilinaData where id = :id", ZilinaData.class)
					.setParameter("id", id).getSingleResult();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<ZilinaAbsencie> getAbsencie(String doctorId) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<ZilinaAbsencie> datas = session
					.createQuery("from ZilinaAbsencie where doctorId = :doctorId", ZilinaAbsencie.class)
					.setParameter("doctorId", doctorId).list();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ZilinaData getDoctorByDoctorId(String doctorId) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			ZilinaData datas = session.createQuery("from ZilinaData where doctorId = :doctorId", ZilinaData.class)
					.setParameter("doctorId", doctorId).getSingleResult();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<Liek> saveLieky(List<Liek> datas) {

		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			datas.stream().forEach(session::save);

			session.flush();
			transaction.commit();
			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;

	}

	public List<Liek> getLieky(String key) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<Liek> datas = session
					.createQuery("from Liek where lower(kod) like :key or lower(nazov) = :key", Liek.class)
					.setParameter("key", '%' + key + '%').list();

			session.flush();
			transaction.commit();

			return datas;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
