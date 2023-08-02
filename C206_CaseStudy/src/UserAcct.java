
public class UserAcct{
    
	private String name;
	private int contactnum;
	private String UserID;
	
	public UserAcct(String name, int contactnum, String userID) {
		super();
		this.name = name;
		this.contactnum = contactnum;
		UserID = userID;
	}

	public String getName() {
		return name;
	}

	public int getContactnum() {
		return contactnum;
	}

	public String getUserID() {
		return UserID;
	}
	

}
