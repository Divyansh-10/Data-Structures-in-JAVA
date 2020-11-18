/*
 * WORST CASE T.C : O(N^2) ;
 * Useful for Sorting small files  
 * 
 * Algorithm :
 * 1. Find min element in the array.(from current index to end of array)
 * 2. swap with current index at current position
 * 3. move to next index 
 * 
 * author : 
 *         @Divyansh
 */


package selectionsort;

public class SelectionSort {
	
	static int[] swap(int x , int y , int[] arr)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return arr;
	}
	
	static int[] getMin(int x , int[] arr)
	{
		int min = Integer.MAX_VALUE;
		int index = 0;
		for(int i=x ; i<arr.length ; i++)
		{
			if(arr[i]<min) 
				{
				   min = arr[i];
				   index = i;
				}
		}
		if(index!=x) 
			arr = swap(x,index,arr);
		
		return arr;
			
	}
	
	static int[] selectionSort(int[] arr)
	{
		for(int i=0 ; i<arr.length ; i++)
		{
			arr = getMin(i,arr);
		}
	
		return arr;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10,3,2,7,5,6};
		
		arr = selectionSort(arr);
		for(int i:arr)
			System.out.print(i+" ");
	}
	
}
