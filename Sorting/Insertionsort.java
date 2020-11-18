package insertionsort;

public class Insertionsort {
	
	static int[] insertionSort(int[] arr)
	{
		int j=1 ;
		
		while(j<arr.length) {
			int i= j;
			int v = arr[i];
			
			while(i>0 && v<arr[i-1])
			{
				arr[i] = arr[i-1];
				arr[i-1] = v;
				i--;
			}
		
			j++;
		}
		return arr;
	}
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {10,5,3,7,2,4};
		
		arr = insertionSort(arr);
		for(int i:arr)
			System.out.print(i+" ");
	}

}
