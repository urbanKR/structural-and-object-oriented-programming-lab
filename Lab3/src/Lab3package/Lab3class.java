package Lab3package;

public class Lab3class {

	public static int calcOccurenceNumber(int arr[], int value) {
		if(arr.length < 1) 
		{
            System.out.println("The array is empty!");
            return 0;
		}
		int result=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == value)
			{
				result++;
			}
		}
		return result;
	}
	
	public static int findMax(int arr[]) {
		if(arr.length < 1) 
		{
            System.out.println("The array is empty!");
            return 0;
		}
		int max=arr[0];
			for(int i=0;i<arr.length;i++) {
				if(arr[i] > max)
				{
					max = arr[i];
				}
			}
		return max;
		}
	
	public static int calcMaxOccurenceNumber(int arr[]) {
		return calcOccurenceNumber(arr, findMax(arr));
		}
	
	public static double calculatePiAccWallies(int iterNo) {
		double result=1.0;
		for(int i=1;i<=iterNo;i++) {
			result = result*(4.0*(double)i*(double)i)/((2.0*(double)i-1.0)*(2.0*(double)i+1.0));
		}
		return result*2.0;
	}
	
	public static double calculatePiAccGregory(int iterNo) {
		double result=0.0;
		int powerMinusOne=1;
		for(int i=0;i<=iterNo;i++) {
			if(i % 2 == 0)
			{
				powerMinusOne = 1;
			}
			else
			{
				powerMinusOne = -1;
			}
			result += ((double)powerMinusOne/(2.0*(double)i+1.0));
		}
		return result*4.0;
	}

	
	public static void main(String[] args) {
		int[] testArray = {12, 12, -234, 2, 777, 12, 777};
		System.out.println("calculated maximal value is: "+
		findMax(testArray)+" should be 777");
		System.out.println("calculated number of occurences is: "+
		calcOccurenceNumber(testArray, 12)+" should be 3");
		System.out.println("calculated max number of occurences is: "+
		calcMaxOccurenceNumber(testArray)+" should be 2");
		/*System.out.println(calculatePiAccWallies(3000)+"\n");
		System.out.println(calculatePiAccGregory(2)+"\n");*/
		double value;
		int iterNo=4;
		value=calculatePiAccWallies(iterNo);
		System.out.println("Wallies for: "+iterNo+"\t"+value);
		value=calculatePiAccGregory(iterNo);
		System.out.println("Gregory for: "+iterNo+"\t"+value);
		iterNo=20;
		value=calculatePiAccWallies(iterNo);
		System.out.println("Wallies for: "+iterNo+"\t"+value);
		value=calculatePiAccGregory(iterNo);
		System.out.println("Gregory for: "+iterNo+"\t"+value);
	}

}
