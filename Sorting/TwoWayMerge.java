/*
 * This is programme for Merge Sort for sorting combination of 2 sorted arrays
 * author :
 *      @Divyansh
 */

package mergesort;
import java.util.*;

public class TwoWayMerge {
	
	static void merge(int[] a,int[] b)
	{
		List<Integer> sort = new ArrayList<>();
		
		int i=0 , j=0;
		while(i<a.length && j<b.length)
		{
			if(a[i]<b[j])
				sort.add(a[i++]);
			else
				sort.add(b[j++]);
		}
		
		for(;i<a.length;i++)   //self-initialized i
			sort.add(a[i]);
		
		for(;j<b.length;j++)   //self-initialized j
			sort.add(b[j]);
		
		for(int z:sort)
			System.out.print(z+" ");
	}

	public static void main(String[] args) {
		int[] arr1 = {1,3,5,8,9};
		int[] arr2 = {2,4,6,7,10};
		
		merge(arr1,arr2);

	}

}
