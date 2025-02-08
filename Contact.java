package labSix;

/*
CS181-9383 – Fall 2019
   Lab 6

   Wooyong Yang

   Date of submission

   Waiting list program. Add, remove, and display people in the waiting list.
*/
public class Contact extends AddressBook {
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String address;

	Contact() {
		firstName = "null";
		lastName = "null";
		phoneNumber = "null";
		address = "null";
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
