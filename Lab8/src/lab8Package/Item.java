package lab8Package;

public class Item {
	public String name;
	public Double weight;
	public Item (String name, Double weight) throws Exception{
		if(!isNameValid(name))
		{
			throw new Exception ("Invalid name!");
		}
		this.name = name;
		if(!isWeightValid(weight))
		{
			throw new Exception ("Invalid name!");
		}
		this.weight = weight;
	}
	public String toString() {
		return ("Name: "+name+", weight: "+weight);
	}
	public boolean isNameValid(String name) {
		if(name == null || name.trim().length() <= 0)
		{
			return false;
		}
		return true;
	}
	public boolean isWeightValid(Double weight) {
		if(weight < 0.1 || weight > 10.0)
		{
			return false;
		}
		return true;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        if(isNameValid(name))
        {
            this.name = name;
        }
    }
    public Double getItemWeight() {
        return weight;
    }
    public void setItemWeight(Double weight) {
        if (isWeightValid(weight))
        {
            this.weight = weight;
        }
    }
}