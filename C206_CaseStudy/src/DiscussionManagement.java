import java.util.ArrayList;

public class DiscussionManagement {

    public static void main(String[] args) {
        ArrayList<Discussion> discussionList = new ArrayList<Discussion>();
        discussionList.add(new Discussion("How to maintain your bike?"));
        discussionList.add(new Discussion("Best places to ride in the city?"));

  
        
        int option = -1;
        while (option != 4) {
            DiscussionManagement.adminMenu();
            option = Helper.readInt("Enter an option > ");
            if (option == 1) {
                Discussion d = inputDiscussion();
                DiscussionManagement.addDiscussion(discussionList, d);
            } else if (option == 2) {
                DiscussionManagement.viewAllDiscussions(discussionList);
            } else if (option == 3) {
                String discussionTopic = Helper.readString("Enter Discussion Topic > ");
                DiscussionManagement.deleteDiscussion(discussionList, discussionTopic);
            } else if (option == 4) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    public static void adminMenu() {
        DiscussionManagement.setHeader("DISCUSSION MANAGEMENT PORTAL");
        System.out.println("1. Add a new Discussion");
        System.out.println("2. View all Discussions");
        System.out.println("3. Delete an existing Discussion");
        System.out.println("4. Quit");
        Helper.line(115, "-");
    }

    public static void setHeader(String header) {
        Helper.line(115, "-");
        System.out.println(header);
        Helper.line(115, "-");
    }

    //================================= Option 1 Add =================================
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

    //================================= Option 2 View =================================
    public static String retrieveAllDiscussions(ArrayList<Discussion> discussionList) {
        String output = "";
        for (Discussion d : discussionList) {
            output += String.format("%-50s\n", d.getTopic());
        }
        return output;
    }

    public static void viewAllDiscussions(ArrayList<Discussion> discussionList) {
        DiscussionManagement.setHeader("DISCUSSIONS LIST");
        String output = String.format("%-50s\n", "Discussion Topic");
        output += retrieveAllDiscussions(discussionList);
        System.out.println(output);
    }

    //================================= Option 3 Delete =================================
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
}

class Discussion {
    private String topic;

    public Discussion(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    // ... (You can add other methods or attributes if required)
}

// Remember to include the Helper class from the previous examples for reading input and printing lines.