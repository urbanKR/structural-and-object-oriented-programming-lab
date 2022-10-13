package lab4package;

import java.util.Scanner;

public class Lab4class {
	private static Scanner scKeyboard = new Scanner(System.in);
	/* input data from standard input, if there is not enough data fill
	 * the remaining elements with 0's.
	 * Stop reading the numbers after filling the array.
	 * All tokens that do not represent a number must be ignored
	 */
	
	public static int[] readArray(int size)
    {
        int[] array = new int [size];

        for(int i=0; i<size; i++)
        {
        	String input = scKeyboard.next();
        	try {
        		array[i] = Integer.parseInt(input);
        	}
        	catch(NumberFormatException e) {
        		i--;
        	} 
        }
        return array;
    }
	static void printOneDim(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\n");
		}
	}
	public static int[] appendArrays(int [] a1, int [] a2) {
		int[] array = new int [a1.length+a2.length];
		int k=0;
		for(int i=0; i<a1.length; i++) {
			array[i] = a1[i];
		}
		for(int j=a1.length; j<a1.length+a2.length; j++) {
			
			array[j] = a2[k];
			k++;
		}
		return array;
	}
	public int getMinimalElement(int [] inArr) {
		if(inArr.length < 1)
		{
			return 0;
		}
		int min = inArr[0];
		for(int i=0; i<inArr.length; i++) {
			if(inArr[i] < min)
			{
				min = inArr[i];
			}
		}
		return min;
	}
	// resulting array should contain all elements have the minimal value
	public int[] getMinimalElements(int [] inArr) {
		int[] resultArr = new int [inArr.length];
		int min = getMinimalElement(inArr);
		int j = 0;
		for(int i=0; i<inArr.length; i++) {
			if(inArr[i] == min)
			{
				resultArr[j] = min;
				j++;
			}
		}
		return resultArr;
	}
	// resulting array should contain elements that are >= limit
	public int[] getGreaterThan(int[] inArr, int limit) {
		int[] resultArr = new int [inArr.length];
		int j = 0;
		for(int i=0; i<inArr.length; i++) {
			if(inArr[i] >= limit)
			{
				resultArr[j] = inArr[i];
				j++;
			}
		}
		return resultArr;
	}
	// resulting array should contain elements that are >= lowrLimit and <=upperLimit
	public int[] getRange(int[] inArr, int lowerLimit, int upperLimit) {
		int[] resultArr = new int [inArr.length];
		int j = 0;
		for(int i=0; i<inArr.length; i++) {
			if(inArr[i] >= lowerLimit && inArr[i] <= upperLimit)
			{
				resultArr[j] = inArr[i];
				j++;
			}
		}
		return resultArr;
	}
	public int elementCount(int[] inArr, int what2Look4) {
		int counter = 0;
		for(int i=0; i<inArr.length; i++) {
			if(inArr[i] == what2Look4)
			{
				counter++;
			}
		}
		return counter;
	}
	public static int elementCountStatic(int[] inArr, int what2Look4) {
		int counter = 0;
		for(int i=0; i<inArr.length; i++) {
			if(inArr[i] == what2Look4)
			{
				counter++;
			}
		}
		return counter;
	}
//	public static int[] removeZerosFromArr(int[] arr) {
//		int[] resultArr = new int[arr.length-elementCountStatic(arr, 0)];
//		int j = 0;
//		for(int i=0; i<arr.length; i++) {
//			if(arr[i] != 0)
//			{
//				resultArr[j] = arr[i];
//				j++;
//			}
//		}
//		return resultArr;
//	}
	// resulting array contains elements that are in exactly one array
	public static int everyDiffElemArrPart1(int [] arr) {
		sortArr(arr);
		int l = 0;
		for(int i=0; i<arr.length; i++) {
			boolean existsSameElem = false;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]==arr[j])
				{
					existsSameElem = true;
				}
			}
			if(existsSameElem == false)
			{
				l++;
			}
		}
		return l;
    }
	public static int[] everyDiffElemArr(int [] arr, int resultArrLength) {
		sortArr(arr);
		int resultArr[] = new int[resultArrLength];
		int k = 0;
		for(int i=0; i<arr.length; i++) {
			boolean existsSameElem = false;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]==arr[j])
				{
					existsSameElem = true;
				}
			}
			if(existsSameElem == false)
			{
				resultArr[k] = arr[i];
				k++;
			}
			
		}
		return resultArr;
    }
	public static int[] uniqueElementsFrom1In2(int [] a1, int [] a2) {
		int k = 0;
		for(int m=0; m<a1.length; m++) {
			boolean isUnique2 = true;
			for(int n=0; n<a2.length; n++) {
				if(a1[m] == a2[n])
				{
					isUnique2 = false;
				}
			}
			if(isUnique2 == true)
			{
				k++;
			}
		}
		
		int[] resultArr = new int[k];
		int l = 0;
		for(int i=0; i<a1.length; i++) {
			boolean isUnique = true;
			for(int j=0; j<a2.length; j++) {
				if(a1[i] == a2[j])
				{
					isUnique = false;
				}
			}
			if(isUnique == true)
			{
				resultArr[l] = a1[i];
				l++;
			}
		}
			return everyDiffElemArr(resultArr, everyDiffElemArrPart1(resultArr));
	}
	public static int[] uniqueElements(int [] a1, int [] a2) {
		return everyDiffElemArr(appendArrays(uniqueElementsFrom1In2(a1, a2), uniqueElementsFrom1In2(a2, a1))
				,everyDiffElemArrPart1(appendArrays(uniqueElementsFrom1In2(a1, a2), uniqueElementsFrom1In2(a2, a1))));
	}
	
	public static int[] sortArr(int [] arr) {
		int x=0;
		int resultArr[] = new int[arr.length];
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]>arr[i])
				{
					x=arr[j];
					arr[j]=arr[i];
					arr[i]=x;
				}
			}
		}
		return resultArr;
    }
	//resulting array should contain elements that are in both arrays
	public static int[] commonElements(int [] a1, int [] a2) {
		int[] uniqueArr = uniqueElements(a1, a2);
		int[] appendArr = everyDiffElemArr(appendArrays(a1, a2), everyDiffElemArrPart1(appendArrays(a1, a2)));
		int[] resultArr = new int[appendArr.length];
		int k = 0;
		for(int i=0; i<appendArr.length; i++) {
			boolean isInUnique = false;
			for(int j=0; j<uniqueArr.length; j++) {
				if(appendArr[i] == uniqueArr[j])
				{
					isInUnique  = true;
				}
			}
			if(isInUnique == false)
			{
				resultArr[k] = appendArr[i];
				k++;
			}
		}
		return everyDiffElemArr(resultArr,everyDiffElemArrPart1(resultArr));
	}
	public static void reverseMe(int[] inOutArr) {
		for(int i=0; i<inOutArr.length / 2; i++) {
			int temp = inOutArr[i];
			inOutArr[i] = inOutArr[inOutArr.length - i - 1];
			inOutArr[inOutArr.length - i - 1] = temp;
		}
	}
	//return an array with elements in reversed order
	public static int[] returnReversed(int[] inArr) {
		int k = inArr.length - 1;
		int[] resultArray = new int[inArr.length]; 
		for(int i=0; i<inArr.length; i++) {
			resultArray[i] = inArr[k];
			k--;
		}
		return resultArray;
	}
	public static void showArr(int [] arrIn, int numberOfColumns) {
		for(int i=0; i<numberOfColumns; i++) {
			System.out.println(arrIn[i]);
		}
	}
	public static void main(String[] args) {
		// Test calls to all above methods
		// Except for the readArray method use initialized arrays for testing.
		// input your code here, modify the input array
		int[] testArray = {1, 3, 1, 3, 0, 0, 2, 4, 5, 1};
		int[] testArray2 = {1, 2, 3, 4};
		//printOneDim(appendArrays(testArray, testArray2));
		//System.out.println(getMinimalElement(testArray2));
		//printOneDim(uniqueElements(testArray, testArray2));
		//printOneDim(commonElements(testArray, testArray2));
		//printOneDim(everyDiffElemArr(testArray, everyDiffElemArrPart1(testArray)));
		//printOneDim(returnReversed(testArray2));
		reverseMe(testArray2);
	}
}
