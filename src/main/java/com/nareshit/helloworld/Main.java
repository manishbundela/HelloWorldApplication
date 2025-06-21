package com.nareshit.helloworld;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
 public static void main(String[] args) {
     System.out.println("Try programiz.pro");
     List<Integer> list=Arrays.asList(4,1,2,1,2);

     Map<Integer,Long> mapobj=list.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
     System.out.println(mapobj);
     Integer no=mapobj.entrySet().stream().filter(e->e.getValue()==1L).map(k->k.getKey()).findFirst().get();
     System.out.println(no);
 }
}
