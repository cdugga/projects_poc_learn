package com.cdugga.java8.functionalinterfaces;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author cdugga
 *
 */
public class FunctionalUtils {

	public String add(String string,  Function<String, String> fn) {
	    return fn.apply(string);
	}
	
	public List<Integer> addCryptoToken(List<Integer> holdings) {
	    List<Integer> plusOne = new LinkedList<>();
	    for(Integer holding : holdings) {
	        plusOne.add(holding + 1);
	    }
	    return plusOne;
	}
	
	public List<Integer> removeCryptoTokenUsingFunctionAPI(List<Integer> holdings) {
	    return holdings
	            .stream()
	            .map(holding -> holding - 1)
	            .collect(Collectors.toList());
	}
	
}
