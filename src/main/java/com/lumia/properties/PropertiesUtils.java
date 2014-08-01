package com.lumia.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * properties utils, need slf4j jar, slf4j-simple jar
 * 
 * @author heihaier
 *
 */
public class PropertiesUtils {

	private static final Logger log = LoggerFactory.getLogger( PropertiesUtils.class );
	
	private static final URL path = Thread.currentThread().getContextClassLoader().getResource( "" );
	
	private Properties props;
	
	private String fileName;
	
	// 目标文件必须在class的根目录下
	public PropertiesUtils( String fileName ) {
		this.fileName = fileName;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream( fileName );
			props = new Properties();
			props.load( is );
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info( "can not find the file " + fileName );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info( "read the file " + fileName + "error" );
		}
	}
	
	public String getProperty( String key ) {
		
		return this.props.getProperty( key );
	}
	
	public String getProperty( String key, String defaultValue ) {
		
		return this.props.getProperty( key, defaultValue );
	}
	
	public Map<String, String> getAllProperty() {
		
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<?> names = this.props.propertyNames();
		String key = null;
		String value = null;
		
		while ( names.hasMoreElements() ) {
			
			key = (String) names.nextElement();
			value = this.getProperty( key );
			
			map.put( key, value );
		}
		
		return map;
	}
	
	public void list() {
		this.props.list( System.out );
	}
	
	public static void main(String[] args) {
		PropertiesUtils p = new PropertiesUtils( "D:\\yonyouiccspace\\wx_agent\\WebContent\\WEB-INF\\classes\\Proxool.properties" );
		log.info( p.getProperty( "123", "123" ) );
		p.list();
	}

}
