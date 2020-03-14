package com.cdugga.java8.lambda.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.cdugga.java8.lambda.MessageWriter;

public class LambdaTests {

	@Test
	public void messageWriterLambda() {
		
		MessageWriter writer = (String s) -> "Greetings " + s;
		assertTrue(writer.messageWriter("Colin").equalsIgnoreCase("Greetings Colin"));
		
		MessageWriter writer2 = (String s) -> "Buenas nochas " + s;
		assertTrue(writer2.messageWriter("Colin").equalsIgnoreCase("Buenas nochas Colin"));
		
	}
	
	@Test 
	public void collectionsLambdaTest() {
		
		List<String> personList = Arrays.asList("Colin", "John", "Brian", "Damien", "Eamon", "Jarlath");
		//sort list ASC using an anonymous inner class for comparator 
		Collections.sort(personList, (String p1, String p2) -> p1.compareTo(p2));
		
		assertTrue(personList.get(0).equalsIgnoreCase("Brian"));
		assertTrue(personList.get(personList.size()-1).equalsIgnoreCase("John"));
	}
	
}
