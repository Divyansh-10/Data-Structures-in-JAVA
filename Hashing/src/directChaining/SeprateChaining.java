package directChaining;


class Node
{
	int data;
	Node next = null;
	Node(int data)
	{
		this.data = data;
	}
}


class Chaining
{
	Node[] arr = new Node[10];
	int size = 0;

	void delete(int key)
	{
		 int index = key%10;
		 
		 Node temp = arr[index];
		
		 if(temp.data == key)
		 {
			 arr[index] = temp.next;
			 System.out.println(key+" Successfully deleted");
             return ;
		 }
		 
	
		 while(temp.next.data != key)
		 {
			 temp = temp.next;
		 }
		 
		 Node temp2 = temp.next.next;
		 temp.next = temp2;
		 
		 System.out.println(key+" Successfully deleted");
	}
	
		
	void search(int key)
	{
	   int index = key%10;
	   
	   if(arr[index]==null) {
		   System.out.println("Key value does not exist"); 
		   return;
	   }
	   
	   if(arr[index].data == key) {
		   System.out.println("Key value do exist");
		   return;
	   }
	  
	   Node temp = arr[index];
	   while(temp.next!=null)
		   {
			   temp = temp.next;
			   if(temp.data == key) 
				   { 
				     System.out.println("Key value do exist");
				     return;
				   }
		   }
	  
	   System.out.println("Key value does not exist");
	   
	}
	
	
	void delTable()
	{
		for(int i=0; i<arr.length ; i++)
			arr[i]= null;
			
	}

	void add(int key)
	{
		
		int index = key % 10;
		Node n = new Node(key);
		
		if(arr[index] == null)
		{
			arr[index]= n;
			size ++;
	
		}
		
		
		else
		{
		   Node temp = arr[index];
		   while(temp.next!=null)
		   {
			   temp = temp.next;
		   }
		   
		     temp.next = n;
		    
		     size++;
		  
		}
		
		System.out.println(key+" successfully added ");
	}
	 
}

public class SeprateChaining {

	public static void main(String[] args) {
		Chaining c = new Chaining();
		c.add(10);
		c.add(20);
		c.add(30);
		c.add(15);
		c.add(999);
		c.add(26);
		
		System.out.println("Size of hashTable : " +c.size);
	
		c.search(30);
		c.delete(15);
		c.search(15);

	}

}
