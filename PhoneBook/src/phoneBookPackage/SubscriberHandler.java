package phoneBookPackage;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SubscriberHandler extends DefaultHandler {

	private List<Subscriber> subscribers = null;
	private Subscriber subscriber = null;
	private StringBuilder data = null;

	public List<Subscriber> getSubscribersList() {
		return subscribers;
	}
	boolean bSubscriberName = false;
	boolean bAddress = false;
	boolean bPhoneNumber = false;
			
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("subscriber")) {
			subscriber = new Subscriber();
			// initialize list
			if(subscribers == null)
				subscribers = new ArrayList<>();
		} else if(qName.equalsIgnoreCase("name")) {
			bSubscriberName = true;
		} else if(qName.equalsIgnoreCase("address")) {
			bAddress = true;
		} else if(qName.equalsIgnoreCase("phonenumber")) {
			bPhoneNumber = true;
		}
		// create the data container
		data = new StringBuilder();
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(bSubscriberName) {
			subscriber.setName(data.toString());
			bSubscriberName = false;
		} else if(bAddress) {
			subscriber.setAddress(data.toString());
			bAddress = false;
		} else if(bPhoneNumber) {
			subscriber.setPhoneNumber(data.toString());
			bPhoneNumber = false;
		} 
				
		if (qName.equalsIgnoreCase("subscriber")) {
			// add Subscriber object to list
			subscribers.add(subscriber);
		}
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}
