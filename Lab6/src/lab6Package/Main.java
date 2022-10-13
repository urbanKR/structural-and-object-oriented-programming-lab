package lab6Package;

public class Main {
	public static void main(String[] args) {
		ProductType stone1 = new ProductType("stone_1", 150.0, "good product!");
		ProductType stone2 = new ProductType("", -100.0, "");
		ProductType wood = new ProductType("wood_1", 0.0, "");
		ProductType brick = new ProductType("brick_1", 2350.0, "bad product!");
		ProductType glass = new ProductType("glass_1", 40.0, "good product!");
		ProductType arrPT[] = new ProductType[5];
		arrPT[0] = stone1;
		arrPT[1] = stone2;
		arrPT[2] = wood;
		arrPT[3] = brick;
		arrPT[4] = glass;
		for(int i=0; i<arrPT.length; i++) {
			System.out.println("Product nr "+(i+1)+":\n"+arrPT[i].toString()+"\n");
		}
		System.out.println("Additional test on first ProductType :\nName:\n"+stone1.getName());
		stone1.modifyName("stone_3");
		System.out.println("\nName after modification:\n"+stone1.getName());
		System.out.println("\nPrice:\n"+stone1.getPrice()+" nr of price changes: ");
		stone1.setPrice(170.0);
		System.out.println("\nPrice after change:\n"+stone1.getPrice());
		System.out.println("\nComment:\n"+stone1.getComment());
		System.out.println("\nIs valid?:\n"+stone1.isValid());
	}

}