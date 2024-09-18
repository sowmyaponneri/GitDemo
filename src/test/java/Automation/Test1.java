package Automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void TestOne()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Anu");
		names.add("Deepa");
		names.add("Arvind");
		names.add("Roshan");
		names.add("Anand");
		
		names.add("Anand1");
		names.add("Anand2");
		names.add("Anand3");
		names.add("Anand4");
		names.add("Anand5");
		
		long count=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("Count the names starts with letter A : "+count);
	}
	@Test
	public void TestTwo()
	{
		long count1=Stream.of("Anna","Anne","Arivy","Benette","Anni").filter(s->
		s.startsWith("A")).count();
		System.out.println("Creating Stream using Stream.of : "+count1);
	}
	
	@Test
	public void TestThree()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Anu");
		names.add("Deepa");
		names.add("Arvind");
		names.add("Roshan");
		names.add("Anand");
		System.out.println("Filter then perform some action using Map");
		//print all the names in arraylist - name length >4
				names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
				//print the first result after filtering the names length > 4
				names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
				//print name which as last letter "a" in uppercase
				names.stream().filter(s->s.endsWith("a"))
				              .map(s->s.toUpperCase()).forEach(s->System.out.println(s));
				//print names which have first letter as a with uppercase and sorted
				names.stream().filter(s->s.startsWith("A"))
				              .sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	@Test
	public void mergeStreams()
	{
		List<String> names=Arrays.asList("Abi","Anu","Bala","Mala","Dev");
		List<String> names1=Arrays.asList("Abi","Anand","Kala","latha","Devi");
		//Merging two diff lists
				Stream<String> mergedStream=Stream.concat(names.stream(), names1.stream());
				System.out.println("Merge Stream");
				mergedStream.sorted().forEach(s->System.out.println(s));
				
	}
	@Test
	public void findMatch()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Anu");
		names.add("Deepa");
		names.add("Arvind");
		names.add("Roshan");
		//filter returns subset of required list based on filter condition
		//anyMatch returns boolean value true or false based on match condition
		boolean flag=names.stream().anyMatch(s->s.equalsIgnoreCase("anu"));
		Assert.assertTrue(flag);
	}
	@Test
	public void streamCollect()
	{
		List<String> ls=Stream.of("Anna","Anne","Arivy","Benette","Anni").filter(s->
		s.startsWith("A")).collect(Collectors.toList());
		System.out.println(ls.get(0));
	}
	//print unique number from this array [3,2,2,4,7,9,1,5,5,7]
	
	@Test
	public void findUnique()
	{
		List<Integer> values=Arrays.asList(3,2,2,4,7,9,1,5,5,7);
		//print unique numbers
		System.out.println("Unique Numbers");
		values.stream().distinct().forEach(s->System.out.println(s));
		//sort the array , get the 3rd index value
		List<Integer> sortedList=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("Sorted Array");
		sortedList.stream().forEach(s->System.out.println(s));
		System.out.println("Sort Array and get the 3rd index");
		System.out.println(sortedList.get(2));
	}
}
