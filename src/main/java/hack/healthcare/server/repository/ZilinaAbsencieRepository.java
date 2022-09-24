package hack.healthcare.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hack.healthcare.server.model.ZilinaAbsencie;
import hack.healthcare.server.utils.HibernateUtil;

public class ZilinaAbsencieRepository {

	public List<ZilinaAbsencie> saveZilinaAbsencieDatas(List<ZilinaAbsencie> datas) {

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

}
