package com.lumia.windows;

public class Demo {

	public static void main(String[] args) {

		String path = Demo.class.getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		System.out.println( path );
	}
}
