package NET.webserviceX.www;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			GlobalWeatherLocator service = new GlobalWeatherLocator();
			URL url = new URL( "http://www.webservicex.net/globalweather.asmx?WSDL" );
			GlobalWeatherSoapStub stub = new GlobalWeatherSoapStub( url, service );
			String a = stub.getCitiesByCountry( "china" );
			System.out.println( a );
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
