package com.lumia.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static final Logger L = LoggerFactory.getLogger( HibernateUtil.class );

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			/*return new Configuration().configure().buildSessionFactory(
					new StandardServiceRegistryBuilder().build());*/
			
			Configuration cfg = new Configuration();
			cfg.configure();
			ServiceRegistry serviceRegistry= new ServiceRegistryBuilder()
					.applySettings(cfg.getProperties() ).build();
			
			return cfg.buildSessionFactory( serviceRegistry );
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		Session session = getSessionFactory().getCurrentSession();
		L.info( session.toString() );
	}
}
