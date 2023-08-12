public class Bike {

	private String model;
	private String brand;
	private String type;
	
	public Bike(String model) {
		super();
		this.model = model;
	}

	public Bike(String model, String brand, String type) {
		super();
		this.model = model;
		this.brand = brand;
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}