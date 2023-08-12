
public class UserAcct extends Info implements Database{
	
	private String userID;
	private int userPass;
	
	public UserAcct(String name, int ContactNum, String eventName, String Date ,String userID,int userPass) {
		super(name, ContactNum, eventName, Date);
		this.userID = userID;
		this.userPass = userPass;
	}
	
	public String getUserID() {
		return userID;
	}

	public int getUserPass() {
		return userPass;
	}
	
	public boolean login(String accNum, int pass) {
		if( accNum.equals(userID) && pass == userPass) {
			return true;
		}else {
			return false;
		}
	}
}
