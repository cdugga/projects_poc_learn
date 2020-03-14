package com.cdugga.java9.staticmethods;

/**
 * Provides Utility methods for converting crypto currencies to FIAT valuations 
 * @author cdugga
 *
 */
public interface CryptoConverter {
	
	static final double USD_BITCOIN_VALUATION = 0.00010; 
	
	static CryptoConverter getInstance(final String argCurrency) {
		
		if(argCurrency.equalsIgnoreCase("NEO")) {
			return new NEOConverter();
		}else if(argCurrency.equalsIgnoreCase("ETH")) {
			return new EthereumConverter();
		}
		else {
			return new NANOConverter();
		}
	}
	
	/** provide default conversion rate for implementing classes */
	default void printValuations(double usdValue, double btcValue, String argStringCurrency) {
		System.out.println("Bitcoin valudation of " + argStringCurrency + " holding: " +  btcValue + " BTC");
		System.out.println("USD valudation of " + argStringCurrency + " holding: " +  usdValue + " USD");
	}

	double usdValue(double currencyHolding);
	
	double btcValue(double currencyHolding);
	
}
