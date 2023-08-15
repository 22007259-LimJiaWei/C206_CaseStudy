import java.util.ArrayList;

public class C206_CaseStudy_Project {

	private static final int OPTION_QUIT = 3;

	public static void main(String[] args) {

		ArrayList<UserAcct> UserList = new ArrayList<UserAcct>();
		ArrayList<AdministratorAcct> AdminList = new ArrayList<AdministratorAcct>();
		ArrayList<String> eventList = new ArrayList<>();
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		ArrayList<Discussion> discussionList = new ArrayList<Discussion>();
		ArrayList<Group> groupList = new ArrayList<Group>();

		UserList.add(new UserAcct("Alice", 87551131, "", "", "1124", 1234));
		UserList.add(new UserAcct("Bob", 97526548, "Cycle To Makan! @ Gardens By The Bay", "08/07/2023", "1124", 1234));
		AdminList.add(new AdministratorAcct("Ali", 94672354, "1124", 1234));
		eventList.add("The Little Pore of Singapore Cycling Tour");
		eventList.add("Cycle To Makan! @ Gardens By The Bay");
		eventList.add("National Bikers Weekend 2023");

		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy_Project.AcctTypeMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				UserAcct loginAcct = getUserLoginAcc(UserList);
				if(loginAcct != null) {
					runUserProcess(loginAcct, eventList, bikeList, discussionList, groupList);
				}

			} else if (option == 2) {
				AdministratorAcct loginAcct = getAdminLogicAccount(AdminList);
				if(loginAcct != null) {
					runAdminProcess(UserList, eventList, bikeList);
				}

			} else if (option == 3) {
				System.out.println("Bye!");
			}else {
				System.out.println("Invalid option");
			}
		}
	}

	private static void runUserProcess(UserAcct loginAcct, ArrayList<String> eventList, ArrayList<Bike> bikeList, ArrayList<Discussion> discussionList, ArrayList<Group> groupList) {
		int Useroption = 0;

		while (Useroption != 11) {
			Usermenu();
			Useroption = Helper.readInt("Enter choice > ");

			if (Useroption == 1) {
				C206_CaseStudy_Project.EventMenu(eventList);
				RegisterEvents(loginAcct, eventList);

			} else if (Useroption == 2) {				
				deleteEvent(loginAcct);

			} else if (Useroption == 3) {		
				Bike b = inputBike();
				C206_CaseStudy_Project.addBike(bikeList, b);
				System.out.println("New bike is added!");

			}else if(Useroption == 4){
				String modelToDelete = Helper.readString("Enter bike model > ");
				C206_CaseStudy_Project.deleteBike(bikeList, modelToDelete);

			}else if(Useroption == 5){
				Discussion d = inputDiscussion();
				C206_CaseStudy_Project.addDiscussion(discussionList, d);

			}else if(Useroption == 6){
				C206_CaseStudy_Project.viewAllDiscussions(discussionList);

			}else if(Useroption == 7){
				String discussionTopic = Helper.readString("Enter Discussion Topic > ");
				C206_CaseStudy_Project.deleteDiscussion(discussionList, discussionTopic);

			}else if(Useroption == 8){
				Group g = inputGroup();
				C206_CaseStudy_Project.addGroup(groupList, g);
				
			}else if(Useroption == 9){
				C206_CaseStudy_Project.viewAllGroups(groupList);
				
			}else if(Useroption == 10){
				String groupName = Helper.readString("Enter Group Name > ");
				C206_CaseStudy_Project.deleteGroup(groupList, groupName);
				
			}else if(Useroption == 11){
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

	private static void runAdminProcess(ArrayList<UserAcct> UserList, ArrayList<String> eventList, ArrayList<Bike> bikeList) {
		int Adminoption = 0;

		while (Adminoption != 6) {
			Adminmenu();
			Adminoption = Helper.readInt("Enter choice > ");

			if (Adminoption == 1) {	
				C206_CaseStudy_Project.EventMenu(eventList);
				C206_CaseStudy_Project.viewAllEvent(UserList, eventList);

			} else if (Adminoption == 2) {		
				UserAcct UA = inputUserAcct();
				C206_CaseStudy_Project.addUserAcct(UserList, UA);
				System.out.println("Added Successful!");

			}else if(Adminoption == 3){
				C206_CaseStudy_Project.viewAllUserList(UserList);

			}else if(Adminoption == 4){		
				String name = Helper.readString("Enter Name > ");
				C206_CaseStudy_Project.checkdeleteUserAcct(UserList, name);

			}else if(Adminoption == 5){
				C206_CaseStudy_Project.viewAllBikesList(bikeList);

			}else if(Adminoption == 6){
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
		C206_CaseStudy_Project.setHeader("SELECT ACCOUNT");
		System.out.println("1. User Account");
		System.out.println("2. Administrator Account");
		System.out.println("3. Quit");
		Helper.line(115, "-");
	}

	public static void Usermenu() {
		showUserMenu();
	}

	public static void showUserMenu() {
		C206_CaseStudy_Project.setHeader("BIKERS COMMUNITY PORTAL");
		System.out.println("1. Register Event");
		System.out.println("2. Cancel Registration Event");
		System.out.println("3. Add Bike");
		System.out.println("4. Delete Bike");
		System.out.println("5. Add a new Discussion");
		System.out.println("6. View all Discussions");
		System.out.println("7. Delete an existing Discussion");
		System.out.println("8. Add a new Group");
		System.out.println("9. View all Groups");
		System.out.println("10. Delete an existing Group");
		System.out.println("11. Quit");
		Helper.line(115, "-");
	}

	public static void EventMenu(ArrayList<String> eventList) {
		C206_CaseStudy_Project.setHeader("EVENT");
		String output = "";
		for (String event : eventList) {
			output += String.format("%s\n", event);
		}
		System.out.println(output);
		Helper.line(115, "-");

	}

	public static void Adminmenu() {
		showAdminMenu();
	}

	public static void showAdminMenu() {
		C206_CaseStudy_Project.setHeader("BIKERS COMMUNITY PORTAL");
		System.out.println("1. View Event List");
		System.out.println("2. Add a new User ");
		System.out.println("3. View all Users");
		System.out.println("4. Delete an exisiting user");
		System.out.println("5. View Bike");
		System.out.println("6. Quit");
		Helper.line(115, "-");
	}

	public static void setHeader(String header) {
		Helper.line(115, "-");
		System.out.println(header);
		Helper.line(115, "-");
	}

	//================================= Option ViewAllUsersRegisterEvent (CRUD - Read) =================================
	public static String retrieveAllEvent(ArrayList<UserAcct> UserList) {
		String output = "";
		for (int i = 0; i < UserList.size(); i++) {

			String name = UserList.get(i).getName();
			int contactNum = UserList.get(i).getContactNum();
			String eventName = UserList.get(i).getEventName();
			String date = UserList.get(i).getDate();
			output += String.format("%-10s %-30s %-10s %-10s\n", name,
					contactNum, eventName, date
					);

		}
		return output;
	}

	public static void viewAllEvent(ArrayList<UserAcct> UserList, ArrayList<String> eventList) {
		String output = "";	
		String FindEvent = Helper.readString("Enter a Event > ");
		C206_CaseStudy_Project.setHeader(FindEvent);
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
		}else {
			System.out.println("Nothing to Delete");
			return;
		}
		return;
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

	//================================= Option addUser (CRUD - Read) =================================
	public static UserAcct inputUserAcct() {
		String name = Helper.readString("Enter Name > ");
		int contactNum = Helper.readInt("Enter Contact Number > ");
		String userID = Helper.readString("Enter UserID > ");
		int userpass = Helper.readInt("Enter UserPass > ");
		return new UserAcct(name, contactNum, "", "", userID, userpass);
	}

	public static void addUserAcct(ArrayList<UserAcct> userAcctList, UserAcct userAcct) {
		for (UserAcct ua : userAcctList) {
			if (ua.getName().equalsIgnoreCase(userAcct.getName())) {
				return;
			}
		}
		if (userAcct.getName().isEmpty() || userAcct.getContactNum() == 0) {
			return;
		}
		userAcctList.add(userAcct);
	}
	//================================= Option viewUser (CRUD - Create)=================================
	public static void viewAllUserList(ArrayList<UserAcct> userAcctList) {
		C206_CaseStudy_Project.setHeader("User LIST");
		String output = String.format("%-10s %-30s %-10s %-10s\n", "Name", "ContactNum", "Event Name", "Date");
		output += retrieveAllUserAcct(userAcctList);
		System.out.println(output);
	}

	public static String retrieveAllUserAcct(ArrayList<UserAcct> userAcctList) {
		String output = "";
		for (UserAcct ua : userAcctList) {
			output += String.format("%-10s %-30s %-10s %-10s\n", ua.getName(), ua.getContactNum(),
					ua.getEventName(), ua.getDate());
		}
		return output;
	}

	//================================= Option deleteUser (CRUD - Create)=================================
	public static void checkdeleteUserAcct(ArrayList<UserAcct> UserList, String name) {  
		String checkname = name.trim();
		boolean CheckUser = false;
		for (int i = 0; i < UserList.size(); i++) {
			if (checkname.equalsIgnoreCase(UserList.get(i).getName())) { 
				CheckUser = true;
				UserList.remove(UserList.get(i));
				System.out.println("User has been deleted");
			}
		}
		if(CheckUser == false) {
			System.out.println("User not found");
			return;
		}
		return;

	}
	public static boolean deleteUserAcct(ArrayList <UserAcct> UserList, String name) {
		//String output = checkdeleteUserAcct(UserList);
		//String checkname = name.trim();
		for (UserAcct user : UserList) {
			if (name.equalsIgnoreCase(user.getName())) {      
				UserList.remove(user);
				System.out.println("User has been deleted");
				return(true);
			}else {
				System.out.println("User no deleted");
				return(false);
			}
		}
		return(false);
	}

	//================================= Option AddBike (CRUD - Create)=================================

	public static Bike inputBike() {
		String model = Helper.readString("Enter bike model > ");
		String brand = Helper.readString("Enter brand > ");
		String type = Helper.readString("Enter type > ");

		Bike b = new Bike(model, brand, type);
		return b;
	}

	public static void addBike(ArrayList<Bike> bikeList, Bike b) {
		for(int i = 0; i < bikeList.size(); i++) {
			if (bikeList.get(i).getModel().equalsIgnoreCase(b.getModel()) )
				return;
		}

		if ((b.getModel().isEmpty()) || (b.getBrand().isEmpty()) || (b.getType().isEmpty())) {
			return;
		}
		bikeList.add(b);
	}



	//================================= Option ViewBike (CRUD - Read) =================================
	public static String retrieveAllBikes(ArrayList<Bike> bikeList) {
		String output = "";
		for (int i = 0; i < bikeList.size(); i++) {
			output += String.format("%-10s %-15s %-10s\n", bikeList.get(i).getModel(),
					bikeList.get(i).getBrand(), bikeList.get(i).getType());
		}
		return output;
	}

	public static void viewAllBikesList(ArrayList<Bike> bikeList) { 
		C206_CaseStudy_Project.setHeader("BikeLIST");
		String output = String.format("%-10s %-15s %-10s\n", "Model", "Brand", "Type");

		output += retrieveAllBikes(bikeList);	
		System.out.println(output);
	}


	//================================= Option DeleteBike (CRUD - Delete)=================================
	public static void deleteBike(ArrayList<Bike> bikeList, String modelToDelete) {
		Bike bikeToRemove = null;
		for (Bike bike : bikeList) {
			if (bike.getModel().equalsIgnoreCase(modelToDelete)) {
				bikeToRemove = bike;
				break;
			}
		}
		if (bikeToRemove != null) {
			bikeList.remove(bikeToRemove);
			System.out.println("Bike with model '" + modelToDelete + "' has been deleted.");
		} else {
			System.out.println("Bike with model '" + modelToDelete + "' not found.");
		}
	}

	//================================= Option AddDiscussion =================================a
	public static Discussion inputDiscussion() {
		String topic = Helper.readString("Enter Discussion Topic > ");
		Discussion d = new Discussion(topic);
		return d;
	}

	public static void addDiscussion(ArrayList<Discussion> discussionList, Discussion d) {
		for (Discussion existingDiscussion : discussionList) {
			if (existingDiscussion.getTopic().equalsIgnoreCase(d.getTopic())) {
				System.out.println("Discussion already exists!");
				return;
			}
		}
		if (d.getTopic().isEmpty()) {
			System.out.println("Discussion topic cannot be empty!");
			return;
		}
		discussionList.add(d);
		System.out.println("New discussion has been added");
	}

	//================================= Option ViewDiscussion =================================
	public static String retrieveAllDiscussions(ArrayList<Discussion> discussionList) {
		String output = "";
		for (Discussion d : discussionList) {
			output += String.format("%-50s\n", d.getTopic());
		}
		return output;
	}

	public static void viewAllDiscussions(ArrayList<Discussion> discussionList) {
		C206_CaseStudy_Project.setHeader("DISCUSSIONS LIST");
		String output = String.format("%-50s\n", "Discussion Topic");
		output += retrieveAllDiscussions(discussionList);
		System.out.println(output);
	}

	//================================= Option DeleteDiscussion =================================
	public static boolean deleteDiscussion(ArrayList<Discussion> discussionList, String topic) {
		for (int i = 0; i < discussionList.size(); i++) {
			if (topic.trim().equalsIgnoreCase(discussionList.get(i).getTopic())) {
				discussionList.remove(i);
				System.out.println("Discussion has been deleted");
				return true;
			}
		}
		System.out.println("Discussion not found!");
		return false;
	}

	//================================= Option AddGroup =================================
	public static Group inputGroup() {
		String groupName = Helper.readString("Enter Group Name > ");
		Group g = new Group(groupName);
		return g;
	}

	public static void addGroup(ArrayList<Group> groupList, Group g) {
		for (Group existingGroup : groupList) {
			if (existingGroup.getName().equalsIgnoreCase(g.getName())) {
				System.out.println("Group already exists!");
				return;
			}
		}
		if (g.getName().isEmpty()) {
			System.out.println("Group name cannot be empty!");
			return;
		}
		groupList.add(g);
		System.out.println("New group has been added");
	}

	//================================= Option ViewGroup =================================
	public static String retrieveAllGroups(ArrayList<Group> groupList) {
		String output = "";
		for (Group g : groupList) {
			output += String.format("%-30s\n", g.getName());
		}
		return output;
	}

	public static void viewAllGroups(ArrayList<Group> groupList) {
		C206_CaseStudy.setHeader("GROUPS LIST");
		String output = String.format("%-30s\n", "Group Name");
		output += retrieveAllGroups(groupList);
		System.out.println(output);
	}

	//================================= Option DeleteGroup =================================
	public static boolean deleteGroup(ArrayList<Group> groupList, String groupName) {
		for (int i = 0; i < groupList.size(); i++) {
			if (groupName.trim().equalsIgnoreCase(groupList.get(i).getName())) {
				groupList.remove(i);
				System.out.println("Group has been deleted");
				return true;
			}
		}
		System.out.println("Group not found!");
		return false;
	}
}


