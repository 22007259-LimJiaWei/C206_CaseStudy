
public class AdministratorAcct extends Info implements Database{

	private String AdminID;
	private int AdminPass;	

	public AdministratorAcct(String name, int ContactNum, String AdminID, int AdminPass) {
		super(name, ContactNum);
		this.AdminID = AdminID;
		this.AdminPass = AdminPass;
	}

	public String getAdminID() {
		return AdminID;
	}

	public int getAdminPass() {
		return AdminPass;
	}

	public boolean login(String accNum, int pass) {
		if( accNum.equals(AdminID) && pass == AdminPass) {
			return true;
		}else {
			return false;
		}
	}
	
}
