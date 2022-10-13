package lab6Package;

public class ProductType {
	private String name = "not_known";
	private double price = 0.0;
	private String comment = "none";
	private int priceChangeNo = 0;
	private boolean valid = false;

	public ProductType(String name, double price, String comment) {
		if(checkString(name))
		{
			this.name = name;
		}
		if(checkPrice(price))
		{
			this.price = price;
		}
		if(checkString(comment))
		{
			this.comment = comment;
		}
		if(checkString(name) && checkPrice(price) && checkString(comment))
		{
			this.valid = true;
		}
	}
	public boolean checkString(String name) {
		if(!name.equals("") && name != null)
		{
			return true;
		}
		return false;
	}
	public boolean checkPrice(double price) {
		if(price < 0.0 || price > 200.0)
		{
			return false;
		}
		return true;
	}
	public String toString() {
		return ("Name: "+name+", Price: "+price+", comment: "+comment+"\nprice changed: "+priceChangeNo+" times"+", was created successfully?: "+valid);
	}
	public boolean isValid() {
		if(!name.equals("") && price != 0.0 && !comment.equals(""))
		{
			return true;
		}
		return false;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getComment() {
		return comment;
	}
	public boolean modifyName(String newName) {
		if(checkString(newName) && checkString(name))
		{
			this.name = newName;
			return true;
		}
		return false;
	}
	public boolean setPrice(double newPrice) {
		if(checkPrice(price) && checkPrice(newPrice))
		{
			this.price = newPrice;
			this.priceChangeNo++;
			return true;
		}
		return false;
	}
}
