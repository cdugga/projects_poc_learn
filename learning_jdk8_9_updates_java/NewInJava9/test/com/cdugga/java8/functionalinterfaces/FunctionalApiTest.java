package com.cdugga.java8.functionalinterfaces;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

/**
 * @author cdugga
 */
public class FunctionalApiTest {

	@Test
	public void testLambda() {
		FunctionalUtils useFoo = new FunctionalUtils();
		Function<String, String> fn = message -> message + "from lambda";
		String result = useFoo.add("Message ", fn);
		assertTrue(result.equalsIgnoreCase("Message from lambda"));
	}
	
	@Test
	public void testFunctionAsParam() {
		FunctionalUtils useFoo = new FunctionalUtils();
		List<Integer> holdings = Arrays.asList(100, 70, 24);
		
		assertTrue(useFoo.addCryptoToken(holdings).get(1) == 71);
		assertTrue(useFoo.removeCryptoTokenUsingFunctionAPI(holdings).get(1) == 69);
	}

	
}
