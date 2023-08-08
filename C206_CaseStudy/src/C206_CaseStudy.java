import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<UserAcct> UserList = new ArrayList<UserAcct>();


		UserList.add(new UserAcct("Alice", 87551131, "alice123"));
		UserList.add(new UserAcct("Bob", 97891432, "bob456"));

		int option = -1;

		while (option != 5) {

			C206_CaseStudy.Adminmenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.EventMenu();

			} else if (option == 2) {
				UserAcct UA = inputUserAcct();
				C206_CaseStudy.addUserAcct(UserList, UA);

			} else if (option == 3) {
				C206_CaseStudy.viewAllUserList(UserList);

			}else if(option == 4){
				String name = Helper.readString("Enter Name > "); 
				C206_CaseStudy.deleteUserAcct(UserList,name);

			}else if(option == 5){
				System.out.println("Bye!");
			}else {
				System.out.println("Invalid option");
			}

		}

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
		System.out.println("2. Add a new User ");
		System.out.println("3. View all Users");
		System.out.println("4. Delete an exisiting user");
		System.out.println("5. Quit");
		Helper.line(115, "-");
	}

	public static void setHeader(String header) {
		Helper.line(115, "-");
		System.out.println(header);
		Helper.line(115, "-");
	}
	//================================= Option 1 add (CRUD - Read) =================================

	public static UserAcct inputUserAcct() {

		String name = Helper.readString("Enter Name > ");
		int contactNum = Helper.readInt("Enter Contact Number > ");
		String userID  = Helper.readString("Enter UserID > ");

		UserAcct UA = new UserAcct(name, contactNum, userID);
		return UA;
	}

	public static void addUserAcct(ArrayList<UserAcct> UserList, UserAcct UA) {

		for(int i = 0; i < UserList.size(); i++) {

			if (UserList.get(i).getName().equalsIgnoreCase(UA.getName()) )
				return;
		}
		if ((UA.getName().isEmpty()) || UA.getContactnum() == 0) {
			return;
		}
		UserList.add(UA) ;
	}





	//================================= Option 2 view (CRUD - Create)=================================

	public static String retrieveAllUserAcct(ArrayList<UserAcct> UserList) {
		String output = "";
		for (int i = 0; i < UserList.size(); i++) {
			output += String.format("%-10s %-15d %-10s\n", UserList.get(i).getName(), UserList.get(i).getContactnum(),
					UserList.get(i).getUserID());
		}
		return output;
	}


	public static void viewAllUserList(ArrayList<UserAcct> UserList) {
		C206_CaseStudy.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-15s %-10s\n", "Name", "ContactNum", "UserID");
		output += retrieveAllUserAcct(UserList);	
		System.out.println(output);

	}
	//================================= Option 3 delete (CRUD - Create)=================================
	public static String checkdeleteUserAcct(ArrayList<UserAcct> UserList) {    
		String output = "";
		for (int i = 0; i < UserList.size(); i++) {
			output += String.format("%-10s %-15d %-10s\n", UserList.get(i).getName(), UserList.get(i).getContactnum(),
					UserList.get(i).getUserID());
		}
		return output;
	}

	public static boolean deleteUserAcct(ArrayList <UserAcct> UserList, String name) {
		//String output = checkdeleteUserAcct(UserList);
		String checkname = name.trim();
		for (int i = 0; i < UserList.size(); i++) {
			if (checkname.equalsIgnoreCase(UserList.get(i).getName())) {      
					
				UserList.remove(UserList.get(i));
					return(true);
			}else {
				return(false);
			}
		}
		return(false);
	}
}





