package quicksort;

public class QuickSort {
	
	static int[] swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		return arr;
	}
	static int Partitioning(int[] arr,int l,int h)
	{
		int pivot = arr[l];
		int i=l , j=h;
		
		while(i<j)
		{
			do
			{
				i++;
			}while(arr[i]<=pivot);
			
			do
			{
				j--;
			}while(arr[j]>pivot);
		
			if(i<j)
				swap(arr,i,j);
			
		}
		
		swap(arr,l,j);
		return j;
	}
	
	static int[] quickSort(int[]arr,int l,int h)
	{
		if(l<h)
		{
			int j = Partitioning(arr,l,h);
			quickSort(arr,l,j);
			quickSort(arr,j+1,h);
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,3,7,5,6,4,8,2,Integer.MAX_VALUE};
		
		arr = quickSort(arr,0,arr.length-1);
		
		for(int i:arr)
		{
			if(i==Integer.MAX_VALUE) break;
			System.out.print(i+" ");
		}
		
		
		
	}

}
