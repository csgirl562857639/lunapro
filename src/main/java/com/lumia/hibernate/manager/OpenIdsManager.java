package com.lumia.hibernate.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lumia.hibernate.HibernateUtil;
import com.lumia.hibernate.entrty.OpenIds;

public class OpenIdsManager {
	
	private static final Logger L = LoggerFactory.getLogger( OpenIdsManager.class );

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		list();
	}

	public static List<OpenIds> list() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<OpenIds> list = session.createQuery( "FROM OpenIds " ).list();
		
		if ( list != null ) {
			L.info( list.size() + "" );
		}
		
		transaction.commit();
		
		return list;
	}
}
