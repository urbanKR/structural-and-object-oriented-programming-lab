package lab7Package;

public class ProductTypeEx {
	private String Name;
	private double itemPrice;
	private String comment;
	private int priceChangeNo;
	public ProductTypeEx(String Name, double itemPrice, String comment) throws Exception {
		if(Name == null || Name.trim().length() <= 0)
		{
			throw new Exception ("Name should be a nonempty string of characters, null value is not allowed too!");
		}
		this.Name = Name;
		if(!isPriceValid(itemPrice))
		{
			throw new Exception ("The price of a single item of ProductTypeEx, must be >= 0 and <= 200!");
		}
		this.itemPrice = itemPrice;
		if(priceChangeNo < 0)
		{
			throw new Exception ("The priceChangeNo can not be < 0!");
		}
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
		priceChangeNo++;
		return true;
	}
	public static ProductTypeEx[] createTestDataEx() throws Exception {
		ProductTypeEx product1 = new ProductTypeEx("Stone", 20, "good");
		ProductTypeEx product2 = new ProductTypeEx("Rock", 11, "bad");
		ProductTypeEx product3 = new ProductTypeEx("Wood", 200, "good");
		ProductTypeEx arrOfProducts[] = {product1, product2, product3};
		return arrOfProducts;
	}
//	public static ProductTypeEx[] createTestData() {
//		try {
//			ProductTypeEx product1 = new ProductTypeEx("Stone", 20, "good");
//			ProductTypeEx product2 = new ProductTypeEx("Rock", 23, "bad");
//			ProductTypeEx product3 = new ProductTypeEx("Wood", 200, "good");
//			ProductTypeEx product4 = new ProductTypeEx("Rock", 45, "bad");
//			ProductTypeEx product5 = new ProductTypeEx("Wood", -1, "good");
//			ProductTypeEx arrOfProducts[] = {product1, product2, product3, product4, product5};
//			return arrOfProducts;
//		} catch (Exception ignore) {}
//		return null;
//	}
	public static void testMe()  {
		ProductTypeEx[] testProductArr;
		try {
			testProductArr = createTestDataEx();
			for(int i=0; i<testProductArr.length; i++)
			{
				System.out.println(testProductArr[i].toString());
			}
			testProductArr[0].setPrice(10);
			System.out.println("Test product1 price after change should  be: 1.0, is: "+testProductArr[0].getPrice());
			testProductArr[0].modifyName("product99");
			System.out.println("Test product1 Name after change should  be: protuct99, is: "+testProductArr[0].getName());
		} catch (Exception e) {
			System.out.println("\n Incorrect Name or itemPrice in one of products!");
		}
	}
//	public static void testMe2()  {
//		ProductTypeEx[] testProductArr;
//		try {
//			testProductArr = createTestData();
//			for(int i=0; i<testProductArr.length; i++)
//			{
//				System.out.println(testProductArr[i].toString());
//			}
//		} catch (Exception e) {
//			System.out.println("Incorrect Name or itemPrice in one of products!");
//		}
//	}
	public static void main(String[] args) {
		testMe();
	}
}

