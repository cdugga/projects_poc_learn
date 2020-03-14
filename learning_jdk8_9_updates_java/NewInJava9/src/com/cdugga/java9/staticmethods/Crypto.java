package com.cdugga.java9.staticmethods;
/**
 * 
 * @author cdugga
 *
 */
public class Crypto {

	public static void main(String [] args) {
		CryptoConverter neoConverter  = CryptoConverter.getInstance("NEO");
		neoConverter.printValuations(neoConverter.usdValue(100),neoConverter.btcValue(100),"BTC");
		
		CryptoConverter ethConverter  = CryptoConverter.getInstance("ETH");
		neoConverter.printValuations(ethConverter.usdValue(100),ethConverter.btcValue(100),"BTC");
	}
	
}
