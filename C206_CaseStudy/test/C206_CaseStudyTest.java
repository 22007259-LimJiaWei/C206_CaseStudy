	import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class C206_CaseStudyTest {
	private UserAcct User1;
	private UserAcct User2;
	private UserAcct User3;
	private UserAcct User4;
	private UserAcct User5;
	private ArrayList<UserAcct> UserList;

	@Before
	public void setUp() throws Exception {
		// Create a new UserAcct object for each test case

		User1 = new UserAcct("Alice", 23456789, "The Little Pore of Singapore Cycling Tour", "07/08/2023", "Alice", 1234);
		User2 = new UserAcct("Cheng", 34567891, "National Bikers Weekend 2023", "15/08/2023", "Cheng", 1234);
		User3 = new UserAcct("Bob", 34567891, "Cycle To Makan! @ Gardens By The Bay", "10/08/2023", "Bob", 1234);
		User4 = new UserAcct("Ali", 12345678, "Bikers at Singapore", "07/07/2023", "Ali", 1234);
		User5 = new UserAcct("Ali", 12345678, "", "", "Ali", 1234);

		UserList = new ArrayList<UserAcct>();
		

	}

	@Test
	public void testInputDetails_RegisterOption1_Successful() {
		// boundary
		String checkEvent = "The Little Pore of Singapore Cycling Tour";
		String checkDate = "07/08/2023";
		// Given an empty list, after adding 1 items, test if the size of the list is 1
		// - normal
		C206_CaseStudy.addUser(UserList, User1);
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
		C206_CaseStudy.addUser(UserList, User3);
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
		C206_CaseStudy.addUser(UserList, User2);
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
		C206_CaseStudy.addUser(UserList, User4);
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
		String allCamcorder = C206_CaseStudy.retrieveAllEvent(UserList);
		String testOutput = "";
		assertEquals("Check that viewAllEvent is empty", testOutput, allCamcorder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addUser(UserList, User1);
		C206_CaseStudy.addUser(UserList, User2);
		assertEquals("Test that UserList arraylist size is 1", 2, UserList.size());

		// test if the expected output string same as the list of UserAcct retrieved
		// from the SourceCentre
		allCamcorder = C206_CaseStudy.retrieveAllEvent(UserList);
		testOutput = String.format("%-10s %-30s %-10s %-10s\n", "Alice", 23456789, "The Little Pore of Singapore Cycling Tour", "07/08/2023");
		testOutput += String.format("%-10s %-30s %-10s %-10s\n", "Cheng", 34567891, "National Bikers Weekend 2023", "15/08/2023");

		assertEquals("Test that viewAllEvent is correct", testOutput, allCamcorder);
	}

	@Test
	public void testDeleteEvent() {
		// Test deleting an event when the user has registered for an event
		// Get the first user from the list
		C206_CaseStudy.checkDelteEvent(User1);

		assertEquals("Check that event name should be empty after deletion", "", User1.getEventName());
		assertEquals("Check that Date should be empty after deletion", "", User1.getDate());
	}

	@Test
	public void testNullDeleteEvent() {
		// Test deleting an event when the user has no register for an event
		// Get the first user from the list
		C206_CaseStudy.checkDelteEvent(User5);

		assertEquals("Check that Event name is Null to deletiom", "", User5.getEventName());
		assertEquals("Check that Date is Null to deletion", "", User5.getDate());
	}
	
	@Test
	public void testInvalidDeleteEvent() {
		// Test deleting an event when the user has no register for an event
		// Get the first user from the list
		C206_CaseStudy.checkDelteEvent(User4);

		assertEquals("Check that Event name is Invalid to delete to deletion", "", User4.getEventName());
		assertEquals("Check that Date is Null to deletion", "", User4.getDate());
	}

	@After
	public void tearDown() throws Exception {
		UserList.clear();
	}
}
