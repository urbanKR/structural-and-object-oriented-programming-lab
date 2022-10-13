package lab8Package;

import java.util.Arrays;

public class HandHoldBag extends Bag{
	public boolean premiumQuality;
	public HandHoldBag (int bagCapacity, Double maxWeight, boolean quality) throws Exception {
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
		this.premiumQuality  = quality;
	}
	public String toString() {
        return "Bag capacity: "+bagCapacity+", max weight: "+maxWeight+", bag quality is premium?: "+premiumQuality+", bag items: "+Arrays.toString(bagItems);
    }
	public boolean isBagCapacityValid(int bagCapacity) {
		if(bagCapacity == 5)
		{
			return true;
		}
		return false;
	}
	public boolean isMaxWeightValid(Double maxWeight) {
		if(maxWeight >= 0.1 && maxWeight <= 2.0)
		{
			return true;
		}
		return false;
	}
}
