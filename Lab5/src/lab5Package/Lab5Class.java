package lab5Package;

public class Lab5Class {
	public static int factorialI(int x) {
		if(x < 0)
	    {
	        return -1;
	    }
	    if(x == 0)
	    {
	        return 1;
	    }
	    else
	    {
	    	int result = 1;
	        while(x > 0)
	        {
	            result = result*x;
	            x--;
	        }
	        return result;
	    }
	}
	public static int factorialR(int x) {
		if(x < 0)
	    {
	        return -1;
	    }
	    if(x == 0)
	    {
	        return 1;
	    }
	    return x*factorialR(x-1);
	}
	public static int sumXYI(int x, int y) {
		if(x > y)
		{
			return -1;
		}
		int result = 0;
		while(x<=y) {
			result += x;
			x++;
		}
		return result;
	}
	public static int sumXYR(int x, int y) {
		if(x > y)
		{
			return -1;
		}
		if(x < y)
		{
			return x + sumXYR(x+1, y);
		}
		else
		{
			return x;
		}
	}
	public static int numberDigitI(int x, int digit) {
		if(x < 0)
		{
			return -1;
		}
		int count = 0;
		while(x > 0)
		{
			if(x%10 == digit)
			{
				count++;
			}
			x = x/10;
		}
		return count;
	}
	public static int numberDigitR(int x, int digit) {
		if(x < 0)
		{
			return -1;
		}
		if(x > 0)
		{
			if(x%10 == digit)
			{
				return 1 + numberDigitR(x/10, digit);
			}
			else
			{
				return numberDigitR(x/10, digit);
			}
		}
		else
		{
			return 0;
		}
	}
	public static int numberLengthI(int x) {
		if(x < 0)
		{
			return -1;
		}
		int count = 0;
		while(x > 0)
		{
			count++;
			x = x/10; 
		}
		return count;
	}
	public static int numberLengthR(int x) {
		if(x < 0)
		{
			return -1;
		}
		if(x > 0)
		{
			return 1 + numberLengthR(x/10);
		}
		else
		{
			return 0;
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(factorialI(5));
//		System.out.println(factorialR(5));
//		System.out.println(sumXYI(1, 3));
//		System.out.println(sumXYR(1, 3));
//		System.out.println(numberDigitI(1333323, 3));
//		System.out.println(numberDigitR(1333323, 3));
		System.out.println(numberLengthI(1233));
		System.out.println(numberLengthR(1233));
	}

}
