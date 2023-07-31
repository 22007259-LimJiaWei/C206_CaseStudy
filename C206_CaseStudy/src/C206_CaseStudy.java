import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<UserAcct> UserList = new ArrayList<UserAcct>();
		ArrayList<AdministratorAcct> AdminList = new ArrayList<AdministratorAcct>();

		UserList.add(new UserAcct("Alice", 87551131, "The Little Pore of Singapore Cycling Tour", "07", "Alice1124", 1234));
		UserList.add(new UserAcct("Bob", 97891432, "The Little Pore of Singapore Cycling Tour", "07", "Bob1124", 1234));
		UserList.add(new UserAcct("A", 87551131, "The Little Pore of Singapore Cycling Tour", "07", "A1", 1234));
		UserList.add(new UserAcct("B", 97891432, "The Little Pore of Singapore Cycling Tour", "07", "B1", 1234));
		UserList.add(new UserAcct("C", 87551131, "", "", "C1", 1234));
		UserList.add(new UserAcct("D", 97891432, "", "", "D1", 1234));
		AdminList.add(new AdministratorAcct("Ali", 94672354, "1124", 1234));
		AdminList.add(new AdministratorAcct("Cheng", 86544567,  "123e", 4321));

		int option = -1;

		while (option != 3) {

			C206_CaseStudy.AcctTypeMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				UserAcct loginAcct = getUserLoginAcc(UserList);
				if(loginAcct != null) {
					runUserProcess(loginAcct);
				}

			} else if (option == 2) {
				AdministratorAcct loginAcct = getAdminLogicAccount(AdminList);
				if(loginAcct != null) {
					runAdminProcess(UserList);
				}

			} else if (option == 3) {
				System.out.println("Bye!");
			}else {
				System.out.println("Invalid option");
			}

		}

	}

	private static void runUserProcess(UserAcct loginAcct) {
		int Useroption = 0;

		while (Useroption != 3) {
			Usermenu();
			Useroption = Helper.readInt("Enter choice > ");

			if (Useroption == 1) {
				C206_CaseStudy.EventMenu();
				inputDetails(loginAcct);

			} else if (Useroption == 2) {				
				deleteEvent(loginAcct);

			} else if (Useroption == 3) {		
				System.out.println("Logging out.");
			}else {
				System.out.println("Invalid option");
			}
		}

	}

	private static UserAcct getUserLoginAcc(ArrayList<UserAcct> UserList) {
		UserAcct loginAcct = null;
		boolean checkAcc = false;
		String Accnum = Helper.readString("User ID > ");
		int PinNum = Helper.readInt("Password > ");

		for(UserAcct user : UserList) {
			if(user.login(Accnum, PinNum) == true) {
				checkAcc = true;
				loginAcct = user;
				break;
			}
		}
		if(checkAcc == false) {
			System.out.println("Incorrect User ID or Password");
		}
		return loginAcct;


	}

	private static void runAdminProcess(ArrayList<UserAcct> UserList) {
		int Adminoption = 0;

		while (Adminoption != 2) {
			Adminmenu();
			Adminoption = Helper.readInt("Enter choice > ");

			if (Adminoption == 1) {	
				C206_CaseStudy.EventMenu();
				C206_CaseStudy.viewAllEvent(UserList);

			} else if (Adminoption == 2) {				
				System.out.println("Logging out.");
			}else {
				System.out.println("Invalid option");
			}
		}

	}

	private static AdministratorAcct getAdminLogicAccount(ArrayList<AdministratorAcct> adminList) {
		AdministratorAcct loginAcct = null;
		boolean checkAcc= false;
		String Accnum = Helper.readString("Admin ID > ");
		int PinNum = Helper.readInt("Password > ");

		for(AdministratorAcct admin : adminList) {
			if(admin.login(Accnum, PinNum) == true) {
				checkAcc = true;
				loginAcct = admin;
				break;
			}
		}
		if(checkAcc == false) {
			System.out.println("Incorrect Admin ID or Password");
		}


		return loginAcct;
	}


	public static void AcctTypeMenu() {
		C206_CaseStudy.setHeader("SELECT ACCOUNT");
		System.out.println("1. User Account");
		System.out.println("2. Administrator Account");
		System.out.println("3. Quit");
		Helper.line(115, "-");
	}

	public static void Usermenu() {
		C206_CaseStudy.setHeader("BIKERS COMMUNITY PORTAL");
		System.out.println("1. Register Event");
		System.out.println("2. Delete Registration Event");
		System.out.println("3. Quit");
		Helper.line(115, "-");
	}

	public static void EventMenu() {
		C206_CaseStudy.setHeader("EVENT");
		System.out.println("1. The Little Pore of Singapore Cycling Tour");
		System.out.println("2. Cycle To Makan! @ Gardens By The Bay");
		System.out.println("3. National Bikers Weekend 2023");
		Helper.line(115, "-");
	}

	public static void Adminmenu() {
		C206_CaseStudy.setHeader("BIKERS COMMUNITY PORTAL");
		System.out.println("1. View Event List");
		System.out.println("2. Quit");
		Helper.line(115, "-");
	}

	public static void setHeader(String header) {
		Helper.line(115, "-");
		System.out.println(header);
		Helper.line(115, "-");
	}
	
	public static String showAvailability(boolean isAvailableSlot) {
		String avail;
		
		if(isAvailableSlot == true) {
			avail = "Yes";
		}else {
			avail = "No";
		}
		return avail;
	}

	public static int option1 = 4;
	public static int option2 = 0;
	public static int option3 = 0;
	
	//================================= Option 1 View (CRUD - Read) =================================
	public static void viewAllEvent(ArrayList<UserAcct> UserList) {

		String output = "";	
		boolean CheckEvent = false;
		int FindEvent = Helper.readInt("Enter a Event > ");


		for(UserAcct i : UserList) {
			if(FindEvent == 1 && i.getEventName().equalsIgnoreCase("The Little Pore of Singapore Cycling Tour")) {
				CheckEvent = true;
				if(option1 == 5) {	
					i.setAvailableSlot(false);
					output += String.format("%-10s %-20s %-50s %-15s %-20s\n", "BIKER", "CONTACT NUMBER", "EVENT NAME", "DATE", "AVAILABLE SLOT");
					output += String.format("%-10s %-20d %-50s %-15s %-20s\n", i.getName(), i.getContactNum(), i.getEventName(), i.getDate(), C206_CaseStudy.showAvailability(i.getAvailableSlot()));
				}else{
					output += String.format("%-10s %-20s %-50s %-15s %-20s\n", "BIKER", "CONTACT NUMBER", "EVENT NAME", "DATE", "AVAILABLE SLOT");
					output += String.format("%-10s %-20d %-50s %-15s %-20s\n", i.getName(), i.getContactNum(), i.getEventName(), i.getDate(), C206_CaseStudy.showAvailability(i.getAvailableSlot()));	
				}
				
			}else if(FindEvent == 2 && i.getEventName().equalsIgnoreCase("Cycle To Makan! @ Gardens By The Bay")) {
				CheckEvent = true;	
				if(option2 == 5) {
					i.setAvailableSlot(false);
					output += String.format("%-10s %-20s %-50s %-15s %-20s\n", "BIKER", "CONTACT NUMBER", "EVENT NAME", "DATE", "AVAILABLE SLOT");
					output += String.format("%-10s %-20d %-50s %-15s %-20s\n", i.getName(), i.getContactNum(), i.getEventName(), i.getDate(), C206_CaseStudy.showAvailability(i.getAvailableSlot()));	
				}else {
					output += String.format("%-10s %-20s %-50s %-15s %-20s\n", "BIKER", "CONTACT NUMBER", "EVENT NAME", "DATE", "AVAILABLE SLOT");
					output += String.format("%-10s %-20d %-50s %-15s %-20s\n", i.getName(), i.getContactNum(), i.getEventName(), i.getDate(), C206_CaseStudy.showAvailability(i.getAvailableSlot()));	
				}			
			}else if(FindEvent == 3 && i.getEventName().equalsIgnoreCase("National Bikers Weekend 2023")) {
				CheckEvent = true;			
				if(option3 == 5) {
					i.setAvailableSlot(false);
					output += String.format("%-10s %-20s %-50s %-15s %-20s\n", "BIKER", "CONTACT NUMBER", "EVENT NAME", "DATE", "AVAILABLE SLOT");
					output += String.format("%-10s %-20d %-50s %-15s %-20s\n", i.getName(), i.getContactNum(), i.getEventName(), i.getDate(), C206_CaseStudy.showAvailability(i.getAvailableSlot()));
				}else {
					output += String.format("%-10s %-20s %-50s %-15s %-20s\n", "BIKER", "CONTACT NUMBER", "EVENT NAME", "DATE", "AVAILABLE SLOT");
					output += String.format("%-10s %-20d %-50s %-15s %-20s\n", i.getName(), i.getContactNum(), i.getEventName(), i.getDate(), C206_CaseStudy.showAvailability(i.getAvailableSlot()));
				}		
			}
		}
		
		if(CheckEvent == false) {
			System.out.println("No Such Event!");
		}else if(FindEvent == 1 ){
			C206_CaseStudy.setHeader("The Little Pore of Singapore Cycling Tour");
			System.out.println(output);
		}else if(FindEvent == 2) {
			C206_CaseStudy.setHeader("Cycle To Makan! @ Gardens By The Bay");
			System.out.println(output);
		}else if(FindEvent == 2) {
			C206_CaseStudy.setHeader("National Bikers Weekend 2023");
			System.out.println(output);
		}
	}

	

	//================================= Option 2 Add (CRUD - Create)=================================
	public static void inputDetails(UserAcct i) {

		int option = Helper.readInt("Enter option to choose the Event > ");
		String Date = Helper.readString("Enter a date > ");
		boolean Checkoption = false;
		

		if(option == 1) {
			Checkoption = true;
			if(option1 != 5) {
				i.setEventName("The Little Pore of Singapore Cycling Tour");
				i.setDate(Date);
				System.out.println("Register Successful!");
				option1++;
			}else {
				System.out.println("The slot is full!");
			}
			
		}else if(option == 2) {
			Checkoption = true;
			if(option2 != 5) {
				i.setEventName("Cycle To Makan! @ Gardens By The Bay");
				i.setDate(Date);
				option2++;
				System.out.println("Register Successful!");
			}else {
				System.out.println("The slot is full!");
			}
			
		}else if(option == 3) {
			Checkoption = true;
			if(option3 != 5) {
				i.setEventName("National Bikers Weekend 2023");
				i.setDate(Date);
				option3++;
				System.out.println("Register Successful!");
			}else {
				System.out.println("The slot is full!");
			}
						
		}
		

		if(Checkoption == false) {
			System.out.println("Invalid option");
		}
	}

	//================================= Option 3 delete (CRUD - Create)=================================
	public static void deleteEvent(UserAcct i) {

		String output = "";
		output += String.format("%-10s %-20s %-50s %-15s %-20s\n", "BIKER", "CONTACT NUMBER", "EVENT NAME", "DATE", "AVAILABLE SLOT");
		output += String.format("%-10s %-20d %-50s %-15s %-20s\n", i.getName(), i.getContactNum(), i.getEventName(), i.getDate(), C206_CaseStudy.showAvailability(i.getAvailableSlot()));		
		System.out.println(output);

		if(i.getEventName().length() > 0) {
			if(i.getEventName().equalsIgnoreCase("The Little Pore of Singapore Cycling Tour")) {
				char DeleteEvent = Helper.readChar("Do you want to cancel registration? (Y/N) > ");
				if(DeleteEvent == 'Y' || DeleteEvent == 'y') {
					i.setEventName("");
					i.setDate("");
					option1--;
					System.out.println("Cancel Successful!");
				}else {
					System.out.println("Cancel Not Successful!");
				}
			}else if(i.getEventName().equalsIgnoreCase("Cycle To Makan! @ Gardens By The Bay")) {
				char DeleteEvent = Helper.readChar("Do you want to cancel registration? (Y/N) > ");
				if(DeleteEvent == 'Y' || DeleteEvent == 'y') {
					i.setEventName("");
					i.setDate("");
					option2--;
					System.out.println("Cancel Successful!");
				}else {
					System.out.println("Cancel Not Successful!");
				}
			}else if(i.getEventName().equalsIgnoreCase("National Bikers Weekend 2023")) {
				char DeleteEvent = Helper.readChar("Do you want to cancel registration? (Y/N) > ");
				if(DeleteEvent == 'Y' || DeleteEvent == 'y') {
					i.setEventName("");
					i.setDate("");
					option3--;
					System.out.println("Cancel Successful!");
				}else {
					System.out.println("Cancel Not Successful!");
				}
			}
			
		}else if(i.getEventName().length() < 1) {
			System.out.println("You don't register for any event yet!");
		}


	}

}


