package lab7Package;

public class ProductType {
	private String Name;
	private double itemPrice;
	private String comment;
	private int priceChangeNo;
	public ProductType(String Name, double itemPrice, String comment) {
		this.Name = Name;
		this.itemPrice = itemPrice;
		this.comment = comment;
	}
	public String toString() {
		return ("Name: "+Name+", Price: "+itemPrice+", comment: "+comment+"\nprice changed: "+priceChangeNo+" times");
	}
	public String getName() {
		return Name;
	}
	public double getPrice() {
		return itemPrice;
	}
	public boolean isNameValid(String Name) {
		if(Name == null || Name.trim().length() <= 0)
		{
			return false;
		}
		return true;
	}
	public boolean isPriceValid(double itemPrice) {
		if(itemPrice < 0 || itemPrice > 200)
		{
			return false;
		}
		return true;
	}
	public boolean modifyName(String new_name) {
		if(!isNameValid(new_name))
		{
			return false;
		}
		this.Name = new_name;
		return true;
	}
	public boolean setPrice(double price) throws Exception {
		if(!isPriceValid(price))
		{
			throw new Exception ("The price of a single item of ProductTypeEx, must be >= 0 and <= 200!");
		}
		this.itemPrice = price;
		return true;
	}
	public static ProductType[] createTestData() {
			ProductType product1 = new ProductType("Stone", 20, "good");
			ProductType product2 = new ProductType("Rock", 23, "bad");
			ProductType product3 = new ProductType("Wood", 200, "good");
			ProductType product4 = new ProductType("Rock", 45, "bad");
			ProductType product5 = new ProductType("Wood", -1, "good");
			ProductType arrOfProducts[] = {product1, product2, product3, product4, product5};
			return arrOfProducts;
	}
	public static void testMe2()  {
		ProductType[] testProductArr;
			testProductArr = createTestData();
			for(int i=0; i<testProductArr.length; i++)
			{
				System.out.println(testProductArr[i].toString());
			}
	}
	public static void main(String[] args) {
		testMe2();
	}
}

