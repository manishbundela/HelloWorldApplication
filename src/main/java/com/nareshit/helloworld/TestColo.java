package com.nareshit.helloworld;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestColo {

	public static void main(String[] args) {
		Integer a[] = {5,0,8,4,2,3,0,11,47};
		//How do you move all zeros to the end of an array?
		//System.out.print(Arrays.sort(a));
		
		//{1,5,2,5,2,5,28,9,3,6,7,2}
		//find the duplicate elements using java 8
		
		Integer a1[] =new Integer[a.length]; 
		for(int i=0;i<a.length;i++) { //i=0,1,2
			for(int j=i+1;j<a.length;j++) {
			   if(a[i].equals(a[j])) {
				//   a[i];
			   }	
			}			
		}
		
		Integer[] obj={1,5,2,5,2,5,28,9,3,6,7,2};
		
		Map<Integer,Long> obj1=Arrays.asList(obj).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())); // insertOrder
		
		List<Integer> ob=obj1.entrySet().stream().filter(x->x.getValue()>1L).map(x->x.getKey()).collect(Collectors.toList());
		System.out.println(ob);
		
		
		
		/*Expected Output:
			  [
			    "David (4)",
			    "Alice (3)",
			    "Bob (3)",
			    "Charlie (2)"
			  ]*/
		
		List<String> st=Arrays.asList("Alice","Bob", "David", "Alice", "Alice", "David", "Bob","Charlie", "David", "Charlie", "Bob", "David").
		 stream().sorted(Comparator.comparing(String::length)).
		 collect(Collectors.toList());
		 
		System.out.println(st);
		
	 Map<String,Long> obj2=st.
			 stream().sorted(Comparator.comparing(String::length)).
			 collect(Collectors.groupingBy(Function.identity(),Collectors.counting())); // insertOrder
	 	
	//    obj2.entrySet().s
	 
		System.out.println(obj2);
		/*
		 * 1. find a new list with the frequency of each strings. 2. After that Sort the
		 * list in descending order of frequency. 3. now for the same frequency, sort
		 * them alphabetical order. 4. Return the sorted result as a list of strings,
		 * with each string formatted as: name (count).
		 */
	}
	
}
