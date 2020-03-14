package com.cdugga.java8.streams;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.cdugga.java8.lambda.Cryptos;

public class StreamsTest {

	@Test
	public void streamFilterExamples() {
		
		// streams are not data structures
		List<Cryptos> tokens = new ArrayList<Cryptos>();
		tokens.add(new Cryptos("POS", "NEO"));
		tokens.add(new Cryptos("POW", "BITCOIN"));
		tokens.add(new Cryptos("POE", "PO.ET"));
		tokens.add(new Cryptos("POS", "ETHEREUM"));
		tokens.add(new Cryptos("POW", "RIPPLE"));
		tokens.add(new Cryptos("POW", "LITECOIN"));
		tokens.add(new Cryptos("POS", "CARDANO"));
		tokens.add(new Cryptos("POS", "STELLAR"));
		tokens.add(new Cryptos("POW", "DASH"));
		tokens.add(new Cryptos("POS", "NEM"));
		tokens.add(new Cryptos("POW", "TRON"));
		tokens.add(new Cryptos("POW", "TETHER"));
		tokens.add(new Cryptos("Tangle", "IOTA"));
		
		List<String> proofModels = 
				tokens.stream().map(token -> token.getConsensusModel()).map(consensusModel -> consensusModel.toLowerCase())
				.filter(model -> model.startsWith("pow")).collect(Collectors.toList());
		assertTrue(proofModels.size() == 6);
	
		List<Cryptos> excludeNeo = tokens.stream().filter(token -> !token.getCryptoName().equals("NEO")).collect(Collectors.toList());
		assertTrue(excludeNeo.size() == 12 );
	}
	
	@Test
	public void streamfindAnyExamples() {
		// streams are not data structures
		List<Cryptos> tokens = new ArrayList<Cryptos>();
		tokens.add(new Cryptos("POS", "NEO"));
		tokens.add(new Cryptos("POW", "BITCOIN"));
		tokens.add(new Cryptos("POE", "PO.ET"));
		tokens.add(new Cryptos("POW", "TRON"));
		
		Cryptos findingNEO = tokens.stream().filter(x -> "NEO".equals(x.getCryptoName())).findAny().orElse(null);
		assertTrue(null != findingNEO && findingNEO.getCryptoName().equalsIgnoreCase("NEO"));
	
		Cryptos findingBTC = tokens.stream().filter(p -> {
			if(p.getConsensusModel().equalsIgnoreCase("POW")) {
				return true;
			}
			return false;
		}).findAny().orElse(null);
		
		assertTrue(null != findingBTC && findingBTC.getCryptoName().equalsIgnoreCase("bitcoin"));
		
		Cryptos findingfailure = tokens.stream().filter(p -> {
			if(p.getConsensusModel().equalsIgnoreCase("POWe")) {
				return true;
			}
			return false;
		}).findAny().orElse(new Cryptos("test","testcoin"));
	
		assertTrue(null != findingfailure && findingfailure.getCryptoName().equalsIgnoreCase("testcoin"));
	}
	
	@Test
	public void streamfindAnyFailureExamples() {
		List<Cryptos> tokens = new ArrayList<Cryptos>();
		
		Cryptos findingfailure = tokens.stream().filter(p -> {
			if(p.getConsensusModel().equalsIgnoreCase("POWe")) {
				return true;
			}
			return false;
		}).findAny().orElse(new Cryptos("test","testcoin"));
	
		assertTrue(null != findingfailure && findingfailure.getCryptoName().equalsIgnoreCase("testcoin"));	
	}

	@Test
	public void streamfindFirstExamples() {
		// streams are not data structures
		List<Cryptos> tokens = new ArrayList<Cryptos>();
		tokens.add(new Cryptos("POS", "NEO"));
		tokens.add(new Cryptos("POW", "BITCOIN"));
		tokens.add(new Cryptos("POE", "PO.ET"));
		tokens.add(new Cryptos("POW", "TRON"));
		
		Cryptos findingBTC = tokens.stream().filter(p -> {
			if(p.getConsensusModel().equalsIgnoreCase("POW")) {
				return true;
			}
			return false;
		}).findFirst().orElse(null);
		
		assertTrue(null != findingBTC && findingBTC.getCryptoName().equalsIgnoreCase("bitcoin"));
	}
	
}
