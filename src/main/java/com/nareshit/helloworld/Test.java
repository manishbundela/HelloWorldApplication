package com.nareshit.helloworld;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SortBasedLength implements Comparator<String>{
	public int length;
	public SortBasedLength() {}
	public SortBasedLength(String str) {
		super();
		this.length=str.length();
	}

	@Override
	public int compare(String o1, String o2) {
		
		return Math.abs(o1.length()-length)-Math.abs(o2.length()-length);
	}
		
}

class Sort{
	private void sortStringBasedLength() {
		List<SortBasedLength> listObj=new ArrayList<SortBasedLength>();
		listObj.add(new SortBasedLength("Manish"));
		listObj.add(new SortBasedLength("Visal"));
		listObj.add(new SortBasedLength("Neha"));
		SortBasedLength so=new SortBasedLength();
		
		
	}
}

public class Test {
	
	public static void main(String[] args) {
		Map<String,List<Integer>> mapObj=new HashMap();
		mapObj.put("A", Arrays.asList(1,2,3,4,5,6));
		mapObj.put("B", Arrays.asList(7,8,9,2,3,5,6));
		List<Integer> listObj=useFlatMap(mapObj);
		System.out.println("FinalList:: "+listObj);
		WorkWithNumber(listObj);
		printCustomOutput();
		reduseBinaryOpertion();
		ConvertionString();
		
		List<String> strings = Arrays.asList(new String[] {"cucumber","aeronomical","bacon","tea","telescopic","fantasmagorical"});
		strings.sort((s1, s2) -> Math.abs(s1.length() - "intelligent".length()) - Math.abs(s2.length() - "intelligent".length()));
		
		
		
	}

	
	
	
	
	public static List<Integer> useFlatMap(Map<String,List<Integer>> mapObj){
		List<Integer> listObj=mapObj.values().stream().flatMap(Collection::stream).collect(Collectors.toList());	
		return listObj;
	}
	
	public static void WorkWithNumber(List<Integer> listObj){
		//Input:- [1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 5, 6]
		//{1=1, 2=2, 3=2, 4=1, 5=2, 6=2, 7=1, 8=1, 9=1}	
		Map<Integer, Long> duplicateWithCount = listObj.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		
		/*Find Not Duplicate and unique*/
		List<Integer> uniqueNumber=duplicateWithCount.entrySet().stream().filter(x->x.getValue()==1).map(x->x.getKey()).collect(Collectors.toList());
		System.out.println(uniqueNumber); 
		
		/*Find Duplicate and not unique*/
		List<Integer> notuniqueNumber=duplicateWithCount.entrySet().stream().filter(x->x.getValue()>1L).map(x->x.getKey()).collect(Collectors.toList());
		System.out.println(notuniqueNumber);
		
		List<Integer> list3Obj=notuniqueNumber.stream().limit(3).collect(Collectors.toList());
		System.out.println("Find First 3 Number :: "+list3Obj);
		
		Integer findFirst=notuniqueNumber.stream().findFirst().orElse(0);
		Integer findSecound=notuniqueNumber.stream().skip(1).findFirst().orElse(0);
		System.out.println("FirstDuplicateNumber:: "+findFirst+ " SecoundDuplicateNumber:: "+findSecound);
		
		Integer findMaxnumber=notuniqueNumber.stream().sorted((a,b)->b-a).findFirst().orElse(0);
		Integer findSecoundmaxnumber=notuniqueNumber.stream().sorted((a,b)->b-a).skip(1).findFirst().orElse(0);
		System.out.println("MaxDuplicateNumber:: "+findMaxnumber+ " SecoundMaxDuplicateNumber:: "+findSecoundmaxnumber);
		
		Integer findMinNumber=notuniqueNumber.stream().sorted().findFirst().orElse(0);
		Integer findSecoundMinNumber=notuniqueNumber.stream().sorted().skip(1).findFirst().orElse(0);
		System.out.println("MinDuplicateNumber:: "+findMinNumber+ " SecoundMinDuplicateNumber:: "+findSecoundMinNumber);
		
		IntSummaryStatistics number=uniqueNumber.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println("Find Uniqe Number :Count: "+number.getCount()+" :Sum: "+number.getSum()+" :Max: "+number.getMax()+" :Min: "+number.getMin()+" ::Average: "+number.getAverage());
		
	}
	
	
	public static void reduseBinaryOpertion() {
		Integer sum=Arrays.asList(1,2,3,4,5).stream().reduce((x,y)->x+y).get();
		System.out.println(sum);
	}
	
	//input : {1,2,0,5,0,4,3,3}
	//output: {1,2,5,4,3,3,0,0}
	public static void printCustomOutput() {
		Integer[] intobj={1,2,0,5,0,4,3,3};
		List<Integer> listObj=Arrays.asList(intobj);
		
		List<Integer> listObj2=listObj.stream().filter(x->!x.equals(0)).distinct().collect(Collectors.toList()); //remove duplicate also
		List<Integer> listObj3=listObj.stream().filter(x->x.equals(0)).collect(Collectors.toList());
		
		Map<String,List<Integer>> mapObj=new HashMap<String, List<Integer>>();
		mapObj.put("A", listObj2);
		mapObj.put("B", listObj3);
		List<Integer> obj=mapObj.values().stream().flatMap(Collection::stream).collect(Collectors.toList());		
		System.out.println(obj); //output: {1,2,5,4,3,3,0,0}
		getStringWithLength();
		
		
	}
	
	
    public static void getStringWithLength() {
    	String[] str= {"Java","Payton","Dot Net"}; //Input
    	//output:- {java-4,Payton-6,Dot Net-7}
    	
		/*
		 * List<String> listObj=Arrays.asList(str); List<String> listObj1=new
		 * ArrayList<String>(); Iterator<String> it=listObj.iterator(); while
		 * (it.hasNext()) { String string = (String) it.next(); String
		 * lenSt=String.valueOf(string.length());
		 * listObj1.add(string.concat("-"+lenSt)); } System.out.println(listObj1);
		 */
    	
    	Stream<String> stm =Stream.of(str); //Conevrt String to Stream
    	List<String> stringWithLenth= stm.map(x->x.concat("-"+String.valueOf(x.length()))).collect(Collectors.toList());
    	System.out.println(stringWithLenth);
    	
    }  
	
    public static void ConvertionString() {
    	
    	
    	String str="this Company Best";    	
    	//convert String to Char
    	str=str.replace(" ","").toLowerCase();
    	List<Character> chlist=str.chars().mapToObj(c->(char)c).collect(Collectors.toList());
    	System.out.println(chlist);
    	
    	List<Character> chlist1=str.chars().mapToObj(c->(char)c).collect(Collectors.toList());
    	System.out.println(chlist1);
    	
    	int[] val= {1,2,3,4,5};
    	
    	//Arrays.asList(val).stream().mapToDouble(x->Double.valueOf(x));
	}
	
}
