package hashMap;

import java.util.HashMap;
import java.util.*;

class Pair
{
	int a;
	int b;
	Pair(int a,int b)
	{
		this.a = a;
		this.b = b;
	}
}

public class Methods {
	
	static void removeDuplicates(String s)
	{
		Map <Character,Integer> hm = new HashMap<>();
		String str = null;
		for(int i=0 ; i<s.length() ; i++)
		{
			if(hm.containsKey(s.charAt(i))==true)
				continue;
			
//			s = s.substring(0,i) + s.substring(i+1,s.length());
			str = str + s.charAt(i);
			hm.put(s.charAt(i), i);
		
		}
		
	  	
		System.out.println(str);
	}
	
	static boolean checkIfSame(int[] arr1 ,int[] arr2)
	{
		if(arr1.length != arr2.length) 
		{
			return false;
		}
		HashMap<Integer,Integer> hm1 = new HashMap<>();
		HashMap<Integer,Integer> hm2 = new HashMap<>();
		
		
		for(int i=0 ; i<arr1.length ; i++)
		{
			if(hm1.containsKey(arr1[i]) == true)
				hm1.put(arr1[i], hm1.get(arr1[i]) + 1);
			
			if(hm2.containsKey(arr2[i]) == true)
				hm2.put(arr2[i], hm2.get(arr2[i]) + 1);
			
			if(hm1.containsKey(arr1[i]) == false)
				hm1.put(arr1[i], 1);

			if(hm2.containsKey(arr2[i]) == false)
				hm2.put(arr2[i],1);
				
		}
		
		for(int i=0 ; i<arr1.length ; i++)
		{
			if(hm1.get(arr1[i]) != hm2.get(arr1[i]))
				return false;
		}
		
		System.out.println(hm1);
		System.out.println(hm2);
		
		return true;
		
		
	}

	public static void main(String[] args) {
	    
		
// ------------------------------------------
		
//		
//		m.put("Divyansh", 40);
//		m.put("hasd", 2);
//		m.put("hasfd", 3);
//		m.put("devs", 45);
//		m.put("fgh", 34);
//		
//		for(Map.Entry<String,Integer> e : m.entrySet())  //to print hasmap
//		{
//			System.out.println(e.getKey()+" "+e.getValue());
//		}
//		
//		m.putIfAbsent("has", 20);
//		
//		for(Map.Entry<String,Integer> e : m.entrySet())  //to print hasmap
//		{
//			System.out.println(e.getKey()+" "+e.getValue());
//		}
//		
		Scanner sc = new Scanner(System.in);
//		String s = sc.next();
//		removeDuplicates(s);
		
//    -------------------------------------------------------------------------------
		
//		int[] arr1 = {2,5,6,8,10,2,2};
//		int[] arr2 = {2,5,2,8,10,2,6};
//		
//		System.out.println(checkIfSame(arr1,arr2));
		
// ------------------------------------------------------------------------------------
		
		
		int no = sc.nextInt();
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		ArrayList<Pair> arr = new ArrayList<>();
		
		for(int i=0 ; i<no ; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			hm.put(a, b);
			
			if(hm.containsValue(a) == true && hm.containsKey(b) == true && hm.get(b) == a)
			{
				arr.add(new Pair(a,b));
			}
		
		}
		
	
//		Iterator itr = arr.iterator();
//		
//		while(itr.hasNext())
//		{
//			System.out.println(itr.next());
//		} 
		
        for(Pair p : arr)
        	System.out.println(p.a + " " + p.b);

	}

}
