import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //here hash map is used store string value from address book
        HashMap<String, AddressBook> addressBookList = new HashMap<String, AddressBook>();

        AddressBook familyAddressBook = new AddressBook();
        AddressBook friendsAddressBook = new AddressBook();
        addressBookList.put("Family", familyAddressBook);
        addressBookList.put("Friends", friendsAddressBook);

        while (true) {
            System.out.println("1: to input family \n 2: to input friend \n 3.for terminate the program \n ");
            int selectedOption = scanner.nextInt();
            switch(selectedOption){
    
            	 case 1: familyAddressBook.getUserChoice();
            	 		break;
            	 case 2: friendsAddressBook.getUserChoice();
            	 		break;
            	 case 3: System.exit(0);
            	 		break;
            	 default:System.out.println("Invalid Input");		
        }
        scanner.close();
    }
}
}