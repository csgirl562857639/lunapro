package com.lumia.singleton;

/**
 * 懒汉式单例，在第一次调用时实例化
 * @author heihaier
 *
 */
public class Singleton1 {
	
	private static Singleton1 singleton = null;
	
	private Singleton1() {
		
	}
	
	static {
		singleton = new Singleton1();
	}
	
	public synchronized static Singleton1 getInstance() {
		
		if ( singleton == null ) {
			singleton = new Singleton1();
		}
		
		return singleton;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
