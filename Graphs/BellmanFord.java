/*BellmanFord Algorithm (A greedy algorithm)
 * 
 * 
 * BellmanFord Algorithm dont work for NEGATIVE WEIGHED CYCLES..IT WILL BE A INFINITE LOOP;
 * But it could be used to detect negative edges , if relaxation is successfull after V-1 attempts ;
 * 
 * HERE the Relaxation procedure is repeated = Total vertices - 1 times
 * After this many times , Minimum distance will be found for all edges;
 * Time Complexity : O(|V||E|) , for complete graph -> O(V^3) 
 * 
 * author :  
 *            @Divyansh
 */


package bellmanFord;
import java.util.*;


class Graph
{
	private int vertexCount;
	private int adjMatrix[][];
	Set<Integer> visited = new HashSet<Integer>();
	Graph(int val)
	{
		this.vertexCount = val;
		adjMatrix = new int[][] {{0,6,5,5,0,0,0}, {0,0,0,0,-1,0,0}, {0,-2,0,0,1,0,0},
			                     {0,0,-2,0,0,-1,0},{0,0,0,0,0,0,3},{0,0,0,0,0,0,3},
			                     {0,0,0,0,0,0,0}};
		
/*		for(int i=0 ; i<vertexCount ; i++)
			for(int j=0 ; j<vertexCount ; j++)
				adjMatrix[i][j] = 0;
				*/
		
	
	}

int nextVertex(int[] arr , Set<Integer> visited)
{
	int value=Integer.MAX_VALUE;
	int count = 0;
	for(int i=0 ; i<vertexCount ; i++ )
	{
		if(arr[i]<value && visited.contains(i)==false)
		{
			value = arr[i];
			count = i;
		}
	}
	return count;
}
 
void BellmanFord()
{
	int[] distance = new int[vertexCount];
	 
	 for(int i=0 ; i<vertexCount ; i++)
		 distance[i] = Integer.MAX_VALUE;
	 
	 	 distance[0] = 0;
	      int count = 1;
	 Set<Integer> visited = new HashSet<Integer>();
	while(count < vertexCount)
	{
	 while(visited.size()<vertexCount)
	 {
		int v = nextVertex(distance,visited);
		visited.add(v);
		
		for(int i=0 ; i<vertexCount ; i++)
		{
			if(adjMatrix[v][i]!=0)
			{
				if(distance[v]+adjMatrix[v][i] < distance[i])
				distance[i] = distance[v] + adjMatrix[v][i];
			}
		}
	 }
	 visited.clear();
	 count++;
	}
	
	System.out.println("Count : " +count);
	
	 for(int i=0 ; i<vertexCount ; i++)
		 System.out.println("Vertex "+i+" : "+distance[i]);
	 
}
}
class BellmanFord {
public static void main(String[] args) {
		
		      Graph g = new Graph(7);
		      
		      g.BellmanFord();
	}

}
