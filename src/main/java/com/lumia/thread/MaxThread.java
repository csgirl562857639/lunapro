package com.lumia.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxThread {
	
	private static final Logger log = LoggerFactory.getLogger( MaxThread.class );
	
	private static Object s = new Object();
	
	private static int i = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for ( ; ; ) {
			new Thread( new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					synchronized ( s ) {
						
						i++;
						log.info( "new Thread nums #" + i );
					}
					
					for ( ; ; ) {
						try {
							Thread.sleep( 1000 );
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			} ).start();
		}
	}

}
