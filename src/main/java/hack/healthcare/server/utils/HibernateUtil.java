package hack.healthcare.server.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private HibernateUtil() {
	}

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		
//		configuration.setProperty(PropertiesManager.PropertyKey.HIBERNATE_CONNECTION_DRIVER_CLASS.getKeyVal(), PropertiesManager.getInstance().getHibernateConnectionDriverClass());
//		configuration.setProperty(PropertiesManager.PropertyKey.HIBERNATE_CONNECTION_PASSWORD.getKeyVal(), PropertiesManager.getInstance().getHibernateConnectionPassword());
//		configuration.setProperty(PropertiesManager.PropertyKey.HIBERNATE_CONNECTION_URL.getKeyVal(), PropertiesManager.getInstance().getHibernateConnectionUrl());
//		configuration.setProperty(PropertiesManager.PropertyKey.HIBERNATE_CONNECTION_USERNAME.getKeyVal(), PropertiesManager.getInstance().getHibernateConnectionUsername());

		return configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}
