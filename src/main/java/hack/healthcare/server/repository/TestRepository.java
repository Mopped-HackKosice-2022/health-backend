package hack.healthcare.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hack.healthcare.server.model.Test;
import hack.healthcare.server.utils.HibernateUtil;

public class TestRepository {

	public Test save(Test test) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(test);

			session.flush();
			transaction.commit();
			return test;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<Test> getTests() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			List<Test> tests = session.createQuery("from Test", Test.class).list();

			session.flush();
			transaction.commit();

			return tests;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public Test getTestById(Integer id) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			Test test = session.createQuery("from Test where id = :id", Test.class).setParameter("id", id)
					.getSingleResult();

			session.flush();
			transaction.commit();

			return test;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public int deleteTestById(Integer id) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			int result = session.createQuery("delete from Test where id = :id").setParameter("id", id)
					.executeUpdate();

			session.flush();
			transaction.commit();

			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}

}
