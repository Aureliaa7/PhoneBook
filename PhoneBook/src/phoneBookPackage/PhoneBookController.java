package phoneBookPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

// the Controller class

public class PhoneBookController {

	private PhoneBook phoneBook;
	private UI ui;
	final static String newline = "\n";
	
	public PhoneBookController(PhoneBook phoneBook, UI ui) {
		this.phoneBook = phoneBook;
		this.ui = ui;
		this.ui.addListeners(new MyActionListener());
	}
	
	
	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == ui.add) {
				String subscriberName, address, phoneNumber;
				ui.clearTextArea();
				try {
					subscriberName = ui.getNameField();
					address = ui.getAddressField();
					phoneNumber = ui.getPhoneNumberField();
					Subscriber subscriber = new Subscriber();
					subscriber.setName(subscriberName);
					subscriber.setAddress(address);
					subscriber.setPhoneNumber(phoneNumber);
					phoneBook.addSubscriber(subscriber);
				} catch(NumberFormatException e) {
					ui.displayErrorMessage("Invalid input!");
				}
				ui.nameField.setText(null);
				ui.addressField.setText(null);
				ui.numberField.setText(null);
			} else if(event.getSource() == ui.search) {
				String name;
				List<Subscriber> subscribers = new ArrayList<Subscriber>();
				subscribers = phoneBook.getSubscribers();
				ui.clearTextArea();
				try {
					name = ui.getSearchedName();
					if(name != null) {
						ui.textArea.append("Search results: " + newline);
						for(int i = 0; i < subscribers.size(); i++) {
							if((subscribers.get(i).getName()).equals(name)) {
								ui.textArea.append(subscribers.get(i).toString());
							}
						}
						ui.searchSubscriber.setText(null);
					} else if(name == null){
						ui.textArea.append("No result");
					}
					
				} catch(InputMismatchException e1) {
					ui.displayErrorMessage("Invalid input!");
				}
			} else if(event.getSource() == ui.showSubscribers) {
				ui.clearTextArea();
				List<Subscriber> subscribers = new ArrayList<Subscriber>();
				subscribers = phoneBook.getSubscribers();
				ui.textArea.append("The existing subscribers: " + newline + newline);
				for(Subscriber subscriber : subscribers) {
					ui.textArea.append(subscriber.toString());
				}
			} else if(event.getSource() == ui.exit) {
				ui.dispose();
			}	
		}
	}
}
