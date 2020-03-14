package com.cdugga.java8.lambda.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

import com.cdugga.java8.lambda.CryptoAnalysisLambda;
import com.cdugga.java8.lambda.Cryptos;

public class CryptoAnalysisLambdaTest {

	@Test
	public void testAnalysisLambdaPredicateAPI() {
		
		CryptoAnalysisLambda analyzer = new CryptoAnalysisLambda();
		
		List<Cryptos> tokens = new ArrayList<Cryptos>();
		tokens.add(new Cryptos("POS", "NEO"));
		tokens.add(new Cryptos("POW", "BITCOIN"));
		tokens.add(new Cryptos("POE", "PO.ET"));
		tokens.add(new Cryptos("POS", "ETHEREUM"));
		
		Predicate<Cryptos> proofOfStake = p -> p.getConsensusModel().equalsIgnoreCase("POS");
		Predicate<Cryptos> proofOfWork= p -> p.getConsensusModel().equalsIgnoreCase("POW");
		Predicate<Cryptos> proofOfExistence = p -> p.getConsensusModel().equalsIgnoreCase("POE");
	
		System.out.println("****** Test 1 - Display all POS tokens ::: Predicate API  ****** ");
		analyzer.proofOfStakeBlockchains(tokens, proofOfStake);
		
		System.out.println("****** Test 1 - Display all POW tokens ::: Predicate API  ****** ");
		analyzer.proofOfWorkBlockchains(tokens, proofOfWork);
		
		System.out.println("****** Test 1 - Display all POE tokens ::: Predicate API  ****** ");
		analyzer.proofOfExistenceBlockchains(tokens, proofOfExistence);
		
	}
	
	@Test
	public void testAnalysisLambdafUNCTIONAPI() {
		
		CryptoAnalysisLambda analyzer = new CryptoAnalysisLambda();
		
		List<Cryptos> tokens = new ArrayList<Cryptos>();
		tokens.add(new Cryptos("POS", "NEO"));
		tokens.add(new Cryptos("POW", "BITCOIN"));
		tokens.add(new Cryptos("POE", "PO.ET"));
		tokens.add(new Cryptos("POS", "ETHEREUM"));
		
		Function<Cryptos, String> cryptoNameFunction = (Cryptos c) -> {return c.getConsensusModel();};
		
		
		Function<String, String> consensusModelFunction = (String s) -> {return (s.equalsIgnoreCase("POS")?"Is a POS chain":"Other consensus model");};
		System.out.println("****** Test 1 - Display all POS tokens ::: Function API  ****** ");
		analyzer.proofOfWorkBlockchainsFunctorExample(tokens, cryptoNameFunction.andThen(consensusModelFunction));
	}
	
}
