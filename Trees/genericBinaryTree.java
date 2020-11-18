package genericTree;

class Node
{
	private int data;
	private Node firstChild;
	private Node nextSibling;
	
	public int getData()
	{
		return this.data;
	}
	
	public Node getFirstChild()
	{
		return firstChild;
	}
	
	public Node getNextSibling()
	{
		return nextSibling;
	}
	
	public void setData(int val)
	{
		this.data = val;
	}
	
	public void setFirstChild(Node f)
	{
		this.firstChild = f;
	}
	
	public void setNextSibling(Node s)
	{
		this.nextSibling = s;
	}
	
}

class genericMethods
{
	int sum = 0;
	public int sum(Node root)
	{
	/*    if(root == null) return 0;
		sum = sum +root.getData();
		sum(root.getFirstChild());
		sum(root.getNextSibling());
		return sum;       */
		
		if(root==null)
		return 0;
		
		return root.getData() + sum(root.getFirstChild()) + sum(root.getNextSibling());
	}
}

public class genericBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
