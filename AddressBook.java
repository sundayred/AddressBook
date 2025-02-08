package labSix;

/*
CS181-9383 – Spring 2024
   Lab 6

   Wooyong Yang

   Date of submission

   Waiting list program. Add, remove, and display people in the waiting list.
*/

import java.util.*;

public class AddressBook 
{
  ArrayList<Contact> PersonContainer = new ArrayList<Contact>();
  public int CurrentPosition = 0;

  // personContainer sorted array list or linked list
  // alphabetize by last name
  // display all contacts might be something you would want do
  
  AddressBook() {
    // constructor
  }

  public void addContact(Contact contact) {
    PersonContainer.add(contact);
    CurrentPosition = PersonContainer.size() - 1;
  }

  public int findContact(String name) {
	// binary search
	  int low = 0;  
	  int high = PersonContainer.size() - 1;  
	  
	  while (low <= high) {
		  
		  int mid = low + (high - low) / 2;
		  
		  if (PersonContainer.get(mid).firstName.equalsIgnoreCase(name))
		  {
			  CurrentPosition = mid;
			  return mid;
		  }
		  
		  if (PersonContainer.get(mid).firstName.compareToIgnoreCase(name) < 0)
		  {
			  low = mid + 1;
		  }
		  
		  else 
		  {
			  high = mid - 1;
		  }
	  }
	 
	  return -1;
  }

  public void editContact(String nameIn) {
	  
	  int editorIndex = findContact(nameIn);
	  CurrentPosition = editorIndex;
	  
	  if (editorIndex != -1)
	  {
		  Scanner keyboard = new Scanner(System.in);
		  Contact temp = new Contact();
		  
		  System.out.println("Enter the contact's NEW first name: ");
		  temp.firstName = keyboard.nextLine();
		  //PersonContainer.get(editorIndex).firstName = keyboard.nextLine();

	      System.out.println("Enter the contact's NEW last name: ");
	      temp.lastName = keyboard.nextLine();

	      System.out.println("Enter the contact's NEW phone number: ");
	      temp.phoneNumber = keyboard.nextLine();

	      System.out.println("Enter the contact's NEW address: ");
	      temp.address = keyboard.nextLine();
	      
		  PersonContainer.set(editorIndex, temp);  
	  }
	  else 
	  {
		  System.out.println("The name you entered does not exist in our phone book system.");
	  }
  }

  public Contact objFinder(int deletionIndexIn)
  {
	 if (deletionIndexIn != -1)
	 {
		return PersonContainer.get(deletionIndexIn);
	 }
	 else
	 {
	 	System.out.println("\nName not found");
	 	return null;
	 }
  }
  
  public void deleteContact(Contact conDelIn) {
    PersonContainer.remove(conDelIn);
    System.out.print("\nContact has been deleted succesfully.");
  }

  public void getCurrent() {
    System.out.println(PersonContainer.get(CurrentPosition).firstName + 
    " at Position " + CurrentPosition);
  }
  
  public void sort(ArrayList<Contact> person) {
	  person.sort((k1, k2)
	  -> k1.getFirstName().compareToIgnoreCase(k2.getFirstName()));
  }
  
  public void displayEveryone() {
	  Scanner keyboard = new Scanner(System.in);
	  System.out.println("Are you sure you want display all contacts?");
	  String usrInput = keyboard.nextLine();
	  
	  if (usrInput.equalsIgnoreCase("YES"));
	  {
		  
	  }
	  sort(PersonContainer);
	  
	  for (int i = 0; i < PersonContainer.size(); i++)
	  {
		  System.out.println(PersonContainer.get(i).firstName);
		  System.out.println(PersonContainer.get(i).lastName);
		  System.out.println(PersonContainer.get(i).phoneNumber);
		  System.out.println(PersonContainer.get(i).address);
	  }
  }

  public void makeEmpty() {
    PersonContainer.clear();
    System.out.println("Contact cleared successfully.");
  }
}