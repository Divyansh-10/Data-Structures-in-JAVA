package bubblesort;

/*
 * WORST CASE T.C : O(N^2) ;
 * Never use for sorting big files 
 * ADVANTAGE : CAN BE USED TO CHECK IF GIVEN LIST IS SORTED OR NOT
 * 
 * author : 
 *         @Divyansh
 */


public class BubbleSort {
	
	static int[] swap(int x,int y,int[] arr)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return arr;
	}
	
	static int[] bubbleSort(int[] arr)
	{
		for(int i=0 ; i<arr.length ; i++)
		{
			int count = 0;
			for(int j=0 ; j<arr.length-1 ; j++)
			{
				if(arr[j]>arr[j+1])
				{
					arr = swap(j,j+1,arr);
					count++;
				}
				if(count==0)
					break;
			}
		}
		
		return arr;
	}

	public static void main(String[] args) {

		int[] arr = {10,3,2,7,5,6};
		
		arr = bubbleSort(arr);
		for(int i:arr)
			System.out.print(i+" ");
	}

}
