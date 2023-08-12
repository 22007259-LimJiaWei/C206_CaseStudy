public class Info {
	private String name;
	private int ContactNum;
	private String eventName;
	private String Date;

	
	public Info(String name, int ContactNum) {
		this.name = name;
		this.ContactNum  = ContactNum;
		this.eventName = "";
		this.Date = "";
	}

	public Info(String name, int ContactNum, String eventName, String Date) {
		this.name = name;
		this.ContactNum  = ContactNum;
		this.eventName = eventName;
		this.Date = Date;
	}



	public String showAvailability(boolean isAvailableSlot) {
		String avail;

		if(isAvailableSlot == true) {
			avail = "Yes";
		}else {
			avail = "No";
		}
		return avail;
	}

	public String getName() {
		return name;
	}

	public int getContactNum() {
		return ContactNum;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
}