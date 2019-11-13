package phoneBookPackage;

public class Subscriber {

	private String address;
	private String name;
	private String phoneNumber;
	
	public Subscriber() {
		this.address = "";
		this.name = "";
		this.phoneNumber = "";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String toString() {
		return this.name + "\n" + this.address + "\n" + this.phoneNumber + "\n\n";
	}
}
