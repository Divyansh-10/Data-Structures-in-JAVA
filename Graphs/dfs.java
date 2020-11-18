/*
 * DFS creates a DFStree with no BackEdges
 * 
    Object push(Object element) : Pushes an element on the top of the stack.
    Object pop() : Removes and returns the top element of the stack. An ‘EmptyStackException’ exception is thrown if we call pop() when the invoking stack is empty.
    Object peek() : Returns the element on the top of the stack, but does not remove it.
    boolean isEmpty() : It returns true if nothing is on the top of the stack. Else, returns false.
    int search(Object element) : It determines whether an object exists in the stack. If the element is found, it returns the position of the element from the top of the stack. Else, it returns -1.

     Performing DFS traversal using Stack Data Structures .
     Here Stack is a class from Java Collection.
     
  
     
     author : 
                @Divyansh
 */


package depthFirstSearch;

import java.util.*;
class vertex
{
	char label;
	boolean visited;
	vertex(char lab)
	{
		this.label = lab;
		this.visited=false;
	}
}

class Graph
{
	private final int maxVertex  =20;
	private  vertex vertexList[];
	private int[][] adjMatrix;
	private int vertexCount;
	private Stack<Integer> theStack;
	public Graph()
	{
		vertexList = new vertex[maxVertex];
		adjMatrix = new int[maxVertex][maxVertex];
		theStack = new Stack<Integer>();
		
		vertexCount = 0;
		for(int i=0 ; i<maxVertex ; i++)
			for(int j=0 ; j<maxVertex ; j++)
				adjMatrix[i][j]= 0;
		
	}
	
	public void addVertex(char lab)
	{
		vertexList[vertexCount++] = new vertex(lab);
	}
	
	public void addEdge(int start , int end)
	{
		adjMatrix[start][end] = 1;
		adjMatrix[end][start]=1;
	}
	
	public void displayVertex(int i)
	{
		System.out.println(vertexList[i].label);
	}
	
	public int getAdjUnvisitedVertex(int v)
	{
		for(int j=0 ; j<vertexCount ; j++)
		{
			if(adjMatrix[v][j]==1 && vertexList[j].visited==false)
				return j;
	    }
		 return -1;
	}
	
	public void dfsTraversal()
	{
		vertexList[0].visited = true;
		displayVertex(0);
		theStack.push(0);
		while(!theStack.isEmpty())
		{
			//get an unvisited vertex adjacent to stack top
			int v = getAdjUnvisitedVertex(theStack.peek());
			if(v==-1)
				theStack.pop();
			else
			{
				vertexList[v].visited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		//Delete the flags so that for Next executioons flag must be unsullied
		for(int i=0 ; i<vertexCount ; i++)
		{
			vertexList[i].visited = false;
		}
	}
}
public class dfs {

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
		
		g.dfsTraversal();
	}

}
