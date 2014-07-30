package com.lumia.property;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemPropertiesManager {
	
	private static final Logger log = LoggerFactory.getLogger( SystemPropertiesManager.class );

	private static SystemPropertiesManager sp = null;
	
	private PropertiesUtils pu;
	
	private SystemPropertiesManager() {
		
	}
	
	public static SystemPropertiesManager getInstance() {
		
		if ( sp == null ) {
			
			synchronized ( SystemPropertiesManager.class ) {
				
				if ( sp == null ) {
					
					sp = new SystemPropertiesManager();
					sp.init();
				}
			}
		}
		
		return sp;
	}

	private void init() {
		// TODO Auto-generated method stub
		pu = new PropertiesUtils( "" );
	}
	
}
