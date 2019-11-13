package testPackage;

import phoneBookPackage.*;

public class MainClass {

	public static void main(String[] args) {
		
		UI frame = new UI();
		PhoneBook phoneBook = new PhoneBook();
		PhoneBookController phoneBookController = new PhoneBookController(phoneBook, frame);
	}
}
