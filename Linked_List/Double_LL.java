/*
 * author : @DivyanshKamboj
 * 
 * This is a Double Linked List program with functionality of forward and reverse traversal.
 * Node at specific Position can be accessed.
 * Insertion and Deletion at any position
 */

package double__LLAdv;

import java.util.Scanner;

class Node
{
	private int data;
	private Node next ;
	private Node prev ;
	
	Node(int d, Node n ,Node p)
	{
		this.data = d;
		this.next = n;
		this.prev = p;
	}
	
	public void setData(int val)
	{
		data = val;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
	
	public void setPrev(Node p)
	{
		prev = p;
	}
	
	public int getData()
	{
		return data;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public Node getPrev()
	{
		return prev;
	}
	
}

class Double_LL_Methods
{
	private int size;
	private Node start;
    private Node end = start;
	
	public void size()
	{
		System.out.println("Size of List : " +size);
	}
	
	public void viewList()
	{
		if(size == 0) System.out.println("List is Empty");
		else
		{
		Node t =start;
        for(int i=0 ; i<size ; i++)
        {
        System.out.print(t.getData() + " ");
        t=t.getNext();
	    }
		}
	}
	
	public void reverseList()
	{
		if(size == 0) System.out.println("List is Empty");
		else if(size == 1) 
		{
			end = start;
			System.out.println(end.getData());
		}
		else
		{
			Node t = end;
			for(int i=size ; i>0 ; i--)		
			{
				System.out.print(t.getData()+" ");
				t = t.getPrev();
			}
		}
	}

	
	public void EndNode()
	{
		if(size==0) System.out.println("NO END NODE");
	    else if(size==1) 
		{
			end = start;
			
		}
		else if(size > 1)
		{   
			end = new Node(0,null,null);
			Node s = start;
		    while(s.getNext()!=null)
				s = s.getNext();
		    
		    end = s;
		    
		  }
	}
	
	public void insertBegin(int val)
	{
		Node n = new Node(val,start,null);
	    start = n;
	    if(size>0)
	    {
	       Node z = start.getNext();
	 	   z.setPrev(start);
	    }
	    size++;
	    EndNode();
	}
	
	public void insertEnd(int val)
	{
		if(size == 0) insertBegin(val);
		else
		{
			Node n = new Node(val,null,null);
			Node t = start;
			while(t.getNext() != null)
			{
				t = t.getNext();
			}
			t.setNext(n);
			n.setPrev(t);
		    size++;	
		    EndNode();
		  
		}
	}
	
	public void insertPos(int val,int pos)
	{
		 if(size == 0) insertBegin(val);
		 else if(pos == size+1) insertEnd(val);
		 else if(pos < 1 || pos > size+1) System.out.println("CANNOT INSERT HERE");
		 else if(pos >1 && pos < size)
		 {
		     Node t = start;
			 Node n =  new Node(val,null,null);
			 for(int i=1 ; i<pos-1 ; i++)
			{	 
			 t = t.getNext();
			}
			 Node z = t.getNext();
			 z.setPrev(n);
			 n.setNext(t.getNext());
			 n.setPrev(t);
			 t.setNext(n);
			 size++;
		 }		 
	}
		 
	public void deleteBegin()
	{
		if(size == 0) System.out.println("NO ELEMENTS");
		else
		{
			start = start.getNext();
			size--;
			EndNode();
		}
	}
	
	public void deleteEnd()
	{
		if(size==0) System.out.println("NO ELEMENTS");
		else if(size == 1) deleteBegin();
		else
		{
			
			Node t=start;
			for(int i=1;i<size-1;i++)
				t = t.getNext();
		
		 	t.setNext(null);
		 	size--;
		 	EndNode();
		}
	}
	
	public void deletePos(int pos)
	{
		if(pos==1) deleteBegin();
		else if(pos==size) deleteEnd();
        else if(start == null) System.out.println("No Element");
        else if(pos<1 || pos>size)  System.out.println("No Element to delete at position :" +pos);
		 
		else
		{
			Node t = start;
			Node z;
			for(int i=1 ; i<pos-1 ; i++) 
				t = t.getNext();
			
			z = t.getNext();
			t.setNext(z.getNext());
			z = z.getNext();
			z.setPrev(t);
			size--;
		}
     }
	
	public void valuePos(int pos)
	{
		if(pos==1) System.out.println(start.getData());
		else if(pos == size) System.out.println(end.getData());
		else if(pos>1 && pos<=size/2)
		{
		  System.out.println("From Start with Love");
		   Node t = start;
		   int p = 1;
		   while(p != pos)
		   {
			   t = t.getNext();
			   p++;
		   }   
		   System.out.println("Your Value : " +t.getData());
		}
		else if(pos <size && pos > size/2)
		{
			System.out.println("From End with Love");
			Node t = end;
			int p = size;
			while(p!=pos)
			{
				t = t.getPrev();
				p--;
			}
			System.out.println("Your Value : " +t.getData());
		}
		else
		{
			System.out.println("Nothing's Here Son of a Bitch!!");
		}
	 }
}

public class Double_LL {
	public static void main(String args[])
	{
		Double_LL_Methods list = new Double_LL_Methods();
		System.out.println("!!!WELCOME TO DOUBLE LINKED LIST PROGRAMME!!!");
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag)
		{
            System.out.println(" ");
			System.out.println("1 to insert in beginning");
			System.out.println("2 to insert at your position");
			System.out.println("3 to insert in End");
			System.out.println("4 to delete first Node");
			System.out.println("5 to delete your given node");
			System.out.println("6 to delete last Node");
			System.out.println("7 to view List");
			System.out.println("8 to get element from position");
            System.out.println("9 to EXIT");
            
			int choice = sc.nextInt();
			switch(choice) {
			
			case 1:
				System.out.println("ENTER NODE :");
				int val = sc.nextInt();
				list.insertBegin(val);
                break;
                
			case 2:
				System.out.println("ENTER THE POSITION :");
				int pos =sc.nextInt();
				System.out.println("ENTER NODE :");
				int val2 = sc.nextInt();
				list.insertPos(val2, pos);
				break;
				
			case 3:
				System.out.println("ENTER NODE :");
				int val3 = sc.nextInt();
				list.insertEnd(val3);
				break;
				
			case 4:
				list.deleteBegin();
				break;
				
			case 5:
				System.out.println("ENTER THE POSITION :");
				int pos1 = sc.nextInt();
				list.deletePos(pos1);
				break;
				
			case 6:
				list.deleteEnd();
				break;
				
			case 7:
				System.out.println("View Linked List : ");
				list.viewList();
				System.out.println("\nView Reversed Linked List : ");
				list.reverseList();
			    break;
			    
			case 8:
				System.out.println("Enter Position : ");
				int pos2 = sc.nextInt();
				list.valuePos(pos2);
				break;
                
			case 9:
				flag = false;
				sc.close();
				break;
		
			    default: 
				System.out.println("INVALID CHOICE");
				
			}
		}
	}
}
	
	

