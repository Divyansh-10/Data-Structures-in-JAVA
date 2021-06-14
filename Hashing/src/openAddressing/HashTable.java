 package openAddressing;
 
 class Data
 {
	 int key;
	 int flag;    //flag -> 0 -> empty, flag -> 1 ->  delete me , flag -> 2 -> occupied
	 Data()
	 {
		 this.key = -1;
		 this.flag = 0;
	 }
 }

public class HashTable {
	
	static Data[] hashtable;
	
	static int capacity = 7;
	static int size = 0;
	
	static void createTable()
	{
		hashtable = new Data[capacity];
		for(int i = 0; i<capacity ; i++)
		{
			hashtable[i] = new Data();
		}
	}
	
	static int hash1(int key)
	{
		return key % capacity;
	}
	
	static int hash2(int key)
	{
		return ( 5 - (key % 5)) ;
	}
	
	static void Insert(int key)
	{
		int index = hash1(key);
		Data d= new Data();
		d.key = key;
		if(size == capacity)
		{
			System.out.println("Stack Overflow");
			return;
		}
		d.flag = 2;
		
		
		if(hashtable[index].key == d.key)
		{
			System.out.println("Key already present");
			return;
		}
		
		
		if(hashtable[index].flag != 2)
		{
			hashtable[index] = d;
			hashtable[index].flag = 2;
			
		}
		
		else
		{
			int i = 1;
			while(hashtable[index].flag == 2)
			{
			index = (index + i * hash2(key))%capacity;
			i++;
			
			if(hashtable[index].key == d.key)
			{
				System.out.println("Key already present");
				return;
			}
			}
					
			hashtable[index] = d;
		}
		
		System.out.println("Element inserted");
		size++;
		
	}
	
	static boolean search(int key)
	{
		int index = hash1(key);
		
		if(hashtable[index].key == key)
			return true;
		
		else
		{
			int i = 1;
			int count = 1;
			while(hashtable[index].flag != 0 && count == capacity)
			{
			index = (index + i * hash2(key))%capacity;
			i++;
			count++;
			
			if(hashtable[index].key == key)
				return true;
		 
			}
			
			return false;
		}
	}
	
	static void Delete(int key)
	{
		int index = hash1(key);
		if(hashtable[index].key == key)
		{
			hashtable[index].key = 0;
			hashtable[index].flag = 1;
		}
		
		else
		{
			int i = 1;
			while(hashtable[index].flag != 0)
			{
			index = (index + i * hash2(key))%capacity;
			i++;
			
			if(hashtable[index].key == key)
			{
				hashtable[index].key = -1;
				hashtable[index].flag = 1;
				System.out.println("Key deleted");
				return;
			}
			
			
			if(hashtable[index].flag == 0)
			{
				System.out.println("Key Not found");
			}
			
	
		    }
	}
	}
	
	static void PrintTable()
	{
		int j = 0;
		for(Data i: hashtable)
		{
			if(i !=null)
			{
				System.out.println(j+" --> "+i.key);
			}
			else
			System.out.println(j + " --> null");
			
			j++;
	
		}
	}
	public static void main(String[] args) {
		
		createTable();
		Insert(10);
		Insert(23);
		Insert(45);
		Insert(23414);
		Insert(1234);
		Insert(1244);
		Insert(1244);
		Insert(21);
		
		PrintTable();
		Delete(1244);
		PrintTable();
		System.out.println(search(5));
		
		
		

	}

}
