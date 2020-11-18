package avlTree;

class Node{
	 int data,height;
	 Node left,right;
	Node(int val)
	{
        this.data = val;
        this.height=0;
        this.left = null;
        this.right=null;
	}
	public void setData(int val)
	{
		this.data = val;
	}
	public void setHeight(int h)
	{
		this.height = h;
	}
	public void setLeftNode(Node l)
	{
		this.left = l;
	}
	public void setRightNode(Node r)
	{
		this.right = r;
	}
	public int getData()
	{
		return data;
	}
	public int getHeight()
	{
		return height;
	}
	public Node getLeftNode() {
		return left;
	}
	public Node getRightNode()
	{
		return right;
	}
}

class AVL_Methods
{
	int min=0;
	
	public int Height(Node root)                    //O(1)
	{
		if(root==null) return -1;
		else
			return root.getHeight();
	}
	
	public int Max(int val1 , int val2)
	{
		return val1>val2?val1:val2 ;
	}
	
	public int Min(Node root)
	{
		if(root.getLeftNode()==null) return root.getData();
		
		min = Min(root.getLeftNode());
		return min;
	}
	public int balanceFactor(Node root)
	{
		if(root==null) return 0;
	      return (Height(root.getLeftNode()) - Height(root.getRightNode()));
	}
	 
	//If imbalance in LeftSubtree of Left child of root
	public Node LLRotation(Node root)
	{
		Node W = root.getLeftNode();
		root.setLeftNode(W.getRightNode());
		W.setRightNode(root);
		
		W.setHeight(Max(Height(W.getLeftNode()),Height(W.getRightNode()))+1);
		root.setHeight(Max(Height(root.getLeftNode()),Height(root.getRightNode()))+1);
		
		return W;
	}
	
	//If imbalance in Right Subtree of Right child of root
	public Node RRRotation(Node root)
	{
		Node W = root.getRightNode();
		root.setRightNode(W.getLeftNode());
		W.setLeftNode(root);
		
		W.setHeight(Max(Height(W.getLeftNode()),Height(W.getRightNode()))+1);
		root.setHeight(Max(Height(root.getLeftNode()),Height(root.getRightNode()))+1);
		
		return W;
	}
	
    //iF Imbalance in RightSubtree of Left child of root
	public Node LRRotation(Node root)
	{
		root.setLeftNode(RRRotation(root.getLeftNode()));
		return LLRotation(root);
	}
	
	//If imbalance in LeftSubtree of Right Child of root.
	public Node RLRotation(Node root)
	{
		root.setRightNode(LLRotation(root.getRightNode()));
		return RRRotation(root);
	}
	
	
	
	public Node Insert(Node root, Node parent , int key)
	{
		if(root==null)
		{
			root = new Node(key);
		}
		
		else if(key<root.getData())
		{
			root.setLeftNode(Insert(root.getLeftNode(),root,key));
			if(balanceFactor(root)==2)
			{
				if(key<root.getLeftNode().getData())
				    root = LLRotation(root);
				else
					root = LRRotation(root);
			}
		}
		
		else if(key>root.getData())
		{
			root.setRightNode(Insert(root.getRightNode(),root,key));
			if(balanceFactor(root)==-2)
			{
				if(key>root.getRightNode().getData())
					root = RRRotation(root);
				else
					root = RLRotation(root);
			}
			
		}
		
		root.setHeight(Max(Height(root.getLeftNode()),Height(root.getRightNode()))+1);
		return root;
       }
	
	
	
	public Node Delete(Node root ,Node parent,int key)
	{
		if(root == null) System.out.println("Nothing to Delete");
	
		else if(key<root.getData())
		{
			root.setLeftNode(Delete(root.getLeftNode() ,root,key));
			root.setHeight(Max(Height(root.getLeftNode()),Height(root.getRightNode()))+1);
			
			if(balanceFactor(root) == -2)
			{
				if(key<root.getLeftNode().getData())
					root = LRRotation(root);
				else
					root = RRRotation(root);
			}
		}
		else if(key>root.getData())
		{
		root.setRightNode(Delete(root.getRightNode(),root, key));
		root.setHeight(Max(Height(root.getLeftNode()),Height(root.getRightNode()))+1);
		System.out.println(balanceFactor(root));
	     if(balanceFactor(root)==2)
		   {
			if(key>root.getRightNode().getData())
				root = RLRotation(root);
			else
			{
				root = LLRotation(root);
		//		System.out.println(root.getData());
			}
		   }
		}

		     else
		     {
			if(root.getLeftNode()==null)
			{
				
				return root.getRightNode();
     		}
			
			else if(root.getRightNode()==null)
			{
				return root.getLeftNode();
			}
			
	        root.data = Min(root.getRightNode());
	        root.right = Delete(root.getRightNode(),root,root.getData());
	        
		     }
		System.out.println(root.getData());
		return root;
     }   

	public void InOrder(Node root)
	{
		if(root!=null)
		{
			InOrder(root.getLeftNode());
			System.out.print(root.getData()+" ");
			InOrder(root.getRightNode());
		}
	}
	
	
}

class AVLTree {

	public static void main(String[] args) {
		
		AVL_Methods tree = new AVL_Methods();
     
	    Node root=null;
		root = tree.Insert(root, root,30);
		root = tree.Insert(root,root, 60);
		root = tree.Insert(root,root, 70);
		root = tree.Insert(root, root,100);
		root = tree.Insert(root, root, 15);
		root = tree.Insert(root,root,10);
		root = tree.Insert(root,root,20);
		root = tree.Insert(root,root,25);
		root = tree.Insert(root,root,30);
		root = tree.Insert(root,root,28);
		
		tree.InOrder(root);
		
		System.out.println("\n" +tree.Height(root));
		System.out.println("\n" +root.getData());
		System.out.println("\n" +tree.Min(root));
		
	    tree.Delete(root, root,70);
	    System.out.println("\nroot data : " +root.getData());
		tree.InOrder(root);
		 
		

	}

}
