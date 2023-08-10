import java.util.ArrayList;

public class GroupManagement {

    public static void main(String[] args) {
        ArrayList<Group> groupList = new ArrayList<Group>();
        groupList.add(new Group("Bikers 101"));
        groupList.add(new Group("Morning Riders"));

        int option = -1;
        while (option != 4) {
            GroupManagement.adminMenu();
            option = Helper.readInt("Enter an option > ");
            if (option == 1) {
                Group g = inputGroup();
                GroupManagement.addGroup(groupList, g);
            } else if (option == 2) {
                GroupManagement.viewAllGroups(groupList);
            } else if (option == 3) {
                String groupName = Helper.readString("Enter Group Name > ");
                GroupManagement.deleteGroup(groupList, groupName);
            } else if (option == 4) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    public static void adminMenu() {
        GroupManagement.setHeader("GROUP MANAGEMENT PORTAL");
        System.out.println("1. Add a new Group");
        System.out.println("2. View all Groups");
        System.out.println("3. Delete an existing Group");
        System.out.println("4. Quit");
        Helper.line(115, "-");
    }

    public static void setHeader(String header) {
        Helper.line(115, "-");
        System.out.println(header);
        Helper.line(115, "-");
    }

    //================================= Option 1 Add =================================
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

    //================================= Option 2 View =================================
    public static String retrieveAllGroups(ArrayList<Group> groupList) {
        String output = "";
        for (Group g : groupList) {
            output += String.format("%-30s\n", g.getName());
        }
        return output;
    }

    public static void viewAllGroups(ArrayList<Group> groupList) {
        GroupManagement.setHeader("GROUPS LIST");
        String output = String.format("%-30s\n", "Group Name");
        output += retrieveAllGroups(groupList);
        System.out.println(output);
    }

    //================================= Option 3 Delete =================================
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

class Group {
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // ... (You can add other methods or attributes if required)
}

// Don't forget the Helper class from your previous code for reading input and printing lines.