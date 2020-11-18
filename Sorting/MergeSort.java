package mergesort;

public class MergeSort {
	
	static void mergeSort(int[] arr , int l , int m , int r)
	{
		int n1 = m-l+1;
		int n2 = r-m;
		
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		
		for(int i=0 ; i<n1 ; i++)
			arr1[i]=arr[l+i];
		
		for(int j=0 ; j<n2 ; j++)
			arr2[j] = arr[m+1+j];
		
		int i=0 , j=0 , k = l;
		
		while(i<n1 && j<n2)
		{
			if(arr1[i]<=arr2[j])
				arr[k++] = arr1[i++];
			else
				arr[k++] = arr2[j++];
		}
		
		while(i<n1)
			arr[k++]=arr1[i++];
		while(j<n2)
			arr[k++]=arr2[j++];
		
		
		
	}
	
	static void Sort(int[] arr , int l , int r)
	{
		if(l<r) 
		{
			int m = (l+r)/2 ;
			
			Sort(arr,l,m);
			Sort(arr,m+1,r);
			
			mergeSort(arr,l,m,r);
		}
	}
	static void printArray(int[] arr)
	{
		for(int i:arr)
			System.out.print(i+" ");
		
	}

	public static void main(String[] args) {
		
		int[] arr = {9,3,7,5,6,4,8,2};
		
		Sort(arr,0,arr.length-1);
		
		printArray(arr);

	}
}
