//Incomplete!!!!!!!!!!!!!!


package adjacencyList;

import java.util.*;

class Vertex
{
	public boolean visited;
	public char label;
	Vertex(char lab)
	{
		this.label = lab;
		this.visited = false;
	}
}

class Graph
{
	private int maxCount = 10;
	private int Count = 0;
	private ArrayList<ArrayList<Integer>> list;
	private Vertex vertexList[];
	private Stack<Integer> theStack ;
	Graph()
	{
		list =new ArrayList<ArrayList<Integer>>();
		vertexList = new Vertex[maxCount];
		theStack = new Stack<Integer>();
	}
	
	void addVertex(char lab)
	{
	    vertexList[Count++] = new Vertex(lab);
		list.add(new ArrayList<Integer>());
	}
	


	void addEdge(int start , int end)
	{
		list.get(start).add(end);
		list.get(end).add(start);
	}
	
	void printList()
	{
	  for(int i=0 ; i<list.size();i++)
	  {
		  for(int j=0 ; j<list.get(i).size();j++)
		  {
			  System.out.print(list.get(i).get(j)+" ");
		  }
	  
		 System.out.println();
	  }
	}
	
	int getAdjUnvisited(int v)
	{
		for(int i=0 ; i<list.get(v).size(); i++)
		   if(vertexList[list.get(v).get(i)].visited==false)
			   return i;
		
		return -1;
		
	}
	
	void Display(int v)
	{
		System.out.print(vertexList[v].label+" ");
	}
	
	void dfs()
	{
        Display(0);
		vertexList[0].visited = true;
		theStack.push(0);
		
		while(!theStack.isEmpty())
		{
			int v = getAdjUnvisited(theStack.peek());
			if(v==-1)
				theStack.pop();
			else
			{
				Display(v);
				vertexList[v].visited=true;
				theStack.push(v);
			}
		}
		  
	}
	
}

public class AdjList {

	public static void main(String[] args) {
		
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		
		g.addEdge( 0 ,2 );
		g.addEdge( 0 ,1 );
		g.addEdge( 1 ,3 );
		g.addEdge( 3, 2 );
		g.addEdge( 2 ,4 );
		
	//	g.printList();
		
		g.dfs();

	}

}
