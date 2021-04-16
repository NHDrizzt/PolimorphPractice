package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserProduct extends Product {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufactureDate;
	
	public UserProduct(){
		
	}

	public UserProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public final String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " (used) $ ");
		sb.append(String.format("%.2f", price));
		sb.append(" (" + "Manufacture date:  " + sdf.format(manufactureDate) + ")");

		return sb.toString();
	}
}
