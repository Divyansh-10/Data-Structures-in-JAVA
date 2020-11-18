/*THIS PROGRAMME IS FOR SHORTES PATH FROM SINGLE SOURCE FOR UNWEIGHTED GRAPH
 * 
 * Each vertex to be examined Atmost 1 .
 * Similar as a bfs traversal.
 * Data structures used : Queue , array ;
 * 
 *   author : 
 *             @Divyansh
 */




package shortestPathUnweightedGraph;
import java.util.*;
public class ShortestPath {
	
	//Methods takes matrix , size and src as parameters.
	static void shortestPath(int[][] graph , int src ,int size)
	{
		Queue<Integer> theQueue = new LinkedList<Integer>();
		int[] distance = new int[size];
		
		for(int i=0; i<size ; i++)
			distance[i]=-1;
		
		distance[src]=0;
		theQueue.add(src);
		
		while(!theQueue.isEmpty())
		{
			
			int v = theQueue.peek();
			for(int i=0 ; i<size ; i++)
			{
				if(graph[v][i]!=0 && distance[i]==-1)
				{
				distance[i] = distance[v]+1;
				theQueue.add(i);
				}
			}
			
			theQueue.poll();
			
		}
		
		 for(int i=0 ; i<size ; i++)
			 System.out.println("Vertex "+i+" : "+distance[i]);
		
	}

	public static void main(String args[])
	{
		int adjMatrix[][] = new int[][]{{0,1,1,0,0,0},{0,0,0,0,0,1},
			                            {1,0,0,1,1,0},{0,0,1,0,1,0},
			                            {0,0,1,1,0,0},{0,1,0,0,0,0}};
			
			shortestPath(adjMatrix,0,6);
	}

}
