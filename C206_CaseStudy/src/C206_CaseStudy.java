import java.util.ArrayList;

public class C206_CaseStudy {


	public static void main(String[] args) {

		ArrayList<UserAcct> UserList = new ArrayList<UserAcct>();
		ArrayList<AdministratorAcct> AdminList = new ArrayList<AdministratorAcct>();
		ArrayList<String> eventList = new ArrayList<>();

		UserList.add(new UserAcct("Alice", 87551131, "", "", "1124", 1234));
		UserList.add(new UserAcct("Bob", 97526548, "Cycle To Makan! @ Gardens By The Bay", "08/07/2023", "1124", 1234));
		AdminList.add(new AdministratorAcct("Ali", 94672354, "1124", 1234));
		eventList.add("The Little Pore of Singapore Cycling Tour");
		eventList.add("Cycle To Makan! @ Gardens By The Bay");
		eventList.add("National Bikers Weekend 2023");

		int option = -1;

		while (option != 3) {

			C206_CaseStudy.AcctTypeMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				UserAcct loginAcct = getUserLoginAcc(UserList);
				if(loginAcct != null) {
					runUserProcess(loginAcct, eventList);
				}

			} else if (option == 2) {
				AdministratorAcct loginAcct = getAdminLogicAccount(AdminList);
				if(loginAcct != null) {
					runAdminProcess(UserList, eventList);
				}

			} else if (option == 3) {
				System.out.println("Bye!");
			}else {
				System.out.println("Invalid option");
			}

		}

	}

	private static void runUserProcess(UserAcct loginAcct, ArrayList<String> eventList) {
		int Useroption = 0;

		while (Useroption != 3) {
			Usermenu();
			Useroption = Helper.readInt("Enter choice > ");

			if (Useroption == 1) {
				C206_CaseStudy.EventMenu(eventList);
				RegisterEvents(loginAcct, eventList);

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

	private static void runAdminProcess(ArrayList<UserAcct> UserList, ArrayList<String> eventList) {
		int Adminoption = 0;

		while (Adminoption != 2) {
			Adminmenu();
			Adminoption = Helper.readInt("Enter choice > ");

			if (Adminoption == 1) {	
				C206_CaseStudy.EventMenu(eventList);
				C206_CaseStudy.viewAllEvent(UserList, eventList);

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

	public static void EventMenu(ArrayList<String> eventList) {
		C206_CaseStudy.setHeader("EVENT");
		String output = "";
		for (String event : eventList) {
			output += String.format("%s\n", event);
		}
		System.out.println(output);
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


	public static int option1 = 0;
	public static int option2 = 0;
	public static int option3 = 0;

	//================================= Option ViewAllUsersRegisterEvent (CRUD - Read) =================================
	public static String retrieveAllEvent(ArrayList<UserAcct> UserList) {
		String output = "";
		for (int i = 0; i < UserList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20s\n", UserList.get(i).getName(),
					UserList.get(i).getContactNum(), UserList.get(i).getEventName(), UserList.get(i).getDate(),
					UserList.get(i).getUserID(), UserList.get(i).getUserPass());

		}
		return output;
	}

	public static void viewAllEvent(ArrayList<UserAcct> UserList, ArrayList<String> eventList) {
		String output = "";	
		String FindEvent = Helper.readString("Enter a Event > ");
		C206_CaseStudy.setHeader(FindEvent);
		output += String.format("%-10s %-20s %-50s %-15s\n", "BIKER", "CONTACT NUMBER", "EVENT NAME", "DATE");

		for(UserAcct i : UserList) {
			for(String event : eventList) {
				if(FindEvent.equalsIgnoreCase(event) && i.getEventName().equalsIgnoreCase(FindEvent)) {


					output += String.format("%-10s %-20d %-50s %-15s\n", i.getName(), i.getContactNum(), i.getEventName(), i.getDate());
				}
			}
		}
		System.out.println(output);
	}

	//================================= Option UsersRegisterEvent (CRUD - Create)=================================
	public static void addUser(ArrayList<UserAcct> UserList, UserAcct user) {
		UserAcct Info;
		for(int i = 0; i < UserList.size(); i++) {
			Info = UserList.get(i);
			if (Info.getName().equalsIgnoreCase(user.getName()) )
				return;
		}
		if ((user.getName().isEmpty()) || (user.getContactNum() == 0) || (user.getUserID().isEmpty()) || (user.getUserPass() == 0)) {
			return;

		}
		UserList.add(user);

	}

	public static void RegisterEvents(UserAcct i, ArrayList<String> eventList) {
		String Chooseevent = Helper.readString("Enter the event name > ");
		String Date = Helper.readString("Enter a date > ");
		boolean Checkoption = false;

		if(i.getEventName().equalsIgnoreCase("")) {
			for(String event : eventList) {
				if(Chooseevent.equalsIgnoreCase(event)) {
					Checkoption = true;
					i.setEventName(event);
					i.setDate(Date);
					System.out.println("Register Successful!");
				}
			}
		}
		if(Checkoption == false) {
			System.out.println("No Such Event!");
		}


	}

	//================================= Option UserCancelRegister (CRUD - delete)=================================
	public static void checkDelteEvent(UserAcct user) {
		if (!user.getEventName().equalsIgnoreCase("") && !user.getDate().equalsIgnoreCase("")) {
			user.setEventName("");
			user.setDate("");
			return;
			}else {
				return;
			}
		}
	
		public static void deleteEvent(UserAcct i) {
	
			String output = "";
			output += String.format("%-10s %-20s %-50s %-15s\n", "BIKER", "CONTACT NUMBER", "EVENT NAME", "DATE");
			output += String.format("%-10s %-20d %-50s %-15s\n", i.getName(), i.getContactNum(), i.getEventName(), i.getDate());
			System.out.println(output);

		if(i.getEventName().length() > 0) {
			char DeleteEvent = Helper.readChar("Do you want to cancel registration? (Y/N) > ");
			if(DeleteEvent == 'Y' || DeleteEvent == 'y') {
				i.setEventName("");
				i.setDate("");
				System.out.println("Cancel Successful!");
			}else {
				System.out.println("Cancel Not Successful!");
			}

		}else if(i.getEventName().length() < 1) {
			System.out.println("You don't register for any event yet!");
		}

	}
}


