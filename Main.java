package labSix;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    int choice = 99;

    Scanner keyboard = new Scanner(System.in);
    AddressBook addressBookObj = new AddressBook();

    while (choice != 8) {
      choice = menu();
      switch (choice) {

        case 1: // addContact
          
          addressBookObj.addContact(conObj());
          break;

        case 2: // findContact
        	
          System.out.println("Enter the contact's first name: ");
          String findName = keyboard.nextLine();
          
          int foundIndex = addressBookObj.findContact(findName);
          
          if (foundIndex != -1)
          {
        	 System.out.println("Contact is at index " + foundIndex);
          }
          
          else 
          {
        	  System.out.println("contact not found.");
          }

          break;

        case 3: // edit Contact
        	System.out.println("Enter first name of contact to edit: ");
        	String missingName = keyboard.nextLine();
        	addressBookObj.editContact(missingName);
          break;

        case 4: // delete Contact
        	System.out.println("Enter first name of contact to delete: ");
        	String nameToDelete = keyboard.nextLine();
        	
        	int deletionIndex = addressBookObj.findContact(nameToDelete);
        	
        	Contact conDel = addressBookObj.objFinder(deletionIndex);
        	addressBookObj.deleteContact(conDel);
          break;

        case 5:
        	addressBookObj.getCurrent();
          break;
          
        case 6:
        	addressBookObj.displayEveryone();
          break;
          
        case 7:
        	addressBookObj.makeEmpty();
          break;
          
        case 8:
          System.out.println("!!Thank you and Good Bye!!\n");
      }
    }
  }

  public static int menu() {
    int choice = 99;
    Scanner sc = new Scanner(System.in);

    System.out.println("\nEnter the number for the Operation you wish to perform:");
    System.out.println(
        "1. Add Contact\n" +
            "2. Find Contact\n" +
            "3. Edit Contact\n" +
            "4. Delete Contact\n" +
            "5. Display Current Contact\n" +
            "6. Display All Contacts *** WARNING RESETS CURRENT POSITION ***\n" +
            "7. Delete All Contacts\n" +
            "8. Exit Program\n");

    System.out.print("Enter Choice: ");

    try {
      choice = sc.nextInt();
      while (choice < 1 || choice > 8) {
        System.out.println("Please enter a valid menu choice: ");

        choice = sc.nextInt();
      }
    } catch (java.util.InputMismatchException e) {
      System.out.println("!!Non Integer entered!!");
      sc.next();
      choice = 99;
    }

    System.out.println(); // prints blank line
    return choice;

  }
  
  public static Contact conObj() {
	  Contact con = new Contact();
	  Scanner keyboard = new Scanner(System.in);
	  
	  System.out.println("Enter the contact's first name: ");
      con.firstName = keyboard.nextLine();

      System.out.println("Enter the contact's last name: ");
      con.lastName = keyboard.nextLine();

      System.out.println("Enter the contact's phone number: ");
      con.phoneNumber = keyboard.nextLine();

      System.out.println("Enter the contact's address: ");
      con.address = keyboard.nextLine();
      
      return con;
  }
}
