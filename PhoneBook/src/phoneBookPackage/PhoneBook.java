package phoneBookPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

// the Model class

public class PhoneBook {

	private List<Subscriber> subscribers;
	
	public PhoneBook() {
		this.subscribers = new ArrayList<Subscriber>();
		readSubscribersFromXML();
	}
	
	private void readSubscribersFromXML() {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	    try {
	        SAXParser saxParser = null;
			try {
				saxParser = saxParserFactory.newSAXParser();
			} catch (ParserConfigurationException e1) {
				e1.printStackTrace();
			} catch (SAXException e1) {
				e1.printStackTrace();
			}
	        SubscriberHandler handler = new SubscriberHandler();
	        try {
				saxParser.parse(new File("src/subscribers.xml"), handler);
			} catch (SAXException e) {
				e.printStackTrace();
			}
	        subscribers = handler.getSubscribersList();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void addSubscriber(Subscriber subscriber) {
		if(subscriber != null) {
			this.subscribers.add(subscriber);
		}
	}
	
	public void showAllSubscribers() {
		for(int i = 0; i < this.subscribers.size(); i++) {
			System.out.println(subscribers.get(i).toString());
		}
	}
	
	public Subscriber getSearchedSubscriber(String name) {
		for(int i = 0; i < subscribers.size(); i++) {
			if((subscribers.get(i).getName()).equals(name)) {
				return subscribers.get(i);
			}
		}
		return null;
	}
	
	public List<Subscriber> getSubscribers() {
		return this.subscribers;
	}
}
