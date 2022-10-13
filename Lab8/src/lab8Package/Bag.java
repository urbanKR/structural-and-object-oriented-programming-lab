package lab8Package;

import java.util.Arrays;

public class Bag {
	public int bagCapacity;
    public Double maxWeight;
    public Item[] bagItems;
    public int count = 0;
	public Bag(int bagCapacity, Double maxWeight) throws Exception {
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
		if(!areBagItemsValid(bagCapacity, maxWeight))
		{
			throw new Exception ("Invalid maxWeight!");
		}
		this.bagItems = new Item[bagCapacity];
	}
	public String toString() {
        return "Bag capacity: "+bagCapacity+", max weight: "+maxWeight+", bag items: "+Arrays.toString(bagItems);
    }
	public boolean isBagCapacityValid(int bagCapacity) {
		if(bagCapacity >= 1 && bagCapacity <= 50)
		{
			return true;
		}
		return false;
	}
	public boolean isMaxWeightValid(Double maxWeight) {
		if(maxWeight >= 0.1 && maxWeight <= 20.0)
		{
			return true;
		}
		return false;
	}
	public boolean areBagItemsValid(int bagCapacity, Double maxWeight) {
		if(isBagCapacityValid(bagCapacity) && isMaxWeightValid(maxWeight))
		{
			return true;
		}
		return false;
	}
	public void removeAllItems() {
		for(int i=0; i<bagCapacity; i++) {
			bagItems[i] = null;
		}
		count = 0;
	}
    public int getItemNo() {
        int itemNo = 0;
        for (int i=0; i<bagCapacity; i++){
            if (bagItems[i] != null){
                itemNo ++;
            }
        }
        return itemNo;
    }
    public double getTotalWeight() {
        double totalWeight = 0;

        for (int i=0; i<bagCapacity; i++){
            if (bagItems[i] != null){
                totalWeight +=  bagItems[i].getItemWeight();
            }
        }

        return totalWeight;
    }
	public boolean putIn(Item item) {
		if(getItemNo() + 1 <= bagCapacity && getTotalWeight() + item.getItemWeight() <= maxWeight)
		{
			bagItems[count] = item;
			count++;
			return true;
		}
		return false;
	}
	public int getCapacity() {
        return bagCapacity;
    }
	public boolean isEmpty() {
		for (int i=0; i<bagCapacity; i++){
            if (bagItems[i] != null){
                return false;
            }
        }
		return true;
	}
	public boolean isFull() {
		for (int i=0; i<bagCapacity; i++){
            if (bagItems[i] == null){
                return false;
            }
        }
		return true;
	}
	public boolean removeTheHeaviest () {
		if(bagItems == null)
		{
			return false;
		}
		Double heaviest = bagItems[0].getItemWeight();
		for (int i=0; i<bagCapacity; i++){
            if (bagItems[i].getItemWeight() > heaviest){
                heaviest = bagItems[i].getItemWeight();
            }
        }
		for (int i=0; i<bagCapacity; i++){
            if (bagItems[i].getItemWeight() == heaviest){
            	bagItems[i] = null;
            }
        }
		return true;
	}
}
