package Linked_list_java;


import java.util.*;

class Node           
{
	private int data;
	private Node next;
	
	Node()
	{
		data = 0;
		next = null;
	}
	
	Node(int val , Node n)
	{
		data = val;
		next = n;

	}
	
	public void setData(int val)
	{
		data = val;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
	
	public int getData()
	{
		return data;
	}
	
	public Node getNext()
	{
		return next;
	}
	

}

class Linked_List
{
	private int size;
	private Node start;

    public void size()
      {

          System.out.println("SIZE OF THE LINKED LIST : " +size);
      }
	
	public boolean isEmpty()
	{
		if(size==0 | start ==null)
			return true;
		else
			return false;
	}
	
	public void viewList()
	{
		if (start == null)
			System.out.println("LIST IS EMPTY");
		else
		{
			Node t ;
			t = start;
			for(int i=0 ; i<size ; i++)
			{
               System.out.print(" " +t.getData() +" ");
			   t = t.getNext();
			   
			}
		}
	}
	
	public void insertFirst(int val)
	{
		Node n = new Node(val ,start);
		start = n;
		size++;
	}

	public void insertEnd(int val)        //Inserts Node in the End
		{
			Node n ,t;
			n = new Node(val,null);
		        t = start ;
			if(t==null)
				start = n;
			else
			{
				while(t.getNext()!=null)
					t = t.getNext();
				
				t.setNext(n);
			}
			
			size++;
		}
	
	public void insertPos(int val , int pos)
	{
		if(pos==1) insertFirst(val);
		else if(pos==size+1) insertEnd(val);
		
		else if(pos > 1 && pos <size)
		{
			Node n = new Node(val , null);
			Node t=start;
			for(int i=1 ; i<pos-1 ; i++)
			{
				t = t.getNext();
			}
			n.setNext(t.getNext());
			t.setNext(n);
			size++;
		}
                 else 
                 System.out.println("Insertion not posssible at position " +pos);
	}
	
	public void deleteFirst()
	{
		if(start==null) System.out.println("Nothing to Delete");
		else
		{
			start = start.getNext();
			size--;
		}
	}
	
	public void deleteLast()
	{
		if(start==null) deleteFirst();
		if(size == 1) { start.setNext(null);  size-- ; }
		else
		{
			Node t = start;
			for(int i=1 ; i<size-1 ; i++)
			t = t.getNext();
			
			t.setNext(null);
			size--;
		}
	}
	
	public void deletePos(int pos)
	{
		if(pos==1) deleteFirst();
		else if(pos==size) deleteLast();
        else if(start == null) System.out.println("No Element");
        else if(pos<1 || pos>size)  System.out.println("No Element to delete at position :" +pos);
		 
		
		else
		{
			Node t = start;
			Node z;
			for(int i=1 ; i<pos-1 ; i++) t = t.getNext();
			
			z = t.getNext();
			t.setNext(z.getNext());
			size--;
		}
                  
	}
	
	public void Reverse()
	{
		Node current = start;
		Node next = null;
		Node prev = null;
		
		while(current!=null)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		start = prev;
		
			
	}
}

public class Linked_List_Driver {
	public static void main(String args[])
	{   
		Linked_List list = new Linked_List();
		System.out.println("!!!WELCOME TO LINKED LIST PROGRAME!!!");
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
            System.out.println("8 to view List Size");
			System.out.println("9 to Reverse the Link List");
			System.out.println("10 to Exit");
			int choice = sc.nextInt();
			switch(choice) {
			
			case 1:
				System.out.println("ENTER NODE :");
				int val = sc.nextInt();
				list.insertFirst(val);
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
				list.deleteFirst();
				break;
				
			case 5:
				System.out.println("ENTER THE POSITION :");
				int pos1 = sc.nextInt();
				list.deletePos(pos1);
				break;
				
			case 6:
				list.deleteLast();
				break;
				
			case 7:
				list.viewList();
				break;
                
			case 8:
                 list.size();
                 break;
                 
			case 9:
				list.Reverse();
				break;
				
			case 10:
				flag = false;
				sc.close();
				break;
				
				default: 
				System.out.println("INVALID CHOICE");
				
			
			}
			
		}
		
	}
}
