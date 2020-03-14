package com.cdugga.java9.staticmethods;
/**
 * 
 * @author cdugga
 *
 */
public class NEOConverter implements CryptoConverter{

	static final double NE0_TO_BITCOIN_SATOSHI_VALUATION = 0.012135;
	
	static final double NE0_TO_USD_VALUATION = 116.00;
	
	@Override
	public double usdValue(double currencyHolding) {
		return NE0_TO_USD_VALUATION * currencyHolding;
	}

	@Override
	public double btcValue(double currencyHolding) {
		return NE0_TO_BITCOIN_SATOSHI_VALUATION * currencyHolding;
	}

}
