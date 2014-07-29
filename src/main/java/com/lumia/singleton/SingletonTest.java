package com.lumia.singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Runtime.getRuntime() use singleton model
			Process p = Runtime.getRuntime().exec( "C:/windows/system32/ping.exe programcreek.com" );
			BufferedReader br = new BufferedReader( new InputStreamReader( p.getInputStream() ) );
			String line = null;
			
			while ( ( line = br.readLine() ) != null ) {
				System.out.println( line );
			}
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
