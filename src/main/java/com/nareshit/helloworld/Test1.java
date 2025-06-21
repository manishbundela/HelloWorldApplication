package com.nareshit.helloworld;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1{
public static void main(String[] args) {
	String str="abcabcbbabcds";	
	
	Stream<Character> stream=str.chars().mapToObj(c->Character.toLowerCase(Character.valueOf((char)c)));
	List<Character> list=stream.collect(Collectors.toList());	
	//String s=list.stream().filter(x->Collections.frequency(list, x)>=1).distinct().map(String::valueOf).collect(Collectors.joining()); //remove duplicate and Print uniqe
	//String s=list.stream().filter(x->Collections.frequency(list, x)==1).distinct().map(String::valueOf).collect(Collectors.joining()); // find uniqe
	//String s=list.stream().filter(x->Collections.frequency(list, x)>=2).distinct().map(String::valueOf).collect(Collectors.joining()); // find duplicate
	
	//String s=list.stream().filter(x->Collections.frequency(list, x)>=2).distinct().map(String::valueOf).findFirst().get(); //find first duplicate char  
	//String s=list.stream().filter(x->Collections.frequency(list, x)>=2).distinct().map(String::valueOf).limit(1).collect(Collectors.joining()); //find first duplicate char 
	//String s=list.stream().filter(x->Collections.frequency(list, x)==1).distinct().map(String::valueOf).limit(1).collect(Collectors.joining()); //find first non duplicate char	
	
	String s=list.stream().filter(x->Collections.frequency(list, x)==1).distinct().map(String::valueOf).limit(1).collect(Collectors.joining()); //find first non duplicate char
	
	System.out.println(s.concat(":"+s.length())); //abcd:4
	
 }	
}
