package com.lumia.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPools {

	private static final Logger log = LoggerFactory.getLogger( ThreadPools.class );
	
	public static ThreadPoolExecutor threadPools = new ThreadPoolExecutor( 100,
			300, 10L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy() );
	
	public static void execute( Runnable command ) {
		
		try {
			threadPools.execute(command);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info( "执行线程失败" );
		}
	}
}
