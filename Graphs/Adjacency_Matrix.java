/*
 * Its a Adjacency Matrix for Undirected graph suitable for Dense Graph with
 * Time Complexity INSERTION AND DELETION = O(V^2); where V= no of vertices ; Time complexity searching : O(1);
 * NOT Suitable for SPARSE graph as its time complexity will reach beyond
 * 
 * 
 * 
 * author :  @Divyansh
 *        
 */


package adjancencyMatrix;

//Class Graph with a Parameterized Constructor . 
//Matrix is a BOOLEAN TYPE WITH EXISTING EDGES AS TRUE ELSE False
class Graph
{
	private int vertexCount;
	private boolean adjMatrix[][];
	Graph(int val)
	{
		this.vertexCount = val;
		adjMatrix = new boolean[vertexCount][vertexCount];
	}

//Create Undirected edge from valid Vertices 
void addEdge(int i,int j)
	{
		if(i>=0 && i<vertexCount && j>0 && j<vertexCount)
		{
			adjMatrix[i][j]=true;
			adjMatrix[j][i]=true;
		}
		else
			System.out.println("Either a Self Loop request or vertex dont exit");
	}

//Sets valid edges as Flase for both interfaces
void remove(int i,int j)
{
	if(i>=0 && i<vertexCount && j>0 && j<vertexCount)
	{
		adjMatrix[i][j]=false;
		adjMatrix[j][i]=false;
	}
	else
		System.out.println("Edge doesnot exist");
}


//Checks if edge exist or don't 
int hasEdge(int i,int j)
{
	if(i>=0 && i<vertexCount && j>0 && j<vertexCount)
	{
		if (adjMatrix[i][j]==true) return 1;
		else return 0;
	}
	else return 0;
}

void printMatrix()
{
	for(int i=0 ; i<vertexCount ; i++)
	{
		for(int j=0 ; j<vertexCount ;j++)
		{
			System.out.print(hasEdge(i,j)+" ");
		}
		System.out.println();
	}
}



}
public class Adjacency_Matrix {

	public static void main(String[] args) {
		
		int size = 3;
		Graph g = new Graph(size);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2,4);
		g.addEdge(2, 1);
		g.addEdge(1, 1);
		
		g.printMatrix();
		
		
		
		
	}

}
