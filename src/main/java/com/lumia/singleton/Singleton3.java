package com.lumia.singleton;

public class Singleton3 {

	private static Singleton3 singleton;
	
	private Singleton3() {
		
	}
	
	public static Singleton3 getInstance() {
		
		if ( singleton == null ) {
			
			synchronized ( Singleton3.class ) {
				
				if ( singleton == null ) {
					
					singleton = new Singleton3();
				}
			}
		}
		
		return singleton;
	}
}
