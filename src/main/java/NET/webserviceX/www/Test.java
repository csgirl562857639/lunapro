package NET.webserviceX.www;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import org.apache.axis.AxisFault;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			GlobalWeatherLocator service = new GlobalWeatherLocator();
			URL url = new URL( "http://www.webservicex.net/globalweather.asmx?WSDL" );
			GlobalWeatherSoapStub stub = new GlobalWeatherSoapStub( url, service );
			String a = stub.getCitiesByCountry( "china" );
			System.out.println( a );
			
			SAXReader reader = new SAXReader();
			Document document = reader.read( a );
			Element element = document.getRootElement();
			
			List<Attribute> list = element.attributes();
			
			for ( Attribute b : list ) {
				
				System.out.println( b.getText() + "===" + b.getName() + "===" + b.getValue() );
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
