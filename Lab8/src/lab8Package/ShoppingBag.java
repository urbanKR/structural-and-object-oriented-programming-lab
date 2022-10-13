package lab8Package;

import java.util.Arrays;

public class ShoppingBag extends Bag {
	public boolean extremelyRobust;
		public ShoppingBag (int bagCapacity, Double maxWeight, boolean robustness) throws Exception {
			super(bagCapacity, maxWeight);
			if(!isBagCapacityValid(bagCapacity))
			{
				throw new Exception ("Invalid bagCapacity!");
			}
			this.bagCapacity = bagCapacity;
			if(!isMaxWeightValid(maxWeight))
			{
				throw new Exception ("Invalid maxWeight!");
			}
			this.maxWeight = maxWeight;
			this.extremelyRobust  = robustness;
		}
		public String toString() {
	        return "Bag capacity: "+bagCapacity+", max weight: "+maxWeight+", is bag extremely robust?: "+extremelyRobust+", bag items: "+Arrays.toString(bagItems);
	    }
		public boolean isBagCapacityValid(int bagCapacity) {
			if(bagCapacity == 30)
			{
				return true;
			}
			return false;
		}
	}