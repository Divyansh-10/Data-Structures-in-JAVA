package binarytree;

class Node
{
	private int data;
	private Node left , right ;
	
	public Node(int val , Node l , Node r)
	{
		this.data = val;
		this.left = l;
		this.right = r;
	}
	
	public int getData()
	{
		return data;
	}
	
	public Node getLeftNode()
	{
	   return left;	
	}
	
	public Node getRightNode()
	{
		return right;
	}
	
	public void setData(int n)
	{
		this.data = n;
	}
	
	public void setLeftNode(Node l)
	{
		this.left = l;
	}
	
	public void setRightNode(Node r)
	{
		this.right = r;
	}
}

class BT_Methods
{
	

	public void PreOrder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.getData());
			PreOrder(root.getLeftNode());
			PreOrder(root.getRightNode());
		}
	}
	
	public void InOrder(Node root)
	{
		if(root!=null)
		{
			InOrder(root.getLeftNode());
			System.out.println(root.getData());
			InOrder(root.getRightNode());
		}
	}
	
	public void PostOrder(Node root)
	{
		if(root!=null)
		{
			PostOrder(root.getLeftNode());
			PostOrder(root.getRightNode());
			System.out.println(root.getData());
		}
	}
	
	public void MaxElement(Node root)
	{
		Node max = new Node(0,null,null);
		if(root!=null)
		{
			if(root.getData() > max.getData()) max.setData(root.getData());

            PreOrder(root.getLeftNode());
			PreOrder(root.getRightNode());
		}
		System.out.println("Max element : " +max.getData());
	}
	
	public boolean SearchData(Node root , int val)
	{
		if(root == null)
			return false;
		if(root.getData()==val)
			return true;
		
		return SearchData(root.getLeftNode(),val) || SearchData(root.getRightNode(),val);
	}
	
	public void Insertion(Node root,int val)
	{
		if (root == null)
		root = new Node(val,null,null);
		
		else if(root.getData() < val)
		{
		{
			if(root.getLeftNode()==null)
				{
				Node n = new Node(val,null,null);
				root.setLeftNode(n);
				}
			else {
				Insertion(root.getLeftNode(),val);
			     }
		}
		}
		else
		{
			
		   if(root.getRightNode()==null)
		   {
			   Node n = new  Node(val,null,null);
			   root.setRightNode(n);
		   }
		   
		   else
		   {
		   Insertion(root.getRightNode(),val);
		   }
		}
	}
	
	public int size(Node root)
	{
	    int leftCount = root.getLeftNode() == null ?0:size(root.getLeftNode());
		int rightCount = root.getRightNode()==null ?0:size(root.getRightNode());
		
		return 1+leftCount+rightCount;
	}
	
	public void DeleteTree(Node root)
	{
		if(root!=null)
		{
		DeleteTree(root.getLeftNode());
		
		DeleteTree(root.getRightNode());
		root = null;
		}
	}
	
	public int Height(Node root)
	{  
		if(root==null)
			return 0;
		
		int LeftDepth = Height(root.getLeftNode());
		int RightDepth = Height(root.getRightNode());
		
		return (LeftDepth>RightDepth)?LeftDepth+1 :  RightDepth+1 ;
			
    }
	
	
	
	
}


public class Binary_Tree {

	public static void main(String[] args) {
		
		BT_Methods tree = new BT_Methods();
		Node root = new Node(50,null,null);
		tree.Insertion(root, 10);
		tree.Insertion(root, 30);
		tree.Insertion(root, 20);
		tree.Insertion(root, 100);
		tree.Insertion(root, 5);
		
		
		tree.InOrder(root);
		
		

	}

}
