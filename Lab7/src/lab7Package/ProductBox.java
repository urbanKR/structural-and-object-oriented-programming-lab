package lab7Package;

public class ProductBox {
	private ProductType [] regularStore;
	private ProductTypeEx[] exStore;

	public ProductBox(ProductType[] regularStore, ProductTypeEx[] exStore) {
		if(regularStore instanceof ProductType[]) 
		{
			this.regularStore = regularStore;
		}
		if(exStore instanceof ProductTypeEx[]) 
		{
			this.exStore = exStore;
		}
	}
	public boolean setRegular(ProductType[] data) {
		if(data instanceof ProductType[]) 
		{
			this.regularStore = data;
			return true;
		}
		return false;
	}
	public boolean setEx(ProductTypeEx[] data) {
		if(data instanceof ProductTypeEx[]) 
		{
			this.exStore=data;
			return true;
		}
		return false;
	}
	public Double calcAveragePrice() {
		double sum = 0;
		for(int i=0; i<regularStore.length; i++) {
			if(regularStore[i] instanceof ProductType) 
			{
				sum += regularStore[i].getPrice();
			}
		}
		double avg = (double)sum/regularStore.length;
		if(avg>0) 
		{
			return avg;
		} 
		return Double.NaN;
	}
	public Double calcAveragePriceEx() {
		double sum = 0;
		double avg;
		for(int i=0; i<exStore.length; i++) {
			if(exStore[i] instanceof ProductTypeEx) 
			{
				sum += exStore[i].getPrice();
			}
		}
		avg = (double)sum/exStore.length;
		return avg;
	}
	public static void main(String[] args) throws Exception {
		ProductTypeEx product1 = new ProductTypeEx("Stone",10.0,"bad");
		ProductTypeEx product2 = new ProductTypeEx("Wood",10.0,"amazing");
		ProductTypeEx product3 = new ProductTypeEx("Rock",50.0,"good");
		ProductTypeEx product4 = new ProductTypeEx("Glass",100,"not bad");
		ProductTypeEx product5 = new ProductTypeEx("Brick",9.0,"outstanding");

		ProductType product6 = new ProductType("Stone",150.0,"brilliant");
		ProductType product7 = new ProductType("Rock",30.0,"uncommon");
		ProductType product8= new ProductType("Wood",50.0,"magnificent");
		ProductType product9 = new ProductType("Brick",10,"terrible");
		ProductType product10 = new ProductType("Glass",55.0,"expensive");
		
		ProductTypeEx arrOfProductsEx[] = {product1, product2, product3, product4, product5};
		ProductType[] arrOfProducts = {product6, product7, product8, product9, product10};

		ProductBox testBox = new ProductBox(arrOfProducts, arrOfProductsEx);

		System.out.println("setRegular is proper: "+testBox.setRegular(arrOfProducts));
		System.out.println("setEx is proper: "+testBox.setEx(arrOfProductsEx));
		System.out.println(testBox.calcAveragePrice());
		System.out.println(testBox.calcAveragePriceEx());
	}
}
