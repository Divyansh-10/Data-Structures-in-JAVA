/*This is Program for a Minimum Spanning tree using Prim's Algorithm.(A GREEDY ALGORITHM)
 * THE CORE CONCEPT OF PRIM'S IS :
 * -> Select minimum cost edge
 * ->Next edge should be : ->connected to previous edge
 *                         ->Should be least of all Connected edges
 * ->Idea of Prims's is to : MAINTAIN A TREE AND AVOID MAKING A LOOP;
 * 
 * Total edges in MST should be equal to : (|V|-1) i.e    NO. of vertices -1 ;
 * 
 * Time Complexity : O(|E| log|V|) ; Can be improved using Fibbonaci heaps
 * 
 * author :
 *            @Divyansh
 * 
 *
 */

package prims;

import java.util.*;

class Graph
{
  private int cost = 0; //cost of Min spanning tree
  private int Edges = 0; //Edges of Min spanning tree
  private int vertexCount = 0;
  private int[][] adjMatrix;   //The Graph
  private int[][] minSpanningTree ;//The spanning tree
  private   ArrayList<Integer> visited ;//Dynamic Array used
  Graph(int val)
  {
	 visited = new ArrayList<Integer>(); 
	 this.vertexCount = val;
	 adjMatrix = new int[][] {{0,28,0,0,0,10,0},{28,0,16,0,0,0,14},{0,16,0,12,0,0,0},
		                      {0,0,12,0,22,0,28},{0,0,0,22,0,25,24},{10,0,0,0,25,0,0},
		                      {0,14,0,18,24,0,0}};
		                      
      minSpanningTree = new int[vertexCount][vertexCount];
      for(int i=0 ; i<vertexCount ; i++)
    	  for(int j=0 ; j<vertexCount ; j++)
    		  minSpanningTree[i][j]=0;
  }
  
  void addEdges(int i , int j , int val)
  {
	  minSpanningTree[i][j] = val;
	  minSpanningTree[j][i] = val;
  }
  
  //Adds the Minimum edges to graph and adds the row to ArrayList
  void addFirstVertex()
  {
	  int val = Integer.MAX_VALUE;
	  int row=0 , column = 0;
	  
	  for(int i=0 ; i<vertexCount ; i++)
		  for(int j=0 ; j<vertexCount ;j++)
			  if(adjMatrix[i][j]<val && adjMatrix[i][j]!=0)
			  {
				  val = adjMatrix[i][j];
				  row = i;
				  column = j;
			  }
	  
	  addEdges(row,column,val);
	  visited.add(row);

  }
  
  
  void Prims()
  {
	  addFirstVertex(); //First vertex added
	  
	  while(visited.size()<vertexCount)  //while all the vertices are not covered
	  {
		  
		  int val = Integer.MAX_VALUE;
		  int column = 0 , row = 0;
		  
		  for(int i=0 ; i<visited.size();i++)
		  {
			 for(int j=0 ; j<vertexCount ; j++)
			  {
				  if(adjMatrix[visited.get(i)][j]<val && adjMatrix[visited.get(i)][j]!=0 && visited.contains(j)==false)
				  {
					
					  val = adjMatrix[visited.get(i)][j];
					  column = j;
					  row = visited.get(i);
				
				  }
			  }  
		  }

		
		
		  addEdges(row,column,val);
		  visited.add(column);
		  cost = cost+val;
		  Edges++;
	  }
	 
	  spanningTree();
	  
	}
  
  
  //Prints the MST
  void spanningTree()
  {
	  System.out.println("Edges : " +Edges);
	  System.out.println("Cost : " +cost);
	  System.out.println("MININMUM SPANNING TREE : ");
	  
	  for(int i=0 ; i<vertexCount ; i++)
	  {
		  for(int j=0 ; j<vertexCount ; j++)
		  {
			  System.out.print(minSpanningTree[i][j] +" ");
		  }
		  System.out.println();
	  }
  }
  
}
			

//Driver class
public class PrimsMST {

	public static void main(String[] args) {
		
		Graph g = new Graph(7);
		
		g.Prims();

	}

}
