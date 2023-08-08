import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// prepare test data
	private UserAcct UA1;
	private UserAcct UA2;

	private ArrayList<UserAcct> UserList;

	@Before
	public void setUp() throws Exception {
		UA1 = new UserAcct("Alice", 87551131, "");
		UA2 = new UserAcct("Bob", 97891432, "");

		UserList = new ArrayList<UserAcct>();
	}

	@Test
	public void testAddUserAcct() {
		// Create a new UserAcct object
		UserAcct user1 = new UserAcct("John Doe", 12345678, "johndoe123");

		// Ensure that the UserList is empty before adding the user
		assertEquals(0, UserList.size());

		// Add the user to the UserList using the addUserAcct method
		C206_CaseStudy.addUserAcct(UserList, user1);

		// Check if the user was added successfully
		assertEquals(1, UserList.size());
		assertEquals("John Doe", UserList.get(0).getName());
		assertEquals(12345678, UserList.get(0).getContactnum());
		assertEquals("johndoe123", UserList.get(0).getUserID());

		// Try adding the same user again and ensure it is not duplicated
		C206_CaseStudy.addUserAcct(UserList, user1);
		assertEquals(1, UserList.size());
	}

	@Test
	public void testAddUserAcct_InvalidInput() {
		// Create a new UserAcct object with empty fields
		UserAcct user2 = new UserAcct("", 0, "");

		// Ensure that the UserList is empty before adding the user
		assertEquals(0, UserList.size());

		// Try adding the user with empty fields and ensure it is not added
		C206_CaseStudy.addUserAcct(UserList, user2);
		assertEquals(0, UserList.size());
	}

	@Test
	public void testRetrieveAllAcct() {
		assertNotNull("Test if there is a valid UserAcct arraylist to retrieve item", UserList);

		// Test if the list of UserAcct retrieved from the UserList is empty (boundary case)
		String allUserAcct = C206_CaseStudy.retrieveAllUserAcct(UserList);
		String testOutput = "";
		assertEquals("Check that ViewAllUserAcctList", testOutput, allUserAcct);

		// Given an empty list, after adding 2 UserAcct objects, test if the size of the list is 2 (normal case)
		C206_CaseStudy.addUserAcct(UserList, UA1);
		C206_CaseStudy.addUserAcct(UserList, UA2);
		assertEquals("Test that UserAcct arraylist size is 2", 2, UserList.size());

		// Test if the expected output string matches the list of UserAcct retrieved from the UserList
		allUserAcct = C206_CaseStudy.retrieveAllUserAcct(UserList);
		testOutput = String.format("%-10s %-15d %-10s\n", "Alice", 87551131, "");
		testOutput += String.format("%-10s %-15d %-10s\n", "Bob", 97891432, "");

		assertEquals("Test that viewAllUserAcct", testOutput, allUserAcct);
	}

	@Test
	public void testdeleteUSerAcct() {
		UserList.add(UA2);
		assertFalse("Test that user is not found in the arrayList",
				C206_CaseStudy.deleteUserAcct(UserList, "mike" ));
		assertTrue("Test that user is in the arrayList",C206_CaseStudy.deleteUserAcct(UserList, "Bob" ));
		
		UserList.add(UA1);
		assertTrue("Test that user is in the arrayList",C206_CaseStudy.deleteUserAcct(UserList, "Alice" ));
	}

	@After
	public void tearDown() throws Exception {
		UA1 = null;
		UA2 = null;
		UserList = null;
	}

}
