package dijkastras;
import java.util.*;


class Graph
{
	Stack<Integer> theQueue = new Stack<>();
	
	
	private int vertexCount;
	private int adjMatrix[][];
	Set<Integer> visited = new HashSet<Integer>();
	Graph(int val)
	{
		this.vertexCount = val;
		adjMatrix = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
		
/*		for(int i=0 ; i<vertexCount ; i++)
			for(int j=0 ; j<vertexCount ; j++)
				adjMatrix[i][j] = 0;
				*/
		
	
	}

//Create Undirected edge from valid Vertices 
void addEdge(int i,int j,int val)
	{
		adjMatrix[i][j]=val;
		adjMatrix[j][i]=val;
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

void Dijkastras()
{
	 int[] distance = new int[vertexCount];
	 
	 for(int i=0 ; i<vertexCount ; i++)
		 distance[i] = Integer.MAX_VALUE;
	 
	 	 distance[0] = 0;
	
	 Set<Integer> visited = new HashSet<Integer>();
	
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
	 
	 for(int i=0 ; i<vertexCount ; i++)
		 System.out.println("Vertex "+i+" : "+distance[i]);
	 
}

}
public class Dijkastra {

	public static void main(String[] args) {
		
		Graph g = new Graph(9);
/*		g.addEdge(0,1,2);
		g.addEdge(0,2,4);
		g.addEdge(1,2,1);
		g.addEdge(1,3,5);
		g.addEdge(2,4,3);
		g.addEdge(3,4,2);
		g.addEdge(3,5,1);
		g.addEdge(4,5,4);
	*/	
		g.Dijkastras();
		
		

	}

}
