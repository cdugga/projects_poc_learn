package com.cdugga.java8.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CryptoAnalysisLambda {

	public void proofOfWorkBlockchains(List<Cryptos> cryptos, Predicate<Cryptos> pred) {
		for(Cryptos crypto: cryptos) {
			if(pred.test(crypto)) {
				printProofOfWorkCryptos(crypto.getCryptoName());
			}
		}
	}
		
	public void proofOfStakeBlockchains(List<Cryptos> cryptos, Predicate<Cryptos> pred) {
		for(Cryptos crypto: cryptos) {
			if(pred.test(crypto)) {
				printProofOfStakeCryptos(crypto.getCryptoName());
			}
		}
	}
	
	public void proofOfExistenceBlockchains(List<Cryptos> cryptos, Predicate<Cryptos> pred) {
		for(Cryptos crypto: cryptos) {
			if(pred.test(crypto)) {
				printProofOfExistenceCryptos(crypto.getCryptoName());
			}
		}
	}

	public void proofOfWorkBlockchainsFunctorExample(List<Cryptos> cryptos, Function<Cryptos, String> pred) {
		for(Cryptos crypto: cryptos) {
			System.out.println("Using Function API: " + pred.apply(crypto));
		}
	}
	
	private void printProofOfWorkCryptos(final String argToken) {
		System.out.println(argToken + " is Proof Of Work token");
	}
	
	private void printProofOfStakeCryptos(final String argToken) {
		System.out.println(argToken + " is Proof Of Stake token");
	}
	
	private void printProofOfExistenceCryptos(final String argToken) {
		System.out.println(argToken + " is Proof Of Existence token");
	}
	
}
