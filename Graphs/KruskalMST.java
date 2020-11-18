//Application of Kruskal's algo using Weighted Union and Collapsing Find


package kruskal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Sets
{
	int size = 0;
	int cost = 0;
	int a=0 , b=0;
	List<Integer> list = new ArrayList<>();
	
	int[] set ;
	Sets(int s)
	{
		this.size = s;
		set = new int[s];
		
		for(int i=0 ; i<s ; i++)
			set[i] = -1 ;
	}
	
	int Find(int x)   //returns Parent
	{
	    if(set[x]<0)
	    	return x;
	    
	    return Find(set[x]);
	    
	}
	
	void Union(int x , int y)
	{
		int a = Find(x);
		int b = Find(y);
		
		if(a==b) return ;
		
		if(set[a]<=set[b])
		{
			set[b] = a;
			set[a] = set[a] - 1;
			return;
		}
		
		set[a] = b;
		set[b] = set[b] - 1;
	}
	
	void nextMinEdge(int[][] matrix)
	{
		int count = Integer.MAX_VALUE;
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				if(matrix[i][j]!=0 && matrix[i][j]<count && list.contains(matrix[i][j])==false)
				{
					a = i;
					b = j;
					count = matrix[i][j];
				}
			}
		}
	
		list.add(matrix[a][b]);
		cost += matrix[a][b];
	
	}
	
	void Kruskals(int[][] matrix)
	{
		Set<Integer> set = new HashSet<>();
		int[][] spanning = new int[size][size];
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				spanning[i][j] = 0;
			}
		}
		
		while(set.size()!=size)
		{
		   nextMinEdge(matrix);
		   Union(a,b);
		   spanning[a][b] = matrix[a][b];
		   spanning[b][a] = matrix[a][b];
		   
		   set.add(a);
		   set.add(b);
		}
	
		System.out.println("Cost of Kruskal's algo  : " +cost);
		System.out.println("Kruskal's spanning tree : ");
		for(int i=0 ; i<size ; i++)
		{
			for(int j=0 ; j<size ; j++)
			{
				System.out.print(spanning[i][j]+" ");
			}
			System.out.println();
		}
			
	}
	
}


public class KruskalMST {

	public static void main(String[] args) {
		
		int graph[][] = { 
		        { 0, 2, 0, 6, 0 }, 
		        { 2, 0, 3, 8, 5 }, 
		        { 0, 3, 0, 0, 7 }, 
		        { 6, 8, 0, 0, 9 }, 
		        { 0, 5, 7, 9, 0 }, }; 
		
		Sets s =new Sets(graph.length);
		s.Kruskals(graph);
    }

}