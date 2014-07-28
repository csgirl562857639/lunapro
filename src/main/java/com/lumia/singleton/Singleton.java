package com.lumia.singleton;

/**
 * 饿汉式单例，在类初始化时，已自行实例化
 * @author heihaier
 *
 */
public class Singleton {
	
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		
		return singleton;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton.getInstance();
	}

}
