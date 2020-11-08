import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    public static final List<String> PersonDetails = null;
	HashMap <String, PersonDetails> contactList = new HashMap<String, PersonDetails>();
    Scanner scanner = new Scanner(System.in);
    static AddressBook addressBook = new AddressBook();

    public void getUserChoice() {
        boolean isTerminate = false;
        while (!isTerminate) {
            System.out.println("1: for adding new person \n2: for update person \n3: for print address book \n4: For delete \n5: for number of contact persons\n 6: for Sorting\n 7:For exit");
            int option = scanner.nextInt();
            switch (option)
            {
                case 1:
                    PersonDetails personObject = addressBook.getUserInputInformation();
                    contactList.put(personObject.getEmailId(), personObject);
                    break;
                case 2:
                    addressBook.updateContact();
                    break;
                case 3:System.out.println("Enter choice view :\n1. all address book\n2.by state\n 3.by city ");
                	   int choice = scanner.nextInt();
                	   if(choice == 1) {
                		   for (PersonDetails EveryContacts : contactList.values()) {
                			   System.out.println(EveryContacts);
                		   		}
                      		}
                		if(choice == 2) {
                			ViewPersonByState();
                		}
                		if(choice == 3){
                			ViewPersonByCity();
                		}
                		else 
                			System.out.println("Wrong Input!");
                		
                    break;
                case 4:
                    addressBook.deletePerson();
                    break;
                case 5:System.out.println("Count by\n 1:city\n 2.state");
                	   int countChoice = scanner.nextInt();
                	   if(countChoice == 1) {
                		   CoiuntByCity();
                	   }
                	   if(countChoice == 2) {
                		   CountByState();
                	   }
                	   else
                		   System.out.println("Invalid Input");
                case 6:System.out.println("Enter choice of sorting:\n 1.Name\n 2.City\n 3.State\n 4.Zip");
                		int sortChoice = scanner.nextInt();
                		if(sortChoice == 1) {
                			sortByName();
                		}
                		if(sortChoice == 2) {
                			sortBycity();
                		}
                		if(sortChoice == 3) {
                			sortByState();
                		}
                		if(sortChoice == 4) {
                			sortByZip();
                		}
                		else {
                			System.out.println("Invalid Input");
                		}
                case 7:
                    isTerminate = true;
                    break;
                default:
                    System.out.println("please select valid option");
                    break;
            }
        }
    }
    public void sortByName() {
    	Comparator<PersonDetails> compareByName = Comparator
										.comparing(PersonDetails::getfirstName)
										.thenComparing(PersonDetails::getlastName);
    	List<PersonDetails> ListName = contactList.values()
    									.stream()
    									.sorted(compareByName)
    									.collect(Collectors.toList());
    	System.out.println(ListName);
    }
    public void sortBycity() {
    	Comparator<PersonDetails> compareByCity = Comparator
										.comparing(PersonDetails::getCity);
    	List<PersonDetails> ListCity = contactList.values()
    									.stream()
    									.sorted(compareByCity)
    									.collect(Collectors.toList());
    	System.out.println(ListCity);
    }
    public void sortByState() {
    	Comparator<PersonDetails> compareByState = Comparator
										.comparing(PersonDetails::getState);
    	List<PersonDetails> ListState = contactList.values()
    									.stream()
    									.sorted(compareByState)
    									.collect(Collectors.toList());
    	System.out.println(ListState);
    }
    public void sortByZip() {
    	Comparator<PersonDetails> compareByZip = Comparator
										.comparingInt(PersonDetails::getZip);
    	List<PersonDetails> ListZip = contactList.values()
    									.stream()
    									.sorted(compareByZip)
    									.collect(Collectors.toList());
    	System.out.println(ListZip);
    }
    //count by city
    public void CoiuntByCity() {
    	System.out.println("Enter City Name:");
    	String CityName = scanner.next();
    	Long CountValueCity = contactList.values()
    							.stream()
    							.filter(map -> map.getCity().contains(CityName))
    							.collect(Collectors.counting());

    	System.out.println(CountValueCity);
    	
    }
    //count by state
    public void CountByState() {
    	System.out.println("Enter State Name:");
    	String stateName = scanner.next();
    	Long CountValueState = contactList.values()
    							.stream()
    							.filter(map -> map.getCity().contains(stateName))
    							.collect(Collectors.counting());

    	System.out.println(CountValueState);
    	
    	
    }
    //view person by city
    public void ViewPersonByCity() {
    	System.out.println("Enter City:");
    	String viewPersonCity = scanner.next();
    	Map<String,String> ShowDetails = contactList.values()
    						.stream()
    						.filter(map -> map.getCity().contains(viewPersonCity))
    						.collect(Collectors.toMap(map -> map.getEmailId()+"Name: " , map -> " "+map.getfirstName()+" "+map.getlastName()+", ZipCode : "+map.getZip()+", phoneNumber :" +map.getPhoneNumber() ));
    		System.out.println(ShowDetails);
    }

   //view person by state 	
    public void ViewPersonByState() {
    	System.out.println("Enter State:");
    	String viewPersonCity = scanner.next();
    	Map<String,String> ShowDetails = contactList.values()
    						.stream()
    						.filter(map -> map.getState().contains(viewPersonCity))
    						.collect(Collectors.toMap(map -> map.getEmailId()+"Name: " , map -> " "+map.getfirstName()+" "+map.getlastName()+", ZipCode : "+map.getZip()+", phoneNumber :" +map.getPhoneNumber() ));
    		System.out.println(ShowDetails);
    }

    public void deletePerson() {
        System.out.println("Enter option 1.EmailId\n 2.phonenumber to delete\n");
        int Option = scanner.nextInt();
       switch (Option)
        {
        	case 1:	System.out.println("enter emailID:");
        			String email = scanner.next();
            		if (!contactList.containsKey(email)) {
            				System.out.println("Provided email Id is not found");
            				deletePerson();
                			}
             			contactList.remove(email);
        			break;
        	case 2: System.out.println("enter phoneNumber:");
        			long phone = scanner.nextInt();	
        			if (!contactList.containsKey(phone)) {
        				System.out.println("Provided phone number is not found");
        				deletePerson();
        				}
        				contactList.remove(phone);
        			break;
        	default: System.out.println("Wrong Input");
        }  
    }

    @Override
    public void finalize() throws Throwable {
        scanner.close();
    } 

    public void updateContact() {
        System.out.println("Enter emailId to update");
        String emailId = scanner.next();

        if ( contactList.containsKey(emailId) == false) {
            System.out.println("provided email Id is wrong !");
            updateContact();
        }

        PersonDetails person = contactList.get(emailId);
        System.out.println("1: For first name \n 2: For Last Name \n 3: For Address \n 4: For city \n 5: For state \n 6: For zip \n 7: For phoneNumber");

        int selectedOption = scanner.nextInt();
        switch (selectedOption) {
            case 1:
                System.out.println("Enter First Name ");
                String firstName = scanner.next();
                person.setfirstName(firstName);
                break;
            case 2:
                System.out.println("Enter Last Name");
                String lastName = scanner.next();
                person.setlastName(lastName);
                break;
            case 3:
                System.out.println("Enter Address");
                String address = scanner.next();
                person.setAddress(address);
                break;
            case 4:
                System.out.println("Enter City");
                String city = scanner.next();
                person.setCity(city);
                break;
            case 5:
                System.out.println("Enter State");
                String state = scanner.next();
                person.setState(state);
                break;
            case 6:
                System.out.println("Enter Zip Code");
                int zip=scanner.nextInt();
                person.setZip(zip);
                break;
            case 7:
                System.out.println("Enter Phone Number");
                long phone = scanner.nextLong();
                person.setPhoneNumber(phone);
                break;
            default:
                System.out.println("please select valid option");
                break;
        }
    }

    private PersonDetails getUserInputInformation() {
        System.out.println("Enter First Name");
        String firstName = scanner.next();
        System.out.println("Enter Last Name");
        String lastName = scanner.next();
        System.out.println("Enter Address");
        String address = scanner.next();
        System.out.println("Enter City Name");
        String city = scanner.next();
        System.out.println("Enter the Zip Code");
        int zip = scanner.nextInt();
        System.out.println("Enter State Name");
        String state = scanner.next();
        System.out.println("Enter Phone Number");
        long phone = scanner.nextLong();
        System.out.println("Enter Email Id");
        String emailId = scanner.next();
        PersonDetails person = new PersonDetails();
        person.setfirstName(firstName);
        person.setlastName(lastName);
        person.setAddress(address);
        person.setCity(city);
        person.setZip(zip);
        person.setState(state);
        person.setPhoneNumber(phone);
        person.setEmailId(emailId);

        return person;
    }
}