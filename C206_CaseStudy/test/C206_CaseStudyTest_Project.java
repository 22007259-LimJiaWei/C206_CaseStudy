import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class C206_CaseStudyTest_Project {
	private UserAcct User1;
	private UserAcct User2;
	private UserAcct User3;
	private UserAcct User4;
	private UserAcct User5;
	private UserAcct UA1;
	private UserAcct UA2;
	private Bike b1;
	private Bike b2;
	private Discussion d1;
	private Discussion d2;
	private ArrayList<Discussion> discussionList;
	private ArrayList<UserAcct> UserList;
	private ArrayList<Group> groupList;
	private ArrayList<Bike> bikeList;


	@Before
	public void setUp() throws Exception {
		// Create a new UserAcct object for each test case

		User1 = new UserAcct("Alice", 23456789, "The Little Pore of Singapore Cycling Tour", "07/08/2023", "Alice", 1234);
		User2 = new UserAcct("Cheng", 34567891, "National Bikers Weekend 2023", "15/08/2023", "Cheng", 1234);
		User3 = new UserAcct("Bob", 34567891, "Cycle To Makan! @ Gardens By The Bay", "10/08/2023", "Bob", 1234);
		User4 = new UserAcct("Ali", 12345678, "Bikers at Singapore", "07/07/2023", "Ali", 1234);
		User5 = new UserAcct("Ali", 12345678, "", "", "Ali", 1234);
		UA1 = new UserAcct("Alice", 87551131, "", "", "Alice", 1234);
		UA2 = new UserAcct("Bob", 97891432, "", "", "Bob", 1234);
		b1 = new Bike("Mountain Rider","Trek","Mountain Bike");
		b2 = new Bike("Speedster","Specialized","Road Bike");
        d1 = new Discussion("How to maintain your bike?");
        d2 = new Discussion("Best places to ride in the city?");
        
        discussionList = new ArrayList<Discussion>();
		bikeList= new ArrayList<Bike>();
		UserList = new ArrayList<UserAcct>();
		groupList = new ArrayList<Group>();

	}

	@Test
	public void testInputDetails_RegisterOption1_Successful() {
		// boundary
		String checkEvent = "The Little Pore of Singapore Cycling Tour";
		String checkDate = "07/08/2023";
		// Given an empty list, after adding 1 items, test if the size of the list is 1
		// - normal
		C206_CaseStudy_Project.addUser(UserList, User1);
		assertEquals("Test that Camcorder arraylist size is 1", 1, UserList.size());

		// Assert
		assertEquals(checkEvent, User1.getEventName());
		assertEquals(checkDate, User1.getDate());
	}

	@Test
	public void testInputDetails_RegisterOption2_Successful() {
		// boundary
		String checkEvent = "Cycle To Makan! @ Gardens By The Bay";
		String checkDate = "10/08/2023";

		// Given an empty list, after adding 1 items, test if the size of the list is 1
		// - normal
		C206_CaseStudy_Project.addUser(UserList, User3);
		assertEquals("Test that Camcorder arraylist size is 1", 1, UserList.size());

		// Assert
		assertEquals(checkEvent, User3.getEventName());
		assertEquals(checkDate, User3.getDate());
	}

	@Test
	public void testInputDetails_RegisterOption3_Successful() {
		// boundary
		String checkEvent = "National Bikers Weekend 2023";
		String checkDate = "15/08/2023";

		// Given an empty list, after adding 1 items, test if the size of the list is 1
		// - normal
		C206_CaseStudy_Project.addUser(UserList, User2);
		assertEquals("Test that Camcorder arraylist size is 1", 1, UserList.size());

		// Assert
		assertEquals(checkEvent, User2.getEventName());
		assertEquals(checkDate, User2.getDate());
	}

	@Test
	public void testInputDetails_Invalid_RegistrationNotAllowed() {
		// boundary
		String checkEvent = "Bikers at Singapore";
		String checkDate = "07/07/2023";

		// Given an empty list, after adding 1 items, test if the size of the list is 1
		// - normal
		C206_CaseStudy_Project.addUser(UserList, User4);
		assertEquals("Test that Camcorder arraylist size is 1", 1, UserList.size());

		// Assert
		assertEquals(checkEvent, User4.getEventName());
		assertEquals(checkDate, User4.getDate());
	}

	@Test
	public void testRetrieveAllBikers() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid UserAcct arraylist to retrieve item", UserList);

		// test if the list of UserAcct retrieved from the SourceCentre is empty -
		// boundary
		String allCamcorder = C206_CaseStudy_Project.retrieveAllEvent(UserList);
		String testOutput = "";
		assertEquals("Check that viewAllEvent is empty", testOutput, allCamcorder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy_Project.addUser(UserList, User1);
		C206_CaseStudy_Project.addUser(UserList, User2);
		assertEquals("Test that UserList arraylist size is 1", 2, UserList.size());

		// test if the expected output string same as the list of UserAcct retrieved
		// from the SourceCentre
		allCamcorder = C206_CaseStudy_Project.retrieveAllEvent(UserList);
		testOutput = String.format("%-10s %-30s %-10s %-10s\n", "Alice", 23456789, "The Little Pore of Singapore Cycling Tour", "07/08/2023");
		testOutput += String.format("%-10s %-30s %-10s %-10s\n", "Cheng", 34567891, "National Bikers Weekend 2023", "15/08/2023");

		assertEquals("Test that viewAllEvent is correct", testOutput, allCamcorder);
	}

	@Test
	public void testDeleteEvent() {
		// Test deleting an event when the user has registered for an event
		// Get the first user from the list
		C206_CaseStudy_Project.checkDelteEvent(User1);

		assertEquals("Check that event name should be empty after deletion", "", User1.getEventName());
		assertEquals("Check that Date should be empty after deletion", "", User1.getDate());
	}

	@Test
	public void testNullDeleteEvent() {
		// Test deleting an event when the user has no register for an event
		// Get the first user from the list
		C206_CaseStudy_Project.checkDelteEvent(User5);

		assertEquals("Check that Event name is Null to deletiom", "", User5.getEventName());
		assertEquals("Check that Date is Null to deletion", "", User5.getDate());
	}

	@Test
	public void testInvalidDeleteEvent() {
		// Test deleting an event when the user has no register for an event
		// Get the first user from the list
		C206_CaseStudy_Project.checkDelteEvent(User4);

		assertEquals("Check that Event name is Invalid to delete to deletion", "", User4.getEventName());
		assertEquals("Check that Date is Null to deletion", "", User4.getDate());
	}

	@Test
	public void testAddGroupNew() {
		Group g = new Group("New Group");
		C206_CaseStudy_Project.addGroup(groupList, g);
		assertTrue(groupList.contains(g));
	}

	@Test
	public void testAddGroupDuplicate() {
		Group g = new Group("Existing Group");
		groupList.add(g);
		Group g2 = new Group("Existing Group");
		C206_CaseStudy_Project.addGroup(groupList, g2);
		assertEquals(1, groupList.size());
	}

	@Test
	public void testAddGroupEmptyName() {
		Group g = new Group("");
		C206_CaseStudy_Project.addGroup(groupList, g);
		assertFalse(groupList.contains(g));
	}

	@Test
	public void testRetrieveAllGroups() {
		groupList.add(new Group("Group 1"));
		groupList.add(new Group("Group 2"));
		String result = C206_CaseStudy_Project.retrieveAllGroups(groupList);
		assertTrue(result.contains("Group 1"));
		assertTrue(result.contains("Group 2"));
	}

	@Test
	public void testDeleteGroupExists() {
		Group g = new Group("Group to Delete");
		groupList.add(g);
		assertTrue(C206_CaseStudy_Project.deleteGroup(groupList, "Group to Delete"));
		assertFalse(groupList.contains(g));
	}

	@Test
	public void testDeleteGroupNotExists() {
		assertFalse(C206_CaseStudy_Project.deleteGroup(groupList, "Non-Existent Group"));
	}

	@Test
	public void testAddUserAcct() {
		// Create a new UserAcct object
		UserAcct user1 = new UserAcct("John Doe", 12345678, "", "","johndoe123", 1234);
		// Ensure that the UserList is empty before adding the user
		assertEquals(0, UserList.size());

		// Add the user to the UserList using the addUserAcct method
		C206_CaseStudy_Project.addUserAcct(UserList, user1);

		// Check if the user was added successfully
		assertEquals(1, UserList.size());
		assertEquals("John Doe", UserList.get(0).getName());
		assertEquals(12345678, UserList.get(0).getContactNum());
		assertEquals("johndoe123", UserList.get(0).getUserID());
		assertEquals(1234, UserList.get(0).getUserPass());

		// Try adding the same user again and ensure it is not duplicated
		C206_CaseStudy_Project.addUserAcct(UserList, user1);
		assertEquals(1, UserList.size());
	}



	@Test
	public void testAddUserAcct_InvalidInput() {
		// Create a new UserAcct object with empty fields
		UserAcct user2 = new UserAcct("", 0, "", "", "", 0);

		// Ensure that the UserList is empty before adding the user
		assertEquals(0, UserList.size());

		// Try adding the user with empty fields and ensure it is not added
		C206_CaseStudy_Project.addUserAcct(UserList, user2);
		assertEquals(0, UserList.size());
	}

	@Test
	public void testRetrieveAllAcct() {
		assertNotNull("Test if there is a valid UserAcct arraylist to retrieve item", UserList);

		// Test if the list of UserAcct retrieved from the UserList is empty (boundary case)
		String allUserAcct = C206_CaseStudy_Project.retrieveAllUserAcct(UserList);
		String testOutput = "";
		assertEquals("Check that ViewAllUserAcctList", testOutput, allUserAcct);

		// Given an empty list, after adding 2 UserAcct objects, test if the size of the list is 2 (normal case)
		C206_CaseStudy_Project.addUserAcct(UserList, UA1);
		C206_CaseStudy_Project.addUserAcct(UserList, UA2);
		assertEquals("Test that UserAcct arraylist size is 2", 2, UserList.size());

		// Test if the expected output string matches the list of UserAcct retrieved from the UserList
		allUserAcct = C206_CaseStudy_Project.retrieveAllUserAcct(UserList);
		testOutput = String.format("%-10s %-30d %-10s %-10s\n", "Alice", 87551131, "", "");
		testOutput += String.format("%-10s %-30d %-10s %-10s\n", "Bob", 97891432, "", "");

		assertEquals("Test that viewAllUserAcct", testOutput, allUserAcct);
	}

	@Test
	public void testdeleteUSerAcct() {
		UserList.add(UA2);
		assertFalse("Test that user is not found in the arrayList",
				C206_CaseStudy_Project.deleteUserAcct(UserList, "mike" ));
		assertTrue("Test that user is in the arrayList",C206_CaseStudy_Project.deleteUserAcct(UserList, "Bob" ));

		UserList.add(UA1);
		assertTrue("Test that user is in the arrayList",C206_CaseStudy_Project.deleteUserAcct(UserList, "Alice" ));
	}
	
	@Test
	public void testAddBike() {
		// Bike list is not null, and it is empty - boundary
		assertNotNull("Check if there is valid Bike arraylist to add to", bikeList);
		assertEquals("Check that bike arraylist size is 0", 0, bikeList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy_Project.addBike(bikeList, b1);
		assertEquals("Check that bike arraylist size is 1", 1, bikeList.size());
		assertSame("Check that bike is added", b1, bikeList.get(0));
		// Add another item, test the size of the list is 2 -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy_Project.addBike(bikeList, b2);
		assertEquals("Check that bike arraylist size is 2", 2, bikeList.size());
		assertSame("Check that bike is added", b2, bikeList.get(1));
		// Add a bike that already exists in the list -error
		C206_CaseStudy_Project.addBike(bikeList, b2);
		assertEquals("Test that the bike arrayList size is unchanged.", 2, bikeList.size());
		// Add an item that has a missing detail -error
		Bike b_missing = new Bike("Mountain Rider","","");
		C206_CaseStudy_Project.addBike(bikeList, b_missing);
		assertEquals("Test that the bike arrayList size is unchanged.", 2, bikeList.size());
	}

	@Test
	public void testRetrieveAllBikes() {
		assertNotNull("Test if there is a valid bike arraylist to retrieve item", bikeList);
		// Test if the list of bikeList retrieved from the bikeList is empty (boundary case)
		String allBikes = C206_CaseStudy_Project.retrieveAllBikes(bikeList);
		String testOutput = "";
		assertEquals("Check ViewAllBikes", testOutput, allBikes);
		// Given an empty list, after adding 2 bikes, test if the size of the list is 2 (normal case)
		C206_CaseStudy_Project.addBike(bikeList, b1);
		C206_CaseStudy_Project.addBike(bikeList, b2);
		assertEquals("Test that bike arraylist size is 2", 2, bikeList.size());
		// Test if the expected output string matches the list of bikes retrieved from the bikeList
		allBikes = C206_CaseStudy_Project.retrieveAllBikes(bikeList);
		testOutput = String.format("%-10s %-15s %-10s\n", "Mountain Rider","Trek","Mountain Bike");
		testOutput += String.format("%-10s %-15s %-10s\n", "Speedster","Specialized","Road Bike");
		assertEquals("Test viewAllBikes", testOutput, allBikes);
	}

	@Test
    public void testDeleteBike() {
        // Bike list is not null, and it is not empty - boundary
        assertNotNull(bikeList);
        bikeList.add(new Bike("BMX", "Mongoose", "Stunt Bike"));
        bikeList.add(new Bike("Touring", "Cannondale", "Touring Bike"));
        assertNotEquals(0, bikeList.size());
        // Given the list has 2 bikes, after deleting 1 bike, the size of the list is 1 - normal
        C206_CaseStudy_Project.deleteBike(bikeList, "BMX");
        assertEquals(1, bikeList.size());
        // Delete a non-existing bike
        // The list size remains the same
        C206_CaseStudy_Project.deleteBike(bikeList, "Cruiser");
        assertEquals(1, bikeList.size());
        // Delete a bike with missing bike model detail
        // The list size remains the same
        C206_CaseStudy_Project.deleteBike(bikeList, "");
        assertEquals(1, bikeList.size());
    }
	
	
	@Test
    public void testAddDiscussion() {
        // Prepare test data
        Discussion newDiscussion = new Discussion("New discussion topic");
        // Perform the action
        C206_CaseStudy_Project.addDiscussion(discussionList, d1);
        C206_CaseStudy_Project.addDiscussion(discussionList, d2);
        C206_CaseStudy_Project.addDiscussion(discussionList, newDiscussion);
        // Check if the discussion has been added
        assertEquals(3, discussionList.size());
        assertEquals("New discussion topic", discussionList.get(2).getTopic());
    }

    @Test
    public void testViewAllDiscussions() {
        // Perform the action
    	C206_CaseStudy_Project.addDiscussion(discussionList, d1);
        C206_CaseStudy_Project.addDiscussion(discussionList, d2);
        String output = C206_CaseStudy_Project.retrieveAllDiscussions(discussionList);
        // Check if the output contains the expected discussion topics
        assertTrue(output.contains("How to maintain your bike?"));
        assertTrue(output.contains("Best places to ride in the city?"));
    }

    @Test
    public void testDeleteDiscussion_Successful() {
        // Prepare test data
    	C206_CaseStudy_Project.addDiscussion(discussionList, d1);
        C206_CaseStudy_Project.addDiscussion(discussionList, d2);
        String topicToDelete = "How to maintain your bike?";
        // Perform the action
        boolean isDeleted = C206_CaseStudy_Project.deleteDiscussion(discussionList, topicToDelete);
        // Check if the discussion has been deleted
        assertTrue(isDeleted);
        assertEquals(1, discussionList.size());
        assertEquals("Best places to ride in the city?", discussionList.get(0).getTopic());
    }

    @Test
    public void testDeleteDiscussion_NotFound() {
        // Prepare test data
    	C206_CaseStudy_Project.addDiscussion(discussionList, d1);
        C206_CaseStudy_Project.addDiscussion(discussionList, d2);
        String topicToDelete = "Non-existent topic";
        // Perform the action
        boolean isDeleted = C206_CaseStudy_Project.deleteDiscussion(discussionList, topicToDelete);
        // Check if the discussion is not found
        assertFalse(isDeleted);
        assertEquals(2, discussionList.size());

    }

	@After
	public void tearDown() throws Exception {
		User1 = null;
		User2 = null;
		User3 = null;
		User4 = null;
		User5 = null;
		UA1 = null;
		UA2 = null;
		b1 = null;
		b2 = null;
		discussionList.clear();
		UserList.clear();
		groupList.clear();
		bikeList.clear();
	}
}
