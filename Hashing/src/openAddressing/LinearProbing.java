package openAddressing;

public class LinearProbing {
	
	static int size = 7;
	static int[] arr = new int[size];
	static int elements = 0;
	
	
	static private void expand()       //to generate new stack with more capacity
	{
		int length = size;
		int[] arr2 = new int[size*2];
		System.arraycopy(arr, 0, arr2, 0, length);
		arr = arr2;
		size *= 2;
	}
	
	static float LoadFactor()
	{
		return (float)elements/size;
	}

	
	static void insert(int key)
	{
		
		if(LoadFactor() >= 0.75)
		    expand();
			
		int index = key%size;
		
		int n = 0;
	
			while(arr[index]!=0)
			{
				index = (key+(n))%size;
				n++;
				
			}
			
			
			arr[index] = key;
			elements++;
			System.out.println(key+" Inserted");
			
	}
	


	public static void main(String[] args) {
		
		insert(7);
		insert(14);
		insert(49);
		insert(19);
		insert(11);
		insert(21);
		insert(28);
		insert(60);

	
	
		for(int i : arr)
			 System.out.print(i+" "); 
		

	}

}
