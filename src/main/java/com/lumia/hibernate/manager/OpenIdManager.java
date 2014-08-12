package com.lumia.hibernate.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lumia.hibernate.HibernateUtil;
import com.lumia.hibernate.entrty.OpenId;

public class OpenIdManager {
	
	private static final Logger L = LoggerFactory.getLogger( OpenIdManager.class );

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		OpenId openid = new OpenId();
//		openid.setOpenid( "1234" );
//		save( openid );
		
//		OpenId o = get( "8a8aa08c47b4efa10147b4f2fbb400041" );
//		L.info( o.getOpenid() );
		OpenId o1 = load( "8a8aa08c47b4efa10147b4f2fbb40004" );
		L.info( o1.getOpenid() );
	}

	public static List<OpenId> list() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<OpenId> list = session.createQuery( "FROM OpenId" ).list();
		
		if ( list != null ) {
			L.info( list.size() + "" );
		}
		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	public static void save( OpenId openId ) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save( openId );
		transaction.commit();
		//session.close();
	}
	
	public static OpenId get( String id ) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		return (OpenId) session.get( OpenId.class, id );
	}
	
	public static OpenId load( String id ) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
//		transaction.begin();
		
		OpenId o = (OpenId) session.load( OpenId.class, id );
		transaction.commit();
		
		return o;
	}
}
