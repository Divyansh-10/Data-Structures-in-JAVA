package breadthfirstsearch;

import java.util.*;

class vertex
{
	public char label;
	public boolean visited;
	vertex(char lab)
	{
		this.label = lab;
		this.visited = false;
	}
}

class Graph
{
	private final int maxVertice = 20;
	private int vertexCount ;
	private int[][] adjMatrix;
	private vertex[] vertexList;
	private Queue<Integer> theQueue;
	Graph()
	{
		vertexCount = 0;
		adjMatrix=new int[maxVertice][maxVertice] ;
		vertexList = new vertex[maxVertice];
		theQueue = new LinkedList<Integer>();
		
		for(int i=0 ; i<maxVertice ; i++)
			for(int j=0 ; j<maxVertice ; j++)
				adjMatrix[i][j] = 0;
	}
	
	public void addVertex(char lab)
	{
		vertexList[vertexCount++] = new vertex(lab);
	}
	
	public void addEdge(int start , int end)
	{
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}
	
	public void Display(int v)
	{
		System.out.print(vertexList[v].label+" ");
	}
	
	public boolean nextAdjUnvisited(int v)
	{
		int count=0;
		for(int i=0 ; i<vertexCount ; i++)
			if(adjMatrix[v][i]==1 && vertexList[i].visited == false)
			{
				Display(i);
				theQueue.add(i);
				vertexList[i].visited = true;
				count++;
			}
		
		if(count==0) return false; 
		else return true;
		
	}
	
	public void bfsTraversal()
	{
		Display(0);
		nextAdjUnvisited(0);
		vertexList[0].visited = true;
		
		while(!theQueue.isEmpty())
		{
			boolean v = nextAdjUnvisited(theQueue.peek());
			if(v==false)
				theQueue.poll();
			else
			{
				nextAdjUnvisited(theQueue.peek());
			}
		}
		
		
	}
	
	
	
}

public class bfs {

	public static void main(String[] args) {
		Graph g =new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		g.addVertex('H');
		g.addVertex('I');
		g.addVertex('J');
		
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(3 ,2);
		g.addEdge(1, 2);
		g.addEdge(2, 8);
		g.addEdge(2, 9);
		g.addEdge(1, 4);
		g.addEdge(1, 6);
		g.addEdge(1, 7);
		g.addEdge(4, 5);
		
		g.bfsTraversal();

	}

}
